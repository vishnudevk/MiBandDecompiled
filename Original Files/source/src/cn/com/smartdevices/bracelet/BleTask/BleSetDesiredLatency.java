// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleTask, BleCallBack

public class BleSetDesiredLatency extends BleTask
{

    public static String TAG = "BleTaskX";
    private static final int b = 2;
    private static Object c = new Object();
    protected static Object waitingResult = new Object();
    private int a;

    public BleSetDesiredLatency(int i, BleCallBack blecallback)
    {
        super(blecallback);
        a = 0;
        a = i;
    }

    private void a(int i)
    {
        Debug.i(TAG, (new StringBuilder()).append("value:").append(i).toString());
        Debug.f(TAG, (new StringBuilder()).append("value:").append(i).toString());
        waitingResult = Integer.valueOf(-1);
        if (i != 39) goto _L2; else goto _L1
_L1:
        boolean flag = gattPeripheral._setLEParams(39, 49, 0, 500, 0);
_L4:
        if (flag && ((Integer)waitingResult).intValue() == -1)
        {
            a(10000L);
        }
        com.xiaomi.hm.bleservice.profile.IMiLiProfile.LEParams leparams = gattPeripheral._getLEParams();
        Debug.i(TAG, (new StringBuilder()).append("out setLatency!\n").append(leparams).toString());
        Debug.f(TAG, (new StringBuilder()).append("out setLatency!\n").append(leparams).toString());
        return;
_L2:
        flag = false;
        if (i == 480)
        {
            flag = gattPeripheral._setLEParams(460, 500, 0, 500, 0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(long l)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        Debug.i(TAG, "before waiting...");
        Exception exception;
        try
        {
            c.wait(l);
        }
        catch (InterruptedException interruptedexception) { }
        Debug.i(TAG, (new StringBuilder()).append("after waiting...").append(waitingResult).toString());
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void waitingNotify(Object obj)
    {
        Debug.i(TAG, (new StringBuilder()).append("waitingNotify:").append(obj).toString());
        synchronized (c)
        {
            waitingResult = obj;
            c.notify();
        }
        return;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void doWork(BleCallBack blecallback)
    {
        com.xiaomi.hm.bleservice.profile.IMiLiProfile.LEParams leparams;
        if (blecallback != null)
        {
            blecallback.sendOnStartMessage();
        }
        leparams = gattPeripheral._getLEParams();
        if (leparams == null) goto _L2; else goto _L1
_L1:
        Debug.i(TAG, (new StringBuilder()).append("set latency:").append(a).append("\n").append(leparams).toString());
        Debug.f(TAG, (new StringBuilder()).append("set latency:").append(a).append("\n").append(leparams).toString());
        if (a != 39) goto _L4; else goto _L3
_L3:
        if (leparams.connInt < 39 || leparams.connInt > 49) goto _L2; else goto _L5
_L5:
        blecallback.sendOnFinishMessage(Integer.valueOf(8));
_L7:
        return;
_L4:
        if (a == 480 && leparams.connInt >= 460 && leparams.connInt <= 500)
        {
            blecallback.sendOnFinishMessage(Integer.valueOf(8));
            return;
        }
_L2:
        int i = 0;
_L8:
        int j;
        j = i + 1;
        if (i >= 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        a(a);
        if (((Integer)waitingResult).intValue() != 8)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        if (blecallback == null) goto _L7; else goto _L6
_L6:
        blecallback.sendOnFinishMessage(waitingResult);
        return;
        i = j;
          goto _L8
    }

}
