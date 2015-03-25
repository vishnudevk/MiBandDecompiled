// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import java.io.File;

// Referenced classes of package com.xiaomi.market.sdk:
//            q, b, j, t, 
//            w, XiaomiUpdateListener

public class XiaomiUpdateAgent
{

    private static final String a = "MarketUpdateAgent";
    private static Context b;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static q f;
    private static w g;
    private static XiaomiUpdateListener h;
    private static final int i = 0;
    private static final int j = 1;

    public XiaomiUpdateAgent()
    {
    }

    static Context a()
    {
        return b;
    }

    static q a(Context context)
    {
        q q1;
        PackageManager packagemanager;
        q1 = q.h(context.getPackageName());
        packagemanager = context.getPackageManager();
        PackageInfo packageinfo1 = packagemanager.getPackageInfo(q1.packageName, 64);
        PackageInfo packageinfo = packageinfo1;
_L1:
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        if (packageinfo != null && packageinfo.applicationInfo != null)
        {
            q1.aU = packagemanager.getApplicationLabel(packageinfo.applicationInfo).toString();
            q1.versionCode = packageinfo.versionCode;
            q1.versionName = packageinfo.versionName;
            q1.aV = com.xiaomi.market.sdk.b.a(String.valueOf(packageinfo.signatures[0].toChars()));
            q1.sourceDir = packageinfo.applicationInfo.sourceDir;
            q1.aW = com.xiaomi.market.sdk.b.a(new File(q1.sourceDir));
            return q1;
        } else
        {
            return null;
        }
        namenotfoundexception;
        Log.e("MarketUpdateAgent", "get package info failed");
        packageinfo = null;
          goto _L1
    }

    static void a(q q1)
    {
        f = q1;
    }

    static void a(w w)
    {
        g = w;
    }

    static void a(boolean flag)
    {
        e = flag;
    }

    static Context b()
    {
        return b;
    }

    static q c()
    {
        return f;
    }

    static boolean d()
    {
        return e;
    }

    static boolean e()
    {
        return d;
    }

    static w f()
    {
        return g;
    }

    static boolean g()
    {
        return c;
    }

    public static int getSDKVersion()
    {
        return 0;
    }

    static XiaomiUpdateListener h()
    {
        return h;
    }

    public static void setCheckUpdateOnlyWifi(boolean flag)
    {
        d = flag;
    }

    public static void setUpdateAutoPopup(boolean flag)
    {
        c = flag;
    }

    public static void setUpdateListener(XiaomiUpdateListener xiaomiupdatelistener)
    {
        h = xiaomiupdatelistener;
    }

    public static void update(Context context)
    {
        if (context == null)
        {
            return;
        } else
        {
            b = context;
            com.xiaomi.market.sdk.j.k();
            (new t(null)).execute(new Void[0]);
            return;
        }
    }

    static 
    {
        c = true;
        d = false;
        e = false;
    }
}
