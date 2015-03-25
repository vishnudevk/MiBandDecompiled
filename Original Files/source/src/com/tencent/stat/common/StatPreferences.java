// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class StatPreferences
{

    private static SharedPreferences a = null;

    static SharedPreferences a(Context context)
    {
        if (a == null)
        {
            a = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return a;
    }

    public static long getLong(Context context, String s, long l)
    {
        String s1 = (new StringBuilder()).append("").append(s).toString();
        return a(context).getLong(s1, l);
    }

    public static String getString(Context context, String s, String s1)
    {
        String s2 = (new StringBuilder()).append("").append(s).toString();
        return a(context).getString(s2, s1);
    }

    public static void putLong(Context context, String s, long l)
    {
        String s1 = (new StringBuilder()).append("").append(s).toString();
        android.content.SharedPreferences.Editor editor = a(context).edit();
        editor.putLong(s1, l);
        editor.commit();
    }

    public static void putString(Context context, String s, String s1)
    {
        String s2 = (new StringBuilder()).append("").append(s).toString();
        android.content.SharedPreferences.Editor editor = a(context).edit();
        editor.putString(s2, s1);
        editor.commit();
    }

}
