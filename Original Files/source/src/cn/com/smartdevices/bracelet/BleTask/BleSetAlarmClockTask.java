// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import java.util.ArrayList;
import java.util.Calendar;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleTask, BleCallBack

public class BleSetAlarmClockTask extends BleTask
{

    private ArrayList a;

    public BleSetAlarmClockTask(ArrayList arraylist, BleCallBack blecallback)
    {
        super(blecallback);
        a = null;
        a = arraylist;
    }

    public void doWork(BleCallBack blecallback)
    {
        if (blecallback != null)
        {
            blecallback.sendOnStartMessage();
        }
        int i = 0;
        while (i < a.size()) 
        {
            AlarmClockItem alarmclockitem = (AlarmClockItem)a.get(i);
            Debug.i(TAG, (new StringBuilder()).append("BleSetAlarmClockTask:").append(alarmclockitem.toJson()).toString());
            int j = alarmclockitem.getCoded();
            if (alarmclockitem.calendar == null)
            {
                alarmclockitem.calendar = Calendar.getInstance();
            }
            Debug.i(TAG, (new StringBuilder()).append("Set alarm at: ").append(i).append(", ").append(alarmclockitem.getCalendar()).toString());
            Debug.f(TAG, (new StringBuilder()).append("Set alarm at: ").append(i).append(", ").append(alarmclockitem.toJson()).toString());
            MiLiProfile miliprofile = gattPeripheral;
            byte byte0 = (byte)i;
            int k;
            if (alarmclockitem.isEnabled())
            {
                k = 1;
            } else
            {
                k = 0;
            }
            miliprofile.setTimer(byte0, (byte)k, alarmclockitem.calendar, (byte)alarmclockitem.getDuration(), (byte)j);
            alarmclockitem.setUpdate(false);
            i++;
        }
        if (blecallback != null)
        {
            blecallback.sendOnFinishMessage(Boolean.valueOf(true));
        }
    }
}
