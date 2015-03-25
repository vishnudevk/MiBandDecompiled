// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

// Referenced classes of package com.tencent.tauth:
//            IRequestListener, LocationApi, a

abstract class d
    implements IRequestListener
{

    final LocationApi a;

    private d(LocationApi locationapi)
    {
        a = locationapi;
        super();
    }

    d(LocationApi locationapi, a a1)
    {
        this(locationapi);
    }

    protected abstract void a(Exception exception);

    public void onConnectTimeoutException(ConnectTimeoutException connecttimeoutexception)
    {
        a(connecttimeoutexception);
    }

    public void onHttpStatusException(com.tencent.utils.HttpUtils.HttpStatusException httpstatusexception)
    {
        a(httpstatusexception);
    }

    public void onIOException(IOException ioexception)
    {
        a(ioexception);
    }

    public void onJSONException(JSONException jsonexception)
    {
        a(jsonexception);
    }

    public void onMalformedURLException(MalformedURLException malformedurlexception)
    {
        a(malformedurlexception);
    }

    public void onNetworkUnavailableException(com.tencent.utils.HttpUtils.NetworkUnavailableException networkunavailableexception)
    {
        a(networkunavailableexception);
    }

    public void onSocketTimeoutException(SocketTimeoutException sockettimeoutexception)
    {
        a(sockettimeoutexception);
    }

    public void onUnknowException(Exception exception)
    {
        a(exception);
    }
}
