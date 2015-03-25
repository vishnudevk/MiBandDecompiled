// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            StatisticChartViewOld, StatisticChartOld

class t
    implements cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener
{

    final StatisticChartViewOld a;

    t(StatisticChartViewOld statisticchartviewold)
    {
        a = statisticchartviewold;
        super();
    }

    public void onFinish()
    {
        Debug.i("Chart.StatisticChartView", "Scroll OnFinish!!");
        StatisticChartViewOld.i(a).onToItem(((StatisticChartOld)StatisticChartViewOld.h(a)).itemOffset());
        if (StatisticChartViewOld.j(a))
        {
            StatisticChartViewOld.c(a, false);
        }
        StatisticChartViewOld.b(a, 0);
    }

    public void onJustify()
    {
        Debug.i("Chart.StatisticChartView", "Scroll OnJustify!!");
        if (Math.abs(StatisticChartViewOld.e(a)) > 1)
        {
            StatisticChartViewOld.g(a).scrollX(((StatisticChartOld)StatisticChartViewOld.f(a)).justified());
        }
    }

    public boolean onScrollX(int i)
    {
        ((StatisticChartOld)StatisticChartViewOld.d(a)).scroll(i);
        a.postInvalidateOnAnimation();
        StatisticChartViewOld.a(a, i);
        return true;
    }

    public boolean onScrollY(int i)
    {
        return true;
    }

    public void onStart()
    {
        Debug.i("Chart.StatisticChartView", "Scroll OnStart!!");
        StatisticChartViewOld.b(a, true);
    }
}
