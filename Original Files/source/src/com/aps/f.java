// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import android.util.SparseArray;

public class f
{

    static String a = null;
    static String b = null;
    static String c = null;
    static String d = "";
    static String e = "";
    static String f = "";
    static boolean g = false;
    static boolean h = true;
    static long i = 10000L;
    static long j = 30000L;
    static boolean k = true;
    static final SparseArray l;
    static final String m[] = {
        "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE"
    };

    private f()
    {
    }

    static void a(String s)
    {
        d = s;
    }

    static void a(boolean flag)
    {
        g = flag;
    }

    static void b(String s)
    {
        e = s;
    }

    static void c(String s)
    {
        f = s;
    }

    static 
    {
        l = new SparseArray();
        l.append(0, "UNKNOWN");
        l.append(1, "GPRS");
        l.append(2, "EDGE");
        l.append(3, "UMTS");
        l.append(4, "CDMA");
        l.append(5, "EVDO_0");
        l.append(6, "EVDO_A");
        l.append(7, "1xRTT");
        l.append(8, "HSDPA");
        l.append(9, "HSUPA");
        l.append(10, "HSPA");
        l.append(11, "IDEN");
        l.append(12, "EVDO_B");
        l.append(13, "LTE");
        l.append(14, "EHRPD");
        l.append(15, "HSPAP");
    }
}
