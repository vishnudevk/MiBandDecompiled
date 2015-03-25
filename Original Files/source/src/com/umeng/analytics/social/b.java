// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;

import android.util.Log;

// Referenced classes of package com.umeng.analytics.social:
//            e

public class b
{

    public b()
    {
    }

    public static void a(String s, String s1)
    {
        if (e.v)
        {
            Log.i(s, s1);
        }
    }

    public static void a(String s, String s1, Exception exception)
    {
        if (e.v)
        {
            Log.i(s, (new StringBuilder(String.valueOf(exception.toString()))).append(":  [").append(s1).append("]").toString());
        }
    }

    public static void b(String s, String s1)
    {
        if (e.v)
        {
            Log.e(s, s1);
        }
    }

    public static void b(String s, String s1, Exception exception)
    {
        if (!e.v) goto _L2; else goto _L1
_L1:
        StackTraceElement astacktraceelement[];
        int i;
        int j;
        Log.e(s, (new StringBuilder(String.valueOf(exception.toString()))).append(":  [").append(s1).append("]").toString());
        astacktraceelement = exception.getStackTrace();
        i = astacktraceelement.length;
        j = 0;
_L5:
        if (j < i) goto _L3; else goto _L2
_L2:
        return;
_L3:
        StackTraceElement stacktraceelement = astacktraceelement[j];
        Log.e(s, (new StringBuilder("        at\t ")).append(stacktraceelement.toString()).toString());
        j++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static void c(String s, String s1)
    {
        if (e.v)
        {
            Log.d(s, s1);
        }
    }

    public static void c(String s, String s1, Exception exception)
    {
        if (e.v)
        {
            Log.d(s, (new StringBuilder(String.valueOf(exception.toString()))).append(":  [").append(s1).append("]").toString());
        }
    }

    public static void d(String s, String s1)
    {
        if (e.v)
        {
            Log.v(s, s1);
        }
    }

    public static void d(String s, String s1, Exception exception)
    {
        if (e.v)
        {
            Log.v(s, (new StringBuilder(String.valueOf(exception.toString()))).append(":  [").append(s1).append("]").toString());
        }
    }

    public static void e(String s, String s1)
    {
        if (e.v)
        {
            Log.w(s, s1);
        }
    }

    public static void e(String s, String s1, Exception exception)
    {
        if (!e.v) goto _L2; else goto _L1
_L1:
        StackTraceElement astacktraceelement[];
        int i;
        int j;
        Log.w(s, (new StringBuilder(String.valueOf(exception.toString()))).append(":  [").append(s1).append("]").toString());
        astacktraceelement = exception.getStackTrace();
        i = astacktraceelement.length;
        j = 0;
_L5:
        if (j < i) goto _L3; else goto _L2
_L2:
        return;
_L3:
        StackTraceElement stacktraceelement = astacktraceelement[j];
        Log.w(s, (new StringBuilder("        at\t ")).append(stacktraceelement.toString()).toString());
        j++;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
