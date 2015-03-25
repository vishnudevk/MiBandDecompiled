// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package android.support.v4.net:
//            b

class a
    implements b
{

    a()
    {
    }

    public boolean a(ConnectivityManager connectivitymanager)
    {
        NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
        if (networkinfo != null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        switch (networkinfo.getType())
        {
        default:
            return true;

        case 1: // '\001'
            return false;

        case 0: // '\0'
            break;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
