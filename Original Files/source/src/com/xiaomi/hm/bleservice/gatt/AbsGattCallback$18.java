// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import com.xiaomi.hm.bleservice.util.Debug;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.xiaomi.hm.bleservice.gatt:
//            AbsGattCallback

final class val.descriptor
    implements Runnable
{

    final BluetoothGattDescriptor val$descriptor;
    final BluetoothGatt val$gatt;

    public void run()
    {
        Debug.TRACE();
        Debug.ASSERT_RUN_ON_THREAD(AbsGattCallback.access$100());
        Debug.ASSERT_NOT_NULL(val$gatt);
        if (val$gatt != null) goto _L2; else goto _L1
_L1:
        AbsGattCallback.access$200().lock();
        AbsGattCallback.access$302(65281);
        Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: synchronizedReadDescriptor(): ").append(AbsGattCallback.access$300()).toString());
        AbsGattCallback.access$402(false);
        AbsGattCallback.access$500().signal();
        AbsGattCallback.access$200().unlock();
_L4:
        return;
        Exception exception1;
        exception1;
        AbsGattCallback.access$200().unlock();
        throw exception1;
_L2:
        boolean flag;
        flag = val$gatt.readDescriptor(val$descriptor);
        Debug.ASSERT_TRUE(flag);
        if (flag) goto _L4; else goto _L3
_L3:
        AbsGattCallback.access$200().lock();
        AbsGattCallback.access$302(65282);
        Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: synchronizedReadDescriptor(): ").append(AbsGattCallback.access$300()).toString());
        AbsGattCallback.access$402(false);
        AbsGattCallback.access$500().signal();
        AbsGattCallback.access$200().unlock();
        return;
        Exception exception;
        exception;
        AbsGattCallback.access$200().unlock();
        throw exception;
    }

    ()
    {
        val$gatt = bluetoothgatt;
        val$descriptor = bluetoothgattdescriptor;
        super();
    }
}
