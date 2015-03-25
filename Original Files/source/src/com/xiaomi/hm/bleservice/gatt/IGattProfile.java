// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothGattCharacteristic;

public interface IGattProfile
{

    public abstract void cleanup();

    public abstract boolean init();

    public abstract byte[] read(BluetoothGattCharacteristic bluetoothgattcharacteristic);

    public abstract boolean write(BluetoothGattCharacteristic bluetoothgattcharacteristic, byte abyte0[]);
}
