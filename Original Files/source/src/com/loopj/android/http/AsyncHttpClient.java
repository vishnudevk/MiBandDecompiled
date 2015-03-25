// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

// Referenced classes of package com.loopj.android.http:
//            a, b, c, z, 
//            RequestParams, ResponseHandlerInterface, MySSLSocketFactory, RequestHandle, 
//            d, AsyncHttpRequest, RangeFileAsyncHttpResponseHandler, PreemtiveAuthorizationHttpRequestInterceptor, 
//            w

public class AsyncHttpClient
{

    public static final int DEFAULT_MAX_CONNECTIONS = 10;
    public static final int DEFAULT_MAX_RETRIES = 5;
    public static final int DEFAULT_RETRY_SLEEP_TIME_MILLIS = 1500;
    public static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    public static final int DEFAULT_SOCKET_TIMEOUT = 10000;
    public static final String ENCODING_GZIP = "gzip";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String LOG_TAG = "AsyncHttpClient";
    private int a;
    private int b;
    private final DefaultHttpClient c;
    private final HttpContext d;
    private ExecutorService e;
    private final Map f;
    private final Map g;
    private boolean h;

    public AsyncHttpClient()
    {
        this(false, 80, 443);
    }

    public AsyncHttpClient(int i)
    {
        this(false, i, 443);
    }

    public AsyncHttpClient(int i, int j)
    {
        this(false, i, j);
    }

    public AsyncHttpClient(SchemeRegistry schemeregistry)
    {
        a = 10;
        b = 10000;
        h = true;
        BasicHttpParams basichttpparams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basichttpparams, b);
        ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(a));
        ConnManagerParams.setMaxTotalConnections(basichttpparams, 10);
        HttpConnectionParams.setSoTimeout(basichttpparams, b);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, b);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        ThreadSafeClientConnManager threadsafeclientconnmanager = new ThreadSafeClientConnManager(basichttpparams, schemeregistry);
        e = getDefaultThreadPool();
        f = new WeakHashMap();
        g = new HashMap();
        d = new SyncBasicHttpContext(new BasicHttpContext());
        c = new DefaultHttpClient(threadsafeclientconnmanager, basichttpparams);
        c.addRequestInterceptor(new a(this));
        c.addResponseInterceptor(new b(this));
        c.addRequestInterceptor(new c(this), 0);
        c.setHttpRequestRetryHandler(new z(5, 1500));
    }

    public AsyncHttpClient(boolean flag, int i, int j)
    {
        this(a(flag, i, j));
    }

    static Map a(AsyncHttpClient asynchttpclient)
    {
        return asynchttpclient.g;
    }

    private HttpEntity a(RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        HttpEntity httpentity = null;
        if (requestparams != null)
        {
            HttpEntity httpentity1;
            try
            {
                httpentity1 = requestparams.getEntity(responsehandlerinterface);
            }
            catch (Throwable throwable)
            {
                if (responsehandlerinterface != null)
                {
                    responsehandlerinterface.sendFailureMessage(0, null, null, throwable);
                    return null;
                } else
                {
                    throwable.printStackTrace();
                    return null;
                }
            }
            httpentity = httpentity1;
        }
        return httpentity;
    }

    private HttpEntityEnclosingRequestBase a(HttpEntityEnclosingRequestBase httpentityenclosingrequestbase, HttpEntity httpentity)
    {
        if (httpentity != null)
        {
            httpentityenclosingrequestbase.setEntity(httpentity);
        }
        return httpentityenclosingrequestbase;
    }

    private static SchemeRegistry a(boolean flag, int i, int j)
    {
        if (flag)
        {
            Log.d("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
        }
        if (i < 1)
        {
            i = 80;
            Log.d("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
        }
        if (j < 1)
        {
            j = 443;
            Log.d("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
        }
        SSLSocketFactory sslsocketfactory;
        SchemeRegistry schemeregistry;
        if (flag)
        {
            sslsocketfactory = MySSLSocketFactory.getFixedSocketFactory();
        } else
        {
            sslsocketfactory = SSLSocketFactory.getSocketFactory();
        }
        schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), i));
        schemeregistry.register(new Scheme("https", sslsocketfactory, j));
        return schemeregistry;
    }

    public static void allowRetryExceptionClass(Class class1)
    {
        if (class1 != null)
        {
            z.a(class1);
        }
    }

    static Map b(AsyncHttpClient asynchttpclient)
    {
        return asynchttpclient.f;
    }

    public static void blockRetryExceptionClass(Class class1)
    {
        if (class1 != null)
        {
            z.b(class1);
        }
    }

    public static String getUrlWithQueryString(boolean flag, String s, RequestParams requestparams)
    {
        String s1;
        if (flag)
        {
            s1 = s.replace(" ", "%20");
        } else
        {
            s1 = s;
        }
        if (requestparams != null)
        {
            String s2 = requestparams.getParamString().trim();
            if (!s2.equals("") && !s2.equals("?"))
            {
                StringBuilder stringbuilder = (new StringBuilder()).append(s1);
                String s3;
                String s4;
                if (s1.contains("?"))
                {
                    s3 = "&";
                } else
                {
                    s3 = "?";
                }
                s4 = stringbuilder.append(s3).toString();
                s1 = (new StringBuilder()).append(s4).append(s2).toString();
            }
        }
        return s1;
    }

    public static void silentCloseInputStream(InputStream inputstream)
    {
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        inputstream.close();
        return;
        IOException ioexception;
        ioexception;
        Log.w("AsyncHttpClient", "Cannot close input stream", ioexception);
        return;
    }

    public static void silentCloseOutputStream(OutputStream outputstream)
    {
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        outputstream.close();
        return;
        IOException ioexception;
        ioexception;
        Log.w("AsyncHttpClient", "Cannot close output stream", ioexception);
        return;
    }

    public void addHeader(String s, String s1)
    {
        g.put(s, s1);
    }

    public void cancelAllRequests(boolean flag)
    {
        Iterator iterator = f.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            List list = (List)iterator.next();
            if (list != null)
            {
                Iterator iterator1 = list.iterator();
                while (iterator1.hasNext()) 
                {
                    ((RequestHandle)iterator1.next()).cancel(flag);
                }
            }
        } while (true);
        f.clear();
    }

    public void cancelRequests(Context context, boolean flag)
    {
        if (context == null)
        {
            Log.e("AsyncHttpClient", "Passed null Context to cancelRequests");
            return;
        }
        d d1 = new d(this, context, flag);
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            (new Thread(d1)).start();
            return;
        } else
        {
            d1.run();
            return;
        }
    }

    public void clearBasicAuth()
    {
        c.getCredentialsProvider().clear();
    }

    public RequestHandle delete(Context context, String s, ResponseHandlerInterface responsehandlerinterface)
    {
        HttpDelete httpdelete = new HttpDelete(URI.create(s).normalize());
        return sendRequest(c, d, httpdelete, null, responsehandlerinterface, context);
    }

    public RequestHandle delete(Context context, String s, Header aheader[], RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        HttpDelete httpdelete = new HttpDelete(getUrlWithQueryString(h, s, requestparams));
        if (aheader != null)
        {
            httpdelete.setHeaders(aheader);
        }
        return sendRequest(c, d, httpdelete, null, responsehandlerinterface, context);
    }

    public RequestHandle delete(Context context, String s, Header aheader[], ResponseHandlerInterface responsehandlerinterface)
    {
        HttpDelete httpdelete = new HttpDelete(URI.create(s).normalize());
        if (aheader != null)
        {
            httpdelete.setHeaders(aheader);
        }
        return sendRequest(c, d, httpdelete, null, responsehandlerinterface, context);
    }

    public RequestHandle delete(String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return delete(null, s, responsehandlerinterface);
    }

    public RequestHandle get(Context context, String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(c, d, new HttpGet(getUrlWithQueryString(h, s, requestparams)), null, responsehandlerinterface, context);
    }

    public RequestHandle get(Context context, String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return get(context, s, null, responsehandlerinterface);
    }

    public RequestHandle get(Context context, String s, Header aheader[], RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        HttpGet httpget = new HttpGet(getUrlWithQueryString(h, s, requestparams));
        if (aheader != null)
        {
            httpget.setHeaders(aheader);
        }
        return sendRequest(c, d, httpget, null, responsehandlerinterface, context);
    }

    public RequestHandle get(String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return get(null, s, requestparams, responsehandlerinterface);
    }

    public RequestHandle get(String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return get(null, s, null, responsehandlerinterface);
    }

    protected ExecutorService getDefaultThreadPool()
    {
        return Executors.newCachedThreadPool();
    }

    public HttpClient getHttpClient()
    {
        return c;
    }

    public HttpContext getHttpContext()
    {
        return d;
    }

    public int getMaxConnections()
    {
        return a;
    }

    public ExecutorService getThreadPool()
    {
        return e;
    }

    public int getTimeout()
    {
        return b;
    }

    public RequestHandle head(Context context, String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(c, d, new HttpHead(getUrlWithQueryString(h, s, requestparams)), null, responsehandlerinterface, context);
    }

    public RequestHandle head(Context context, String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return head(context, s, null, responsehandlerinterface);
    }

    public RequestHandle head(Context context, String s, Header aheader[], RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        HttpHead httphead = new HttpHead(getUrlWithQueryString(h, s, requestparams));
        if (aheader != null)
        {
            httphead.setHeaders(aheader);
        }
        return sendRequest(c, d, httphead, null, responsehandlerinterface, context);
    }

    public RequestHandle head(String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return head(null, s, requestparams, responsehandlerinterface);
    }

    public RequestHandle head(String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return head(null, s, null, responsehandlerinterface);
    }

    public boolean isUrlEncodingEnabled()
    {
        return h;
    }

    public RequestHandle post(Context context, String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return post(context, s, a(requestparams, responsehandlerinterface), null, responsehandlerinterface);
    }

    public RequestHandle post(Context context, String s, HttpEntity httpentity, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(c, d, a(new HttpPost(URI.create(s).normalize()), httpentity), s1, responsehandlerinterface, context);
    }

    public RequestHandle post(Context context, String s, Header aheader[], RequestParams requestparams, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        HttpPost httppost = new HttpPost(URI.create(s).normalize());
        if (requestparams != null)
        {
            httppost.setEntity(a(requestparams, responsehandlerinterface));
        }
        if (aheader != null)
        {
            httppost.setHeaders(aheader);
        }
        return sendRequest(c, d, httppost, s1, responsehandlerinterface, context);
    }

    public RequestHandle post(Context context, String s, Header aheader[], HttpEntity httpentity, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        HttpEntityEnclosingRequestBase httpentityenclosingrequestbase = a(new HttpPost(URI.create(s).normalize()), httpentity);
        if (aheader != null)
        {
            httpentityenclosingrequestbase.setHeaders(aheader);
        }
        return sendRequest(c, d, httpentityenclosingrequestbase, s1, responsehandlerinterface, context);
    }

    public RequestHandle post(String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return post(null, s, requestparams, responsehandlerinterface);
    }

    public RequestHandle post(String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return post(null, s, null, responsehandlerinterface);
    }

    public RequestHandle put(Context context, String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return put(context, s, a(requestparams, responsehandlerinterface), null, responsehandlerinterface);
    }

    public RequestHandle put(Context context, String s, HttpEntity httpentity, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        return sendRequest(c, d, a(new HttpPut(URI.create(s).normalize()), httpentity), s1, responsehandlerinterface, context);
    }

    public RequestHandle put(Context context, String s, Header aheader[], HttpEntity httpentity, String s1, ResponseHandlerInterface responsehandlerinterface)
    {
        HttpEntityEnclosingRequestBase httpentityenclosingrequestbase = a(new HttpPut(URI.create(s).normalize()), httpentity);
        if (aheader != null)
        {
            httpentityenclosingrequestbase.setHeaders(aheader);
        }
        return sendRequest(c, d, httpentityenclosingrequestbase, s1, responsehandlerinterface, context);
    }

    public RequestHandle put(String s, RequestParams requestparams, ResponseHandlerInterface responsehandlerinterface)
    {
        return put(null, s, requestparams, responsehandlerinterface);
    }

    public RequestHandle put(String s, ResponseHandlerInterface responsehandlerinterface)
    {
        return put(null, s, null, responsehandlerinterface);
    }

    public void removeHeader(String s)
    {
        g.remove(s);
    }

    protected RequestHandle sendRequest(DefaultHttpClient defaulthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, String s, ResponseHandlerInterface responsehandlerinterface, Context context)
    {
        if (httpurirequest == null)
        {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        }
        if (responsehandlerinterface == null)
        {
            throw new IllegalArgumentException("ResponseHandler must not be null");
        }
        if (responsehandlerinterface.getUseSynchronousMode())
        {
            throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
        }
        if (s != null)
        {
            httpurirequest.setHeader("Content-Type", s);
        }
        responsehandlerinterface.setRequestHeaders(httpurirequest.getAllHeaders());
        responsehandlerinterface.setRequestURI(httpurirequest.getURI());
        AsyncHttpRequest asynchttprequest = new AsyncHttpRequest(defaulthttpclient, httpcontext, httpurirequest, responsehandlerinterface);
        e.submit(asynchttprequest);
        RequestHandle requesthandle = new RequestHandle(asynchttprequest);
        if (context != null)
        {
            Object obj = (List)f.get(context);
            if (obj == null)
            {
                obj = new LinkedList();
                f.put(context, obj);
            }
            if (responsehandlerinterface instanceof RangeFileAsyncHttpResponseHandler)
            {
                ((RangeFileAsyncHttpResponseHandler)responsehandlerinterface).updateRequestHeaders(httpurirequest);
            }
            ((List) (obj)).add(requesthandle);
            Iterator iterator = ((List) (obj)).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (((RequestHandle)iterator.next()).shouldBeGarbageCollected())
                {
                    iterator.remove();
                }
            } while (true);
        }
        return requesthandle;
    }

    public void setAuthenticationPreemptive(boolean flag)
    {
        if (flag)
        {
            c.addRequestInterceptor(new PreemtiveAuthorizationHttpRequestInterceptor(), 0);
            return;
        } else
        {
            c.removeRequestInterceptorByClass(com/loopj/android/http/PreemtiveAuthorizationHttpRequestInterceptor);
            return;
        }
    }

    public void setBasicAuth(String s, String s1)
    {
        setBasicAuth(s, s1, false);
    }

    public void setBasicAuth(String s, String s1, AuthScope authscope)
    {
        setBasicAuth(s, s1, authscope, false);
    }

    public void setBasicAuth(String s, String s1, AuthScope authscope, boolean flag)
    {
        UsernamePasswordCredentials usernamepasswordcredentials = new UsernamePasswordCredentials(s, s1);
        CredentialsProvider credentialsprovider = c.getCredentialsProvider();
        if (authscope == null)
        {
            authscope = AuthScope.ANY;
        }
        credentialsprovider.setCredentials(authscope, usernamepasswordcredentials);
        setAuthenticationPreemptive(flag);
    }

    public void setBasicAuth(String s, String s1, boolean flag)
    {
        setBasicAuth(s, s1, null, flag);
    }

    public void setCookieStore(CookieStore cookiestore)
    {
        d.setAttribute("http.cookie-store", cookiestore);
    }

    public void setEnableRedirects(boolean flag)
    {
        setEnableRedirects(flag, flag, flag);
    }

    public void setEnableRedirects(boolean flag, boolean flag1)
    {
        setEnableRedirects(flag, flag1, true);
    }

    public void setEnableRedirects(boolean flag, boolean flag1, boolean flag2)
    {
        HttpParams httpparams = c.getParams();
        boolean flag3;
        if (!flag1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        httpparams.setBooleanParameter("http.protocol.reject-relative-redirect", flag3);
        c.getParams().setBooleanParameter("http.protocol.allow-circular-redirects", flag2);
        c.setRedirectHandler(new w(flag));
    }

    public void setMaxConnections(int i)
    {
        if (i < 1)
        {
            i = 10;
        }
        a = i;
        ConnManagerParams.setMaxConnectionsPerRoute(c.getParams(), new ConnPerRouteBean(a));
    }

    public void setMaxRetriesAndTimeout(int i, int j)
    {
        c.setHttpRequestRetryHandler(new z(i, j));
    }

    public void setProxy(String s, int i)
    {
        HttpHost httphost = new HttpHost(s, i);
        c.getParams().setParameter("http.route.default-proxy", httphost);
    }

    public void setProxy(String s, int i, String s1, String s2)
    {
        c.getCredentialsProvider().setCredentials(new AuthScope(s, i), new UsernamePasswordCredentials(s1, s2));
        HttpHost httphost = new HttpHost(s, i);
        c.getParams().setParameter("http.route.default-proxy", httphost);
    }

    public void setRedirectHandler(RedirectHandler redirecthandler)
    {
        c.setRedirectHandler(redirecthandler);
    }

    public void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        c.getConnectionManager().getSchemeRegistry().register(new Scheme("https", sslsocketfactory, 443));
    }

    public void setThreadPool(ExecutorService executorservice)
    {
        e = executorservice;
    }

    public void setTimeout(int i)
    {
        if (i < 1000)
        {
            i = 10000;
        }
        b = i;
        HttpParams httpparams = c.getParams();
        ConnManagerParams.setTimeout(httpparams, b);
        HttpConnectionParams.setSoTimeout(httpparams, b);
        HttpConnectionParams.setConnectionTimeout(httpparams, b);
    }

    public void setURLEncodingEnabled(boolean flag)
    {
        h = flag;
    }

    public void setUserAgent(String s)
    {
        HttpProtocolParams.setUserAgent(c.getParams(), s);
    }
}
