// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package android.support.v4.net:
//            e, d, c, a, 
//            b

public class ConnectivityManagerCompat
{

    private static final b a;

    public ConnectivityManagerCompat()
    {
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager connectivitymanager, Intent intent)
    {
        return connectivitymanager.getNetworkInfo(((NetworkInfo)intent.getParcelableExtra("networkInfo")).getType());
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivitymanager)
    {
        return a.a(connectivitymanager);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new e();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            a = new d();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            a = new c();
        } else
        {
            a = new a();
        }
    }
}
