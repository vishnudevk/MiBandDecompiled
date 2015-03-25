// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.game;

import android.content.Context;
import com.umeng.analytics.Gender;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMSocialService;
import com.umeng.analytics.social.e;
import u.aly.bj;

// Referenced classes of package com.umeng.analytics.game:
//            d

public class UMGameAgent extends MobclickAgent
{

    private static final String a = "Input string is null or empty";
    private static final String b = "Input string must be less than 64 chars";
    private static final String c = "Input value type is negative";
    private static final String d = "The int value for 'Pay Channels' ranges between 1 ~ 99 ";
    private static final d e = new d();
    private static Context f;

    public UMGameAgent()
    {
    }

    private static boolean a(String s)
    {
        while (s == null || s.trim().length() <= 0) 
        {
            return true;
        }
        return false;
    }

    public static void bonus(double d1, int i)
    {
        if (d1 < 0.0D)
        {
            bj.b("MobclickAgent", "Input value type is negative");
            return;
        }
        if (i <= 0 || i >= 100)
        {
            bj.b("MobclickAgent", "The int value for 'Pay Channels' ranges between 1 ~ 99 ");
            return;
        } else
        {
            e.a(d1, i);
            return;
        }
    }

    public static void bonus(String s, int i, double d1, int j)
    {
        if (a(s))
        {
            bj.b("MobclickAgent", "Input string is null or empty");
            return;
        }
        if (i < 0 || d1 < 0.0D)
        {
            bj.b("MobclickAgent", "Input value type is negative");
            return;
        }
        if (j <= 0 || j >= 100)
        {
            bj.b("MobclickAgent", "The int value for 'Pay Channels' ranges between 1 ~ 99 ");
            return;
        } else
        {
            e.a(s, i, d1, j);
            return;
        }
    }

    public static void buy(String s, int i, double d1)
    {
        if (a(s))
        {
            bj.b("MobclickAgent", "Input string is null or empty");
            return;
        }
        if (i < 0 || d1 < 0.0D)
        {
            bj.b("MobclickAgent", "Input value type is negative");
            return;
        } else
        {
            e.a(s, i, d1);
            return;
        }
    }

    public static void failLevel(String s)
    {
        if (a(s))
        {
            bj.b("MobclickAgent", "Input string is null or empty");
            return;
        }
        if (s.length() > 64)
        {
            bj.b("MobclickAgent", "Input string must be less than 64 chars");
            return;
        } else
        {
            e.d(s);
            return;
        }
    }

    public static void finishLevel(String s)
    {
        if (a(s))
        {
            bj.b("MobclickAgent", "Input string is null or empty");
            return;
        }
        if (s.length() > 64)
        {
            bj.b("MobclickAgent", "Input string must be less than 64 chars");
            return;
        } else
        {
            e.c(s);
            return;
        }
    }

    public static void init(Context context)
    {
        e.a(context);
        f = context.getApplicationContext();
    }

    public static void onEvent(String s, String s1)
    {
        onEvent(f, s, s1);
    }

    public static transient void onSocialEvent(Context context, String s, UMPlatformData aumplatformdata[])
    {
        if (context == null)
        {
            bj.b("MobclickAgent", "context is null in onShareEvent");
            return;
        } else
        {
            e.e = "4";
            UMSocialService.share(context, s, aumplatformdata);
            return;
        }
    }

    public static transient void onSocialEvent(Context context, UMPlatformData aumplatformdata[])
    {
        if (context == null)
        {
            bj.b("MobclickAgent", "context is null in onShareEvent");
            return;
        } else
        {
            e.e = "4";
            UMSocialService.share(context, aumplatformdata);
            return;
        }
    }

    public static void pay(double d1, double d2, int i)
    {
        if (i <= 0 || i >= 100)
        {
            bj.b("MobclickAgent", "The int value for 'Pay Channels' ranges between 1 ~ 99 ");
            return;
        }
        if (d1 < 0.0D || d2 < 0.0D)
        {
            bj.b("MobclickAgent", "Input value type is negative");
            return;
        } else
        {
            e.a(d1, d2, i);
            return;
        }
    }

    public static void pay(double d1, String s, int i, double d2, int j)
    {
        if (j <= 0 || j >= 100)
        {
            bj.b("MobclickAgent", "The int value for 'Pay Channels' ranges between 1 ~ 99 ");
            return;
        }
        if (d1 < 0.0D || i < 0 || d2 < 0.0D)
        {
            bj.b("MobclickAgent", "Input value type is negative");
            return;
        }
        if (a(s))
        {
            bj.b("MobclickAgent", "Input string is null or empty");
            return;
        } else
        {
            e.a(d1, s, i, d2, j);
            return;
        }
    }

    public static void setPlayerInfo(String s, int i, int j, String s1)
    {
        if (a(s))
        {
            bj.b("MobclickAgent", "Input string is null or empty");
            s = null;
        }
        if (i < 0 || i > 200)
        {
            bj.c("MobclickAgent", "The int value for 'Age' range between 0~200");
            i = 0;
        }
        if (a(s1))
        {
            bj.b("MobclickAgent", "Input string is null or empty");
            s1 = null;
        }
        e.a(s, i, Gender.getGender(j), s1);
    }

    public static void setPlayerLevel(String s)
    {
        if (a(s))
        {
            bj.b("MobclickAgent", "Input string is null or empty");
            return;
        }
        if (s.length() > 64)
        {
            bj.b("MobclickAgent", "Input string must be less than 64 chars");
            return;
        } else
        {
            e.a(s);
            return;
        }
    }

    public static void setTraceSleepTime(boolean flag)
    {
        e.a(flag);
    }

    public static void startLevel(String s)
    {
        if (a(s))
        {
            bj.b("MobclickAgent", "Input string is null or empty");
            return;
        }
        if (s.length() > 64)
        {
            bj.b("MobclickAgent", "Input string must be less than 64 chars");
            return;
        } else
        {
            e.b(s);
            return;
        }
    }

    public static void use(String s, int i, double d1)
    {
        if (a(s))
        {
            bj.b("MobclickAgent", "Input string is null or empty");
            return;
        }
        if (i < 0 || d1 < 0.0D)
        {
            bj.b("MobclickAgent", "Input value type is negative");
            return;
        } else
        {
            e.b(s, i, d1);
            return;
        }
    }

}
