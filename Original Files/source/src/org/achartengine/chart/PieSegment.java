// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;

import java.io.Serializable;

public class PieSegment
    implements Serializable
{

    private float a;
    private float b;
    private int c;
    private float d;

    public PieSegment(int i, float f, float f1, float f2)
    {
        a = f1;
        b = f2 + f1;
        c = i;
        d = f;
    }

    protected int getDataIndex()
    {
        return c;
    }

    protected float getEndAngle()
    {
        return b;
    }

    protected float getStartAngle()
    {
        return a;
    }

    protected float getValue()
    {
        return d;
    }

    public boolean isInSegment(double d1)
    {
        if (d1 < (double)a || d1 > (double)b)
        {
            double d2 = d1 % 360D;
            double d3 = a;
            double d4;
            for (d4 = b; d4 > 360D; d4 -= 360D)
            {
                d3 -= 360D;
            }

            if (d2 < d3 || d2 > d4)
            {
                return false;
            }
        }
        return true;
    }

    public String toString()
    {
        return (new StringBuilder()).append("mDataIndex=").append(c).append(",mValue=").append(d).append(",mStartAngle=").append(a).append(",mEndAngle=").append(b).toString();
    }
}
