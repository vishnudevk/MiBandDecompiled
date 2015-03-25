// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.HttpMethodName;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.util.HttpUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.xiaomi.infra.galaxy.common.http:
//            ExecutionContext, ClientConfiguration, RepeatableInputStreamRequestEntity

class HttpRequestFactory
{

    private static final String DEFAULT_ENCODING = "UTF-8";
    public static final Log log = LogFactory.getLog(com/xiaomi/infra/galaxy/common/http/HttpRequestFactory);

    HttpRequestFactory()
    {
    }

    private void configureHeaders(HttpRequestBase httprequestbase, BasicGalaxyRequest basicgalaxyrequest, ExecutionContext executioncontext, ClientConfiguration clientconfiguration)
    {
        URI uri = basicgalaxyrequest.getEndpoint();
        String s = uri.getHost();
        if (HttpUtils.isUsingNonDefaultPort(uri))
        {
            s = (new StringBuilder()).append(s).append(":").append(uri.getPort()).toString();
        }
        httprequestbase.addHeader("Host", s);
        Iterator iterator = basicgalaxyrequest.getHeaders().entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (!((String)entry.getKey()).equalsIgnoreCase("Content-Length") && !((String)entry.getKey()).equalsIgnoreCase("Host"))
            {
                httprequestbase.addHeader((String)entry.getKey(), (String)entry.getValue());
            }
        } while (true);
        if (httprequestbase.getHeaders("Content-Type") == null || httprequestbase.getHeaders("Content-Type").length == 0)
        {
            httprequestbase.addHeader("Content-Type", (new StringBuilder()).append("application/x-www-form-urlencoded; charset=").append("UTF-8".toLowerCase()).toString());
        }
        if (executioncontext != null && executioncontext.getContextUserAgent() != null)
        {
            httprequestbase.addHeader("User-Agent", createUserAgentString(clientconfiguration, executioncontext.getContextUserAgent()));
        }
    }

    private String createUserAgentString(ClientConfiguration clientconfiguration, String s)
    {
        if (clientconfiguration.getUserAgent().contains(s))
        {
            return clientconfiguration.getUserAgent();
        } else
        {
            return (new StringBuilder()).append(clientconfiguration.getUserAgent()).append(" ").append(s).toString();
        }
    }

    private HttpEntity newBufferedHttpEntity(HttpEntity httpentity)
    {
        BufferedHttpEntity bufferedhttpentity;
        try
        {
            bufferedhttpentity = new BufferedHttpEntity(httpentity);
        }
        catch (IOException ioexception)
        {
            log.error(ioexception);
            throw new GalaxyClientException(ReturnCode.HTTP_ERROR, (new StringBuilder()).append("Unable to create HTTP entity: ").append(ioexception.getMessage()).toString(), ioexception);
        }
        return bufferedhttpentity;
    }

    private HttpEntity newStringEntity(String s)
    {
        StringEntity stringentity;
        try
        {
            stringentity = new StringEntity(s);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            log.error(unsupportedencodingexception);
            throw new GalaxyClientException(ReturnCode.HTTP_ERROR, (new StringBuilder()).append("Unable to create HTTP entity: ").append(unsupportedencodingexception.getMessage()).toString(), unsupportedencodingexception);
        }
        return stringentity;
    }

    HttpRequestBase createHttpRequest(BasicGalaxyRequest basicgalaxyrequest, ClientConfiguration clientconfiguration, HttpEntity httpentity, ExecutionContext executioncontext)
    {
        String s = basicgalaxyrequest.getEndpoint().toString();
        if (basicgalaxyrequest.getResourcePath() == null || basicgalaxyrequest.getResourcePath().length() <= 0) goto _L2; else goto _L1
_L1:
        if (!basicgalaxyrequest.getResourcePath().startsWith("/")) goto _L4; else goto _L3
_L3:
        if (s.endsWith("/"))
        {
            s = s.substring(0, -1 + s.length());
        }
_L7:
        s = (new StringBuilder()).append(s).append(HttpUtils.urlEncode(basicgalaxyrequest.getResourcePath(), true)).toString();
_L5:
        Object obj;
label0:
        {
            String s1 = HttpUtils.encodeParameters(basicgalaxyrequest);
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (basicgalaxyrequest.getContent() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (basicgalaxyrequest.getHttpMethod() == HttpMethodName.POST)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                flag2 = false;
                if (!flag)
                {
                    break label0;
                }
            }
            flag2 = true;
        }
        if (s1 != null && flag2)
        {
            s = (new StringBuilder()).append(s).append("?").append(s1).toString();
        }
        if (basicgalaxyrequest.getHttpMethod() == HttpMethodName.POST)
        {
            HttpPost httppost = new HttpPost(s);
            if (basicgalaxyrequest.getContent() == null && s1 != null)
            {
                httppost.setEntity(newStringEntity(s1));
            } else
            {
                httppost.setEntity(new RepeatableInputStreamRequestEntity(basicgalaxyrequest));
            }
            obj = httppost;
        } else
        if (basicgalaxyrequest.getHttpMethod() == HttpMethodName.PUT)
        {
            HttpPut httpput = new HttpPut(s);
            httpput.getParams().setParameter("http.protocol.expect-continue", Boolean.valueOf(true));
            if (httpentity != null)
            {
                httpput.setEntity(httpentity);
            } else
            if (basicgalaxyrequest.getContent() != null)
            {
                Object obj1 = new RepeatableInputStreamRequestEntity(basicgalaxyrequest);
                if (basicgalaxyrequest.getHeaders().get("Content-Length") == null)
                {
                    obj1 = newBufferedHttpEntity(((HttpEntity) (obj1)));
                }
                httpput.setEntity(((HttpEntity) (obj1)));
            }
            obj = httpput;
        } else
        if (basicgalaxyrequest.getHttpMethod() == HttpMethodName.GET)
        {
            obj = new HttpGet(s);
        } else
        if (basicgalaxyrequest.getHttpMethod() == HttpMethodName.DELETE)
        {
            obj = new HttpDelete(s);
        } else
        {
label1:
            {
                if (basicgalaxyrequest.getHttpMethod() != HttpMethodName.HEAD)
                {
                    break label1;
                }
                obj = new HttpHead(s);
            }
        }
        configureHeaders(((HttpRequestBase) (obj)), basicgalaxyrequest, executioncontext, clientconfiguration);
        return ((HttpRequestBase) (obj));
_L4:
        if (!s.endsWith("/"))
        {
            s = (new StringBuilder()).append(s).append("/").toString();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!s.endsWith("/"))
        {
            s = (new StringBuilder()).append(s).append("/").toString();
        }
          goto _L5
        throw new GalaxyClientException(ReturnCode.HTTP_ERROR, (new StringBuilder()).append("Unknown HTTP method name: ").append(basicgalaxyrequest.getHttpMethod()).toString());
        if (true) goto _L7; else goto _L6
_L6:
    }

}
