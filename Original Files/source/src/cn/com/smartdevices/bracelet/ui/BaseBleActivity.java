// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleFwUpgradeTask;
import cn.com.smartdevices.bracelet.BleTask.BleSetDesiredLatency;
import cn.com.smartdevices.bracelet.BleTask.BleTogglePairTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.view.CustomToast;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, j, k, l, 
//            m

public abstract class BaseBleActivity extends SystemBarTintActivity
{

    public static final int MSG_UPDATE_PRESSED_TIME = 520;
    public static final int UPDATE_PRESSED_TIMEOUT = 2000;
    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 3;
    private static final int d = 4;
    private static final int e = 5;
    private static final int f = 8;
    private static final int g = 10;
    private static final int h = 11;
    private static final int i = 12;
    private static final int j = 13;
    private static int o = -1;
    private long k;
    private Handler l;
    private BroadcastReceiver m;
    private String n;
    private boolean p;
    private int q;
    private int r;

    public BaseBleActivity()
    {
        k = -1L;
        l = null;
        m = null;
        n = "BaseBleActivity";
        p = false;
        q = 1;
        r = -1;
    }

    static long a(BaseBleActivity basebleactivity, long l1)
    {
        basebleactivity.k = l1;
        return l1;
    }

    static String a(BaseBleActivity basebleactivity)
    {
        return basebleactivity.n;
    }

    private void a()
    {
        l = new j(this);
        m = new k(this);
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction(BLEService.INTENT_ACTION_DEVICE_FOUND);
        intentfilter.addAction(MiLiProfile.INTENT_ACTION_DEVICE_STATUS_CHANGED);
        intentfilter.addAction(BLEService.INTENT_ACTION_DEVICE_CONNECTED);
        intentfilter.addAction(MiLiProfile.INTENT_ACTION_INITIALIZATION_SUCCESS);
        intentfilter.addAction(MiLiProfile.INTENT_ACTION_INITIALIZATION_FAILED);
        intentfilter.addAction(BLEService.INTENT_ACTION_DEVICE_DISCONNECTED);
        intentfilter.addAction(BLEService.INTENT_ACTION_DEVICE_CONNECTION_FAILED);
        intentfilter.addAction(MiLiProfile.INTENT_ACTION_DEVICE_BATTERY_STATUS_CHANGED);
        LocalBroadcastManager.getInstance(this).registerReceiver(m, intentfilter);
        IntentFilter intentfilter1 = new IntentFilter();
        intentfilter1.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        registerReceiver(m, intentfilter1);
    }

    private void a(int i1)
    {
        Debug.f(n, (new StringBuilder()).append("onBatteryLowNotification:").append(i1).toString());
        if (r == i1)
        {
            return;
        }
        r = i1;
        NotificationManager notificationmanager = (NotificationManager)getSystemService("notification");
        String s = getString(0x7f0d0111);
        String s1 = getString(0x7f0d010f);
        if (i1 == 0)
        {
            s = getString(0x7f0d0112);
            s1 = getString(0x7f0d0110);
        }
        android.support.v4.app.NotificationCompat.Builder builder = (new android.support.v4.app.NotificationCompat.Builder(this)).setSmallIcon(0x7f020004).setContentTitle(s).setContentText(s1).setAutoCancel(true);
        builder.setVibrate(new long[] {
            100L, 500L, 500L, 500L
        });
        builder.setContentIntent(PendingIntent.getBroadcast(this, 0, new Intent("ACTION_BATTERY_LOW"), 0x10000000));
        notificationmanager.notify(q, builder.build());
    }

    static void a(BaseBleActivity basebleactivity, int i1)
    {
        basebleactivity.c(i1);
    }

    static Handler b(BaseBleActivity basebleactivity)
    {
        return basebleactivity.l;
    }

    private void b()
    {
        ((NotificationManager)getSystemService("notification")).cancel(q);
    }

    private void b(int i1)
    {
        i1;
        JVM INSTR tableswitch 13 22: default 56
    //                   13 57
    //                   14 124
    //                   15 134
    //                   16 144
    //                   17 154
    //                   18 164
    //                   19 174
    //                   20 184
    //                   21 194
    //                   22 204;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        return;
_L2:
        String s = getString(0x7f0d011a);
_L13:
        NotificationManager notificationmanager = (NotificationManager)getSystemService("notification");
        String s1 = getString(0x7f0d0113);
        android.support.v4.app.NotificationCompat.Builder builder = (new android.support.v4.app.NotificationCompat.Builder(this)).setSmallIcon(0x7f020004).setContentTitle(s1).setContentText(s).setAutoCancel(true);
        notificationmanager.notify(q, builder.build());
        return;
_L3:
        s = getString(0x7f0d0117);
        continue; /* Loop/switch isn't completed */
_L4:
        s = getString(0x7f0d0118);
        continue; /* Loop/switch isn't completed */
_L5:
        s = getString(0x7f0d011c);
        continue; /* Loop/switch isn't completed */
_L6:
        s = getString(0x7f0d0114);
        continue; /* Loop/switch isn't completed */
_L7:
        s = getString(0x7f0d0119);
        continue; /* Loop/switch isn't completed */
_L8:
        s = getString(0x7f0d0115);
        continue; /* Loop/switch isn't completed */
_L9:
        s = getString(0x7f0d011b);
        continue; /* Loop/switch isn't completed */
_L10:
        s = getString(0x7f0d0116);
        continue; /* Loop/switch isn't completed */
_L11:
        s = getString(0x7f0d011d);
        if (true) goto _L13; else goto _L12
_L12:
    }

    private void c()
    {
        (new BleTogglePairTask(Keeper.readPersonInfo(), new l(this))).work();
    }

    private void c(int i1)
    {
        Debug.i(n, (new StringBuilder()).append("onDeviceStatusChanged:").append(i1).toString());
        Debug.f(n, (new StringBuilder()).append("onDeviceStatusChanged:").append(i1).toString());
        if (i1 >= 13 && i1 <= 22)
        {
            b(i1);
            return;
        }
        switch (i1)
        {
        case 3: // '\003'
        case 4: // '\004'
        case 7: // '\007'
        default:
            return;

        case 1: // '\001'
            onFwUpgradeFailed();
            return;

        case 8: // '\b'
            onDeviceSetLatencySuccess();
            return;

        case 2: // '\002'
            onFwUpgradeSuccess();
            return;

        case 6: // '\006'
            onAuthenticationFailed();
            return;

        case 5: // '\005'
            onAuthenticationSuccess();
            return;

        case 11: // '\013'
            onSendFwInfoFailed();
            return;

        case 12: // '\f'
            onSendFwInfoSuccess();
            return;

        case 9: // '\t'
            onResetAuthenticationFailed();
            return;

        case 10: // '\n'
            onResetAuthentiacationSuccess();
            return;
        }
    }

    public static int getDeviceStatus()
    {
        if (BraceletApp.BLEService != null)
        {
            if ((MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral() != null)
            {
                return o;
            } else
            {
                return -1;
            }
        } else
        {
            return -1;
        }
    }

    public static int getProfileStatus()
    {
        if (BraceletApp.BLEService != null)
        {
            MiLiProfile miliprofile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
            if (miliprofile != null)
            {
                int i1 = miliprofile.getProfileState();
                if (i1 == 1)
                {
                    return 0;
                }
                if (i1 == 2)
                {
                    return 1;
                }
                if (i1 == 0)
                {
                    return -1;
                }
            }
        }
        return -1;
    }

    public void onAuthenticationFailed()
    {
        BleTogglePairTask.waitingNotify(Integer.valueOf(6));
    }

    public void onAuthenticationSuccess()
    {
        BleTogglePairTask.waitingNotify(Integer.valueOf(5));
        setLatency(39);
    }

    public void onBackPressed()
    {
        long l1 = System.currentTimeMillis();
        if (k == -1L)
        {
            CustomToast.makeText(this, 0x7f0d0018, 0).show();
            k = l1;
            l.sendEmptyMessageDelayed(520, 2000L);
        } else
        if (l1 - k < 2000L)
        {
            k = -1L;
            onHideApp();
            return;
        }
    }

    public void onBtOff()
    {
    }

    public void onBtOn()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Debug.i(n, "onCreate");
        a();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        Debug.i(n, "onDestory");
        LocalBroadcastManager.getInstance(this).unregisterReceiver(m);
        unregisterReceiver(m);
        l.removeCallbacksAndMessages(null);
        l = null;
        o = -1;
        r = -1;
    }

    public void onDeviceBatteryStatusChanged(byte byte0, int i1)
    {
        Debug.i(n, (new StringBuilder()).append("onDeviceBatteryStatusChanged:").append(byte0).append(",").append(i1).toString());
        Debug.f(n, (new StringBuilder()).append("onDeviceBatteryStatusChanged:").append(byte0).append(",").append(i1).toString());
        if (byte0 == 1)
        {
            a(i1);
        } else
        if (byte0 == 2)
        {
            b();
            return;
        }
    }

    public void onDeviceConnected()
    {
        p = false;
        o = 4;
    }

    public void onDeviceConnectionFailed()
    {
        p = false;
        o = 5;
    }

    public void onDeviceDisconnected()
    {
        p = false;
        o = 6;
    }

    public abstract void onDeviceFound(BluetoothDevice bluetoothdevice, int i1);

    public void onDeviceSetLatencySuccess()
    {
        BleSetDesiredLatency.waitingNotify(Integer.valueOf(8));
    }

    public void onFwUpgradeFailed()
    {
        BleFwUpgradeTask.waitingNotifyFwUpdate(Integer.valueOf(1));
    }

    public void onFwUpgradeSuccess()
    {
        BleFwUpgradeTask.waitingNotifyFwUpdate(Integer.valueOf(2));
    }

    protected void onHideApp()
    {
        moveTaskToBack(true);
    }

    public void onInitializationFailed()
    {
        p = false;
        o = 1;
    }

    public void onInitializationSuccess()
    {
        if (!p)
        {
            p = true;
            o = 0;
            c();
        }
    }

    public void onResetAuthentiacationSuccess()
    {
        BleTogglePairTask.waitingNotifyReset(Integer.valueOf(10));
        setLatency(39);
    }

    public void onResetAuthenticationFailed()
    {
        BleTogglePairTask.waitingNotifyReset(Integer.valueOf(9));
    }

    public void onSendFwInfoFailed()
    {
        BleFwUpgradeTask.waitingNotify(Integer.valueOf(11));
    }

    public void onSendFwInfoSuccess()
    {
        BleFwUpgradeTask.waitingNotify(Integer.valueOf(12));
    }

    public void onTogglePairProgress(int i1)
    {
    }

    public void onTogglePairResult(com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo deviceinfo)
    {
    }

    protected void setLatency(int i1)
    {
        Debug.f(n, (new StringBuilder()).append("current latency level set level:").append(i1).toString());
        android.os.PowerManager.WakeLock wakelock = ((PowerManager)getSystemService("power")).newWakeLock(1, "setLatency");
        Debug.f(n, (new StringBuilder()).append("waklock acquire......").append(i1).toString());
        wakelock.acquire();
        (new BleSetDesiredLatency(i1, new m(this, i1, wakelock))).workX();
    }

}
