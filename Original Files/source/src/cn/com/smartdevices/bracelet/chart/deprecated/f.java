// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            DynamicDetailChartViewOld

class f
    implements cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback
{

    final cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback a;
    final DynamicDetailChartViewOld b;

    f(DynamicDetailChartViewOld dynamicdetailchartviewold, cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback loadcallback)
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
        return a.loadData(i);
    }

    public void onDataLoaded(cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata)
    {
        if (itemdata != null)
        {
            DynamicDetailChartViewOld.DynamicDetailChartData dynamicdetailchartdata = (DynamicDetailChartViewOld.DynamicDetailChartData)itemdata;
            for (Iterator iterator = dynamicdetailchartdata.sleepData.iterator(); iterator.hasNext();)
            {
                DynamicDetailChartViewOld.DynamicDetailChartSleepData dynamicdetailchartsleepdata = (DynamicDetailChartViewOld.DynamicDetailChartSleepData)iterator.next();
                dynamicdetailchartsleepdata.index = dynamicdetailchartsleepdata.index + 1440 * itemdata.index;
            }

            for (Iterator iterator1 = dynamicdetailchartdata.stepData.iterator(); iterator1.hasNext();)
            {
                DynamicDetailChartViewOld.DynamicDetailChartStepData dynamicdetailchartstepdata = (DynamicDetailChartViewOld.DynamicDetailChartStepData)iterator1.next();
                dynamicdetailchartstepdata.index = dynamicdetailchartstepdata.index + 24 * itemdata.index;
            }

            DynamicDetailChartViewOld.a(b, dynamicdetailchartdata);
            if (DynamicDetailChartViewOld.a(b) == itemdata.index)
            {
                onToItem(itemdata.index);
            }
            if (DynamicDetailChartViewOld.b(b))
            {
                b.refresh(true);
            }
            DynamicDetailChartViewOld.a(b, true);
        }
    }

    public void onToItem(int i)
    {
        a.onToItem(i);
    }
}
