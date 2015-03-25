// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class t
{

    private static t b;
    private Context a;

    private t()
    {
    }

    public static t a()
    {
        if (b == null)
        {
            b = new t();
        }
        return b;
    }

    public static Context b()
    {
        return a().a;
    }

    public static boolean c()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)a().a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        int i = networkinfo.getType();
        if (i == 1)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_35;
        Exception exception;
        exception;
        return false;
    }

    public static boolean d()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)a().a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        boolean flag = networkinfo.isAvailable();
        return flag;
        Exception exception;
        exception;
        return false;
    }

    public final void a(Context context)
    {
        if (a == null)
        {
            a = context.getApplicationContext();
        }
    }
}
