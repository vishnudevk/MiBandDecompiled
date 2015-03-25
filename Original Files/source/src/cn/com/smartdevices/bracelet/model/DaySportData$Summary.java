// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


public interface 
{

    public abstract int getDayStepGoal();

    public abstract int getSleep();

    public abstract int getSleepDeepTime();

    public abstract long getSleepRiseTime();

    public abstract int getSleepShallowTime();

    public abstract long getSleepStartTime();

    public abstract int getSleepWakeTime();

    public abstract int getStepActiveTime();

    public abstract int getStepCalorie();

    public abstract int getStepContinueTime();

    public abstract int getStepDistance();

    public abstract int getStepRunDistance();

    public abstract int getStepRunTime();

    public abstract int getStepWalkTime();

    public abstract int getSteps();

    public abstract int getUserSleepEnd();

    public abstract int getUserSleepStart();

    public abstract boolean isEmpty();
}
