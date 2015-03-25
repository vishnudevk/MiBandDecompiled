// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.game;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.Gender;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.c;
import com.umeng.analytics.e;
import java.util.HashMap;
import u.aly.bj;

// Referenced classes of package com.umeng.analytics.game:
//            a, f, b, e

class d
    implements c
{

    private com.umeng.analytics.d a;
    private b b;
    private final int c = 100;
    private final int d = 1;
    private final int e = 0;
    private final int f = -1;
    private final int g = 1;
    private final String h = "level";
    private final String i = "pay";
    private final String j = "buy";
    private final String k = "use";
    private final String l = "bonus";
    private final String m = "item";
    private final String n = "cash";
    private final String o = "coin";
    private final String p = "source";
    private final String q = "amount";
    private final String r = "user_level";
    private final String s = "bonus_source";
    private final String t = "level";
    private final String u = "status";
    private final String v = "duration";
    private final String w = "UMGameAgent.init(Context) should be called before any game api";
    private Context x;

    public d()
    {
        a = MobclickAgent.getAgent();
        b = null;
        a.a(1);
        a.a = true;
    }

    static b a(d d1)
    {
        return d1.b;
    }

    private void a(String s1, int i1)
    {
        if (x == null)
        {
            bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
            return;
        } else
        {
            com.umeng.analytics.e.a(new f(this, s1, i1));
            return;
        }
    }

    static com.umeng.analytics.d b(d d1)
    {
        return d1.a;
    }

    static Context c(d d1)
    {
        return d1.x;
    }

    public void a()
    {
        bj.c("MobclickAgent", "App resume from background");
        if (x == null)
        {
            bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
        } else
        if (a.a)
        {
            b.b();
            return;
        }
    }

    void a(double d1, double d2, int i1)
    {
        if (x == null)
        {
            bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashmap = new HashMap();
        hashmap.put("cash", Long.valueOf((long)(d1 * 100D)));
        hashmap.put("coin", Long.valueOf((long)(d2 * 100D)));
        hashmap.put("source", Integer.valueOf(i1));
        if (b.b != null)
        {
            hashmap.put("user_level", b.b);
        }
        if (b.a != null)
        {
            hashmap.put("level", b.a);
        }
        a.a(x, "pay", hashmap);
    }

    void a(double d1, int i1)
    {
        if (x == null)
        {
            bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashmap = new HashMap();
        hashmap.put("coin", Long.valueOf((long)(100D * d1)));
        hashmap.put("bonus_source", Integer.valueOf(i1));
        if (b.b != null)
        {
            hashmap.put("user_level", b.b);
        }
        if (b.a != null)
        {
            hashmap.put("level", b.a);
        }
        a.a(x, "bonus", hashmap);
    }

    void a(double d1, String s1, int i1, double d2, int j1)
    {
        a(d1, d2 * (double)i1, j1);
        a(s1, i1, d2);
    }

    void a(Context context)
    {
        if (context == null)
        {
            bj.b("MobclickAgent", "Context is null, can't init GameAgent");
            return;
        } else
        {
            x = context.getApplicationContext();
            a.a(this);
            b = new b(x);
            return;
        }
    }

    void a(String s1)
    {
        b.b = s1;
    }

    void a(String s1, int i1, double d1)
    {
        if (x == null)
        {
            bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashmap = new HashMap();
        hashmap.put("item", s1);
        hashmap.put("amount", Integer.valueOf(i1));
        hashmap.put("coin", Long.valueOf((long)(100D * (d1 * (double)i1))));
        if (b.b != null)
        {
            hashmap.put("user_level", b.b);
        }
        if (b.a != null)
        {
            hashmap.put("level", b.a);
        }
        a.a(x, "buy", hashmap);
    }

    void a(String s1, int i1, double d1, int j1)
    {
        a(d1 * (double)i1, j1);
        a(s1, i1, d1);
    }

    void a(String s1, int i1, Gender gender, String s2)
    {
        AnalyticsConfig.sId = s1;
        AnalyticsConfig.sAge = i1;
        AnalyticsConfig.sGender = gender;
        AnalyticsConfig.sSource = s2;
    }

    void a(boolean flag)
    {
        Object aobj[] = new Object[1];
        aobj[0] = Boolean.valueOf(flag);
        bj.c("MobclickAgent", String.format("Trace sleep time : %b", aobj));
        a.a = flag;
    }

    public void b()
    {
        if (x == null)
        {
            bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
        } else
        if (a.a)
        {
            b.a();
            return;
        }
    }

    void b(String s1)
    {
        if (x == null)
        {
            bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
            return;
        } else
        {
            b.a = s1;
            com.umeng.analytics.e.a(new com.umeng.analytics.game.e(this, s1));
            return;
        }
    }

    void b(String s1, int i1, double d1)
    {
        if (x == null)
        {
            bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashmap = new HashMap();
        hashmap.put("item", s1);
        hashmap.put("amount", Integer.valueOf(i1));
        hashmap.put("coin", Long.valueOf((long)(100D * (d1 * (double)i1))));
        if (b.b != null)
        {
            hashmap.put("user_level", b.b);
        }
        if (b.a != null)
        {
            hashmap.put("level", b.a);
        }
        a.a(x, "use", hashmap);
    }

    void c(String s1)
    {
        if (x == null)
        {
            bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
            return;
        } else
        {
            a(s1, 1);
            return;
        }
    }

    void d(String s1)
    {
        if (x == null)
        {
            bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
            return;
        } else
        {
            a(s1, -1);
            return;
        }
    }
}
