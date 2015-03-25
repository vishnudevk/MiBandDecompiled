// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;

import android.graphics.RectF;

public class ClickableArea
{

    private RectF a;
    private double b;
    private double c;

    public ClickableArea(RectF rectf, double d, double d1)
    {
        a = rectf;
        b = d;
        c = d1;
    }

    public RectF getRect()
    {
        return a;
    }

    public double getX()
    {
        return b;
    }

    public double getY()
    {
        return c;
    }
}
