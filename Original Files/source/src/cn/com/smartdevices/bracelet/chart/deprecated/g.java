// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;


// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            DynamicDetailChartViewOld

class g
    implements cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback
{

    final cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback a;
    final DynamicDetailChartViewOld b;

    g(DynamicDetailChartViewOld dynamicdetailchartviewold, cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback loadcallback)
    {
        b = dynamicdetailchartviewold;
        a = loadcallback;
        super();
    }

    public boolean hasData(int i)
    {
        return a.hasData(i);
    }

    public cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData loadData(int i)
    {
        return b.loadDayActiveData(i);
    }

    public void onDataLoaded(cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata)
    {
    }

    public void onToItem(int i)
    {
        a.onToItem(i);
    }
}
