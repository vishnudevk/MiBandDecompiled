// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Field;

public class s
{

    static final String a = "MarketSdkUtils";
    static boolean b = false;
    protected static final int bd = 0xf4240;
    protected static final int be = 1000;
    static boolean c;

    public s()
    {
    }

    static int a(String s1, String s2, String s3)
    {
        Class aclass[] = Class.forName((new StringBuilder(String.valueOf(s1))).append(".R").toString()).getClasses();
        int j = 0;
_L3:
        int k = aclass.length;
        Class class1 = null;
        if (j < k) goto _L2; else goto _L1
_L1:
        if (class1 != null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        if (b)
        {
            Log.d("MarketSdkUtils", "[get resource id] : return id from R$class");
        }
        class1 = Class.forName((new StringBuilder(String.valueOf(s1))).append(".R$").append(s2).toString());
        int i;
        i = 0;
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        int l = class1.getField(s3).getInt(class1);
        i = l;
_L4:
        if (b)
        {
            Log.d("MarketSdkUtils", (new StringBuilder("[get resource id] : id = ")).append(i).toString());
        }
        return i;
_L2:
label0:
        {
            if (!aclass[j].getName().split("\\$")[1].equals(s2))
            {
                break label0;
            }
            class1 = aclass[j];
        }
          goto _L1
        j++;
          goto _L3
        Exception exception;
        exception;
        Log.e("MarketSdkUtils", (new StringBuilder("[get resource id] : id = ")).append(0).append("\nerror: ").append(exception.toString()).toString());
        i = 0;
          goto _L4
    }

    public static String a(long l, Context context)
    {
        if (l < 0L)
        {
            return "";
        }
        String s1;
        int i;
        if (l > 0xf4240L)
        {
            Object aobj1[] = new Object[1];
            aobj1[0] = Double.valueOf((1.0D * (double)l) / 1000000D);
            s1 = String.format("%.1f", aobj1);
            i = a(context.getPackageName(), "string", "xiaomi_megabytes_unit");
        } else
        if (l > 1000L)
        {
            Object aobj[] = new Object[1];
            aobj[0] = Double.valueOf((1.0D * (double)l) / 1000D);
            s1 = String.format("%.1f", aobj);
            i = a(context.getPackageName(), "string", "xiaomi_kilobytes_unit");
        } else
        {
            s1 = String.valueOf(l);
            i = a(context.getPackageName(), "string", "xiaomi_bytes_unit");
        }
        return context.getString(i, new Object[] {
            s1
        });
    }

    static boolean a(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        int i;
        int j;
        boolean flag;
        try
        {
            i = packagemanager.getPackageInfo("com.miui.cloudservice", 0).applicationInfo.flags;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return false;
        }
        j = i & 1;
        flag = false;
        if (j != 0)
        {
            flag = true;
        }
        return flag;
    }

    static boolean a(boolean flag)
    {
        for (String s1 = Environment.getExternalStorageState(); "mounted".equals(s1) || "mounted_ro".equals(s1) && !flag;)
        {
            return true;
        }

        return false;
    }

    static boolean b(Context context)
    {
        try
        {
            context.getPackageManager().getPackageInfo("com.xiaomi.market", 1);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return false;
        }
        return true;
    }

    static boolean c(Context context)
    {
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnectedOrConnecting();
    }

    static boolean d(Context context)
    {
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.getType() == 1;
    }

    static boolean e(Context context)
    {
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.getType() == 0;
    }

    static 
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (!(new File("/sdcard/com.xiaomi.market.sdk/sdk_debug")).exists())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        b = flag;
        flag1 = (new File("/sdcard/com.xiaomi.market.sdk/sdk_staging")).exists();
        flag2 = false;
        if (flag1)
        {
            flag2 = true;
        }
        c = flag2;
    }
}
