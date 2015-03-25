// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;


// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            StatisticChartViewOld

class r
    implements cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback
{

    final cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback a;
    final StatisticChartViewOld b;

    r(StatisticChartViewOld statisticchartviewold, cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback loadcallback)
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
        return a.loadData(i);
    }

    public void onDataLoaded(cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata)
    {
        if (itemdata != null)
        {
            StatisticChartViewOld.a(b, (StatisticChartViewOld.StatisticChartData)itemdata);
            StatisticChartViewOld.a(b);
            b.refresh();
            if (StatisticChartViewOld.b(b) && itemdata.index == 0)
            {
                onToItem(itemdata.index);
                StatisticChartViewOld.a(b, false);
            }
        }
    }

    public void onToItem(int i)
    {
        a.onToItem(i);
    }
}
