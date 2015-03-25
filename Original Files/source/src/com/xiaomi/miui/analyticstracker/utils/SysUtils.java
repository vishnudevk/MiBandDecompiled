// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public class SysUtils
{

    public SysUtils()
    {
    }

    public static String getAppPackageName(Context context)
    {
        return context.getApplicationInfo().packageName;
    }

    public static String getAppVersion(Context context)
    {
        String s;
        try
        {
            s = context.getPackageManager().getPackageInfo(getAppPackageName(context), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return "unknown";
        }
        return s;
    }

    public static String getIMEI(Context context)
    {
        String s = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
        if (TextUtils.isEmpty(s))
        {
            s = "null";
        }
        return s;
    }

    public static String getModel(Context context)
    {
        return Build.MODEL;
    }

    public static String getRomVersion(Context context)
    {
        return android.os.Build.VERSION.INCREMENTAL;
    }

    public static boolean isWifiConnected(Context context)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
        return networkinfo != null && !connectivitymanager.isActiveNetworkMetered() && networkinfo.isConnected();
    }
}
