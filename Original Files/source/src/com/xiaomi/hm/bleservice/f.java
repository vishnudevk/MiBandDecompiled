// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.xiaomi.hm.bleservice.util.Debug;
import com.xiaomi.hm.bleservice.util.Helper;
import java.util.Map;

// Referenced classes of package com.xiaomi.hm.bleservice:
//            BLEService

class f
    implements android.bluetooth.BluetoothAdapter.LeScanCallback
{

    final Map a;
    final BLEService b;

    f(BLEService bleservice, Map map)
    {
        b = bleservice;
        a = map;
        super();
    }

    public void onLeScan(BluetoothDevice bluetoothdevice, int i, byte abyte0[])
    {
        Debug.TRACE();
        String s = bluetoothdevice.getName();
        Debug.DEBUG((new StringBuilder()).append("device: ").append(s).append(",").append(bluetoothdevice.getAddress()).toString());
        Debug.DEBUG((new StringBuilder()).append("scanRecord: ").append(Helper.bytesToHexString(abyte0)).toString());
        Helper.parseAdvData(abyte0);
        if (bluetoothdevice.getAddress().startsWith("88:0F:10"))
        {
            if (BLEService.access$500(b) != null)
            {
                if (!bluetoothdevice.getAddress().equals(BLEService.access$500(b).getAddress()));
            }
            if (!a.containsKey(bluetoothdevice.getAddress()))
            {
                a.put(bluetoothdevice.getAddress(), bluetoothdevice);
                Intent intent = new Intent(BLEService.INTENT_ACTION_DEVICE_FOUND);
                intent.putExtra(BLEService.INTENT_EXTRA_DEVICE, bluetoothdevice);
                intent.putExtra(BLEService.INTENT_EXTRA_PARAM, i);
                intent.putExtra(BLEService.INTENT_EXTRA_PARAM_EXT, abyte0);
                BLEService.access$600().sendBroadcast(intent);
                return;
            }
        }
    }
}
