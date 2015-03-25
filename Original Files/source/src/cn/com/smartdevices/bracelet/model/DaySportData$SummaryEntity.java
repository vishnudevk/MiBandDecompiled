// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


public class daySportGoal
    implements daySportGoal
{

    private int daySportGoal;
    private int sleep;
    private int sleepDeepTime;
    private long sleepRiseTime;
    private int sleepShallowTime;
    private long sleepStartTime;
    private int sleepWakeTime;
    private int stepActiveTime;
    private int stepCalorie;
    private int stepContinueTime;
    private int stepDistance;
    private int stepRunDistance;
    private int stepRunTime;
    private int stepWalkTime;
    private int steps;
    private int userSleepEnd;
    private int userSleepStart;

    public int getDayStepGoal()
    {
        return daySportGoal;
    }

    public int getSleep()
    {
        return sleep;
    }

    public int getSleepDeepTime()
    {
        return sleepDeepTime;
    }

    public long getSleepRiseTime()
    {
        return sleepRiseTime;
    }

    public int getSleepShallowTime()
    {
        return sleepShallowTime;
    }

    public long getSleepStartTime()
    {
        return sleepStartTime;
    }

    public int getSleepWakeTime()
    {
        return sleepWakeTime;
    }

    public int getStepActiveTime()
    {
        return stepActiveTime;
    }

    public int getStepCalorie()
    {
        return stepCalorie;
    }

    public int getStepContinueTime()
    {
        return stepContinueTime;
    }

    public int getStepDistance()
    {
        return stepDistance;
    }

    public int getStepRunDistance()
    {
        return stepRunDistance;
    }

    public int getStepRunTime()
    {
        return stepRunTime;
    }

    public int getStepWalkTime()
    {
        return stepWalkTime;
    }

    public int getSteps()
    {
        return steps;
    }

    public int getUserSleepEnd()
    {
        return userSleepEnd;
    }

    public int getUserSleepStart()
    {
        return userSleepStart;
    }

    public boolean isEmpty()
    {
        return false;
    }

    public void setDayStepGoal(int i)
    {
        daySportGoal = i;
    }

    public void setSleep(int i)
    {
        sleep = i;
    }

    public void setSleepDeepTime(int i)
    {
        sleepDeepTime = i;
    }

    public void setSleepRiseTime(long l)
    {
        sleepRiseTime = l;
    }

    public void setSleepShallowTime(int i)
    {
        sleepShallowTime = i;
    }

    public void setSleepStartTime(long l)
    {
        sleepStartTime = l;
    }

    public void setSleepWakeTime(int i)
    {
        sleepWakeTime = i;
    }

    public void setStepActiveTime(int i)
    {
        stepActiveTime = i;
    }

    public void setStepCalorie(int i)
    {
        stepCalorie = i;
    }

    public void setStepContinueTime(int i)
    {
        stepContinueTime = i;
    }

    public void setStepDistance(int i)
    {
        stepDistance = i;
    }

    public void setStepRunDistance(int i)
    {
        stepRunDistance = i;
    }

    public void setStepRunTime(int i)
    {
        stepRunTime = i;
    }

    public void setStepWalkTime(int i)
    {
        stepWalkTime = i;
    }

    public void setSteps(int i)
    {
        steps = i;
    }

    public void setUserSleepEnd(int i)
    {
        userSleepEnd = i;
    }

    public void setUserSleepStart(int i)
    {
        userSleepStart = i;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Steps: ").append(steps).append(" , Sleep : ").append(sleep).toString();
    }

    public ()
    {
        daySportGoal = 8000;
    }
}
