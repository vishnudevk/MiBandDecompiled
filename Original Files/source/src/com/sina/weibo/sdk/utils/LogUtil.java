// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.util.Log;

public class LogUtil
{

    private static boolean sIsLogEnable = true;

    public LogUtil()
    {
    }

    public static void d(String s, String s1)
    {
        if (sIsLogEnable)
        {
            StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
            Log.d(s, (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(stacktraceelement.getFileName()))).append("(").append(stacktraceelement.getLineNumber()).append(") ").append(stacktraceelement.getMethodName()).toString()))).append(": ").append(s1).toString());
        }
    }

    public static void disableLog()
    {
        sIsLogEnable = false;
    }

    public static void e(String s, String s1)
    {
        if (sIsLogEnable)
        {
            StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
            Log.e(s, (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(stacktraceelement.getFileName()))).append("(").append(stacktraceelement.getLineNumber()).append(") ").append(stacktraceelement.getMethodName()).toString()))).append(": ").append(s1).toString());
        }
    }

    public static void enableLog()
    {
        sIsLogEnable = true;
    }

    public static String getStackTraceMsg()
    {
        StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
        return (new StringBuilder(String.valueOf(stacktraceelement.getFileName()))).append("(").append(stacktraceelement.getLineNumber()).append(") ").append(stacktraceelement.getMethodName()).toString();
    }

    public static void i(String s, String s1)
    {
        if (sIsLogEnable)
        {
            StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
            Log.i(s, (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(stacktraceelement.getFileName()))).append("(").append(stacktraceelement.getLineNumber()).append(") ").append(stacktraceelement.getMethodName()).toString()))).append(": ").append(s1).toString());
        }
    }

    public static void v(String s, String s1)
    {
        if (sIsLogEnable)
        {
            StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
            Log.v(s, (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(stacktraceelement.getFileName()))).append("(").append(stacktraceelement.getLineNumber()).append(") ").append(stacktraceelement.getMethodName()).toString()))).append(": ").append(s1).toString());
        }
    }

    public static void w(String s, String s1)
    {
        if (sIsLogEnable)
        {
            StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[3];
            Log.w(s, (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(stacktraceelement.getFileName()))).append("(").append(stacktraceelement.getLineNumber()).append(") ").append(stacktraceelement.getMethodName()).toString()))).append(": ").append(s1).toString());
        }
    }

}
