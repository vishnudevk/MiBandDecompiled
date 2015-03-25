// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.gatt;


// Referenced classes of package com.xiaomi.hm.bleservice.gatt:
//            AbsGattCallback

class val.rssi
    implements Runnable
{

    final AbsGattCallback this$0;
    final int val$rssi;

    public void run()
    {
        GattCB_onReadRemoteRssi(val$rssi);
    }

    ()
    {
        this$0 = final_absgattcallback;
        val$rssi = I.this;
        super();
    }
}
