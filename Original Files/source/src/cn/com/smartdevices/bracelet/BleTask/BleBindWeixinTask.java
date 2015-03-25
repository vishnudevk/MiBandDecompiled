// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleTask, BleCallBack

public class BleBindWeixinTask extends BleTask
{

    public BleBindWeixinTask(BleCallBack blecallback)
    {
        super(blecallback);
    }

    public void doWork(BleCallBack blecallback)
    {
        int i;
        String s;
        i = 0;
        if (blecallback != null)
        {
            blecallback.sendOnStartMessage();
        }
        com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo deviceinfo = gattPeripheral.getDeviceInfo();
        if (deviceinfo == null && blecallback != null)
        {
            blecallback.sendOnFinishMessage(Boolean.valueOf(false));
        }
        s = (new StringBuilder()).append("gh_f65f9f1aa87a").append(deviceinfo.deviceID).toString();
        byte abyte0[];
        boolean flag1;
        abyte0 = MessageDigest.getInstance("MD5").digest(s.getBytes());
        flag1 = gattPeripheral._wirteMD5(abyte0);
        boolean flag = flag1;
        StringBuilder stringbuilder;
        int j;
        stringbuilder = new StringBuilder(2 * abyte0.length);
        j = abyte0.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        byte byte0 = abyte0[i];
        if ((byte0 & 0xff) >= 16)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        stringbuilder.append("0");
        stringbuilder.append(Integer.toHexString(byte0 & 0xff));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Debug.i(TAG, (new StringBuilder()).append("string:").append(s).append(",md5:").append(stringbuilder.toString()).toString());
_L4:
        if (blecallback != null)
        {
            blecallback.sendOnFinishMessage(Boolean.valueOf(flag));
        }
        return;
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        flag = false;
_L5:
        nosuchalgorithmexception.printStackTrace();
        if (true) goto _L4; else goto _L3
_L3:
        nosuchalgorithmexception;
          goto _L5
    }
}
