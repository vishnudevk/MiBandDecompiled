// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.auth;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.HttpMethodName;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.util.BinaryUtils;
import com.xiaomi.infra.galaxy.common.util.HttpUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.xiaomi.infra.galaxy.common.auth:
//            AbstractGalaxySigner, GalaxyCredentials, SigningAlgorithm, AnonymousGalaxyCredentials, 
//            AppSecretCredentials, SessionCredentials

public class Galaxy4Signer extends AbstractGalaxySigner
{

    protected static final String ALGORITHM = "Galaxy-HMAC-SHA256";
    protected static final String TERMINATOR = "galaxy_request";
    protected static final Log log = LogFactory.getLog(com/xiaomi/infra/galaxy/common/auth/Galaxy4Signer);
    protected ThreadLocal dateStampFormat;
    protected ThreadLocal dateTimeFormat;
    protected Date overriddenDate;
    protected String serviceName;

    public Galaxy4Signer()
    {
        dateTimeFormat = new _cls1();
        dateStampFormat = new _cls2();
    }

    protected void addHostHeader(BasicGalaxyRequest basicgalaxyrequest)
    {
        String s = basicgalaxyrequest.getEndpoint().getHost();
        if (HttpUtils.isUsingNonDefaultPort(basicgalaxyrequest.getEndpoint()))
        {
            s = (new StringBuilder()).append(s).append(":").append(basicgalaxyrequest.getEndpoint().getPort()).toString();
        }
        basicgalaxyrequest.addHeader("Host", s);
    }

    protected String calculateContentHash(BasicGalaxyRequest basicgalaxyrequest)
    {
        InputStream inputstream = getBinaryRequestPayloadStream(basicgalaxyrequest);
        inputstream.mark(-1);
        String s = BinaryUtils.toHex(hash(inputstream));
        try
        {
            inputstream.reset();
        }
        catch (IOException ioexception)
        {
            throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to reset stream after calculating galaxy signature", ioexception);
        }
        return s;
    }

    protected HeaderSigningResult computeSignature(BasicGalaxyRequest basicgalaxyrequest, Date date, String s, String s1, GalaxyCredentials galaxycredentials)
    {
        String s2 = getDateTimeStamp(date);
        String s3 = getDateStamp(date);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s3).append("/").append("Galaxy").append("/").append("galaxy_request");
        StringBuilder stringbuilder1 = getStringToSign(s, s2, stringbuilder, getCanonicalRequest(basicgalaxyrequest, s1));
        StringBuilder stringbuilder2 = new StringBuilder();
        stringbuilder2.append("Galaxy").append(galaxycredentials.getGalaxySecretKey());
        byte abyte0[] = sign("galaxy_request", sign("Galaxy", sign(s3, stringbuilder2.toString().getBytes(), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256);
        byte abyte1[] = sign(stringbuilder1.toString().getBytes(), abyte0, SigningAlgorithm.HmacSHA256);
        return new HeaderSigningResult(s2, stringbuilder.toString(), abyte0, abyte1);
    }

    protected StringBuilder getCanonicalRequest(BasicGalaxyRequest basicgalaxyrequest, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(basicgalaxyrequest.getHttpMethod().toString()).append("\n").append(getCanonicalizedResourcePath(basicgalaxyrequest.getResourcePath())).append("\n").append(getCanonicalizedQueryString(basicgalaxyrequest)).append("\n").append(getCanonicalizedHeaderString(basicgalaxyrequest)).append("\n").append(getSignedHeadersString(basicgalaxyrequest)).append("\n").append(s);
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Galaxy Canonical Request: '\"").append(stringbuilder).append("\"").toString());
        }
        return stringbuilder;
    }

    protected String getCanonicalizedHeaderString(BasicGalaxyRequest basicgalaxyrequest)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(basicgalaxyrequest.getHeaders().keySet());
        Collections.sort(arraylist, String.CASE_INSENSITIVE_ORDER);
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); stringbuilder.append("\n"))
        {
            String s = (String)iterator.next();
            stringbuilder.append((new StringBuilder()).append(s.toLowerCase().replaceAll("\\s+", " ")).append(":").append(((String)basicgalaxyrequest.getHeaders().get(s)).replaceAll("\\s+", " ")).toString());
        }

        return stringbuilder.toString();
    }

    protected String getDateStamp(Date date)
    {
        return ((SimpleDateFormat)dateStampFormat.get()).format(date);
    }

    protected String getDateTimeStamp(Date date)
    {
        return ((SimpleDateFormat)dateTimeFormat.get()).format(date);
    }

    protected StringBuilder getScope(BasicGalaxyRequest basicgalaxyrequest, Date date)
    {
        String s = getDateStamp(date);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s).append("/").append(serviceName).append("/").append("galaxy_request");
        return stringbuilder;
    }

    protected StringBuilder getSignedHeadersString(BasicGalaxyRequest basicgalaxyrequest)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(basicgalaxyrequest.getHeaders().keySet());
        Collections.sort(arraylist, String.CASE_INSENSITIVE_ORDER);
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); stringbuilder.append(s.toLowerCase()))
        {
            s = (String)iterator.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(";");
            }
        }

        return stringbuilder;
    }

    protected StringBuilder getStringToSign(String s, String s1, CharSequence charsequence, CharSequence charsequence1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s).append("\n").append(s1).append("\n").append(charsequence).append("\n").append(BinaryUtils.toHex(hash(charsequence1.toString())));
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Galaxy String to Sign: '\"").append(stringbuilder).append("\"").toString());
        }
        return stringbuilder;
    }

    void overrideDate(Date date)
    {
        overriddenDate = date;
    }

    protected void processRequestPayload(BasicGalaxyRequest basicgalaxyrequest, HeaderSigningResult headersigningresult)
    {
    }

    public void setServiceName(String s)
    {
        serviceName = s;
    }

    public void sign(BasicGalaxyRequest basicgalaxyrequest, GalaxyCredentials galaxycredentials)
    {
        if (galaxycredentials instanceof AnonymousGalaxyCredentials)
        {
            basicgalaxyrequest.addHeader("X-XiaoMi-Access-Method", "anonymous");
            return;
        }
        if (galaxycredentials instanceof AppSecretCredentials)
        {
            basicgalaxyrequest.addHeader("X-XiaoMi-Access-Method", "appsecrettoken");
            basicgalaxyrequest.addHeader("X-XiaoMi-Token", galaxycredentials.getGalaxySecretKey());
        }
        GalaxyCredentials galaxycredentials1 = sanitizeCredentials(galaxycredentials);
        if (galaxycredentials instanceof SessionCredentials)
        {
            basicgalaxyrequest.addHeader("X-XiaoMi-Token", galaxycredentials.getGalaxySecretKey());
        }
        addHostHeader(basicgalaxyrequest);
        Date date = new Date();
        StringBuilder stringbuilder = getScope(basicgalaxyrequest, date);
        String s = calculateContentHash(basicgalaxyrequest);
        basicgalaxyrequest.addHeader("X-XiaoMi-Date", getDateTimeStamp(date));
        if (basicgalaxyrequest.getHeaders().get("X-XiaoMi-Content-Sha256") != null && ((String)basicgalaxyrequest.getHeaders().get("X-XiaoMi-Content-Sha256")).equals("required"))
        {
            basicgalaxyrequest.addHeader("X-XiaoMi-Content-Sha256", s);
        }
        basicgalaxyrequest.addHeader("X-XiaoMi-Content-Sha256", s);
        StringBuilder stringbuilder1 = new StringBuilder();
        stringbuilder1.append(galaxycredentials1.getGalaxyAppId()).append("/").append(stringbuilder);
        HeaderSigningResult headersigningresult = computeSignature(basicgalaxyrequest, date, "Galaxy-HMAC-SHA256", s, galaxycredentials1);
        StringBuilder stringbuilder2 = new StringBuilder();
        stringbuilder2.append("Credential=").append(stringbuilder1);
        StringBuilder stringbuilder3 = new StringBuilder();
        stringbuilder3.append("SignedHeaders=").append(getSignedHeadersString(basicgalaxyrequest));
        StringBuilder stringbuilder4 = new StringBuilder();
        stringbuilder4.append("Signature=").append(BinaryUtils.toHex(headersigningresult.getSignature()));
        StringBuilder stringbuilder5 = new StringBuilder();
        stringbuilder5.append("Galaxy-HMAC-SHA256").append(" ").append(stringbuilder2).append(", ").append(stringbuilder3).append(", ").append(stringbuilder4);
        basicgalaxyrequest.addHeader("Authorization", stringbuilder5.toString());
        processRequestPayload(basicgalaxyrequest, headersigningresult);
    }


    private class _cls1 extends ThreadLocal
    {

        final Galaxy4Signer this$0;

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected SimpleDateFormat initialValue()
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
            simpledateformat.setTimeZone(new SimpleTimeZone(0, "UTC"));
            return simpledateformat;
        }

        _cls1()
        {
            this$0 = Galaxy4Signer.this;
            super();
        }
    }


    private class _cls2 extends ThreadLocal
    {

        final Galaxy4Signer this$0;

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected SimpleDateFormat initialValue()
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd");
            simpledateformat.setTimeZone(new SimpleTimeZone(0, "UTC"));
            return simpledateformat;
        }

        _cls2()
        {
            this$0 = Galaxy4Signer.this;
            super();
        }
    }


    private class HeaderSigningResult
    {

        private String dateTime;
        private byte kSigning[];
        private String scope;
        private byte signature[];
        final Galaxy4Signer this$0;

        public String getDateTime()
        {
            return dateTime;
        }

        public byte[] getKSigning()
        {
            byte abyte0[] = new byte[kSigning.length];
            System.arraycopy(kSigning, 0, abyte0, 0, kSigning.length);
            return abyte0;
        }

        public String getScope()
        {
            return scope;
        }

        public byte[] getSignature()
        {
            byte abyte0[] = new byte[signature.length];
            System.arraycopy(signature, 0, abyte0, 0, signature.length);
            return abyte0;
        }

        public HeaderSigningResult(String s, String s1, byte abyte0[], byte abyte1[])
        {
            this$0 = Galaxy4Signer.this;
            super();
            dateTime = s;
            scope = s1;
            kSigning = abyte0;
            signature = abyte1;
        }
    }

}
