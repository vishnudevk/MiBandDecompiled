// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import android.content.Context;
import android.content.res.Resources;
import com.google.gson.Gson;
import java.util.Calendar;

public class AlarmClockItem
{

    public static final int ALARM_CUSTOM = -1;
    public static final int ALARM_EVERY_DAY;
    public static int ALARM_FRI;
    public static int ALARM_MON;
    public static final int ALARM_MON_2_FRI;
    public static final int ALARM_MON_2_SAT;
    public static int ALARM_ONCE = 0;
    public static int ALARM_SAT;
    public static int ALARM_SUN;
    public static int ALARM_THU;
    public static int ALARM_TUE;
    public static int ALARM_WED;
    public static int MAX_COUNT = 3;
    public static int WEEK_MASK[];
    public Calendar calendar;
    private boolean enabled;
    private boolean isUpdate;
    private int mDays;
    public int mSmartWakeupDuration;

    public AlarmClockItem()
    {
        mDays = 0;
        enabled = true;
        isUpdate = false;
        mSmartWakeupDuration = 0;
        setCalendar(Calendar.getInstance());
        set(ALARM_MON_2_FRI, 8, 0, false);
    }

    public static AlarmClockItem fromJson(String s)
    {
        return (AlarmClockItem)(new Gson()).fromJson(s, cn/com/smartdevices/bracelet/model/AlarmClockItem);
    }

    public Calendar getCalendar()
    {
        if (calendar == null)
        {
            calendar = Calendar.getInstance();
            calendar.set(11, 8);
            calendar.set(12, 0);
            setDuration(0);
            setDays(0);
            setUpdate(false);
        }
        return calendar;
    }

    public int getCoded()
    {
        return mDays;
    }

    public int getDays()
    {
        return mDays;
    }

    public int getDuration()
    {
        return mSmartWakeupDuration;
    }

    public int getHour()
    {
        return getCalendar().get(11);
    }

    public int getMinute()
    {
        return getCalendar().get(12);
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public boolean isSmartWakeup()
    {
        return getDuration() > 0;
    }

    public boolean isUpdate()
    {
        return isUpdate;
    }

    public void set(int i, int j, int k, boolean flag)
    {
        mDays = i;
        getCalendar().set(11, j);
        getCalendar().set(12, k);
        enabled = flag;
    }

    public void set(int i, int j, boolean flag)
    {
        set(mDays, i, j, flag);
    }

    public void setCalendar(Calendar calendar1)
    {
        calendar = calendar1;
    }

    public void setDays(int i)
    {
        mDays = i;
    }

    public void setDuration(int i)
    {
        mSmartWakeupDuration = i;
    }

    public void setEnabled(boolean flag)
    {
        enabled = flag;
    }

    public void setUpdate(boolean flag)
    {
        isUpdate = flag;
    }

    public String toJson()
    {
        return (new Gson()).toJson(this);
    }

    public String toTimeString()
    {
        return toTimeString(false);
    }

    public String toTimeString(boolean flag)
    {
        int i = 12;
        int j = getCalendar().get(11);
        int k = getCalendar().get(i);
        Object obj;
        Object obj1;
        if (!flag)
        {
            int l = getCalendar().get(10);
            StringBuilder stringbuilder;
            StringBuilder stringbuilder1;
            if (l != 0)
            {
                i = l;
            }
        } else
        {
            i = j;
        }
        stringbuilder = new StringBuilder();
        if (i < 10)
        {
            obj = (new StringBuilder()).append("0").append(i).toString();
        } else
        {
            obj = Integer.valueOf(i);
        }
        stringbuilder1 = stringbuilder.append(obj).append(":");
        if (k < 10)
        {
            obj1 = (new StringBuilder()).append("0").append(k).toString();
        } else
        {
            obj1 = Integer.valueOf(k);
        }
        return stringbuilder1.append(obj1).toString();
    }

    public String toWeekString(Context context)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (mDays == ALARM_ONCE)
        {
            return context.getString(0x7f0d0010);
        }
        if (mDays == ALARM_EVERY_DAY)
        {
            return context.getString(0x7f0d0092);
        }
        if (mDays == ALARM_MON_2_FRI)
        {
            return context.getString(0x7f0d00ff);
        }
        if (mDays == ALARM_MON_2_SAT)
        {
            return context.getString(0x7f0d0100);
        }
        int i = mDays;
        int j = 0;
        for (; i > 0; i >>= 1)
        {
            if ((i & 1) == 1)
            {
                j++;
            }
        }

        String as[] = context.getResources().getStringArray(0x7f07000e);
        String as1[] = context.getResources().getStringArray(0x7f07000d);
        int k;
        int l;
        if (j <= 1)
        {
            as = as1;
        }
        k = 0;
        l = j;
        for (; k < 7; k++)
        {
            if ((mDays & 1 << k) == 0)
            {
                continue;
            }
            stringbuilder.append(as[k]);
            if (--l > 0)
            {
                stringbuilder.append(" ");
            }
        }

        if (stringbuilder.length() > 0 && j > 1)
        {
            stringbuilder.insert(0, context.getResources().getString(0x7f0d01ed));
        }
        return stringbuilder.toString();
    }

    static 
    {
        ALARM_MON = 1;
        ALARM_TUE = 2;
        ALARM_WED = 4;
        ALARM_THU = 8;
        ALARM_FRI = 16;
        ALARM_SAT = 32;
        ALARM_SUN = 64;
        ALARM_EVERY_DAY = ALARM_MON | ALARM_TUE | ALARM_WED | ALARM_THU | ALARM_FRI | ALARM_SAT | ALARM_SUN;
        ALARM_MON_2_SAT = ALARM_MON | ALARM_TUE | ALARM_WED | ALARM_THU | ALARM_FRI | ALARM_SAT;
        ALARM_MON_2_FRI = ALARM_MON | ALARM_TUE | ALARM_WED | ALARM_THU | ALARM_FRI;
        int ai[] = new int[7];
        ai[0] = ALARM_MON;
        ai[1] = ALARM_TUE;
        ai[2] = ALARM_WED;
        ai[3] = ALARM_THU;
        ai[4] = ALARM_FRI;
        ai[5] = ALARM_SAT;
        ai[6] = ALARM_SUN;
        WEEK_MASK = ai;
    }
}
