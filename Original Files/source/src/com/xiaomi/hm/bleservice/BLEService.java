// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import com.xiaomi.hm.bleservice.gatt.IGattCallback;
import com.xiaomi.hm.bleservice.util.Debug;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

// Referenced classes of package com.xiaomi.hm.bleservice:
//            a, b, c, e, 
//            f, g

public final class BLEService extends Service
{

    private static final String CLASS_NAME = com/xiaomi/hm/bleservice/BLEService.getSimpleName();
    private static final String HANDLER_THREAD_NAME = CLASS_NAME;
    public static final String INTENT_ACTION_DEVICE_CONNECTED = (new StringBuilder()).append(INTENT_PREFIX).append(".INTENT_ACTION_DEVICE_CONNECTED").toString();
    public static final String INTENT_ACTION_DEVICE_CONNECTION_FAILED = (new StringBuilder()).append(INTENT_PREFIX).append(".INTENT_ACTION_DEVICE_CONNECTION_FAILED").toString();
    public static final String INTENT_ACTION_DEVICE_CONNECTION_RESET = (new StringBuilder()).append(INTENT_PREFIX).append(".INTENT_ACTION_DEVICE_CONNECTION_RESET").toString();
    public static final String INTENT_ACTION_DEVICE_DISCONNECTED = (new StringBuilder()).append(INTENT_PREFIX).append(".INTENT_ACTION_DEVICE_DISCONNECTED").toString();
    public static final String INTENT_ACTION_DEVICE_FOUND = (new StringBuilder()).append(INTENT_PREFIX).append(".INTENT_ACTION_DEVICE_FOUND").toString();
    public static final String INTENT_EXTRA_DEVICE = (new StringBuilder()).append(INTENT_PREFIX).append(".INTENT_EXTRA_DEVICE").toString();
    public static final String INTENT_EXTRA_PARAM = (new StringBuilder()).append(INTENT_PREFIX).append(".INTENT_EXTRA_PARAM").toString();
    public static final String INTENT_EXTRA_PARAM_EXT = (new StringBuilder()).append(INTENT_PREFIX).append(".INTENT_EXTRA_PARAM_EXT").toString();
    private static final String INTENT_PREFIX = (new StringBuilder()).append(PACKAGE_NAME).append(".").append(CLASS_NAME).toString();
    public static final String MAC_ADDRESS_FILTER = "88:0F:10";
    public static final int MESSAGE_DEVICE_CONNECTED = 0;
    public static final int MESSAGE_DEVICE_CONNECTION_FAILED = 2;
    public static final int MESSAGE_DEVICE_CONNECTION_RESET = 3;
    public static final int MESSAGE_DEVICE_DISCONNECTED = 1;
    private static final String PACKAGE_NAME = com/xiaomi/hm/bleservice/BLEService.getPackage().getName();
    public static final String VERSION = "1.9.6.20140519";
    private static LocalBroadcastManager c_BroadcastManager = null;
    private final Binder m_Binder = new BLEServiceBinder();
    private final BluetoothAdapter m_BluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    private BroadcastReceiver m_BroadcastReceiver;
    private BluetoothDevice m_Device;
    private IGattCallback m_GattPeripheral;
    private final Handler m_Handler;
    private final HandlerThread m_HandlerThread;
    private android.bluetooth.BluetoothAdapter.LeScanCallback m_LeScanCallback;
    private UUID m_ServiceFilter[];
    private Runnable m_StopScanRunnable;

    public BLEService()
    {
        m_GattPeripheral = null;
        m_Device = null;
        m_ServiceFilter = null;
        m_LeScanCallback = null;
        m_StopScanRunnable = null;
        m_BroadcastReceiver = null;
        Debug.TRACE();
        m_HandlerThread = new HandlerThread(HANDLER_THREAD_NAME);
        m_HandlerThread.setUncaughtExceptionHandler(new a(this));
        m_HandlerThread.start();
        m_Handler = new b(this, m_HandlerThread.getLooper());
    }

    public static LocalBroadcastManager getBroadcastManager()
    {
        Debug.TRACE();
        Debug.ASSERT_NOT_NULL(c_BroadcastManager);
        return c_BroadcastManager;
    }

    private void handleMessage(Message message)
    {
        Debug.TRACE();
        Debug.ASSERT_RUN_ON_THREAD(m_HandlerThread);
        int i = message.what;
        Object obj = message.obj;
        Debug.ASSERT_NOT_NULL(obj);
        Intent intent;
        switch (i)
        {
        default:
            Debug.WARN(">>> UNEXPECTED <<<");
            return;

        case 0: // '\0'
            Intent intent3 = new Intent(INTENT_ACTION_DEVICE_CONNECTED);
            intent3.putExtra(INTENT_EXTRA_DEVICE, (BluetoothDevice)obj);
            c_BroadcastManager.sendBroadcast(intent3);
            return;

        case 1: // '\001'
            Intent intent2 = new Intent(INTENT_ACTION_DEVICE_DISCONNECTED);
            intent2.putExtra(INTENT_EXTRA_DEVICE, (BluetoothDevice)obj);
            c_BroadcastManager.sendBroadcast(intent2);
            return;

        case 2: // '\002'
            Intent intent1 = new Intent(INTENT_ACTION_DEVICE_CONNECTION_FAILED);
            intent1.putExtra(INTENT_EXTRA_DEVICE, (BluetoothDevice)obj);
            c_BroadcastManager.sendBroadcast(intent1);
            return;

        case 3: // '\003'
            intent = new Intent(INTENT_ACTION_DEVICE_CONNECTION_RESET);
            break;
        }
        intent.putExtra(INTENT_EXTRA_DEVICE, (BluetoothDevice)obj);
        c_BroadcastManager.sendBroadcast(intent);
    }

    private void onReceive(Context context, Intent intent)
    {
        String s;
        Debug.TRACE();
        Debug.ASSERT_RUN_ON_THREAD(m_HandlerThread);
        s = intent.getAction();
        Debug.DEBUG((new StringBuilder()).append("#Broadcast# Intent: ").append(intent.getAction()).toString());
        if (!s.equals("android.bluetooth.adapter.action.STATE_CHANGED")) goto _L2; else goto _L1
_L1:
        intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0x80000000);
        JVM INSTR tableswitch 10 13: default 92
    //                   10 105
    //                   11 112
    //                   12 98
    //                   13 119;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        Debug.WARN(">>> UNEXPECTED <<<");
_L9:
        return;
_L6:
        Debug.INFO("#Broadcast# Bluetooth ON.");
        return;
_L4:
        Debug.INFO("#Broadcast# Bluetooth OFF.");
        return;
_L5:
        Debug.INFO("#Broadcast# Bluetooth turning ON.");
        return;
_L7:
        Debug.INFO("#Broadcast# Bluetooth turning OFF.");
        return;
_L2:
        if (s.equals("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED"))
        {
            int k = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
            int l = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
            BluetoothDevice bluetoothdevice6 = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            Debug.DEBUG((new StringBuilder()).append("#Broadcast# state: ").append(k).append(", prev state: ").append(l).append(", device: ").append(bluetoothdevice6.getAddress()).toString());
            return;
        }
        if (s.equals("android.bluetooth.device.action.ACL_CONNECTED"))
        {
            BluetoothDevice bluetoothdevice5 = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            Debug.DEBUG((new StringBuilder()).append("#Broadcast# device: ").append(bluetoothdevice5.getAddress()).toString());
            return;
        }
        if (s.equals("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED"))
        {
            BluetoothDevice bluetoothdevice4 = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            Debug.DEBUG((new StringBuilder()).append("#Broadcast# device: ").append(bluetoothdevice4.getAddress()).toString());
            return;
        }
        if (s.equals("android.bluetooth.device.action.ACL_DISCONNECTED"))
        {
            BluetoothDevice bluetoothdevice3 = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            Debug.DEBUG((new StringBuilder()).append("#Broadcast# device: ").append(bluetoothdevice3.getAddress()).toString());
            return;
        }
        if (s.equals("android.bluetooth.device.action.BOND_STATE_CHANGED"))
        {
            BluetoothDevice bluetoothdevice2 = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            int i = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
            int j = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", -1);
            Debug.DEBUG((new StringBuilder()).append("#Broadcast# bond state: ").append(i).append(", prev bond state: ").append(j).append(", device: ").append(bluetoothdevice2.getAddress()).toString());
            return;
        }
        if (s.equals("android.bluetooth.device.action.CLASS_CHANGED"))
        {
            BluetoothDevice bluetoothdevice1 = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            BluetoothClass bluetoothclass = (BluetoothClass)intent.getParcelableExtra("android.bluetooth.device.extra.CLASS");
            Debug.DEBUG((new StringBuilder()).append("#Broadcast# device: ").append(bluetoothdevice1.getAddress()).append(", btClass: ").append(bluetoothclass.getDeviceClass()).toString());
            return;
        }
        if (s.equals("android.bluetooth.device.action.NAME_CHANGED"))
        {
            BluetoothDevice bluetoothdevice = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            String s1 = intent.getStringExtra("android.bluetooth.device.extra.NAME");
            Debug.DEBUG((new StringBuilder()).append("#Broadcast# device: ").append(bluetoothdevice.getAddress()).append(", name: ").append(s1).toString());
            return;
        }
        if (s.equals("android.bluetooth.device.action.PAIRING_REQUEST"))
        {
            return;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public Set getBondedDevices()
    {
        Debug.TRACE();
        return m_BluetoothAdapter.getBondedDevices();
    }

    public List getConnectedDevices()
    {
        Debug.TRACE();
        return ((BluetoothManager)getSystemService("bluetooth")).getConnectedDevices(7);
    }

    public IGattCallback getDefaultPeripheral()
    {
        Debug.TRACE();
        Debug.ASSERT_NOT_NULL(m_GattPeripheral);
        return m_GattPeripheral;
    }

    public IGattCallback newConnection(BluetoothDevice bluetoothdevice, Class class1)
    {
        BluetoothDevice bluetoothdevice1;
        Debug.TRACE();
        Debug.ASSERT_NOT_NULL(bluetoothdevice);
        Debug.ASSERT_NOT_NULL(class1);
        Debug.ASSERT_NULL(m_GattPeripheral);
        if (m_GattPeripheral == null)
        {
            break MISSING_BLOCK_LABEL_273;
        }
        Debug.WARN((new StringBuilder()).append("m_GattPeripheral != null, m_GattPeripheral.getState() = ").append(m_GattPeripheral.getState()).toString());
        bluetoothdevice1 = m_GattPeripheral.getDevice();
        Debug.ASSERT_NOT_NULL(bluetoothdevice1);
        if (bluetoothdevice1 == null)
        {
            break MISSING_BLOCK_LABEL_273;
        }
        ((BluetoothManager)getSystemService("bluetooth")).getConnectionState(bluetoothdevice1, 7);
        JVM INSTR tableswitch 0 3: default 124
    //                   0 204
    //                   1 174
    //                   2 144
    //                   3 234;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (bluetoothdevice1.getAddress().equals(bluetoothdevice.getAddress()))
        {
            return m_GattPeripheral;
        }
        break; /* Loop/switch isn't completed */
_L4:
        Debug.DEBUG((new StringBuilder()).append(bluetoothdevice1.getAddress()).append("[CONNECTED]").toString());
        continue; /* Loop/switch isn't completed */
_L3:
        Debug.DEBUG((new StringBuilder()).append(bluetoothdevice1.getAddress()).append("[CONNECTING]").toString());
        continue; /* Loop/switch isn't completed */
_L2:
        Debug.DEBUG((new StringBuilder()).append(bluetoothdevice1.getAddress()).append("[DISCONNECTED]").toString());
        continue; /* Loop/switch isn't completed */
_L5:
        Debug.DEBUG((new StringBuilder()).append(bluetoothdevice1.getAddress()).append("[DISCONNECTING]").toString());
        if (true) goto _L1; else goto _L6
_L6:
        m_GattPeripheral.disconnect();
        IGattCallback igattcallback;
        try
        {
            Constructor constructor = class1.getConstructor(new Class[] {
                android/content/Context, android/bluetooth/BluetoothDevice, android/os/Handler
            });
            Object aobj[] = new Object[3];
            aobj[0] = this;
            aobj[1] = bluetoothdevice;
            aobj[2] = m_Handler;
            igattcallback = (IGattCallback)constructor.newInstance(aobj);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            igattcallback = null;
        }
        Debug.ASSERT_NOT_NULL(igattcallback);
        m_GattPeripheral = igattcallback;
        return igattcallback;
    }

    public IBinder onBind(Intent intent)
    {
        Debug.TRACE();
        return m_Binder;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        Debug.TRACE();
        super.onConfigurationChanged(configuration);
    }

    public void onCreate()
    {
        Debug.TRACE();
        super.onCreate();
        c_BroadcastManager = LocalBroadcastManager.getInstance(this);
        m_BroadcastReceiver = new c(this);
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentfilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        intentfilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentfilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
        intentfilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentfilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        intentfilter.addAction("android.bluetooth.device.action.CLASS_CHANGED");
        intentfilter.addAction("android.bluetooth.device.action.NAME_CHANGED");
        intentfilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
        registerReceiver(m_BroadcastReceiver, intentfilter);
    }

    public void onDestroy()
    {
        Debug.TRACE();
        if (m_GattPeripheral != null)
        {
            m_GattPeripheral.setAutoReconnect(false);
            m_GattPeripheral.disconnect();
        }
        unregisterReceiver(m_BroadcastReceiver);
        m_Handler.post(new e(this));
        super.onDestroy();
    }

    public void onLowMemory()
    {
        Debug.TRACE();
        super.onLowMemory();
    }

    public void onRebind(Intent intent)
    {
        Debug.TRACE();
        Debug.WARN(">>> UNEXPECTED <<<");
        super.onRebind(intent);
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        Debug.TRACE();
        if (intent != null)
        {
            String s = intent.getAction();
            Debug.DEBUG((new StringBuilder()).append("Intent: ").append(s).toString());
        }
        return super.onStartCommand(intent, i, j);
    }

    public void onTaskRemoved(Intent intent)
    {
        Debug.TRACE();
        Debug.WARN("Calling onDestroy()...");
        super.onTaskRemoved(intent);
    }

    public void onTrimMemory(int i)
    {
        Debug.TRACE();
        super.onTrimMemory(i);
    }

    public boolean onUnbind(Intent intent)
    {
        Debug.TRACE();
        return super.onUnbind(intent);
    }

    public void setServiceFilter(UUID auuid[])
    {
        Debug.TRACE();
        m_ServiceFilter = auuid;
        if (auuid == null || auuid.length == 0)
        {
            Debug.WARN("SERVICE FILTER *NOT* SET.");
        }
    }

    public void startScan(int i)
    {
        Debug.TRACE();
        HashMap hashmap = new HashMap();
        if (m_LeScanCallback == null)
        {
            m_LeScanCallback = new f(this, hashmap);
        }
        hashmap.clear();
        Iterator iterator = getConnectedDevices().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            BluetoothDevice bluetoothdevice = (BluetoothDevice)iterator.next();
            if (bluetoothdevice.getAddress().startsWith("88:0F:10"))
            {
                hashmap.put(bluetoothdevice.getAddress(), bluetoothdevice);
                Intent intent = new Intent(INTENT_ACTION_DEVICE_FOUND);
                intent.putExtra(INTENT_EXTRA_DEVICE, bluetoothdevice);
                intent.putExtra(INTENT_EXTRA_PARAM, 0);
                c_BroadcastManager.sendBroadcast(intent);
            }
        } while (true);
        m_BluetoothAdapter.startLeScan(m_LeScanCallback);
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        m_StopScanRunnable = new g(this);
        m_Handler.postDelayed(m_StopScanRunnable, i);
    }

    public void stopScan()
    {
        Debug.TRACE();
        if (m_StopScanRunnable != null)
        {
            m_Handler.removeCallbacks(m_StopScanRunnable);
            m_StopScanRunnable = null;
            m_BluetoothAdapter.stopLeScan(m_LeScanCallback);
            m_LeScanCallback = null;
        }
    }

    static 
    {
        Debug.INFO((new StringBuilder()).append(com/xiaomi/hm/bleservice/BLEService.getSimpleName()).append(".VERSION: ").append("1.9.6.20140519").toString());
    }








    private class BLEServiceBinder extends Binder
    {

        final BLEService a;

        public BLEService getService()
        {
            return a;
        }

        public BLEServiceBinder()
        {
            a = BLEService.this;
            super();
        }
    }

}
