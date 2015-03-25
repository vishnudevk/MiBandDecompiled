// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics;

import android.content.Context;
import u.aly.bi;

// Referenced classes of package com.umeng.analytics:
//            g, Gender

public class AnalyticsConfig
{

    public static boolean ACTIVITY_DURATION_OPEN = true;
    public static boolean CATCH_EXCEPTION = true;
    public static boolean COMPRESS_DATA = true;
    public static boolean ENABLE_MEMORY_BUFFER = true;
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static boolean UPDATE_IN_MAIN_PROCESS = true;
    private static String a = null;
    private static String b = null;
    private static double c[] = null;
    private static int d[];
    public static long kContinueSessionMillis = 30000L;
    public static int mVerticalType;
    public static String mWrapperType = null;
    public static String mWrapperVersion = null;
    public static int sAge;
    public static Gender sGender;
    public static String sId;
    public static String sSource;

    public AnalyticsConfig()
    {
    }

    public static String getAppkey(Context context)
    {
        if (a == null)
        {
            a = bi.o(context);
        }
        return a;
    }

    public static String getChannel(Context context)
    {
        if (b == null)
        {
            b = bi.t(context);
        }
        return b;
    }

    public static double[] getLocation()
    {
        return c;
    }

    public static int[] getReportPolicy(Context context)
    {
        if (d == null)
        {
            d = g.a(context).a();
        }
        return d;
    }

    public static void setAppkey(String s)
    {
        a = s;
    }

    public static void setChannel(String s)
    {
        b = s;
    }

    public static void setLocation(double d1, double d2)
    {
        if (c == null)
        {
            c = new double[2];
        }
        c[0] = d1;
        c[1] = d2;
    }

    public static void setReportPolicy(int i, int j)
    {
        if (d == null)
        {
            d = new int[2];
        }
        d[0] = i;
        d[1] = j;
    }

}
