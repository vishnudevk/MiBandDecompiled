// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import com.xiaomi.hm.bleservice.profile.MiLiProfile;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleTask, BleCallBack

public class BleGetBatteryInfoTask extends BleTask
{

    public BleGetBatteryInfoTask(BleCallBack blecallback)
    {
        super(blecallback);
    }

    public void doWork(BleCallBack blecallback)
    {
        if (blecallback != null)
        {
            blecallback.sendOnStartMessage();
        }
        com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo batteryinfo = gattPeripheral._getBatteryInfo();
        if (blecallback != null)
        {
            blecallback.sendOnFinishMessage(batteryinfo);
        }
    }
}
