// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.net;

import android.net.ConnectivityManager;

class h
{

    h()
    {
    }

    public static boolean a(ConnectivityManager connectivitymanager)
    {
        return connectivitymanager.isActiveNetworkMetered();
    }
}
