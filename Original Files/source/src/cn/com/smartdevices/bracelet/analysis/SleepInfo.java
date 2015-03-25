// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.analysis;

import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class SleepInfo
{

    public static String KEY_AWAKE_MINUTES = "wk";
    public static String KEY_DEEP_MINUTES = "dp";
    public static String KEY_END_DATE = "ed";
    public static String KEY_LIGHT_MINUTES = "lt";
    public static String KEY_SLEEP_INFO = "slp";
    public static String KEY_START_DATE = "st";
    public static String KEY_USER_SLEEP_END = "usrEd";
    public static String KEY_USER_SLEEP_START = "usrSt";
    public static int NOSLEEP_DATALOST = 2;
    public static int NOSLEEP_NONE = 0;
    public static int NOSLEEP_NONWEAR = 1;
    public static int NOSLEEP_UNKNOWN = 255;
    private Date a;
    private Date b;
    private Date c;
    private Date d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;

    public SleepInfo()
    {
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        j = 0x80000000;
        k = 0x80000000;
        l = NOSLEEP_NONE;
        m = false;
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        a = new Date(calendar.getTimeInMillis());
        b = new Date(calendar.getTimeInMillis());
        c = new Date(calendar.getTimeInMillis());
        d = new Date(calendar.getTimeInMillis());
    }

    public int getAwakeCount()
    {
        return h;
    }

    public int getAwakeNum()
    {
        return i;
    }

    public boolean getHasSleep()
    {
        return m;
    }

    public int getNonRemCount()
    {
        return f;
    }

    public int getNosleepReason()
    {
        return l;
    }

    public int getRemCount()
    {
        return e;
    }

    public int getSleepCount()
    {
        return g;
    }

    public Date getStartDate()
    {
        return a;
    }

    public int getStartDateMin()
    {
        int i1 = a.getHours();
        return a.getMinutes() + i1 * 60;
    }

    public String getStartDateStr()
    {
        int i1 = a.getHours();
        int j1 = a.getMinutes();
        StringBuilder stringbuilder = new StringBuilder();
        Object obj;
        StringBuilder stringbuilder1;
        Object obj1;
        if (i1 < 10)
        {
            obj = (new StringBuilder()).append("0").append(i1).toString();
        } else
        {
            obj = Integer.valueOf(i1);
        }
        stringbuilder1 = stringbuilder.append(obj).append(":");
        if (j1 < 10)
        {
            obj1 = (new StringBuilder()).append("0").append(j1).toString();
        } else
        {
            obj1 = Integer.valueOf(j1);
        }
        return stringbuilder1.append(obj1).toString();
    }

    public Date getStartOnBedDate()
    {
        return b;
    }

    public Date getStopDate()
    {
        return c;
    }

    public int getStopDateMin()
    {
        int i1 = c.getHours();
        return c.getMinutes() + i1 * 60;
    }

    public String getStopDateStr()
    {
        int i1 = c.getHours();
        int j1 = c.getMinutes();
        StringBuilder stringbuilder = new StringBuilder();
        Object obj;
        StringBuilder stringbuilder1;
        Object obj1;
        if (i1 < 10)
        {
            obj = (new StringBuilder()).append("0").append(i1).toString();
        } else
        {
            obj = Integer.valueOf(i1);
        }
        stringbuilder1 = stringbuilder.append(obj).append(":");
        if (j1 < 10)
        {
            obj1 = (new StringBuilder()).append("0").append(j1).toString();
        } else
        {
            obj1 = Integer.valueOf(j1);
        }
        return stringbuilder1.append(obj1).toString();
    }

    public Date getStopOnBedDate()
    {
        return d;
    }

    public JSONObject getSummaryJson()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put(KEY_START_DATE, a.getTime() / 1000L);
            jsonobject.put(KEY_END_DATE, c.getTime() / 1000L);
            jsonobject.put(KEY_DEEP_MINUTES, f);
            jsonobject.put(KEY_LIGHT_MINUTES, e);
            jsonobject.put(KEY_AWAKE_MINUTES, h);
            if (j > 0x80000000)
            {
                jsonobject.put(KEY_USER_SLEEP_START, j);
            }
            if (k > 0x80000000)
            {
                jsonobject.put(KEY_USER_SLEEP_END, k);
            }
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    public void setAwakeCount(int i1)
    {
        h = i1;
    }

    public void setAwakeNum(int i1)
    {
        i = i1;
    }

    public void setHasSleep(boolean flag)
    {
        m = flag;
    }

    public void setNonRemCount(int i1)
    {
        f = i1;
    }

    public void setNosleepReason(int i1)
    {
        l = i1;
    }

    public void setRemCount(int i1)
    {
        e = i1;
    }

    public void setSleepCount(int i1)
    {
        g = i1;
    }

    public void setStartDate(Date date)
    {
        a = date;
    }

    public void setStartOnBedDate(Date date)
    {
        b = date;
    }

    public void setStopDate(Date date)
    {
        c = date;
    }

    public void setStopOnBedDate(Date date)
    {
        d = date;
    }

    public void setUserSleepEnd(int i1)
    {
        k = i1;
    }

    public void setUserSleepStart(int i1)
    {
        j = i1;
    }

}
