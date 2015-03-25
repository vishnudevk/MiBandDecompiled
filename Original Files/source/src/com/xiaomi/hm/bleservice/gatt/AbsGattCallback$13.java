// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothGattDescriptor;

// Referenced classes of package com.xiaomi.hm.bleservice.gatt:
//            AbsGattCallback

class val.descriptor
    implements Runnable
{

    final AbsGattCallback this$0;
    final BluetoothGattDescriptor val$descriptor;

    public void run()
    {
        GattCB_onDescriptorRead(val$descriptor);
    }

    ()
    {
        this$0 = final_absgattcallback;
        val$descriptor = BluetoothGattDescriptor.this;
        super();
    }
}
