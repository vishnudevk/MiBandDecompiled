// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.model;


public class SeriesSelection
{

    private int a;
    private int b;
    private double c;
    private double d;

    public SeriesSelection(int i, int j, double d1, double d2)
    {
        a = i;
        b = j;
        c = d1;
        d = d2;
    }

    public int getPointIndex()
    {
        return b;
    }

    public int getSeriesIndex()
    {
        return a;
    }

    public double getValue()
    {
        return d;
    }

    public double getXValue()
    {
        return c;
    }
}
