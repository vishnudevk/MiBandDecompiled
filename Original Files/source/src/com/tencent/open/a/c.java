// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class c
{

    static String a = null;
    private static String b = null;

    public c()
    {
    }

    public static String a(Context context)
    {
        if (a != null && a.length() > 0)
        {
            return a;
        }
        if (context == null)
        {
            return "";
        }
        String s;
        try
        {
            s = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
        }
        catch (Exception exception)
        {
            return "";
        }
        return s;
    }

    public static String b(Context context)
    {
        String s;
        try
        {
            if (b == null)
            {
                WindowManager windowmanager = (WindowManager)context.getSystemService("window");
                DisplayMetrics displaymetrics = new DisplayMetrics();
                windowmanager.getDefaultDisplay().getMetrics(displaymetrics);
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append("imei=").append(a(context)).append('&');
                stringbuilder.append("model=").append(Build.MODEL).append('&');
                stringbuilder.append("os=").append(android.os.Build.VERSION.RELEASE).append('&');
                stringbuilder.append("apilevel=").append(android.os.Build.VERSION.SDK_INT).append('&');
                stringbuilder.append("display=").append(displaymetrics.widthPixels).append('*').append(displaymetrics.heightPixels).append('&');
                stringbuilder.append("manu=").append(Build.MANUFACTURER).append("&");
                b = stringbuilder.toString();
            }
            s = b;
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

    public static String c(Context context)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivitymanager == null)
        {
            return "MOBILE";
        }
        NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
        if (networkinfo != null)
        {
            return networkinfo.getTypeName();
        } else
        {
            return "MOBILE";
        }
    }

}
