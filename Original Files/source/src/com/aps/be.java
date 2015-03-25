// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import android.content.Context;
import android.util.Log;

public final class be
{

    private static String a = "";

    protected static void a(String s)
    {
        if (!s.equals("GPS_SATELLITE"));
    }

    protected static boolean a(Context context)
    {
        if (context != null)
        {
            a = context.getPackageName();
            return true;
        } else
        {
            Log.d(a, "Error: No SD Card!");
            return false;
        }
    }

}
