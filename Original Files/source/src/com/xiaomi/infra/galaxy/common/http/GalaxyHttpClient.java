// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.GalaxyServiceException;
import com.xiaomi.infra.galaxy.common.auth.Signer;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.model.GalaxyMarshaller;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;

// Referenced classes of package com.xiaomi.infra.galaxy.common.http:
//            HttpRequestFactory, GalaxyBackoffStrategy, ClientConfiguration, AbstractHttpClientFactory, 
//            ExecutionContext

public class GalaxyHttpClient
{

    private static final int MAX_BACKOFF_IN_MILLISECONDS = 20000;
    private static GalaxyBackoffStrategy galaxyBackoffStrategy = GalaxyBackoffStrategy.getInstance();
    private static AbstractHttpClientFactory httpClientFactory;
    private static HttpRequestFactory httpRequestFactory = new HttpRequestFactory();
    public static final Log log = LogFactory.getLog(com/xiaomi/infra/galaxy/common/http/GalaxyHttpClient);
    private final ClientConfiguration config;
    public AtomicBoolean isShutdown;
    private HttpClient keepAliveHttpClient;

    public GalaxyHttpClient(ClientConfiguration clientconfiguration)
    {
        config = clientconfiguration;
        if (config.isKeepAlive())
        {
            keepAliveHttpClient = httpClientFactory.createHttpClient(config);
            isShutdown = new AtomicBoolean(false);
            return;
        } else
        {
            isShutdown = new AtomicBoolean(true);
            return;
        }
    }

    private Object executeHelper(BasicGalaxyRequest basicgalaxyrequest, Class class1, ExecutionContext executioncontext, HttpClient httpclient)
    {
        HttpEntity httpentity;
        HashMap hashmap;
        HashMap hashmap1;
        int i;
        setUserAgent(basicgalaxyrequest);
        httpentity = null;
        hashmap = new HashMap();
        hashmap.putAll(basicgalaxyrequest.getParameters());
        hashmap1 = new HashMap();
        hashmap1.putAll(basicgalaxyrequest.getHeaders());
        i = 0;
_L7:
        HttpRequestBase httprequestbase;
        if (i > 0)
        {
            basicgalaxyrequest.setParameters(hashmap);
            basicgalaxyrequest.setHeaders(hashmap1);
        }
        httprequestbase = null;
        Signer signer = executioncontext.getSigner();
        httprequestbase = null;
        if (signer == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        com.xiaomi.infra.galaxy.common.auth.GalaxyCredentials galaxycredentials = executioncontext.getCredentials();
        httprequestbase = null;
        if (galaxycredentials == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        executioncontext.getSigner().sign(basicgalaxyrequest, executioncontext.getCredentials());
        httprequestbase = httpRequestFactory.createHttpRequest(basicgalaxyrequest, config, httpentity, executioncontext);
        if (httprequestbase instanceof HttpEntityEnclosingRequest)
        {
            httpentity = ((HttpEntityEnclosingRequest)httprequestbase).getEntity();
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        httprequestbase.setURI(null);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        pauseExponentially(i, null);
        if (httpentity == null) goto _L2; else goto _L1
_L1:
        InputStream inputstream = httpentity.getContent();
        if (i <= 0) goto _L4; else goto _L3
_L3:
        if (inputstream.markSupported())
        {
            inputstream.reset();
            inputstream.mark(-1);
        }
_L2:
        HttpResponse httpresponse;
        Object obj1;
        httpresponse = httpclient.execute(httprequestbase);
        if (!isRequestSuccessful(httpresponse))
        {
            break MISSING_BLOCK_LABEL_365;
        }
        obj1 = handleResponse(basicgalaxyrequest, class1, httprequestbase, httpresponse, executioncontext);
        i + 1;
        return obj1;
_L4:
        if (!inputstream.markSupported()) goto _L2; else goto _L5
_L5:
        inputstream.mark(-1);
          goto _L2
        IOException ioexception;
        ioexception;
        HttpEntity httpentity1 = httpentity;
        log.error((new StringBuilder()).append("Unable to execute HTTP request: ").append(ioexception.getMessage()).toString(), ioexception);
        if (!shouldRetry(httprequestbase, ioexception, i))
        {
            throw new GalaxyClientException(ReturnCode.HTTP_ERROR, (new StringBuilder()).append("Unable to execute HTTP request: ").append(ioexception.getMessage()).toString(), ioexception);
        }
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        i + 1;
        throw exception;
        Object obj;
        if (shouldRetry(httprequestbase, null, i))
        {
            break MISSING_BLOCK_LABEL_398;
        }
        obj = handleResponse(basicgalaxyrequest, class1, httprequestbase, httpresponse, executioncontext);
        i + 1;
        return obj;
        resetRequestAfterError(basicgalaxyrequest, null);
        int j;
        j = i + 1;
        httpentity1 = httpentity;
_L8:
        httpentity = httpentity1;
        i = j;
        if (true) goto _L7; else goto _L6
_L6:
        resetRequestAfterError(basicgalaxyrequest, ioexception);
        j = i + 1;
          goto _L8
    }

    private Object handleResponse(BasicGalaxyRequest basicgalaxyrequest, Class class1, HttpRequestBase httprequestbase, HttpResponse httpresponse, ExecutionContext executioncontext)
    {
        GalaxyMarshaller galaxymarshaller = executioncontext.getMarshaller();
        InputStream inputstream = httpresponse.getEntity().getContent();
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        String s;
        do
        {
            int i = inputstream.read(abyte0);
            if (i <= 0)
            {
                s = new String(bytearrayoutputstream.toString("UTF-8"));
                if (class1.isAssignableFrom(java/lang/String))
                {
                    return s;
                }
                break;
            }
            bytearrayoutputstream.write(abyte0, 0, i);
        } while (true);
        if (StringUtils.isBlank(s))
        {
            return galaxymarshaller.unmarshall(class1, galaxymarshaller.marshall(ReturnCode.RESPONSE_IS_BLANK.getResult()));
        } else
        {
            return galaxymarshaller.unmarshall(class1, s);
        }
    }

    public static boolean isRequestEntityTooLargeException(GalaxyServiceException galaxyserviceexception)
    {
        if (galaxyserviceexception == null)
        {
            return false;
        } else
        {
            return "Request entity too large".equals(galaxyserviceexception.getErrorCode());
        }
    }

    private boolean isRequestSuccessful(HttpResponse httpresponse)
    {
        return httpresponse.getStatusLine().getStatusCode() / 100 == 2;
    }

    public static boolean isThrottlingException(GalaxyServiceException galaxyserviceexception)
    {
        while (galaxyserviceexception == null || !"Throttling".equals(galaxyserviceexception.getErrorCode()) && !"ThrottlingException".equals(galaxyserviceexception.getErrorCode()) && !"ProvisionedThroughputExceededException".equals(galaxyserviceexception.getErrorCode())) 
        {
            return false;
        }
        return true;
    }

    private void pauseExponentially(int i, GalaxyServiceException galaxyserviceexception)
    {
        long l = Math.min(galaxyBackoffStrategy.getBackoffPeriod(i), 20000L);
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Retriable error detected, will retry in ").append(l).append("ms, attempt number: ").append(i).toString());
        }
        try
        {
            Thread.sleep(l);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            log.error("thread interrupted!", interruptedexception);
            Thread.currentThread().interrupt();
            throw new GalaxyClientException(ReturnCode.HTTP_ERROR, interruptedexception.getMessage(), interruptedexception);
        }
    }

    private void resetRequestAfterError(BasicGalaxyRequest basicgalaxyrequest, Exception exception)
    {
        if (basicgalaxyrequest.getContent() == null)
        {
            return;
        }
        if (!basicgalaxyrequest.getContent().markSupported())
        {
            throw new GalaxyClientException(ReturnCode.HTTP_ERROR, "Encountered an exception and stream is not resettable", exception);
        }
        try
        {
            basicgalaxyrequest.getContent().reset();
            return;
        }
        catch (IOException ioexception)
        {
            throw new GalaxyClientException(ReturnCode.HTTP_ERROR, "Encountered an exception and couldn't reset the stream to retry", exception);
        }
    }

    public static void setHttpClientFactory(AbstractHttpClientFactory abstracthttpclientfactory)
    {
        httpClientFactory = abstracthttpclientfactory;
    }

    private void setUserAgent(BasicGalaxyRequest basicgalaxyrequest)
    {
        String s = config.getUserAgent();
        if (!s.equals(ClientConfiguration.DEFAULT_USER_AGENT))
        {
            s = (new StringBuilder()).append(s).append(", ").append(ClientConfiguration.DEFAULT_USER_AGENT).toString();
        }
        if (s != null)
        {
            basicgalaxyrequest.addHeader("User-Agent", s);
        }
    }

    private boolean shouldRetry(HttpRequestBase httprequestbase, Exception exception, int i)
    {
        if (i < config.getMaxErrorRetry()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (!(httprequestbase instanceof HttpEntityEnclosingRequest))
        {
            break; /* Loop/switch isn't completed */
        }
        HttpEntity httpentity = ((HttpEntityEnclosingRequest)httprequestbase).getEntity();
        if (httpentity == null || httpentity.isRepeatable())
        {
            break; /* Loop/switch isn't completed */
        }
        if (log.isDebugEnabled())
        {
            log.debug("Entity not repeatable");
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (exception instanceof IOException)
        {
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Retrying on ").append(exception.getClass().getName()).append(": ").append(exception.getMessage()).toString());
            }
            return true;
        }
        if (exception instanceof GalaxyServiceException)
        {
            GalaxyServiceException galaxyserviceexception = (GalaxyServiceException)exception;
            if (galaxyserviceexception.getStatusCode() == 500 || galaxyserviceexception.getStatusCode() == 503)
            {
                return true;
            }
            if (isThrottlingException(galaxyserviceexception))
            {
                return true;
            }
            if (isClockSkewError(galaxyserviceexception))
            {
                return true;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void shutdown(HttpClient httpclient)
    {
        if (httpclient != null)
        {
            httpclient.getConnectionManager().shutdown();
        }
    }

    public Object execute(BasicGalaxyRequest basicgalaxyrequest, Class class1, ExecutionContext executioncontext)
    {
        HttpClient httpclient;
        if (executioncontext == null)
        {
            throw new GalaxyClientException(ReturnCode.PARAMETER_IS_INVALID, "Internal SDK Error: No execution context parameter specified.");
        }
        Object obj;
        if (config.isKeepAlive())
        {
            if (isShutdown.compareAndSet(true, false))
            {
                keepAliveHttpClient = httpClientFactory.createHttpClient(config);
            }
            httpclient = keepAliveHttpClient;
        } else
        {
            httpclient = httpClientFactory.createHttpClient(config);
        }
        obj = executeHelper(basicgalaxyrequest, class1, executioncontext, httpclient);
        if (!config.isKeepAlive())
        {
            shutdown(httpclient);
        }
        return obj;
        GalaxyClientException galaxyclientexception;
        galaxyclientexception;
        throw galaxyclientexception;
        Exception exception;
        exception;
        if (!config.isKeepAlive())
        {
            shutdown(httpclient);
        }
        throw exception;
    }

    public HttpClient getKeepAliveHttpClient()
    {
        return keepAliveHttpClient;
    }

    public boolean isClockSkewError(GalaxyServiceException galaxyserviceexception)
    {
        while (galaxyserviceexception == null || !"RequestTimeTooSkewed".equals(galaxyserviceexception.getErrorCode()) && !"RequestExpired".equals(galaxyserviceexception.getErrorCode()) && !"InvalidSignatureException".equals(galaxyserviceexception.getErrorCode()) && !"SignatureDoesNotMatch".equals(galaxyserviceexception.getErrorCode())) 
        {
            return false;
        }
        return true;
    }

    public void shutdown()
    {
        if (!isShutdown.compareAndSet(false, true))
        {
            shutdown(keepAliveHttpClient);
        }
    }

}
