// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.util;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.util.Date;
import java.util.HashMap;

public class l
{

    private static f m;
    private int a;
    private int b;
    private int c;
    private String d;
    private int e;
    private int f;
    private Date g;
    private Date h;
    private String i;
    private boolean j;
    private int k;
    private HashMap l;

    public static l getData()
    {
        if (m == null)
        {
            m = new <init>();
        }
        return m;
    }

    public int getCurrentMode()
    {
        return k;
    }

    public int getSleepDeepTime()
    {
        return f;
    }

    public Date getSleepStartDate()
    {
        return g;
    }

    public Date getSleepStopDate()
    {
        return h;
    }

    public int getSleepTime()
    {
        return e;
    }

    public String getSleepTip()
    {
        return i;
    }

    public int getStepCalorie()
    {
        return c;
    }

    public int getStepCount()
    {
        return a;
    }

    public int getStepDistance()
    {
        return b;
    }

    public String getStepTip()
    {
        return d;
    }

    public ify getUserSleepModify(SportDay sportday)
    {
        String s = sportday.getKey();
        ify ify;
        if (l.containsKey(s))
        {
            ify = (ify)l.get(s);
        } else
        {
            DataManager datamanager = DataManager.getInstance();
            cn.com.smartdevices.bracelet.model.epModify epmodify = datamanager.getSummary(sportday);
            ify = new ify();
            if (epmodify != null)
            {
                ify.sleepStart = epmodify.etUserSleepStart();
                ify.sleepEnd = epmodify.etUserSleepEnd();
                putUserSleepModify(sportday, ify);
                datamanager.removeSummary(sportday);
                return ify;
            }
        }
        return ify;
    }

    public boolean isWeared()
    {
        return j;
    }

    public void putUserSleepModify(SportDay sportday, ify ify)
    {
        l.put(sportday.getKey(), ify);
    }

    public void setCurrentMode(int i1)
    {
        k = i1;
    }

    public void setSleepDeepTime(int i1)
    {
        f = i1;
    }

    public void setSleepStartDate(Date date)
    {
        g = date;
    }

    public void setSleepStopDate(Date date)
    {
        h = date;
    }

    public void setSleepTime(int i1)
    {
        e = i1;
    }

    public void setSleepTip(String s)
    {
        i = s;
    }

    public void setStepCalorie(int i1)
    {
        c = i1;
    }

    public void setStepCount(int i1)
    {
        a = i1;
    }

    public void setStepDistance(int i1)
    {
        b = i1;
    }

    public void setStepTip(String s)
    {
        d = s;
    }

    public void setWeared(boolean flag)
    {
        j = flag;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder()).append("StepCount : ").append(a).toString());
        stringbuilder.append((new StringBuilder()).append(", StepDistance : ").append(b).toString());
        stringbuilder.append((new StringBuilder()).append(", StepCalorie : ").append(c).toString());
        stringbuilder.append((new StringBuilder()).append(", SleepTime : ").append(e).toString());
        stringbuilder.append((new StringBuilder()).append(", SleepDeepTime : ").append(f).toString());
        return stringbuilder.toString();
    }

    private ify()
    {
        j = true;
        l = new HashMap();
    }
}
