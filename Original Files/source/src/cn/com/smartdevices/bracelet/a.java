// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            BraceletApp

class a
    implements ServiceConnection
{

    final BraceletApp a;

    a(BraceletApp braceletapp)
    {
        a = braceletapp;
        super();
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        if (ibinder instanceof com.xiaomi.hm.bleservice.BLEService.BLEServiceBinder)
        {
            BraceletApp.BLEService = ((com.xiaomi.hm.bleservice.BLEService.BLEServiceBinder)ibinder).getService();
        }
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        BraceletApp.BLEService = null;
    }
}
