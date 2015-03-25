// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            p, StatisticChart, n

class q extends p
{

    final StatisticChart b;
    private float c;
    private int d;

    private q(StatisticChart statisticchart)
    {
        b = statisticchart;
        super(statisticchart, null);
        d = 10;
    }

    q(StatisticChart statisticchart, n n)
    {
        this(statisticchart);
    }

    static float a(q q1)
    {
        return q1.c;
    }

    static int b(q q1)
    {
        return q1.d;
    }

    protected float itemHeight(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        if (baritem.value >= mMaxItemValue)
        {
            return rectf.height() - mPaddingTop - mPaddingBottom;
        } else
        {
            return ChartUtil.itemLevelSize(mMaxItemValue, baritem.value, c, d);
        }
    }

    protected void onRectChanged(RectF rectf)
    {
        super.onRectChanged(rectf);
        if (rectf != null)
        {
            float f = rectf.height() - mPaddingTop - mPaddingBottom;
            c = ChartUtil.updateLevelSize(mMaxItemValue, f, d);
        }
    }
}
