// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.renderer;

import java.io.Serializable;
import java.text.NumberFormat;

// Referenced classes of package org.achartengine.renderer:
//            BasicStroke

public class SimpleSeriesRenderer
    implements Serializable
{

    private int a;
    private boolean b;
    private int c;
    private float d;
    private android.graphics.Paint.Align e;
    private float f;
    private BasicStroke g;
    private boolean h;
    private double i;
    private int j;
    private double k;
    private int l;
    private boolean m;
    private NumberFormat n;
    private boolean o;
    private boolean p;

    public SimpleSeriesRenderer()
    {
        a = 0xff0000ff;
        c = 100;
        d = 10F;
        e = android.graphics.Paint.Align.CENTER;
        f = 5F;
        h = false;
        m = true;
        p = true;
    }

    public NumberFormat getChartValuesFormat()
    {
        return n;
    }

    public float getChartValuesSpacing()
    {
        return f;
    }

    public android.graphics.Paint.Align getChartValuesTextAlign()
    {
        return e;
    }

    public float getChartValuesTextSize()
    {
        return d;
    }

    public int getColor()
    {
        return a;
    }

    public int getDisplayChartValuesDistance()
    {
        return c;
    }

    public int getGradientStartColor()
    {
        return j;
    }

    public double getGradientStartValue()
    {
        return i;
    }

    public int getGradientStopColor()
    {
        return l;
    }

    public double getGradientStopValue()
    {
        return k;
    }

    public BasicStroke getStroke()
    {
        return g;
    }

    public boolean isDisplayBoundingPoints()
    {
        return p;
    }

    public boolean isDisplayChartValues()
    {
        return b;
    }

    public boolean isGradientEnabled()
    {
        return h;
    }

    public boolean isHighlighted()
    {
        return o;
    }

    public boolean isShowLegendItem()
    {
        return m;
    }

    public void setChartValuesFormat(NumberFormat numberformat)
    {
        n = numberformat;
    }

    public void setChartValuesSpacing(float f1)
    {
        f = f1;
    }

    public void setChartValuesTextAlign(android.graphics.Paint.Align align)
    {
        e = align;
    }

    public void setChartValuesTextSize(float f1)
    {
        d = f1;
    }

    public void setColor(int i1)
    {
        a = i1;
    }

    public void setDisplayBoundingPoints(boolean flag)
    {
        p = flag;
    }

    public void setDisplayChartValues(boolean flag)
    {
        b = flag;
    }

    public void setDisplayChartValuesDistance(int i1)
    {
        c = i1;
    }

    public void setGradientEnabled(boolean flag)
    {
        h = flag;
    }

    public void setGradientStart(double d1, int i1)
    {
        i = d1;
        j = i1;
    }

    public void setGradientStop(double d1, int i1)
    {
        k = d1;
        l = i1;
    }

    public void setHighlighted(boolean flag)
    {
        o = flag;
    }

    public void setShowLegendItem(boolean flag)
    {
        m = flag;
    }

    public void setStroke(BasicStroke basicstroke)
    {
        g = basicstroke;
    }
}
