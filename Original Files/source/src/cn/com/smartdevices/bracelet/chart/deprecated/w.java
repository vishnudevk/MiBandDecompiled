// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.SportDay;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            StatisticMonthlyFragment

class w
    implements cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback
{

    final StatisticMonthlyFragment a;

    w(StatisticMonthlyFragment statisticmonthlyfragment)
    {
        a = statisticmonthlyfragment;
        super();
    }

    public boolean hasData(int i)
    {
        SportDay sportday = a.mInitDay.addMonth(i);
        Debug.i("Chart.StatisticMonthly", (new StringBuilder()).append("Has Month : ").append(a.formatDate(sportday)).toString());
        if (sportday.getMonthStartDay().before(a.mStartDay.getMonthStartDay()) || sportday.getMonthStartDay().after(a.mStopDay.getMonthStartDay()))
        {
            Debug.w("Chart.StatisticMonthly", "False!!");
            return false;
        } else
        {
            return true;
        }
    }

    public cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData loadData(int i)
    {
        int j = 0;
        SportDay sportday = a.mInitDay.addMonth(i);
        Debug.i("Chart.StatisticMonthly", (new StringBuilder()).append("Load Month : ").append(a.formatDate(sportday)).toString());
        SportDay sportday1 = sportday.getMonthStartDay();
        SportDay sportday2 = sportday.getMonthEndDay();
        Debug.i("Chart.StatisticMonthly", (new StringBuilder()).append(sportday1).append("~").append(sportday2).toString());
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        for (; j < sportday2.day; j++)
        {
            SportDay sportday3 = sportday1.addDay(j);
            Debug.i("Chart.StatisticMonthly", (new StringBuilder()).append("Load Day : ").append(sportday3).toString());
            cn.com.smartdevices.bracelet.model.DaySportData.Summary summary = a.mDataManager.getSummary(sportday3);
            Debug.i("Chart.StatisticMonthly", (new StringBuilder()).append("Summary : ").append(summary).toString());
            if (summary == null)
            {
                continue;
            }
            if (summary.getSteps() > 0)
            {
                j1 += summary.getSteps();
                l++;
            }
            if (summary.getSleep() > 0)
            {
                i1 += (100 * summary.getSleep()) / 480;
                k++;
            }
        }

        StatisticChartViewOld.StatisticChartData statisticchartdata = a.newStatisticChartData(j1, i1, l, k);
        statisticchartdata.date = a.formatDateShort(sportday);
        return statisticchartdata;
    }

    public void onDataLoaded(cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata)
    {
    }

    public void onToItem(int i)
    {
        SportDay sportday = a.mInitDay.addMonth(i);
        Debug.i("Chart.StatisticMonthly", (new StringBuilder()).append("To Month : ").append(a.formatDate(sportday)).toString());
        a.mCurrentDay = sportday;
        a.updateDateTitle(a.mCurrentDay);
        a.cleanStatisticData();
        SportDay sportday1 = sportday.getMonthStartDay();
        SportDay sportday2 = sportday.getMonthEndDay();
        Debug.i("Chart.StatisticMonthly", (new StringBuilder()).append(sportday1).append("~").append(sportday2).toString());
        for (int j = 0; j < sportday2.day; j++)
        {
            SportDay sportday3 = sportday1.addDay(j);
            Debug.i("Chart.StatisticMonthly", (new StringBuilder()).append("Load Day : ").append(sportday3).toString());
            a.totalStatisticData(sportday3);
        }

        a.updateStatisticInfo();
    }
}
