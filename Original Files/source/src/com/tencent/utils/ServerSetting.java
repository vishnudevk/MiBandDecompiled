// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

public class ServerSetting
{

    public static final String DEFAULT_CGI_AUTHORIZE = "https://openmobile.qq.com/oauth2.0/m_authorize?";
    public static final String DEFAULT_LOCAL_STORAGE_URI = "http://qzs.qq.com";
    public static final String DEFAULT_REDIRECT_URI = "auth://tauth.qq.com/";
    public static final String DEFAULT_URL_ASK = "http://qzs.qq.com/open/mobile/request/sdk_request.html?";
    public static final String DEFAULT_URL_BRAG = "http://qzs.qq.com/open/mobile/brag/sdk_brag.html?";
    public static final String DEFAULT_URL_GIFT = "http://qzs.qq.com/open/mobile/request/sdk_request.html?";
    public static final String DEFAULT_URL_GRAPH_BASE = "https://openmobile.qq.com/";
    public static final String DEFAULT_URL_INVITE = "http://qzs.qq.com/open/mobile/invite/sdk_invite.html?";
    public static final String DEFAULT_URL_REACTIVE = "http://qzs.qq.com/open/mobile/reactive/sdk_reactive.html?";
    public static final String DEFAULT_URL_REPORT = "http://wspeed.qq.com/w.cgi";
    public static final String DEFAULT_URL_SEND_STORY = "http://qzs.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?";
    public static final String DEFAULT_URL_VOICE = "http://qzs.qq.com/open/mobile/not_support.html?";
    public static final int ENVIRONMENT_EXPERIENCE = 1;
    public static final int ENVIRONMENT_NORMOL = 0;
    public static final String KEY_HOST_ANALY = "analy.qq.com";
    public static final String KEY_HOST_APPIC = "appic.qq.com";
    public static final String KEY_HOST_APP_SUPPORT = "appsupport.qq.com";
    public static final String KEY_HOST_FUSION = "fusion.qq.com";
    public static final String KEY_HOST_I_GTIMG = "i.gtimg.cn";
    public static final String KEY_HOST_MAPP_QZONE = "mapp.qzone.qq.com";
    public static final String KEY_HOST_OPEN_MOBILE = "openmobile.qq.com";
    public static final String KEY_HOST_QZAPP_QLOGO = "qzapp.qlogo.cn";
    public static final String KEY_HOST_QZS_QQ = "qzs.qq.com";
    public static final String KEY_OPEN_ENV = "OpenEnvironment";
    public static final String KEY_OPEN_SETTING = "OpenSettings";
    private static final String a = com/tencent/utils/ServerSetting.getName();
    private static ServerSetting b = null;
    private volatile WeakReference c;

    public ServerSetting()
    {
        c = null;
    }

    public static ServerSetting getInstance()
    {
        com/tencent/utils/ServerSetting;
        JVM INSTR monitorenter ;
        ServerSetting serversetting;
        if (b == null)
        {
            b = new ServerSetting();
        }
        serversetting = b;
        com/tencent/utils/ServerSetting;
        JVM INSTR monitorexit ;
        return serversetting;
        Exception exception;
        exception;
        throw exception;
    }

    public void changeServer()
    {
        c = null;
    }

    public String getEnvUrl(Context context, String s)
    {
        String s1;
        String s2;
        if (c == null || c.get() == null)
        {
            c = new WeakReference(context.getSharedPreferences("ServerPrefs", 0));
        }
        try
        {
            s1 = (new URL(s)).getHost();
        }
        catch (MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
            Log.e(a, (new StringBuilder()).append("getEnvUrl error. url=").append(s).toString());
            return s;
        }
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        Log.e(a, (new StringBuilder()).append("Get host error. url=").append(s).toString());
        return s;
        s2 = ((SharedPreferences)c.get()).getString(s1, null);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        if (!s1.equals(s2))
        {
            break MISSING_BLOCK_LABEL_188;
        }
        Log.d(a, (new StringBuilder()).append("host=").append(s1).append(", envHost=").append(s2).toString());
        return s;
        s = s.replace(s1, s2);
        Log.d(a, (new StringBuilder()).append("return environment url : ").append(s).toString());
        return s;
    }

    public void setEnvironment(Context context, int i)
    {
        if (context != null && (c == null || c.get() == null))
        {
            c = new WeakReference(context.getSharedPreferences("ServerPrefs", 0));
        }
        if (i != 0 && i != 1)
        {
            Log.e(a, "\u5207\u6362\u73AF\u5883\u53C2\u6570\u9519\u8BEF\uFF0C\u6B63\u5F0F\u73AF\u5883\u4E3A0\uFF0C\u4F53\u9A8C\u73AF\u5883\u4E3A1");
            return;
        }
        android.content.SharedPreferences.Editor editor;
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            android.content.SharedPreferences.Editor editor1 = ((SharedPreferences)c.get()).edit();
            editor1.putInt("ServerType", 0);
            editor1.putString("OpenEnvironment", "formal");
            editor1.putString("qzs.qq.com", "qzs.qq.com");
            editor1.putString("openmobile.qq.com", "openmobile.qq.com");
            editor1.commit();
            changeServer();
            Toast.makeText(context, "\u5DF2\u5207\u6362\u5230\u6B63\u5F0F\u73AF\u5883", 0).show();
            return;

        case 1: // '\001'
            editor = ((SharedPreferences)c.get()).edit();
            break;
        }
        editor.putInt("ServerType", 1);
        editor.putString("OpenEnvironment", "exp");
        editor.putString("qzs.qq.com", "testmobile.qq.com");
        editor.putString("openmobile.qq.com", "test.openmobile.qq.com");
        editor.commit();
        changeServer();
        Toast.makeText(context, "\u5DF2\u5207\u6362\u5230\u4F53\u9A8C\u73AF\u5883", 0).show();
    }

}
