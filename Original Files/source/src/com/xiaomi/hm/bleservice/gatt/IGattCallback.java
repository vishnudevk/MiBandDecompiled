// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import java.util.List;
import java.util.UUID;

public interface IGattCallback
{

    public static final int ERROR_GATT_INVALID = 65281;
    public static final int ERROR_GATT_OPERATION_FAILED = 65282;
    public static final int ERROR_GATT_SUCCESS = 0;
    public static final int ERROR_GATT_UNKNOWN = 65534;

    public abstract void connect();

    public abstract void disconnect();

    public abstract boolean getAutoReconnect();

    public abstract BluetoothDevice getDevice();

    public abstract BluetoothGattService getService(UUID uuid);

    public abstract List getServices();

    public abstract STATE getState();

    public abstract int readCharacteristic(BluetoothGattCharacteristic bluetoothgattcharacteristic);

    public abstract int readRemoteRSSI();

    public abstract void refreshGatt();

    public abstract boolean registerNotification(BluetoothGattCharacteristic bluetoothgattcharacteristic, INotifyCallback inotifycallback);

    public abstract void setAutoReconnect(boolean flag);

    public abstract boolean unregisterNotification(BluetoothGattCharacteristic bluetoothgattcharacteristic);

    public abstract int writeCharacteristic(BluetoothGattCharacteristic bluetoothgattcharacteristic, byte abyte0[]);
}
