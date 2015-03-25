// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.CookieSyncManager;
import com.tencent.a.a.c;
import com.tencent.connect.a.a;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.auth:
//            AuthAgent, QQToken

class i
    implements IUiListener
{

    final AuthAgent a;
    private IUiListener b;
    private boolean c;
    private Context d;

    public i(AuthAgent authagent, Context context, IUiListener iuilistener, boolean flag, boolean flag1)
    {
        a = authagent;
        super();
        d = context;
        b = iuilistener;
        c = flag;
        com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, TokenListener()");
    }

    public void onCancel()
    {
        com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, TokenListener() onCancel");
        b.onCancel();
        com.tencent.a.a.c.a().b();
    }

    public void onComplete(Object obj)
    {
        JSONObject jsonobject;
        com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, TokenListener() onComplete");
        jsonobject = (JSONObject)obj;
        String s;
        String s1;
        String s2;
        s = jsonobject.getString("access_token");
        s1 = jsonobject.getString("expires_in");
        s2 = jsonobject.getString("openid");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        if (com.tencent.connect.auth.AuthAgent.a(a) == null || s2 == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        AuthAgent.b(a).setAccessToken(s, s1);
        com.tencent.connect.auth.AuthAgent.c(a).setOpenId(s2);
        com.tencent.connect.a.a.d(d, AuthAgent.d(a));
        String s3 = jsonobject.getString("pf");
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        d.getSharedPreferences("pfStore", 0).edit().putString("pf", s3).commit();
_L1:
        if (c)
        {
            CookieSyncManager.getInstance().sync();
        }
_L2:
        b.onComplete(jsonobject);
        com.tencent.a.a.c.a().b();
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
        com.tencent.a.a.c.a("openSDK_LOG", "OpenUi, TokenListener() onComplete error", exception);
          goto _L1
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        com.tencent.a.a.c.a("openSDK_LOG", "OpenUi, TokenListener() onComplete error", jsonexception);
          goto _L2
    }

    public void onError(UiError uierror)
    {
        com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, TokenListener() onError");
        b.onError(uierror);
        com.tencent.a.a.c.a().b();
    }
}
