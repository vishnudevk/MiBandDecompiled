// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleCallBack

public abstract class BleTask
    implements Runnable
{

    public static String TAG = "BleTask";
    public static final int TASK_CONTINUE = 2;
    public static final int TASK_SLEEP = 2;
    public static final int TASK_START = 0;
    public static final int TASK_STOP = 1;
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static ExecutorService b = Executors.newSingleThreadExecutor();
    protected BleCallBack callback;
    protected MiLiProfile gattPeripheral;

    public BleTask(BleCallBack blecallback)
    {
        callback = null;
        gattPeripheral = null;
        if (BraceletApp.BLEService == null)
        {
            return;
        } else
        {
            callback = blecallback;
            gattPeripheral = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
            return;
        }
    }

    public abstract void doWork(BleCallBack blecallback);

    public void run()
    {
        Debug.i(TAG, (new StringBuilder()).append("BleTask Run..........................................in:").append(getClass().getName()).toString());
        if (!Utils.isBraceletConnected()) goto _L2; else goto _L1
_L1:
        doWork(callback);
_L4:
        Debug.i(TAG, (new StringBuilder()).append("BleTask Run..........................................out:").append(getClass().getName()).toString());
        return;
_L2:
        if (callback != null)
        {
            callback.sendOnFailedMessage(Boolean.valueOf(false));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void work()
    {
        a.execute(this);
    }

    public void workX()
    {
        b.execute(this);
    }

}
