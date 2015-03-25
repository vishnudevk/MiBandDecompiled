// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.auth;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.util.Base64Utils;
import com.xiaomi.infra.galaxy.common.util.HttpUtils;
import com.xiaomi.infra.galaxy.common.util.StringInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.xiaomi.infra.galaxy.common.auth:
//            Signer, GalaxyCredentials, BasicGalaxyCredentials, SigningAlgorithm

public abstract class AbstractGalaxySigner
    implements Signer
{

    protected static final String DEFAULT_ENCODING = "UTF-8";

    public AbstractGalaxySigner()
    {
    }

    protected byte[] getBinaryRequestPayload(BasicGalaxyRequest basicgalaxyrequest)
    {
        if (HttpUtils.usePayloadForQueryParameters(basicgalaxyrequest))
        {
            String s = HttpUtils.encodeParameters(basicgalaxyrequest);
            if (s == null)
            {
                return new byte[0];
            }
            byte abyte0[];
            try
            {
                abyte0 = s.getBytes("UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to encode string into bytes");
            }
            return abyte0;
        } else
        {
            return getBinaryRequestPayloadWithoutQueryParams(basicgalaxyrequest);
        }
    }

    protected InputStream getBinaryRequestPayloadStream(BasicGalaxyRequest basicgalaxyrequest)
    {
        if (HttpUtils.usePayloadForQueryParameters(basicgalaxyrequest))
        {
            String s = HttpUtils.encodeParameters(basicgalaxyrequest);
            if (s == null)
            {
                return new ByteArrayInputStream(new byte[0]);
            }
            ByteArrayInputStream bytearrayinputstream;
            try
            {
                bytearrayinputstream = new ByteArrayInputStream(s.getBytes("UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to encode string into bytes");
            }
            return bytearrayinputstream;
        } else
        {
            return getBinaryRequestPayloadStreamWithoutQueryParams(basicgalaxyrequest);
        }
    }

    protected InputStream getBinaryRequestPayloadStreamWithoutQueryParams(BasicGalaxyRequest basicgalaxyrequest)
    {
        InputStream inputstream;
        try
        {
            inputstream = basicgalaxyrequest.getContent();
        }
        catch (Exception exception)
        {
            throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, (new StringBuilder()).append("Unable to read request payload to sign request: ").append(exception.getMessage()).toString(), exception);
        }
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        return new ByteArrayInputStream(new byte[0]);
        if (inputstream instanceof StringInputStream)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (!inputstream.markSupported())
        {
            throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to read request payload to sign request.");
        }
        InputStream inputstream1 = basicgalaxyrequest.getContent();
        inputstream = inputstream1;
        return inputstream;
    }

    protected byte[] getBinaryRequestPayloadWithoutQueryParams(BasicGalaxyRequest basicgalaxyrequest)
    {
        InputStream inputstream = getBinaryRequestPayloadStreamWithoutQueryParams(basicgalaxyrequest);
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        inputstream.mark(-1);
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = new byte[5120];
_L1:
        int i = inputstream.read(abyte0);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        bytearrayoutputstream.close();
        inputstream.reset();
        return bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.write(abyte0, 0, i);
          goto _L1
        Exception exception;
        exception;
        throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, (new StringBuilder()).append("Unable to read request payload to sign request: ").append(exception.getMessage()).toString(), exception);
    }

    protected String getCanonicalizedEndpoint(URI uri)
    {
        String s = uri.getHost().toLowerCase();
        if (HttpUtils.isUsingNonDefaultPort(uri))
        {
            s = (new StringBuilder()).append(s).append(":").append(uri.getPort()).toString();
        }
        return s;
    }

    protected String getCanonicalizedQueryString(BasicGalaxyRequest basicgalaxyrequest)
    {
        if (HttpUtils.usePayloadForQueryParameters(basicgalaxyrequest))
        {
            return "";
        } else
        {
            return getCanonicalizedQueryString(basicgalaxyrequest.getParameters());
        }
    }

    protected String getCanonicalizedQueryString(Map map)
    {
        TreeMap treemap = new TreeMap();
        String s;
        String s1;
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); treemap.put(HttpUtils.urlEncode(s, false), HttpUtils.urlEncode(s1, false)))
        {
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator.next();
            s = (String)entry1.getKey();
            s1 = (String)entry1.getValue();
        }

        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator1 = treemap.entrySet().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
            stringbuilder.append((String)entry.getKey());
            stringbuilder.append("=");
            stringbuilder.append((String)entry.getValue());
            if (iterator1.hasNext())
            {
                stringbuilder.append("&");
            }
        } while (true);
        return stringbuilder.toString();
    }

    protected String getCanonicalizedResourcePath(String s)
    {
        String s1;
        if (s == null || s.length() == 0)
        {
            s1 = "/";
        } else
        {
            s1 = HttpUtils.urlEncode(s, true);
            if (!s1.startsWith("/"))
            {
                return "/".concat(s1);
            }
        }
        return s1;
    }

    protected String getRequestPayload(BasicGalaxyRequest basicgalaxyrequest)
    {
        return newString(getBinaryRequestPayload(basicgalaxyrequest));
    }

    protected String getRequestPayloadWithoutQueryParams(BasicGalaxyRequest basicgalaxyrequest)
    {
        return newString(getBinaryRequestPayloadWithoutQueryParams(basicgalaxyrequest));
    }

    protected byte[] hash(InputStream inputstream)
    {
        byte abyte1[];
        try
        {
            DigestInputStream digestinputstream = new DigestInputStream(inputstream, MessageDigest.getInstance("SHA-256"));
            for (byte abyte0[] = new byte[1024]; digestinputstream.read(abyte0) > -1;) { }
            abyte1 = digestinputstream.getMessageDigest().digest();
        }
        catch (Exception exception)
        {
            throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, (new StringBuilder()).append("Unable to compute hash while signing request: ").append(exception.getMessage()).toString(), exception);
        }
        return abyte1;
    }

    public byte[] hash(String s)
    {
        byte abyte0[];
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
            messagedigest.update(s.getBytes("UTF-8"));
            abyte0 = messagedigest.digest();
        }
        catch (Exception exception)
        {
            throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, (new StringBuilder()).append("Unable to compute hash while signing request: ").append(exception.getMessage()).toString(), exception);
        }
        return abyte0;
    }

    public byte[] hash(byte abyte0[])
    {
        byte abyte1[];
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
            messagedigest.update(abyte0);
            abyte1 = messagedigest.digest();
        }
        catch (Exception exception)
        {
            throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, (new StringBuilder()).append("Unable to compute hash while signing request: ").append(exception.getMessage()).toString(), exception);
        }
        return abyte1;
    }

    protected String newString(byte abyte0[])
    {
        String s;
        try
        {
            s = new String(abyte0, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to encode bytes to String", unsupportedencodingexception);
        }
        return s;
    }

    protected GalaxyCredentials sanitizeCredentials(GalaxyCredentials galaxycredentials)
    {
        galaxycredentials;
        JVM INSTR monitorenter ;
        String s;
        String s1;
        s = galaxycredentials.getGalaxyAppId();
        s1 = galaxycredentials.getGalaxySecretKey();
        galaxycredentials;
        JVM INSTR monitorexit ;
        if (s1 != null)
        {
            s1 = s1.trim();
        }
        if (s != null)
        {
            s = s.trim();
        }
        return new BasicGalaxyCredentials(s, s1);
        Exception exception;
        exception;
        galaxycredentials;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public byte[] sign(String s, byte abyte0[], SigningAlgorithm signingalgorithm)
    {
        byte abyte1[];
        try
        {
            abyte1 = sign(s.getBytes("UTF-8"), abyte0, signingalgorithm);
        }
        catch (Exception exception)
        {
            throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, (new StringBuilder()).append("Unable to calculate a request signature: ").append(exception.getMessage()).toString(), exception);
        }
        return abyte1;
    }

    protected byte[] sign(byte abyte0[], byte abyte1[], SigningAlgorithm signingalgorithm)
    {
        byte abyte2[];
        try
        {
            Mac mac = Mac.getInstance(signingalgorithm.toString());
            mac.init(new SecretKeySpec(abyte1, signingalgorithm.toString()));
            abyte2 = mac.doFinal(abyte0);
        }
        catch (Exception exception)
        {
            throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, (new StringBuilder()).append("Unable to calculate a request signature: ").append(exception.getMessage()).toString(), exception);
        }
        return abyte2;
    }

    protected String signAndBase64Encode(String s, String s1, SigningAlgorithm signingalgorithm)
    {
        String s2;
        try
        {
            s2 = signAndBase64Encode(s.getBytes("UTF-8"), s1, signingalgorithm);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, (new StringBuilder()).append("Unable to calculate a request signature: ").append(unsupportedencodingexception.getMessage()).toString(), unsupportedencodingexception);
        }
        return s2;
    }

    protected String signAndBase64Encode(byte abyte0[], String s, SigningAlgorithm signingalgorithm)
    {
        String s1;
        try
        {
            s1 = new String(Base64Utils.encode(sign(abyte0, s.getBytes("UTF-8"), signingalgorithm)));
        }
        catch (Exception exception)
        {
            throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, (new StringBuilder()).append("Unable to calculate a request signature: ").append(exception.getMessage()).toString(), exception);
        }
        return s1;
    }
}
