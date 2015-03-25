// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.util.AttributeSet;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;
import cn.com.smartdevices.bracelet.chart.base.ColorRenderer;
import cn.com.smartdevices.bracelet.chart.base.Renderer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            DynamicShareChart

public class DynamicShareChartView extends BaseChartView
{

    private static final String a = "Chart.DynamicShareChartView";
    private Renderer b;

    public DynamicShareChartView(Context context)
    {
        this(context, null);
    }

    public DynamicShareChartView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DynamicShareChartView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mChart = new DynamicShareChart(context);
        b = new ColorRenderer(0x40ffffff);
    }

    private void a(List list)
    {
        ArrayList arraylist = new ArrayList();
        DynamicShareChart.DynamicShareBarItem dynamicsharebaritem;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(dynamicsharebaritem))
        {
            DynamicDetailChartView.DynamicDetailChartStepData dynamicdetailchartstepdata = (DynamicDetailChartView.DynamicDetailChartStepData)iterator.next();
            dynamicsharebaritem = new DynamicShareChart.DynamicShareBarItem();
            dynamicsharebaritem.value = dynamicdetailchartstepdata.step;
            dynamicsharebaritem.index = dynamicdetailchartstepdata.index;
            dynamicsharebaritem.setRenderer(b);
        }

        ((DynamicShareChart)mChart).fillItems(arraylist);
        ((DynamicShareChart)mChart).notifyChanged();
    }

    public void bindStepData(HashMap hashmap)
    {
        ArrayList arraylist = new ArrayList();
        int i = ((DynamicShareChart)mChart).getTotalHours();
        Iterator iterator = hashmap.keySet().iterator();
        int j = 0;
        while (iterator.hasNext()) 
        {
            Integer integer = (Integer)iterator.next();
            int k;
            int l;
            DynamicDetailChartView.DynamicDetailChartStepData dynamicdetailchartstepdata;
            int i1;
            int j1;
            if (integer.intValue() > j)
            {
                j1 = integer.intValue();
            } else
            {
                j1 = j;
            }
            j = j1;
        }
        Debug.i("Chart.DynamicShareChartView", (new StringBuilder()).append("Max Index : ").append(j).toString());
        if (j > i)
        {
            i1 = j - i;
            if (i1 % 2 != 0)
            {
                k = i1 + 2;
            } else
            {
                k = i1 + 1;
            }
        } else
        {
            k = 1;
        }
        Debug.i("Chart.DynamicShareChartView", (new StringBuilder()).append("Index Offset: ").append(k).toString());
        ((DynamicShareChart)mChart).setOffsetHour(k);
        for (l = k; l < k + i; l++)
        {
            dynamicdetailchartstepdata = new DynamicDetailChartView.DynamicDetailChartStepData();
            dynamicdetailchartstepdata.index = l;
            if (hashmap.get(Integer.valueOf(l)) != null)
            {
                dynamicdetailchartstepdata.step = ((Integer)hashmap.get(Integer.valueOf(l))).intValue();
            }
            arraylist.add(dynamicdetailchartstepdata);
        }

        a(arraylist);
    }
}
