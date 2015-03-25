// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IRequestListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

// Referenced classes of package com.tencent.utils:
//            HttpUtils

final class c extends Thread
{

    final QQToken a;
    final Context b;
    final String c;
    final Bundle d;
    final String e;
    final IRequestListener f;

    c(QQToken qqtoken, Context context, String s, Bundle bundle, String s1, IRequestListener irequestlistener)
    {
        a = qqtoken;
        b = context;
        c = s;
        d = bundle;
        e = s1;
        f = irequestlistener;
        super();
    }

    public void run()
    {
        org.json.JSONObject jsonobject = HttpUtils.request(a, b, c, d, e);
        if (f != null)
        {
            f.onComplete(jsonobject);
            com.tencent.a.a.c.b("openSDK_LOG", "OpenApi onComplete");
        }
_L2:
        return;
        MalformedURLException malformedurlexception;
        malformedurlexception;
        if (f == null) goto _L2; else goto _L1
_L1:
        f.onMalformedURLException(malformedurlexception);
        com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync MalformedURLException", malformedurlexception);
        return;
        ConnectTimeoutException connecttimeoutexception;
        connecttimeoutexception;
        if (f == null) goto _L2; else goto _L3
_L3:
        f.onConnectTimeoutException(connecttimeoutexception);
        com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync onConnectTimeoutException", connecttimeoutexception);
        return;
        SocketTimeoutException sockettimeoutexception;
        sockettimeoutexception;
        if (f == null) goto _L2; else goto _L4
_L4:
        f.onSocketTimeoutException(sockettimeoutexception);
        com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync onSocketTimeoutException", sockettimeoutexception);
        return;
        HttpUtils.NetworkUnavailableException networkunavailableexception;
        networkunavailableexception;
        if (f == null) goto _L2; else goto _L5
_L5:
        f.onNetworkUnavailableException(networkunavailableexception);
        com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync onNetworkUnavailableException", networkunavailableexception);
        return;
        HttpUtils.HttpStatusException httpstatusexception;
        httpstatusexception;
        if (f == null) goto _L2; else goto _L6
_L6:
        f.onHttpStatusException(httpstatusexception);
        com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync onHttpStatusException", httpstatusexception);
        return;
        IOException ioexception;
        ioexception;
        if (f == null) goto _L2; else goto _L7
_L7:
        f.onIOException(ioexception);
        com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync IOException", ioexception);
        return;
        JSONException jsonexception;
        jsonexception;
        if (f == null) goto _L2; else goto _L8
_L8:
        f.onJSONException(jsonexception);
        com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync JSONException", jsonexception);
        return;
        Exception exception;
        exception;
        if (f != null)
        {
            f.onUnknowException(exception);
            com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync onUnknowException", exception);
            return;
        }
          goto _L2
    }
}
