// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import com.xiaomi.hm.bleservice.profile.MiLiProfile;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleTask, BleCallBack

public class BleSetGoalsTask extends BleTask
{

    private int a;

    public BleSetGoalsTask(int i, BleCallBack blecallback)
    {
        super(blecallback);
        a = 8000;
        a = i;
    }

    public void doWork(BleCallBack blecallback)
    {
        if (callback != null)
        {
            callback.sendOnStartMessage();
        }
        boolean flag = gattPeripheral.setGoal((byte)0, a);
        if (callback != null)
        {
            callback.sendOnFinishMessage(Boolean.valueOf(flag));
        }
    }
}
