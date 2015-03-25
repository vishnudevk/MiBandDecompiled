// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;

import android.os.Handler;
import android.os.Message;
import com.tencent.a.a.c;
import com.tencent.tauth.IRequestListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.auth:
//            AuthAgent

class h
    implements IRequestListener
{

    final AuthAgent a;

    public h(AuthAgent authagent)
    {
        a = authagent;
        super();
        c.b("openSDK_LOG", "OpenUi, RequestListener()");
    }

    public void onComplete(JSONObject jsonobject)
    {
        c.b("openSDK_LOG", "OpenUi, RequestListener() onComplete");
        Message message = new Message();
        message.what = 0;
        message.obj = jsonobject;
        AuthAgent.h(a).sendMessage(message);
    }

    public void onConnectTimeoutException(ConnectTimeoutException connecttimeoutexception)
    {
        c.a("openSDK_LOG", "OpenUi, RequestListener() onConnectTimeoutException", connecttimeoutexception);
        Message message = new Message();
        message.what = -7;
        message.obj = (new StringBuilder()).append(connecttimeoutexception.getMessage()).append("").toString();
        AuthAgent.h(a).sendMessage(message);
    }

    public void onHttpStatusException(com.tencent.utils.HttpUtils.HttpStatusException httpstatusexception)
    {
        c.a("openSDK_LOG", "OpenUi, RequestListener() onHttpStatusException", httpstatusexception);
        Message message = new Message();
        message.what = -9;
        message.obj = (new StringBuilder()).append(httpstatusexception.getMessage()).append("").toString();
        AuthAgent.h(a).sendMessage(message);
    }

    public void onIOException(IOException ioexception)
    {
        c.a("openSDK_LOG", "OpenUi, RequestListener() onIOException", ioexception);
        Message message = new Message();
        message.what = -2;
        message.obj = (new StringBuilder()).append(ioexception.getMessage()).append("").toString();
        AuthAgent.h(a).sendMessage(message);
    }

    public void onJSONException(JSONException jsonexception)
    {
        c.a("openSDK_LOG", "OpenUi, RequestListener() onJSONException", jsonexception);
        Message message = new Message();
        message.what = -4;
        message.obj = (new StringBuilder()).append(jsonexception.getMessage()).append("").toString();
        AuthAgent.h(a).sendMessage(message);
    }

    public void onMalformedURLException(MalformedURLException malformedurlexception)
    {
        Message message = new Message();
        message.what = -3;
        message.obj = (new StringBuilder()).append(malformedurlexception.getMessage()).append("").toString();
        AuthAgent.h(a).sendMessage(message);
    }

    public void onNetworkUnavailableException(com.tencent.utils.HttpUtils.NetworkUnavailableException networkunavailableexception)
    {
        c.a("openSDK_LOG", "OpenUi, RequestListener() onNetworkUnavailableException", networkunavailableexception);
        Message message = new Message();
        message.what = -2;
        message.obj = (new StringBuilder()).append(networkunavailableexception.getMessage()).append("").toString();
        AuthAgent.h(a).sendMessage(message);
    }

    public void onSocketTimeoutException(SocketTimeoutException sockettimeoutexception)
    {
        c.a("openSDK_LOG", "OpenUi, RequestListener() onSocketTimeoutException", sockettimeoutexception);
        Message message = new Message();
        message.what = -8;
        message.obj = (new StringBuilder()).append(sockettimeoutexception.getMessage()).append("").toString();
        AuthAgent.h(a).sendMessage(message);
    }

    public void onUnknowException(Exception exception)
    {
        c.a("openSDK_LOG", "OpenUi, RequestListener() onUnknowException", exception);
        Message message = new Message();
        message.what = -6;
        message.obj = (new StringBuilder()).append(exception.getMessage()).append("").toString();
        AuthAgent.h(a).sendMessage(message);
    }
}
