// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.internal;

import android.util.Log;

public class Utils
{

    static final String a = "PullToRefresh";

    public Utils()
    {
    }

    public static void warnDeprecation(String s, String s1)
    {
        Log.w("PullToRefresh", (new StringBuilder()).append("You're using the deprecated ").append(s).append(" attr, please switch over to ").append(s1).toString());
    }
}
