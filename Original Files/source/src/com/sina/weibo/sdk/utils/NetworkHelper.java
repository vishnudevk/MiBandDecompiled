// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.List;

public class NetworkHelper
{

    public NetworkHelper()
    {
    }

    public static void clearCookies(Context context, String s)
    {
        CookieSyncManager.createInstance(context);
        CookieManager cookiemanager = CookieManager.getInstance();
        cookiemanager.setAcceptCookie(true);
        cookiemanager.removeSessionCookie();
        cookiemanager.removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    public static NetworkInfo getActiveNetworkInfo(Context context)
    {
        return ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static NetworkInfo getNetworkInfo(Context context, int i)
    {
        return ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(i);
    }

    public static int getNetworkType(Context context)
    {
        NetworkInfo networkinfo;
label0:
        {
            if (context != null)
            {
                networkinfo = getActiveNetworkInfo(context);
                if (networkinfo != null)
                {
                    break label0;
                }
            }
            return -1;
        }
        return networkinfo.getType();
    }

    public static android.net.NetworkInfo.DetailedState getWifiConnectivityState(Context context)
    {
        NetworkInfo networkinfo = getNetworkInfo(context, 1);
        if (networkinfo == null)
        {
            return android.net.NetworkInfo.DetailedState.FAILED;
        } else
        {
            return networkinfo.getDetailedState();
        }
    }

    public static int getWifiState(Context context)
    {
        WifiManager wifimanager = (WifiManager)context.getSystemService("wifi");
        if (wifimanager == null)
        {
            return 4;
        } else
        {
            return wifimanager.getWifiState();
        }
    }

    public static boolean hasInternetPermission(Context context)
    {
        return context == null || context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }

    public static boolean isMobileNetwork(Context context)
    {
        NetworkInfo networkinfo;
        if (context != null)
        {
            networkinfo = getActiveNetworkInfo(context);
            break MISSING_BLOCK_LABEL_9;
        }
        do
        {
            return false;
        } while (networkinfo == null || networkinfo == null || networkinfo.getType() != 0 || !networkinfo.isConnected());
        return true;
    }

    public static boolean isNetworkAvailable(Context context)
    {
        boolean flag = false;
        if (context != null)
        {
            NetworkInfo networkinfo = getActiveNetworkInfo(context);
            flag = false;
            if (networkinfo != null)
            {
                boolean flag1 = networkinfo.isConnected();
                flag = false;
                if (flag1)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public static boolean isWifiValid(Context context)
    {
        if (context != null)
        {
            NetworkInfo networkinfo = getActiveNetworkInfo(context);
            return networkinfo != null && 1 == networkinfo.getType() && networkinfo.isConnected();
        } else
        {
            return false;
        }
    }

    public static boolean wifiConnection(Context context, String s, String s1)
    {
        WifiManager wifimanager;
        String s2;
        List list;
        wifimanager = (WifiManager)context.getSystemService("wifi");
        s2 = (new StringBuilder("\"")).append(s).append("\"").toString();
        WifiInfo wifiinfo = wifimanager.getConnectionInfo();
        if (wifiinfo != null && (s.equals(wifiinfo.getSSID()) || s2.equals(wifiinfo.getSSID())))
        {
            return true;
        }
        list = wifimanager.getScanResults();
        if (list == null || list.size() == 0) goto _L2; else goto _L1
_L1:
        int i = -1 + list.size();
_L5:
        if (i >= 0) goto _L3; else goto _L2
_L2:
        return false;
_L3:
        String s3 = ((ScanResult)list.get(i)).SSID;
        if (s.equals(s3) || s2.equals(s3))
        {
            WifiConfiguration wificonfiguration = new WifiConfiguration();
            wificonfiguration.SSID = s2;
            wificonfiguration.preSharedKey = (new StringBuilder("\"")).append(s1).append("\"").toString();
            wificonfiguration.status = 2;
            return wifimanager.enableNetwork(wifimanager.addNetwork(wificonfiguration), false);
        }
        i--;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
