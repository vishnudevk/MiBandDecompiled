// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.content.Context;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpClient, ResponseHandlerInterface, AsyncHttpRequest, RequestHandle

public class SyncHttpClient extends AsyncHttpClient
{

    public SyncHttpClient()
    {
        super(false, 80, 443);
    }

    public SyncHttpClient(int i)
    {
        super(false, i, 443);
    }

    public SyncHttpClient(int i, int j)
    {
        super(false, i, j);
    }

    public SyncHttpClient(SchemeRegistry schemeregistry)
    {
        super(schemeregistry);
    }

    public SyncHttpClient(boolean flag, int i, int j)
    {
        super(flag, i, j);
    }

    protected RequestHandle sendRequest(DefaultHttpClient defaulthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, String s, ResponseHandlerInterface responsehandlerinterface, Context context)
    {
        if (s != null)
        {
            httpurirequest.addHeader("Content-Type", s);
        }
        responsehandlerinterface.setUseSynchronousMode(true);
        (new AsyncHttpRequest(defaulthttpclient, httpcontext, httpurirequest, responsehandlerinterface)).run();
        return new RequestHandle(null);
    }
}
