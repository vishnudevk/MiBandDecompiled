// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import java.util.ArrayList;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            StatisticChartView

class r
    implements cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback
{

    final StatisticChartView a;

    r(StatisticChartView statisticchartview)
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
        cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata = StatisticChartView.b(a).getItemData(i);
        if (itemdata == null)
        {
            itemdata = StatisticChartView.a(a).loadData(i);
        }
        return itemdata;
    }

    public void onDataLoaded(cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata)
    {
        if (!StatisticChartView.a(a, itemdata.index))
        {
            StatisticChartView.a(a, (StatisticChartView.StatisticChartData)itemdata);
            StatisticChartView.c(a);
        }
        StatisticChartView.d(a).remove(Integer.valueOf(itemdata.index));
        if (StatisticChartView.d(a).size() == 0)
        {
            if (StatisticChartView.e(a))
            {
                onToItem(StatisticChartView.f(a));
            }
            StatisticChartView.a(a).onDataLoaded(itemdata);
        }
    }

    public void onToItem(int i)
    {
        StatisticChartView.a(a).onToItem(i);
    }
}
