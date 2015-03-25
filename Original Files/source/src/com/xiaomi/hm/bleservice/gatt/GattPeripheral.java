// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.hm.bleservice.util.Debug;
import com.xiaomi.hm.bleservice.util.Helper;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xiaomi.hm.bleservice.gatt:
//            AbsGattCallback, IGattProfile

public class GattPeripheral extends AbsGattCallback
    implements IGattProfile
{

    private FileLock __android_bug_FileLock;
    private FileOutputStream __android_bug_FileOutputStream;
    private boolean m_AutoReconnect;
    private int m_AutoReconnectCount;
    private final Handler m_Messenger;

    protected GattPeripheral(Context context, BluetoothDevice bluetoothdevice, Handler handler)
    {
        super(context, bluetoothdevice);
        m_AutoReconnect = true;
        m_AutoReconnectCount = -1;
        __android_bug_FileOutputStream = null;
        __android_bug_FileLock = null;
        Debug.TRACE();
        m_Messenger = handler;
    }

    private void __lockFile()
    {
        Debug.TRACE();
        try
        {
            __android_bug_FileOutputStream = new FileOutputStream((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/Android/.btlock").toString());
            __android_bug_FileLock = __android_bug_FileOutputStream.getChannel().lock();
            Debug.DEBUG((new StringBuilder()).append("FileLock: ").append(__android_bug_FileLock.isValid()).toString());
            __android_bug_FileOutputStream.write(1);
            return;
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            filenotfoundexception.printStackTrace();
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    private void __releaseFile()
    {
        Debug.TRACE();
        if (__android_bug_FileOutputStream == null || __android_bug_FileLock == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        __android_bug_FileOutputStream.write(0);
        __android_bug_FileLock.release();
        __android_bug_FileOutputStream.close();
        return;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        return;
    }

    protected void GattCB_onCharacteristicChanged(BluetoothGattCharacteristic bluetoothgattcharacteristic)
    {
        Debug.TRACE();
    }

    protected void GattCB_onCharacteristicRead(BluetoothGattCharacteristic bluetoothgattcharacteristic)
    {
        Debug.TRACE();
    }

    protected void GattCB_onCharacteristicWrite(BluetoothGattCharacteristic bluetoothgattcharacteristic)
    {
        Debug.TRACE();
    }

    protected void GattCB_onConnected()
    {
        Debug.TRACE();
        m_Messenger.obtainMessage(0, getDevice()).sendToTarget();
        __lockFile();
        getGatt().discoverServices();
    }

    protected void GattCB_onConnectionFailed()
    {
        Debug.TRACE();
        m_Messenger.obtainMessage(2, getDevice()).sendToTarget();
        cleanupInternal();
    }

    protected void GattCB_onDescriptorRead(BluetoothGattDescriptor bluetoothgattdescriptor)
    {
        Debug.TRACE();
    }

    protected void GattCB_onDescriptorWrite(BluetoothGattDescriptor bluetoothgattdescriptor)
    {
        Debug.TRACE();
    }

    protected void GattCB_onDisconnected()
    {
        Debug.TRACE();
        m_Messenger.obtainMessage(1, getDevice()).sendToTarget();
        cleanupInternal();
    }

    protected void GattCB_onReadRemoteRssi(int i)
    {
        Debug.TRACE();
    }

    protected void GattCB_onServiceDiscovered()
    {
        Debug.TRACE();
        __releaseFile();
        for (Iterator iterator = getGatt().getServices().iterator(); iterator.hasNext();)
        {
            BluetoothGattService bluetoothgattservice = (BluetoothGattService)iterator.next();
            StringBuilder stringbuilder = new StringBuilder();
            String s;
            Iterator iterator1;
            if (bluetoothgattservice.getType() == 0)
            {
                s = "Primary";
            } else
            {
                s = "Secondary";
            }
            Debug.DEBUG(stringbuilder.append(s).append(" service: ").append(Helper.parseUUID(bluetoothgattservice.getUuid())).toString());
            iterator1 = bluetoothgattservice.getCharacteristics().iterator();
            while (iterator1.hasNext()) 
            {
                BluetoothGattCharacteristic bluetoothgattcharacteristic = (BluetoothGattCharacteristic)iterator1.next();
                Debug.DEBUG((new StringBuilder()).append("  Characteristic: ").append(Helper.parseUUID(bluetoothgattcharacteristic.getUuid())).toString());
                Debug.DEBUG((new StringBuilder()).append("    - Properties: ").append(Helper.parseProperties(bluetoothgattcharacteristic.getProperties())).toString());
                Iterator iterator2 = bluetoothgattcharacteristic.getDescriptors().iterator();
                while (iterator2.hasNext()) 
                {
                    BluetoothGattDescriptor bluetoothgattdescriptor = (BluetoothGattDescriptor)iterator2.next();
                    Debug.DEBUG((new StringBuilder()).append("    Descriptor: ").append(Helper.parseUUID(bluetoothgattdescriptor.getUuid())).toString());
                }
            }
        }

        boolean flag = init();
        Debug.ASSERT_TRUE(flag);
        if (!flag)
        {
            disconnectInternal();
        }
    }

    public void cleanup()
    {
        Debug.TRACE();
    }

    protected void cleanupInternal()
    {
label0:
        {
label1:
            {
                Debug.TRACE();
                cleanup();
                super.cleanupInternal();
                if (m_AutoReconnect)
                {
                    if (m_AutoReconnectCount == -1)
                    {
                        break label0;
                    }
                    if (m_AutoReconnectCount != 0)
                    {
                        break label1;
                    }
                }
                return;
            }
            m_AutoReconnectCount = -1 + m_AutoReconnectCount;
        }
        try
        {
            Debug.DEBUG("Delay 1 second before reconnect...");
            Thread.sleep(5000L);
        }
        catch (InterruptedException interruptedexception) { }
        connectInternal();
    }

    protected final void connectInternal()
    {
        Debug.TRACE();
        do
        {
            try
            {
                for (; BluetoothAdapter.getDefaultAdapter().getState() != 12; Thread.sleep(1000L))
                {
                    Debug.DEBUG((new StringBuilder()).append("BluetoothAdapter enable:").append(BluetoothAdapter.getDefaultAdapter().isEnabled()).toString());
                }

                break;
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        } while (true);
        Debug.DEBUG((new StringBuilder()).append("BluetoothAdapter enable:").append(BluetoothAdapter.getDefaultAdapter().isEnabled()).toString());
        Thread.sleep(1000L);
        Debug.DEBUG("device:");
        Debug.DEBUG((new StringBuilder()).append("         name: ").append(getDevice().getName()).toString());
        Debug.DEBUG((new StringBuilder()).append("      address: ").append(getDevice().getAddress()).toString());
        getDevice().getBondState();
        JVM INSTR tableswitch 10 12: default 192
    //                   10 251
    //                   11 242
    //                   12 233;
           goto _L1 _L2 _L3 _L4
_L1:
        getDevice().getType();
        JVM INSTR tableswitch 0 3: default 228
    //                   0 287
    //                   1 269
    //                   2 260
    //                   3 278;
           goto _L5 _L6 _L7 _L8 _L9
_L5:
        super.connectInternal();
        return;
_L4:
        Debug.DEBUG("   bond state: BONDED");
          goto _L1
_L3:
        Debug.DEBUG("   bond state: BONDING");
          goto _L1
_L2:
        Debug.DEBUG("   bond state: NONE");
          goto _L1
_L8:
        Debug.DEBUG("         type: LE");
          goto _L5
_L7:
        Debug.DEBUG("         type: CLASSIC");
          goto _L5
_L9:
        Debug.DEBUG("         type: DUAL");
          goto _L5
_L6:
        Debug.DEBUG("         type: UNKNOWN");
          goto _L5
    }

    protected final void disconnectInternal()
    {
        Debug.TRACE();
        super.disconnectInternal();
    }

    public final boolean getAutoReconnect()
    {
        return m_AutoReconnect;
    }

    public final int getAutoReconnectCount()
    {
        return m_AutoReconnectCount;
    }

    public boolean init()
    {
        Debug.TRACE();
        return true;
    }

    public byte[] read(BluetoothGattCharacteristic bluetoothgattcharacteristic)
    {
        Debug.TRACE();
        Debug.ASSERT_NOT_NULL(bluetoothgattcharacteristic);
        if (bluetoothgattcharacteristic == null)
        {
            return null;
        }
        int i = readCharacteristic(bluetoothgattcharacteristic);
        boolean flag;
        byte abyte0[];
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        if (i == 0)
        {
            abyte0 = bluetoothgattcharacteristic.getValue();
        } else
        {
            abyte0 = null;
        }
        return abyte0;
    }

    public volatile void refreshGatt()
    {
        super.refreshGatt();
    }

    public final void setAutoReconnect(boolean flag)
    {
        Debug.TRACE();
        m_AutoReconnect = flag;
        m_AutoReconnectCount = -1;
    }

    public final void setAutoReconnect(boolean flag, int i)
    {
        m_AutoReconnect = flag;
        m_AutoReconnectCount = i;
    }

    public boolean write(BluetoothGattCharacteristic bluetoothgattcharacteristic, byte abyte0[])
    {
        boolean flag = true;
        Debug.TRACE();
        Debug.ASSERT_NOT_NULL(bluetoothgattcharacteristic);
        Debug.ASSERT_NOT_NULL(abyte0);
        if (bluetoothgattcharacteristic == null || abyte0 == null)
        {
            flag = false;
        } else
        {
            int i = writeCharacteristic(bluetoothgattcharacteristic, abyte0);
            boolean flag1;
            if (i == 0)
            {
                flag1 = flag;
            } else
            {
                flag1 = false;
            }
            Debug.ASSERT_TRUE(flag1);
            if (i != 0)
            {
                return false;
            }
        }
        return flag;
    }
}
