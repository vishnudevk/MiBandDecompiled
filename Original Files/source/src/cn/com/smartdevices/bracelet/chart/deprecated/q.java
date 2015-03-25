// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            StatisticChartOld, o

class q extends BarChart
{

    final StatisticChartOld a;

    private q(StatisticChartOld statisticchartold)
    {
        a = statisticchartold;
        super();
    }

    q(StatisticChartOld statisticchartold, o o)
    {
        this(statisticchartold);
    }

    protected void draw(Canvas canvas, RectF rectf, float f)
    {
        canvas.save();
        canvas.clipRect(rectf);
        super.draw(canvas, rectf, f);
        canvas.restore();
    }

    protected float itemHeight(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        if (baritem.value >= mMaxItemValue)
        {
            return rectf.height() - mPaddingTop - mPaddingBottom;
        } else
        {
            return ((float)baritem.value / (float)mMaxItemValue) * (rectf.height() - 1.0F * mDensity - mPaddingTop - mPaddingBottom) + 1.0F * mDensity;
        }
    }

    protected float itemOffsetX(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        return rectf.width() + (float)(-1 + baritem.index) * StatisticChartOld.a() + StatisticChartOld.b(a).getScroll();
    }

    protected float itemWidth(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        return StatisticChartOld.a() - 2.0F * mItemPadding;
    }
}
