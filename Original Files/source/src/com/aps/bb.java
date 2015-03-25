// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;


public final class bb
{

    protected static final String a[] = {
        "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE"
    };

    protected static boolean a(String as[], String s)
    {
        boolean flag = false;
        if (as == null) goto _L2; else goto _L1
_L1:
        flag = false;
        if (s == null) goto _L2; else goto _L3
_L3:
        int i = 0;
_L8:
        int j;
        j = as.length;
        flag = false;
        if (i >= j) goto _L2; else goto _L4
_L4:
        if (!as[i].equals(s)) goto _L6; else goto _L5
_L5:
        flag = true;
_L2:
        return flag;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

}
