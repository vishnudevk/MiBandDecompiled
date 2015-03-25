// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.util.Log;

public class Patcher
{

    private static final String a = "MarketPatcher";
    private static final String b = "sdk_patcher_jni";

    public Patcher()
    {
    }

    public static int a(String s, String s1, String s2)
    {
        return (new Patcher()).applyPatch(s, s1, s2);
    }

    public static boolean o()
    {
        try
        {
            System.loadLibrary("sdk_patcher_jni");
        }
        catch (Throwable throwable)
        {
            Log.e("MarketPatcher", (new StringBuilder("load patcher library failed : ")).append(throwable.toString()).toString());
            return false;
        }
        return true;
    }

    public native int applyPatch(String s, String s1, String s2);
}
