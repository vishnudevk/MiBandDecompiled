// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SystemBindReceiver extends BroadcastReceiver
{

    public SystemBindReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getAction();
        BluetoothDevice _tmp = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        while (s.equals("com.xiaomi.hm.health.ACTION_DEVICE_BIND_APPLICATION") || !s.equals("com.xiaomi.hm.health.ACTION_DEVICE_UNBIND_APPLICATION")) 
        {
            return;
        }
    }
}
