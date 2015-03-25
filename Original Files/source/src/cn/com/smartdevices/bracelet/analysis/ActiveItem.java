// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.analysis;


public class ActiveItem
{

    public static final int MODE_ACTIVE = 0;
    public static final int MODE_RUN = 2;
    public static final int MODE_WALK = 1;
    public int activeTime;
    public int calories;
    public String dateString;
    public int distance;
    public int flag;
    public int mode;
    public int runtime;
    public int start;
    public int steps;
    public int stop;

    public ActiveItem()
    {
        start = 0;
        stop = 0;
        mode = 0;
        distance = 0;
        calories = 0;
        runtime = 0;
        steps = 0;
        flag = 0;
        activeTime = 0;
        dateString = null;
    }

    public int getActiveTime()
    {
        return activeTime;
    }

    public int getCalories()
    {
        return calories;
    }

    public String getDateString()
    {
        return dateString;
    }

    public int getDistance()
    {
        return distance;
    }

    public int getMode()
    {
        return mode;
    }

    public int getRuntime()
    {
        return runtime;
    }

    public int getStart()
    {
        return start;
    }

    public int getSteps()
    {
        return steps;
    }

    public int getStop()
    {
        return stop;
    }

    public void setActiveTime(int i)
    {
        activeTime = i;
    }

    public void setCalories(int i)
    {
        calories = i;
    }

    public void setDateString(String s)
    {
        dateString = s;
    }

    public void setDistance(int i)
    {
        distance = i;
    }

    public void setMode(int i)
    {
        mode = i;
    }

    public void setRuntime(int i)
    {
        runtime = i;
    }

    public void setStart(int i)
    {
        start = i;
    }

    public void setSteps(int i)
    {
        steps = i;
    }

    public void setStop(int i)
    {
        stop = i;
    }
}
