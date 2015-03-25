// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.RectF;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            c, DynamicDetailChartOld, b, a

class d extends c
{

    final DynamicDetailChartOld b;

    private d(DynamicDetailChartOld dynamicdetailchartold)
    {
        b = dynamicdetailchartold;
        super(dynamicdetailchartold, null);
    }

    d(DynamicDetailChartOld dynamicdetailchartold, a a)
    {
        this(dynamicdetailchartold);
    }

    protected float itemHeight(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        float f;
        if (baritem.index > DynamicDetailChartOld.c(b))
        {
            f = 0.0F;
        } else
        {
            b b1 = (b)DynamicDetailChartOld.f(b);
            f = ((float)baritem.scope / 1440F) * (rectf.height() - mPaddingTop - mPaddingBottom - DynamicDetailChartOld.a(b) - b1.getPaddingBottom());
            if (f < 1.0F * mDensity)
            {
                return 1.0F * mDensity;
            }
        }
        return f;
    }

    protected float itemOffsetX(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        return 0.0F;
    }

    protected float itemOffsetY(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        b b1 = (b)DynamicDetailChartOld.g(b);
        return ((float)baritem.index / 1440F) * (rectf.height() - mPaddingTop - mPaddingBottom - DynamicDetailChartOld.a(b) - b1.getPaddingBottom()) + b1.c();
    }

    protected float itemWidth(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        if (baritem.value >= mMaxItemValue)
        {
            return rectf.width() - mPaddingLeft - mPaddingRight;
        } else
        {
            return ((float)baritem.value / (float)mMaxItemValue) * (rectf.width() - mPaddingLeft - mPaddingRight);
        }
    }
}
