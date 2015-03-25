// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import cn.com.smartdevices.bracelet.chart.base.ChartScroller;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            StatisticChartView

class s
    implements StatisticChartView.StatisticChartLoadCallback
{

    final StatisticChartView a;

    s(StatisticChartView statisticchartview)
    {
        a = statisticchartview;
        super();
    }

    public boolean hasData(int i)
    {
        return StatisticChartView.a(a).hasData(i);
    }

    public cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData loadData(int i)
    {
        a.loadStatisticData(i);
        StatisticChartView.a(a, false);
        return null;
    }

    public void onDataLoaded(cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata)
    {
    }

    public void onOverScrolled()
    {
        StatisticChartView.g(a).forceFinishScrolling();
    }

    public void onToItem(int i)
    {
        StatisticChartView.a(a).onToItem(i);
    }
}
