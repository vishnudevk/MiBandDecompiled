// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import android.util.Log;

public class DaoLog
{

    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final String TAG = "greenDAO";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    public DaoLog()
    {
    }

    public static int d(String s)
    {
        return Log.d("greenDAO", s);
    }

    public static int d(String s, Throwable throwable)
    {
        return Log.d("greenDAO", s, throwable);
    }

    public static int e(String s)
    {
        return Log.w("greenDAO", s);
    }

    public static int e(String s, Throwable throwable)
    {
        return Log.e("greenDAO", s, throwable);
    }

    public static String getStackTraceString(Throwable throwable)
    {
        return Log.getStackTraceString(throwable);
    }

    public static int i(String s)
    {
        return Log.i("greenDAO", s);
    }

    public static int i(String s, Throwable throwable)
    {
        return Log.i("greenDAO", s, throwable);
    }

    public static boolean isLoggable(int j)
    {
        return Log.isLoggable("greenDAO", j);
    }

    public static int println(int j, String s)
    {
        return Log.println(j, "greenDAO", s);
    }

    public static int v(String s)
    {
        return Log.v("greenDAO", s);
    }

    public static int v(String s, Throwable throwable)
    {
        return Log.v("greenDAO", s, throwable);
    }

    public static int w(String s)
    {
        return Log.w("greenDAO", s);
    }

    public static int w(String s, Throwable throwable)
    {
        return Log.w("greenDAO", s, throwable);
    }

    public static int w(Throwable throwable)
    {
        return Log.w("greenDAO", throwable);
    }
}
