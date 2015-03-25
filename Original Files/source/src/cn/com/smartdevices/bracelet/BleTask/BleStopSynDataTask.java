// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import com.xiaomi.hm.bleservice.profile.MiLiProfile;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleTask, BleCallBack

public class BleStopSynDataTask extends BleTask
{

    public BleStopSynDataTask(BleCallBack blecallback)
    {
        super(blecallback);
    }

    public void doWork(BleCallBack blecallback)
    {
        if (blecallback != null)
        {
            blecallback.sendOnStartMessage();
        }
        boolean flag = gattPeripheral.stopSyncData();
        if (blecallback != null)
        {
            blecallback.sendOnFinishMessage(Boolean.valueOf(flag));
        }
    }
}
