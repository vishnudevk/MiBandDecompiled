// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleTask, BleCallBack

public class BleSetWearLocationTask extends BleTask
{

    public static final byte LEFT = 0;
    public static final byte RIGHT = 1;
    private byte a;

    public BleSetWearLocationTask(BleCallBack blecallback, byte byte0)
    {
        super(blecallback);
        a = 0;
        a = byte0;
    }

    public void doWork(BleCallBack blecallback)
    {
        if (blecallback != null)
        {
            blecallback.sendOnStartMessage();
        }
        Debug.i(TAG, (new StringBuilder()).append("location:").append(a).toString());
        boolean flag = gattPeripheral.setWearLocation(a);
        if (blecallback != null)
        {
            blecallback.sendOnFinishMessage(Boolean.valueOf(flag));
        }
    }
}
