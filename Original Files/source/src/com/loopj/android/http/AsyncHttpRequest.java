// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.UnknownHostException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.loopj.android.http:
//            ResponseHandlerInterface

public class AsyncHttpRequest
    implements Runnable
{

    private final AbstractHttpClient a;
    private final HttpContext b;
    private final HttpUriRequest c;
    private final ResponseHandlerInterface d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;

    public AsyncHttpRequest(AbstractHttpClient abstracthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, ResponseHandlerInterface responsehandlerinterface)
    {
        f = false;
        g = false;
        h = false;
        a = abstracthttpclient;
        b = httpcontext;
        c = httpurirequest;
        d = responsehandlerinterface;
    }

    private void a()
    {
        if (!isCancelled())
        {
            if (c.getURI().getScheme() == null)
            {
                throw new MalformedURLException("No valid URI scheme was provided");
            }
            org.apache.http.HttpResponse httpresponse = a.execute(c, b);
            if (!isCancelled() && d != null)
            {
                d.sendResponseMessage(httpresponse);
                return;
            }
        }
    }

    private void b()
    {
        IOException ioexception;
        HttpRequestRetryHandler httprequestretryhandler;
        boolean flag;
        ioexception = null;
        httprequestretryhandler = a.getHttpRequestRetryHandler();
        flag = true;
_L6:
        if (!flag) goto _L2; else goto _L1
_L1:
        a();
_L10:
        return;
        UnknownHostException unknownhostexception;
        unknownhostexception;
        IOException ioexception1 = new IOException((new StringBuilder()).append("UnknownHostException exception: ").append(unknownhostexception.getMessage()).toString());
        if (e <= 0) goto _L4; else goto _L3
_L3:
        int k;
        k = 1 + e;
        e = k;
        boolean flag2;
        if (httprequestretryhandler.retryRequest(ioexception1, k, b))
        {
            flag2 = true;
            break MISSING_BLOCK_LABEL_284;
        }
          goto _L4
_L8:
        if (!flag) goto _L6; else goto _L5
_L5:
        if (d == null) goto _L6; else goto _L7
_L7:
        d.sendRetryMessage(e);
          goto _L6
        Exception exception;
        exception;
        Log.e("AsyncHttpRequest", "Unhandled exception origin cause", exception);
        ioexception = new IOException((new StringBuilder()).append("Unhandled exception: ").append(exception.getMessage()).toString());
_L2:
        throw ioexception;
_L4:
        flag2 = false;
        break MISSING_BLOCK_LABEL_284;
        NullPointerException nullpointerexception;
        nullpointerexception;
        ioexception = new IOException((new StringBuilder()).append("NPE in HttpClient: ").append(nullpointerexception.getMessage()).toString());
        int j = 1 + e;
        e = j;
        flag = httprequestretryhandler.retryRequest(ioexception, j, b);
          goto _L8
        ioexception;
        if (isCancelled()) goto _L10; else goto _L9
_L9:
        boolean flag1;
        int i = 1 + e;
        e = i;
        flag1 = httprequestretryhandler.retryRequest(ioexception, i, b);
        flag = flag1;
          goto _L8
        flag = flag2;
        ioexception = ioexception1;
          goto _L8
    }

    private void c()
    {
        this;
        JVM INSTR monitorenter ;
        if (!h && f && !g)
        {
            g = true;
            if (d != null)
            {
                d.sendCancelMessage();
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean cancel(boolean flag)
    {
        f = true;
        c.abort();
        return isCancelled();
    }

    public boolean isCancelled()
    {
        if (f)
        {
            c();
        }
        return f;
    }

    public boolean isDone()
    {
        return isCancelled() || h;
    }

    public void run()
    {
        if (!isCancelled())
        {
            if (d != null)
            {
                d.sendStartMessage();
            }
            if (!isCancelled())
            {
                try
                {
                    b();
                }
                catch (IOException ioexception)
                {
                    if (!isCancelled() && d != null)
                    {
                        d.sendFailureMessage(0, null, null, ioexception);
                    } else
                    {
                        Log.e("AsyncHttpRequest", "makeRequestWithRetries returned error, but handler is null", ioexception);
                    }
                }
                if (!isCancelled())
                {
                    if (d != null)
                    {
                        d.sendFinishMessage();
                    }
                    h = true;
                    return;
                }
            }
        }
    }
}
