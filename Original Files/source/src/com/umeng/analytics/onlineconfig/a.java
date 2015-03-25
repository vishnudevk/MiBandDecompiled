// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.onlineconfig;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.g;
import java.util.Iterator;
import org.json.JSONObject;
import u.aly.bi;
import u.aly.bj;
import u.aly.bv;

// Referenced classes of package com.umeng.analytics.onlineconfig:
//            b, UmengOnlineConfigureListener, c

public class a
{

    public static final String a = "type";
    public static final String b = "package";
    public static final String c = "channel";
    public static final String d = "idmd5";
    public static final String e = "version_code";
    public static final String f = "appkey";
    public static final String g = "sdk_version";
    private final String h = "last_config_time";
    private final String i = "report_policy";
    private final String j = "online_config";
    private UmengOnlineConfigureListener k;
    private c l;
    private long m;

    public a()
    {
        k = null;
        l = null;
        m = 0L;
    }

    static c a(a a1)
    {
        return a1.l;
    }

    static JSONObject a(a a1, Context context)
    {
        return a1.b(context);
    }

    private void a(Context context, b b1)
    {
        android.content.SharedPreferences.Editor editor = com.umeng.analytics.g.a(context).g().edit();
        if (!TextUtils.isEmpty(b1.e))
        {
            editor.putString("umeng_last_config_time", b1.e);
            editor.commit();
        }
        if (b1.c != -1)
        {
            com.umeng.analytics.g.a(context).a(b1.c, b1.d);
        }
    }

    static void a(a a1, Context context, b b1)
    {
        a1.a(context, b1);
    }

    static void a(a a1, JSONObject jsonobject)
    {
        a1.a(jsonobject);
    }

    private void a(JSONObject jsonobject)
    {
        if (k != null)
        {
            k.onDataReceived(jsonobject);
        }
    }

    private JSONObject b(Context context)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("type", "online_config");
            jsonobject.put("appkey", AnalyticsConfig.getAppkey(context));
            jsonobject.put("version_code", bi.c(context));
            jsonobject.put("package", bi.u(context));
            jsonobject.put("sdk_version", "5.2.4");
            jsonobject.put("idmd5", bv.b(bi.f(context)));
            jsonobject.put("channel", AnalyticsConfig.getChannel(context));
            jsonobject.put("report_policy", com.umeng.analytics.g.a(context).a()[0]);
            jsonobject.put("last_config_time", c(context));
        }
        catch (Exception exception)
        {
            bj.b("MobclickAgent", "exception in onlineConfigInternal");
            return null;
        }
        return jsonobject;
    }

    private void b(Context context, b b1)
    {
        android.content.SharedPreferences.Editor editor;
        if (b1.a == null || b1.a.length() == 0)
        {
            return;
        }
        editor = com.umeng.analytics.g.a(context).g().edit();
        JSONObject jsonobject;
        Iterator iterator;
        jsonobject = b1.a;
        iterator = jsonobject.keys();
_L1:
        Exception exception;
        if (!iterator.hasNext())
        {
            editor.commit();
            bj.a("MobclickAgent", (new StringBuilder("get online setting params: ")).append(jsonobject).toString());
            return;
        }
        try
        {
            String s = (String)iterator.next();
            editor.putString(s, jsonobject.getString(s));
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            bj.c("MobclickAgent", "save online config params", exception);
            return;
        }
          goto _L1
    }

    static void b(a a1, Context context, b b1)
    {
        a1.b(context, b1);
    }

    private String c(Context context)
    {
        return com.umeng.analytics.g.a(context).g().getString("umeng_last_config_time", "");
    }

    public void a()
    {
        k = null;
    }

    public void a(Context context)
    {
        if (context == null)
        {
            try
            {
                bj.b("MobclickAgent", "unexpected null context in updateOnlineConfig");
                return;
            }
            catch (Exception exception)
            {
                bj.b("MobclickAgent", "exception in updateOnlineConfig");
            }
            break MISSING_BLOCK_LABEL_56;
        }
        if (bj.a && bi.w(context))
        {
            (new Thread(new b(context.getApplicationContext()))).start();
            return;
        }
        break MISSING_BLOCK_LABEL_57;
        return;
        long l1 = System.currentTimeMillis();
        if (l1 - m > 0x36ee80L)
        {
            m = l1;
            (new Thread(new b(context.getApplicationContext()))).start();
        }
        return;
    }

    public void a(UmengOnlineConfigureListener umengonlineconfigurelistener)
    {
        k = umengonlineconfigurelistener;
    }

    public void a(c c1)
    {
        l = c1;
    }

    public void b()
    {
        l = null;
    }

    private class b extends bo
        implements Runnable
    {

        Context a;
        final com.umeng.analytics.onlineconfig.a b;

        private void b()
        {
            a a1;
            String as[];
            int i1;
            com.umeng.analytics.onlineconfig.b b1;
            JSONObject jsonobject = com.umeng.analytics.onlineconfig.a.a(b, a);
            a1 = b. new a(jsonobject);
            as = com.umeng.analytics.a.g;
            i1 = 0;
            b1 = null;
_L5:
            if (i1 < as.length) goto _L2; else goto _L1
_L1:
            if (b1 == null)
            {
                com.umeng.analytics.onlineconfig.a.a(b, null);
                return;
            }
            break; /* Loop/switch isn't completed */
_L2:
            a1.a(as[i1]);
            b1 = (com.umeng.analytics.onlineconfig.b)a(a1, com/umeng/analytics/onlineconfig/b);
            if (b1 != null) goto _L1; else goto _L3
_L3:
            i1++;
            if (true) goto _L5; else goto _L4
_L4:
            if (b1.b)
            {
                if (com.umeng.analytics.onlineconfig.a.a(b) != null)
                {
                    com.umeng.analytics.onlineconfig.a.a(b).a(b1.c, b1.d);
                }
                com.umeng.analytics.onlineconfig.a.a(b, a, b1);
                com.umeng.analytics.onlineconfig.a.b(b, a, b1);
                com.umeng.analytics.onlineconfig.a.a(b, b1.a);
                return;
            } else
            {
                com.umeng.analytics.onlineconfig.a.a(b, null);
                return;
            }
        }

        public boolean a()
        {
            return false;
        }

        public void run()
        {
            if (AnalyticsConfig.UPDATE_IN_MAIN_PROCESS && !com.umeng.analytics.b.a(a))
            {
                break MISSING_BLOCK_LABEL_20;
            }
            b();
            return;
            Exception exception;
            exception;
            com.umeng.analytics.onlineconfig.a.a(b, null);
            bj.c("MobclickAgent", "reques update error", exception);
            return;
        }

        public b(Context context)
        {
            b = a.this;
            super();
            a = context.getApplicationContext();
        }

        private class a extends bp
        {

            final com.umeng.analytics.onlineconfig.a a;
            private JSONObject e;

            public JSONObject a()
            {
                return e;
            }

            public String b()
            {
                return d;
            }

            public a(JSONObject jsonobject)
            {
                a = com.umeng.analytics.onlineconfig.a.this;
                super(null);
                e = jsonobject;
            }
        }

    }

}
