// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            StatisticChartView, StatisticChart

class t
    implements cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener
{

    final StatisticChartView a;

    t(StatisticChartView statisticchartview)
    {
        a = statisticchartview;
        super();
    }

    public void onFinish()
    {
        Debug.i("Chart.StatisticChartView", "Scroll OnFinish!!");
        StatisticChartView.m(a).onToItem(((StatisticChart)StatisticChartView.l(a)).itemOffset());
        if (StatisticChartView.n(a))
        {
            StatisticChartView.c(a, false);
        }
        StatisticChartView.c(a, 0);
    }

    public void onJustify()
    {
        Debug.i("Chart.StatisticChartView", "Scroll OnJustify!!");
        if (Math.abs(StatisticChartView.i(a)) > 1)
        {
            StatisticChartView.k(a).scrollX(((StatisticChart)StatisticChartView.j(a)).justified());
        }
    }

    public boolean onScrollX(int i)
    {
        ((StatisticChart)StatisticChartView.h(a)).scroll(i);
        a.postInvalidateOnAnimation();
        StatisticChartView.b(a, i);
        return true;
    }

    public boolean onScrollY(int i)
    {
        return true;
    }

    public void onStart()
    {
        Debug.i("Chart.StatisticChartView", "Scroll OnStart!!");
        StatisticChartView.b(a, true);
    }
}
