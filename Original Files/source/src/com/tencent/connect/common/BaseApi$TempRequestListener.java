// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.common;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.common:
//            a, BaseApi

public class c
    implements IRequestListener
{

    final BaseApi a;
    private IUiListener b;
    private Handler c;

    static IUiListener a(c c1)
    {
        return c1.b;
    }

    public void onComplete(JSONObject jsonobject)
    {
        Message message = c.obtainMessage();
        message.obj = jsonobject;
        message.what = 0;
        c.sendMessage(message);
    }

    public void onConnectTimeoutException(ConnectTimeoutException connecttimeoutexception)
    {
        Message message = c.obtainMessage();
        message.obj = connecttimeoutexception.getMessage();
        message.what = -7;
        c.sendMessage(message);
    }

    public void onHttpStatusException(com.tencent.utils.n n)
    {
        Message message = c.obtainMessage();
        message.obj = n.getMessage();
        message.what = -9;
        c.sendMessage(message);
    }

    public void onIOException(IOException ioexception)
    {
        Message message = c.obtainMessage();
        message.obj = ioexception.getMessage();
        message.what = -2;
        c.sendMessage(message);
    }

    public void onJSONException(JSONException jsonexception)
    {
        Message message = c.obtainMessage();
        message.obj = jsonexception.getMessage();
        message.what = -4;
        c.sendMessage(message);
    }

    public void onMalformedURLException(MalformedURLException malformedurlexception)
    {
        Message message = c.obtainMessage();
        message.obj = malformedurlexception.getMessage();
        message.what = -3;
        c.sendMessage(message);
    }

    public void onNetworkUnavailableException(com.tencent.utils.Exception exception)
    {
        Message message = c.obtainMessage();
        message.obj = exception.getMessage();
        message.what = -10;
        c.sendMessage(message);
    }

    public void onSocketTimeoutException(SocketTimeoutException sockettimeoutexception)
    {
        Message message = c.obtainMessage();
        message.obj = sockettimeoutexception.getMessage();
        message.what = -8;
        c.sendMessage(message);
    }

    public void onUnknowException(Exception exception)
    {
        Message message = c.obtainMessage();
        message.obj = exception.getMessage();
        message.what = -6;
        c.sendMessage(message);
    }

    public (BaseApi baseapi, IUiListener iuilistener)
    {
        a = baseapi;
        super();
        b = iuilistener;
        c = new a(this, baseapi.mContext.getMainLooper(), baseapi);
    }
}
