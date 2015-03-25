// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleTask, BleCallBack

public class BleSetColorThemeTask extends BleTask
{

    public static final int BLUE = 1542;
    public static final byte FLAG_SLASH_NONE = 0;
    public static final byte FLAG_SLASH_NOW = 1;
    public static final int GREEN = 0x40500;
    public static final int ORANGE = 0x60200;
    public static final int RED = 0x60102;
    private int a;
    private byte b;

    public BleSetColorThemeTask(BleCallBack blecallback, int i)
    {
        super(blecallback);
        a = 1542;
        b = 0;
        a = i;
        b = 1;
    }

    public BleSetColorThemeTask(BleCallBack blecallback, int i, byte byte0)
    {
        super(blecallback);
        a = 1542;
        b = 0;
        a = i;
        b = byte0;
    }

    public void doWork(BleCallBack blecallback)
    {
        if (blecallback != null)
        {
            blecallback.sendOnStartMessage();
        }
        byte byte0 = (byte)(0xff & a >> 16);
        byte byte1 = (byte)(0xff & a >> 8);
        byte byte2 = (byte)(0xff & a);
        Debug.i(TAG, (new StringBuilder()).append("r=").append(byte0).append(",g=").append(byte1).append(",b=").append(byte2).toString());
        boolean flag = gattPeripheral.setColorTheme(byte0, byte1, byte2, b);
        if (blecallback != null)
        {
            blecallback.sendOnFinishMessage(Boolean.valueOf(flag));
        }
    }
}
