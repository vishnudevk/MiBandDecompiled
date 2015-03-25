// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import org.json.JSONObject;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleTask, BleCallBack

public class BleStatisticTask extends BleTask
{

    public BleStatisticTask(BleCallBack blecallback)
    {
        super(blecallback);
    }

    public void doWork(BleCallBack blecallback)
    {
        JSONObject jsonobject;
        if (blecallback != null)
        {
            blecallback.sendOnStartMessage();
        }
        jsonobject = new JSONObject();
        com.xiaomi.hm.bleservice.profile.IMiLiProfile.Usage usage;
        if (gattPeripheral == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        usage = gattPeripheral._getUsage();
        if (usage == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        jsonobject.put("usage", usage.toString());
        com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo batteryinfo = gattPeripheral._getBatteryInfo();
        if (batteryinfo == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        jsonobject.put("battery_info", batteryinfo.toString());
        com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo deviceinfo = gattPeripheral.getDeviceInfo();
        if (deviceinfo != null)
        {
            try
            {
                jsonobject.put("device_info", deviceinfo.toString());
            }
            catch (Exception exception) { }
        }
label0:
        {
            if (blecallback != null)
            {
                String s = jsonobject.toString();
                if (s == null || !s.contains("usage") && !s.contains("battery_info"))
                {
                    break label0;
                }
                blecallback.sendOnFinishMessage(s);
            }
            return;
        }
        blecallback.sendOnFinishMessage(null);
        return;
    }
}
