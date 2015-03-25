// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.chart.base.ChartScroller;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            StatisticChartViewOld

class s
    implements StatisticChartViewOld.StatisticChartLoadCallback
{

    final cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback a;
    final StatisticChartViewOld b;

    s(StatisticChartViewOld statisticchartviewold, cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback loadcallback)
    {
        b = statisticchartviewold;
        a = loadcallback;
        super();
    }

    public boolean hasData(int i)
    {
        return a.hasData(i);
    }

    public cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData loadData(int i)
    {
        b.loadData(i);
        return null;
    }

    public void onDataLoaded(cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata)
    {
    }

    public void onOverScrolled()
    {
        StatisticChartViewOld.c(b).forceFinishScrolling();
    }

    public void onToItem(int i)
    {
        a.onToItem(i);
    }
}
