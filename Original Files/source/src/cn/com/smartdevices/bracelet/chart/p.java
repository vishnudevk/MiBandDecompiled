// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            StatisticChart, n

class p extends BarChart
{

    final StatisticChart a;

    private p(StatisticChart statisticchart)
    {
        a = statisticchart;
        super();
    }

    p(StatisticChart statisticchart, n n)
    {
        this(statisticchart);
    }

    public void a(Canvas canvas, float f, float f1, float f2, float f3, float f4)
    {
        List list = mItems;
        list;
        JVM INSTR monitorenter ;
        Iterator iterator = mItems.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem = (cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem)iterator.next();
            if (baritem.needDraw)
            {
                ((StatisticChart.StatisticBarItem)baritem).draw(canvas, f, f1, f2, f3, f4);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_78;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    protected float itemOffsetX(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        return (float)(StatisticChart.d(a) + baritem.index) * StatisticChart.a(a) + StatisticChart.e(a).getScroll();
    }

    protected float itemWidth(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        return StatisticChart.a(a) - 2.0F * mItemPadding;
    }
}
