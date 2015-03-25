// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothGattCharacteristic;

// Referenced classes of package com.xiaomi.hm.bleservice.gatt:
//            AbsGattCallback

class val.characteristic
    implements Runnable
{

    final AbsGattCallback this$0;
    final BluetoothGattCharacteristic val$characteristic;

    public void run()
    {
        GattCB_onCharacteristicRead(val$characteristic);
    }

    ()
    {
        this$0 = final_absgattcallback;
        val$characteristic = BluetoothGattCharacteristic.this;
        super();
    }
}
