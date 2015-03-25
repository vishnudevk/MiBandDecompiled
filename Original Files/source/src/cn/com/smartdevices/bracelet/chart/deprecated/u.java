// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.SportDay;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            StatisticDailyFragment

class u
    implements cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback
{

    final StatisticDailyFragment a;

    u(StatisticDailyFragment statisticdailyfragment)
    {
        a = statisticdailyfragment;
        super();
    }

    public boolean hasData(int i)
    {
        SportDay sportday = a.mInitDay.addDay(i);
        Debug.i("Chart.StatisticDaily", (new StringBuilder()).append("Has Day : ").append(sportday).toString());
        if (sportday.before(a.mStartDay) || sportday.after(a.mStopDay))
        {
            Debug.w("Chart.StatisticDaily", "False!!");
            return false;
        } else
        {
            return true;
        }
    }

    public cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData loadData(int i)
    {
        SportDay sportday = a.mInitDay.addDay(i);
        Debug.i("Chart.StatisticDaily", (new StringBuilder()).append("Load Day : ").append(sportday).toString());
        cn.com.smartdevices.bracelet.model.DaySportData.Summary summary = a.mDataManager.getSummary(sportday);
        Debug.i("Chart.StatisticDaily", (new StringBuilder()).append("Summary : ").append(summary).toString());
        StatisticChartViewOld.StatisticChartData statisticchartdata = new StatisticChartViewOld.StatisticChartData();
        if (summary != null)
        {
            statisticchartdata.stepValue = summary.getSteps();
            statisticchartdata.sleepValue = (100 * summary.getSleep()) / 480;
        }
        statisticchartdata.date = a.formatDateShort(sportday);
        return statisticchartdata;
    }

    public void onDataLoaded(cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata)
    {
    }

    public void onToItem(int i)
    {
        SportDay sportday = a.mInitDay.addDay(i);
        Debug.i("Chart.StatisticDaily", (new StringBuilder()).append("To Day : ").append(sportday).toString());
        a.mCurrentDay = sportday;
        a.updateDateTitle(a.mCurrentDay);
        a.cleanStatisticData();
        cn.com.smartdevices.bracelet.model.DaySportData.Summary summary = a.mDataManager.getSummary(sportday);
        if (summary != null)
        {
            a.totalStatisticDataStep(summary);
            a.totalStatisticDataSleep(summary);
        }
        a.updateStatisticInfo();
    }
}
