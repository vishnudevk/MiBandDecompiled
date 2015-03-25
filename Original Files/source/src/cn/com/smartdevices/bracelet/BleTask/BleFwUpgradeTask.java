// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import com.xiaomi.hm.bleservice.util.Helper;
import java.io.FileInputStream;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleTask, BleCallBack

public class BleFwUpgradeTask extends BleTask
{

    private static Object d = new Object();
    private static Object e = new Object();
    private static Object f = new Object();
    private static Object g = new Object();
    private String a;
    private String b;
    private byte c[];

    public BleFwUpgradeTask(String s, String s1, BleCallBack blecallback)
    {
        super(blecallback);
        a = null;
        b = null;
        c = null;
        a = s1;
        b = s;
    }

    public BleFwUpgradeTask(String s, byte abyte0[], BleCallBack blecallback)
    {
        super(blecallback);
        a = null;
        b = null;
        c = null;
        c = abyte0;
        b = s;
    }

    public static void waiting()
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        Debug.i(TAG, "BleFwUpgradeTask before waiting...");
        Exception exception;
        try
        {
            d.wait(10000L);
        }
        catch (InterruptedException interruptedexception) { }
        Debug.i(TAG, (new StringBuilder()).append("BleFwUpgradeTask after waiting...").append(e).toString());
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void waitingFwUpdate()
    {
        Object obj = f;
        obj;
        JVM INSTR monitorenter ;
        Debug.i(TAG, "BleFwUpgradeTask before waitingFwUpdate...");
        Exception exception;
        try
        {
            f.wait(10000L);
        }
        catch (InterruptedException interruptedexception) { }
        Debug.i(TAG, (new StringBuilder()).append("BleFwUpgradeTask after waitingFwUpdate...").append(g).toString());
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void waitingNotify(Object obj)
    {
        Debug.i(TAG, (new StringBuilder()).append("waitingNotify:").append(obj).toString());
        synchronized (d)
        {
            e = obj;
            d.notify();
        }
        return;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void waitingNotifyFwUpdate(Object obj)
    {
        Debug.i(TAG, (new StringBuilder()).append("waitingNotifyFwUpdate:").append(obj).toString());
        synchronized (f)
        {
            g = obj;
            f.notify();
        }
        return;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void doWork(BleCallBack blecallback)
    {
        Thread.currentThread().setPriority(10);
        e = Integer.valueOf(-1);
        blecallback.sendOnStartMessage();
        if (a != null)
        {
            try
            {
                FileInputStream fileinputstream = new FileInputStream(a);
                c = new byte[fileinputstream.available()];
                fileinputstream.read(c);
                fileinputstream.close();
            }
            catch (Exception exception)
            {
                c = null;
            }
        }
        if (c == null || c.length < 1)
        {
            Debug.i(TAG, "no fw data!");
            blecallback.sendOnFinishMessage(Integer.valueOf(1));
            return;
        }
        int i = Utils.getFwVersion(c);
        Debug.i(TAG, (new StringBuilder()).append("new firmware version:").append(i).toString());
        String as[] = b.split(":");
        int j = ((0xff & Integer.decode((new StringBuilder()).append("0x").append(as[4]).toString()).byteValue()) << 8 | 0xff & Integer.decode((new StringBuilder()).append("0x").append(as[5]).toString()).byteValue()) ^ Helper.CRC16(c);
        if (!gattPeripheral.sendFirmwareInfo(gattPeripheral.getDeviceInfo().firmwareVersion, i, c.length, j))
        {
            Debug.i(TAG, "prepareFirmwareUpdate failed!");
            blecallback.sendOnFinishMessage(Integer.valueOf(1));
            return;
        }
        if (((Integer)e).intValue() == -1)
        {
            waiting();
        }
        if (((Integer)e).intValue() != 12)
        {
            blecallback.sendOnFinishMessage(Integer.valueOf(1));
            return;
        }
        g = Integer.valueOf(-1);
        if (!gattPeripheral.sendFirmwareData(c))
        {
            Debug.i(TAG, "sendFirmwareData failed!");
            blecallback.sendOnFinishMessage(Integer.valueOf(1));
            gattPeripheral.resetFirmwareUpdatingProgress();
            return;
        }
        if (((Integer)g).intValue() == -1)
        {
            waitingFwUpdate();
        }
        int k = ((Integer)g).intValue();
        int l;
        boolean flag;
        byte byte0;
        if (k == -1)
        {
            l = 1;
        } else
        {
            l = k;
        }
        flag = false;
        if (l == 2)
        {
            flag = gattPeripheral._reboot();
        }
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 1;
        }
        blecallback.sendOnFinishMessage(Integer.valueOf(byte0));
        gattPeripheral.resetFirmwareUpdatingProgress();
    }

}
