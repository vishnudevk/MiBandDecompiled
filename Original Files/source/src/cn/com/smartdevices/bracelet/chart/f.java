// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            DynamicDetailChartView

class f
    implements cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback
{

    final DynamicDetailChartView a;

    f(DynamicDetailChartView dynamicdetailchartview)
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
        return DynamicDetailChartView.a(a).loadData(i);
    }

    public void onDataLoaded(cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata)
    {
        DynamicDetailChartView.DynamicDetailChartData dynamicdetailchartdata;
label0:
        {
            if (itemdata != null)
            {
                dynamicdetailchartdata = (DynamicDetailChartView.DynamicDetailChartData)itemdata;
                if (DynamicDetailChartView.b(a) == 16)
                {
                    for (Iterator iterator1 = dynamicdetailchartdata.sleepData.iterator(); iterator1.hasNext();)
                    {
                        DynamicDetailChartView.DynamicDetailChartSleepData dynamicdetailchartsleepdata = (DynamicDetailChartView.DynamicDetailChartSleepData)iterator1.next();
                        dynamicdetailchartsleepdata.index = dynamicdetailchartsleepdata.index + 1440 * itemdata.index;
                    }

                }
                if (DynamicDetailChartView.b(a) == 1)
                {
                    for (Iterator iterator = dynamicdetailchartdata.stepData.iterator(); iterator.hasNext();)
                    {
                        DynamicDetailChartView.DynamicDetailChartStepData dynamicdetailchartstepdata = (DynamicDetailChartView.DynamicDetailChartStepData)iterator.next();
                        dynamicdetailchartstepdata.index = dynamicdetailchartstepdata.index + 24 * itemdata.index;
                    }

                }
                DynamicDetailChartView.c(a).remove(Integer.valueOf(itemdata.index));
                if (!DynamicDetailChartView.c(a).isEmpty())
                {
                    break label0;
                }
                onToItem(DynamicDetailChartView.d(a));
                DynamicDetailChartView.a(a, dynamicdetailchartdata, true);
                DynamicDetailChartView.a(a).onDataLoaded(itemdata);
            }
            return;
        }
        DynamicDetailChartView.a(a, dynamicdetailchartdata, false);
    }

    public void onToItem(int i)
    {
        DynamicDetailChartView.a(a).onToItem(i);
    }
}
