// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import java.util.ArrayList;
import java.util.List;

public class stepData extends cn.com.smartdevices.bracelet.chart.data.tData
{

    public String date;
    public String prevDate;
    public List sleepData;
    public List stepData;

    public ()
    {
        date = "";
        prevDate = "";
        sleepData = new ArrayList();
        stepData = new ArrayList();
    }
}
