// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


public class DayStepRecord
{

    public String date;
    public int steps;

    public DayStepRecord()
    {
        steps = -1;
        date = "";
    }

    public boolean isValid()
    {
        return steps != -1 && date != null && date.length() > 0;
    }

    public String toString()
    {
        if (!isValid())
        {
            return "no day step record!";
        } else
        {
            return (new StringBuilder()).append(date).append(":").append(steps).toString();
        }
    }
}
