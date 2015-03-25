// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


public class DaySportGoals
{

    public int goalSleepTime;
    public int goalStepsCount;

    public DaySportGoals()
    {
        goalStepsCount = -1;
        goalSleepTime = -1;
    }

    public int getGoalStepsCount()
    {
        return goalStepsCount;
    }

    public boolean isValid()
    {
        return goalStepsCount > 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Day sport goal: goalStep").append(goalStepsCount).append(", goalTime:").append(goalSleepTime).toString();
    }
}
