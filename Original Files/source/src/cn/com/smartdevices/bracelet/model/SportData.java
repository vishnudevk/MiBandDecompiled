// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import java.io.Serializable;

public class SportData
    implements Serializable, Cloneable
{

    private static final long serialVersionUID = 1L;
    private int activity;
    private int mode;
    private int runs;
    private int step;
    private int timeIndex;

    public SportData(int i, int j, int k)
    {
        timeIndex = 0;
        runs = 0;
        if (i != 126) goto _L2; else goto _L1
_L1:
        mode = i;
_L4:
        activity = j;
        step = k;
        return;
_L2:
        mode = i & 0xf;
        if (k > 0)
        {
            runs = i >> 4;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public SportData(int i, int j, int k, int l)
    {
        timeIndex = 0;
        runs = 0;
        timeIndex = i;
        if (j != 126) goto _L2; else goto _L1
_L1:
        mode = j;
_L4:
        activity = k;
        step = l;
        return;
_L2:
        mode = j & 0xf;
        if (l > 0)
        {
            runs = j >> 4;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public SportData copy()
    {
        return (SportData)clone();
    }

    public int getActivity()
    {
        return activity;
    }

    public int getRuns()
    {
        return runs;
    }

    public int getSportMode()
    {
        return mode;
    }

    public int getStep()
    {
        return step;
    }

    public int getTimeIndex()
    {
        return timeIndex;
    }

    public void setActivity(int i)
    {
        activity = i;
    }

    public void setMode(int i)
    {
        mode = i;
    }

    public void setStep(int i)
    {
        step = i;
    }

    public String toString()
    {
        return (new StringBuilder()).append("<").append(timeIndex).append(":").append(mode).append(":").append(activity).append(":").append(step).append(">").toString();
    }
}
