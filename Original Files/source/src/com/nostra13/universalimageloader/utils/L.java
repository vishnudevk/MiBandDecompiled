// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;

public final class L
{

    private static final String a = "%1$s\n%2$s";
    private static volatile boolean b = false;
    private static volatile boolean c = true;

    private L()
    {
    }

    private static transient void a(int j, Throwable throwable, String s, Object aobj[])
    {
        if (!c)
        {
            return;
        }
        String s1;
        if (aobj.length > 0)
        {
            s1 = String.format(s, aobj);
        } else
        {
            s1 = s;
        }
        if (throwable != null)
        {
            if (s1 == null)
            {
                s1 = throwable.getMessage();
            }
            s1 = String.format("%1$s\n%2$s", new Object[] {
                s1, Log.getStackTraceString(throwable)
            });
        }
        Log.println(j, ImageLoader.TAG, s1);
    }

    public static transient void d(String s, Object aobj[])
    {
        if (b)
        {
            a(3, null, s, aobj);
        }
    }

    public static void disableLogging()
    {
        writeLogs(false);
    }

    public static transient void e(String s, Object aobj[])
    {
        a(6, null, s, aobj);
    }

    public static void e(Throwable throwable)
    {
        a(6, throwable, null, new Object[0]);
    }

    public static transient void e(Throwable throwable, String s, Object aobj[])
    {
        a(6, throwable, s, aobj);
    }

    public static void enableLogging()
    {
        writeLogs(true);
    }

    public static transient void i(String s, Object aobj[])
    {
        a(4, null, s, aobj);
    }

    public static transient void w(String s, Object aobj[])
    {
        a(5, null, s, aobj);
    }

    public static void writeDebugLogs(boolean flag)
    {
        b = flag;
    }

    public static void writeLogs(boolean flag)
    {
        c = flag;
    }

}
