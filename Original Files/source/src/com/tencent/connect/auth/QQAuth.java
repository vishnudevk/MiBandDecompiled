// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.webkit.CookieSyncManager;
import android.widget.Toast;
import com.tencent.a.a.c;
import com.tencent.connect.a.a;
import com.tencent.connect.common.BaseApi;
import com.tencent.tauth.IUiListener;
import java.util.HashMap;

// Referenced classes of package com.tencent.connect.auth:
//            QQToken, AuthAgent

public class QQAuth
{

    private static HashMap c = null;
    private AuthAgent a;
    private QQToken b;

    private QQAuth(String s, Context context)
    {
        com.tencent.a.a.c.a("openSDK_LOG", "new Tencent() --start");
        b = new QQToken(s);
        a = new AuthAgent(context, b);
        com.tencent.connect.a.a.c(context, b);
        com.tencent.a.a.c.a("openSDK_LOG", "new Tencent() --end");
    }

    public static QQAuth createInstance(String s, Context context)
    {
        com.tencent.a.b.a.a(context.getApplicationContext());
        com.tencent.a.a.c.a("openSDK_LOG", "createInstance() --start");
        QQAuth qqauth;
        if (c == null)
        {
            c = new HashMap();
        } else
        if (c.containsKey(s))
        {
            com.tencent.a.a.c.a("openSDK_LOG", "createInstance() ,sessionMap.containsKey --end");
            return (QQAuth)c.get(s);
        }
        try
        {
            PackageManager packagemanager = context.getPackageManager();
            packagemanager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            packagemanager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            com.tencent.a.a.c.a("openSDK_LOG", "createInstance() error --end", namenotfoundexception);
            Toast.makeText(context.getApplicationContext(), "\u8BF7\u53C2\u7167\u6587\u6863\u5728Androidmanifest.xml\u52A0\u4E0AAuthActivity\u548CAssitActivity\u7684\u5B9A\u4E49 ", 1).show();
            return null;
        }
        qqauth = new QQAuth(s, context);
        c.put(s, qqauth);
        com.tencent.a.a.c.a("openSDK_LOG", "createInstance()  --end");
        return qqauth;
    }

    public QQToken getQQToken()
    {
        return b;
    }

    public boolean isSessionValid()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("isSessionValid(), result = ");
        String s;
        if (b.isSessionValid())
        {
            s = "true";
        } else
        {
            s = "false";
        }
        com.tencent.a.a.c.a("openSDK_LOG", stringbuilder.append(s).append("").toString());
        return b.isSessionValid();
    }

    public int login(Activity activity, String s, IUiListener iuilistener)
    {
        com.tencent.a.a.c.a("openSDK_LOG", "login()");
        BaseApi.isOEM = false;
        return a.doLogin(activity, s, iuilistener);
    }

    public int loginWithOEM(Activity activity, String s, IUiListener iuilistener, String s1, String s2, String s3)
    {
        com.tencent.a.a.c.b("openSDK_LOG", "loginWithOEM");
        BaseApi.isOEM = true;
        if (s1.equals(""))
        {
            s1 = "null";
        }
        if (s2.equals(""))
        {
            s2 = "null";
        }
        if (s3.equals(""))
        {
            s3 = "null";
        }
        BaseApi.installChannel = s2;
        BaseApi.registerChannel = s1;
        BaseApi.businessId = s3;
        return a.doLogin(activity, s, iuilistener);
    }

    public void logout(Context context)
    {
        com.tencent.a.a.c.a("openSDK_LOG", "logout() --start");
        CookieSyncManager.createInstance(context);
        setAccessToken(null, null);
        setOpenId(context, null);
        com.tencent.a.a.c.a("openSDK_LOG", "logout() --end");
    }

    public boolean onActivityResult(int i, int j, Intent intent)
    {
        com.tencent.a.a.c.c("openSDK_LOG", (new StringBuilder()).append("onActivityResult() ,resultCode = ").append(j).append("").toString());
        a.onActivityResult(i, j, intent);
        return true;
    }

    public int reAuth(Activity activity, String s, IUiListener iuilistener)
    {
        com.tencent.a.a.c.a("openSDK_LOG", "reAuth()");
        return a.doLogin(activity, s, iuilistener, true, true);
    }

    public void setAccessToken(String s, String s1)
    {
        com.tencent.a.a.c.a("openSDK_LOG", (new StringBuilder()).append("setAccessToken(), validTimeInSecond = ").append(s1).append("").toString());
        b.setAccessToken(s, s1);
    }

    public void setOpenId(Context context, String s)
    {
        com.tencent.a.a.c.a("openSDK_LOG", "setOpenId() --start");
        b.setOpenId(s);
        com.tencent.connect.a.a.d(context, b);
        com.tencent.a.a.c.a("openSDK_LOG", "setOpenId() --end");
    }

}
