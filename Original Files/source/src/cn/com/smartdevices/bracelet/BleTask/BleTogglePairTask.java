// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import android.bluetooth.BluetoothDevice;
import android.util.Pair;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import cn.com.smartdevices.bracelet.model.MiliConfig;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SportDay;
import cn.com.smartdevices.bracelet.model.SwitchOperator;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleTask, BleCallBack

public class BleTogglePairTask extends BleTask
{

    private static Object c = new Object();
    private static Object d = new Object();
    private static Object e = new Object();
    private static Object f = new Object();
    private com.xiaomi.hm.bleservice.profile.IMiLiProfile.UserInfo a;
    private PersonInfo b;

    public BleTogglePairTask(PersonInfo personinfo, BleCallBack blecallback)
    {
        super(blecallback);
        a = null;
        b = null;
        b = personinfo;
    }

    public static void waiting(int i)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        Debug.i(TAG, "before waiting...");
        Exception exception;
        try
        {
            c.wait(i);
        }
        catch (InterruptedException interruptedexception) { }
        Debug.i(TAG, (new StringBuilder()).append("after waiting...").append(d).toString());
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void waitingNotify(Object obj)
    {
        Debug.i(TAG, (new StringBuilder()).append("waitingNotify:").append(obj).toString());
        synchronized (c)
        {
            d = obj;
            c.notify();
        }
        return;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void waitingNotifyReset(Object obj)
    {
        Debug.i(TAG, (new StringBuilder()).append("waitingNotifyReset:").append(obj).toString());
        synchronized (e)
        {
            f = obj;
            e.notify();
        }
        return;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void waitingReset(int i)
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        Debug.i(TAG, "before waitingReset...");
        Exception exception;
        try
        {
            e.wait(i);
        }
        catch (InterruptedException interruptedexception) { }
        Debug.i(TAG, (new StringBuilder()).append("after waitingReset...").append(f).toString());
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void doWork(BleCallBack blecallback)
    {
        boolean flag = true;
        d = Integer.valueOf(-1);
        if (blecallback != null)
        {
            blecallback.sendOnStartMessage();
        }
        SwitchOperator switchoperator = Keeper.readSwitchOperator();
        String s = gattPeripheral.getDevice().getAddress();
        if (switchoperator.type == flag && switchoperator.lastUid != -1L && b.uid == switchoperator.lastUid && !s.equalsIgnoreCase(switchoperator.lastMacAddress))
        {
            switchoperator.enableClearData = flag;
            switchoperator.enableSteps = flag;
        }
        if (b.isValid())
        {
            byte abyte0[] = b.nickname.getBytes();
            Pair pair;
            com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo batteryinfo;
            com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo deviceinfo;
            ArrayList arraylist;
            int i;
            String s1;
            int j;
            String s2;
            int k;
            byte byte0;
            byte byte1;
            byte byte2;
            AlarmClockItem alarmclockitem;
            int l;
            MiLiProfile miliprofile;
            byte byte3;
            int i1;
            int j1;
            byte abyte1[];
            byte byte4;
            if (abyte0.length <= 10)
            {
                j1 = abyte0.length;
            } else
            {
                j1 = 10;
            }
            abyte1 = new byte[j1];
            System.arraycopy(abyte0, 0, abyte1, 0, j1);
            if (switchoperator.enableClearData)
            {
                Debug.f(TAG, "SWITCH_UNBIND will clear data!");
                byte4 = flag;
            } else
            {
                byte4 = 0;
            }
            a = new com.xiaomi.hm.bleservice.profile.IMiLiProfile.UserInfo((int)b.uid, (byte)b.gender, (byte)b.age, (byte)b.height, (byte)b.weight, byte4, abyte1);
        } else
        {
            Debug.i(TAG, (new StringBuilder()).append("Person info is InValid! ").append(b).toString());
            Debug.f(TAG, (new StringBuilder()).append("Person info is InValid! ").append(b).toString());
            if (blecallback != null)
            {
                blecallback.sendOnFinishMessage(null);
                return;
            }
        }
        Debug.i(TAG, (new StringBuilder()).append("user info:\n").append(a).toString());
        Debug.f(TAG, (new StringBuilder()).append("user info:\n").append(a).toString());
        if (gattPeripheral.setUserInfo(a)) goto _L2; else goto _L1
_L1:
        if (blecallback != null)
        {
            blecallback.sendOnFinishMessage(null);
        }
_L9:
        return;
_L2:
        if (((Integer)d).intValue() == -1)
        {
            waiting(10000);
        }
        if (((Integer)d).intValue() != 5) goto _L4; else goto _L3
_L3:
        if (blecallback != null)
        {
            blecallback.sendOnProgressMessage(5);
        }
_L6:
        switchoperator.enableClearData = false;
        switchoperator.lastUid = -1L;
        if (gattPeripheral._setDateTime(Calendar.getInstance()))
        {
            break; /* Loop/switch isn't completed */
        }
        Keeper.keepSwitchOperator(switchoperator);
        if (blecallback != null)
        {
            blecallback.sendOnFinishMessage(null);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (((Integer)d).intValue() != 6)
        {
            continue; /* Loop/switch isn't completed */
        }
        f = Integer.valueOf(-1);
        waitingReset(30000);
        if (((Integer)f).intValue() == -1)
        {
            if (blecallback != null)
            {
                blecallback.sendOnFinishMessage(null);
                return;
            }
        } else
        {
            if (((Integer)f).intValue() != 9)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (blecallback != null)
            {
                blecallback.sendOnFinishMessage(null);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (((Integer)f).intValue() == 10 || ((Integer)f).intValue() != 239) goto _L6; else goto _L5
_L5:
        Debug.i(TAG, "Cancel pair now!");
        return;
        if (((Integer)d).intValue() != -1) goto _L6; else goto _L7
_L7:
        if (blecallback != null)
        {
            blecallback.sendOnFinishMessage(null);
            return;
        }
        if (true) goto _L9; else goto _L8
_L8:
        pair = gattPeripheral._getDateTime();
        if (pair != null)
        {
            Debug.i(TAG, (new StringBuilder()).append("new time:").append(((Calendar)pair.first).getTime().toString()).append(",old time:").append(((Calendar)pair.second).getTime().toString()).toString());
            Debug.f(TAG, (new StringBuilder()).append("new time:").append(((Calendar)pair.first).getTime().toString()).append(",old time:").append(((Calendar)pair.second).getTime().toString()).toString());
        } else
        {
            Debug.i(TAG, "can not get bracelet time after _setDateTime");
            Debug.f(TAG, "can not get bracelet time after _setDateTime");
        }
        if (switchoperator.type != -1)
        {
            if (b.getDaySportGoalSteps() > 0)
            {
                Debug.i(TAG, (new StringBuilder()).append("setGoal:").append(b.getDaySportGoalSteps()).toString());
                gattPeripheral.setGoal((byte)0, b.getDaySportGoalSteps());
            } else
            {
                Debug.i(TAG, "day sport goals is inValid!");
            }
            arraylist = b.getAlarmClockItems();
            i = 0;
            while (i < arraylist.size()) 
            {
                alarmclockitem = (AlarmClockItem)arraylist.get(i);
                l = alarmclockitem.getCoded();
                Debug.i(TAG, (new StringBuilder()).append("Set alarm at: ").append(i).append(", alarm = ").append(alarmclockitem.toJson()).toString());
                Debug.f(TAG, (new StringBuilder()).append("Set alarm at: ").append(i).append(", ").append(alarmclockitem.toJson()).toString());
                miliprofile = gattPeripheral;
                byte3 = (byte)i;
                if (alarmclockitem.isEnabled())
                {
                    i1 = ((flag) ? 1 : 0);
                } else
                {
                    i1 = 0;
                }
                miliprofile.setTimer(byte3, (byte)i1, alarmclockitem.getCalendar(), (byte)alarmclockitem.getDuration(), (byte)l);
                alarmclockitem.setUpdate(false);
                i++;
            }
            if (b.miliConfig != null && b.miliConfig.lightColor != null)
            {
                s2 = b.miliConfig.lightColor;
                k = 1542;
                if (s2.equals("BLUE"))
                {
                    k = 1542;
                } else
                if (s2.equals("GREEN"))
                {
                    k = 0x40500;
                } else
                if (s2.equals("RED"))
                {
                    k = 0x60102;
                } else
                if (s2.equals("ORANGE"))
                {
                    k = 0x60200;
                }
                byte0 = (byte)(0xff & k >> 16);
                byte1 = (byte)(0xff & k >> 8);
                byte2 = (byte)(k & 0xff);
                Debug.i(TAG, (new StringBuilder()).append("setColorTheme r=").append(byte0).append(",g=").append(byte1).append(",b=").append(byte2).toString());
                if (!gattPeripheral.setColorTheme(byte0, byte1, byte2, (byte)0))
                {
                    Debug.f(TAG, "setColorTheme failed");
                }
            } else
            {
                Debug.f(TAG, "miliConfig is null or lightColor is null");
            }
            if (b.miliConfig != null && b.miliConfig.wearHand != null)
            {
                s1 = b.miliConfig.wearHand;
                if (s1.equals("LEFT_HAND"))
                {
                    j = 0;
                } else
                if (s1.equals("RIGHT_HAND"))
                {
                    j = ((flag) ? 1 : 0);
                } else
                {
                    j = 0;
                }
                Debug.i(TAG, (new StringBuilder()).append("setWearLocation : ").append(j).toString());
                if (!gattPeripheral.setWearLocation(j))
                {
                    Debug.f(TAG, "setWearLocation failed!");
                }
            } else
            {
                Debug.f(TAG, "miliConfig is null or wearHand is null");
            }
            switchoperator.type = -1;
        }
        if (switchoperator.enableSteps)
        {
            if (!switchoperator.date.equals((new SportDay()).getKey()))
            {
                switchoperator.steps = 0;
                Debug.f(TAG, (new StringBuilder()).append("switch date:").append(switchoperator.date).append(",current date:").append((new SportDay()).getKey()).toString());
            }
            if (switchoperator.steps >= flag)
            {
                Debug.i(TAG, (new StringBuilder()).append("setRealtimeSteps:").append(switchoperator.steps).toString());
                Debug.f(TAG, (new StringBuilder()).append("setRealtimeSteps:").append(switchoperator.steps).toString());
                flag = gattPeripheral.setRealtimeSteps(switchoperator.steps);
            }
            if (!flag)
            {
                Debug.i(TAG, (new StringBuilder()).append("setRealtimeSteps:").append(switchoperator.steps).append(" failed!!!").toString());
                Debug.f(TAG, (new StringBuilder()).append("setRealtimeSteps:").append(switchoperator.steps).append(" failed!!!").toString());
            }
            switchoperator.enableSteps = false;
        }
        Keeper.keepSwitchOperator(switchoperator);
        batteryinfo = gattPeripheral._getBatteryInfo();
        Debug.i(TAG, (new StringBuilder()).append("battery info : ").append(batteryinfo).toString());
        Debug.f(TAG, (new StringBuilder()).append("battery info : ").append(batteryinfo).toString());
        deviceinfo = gattPeripheral.getDeviceInfo();
        Debug.i(TAG, (new StringBuilder()).append("device info : ").append(deviceinfo).toString());
        Debug.f(TAG, (new StringBuilder()).append("device info : ").append(deviceinfo).toString());
        if (blecallback != null)
        {
            blecallback.sendOnFinishMessage(deviceinfo);
            return;
        }
        if (true) goto _L9; else goto _L10
_L10:
    }

}
