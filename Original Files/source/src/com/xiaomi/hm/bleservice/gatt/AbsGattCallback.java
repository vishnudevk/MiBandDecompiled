// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.xiaomi.hm.bleservice.util.Debug;
import com.xiaomi.hm.bleservice.util.Helper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.xiaomi.hm.bleservice.gatt:
//            IGattCallback

abstract class AbsGattCallback extends BluetoothGattCallback
    implements IGattCallback
{

    private static final String CALLBACK_QUEUE_THREAD_NAME = CLASS_NAME;
    private static final String CLASS_NAME = com/xiaomi/hm/bleservice/gatt/AbsGattCallback.getSimpleName();
    private static final long GATT_OPERATION_TIMEOUT = 30L;
    private static final String GATT_QUEUE_THREAD_NAME = (new StringBuilder()).append(CLASS_NAME).append("*").toString();
    private static final ReentrantLock c_GattOperationLock;
    private static final Handler c_GattQueue;
    private static final HandlerThread c_GattQueueThread;
    private static int c_RSSI = 0;
    private static final Object c_RSSILock = new Object();
    private static int c_RSSIStatus = 65534;
    private static int c_ReturnValue = 65534;
    private static final Condition c_condGattOperationComplete;
    private static boolean c_isGattOperationLocking = false;
    private static boolean c_isRSSILocking = false;
    private final Context m_Context;
    private final BluetoothDevice m_Device;
    private final ExecutorService m_Executor = Executors.newSingleThreadExecutor(new _cls1());
    private BluetoothGatt m_Gatt;
    private final Map m_NotifyCBs = new HashMap();
    private IGattCallback.STATE m_State;
    private Field m_field_BluetoothGatt_mClientIf;
    private boolean m_isClean;

    protected AbsGattCallback(Context context, BluetoothDevice bluetoothdevice)
    {
        m_Gatt = null;
        m_State = IGattCallback.STATE.DISCONNECTED;
        m_isClean = true;
        m_field_BluetoothGatt_mClientIf = null;
        Debug.TRACE();
        m_Context = context;
        m_Device = bluetoothdevice;
    }

    private static boolean isConnected(BluetoothGatt bluetoothgatt)
    {
        return bluetoothgatt != null;
    }

    private void printClientIf(BluetoothGatt bluetoothgatt)
    {
        if (m_field_BluetoothGatt_mClientIf == null)
        {
            try
            {
                m_field_BluetoothGatt_mClientIf = android/bluetooth/BluetoothGatt.getDeclaredField("mClientIf");
                m_field_BluetoothGatt_mClientIf.setAccessible(true);
            }
            catch (NoSuchFieldException nosuchfieldexception)
            {
                nosuchfieldexception.printStackTrace();
            }
        }
        try
        {
            int i = m_field_BluetoothGatt_mClientIf.getInt(bluetoothgatt);
            Debug.DEBUG((new StringBuilder()).append("mClientIf = ").append(i).toString());
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            illegalaccessexception.printStackTrace();
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            illegalargumentexception.printStackTrace();
        }
    }

    private static int synchronizedReadCharacteristic(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic)
    {
        com/xiaomi/hm/bleservice/gatt/AbsGattCallback;
        JVM INSTR monitorenter ;
        _cls16 _lcls16;
        Debug.TRACE();
        Debug.DEBUG((new StringBuilder()).append("gatt=").append(gatt).append(", characteristic=").append(characteristic).toString());
        Debug.ASSERT_NOT_NULL(gatt);
        Debug.ASSERT_NOT_NULL(characteristic);
        _lcls16 = new _cls16();
        c_GattOperationLock.lock();
        c_isGattOperationLocking = true;
        c_GattQueue.post(_lcls16);
_L7:
        if (!c_isGattOperationLocking) goto _L2; else goto _L1
_L1:
        if (!isConnected(gatt)) goto _L4; else goto _L3
_L3:
        Debug.DEBUG_LOCK((new StringBuilder()).append("WAIT: synchronizedReadCharacteristic(): ").append(Helper.parseUUID(characteristic.getUuid())).toString());
        c_condGattOperationComplete.await(30L, TimeUnit.SECONDS);
        if (!c_isGattOperationLocking) goto _L6; else goto _L5
_L5:
        Debug.WARN("GATT OPERATION TIMEOUT");
        Debug.DEBUG_LOCK((new StringBuilder()).append("CONTINUE: synchronizedReadCharacteristic(): ").append(Helper.parseUUID(characteristic.getUuid())).toString());
_L2:
        c_GattOperationLock.unlock();
_L8:
        int i = c_ReturnValue;
        com/xiaomi/hm/bleservice/gatt/AbsGattCallback;
        JVM INSTR monitorexit ;
        return i;
_L6:
        Debug.DEBUG_LOCK((new StringBuilder()).append("CONTINUE: synchronizedReadCharacteristic(): ").append(Helper.parseUUID(characteristic.getUuid())).toString());
          goto _L7
        InterruptedException interruptedexception;
        interruptedexception;
        interruptedexception.printStackTrace();
        c_GattOperationLock.unlock();
          goto _L8
        Exception exception;
        exception;
        throw exception;
_L4:
        Debug.WARN("NO CONNECTION");
          goto _L2
        Exception exception1;
        exception1;
        c_GattOperationLock.unlock();
        throw exception1;
          goto _L7
    }

    private static int synchronizedReadDescriptor(final BluetoothGatt gatt, final BluetoothGattDescriptor descriptor)
    {
        com/xiaomi/hm/bleservice/gatt/AbsGattCallback;
        JVM INSTR monitorenter ;
        _cls18 _lcls18;
        Debug.TRACE();
        Debug.DEBUG((new StringBuilder()).append("gatt=").append(gatt).append(", characteristic=").append(descriptor).toString());
        Debug.ASSERT_NOT_NULL(gatt);
        Debug.ASSERT_NOT_NULL(descriptor);
        _lcls18 = new _cls18();
        c_GattOperationLock.lock();
        c_isGattOperationLocking = true;
        c_GattQueue.post(_lcls18);
_L7:
        if (!c_isGattOperationLocking) goto _L2; else goto _L1
_L1:
        if (!isConnected(gatt)) goto _L4; else goto _L3
_L3:
        Debug.DEBUG_LOCK((new StringBuilder()).append("WAIT: synchronizedReadDescriptor(): ").append(Helper.parseUUID(descriptor.getUuid())).toString());
        c_condGattOperationComplete.await(30L, TimeUnit.SECONDS);
        if (!c_isGattOperationLocking) goto _L6; else goto _L5
_L5:
        Debug.WARN("GATT OPERATION TIMEOUT");
        Debug.DEBUG_LOCK((new StringBuilder()).append("CONTINUE: synchronizedReadDescriptor(): ").append(Helper.parseUUID(descriptor.getUuid())).toString());
_L2:
        c_GattOperationLock.unlock();
_L8:
        int i = c_ReturnValue;
        com/xiaomi/hm/bleservice/gatt/AbsGattCallback;
        JVM INSTR monitorexit ;
        return i;
_L6:
        Debug.DEBUG_LOCK((new StringBuilder()).append("CONTINUE: synchronizedReadDescriptor(): ").append(Helper.parseUUID(descriptor.getUuid())).toString());
          goto _L7
        InterruptedException interruptedexception;
        interruptedexception;
        interruptedexception.printStackTrace();
        c_GattOperationLock.unlock();
          goto _L8
        Exception exception;
        exception;
        throw exception;
_L4:
        Debug.WARN("NO CONNECTION");
          goto _L2
        Exception exception1;
        exception1;
        c_GattOperationLock.unlock();
        throw exception1;
          goto _L7
    }

    private static int synchronizedWriteCharacteristic(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final byte value[])
    {
        com/xiaomi/hm/bleservice/gatt/AbsGattCallback;
        JVM INSTR monitorenter ;
        _cls17 _lcls17;
        Debug.TRACE();
        Debug.DEBUG((new StringBuilder()).append("gatt=").append(gatt).append(", characteristic=").append(characteristic).append(", value=").append(value).toString());
        Debug.ASSERT_NOT_NULL(gatt);
        Debug.ASSERT_NOT_NULL(characteristic);
        Debug.ASSERT_NOT_NULL(value);
        _lcls17 = new _cls17();
        c_GattOperationLock.lock();
        c_isGattOperationLocking = true;
        c_GattQueue.post(_lcls17);
_L7:
        if (!c_isGattOperationLocking) goto _L2; else goto _L1
_L1:
        if (!isConnected(gatt)) goto _L4; else goto _L3
_L3:
        Debug.DEBUG_LOCK((new StringBuilder()).append("WAIT: synchronizedWriteCharacteristic(): ").append(Helper.parseUUID(characteristic.getUuid())).toString());
        c_condGattOperationComplete.await(30L, TimeUnit.SECONDS);
        if (!c_isGattOperationLocking) goto _L6; else goto _L5
_L5:
        Debug.WARN("GATT OPERATION TIMEOUT");
        Debug.DEBUG_LOCK((new StringBuilder()).append("CONTINUE: synchronizedWriteCharacteristic(): ").append(Helper.parseUUID(characteristic.getUuid())).toString());
_L2:
        c_GattOperationLock.unlock();
_L8:
        int i = c_ReturnValue;
        com/xiaomi/hm/bleservice/gatt/AbsGattCallback;
        JVM INSTR monitorexit ;
        return i;
_L6:
        Debug.DEBUG_LOCK((new StringBuilder()).append("CONTINUE: synchronizedWriteCharacteristic(): ").append(Helper.parseUUID(characteristic.getUuid())).toString());
          goto _L7
        InterruptedException interruptedexception;
        interruptedexception;
        interruptedexception.printStackTrace();
        c_GattOperationLock.unlock();
          goto _L8
        Exception exception;
        exception;
        throw exception;
_L4:
        Debug.WARN("NO CONNECTION");
          goto _L2
        Exception exception1;
        exception1;
        c_GattOperationLock.unlock();
        throw exception1;
          goto _L7
    }

    private static int synchronizedWriteDescriptor(final BluetoothGatt gatt, final BluetoothGattDescriptor descriptor, final byte value[])
    {
        com/xiaomi/hm/bleservice/gatt/AbsGattCallback;
        JVM INSTR monitorenter ;
        _cls19 _lcls19;
        Debug.TRACE();
        Debug.DEBUG((new StringBuilder()).append("gatt=").append(gatt).append(", characteristic=").append(descriptor).append(", value=").append(value).toString());
        Debug.ASSERT_NOT_NULL(gatt);
        Debug.ASSERT_NOT_NULL(descriptor);
        Debug.ASSERT_NOT_NULL(value);
        _lcls19 = new _cls19();
        c_GattOperationLock.lock();
        c_isGattOperationLocking = true;
        c_GattQueue.post(_lcls19);
_L7:
        if (!c_isGattOperationLocking) goto _L2; else goto _L1
_L1:
        if (!isConnected(gatt)) goto _L4; else goto _L3
_L3:
        Debug.DEBUG_LOCK((new StringBuilder()).append("WAIT: synchronizedWriteDescriptor(): ").append(Helper.parseUUID(descriptor.getUuid())).toString());
        c_condGattOperationComplete.await(30L, TimeUnit.SECONDS);
        if (!c_isGattOperationLocking) goto _L6; else goto _L5
_L5:
        Debug.WARN("GATT OPERATION TIMEOUT");
        Debug.DEBUG_LOCK((new StringBuilder()).append("CONTINUE: synchronizedWriteDescriptor(): ").append(Helper.parseUUID(descriptor.getUuid())).toString());
_L2:
        c_GattOperationLock.unlock();
_L8:
        int i = c_ReturnValue;
        com/xiaomi/hm/bleservice/gatt/AbsGattCallback;
        JVM INSTR monitorexit ;
        return i;
_L6:
        Debug.DEBUG_LOCK((new StringBuilder()).append("CONTINUE: synchronizedWriteDescriptor(): ").append(Helper.parseUUID(descriptor.getUuid())).toString());
          goto _L7
        InterruptedException interruptedexception;
        interruptedexception;
        interruptedexception.printStackTrace();
        c_GattOperationLock.unlock();
          goto _L8
        Exception exception;
        exception;
        throw exception;
_L4:
        Debug.WARN("NO CONNECTION");
          goto _L2
        Exception exception1;
        exception1;
        c_GattOperationLock.unlock();
        throw exception1;
          goto _L7
    }

    protected abstract void GattCB_onCharacteristicChanged(BluetoothGattCharacteristic bluetoothgattcharacteristic);

    protected abstract void GattCB_onCharacteristicRead(BluetoothGattCharacteristic bluetoothgattcharacteristic);

    protected abstract void GattCB_onCharacteristicWrite(BluetoothGattCharacteristic bluetoothgattcharacteristic);

    protected abstract void GattCB_onConnected();

    protected abstract void GattCB_onConnectionFailed();

    protected abstract void GattCB_onDescriptorRead(BluetoothGattDescriptor bluetoothgattdescriptor);

    protected abstract void GattCB_onDescriptorWrite(BluetoothGattDescriptor bluetoothgattdescriptor);

    protected abstract void GattCB_onDisconnected();

    protected abstract void GattCB_onReadRemoteRssi(int i);

    protected abstract void GattCB_onServiceDiscovered();

    protected void cleanupInternal()
    {
        Debug.TRACE();
        Debug.DEBUG((new StringBuilder()).append("m_State: ").append(m_State).toString());
        if (m_State != IGattCallback.STATE.DISCONNECTED)
        {
            Debug.WARN((new StringBuilder()).append("Illegal state: m_State = ").append(m_State).toString());
            return;
        }
        m_NotifyCBs.clear();
        c_GattOperationLock.lock();
        c_isGattOperationLocking = false;
        c_ReturnValue = 65534;
        Debug.DEBUG_LOCK("RELEASE: c_condGattOperationComplete");
        c_condGattOperationComplete.signalAll();
        c_GattOperationLock.unlock();
        synchronized (c_RSSILock)
        {
            c_isRSSILocking = false;
            c_RSSI = 0;
            c_RSSIStatus = 65534;
            Debug.DEBUG_LOCK("RELEASE: c_RSSILock");
            c_RSSILock.notifyAll();
        }
        m_Gatt.close();
        m_Gatt = null;
        m_isClean = true;
        return;
        Exception exception;
        exception;
        c_GattOperationLock.unlock();
        throw exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public final void connect()
    {
        Debug.TRACE();
        m_Executor.execute(new _cls3());
    }

    protected void connectInternal()
    {
        Debug.TRACE();
        Debug.DEBUG((new StringBuilder()).append("m_State: ").append(m_State).toString());
        if (m_State != IGattCallback.STATE.DISCONNECTED)
        {
            Debug.WARN((new StringBuilder()).append("Illegal state: m_State = ").append(m_State).toString());
        }
        m_State = IGattCallback.STATE.CONNECTING;
        if (m_Gatt != null)
        {
            Debug.DEBUG("connect back...");
        }
        m_isClean = false;
        m_Gatt = m_Device.connectGatt(m_Context, false, this);
        Debug.ASSERT_NOT_NULL(m_Gatt);
    }

    public final void disconnect()
    {
        Debug.TRACE();
        m_Executor.execute(new _cls4());
    }

    protected void disconnectInternal()
    {
        Debug.TRACE();
        Debug.DEBUG((new StringBuilder()).append("m_State: ").append(m_State).toString());
        if (m_State != IGattCallback.STATE.CONNECTING && m_State != IGattCallback.STATE.CONNECTED)
        {
            Debug.WARN("Illegal state: m_State != STATE_CONNECTING && m_State != STATE_CONNECTED");
            return;
        } else
        {
            Debug.ASSERT_NOT_NULL(m_Gatt);
            m_State = IGattCallback.STATE.DISCONNECTING;
            m_Gatt.disconnect();
            return;
        }
    }

    public final BluetoothDevice getDevice()
    {
        return m_Device;
    }

    protected final BluetoothGatt getGatt()
    {
        return m_Gatt;
    }

    public final BluetoothGattService getService(UUID uuid)
    {
        Debug.TRACE();
        Debug.ASSERT_NOT_NULL(m_Gatt);
        if (m_Gatt == null)
        {
            return null;
        } else
        {
            return m_Gatt.getService(uuid);
        }
    }

    public final List getServices()
    {
        Debug.TRACE();
        Debug.ASSERT_NOT_NULL(m_Gatt);
        if (m_Gatt == null)
        {
            return null;
        } else
        {
            return m_Gatt.getServices();
        }
    }

    public final IGattCallback.STATE getState()
    {
        return m_State;
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothgatt, final BluetoothGattCharacteristic characteristic)
    {
        Debug.TRACE();
        boolean flag;
        final byte value[];
        final IGattCallback.INotifyCallback notifyCB;
        if (m_Gatt == bluetoothgatt)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        value = characteristic.getValue();
        Debug.DEBUG((new StringBuilder()).append("Characteristic Changed: ").append(Helper.bytesToHexString(value)).toString());
        notifyCB = (IGattCallback.INotifyCallback)m_NotifyCBs.get(characteristic);
        Debug.ASSERT_NOT_NULL(notifyCB);
        m_Executor.execute(new _cls11());
        m_Executor.execute(new _cls12());
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothgatt, final BluetoothGattCharacteristic characteristic, int i)
    {
        boolean flag = true;
        Debug.TRACE();
        boolean flag1;
        if (i == 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        Debug.ASSERT_TRUE(flag1);
        if (m_Gatt != bluetoothgatt)
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        Debug.DEBUG((new StringBuilder()).append("Characteristic Read: ").append(Helper.bytesToHexString(characteristic.getValue())).toString());
        c_GattOperationLock.lock();
        c_ReturnValue = i;
        Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: onCharacteristicRead(): ").append(c_ReturnValue).toString());
        c_isGattOperationLocking = false;
        c_condGattOperationComplete.signal();
        c_GattOperationLock.unlock();
        if (i == 0)
        {
            m_Executor.execute(new _cls9());
        }
        return;
        Exception exception;
        exception;
        c_GattOperationLock.unlock();
        throw exception;
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothgatt, final BluetoothGattCharacteristic characteristic, int i)
    {
        boolean flag = true;
        Debug.TRACE();
        boolean flag1;
        if (i == 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        Debug.ASSERT_TRUE(flag1);
        if (m_Gatt != bluetoothgatt)
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        Debug.DEBUG((new StringBuilder()).append("Characteristic Write: ").append(Helper.bytesToHexString(characteristic.getValue())).toString());
        c_GattOperationLock.lock();
        c_ReturnValue = i;
        Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: onCharacteristicWrite(): ").append(c_ReturnValue).toString());
        c_isGattOperationLocking = false;
        c_condGattOperationComplete.signal();
        c_GattOperationLock.unlock();
        if (i == 0)
        {
            m_Executor.execute(new _cls10());
        }
        return;
        Exception exception;
        exception;
        c_GattOperationLock.unlock();
        throw exception;
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothgatt, int i, int j)
    {
        Debug.TRACE();
        boolean flag;
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        if (m_Gatt != bluetoothgatt)
        {
            Debug.WARN((new StringBuilder()).append("m_Gatt: ").append(m_Gatt).toString());
            Debug.WARN((new StringBuilder()).append("  gatt: ").append(bluetoothgatt).toString());
            if (m_Gatt != null)
            {
                StringBuilder stringbuilder3 = (new StringBuilder()).append("m_Gatt.getDevice(): ");
                StringBuilder stringbuilder2;
                Object obj3;
                if (m_Gatt != null)
                {
                    obj3 = m_Gatt.getDevice();
                } else
                {
                    obj3 = "";
                }
                Debug.WARN(stringbuilder3.append(obj3).toString());
                printClientIf(m_Gatt);
            }
            if (bluetoothgatt != null)
            {
                stringbuilder2 = (new StringBuilder()).append("  gatt.getDevice(): ");
                Object obj2;
                if (bluetoothgatt != null)
                {
                    obj2 = bluetoothgatt.getDevice();
                } else
                {
                    obj2 = "";
                }
                Debug.WARN(stringbuilder2.append(obj2).toString());
                printClientIf(bluetoothgatt);
            }
            m_Gatt = bluetoothgatt;
        }
        if (i == 0)
        {
            switch (j)
            {
            case 1: // '\001'
            default:
                Debug.WARN(">>> UNEXPECTED <<<");
                return;

            case 2: // '\002'
                m_State = IGattCallback.STATE.CONNECTED;
                Debug.INFO("=================================================");
                Debug.INFO("=================== CONNECTED ===================");
                Debug.INFO("=================================================");
                printClientIf(m_Gatt);
                m_Executor.execute(new _cls5());
                return;

            case 0: // '\0'
                m_State = IGattCallback.STATE.DISCONNECTED;
                Debug.INFO("=================================================");
                Debug.INFO("================== DISCONNECTED =================");
                Debug.INFO("=================================================");
                m_Executor.execute(new _cls6());
                return;
            }
        }
        if (i != 133)
        {
            throw new RuntimeException((new StringBuilder()).append("status: ").append(i).toString());
        }
        Debug.WARN((new StringBuilder()).append("m_Gatt: ").append(m_Gatt).toString());
        Debug.WARN((new StringBuilder()).append("  gatt: ").append(bluetoothgatt).toString());
        if (m_Gatt != null)
        {
            StringBuilder stringbuilder1 = (new StringBuilder()).append("m_Gatt.getDevice(): ");
            StringBuilder stringbuilder;
            Object obj1;
            if (m_Gatt != null)
            {
                obj1 = m_Gatt.getDevice();
            } else
            {
                obj1 = "";
            }
            Debug.WARN(stringbuilder1.append(obj1).toString());
            printClientIf(m_Gatt);
        }
        if (bluetoothgatt != null)
        {
            stringbuilder = (new StringBuilder()).append("  gatt.getDevice(): ");
            Object obj;
            if (bluetoothgatt != null)
            {
                obj = bluetoothgatt.getDevice();
            } else
            {
                obj = "";
            }
            Debug.WARN(stringbuilder.append(obj).toString());
            printClientIf(bluetoothgatt);
        }
        m_State = IGattCallback.STATE.DISCONNECTED;
        Debug.ERROR("=================================================");
        Debug.ERROR("=============== CONNECTION FAILED ===============");
        Debug.ERROR("=================================================");
        m_Executor.execute(new _cls7());
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothgatt, final BluetoothGattDescriptor descriptor, int i)
    {
        boolean flag = true;
        Debug.TRACE();
        boolean flag1;
        if (i == 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        Debug.ASSERT_TRUE(flag1);
        if (m_Gatt != bluetoothgatt)
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        Debug.DEBUG((new StringBuilder()).append("Descriptor Read: ").append(Helper.bytesToHexString(descriptor.getValue())).toString());
        c_GattOperationLock.lock();
        c_ReturnValue = i;
        Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: onDescriptorRead(): ").append(c_ReturnValue).toString());
        c_isGattOperationLocking = false;
        c_condGattOperationComplete.signal();
        c_GattOperationLock.unlock();
        if (i == 0)
        {
            m_Executor.execute(new _cls13());
        }
        return;
        Exception exception;
        exception;
        c_GattOperationLock.unlock();
        throw exception;
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothgatt, final BluetoothGattDescriptor descriptor, int i)
    {
        boolean flag = true;
        Debug.TRACE();
        boolean flag1;
        if (i == 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        Debug.ASSERT_TRUE(flag1);
        if (m_Gatt != bluetoothgatt)
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        Debug.DEBUG((new StringBuilder()).append("Descriptor Write: ").append(Helper.bytesToHexString(descriptor.getValue())).toString());
        c_GattOperationLock.lock();
        c_ReturnValue = i;
        Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: onDescriptorWrite(): ").append(c_ReturnValue).toString());
        c_isGattOperationLocking = false;
        c_condGattOperationComplete.signal();
        c_GattOperationLock.unlock();
        if (i == 0)
        {
            m_Executor.execute(new _cls14());
        }
        return;
        Exception exception;
        exception;
        c_GattOperationLock.unlock();
        throw exception;
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothgatt, final int rssi, int i)
    {
        boolean flag = true;
        Debug.TRACE();
        boolean flag1;
        if (i == 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        Debug.ASSERT_TRUE(flag1);
        if (m_Gatt != bluetoothgatt)
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        Debug.DEBUG((new StringBuilder()).append("RSSI: ").append(rssi).toString());
        synchronized (c_RSSILock)
        {
            c_RSSI = rssi;
            c_RSSIStatus = i;
            Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: onReadRemoteRssi(): ").append(c_RSSIStatus).toString());
            c_isRSSILocking = false;
            c_RSSILock.notify();
        }
        if (i == 0)
        {
            m_Executor.execute(new _cls15());
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothgatt, int i)
    {
        boolean flag = true;
        Debug.TRACE();
        boolean flag1;
        if (i == 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        Debug.ASSERT_TRUE(flag1);
        if (m_Gatt != bluetoothgatt)
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        Debug.WARN(">>> UNEXPECTED <<<");
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothgatt, int i)
    {
        boolean flag = true;
        Debug.TRACE();
        boolean flag1;
        if (i == 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        Debug.ASSERT_TRUE(flag1);
        if (m_Gatt != bluetoothgatt)
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        if (i == 0)
        {
            m_Executor.execute(new _cls8());
            return;
        } else
        {
            disconnectInternal();
            return;
        }
    }

    public final int readCharacteristic(BluetoothGattCharacteristic bluetoothgattcharacteristic)
    {
        return synchronizedReadCharacteristic(m_Gatt, bluetoothgattcharacteristic);
    }

    public final int readRemoteRSSI()
    {
        Debug.TRACE();
        c_isRSSILocking = true;
        Debug.ASSERT_NOT_NULL(m_Gatt);
        if (m_Gatt == null)
        {
            c_isRSSILocking = false;
            return 0;
        }
        if (!m_Gatt.readRemoteRssi())
        {
            c_isRSSILocking = false;
            return 0;
        }
        Object obj = c_RSSILock;
        obj;
        JVM INSTR monitorenter ;
_L6:
        if (!c_isRSSILocking) goto _L2; else goto _L1
_L1:
        Debug.DEBUG_LOCK("WAIT: readRemoteRSSI()");
        c_RSSILock.wait(30L);
        if (!c_isRSSILocking) goto _L4; else goto _L3
_L3:
        Debug.WARN("GATT OPERATION TIMEOUT");
        Debug.DEBUG_LOCK("CONTINUE: readRemoteRSSI()");
_L2:
        if (c_RSSIStatus == 0)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        return 0;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        Debug.DEBUG_LOCK("CONTINUE: readRemoteRSSI()");
        continue; /* Loop/switch isn't completed */
        InterruptedException interruptedexception;
        interruptedexception;
        interruptedexception.printStackTrace();
          goto _L2
        int i = c_RSSI;
        obj;
        JVM INSTR monitorexit ;
        return i;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void refreshGatt()
    {
        try
        {
            android/bluetooth/BluetoothGatt.getDeclaredMethod("refresh", (Class[])null).invoke(m_Gatt, (Object[])null);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public final boolean registerNotification(BluetoothGattCharacteristic bluetoothgattcharacteristic, IGattCallback.INotifyCallback inotifycallback)
    {
        boolean flag = true;
        Debug.TRACE();
        Debug.ASSERT_NOT_NULL(inotifycallback);
        m_NotifyCBs.put(bluetoothgattcharacteristic, inotifycallback);
        boolean flag1 = m_Gatt.setCharacteristicNotification(bluetoothgattcharacteristic, flag);
        Debug.ASSERT_TRUE(flag1);
        if (flag1)
        {
            BluetoothGattDescriptor bluetoothgattdescriptor = bluetoothgattcharacteristic.getDescriptor(Helper.UUID_DESCRIPTOR_CLIENT_CHARACTERISTIC_CONFIGURATION);
            Debug.ASSERT_NOT_NULL(bluetoothgattdescriptor);
            if (bluetoothgattdescriptor != null)
            {
                if ((0x10 & bluetoothgattcharacteristic.getProperties()) > 0)
                {
                    if (synchronizedWriteDescriptor(m_Gatt, bluetoothgattdescriptor, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE) != 0)
                    {
                        flag = false;
                    }
                    return flag;
                }
                if ((0x20 & bluetoothgattcharacteristic.getProperties()) > 0)
                {
                    if (synchronizedWriteDescriptor(m_Gatt, bluetoothgattdescriptor, BluetoothGattDescriptor.ENABLE_INDICATION_VALUE) != 0)
                    {
                        flag = false;
                    }
                    return flag;
                }
            }
        }
        return false;
    }

    public final boolean unregisterNotification(BluetoothGattCharacteristic bluetoothgattcharacteristic)
    {
        boolean flag;
        flag = true;
        Debug.TRACE();
        m_NotifyCBs.remove(bluetoothgattcharacteristic);
        if (m_State == IGattCallback.STATE.CONNECTED) goto _L2; else goto _L1
_L1:
        Debug.DEBUG("m_State != STATE_CONNECTED");
        if (m_Gatt == null) goto _L4; else goto _L3
_L3:
        boolean flag2;
        Debug.DEBUG("m_Gatt != null, trying to unregister locally...");
        flag2 = m_Gatt.setCharacteristicNotification(bluetoothgattcharacteristic, false);
        Debug.ASSERT_TRUE(flag2);
        if (flag2) goto _L4; else goto _L5
_L5:
        return false;
_L4:
        return flag;
_L2:
        Debug.ASSERT_NOT_NULL(m_Gatt);
        boolean flag1 = m_Gatt.setCharacteristicNotification(bluetoothgattcharacteristic, false);
        Debug.ASSERT_TRUE(flag1);
        if (flag1)
        {
            BluetoothGattDescriptor bluetoothgattdescriptor = bluetoothgattcharacteristic.getDescriptor(Helper.UUID_DESCRIPTOR_CLIENT_CHARACTERISTIC_CONFIGURATION);
            Debug.ASSERT_NOT_NULL(bluetoothgattdescriptor);
            if (bluetoothgattdescriptor != null)
            {
                if (synchronizedWriteDescriptor(m_Gatt, bluetoothgattdescriptor, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE) != 0)
                {
                    flag = false;
                }
                return flag;
            }
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int writeCharacteristic(BluetoothGattCharacteristic bluetoothgattcharacteristic, byte abyte0[])
    {
        return synchronizedWriteCharacteristic(m_Gatt, bluetoothgattcharacteristic, abyte0);
    }

    static 
    {
        c_GattOperationLock = new ReentrantLock();
        c_condGattOperationComplete = c_GattOperationLock.newCondition();
        Debug.TRACE();
        c_GattQueueThread = new HandlerThread(GATT_QUEUE_THREAD_NAME);
        Debug.INFO("********************************");
        Debug.INFO((new StringBuilder()).append("NEW THREAD: ").append(GATT_QUEUE_THREAD_NAME).toString());
        Debug.INFO("********************************");
        c_GattQueueThread.setUncaughtExceptionHandler(new _cls2());
        c_GattQueueThread.start();
        c_GattQueue = new Handler(c_GattQueueThread.getLooper());
    }






/*
    static int access$302(int i)
    {
        c_ReturnValue = i;
        return i;
    }

*/


/*
    static boolean access$402(boolean flag)
    {
        c_isGattOperationLocking = flag;
        return flag;
    }

*/


    private class _cls1
        implements ThreadFactory
    {

        final AbsGattCallback this$0;

        public Thread newThread(Runnable runnable)
        {
            Debug.TRACE();
            Debug.INFO("********************************");
            Debug.INFO((new StringBuilder()).append("NEW THREAD: ").append(AbsGattCallback.CALLBACK_QUEUE_THREAD_NAME).toString());
            Debug.INFO("********************************");
            Thread thread = new Thread(runnable, AbsGattCallback.CALLBACK_QUEUE_THREAD_NAME);
            class _cls1
                implements Thread.UncaughtExceptionHandler
            {

                final _cls1 this$1;

                public void uncaughtException(Thread thread1, Throwable throwable)
                {
                    Debug.TRACE();
                    throwable.printStackTrace();
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    super();
                }
            }

            thread.setUncaughtExceptionHandler(new _cls1());
            return thread;
        }

        _cls1()
        {
            this$0 = AbsGattCallback.this;
            super();
        }
    }


    private class _cls16
        implements Runnable
    {

        final BluetoothGattCharacteristic val$characteristic;
        final BluetoothGatt val$gatt;

        public void run()
        {
            Debug.TRACE();
            Debug.ASSERT_RUN_ON_THREAD(AbsGattCallback.c_GattQueueThread);
            Debug.ASSERT_NOT_NULL(gatt);
            if (gatt != null) goto _L2; else goto _L1
_L1:
            AbsGattCallback.c_GattOperationLock.lock();
            AbsGattCallback.c_ReturnValue = 65281;
            Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: synchronizedReadCharacteristic(): ").append(AbsGattCallback.c_ReturnValue).toString());
            AbsGattCallback.c_isGattOperationLocking = false;
            AbsGattCallback.c_condGattOperationComplete.signal();
            AbsGattCallback.c_GattOperationLock.unlock();
_L4:
            return;
            Exception exception1;
            exception1;
            AbsGattCallback.c_GattOperationLock.unlock();
            throw exception1;
_L2:
            boolean flag;
            flag = gatt.readCharacteristic(characteristic);
            Debug.ASSERT_TRUE(flag);
            if (flag) goto _L4; else goto _L3
_L3:
            AbsGattCallback.c_GattOperationLock.lock();
            AbsGattCallback.c_ReturnValue = 65282;
            Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: synchronizedReadCharacteristic(): ").append(AbsGattCallback.c_ReturnValue).toString());
            AbsGattCallback.c_isGattOperationLocking = false;
            AbsGattCallback.c_condGattOperationComplete.signal();
            AbsGattCallback.c_GattOperationLock.unlock();
            return;
            Exception exception;
            exception;
            AbsGattCallback.c_GattOperationLock.unlock();
            throw exception;
        }

        _cls16()
        {
            gatt = bluetoothgatt;
            characteristic = bluetoothgattcharacteristic;
            super();
        }
    }


    private class _cls18
        implements Runnable
    {

        final BluetoothGattDescriptor val$descriptor;
        final BluetoothGatt val$gatt;

        public void run()
        {
            Debug.TRACE();
            Debug.ASSERT_RUN_ON_THREAD(AbsGattCallback.c_GattQueueThread);
            Debug.ASSERT_NOT_NULL(gatt);
            if (gatt != null) goto _L2; else goto _L1
_L1:
            AbsGattCallback.c_GattOperationLock.lock();
            AbsGattCallback.c_ReturnValue = 65281;
            Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: synchronizedReadDescriptor(): ").append(AbsGattCallback.c_ReturnValue).toString());
            AbsGattCallback.c_isGattOperationLocking = false;
            AbsGattCallback.c_condGattOperationComplete.signal();
            AbsGattCallback.c_GattOperationLock.unlock();
_L4:
            return;
            Exception exception1;
            exception1;
            AbsGattCallback.c_GattOperationLock.unlock();
            throw exception1;
_L2:
            boolean flag;
            flag = gatt.readDescriptor(descriptor);
            Debug.ASSERT_TRUE(flag);
            if (flag) goto _L4; else goto _L3
_L3:
            AbsGattCallback.c_GattOperationLock.lock();
            AbsGattCallback.c_ReturnValue = 65282;
            Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: synchronizedReadDescriptor(): ").append(AbsGattCallback.c_ReturnValue).toString());
            AbsGattCallback.c_isGattOperationLocking = false;
            AbsGattCallback.c_condGattOperationComplete.signal();
            AbsGattCallback.c_GattOperationLock.unlock();
            return;
            Exception exception;
            exception;
            AbsGattCallback.c_GattOperationLock.unlock();
            throw exception;
        }

        _cls18()
        {
            gatt = bluetoothgatt;
            descriptor = bluetoothgattdescriptor;
            super();
        }
    }


    private class _cls17
        implements Runnable
    {

        final BluetoothGattCharacteristic val$characteristic;
        final BluetoothGatt val$gatt;
        final byte val$value[];

        public void run()
        {
            Debug.TRACE();
            Debug.ASSERT_RUN_ON_THREAD(AbsGattCallback.c_GattQueueThread);
            Debug.ASSERT_NOT_NULL(gatt);
            if (gatt != null) goto _L2; else goto _L1
_L1:
            AbsGattCallback.c_GattOperationLock.lock();
            AbsGattCallback.c_ReturnValue = 65281;
            Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: synchronizedWriteCharacteristic(): ").append(AbsGattCallback.c_ReturnValue).toString());
            AbsGattCallback.c_isGattOperationLocking = false;
            AbsGattCallback.c_condGattOperationComplete.signal();
            AbsGattCallback.c_GattOperationLock.unlock();
_L4:
            return;
            Exception exception1;
            exception1;
            AbsGattCallback.c_GattOperationLock.unlock();
            throw exception1;
_L2:
            boolean flag;
            characteristic.setValue(value);
            flag = gatt.writeCharacteristic(characteristic);
            Debug.ASSERT_TRUE(flag);
            if (flag) goto _L4; else goto _L3
_L3:
            AbsGattCallback.c_GattOperationLock.lock();
            AbsGattCallback.c_ReturnValue = 65282;
            Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: synchronizedWriteCharacteristic(): ").append(AbsGattCallback.c_ReturnValue).toString());
            AbsGattCallback.c_isGattOperationLocking = false;
            AbsGattCallback.c_condGattOperationComplete.signal();
            AbsGattCallback.c_GattOperationLock.unlock();
            return;
            Exception exception;
            exception;
            AbsGattCallback.c_GattOperationLock.unlock();
            throw exception;
        }

        _cls17()
        {
            gatt = bluetoothgatt;
            characteristic = bluetoothgattcharacteristic;
            value = abyte0;
            super();
        }
    }


    private class _cls19
        implements Runnable
    {

        final BluetoothGattDescriptor val$descriptor;
        final BluetoothGatt val$gatt;
        final byte val$value[];

        public void run()
        {
            Debug.TRACE();
            Debug.ASSERT_RUN_ON_THREAD(AbsGattCallback.c_GattQueueThread);
            Debug.ASSERT_NOT_NULL(gatt);
            if (gatt != null) goto _L2; else goto _L1
_L1:
            AbsGattCallback.c_GattOperationLock.lock();
            AbsGattCallback.c_ReturnValue = 65281;
            Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: synchronizedWriteDescriptor(): ").append(AbsGattCallback.c_ReturnValue).toString());
            AbsGattCallback.c_isGattOperationLocking = false;
            AbsGattCallback.c_condGattOperationComplete.signal();
            AbsGattCallback.c_GattOperationLock.unlock();
_L4:
            return;
            Exception exception1;
            exception1;
            AbsGattCallback.c_GattOperationLock.unlock();
            throw exception1;
_L2:
            boolean flag;
            descriptor.setValue(value);
            flag = gatt.writeDescriptor(descriptor);
            Debug.ASSERT_TRUE(flag);
            if (flag) goto _L4; else goto _L3
_L3:
            AbsGattCallback.c_GattOperationLock.lock();
            AbsGattCallback.c_ReturnValue = 65282;
            Debug.DEBUG_LOCK((new StringBuilder()).append("NOTIFY: synchronizedWriteDescriptor(): ").append(AbsGattCallback.c_ReturnValue).toString());
            AbsGattCallback.c_isGattOperationLocking = false;
            AbsGattCallback.c_condGattOperationComplete.signal();
            AbsGattCallback.c_GattOperationLock.unlock();
            return;
            Exception exception;
            exception;
            AbsGattCallback.c_GattOperationLock.unlock();
            throw exception;
        }

        _cls19()
        {
            gatt = bluetoothgatt;
            descriptor = bluetoothgattdescriptor;
            value = abyte0;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final AbsGattCallback this$0;

        public void run()
        {
            connectInternal();
        }

        _cls3()
        {
            this$0 = AbsGattCallback.this;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final AbsGattCallback this$0;

        public void run()
        {
            disconnectInternal();
        }

        _cls4()
        {
            this$0 = AbsGattCallback.this;
            super();
        }
    }


    private class _cls11
        implements Runnable
    {

        final AbsGattCallback this$0;
        final IGattCallback.INotifyCallback val$notifyCB;
        final byte val$value[];

        public void run()
        {
            notifyCB.notify(value);
        }

        _cls11()
        {
            this$0 = AbsGattCallback.this;
            notifyCB = inotifycallback;
            value = abyte0;
            super();
        }
    }


    private class _cls12
        implements Runnable
    {

        final AbsGattCallback this$0;
        final BluetoothGattCharacteristic val$characteristic;

        public void run()
        {
            GattCB_onCharacteristicChanged(characteristic);
        }

        _cls12()
        {
            this$0 = AbsGattCallback.this;
            characteristic = bluetoothgattcharacteristic;
            super();
        }
    }


    private class _cls9
        implements Runnable
    {

        final AbsGattCallback this$0;
        final BluetoothGattCharacteristic val$characteristic;

        public void run()
        {
            GattCB_onCharacteristicRead(characteristic);
        }

        _cls9()
        {
            this$0 = AbsGattCallback.this;
            characteristic = bluetoothgattcharacteristic;
            super();
        }
    }


    private class _cls10
        implements Runnable
    {

        final AbsGattCallback this$0;
        final BluetoothGattCharacteristic val$characteristic;

        public void run()
        {
            GattCB_onCharacteristicWrite(characteristic);
        }

        _cls10()
        {
            this$0 = AbsGattCallback.this;
            characteristic = bluetoothgattcharacteristic;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final AbsGattCallback this$0;

        public void run()
        {
            GattCB_onConnected();
        }

        _cls5()
        {
            this$0 = AbsGattCallback.this;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final AbsGattCallback this$0;

        public void run()
        {
            GattCB_onDisconnected();
        }

        _cls6()
        {
            this$0 = AbsGattCallback.this;
            super();
        }
    }


    private class _cls7
        implements Runnable
    {

        final AbsGattCallback this$0;

        public void run()
        {
            GattCB_onConnectionFailed();
        }

        _cls7()
        {
            this$0 = AbsGattCallback.this;
            super();
        }
    }


    private class _cls13
        implements Runnable
    {

        final AbsGattCallback this$0;
        final BluetoothGattDescriptor val$descriptor;

        public void run()
        {
            GattCB_onDescriptorRead(descriptor);
        }

        _cls13()
        {
            this$0 = AbsGattCallback.this;
            descriptor = bluetoothgattdescriptor;
            super();
        }
    }


    private class _cls14
        implements Runnable
    {

        final AbsGattCallback this$0;
        final BluetoothGattDescriptor val$descriptor;

        public void run()
        {
            GattCB_onDescriptorWrite(descriptor);
        }

        _cls14()
        {
            this$0 = AbsGattCallback.this;
            descriptor = bluetoothgattdescriptor;
            super();
        }
    }


    private class _cls15
        implements Runnable
    {

        final AbsGattCallback this$0;
        final int val$rssi;

        public void run()
        {
            GattCB_onReadRemoteRssi(rssi);
        }

        _cls15()
        {
            this$0 = AbsGattCallback.this;
            rssi = i;
            super();
        }
    }


    private class _cls8
        implements Runnable
    {

        final AbsGattCallback this$0;

        public void run()
        {
            GattCB_onServiceDiscovered();
        }

        _cls8()
        {
            this$0 = AbsGattCallback.this;
            super();
        }
    }


    private class _cls2
        implements Thread.UncaughtExceptionHandler
    {

        public void uncaughtException(Thread thread, Throwable throwable)
        {
            Debug.TRACE();
            throwable.printStackTrace();
        }

        _cls2()
        {
        }
    }

}
