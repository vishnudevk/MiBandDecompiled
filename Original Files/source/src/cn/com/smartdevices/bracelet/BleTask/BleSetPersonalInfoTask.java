// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleTask, BleCallBack

public class BleSetPersonalInfoTask extends BleTask
{

    private com.xiaomi.hm.bleservice.profile.IMiLiProfile.UserInfo a;

    public BleSetPersonalInfoTask(PersonInfo personinfo, BleCallBack blecallback)
    {
        int i = 10;
        super(blecallback);
        a = null;
        byte abyte0[] = personinfo.nickname.getBytes();
        if (abyte0.length <= i)
        {
            i = abyte0.length;
        }
        byte abyte1[] = new byte[i];
        System.arraycopy(abyte0, 0, abyte1, 0, i);
        a = new com.xiaomi.hm.bleservice.profile.IMiLiProfile.UserInfo((int)personinfo.uid, (byte)personinfo.gender, (byte)personinfo.age, (byte)personinfo.height, (byte)personinfo.weight, abyte1);
    }

    public void doWork(BleCallBack blecallback)
    {
        if (blecallback != null)
        {
            blecallback.sendOnStartMessage();
        }
        boolean flag = gattPeripheral.setUserInfo(a);
        if (blecallback != null)
        {
            blecallback.sendOnFinishMessage(Boolean.valueOf(flag));
        }
    }
}
