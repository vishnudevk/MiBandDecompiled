// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;


// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            DynamicDetailChartView

class g
    implements cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback
{

    final DynamicDetailChartView a;

    g(DynamicDetailChartView dynamicdetailchartview)
    {
        a = dynamicdetailchartview;
        super();
    }

    public boolean hasData(int i)
    {
        return DynamicDetailChartView.a(a).hasData(i);
    }

    public cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData loadData(int i)
    {
        return a.loadDynamicData(i);
    }

    public void onDataLoaded(cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata)
    {
    }

    public void onToItem(int i)
    {
        DynamicDetailChartView.a(a).onToItem(i);
    }
}
