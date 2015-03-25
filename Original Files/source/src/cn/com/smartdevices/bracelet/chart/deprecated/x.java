// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.SportDay;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            StatisticWeeklyFragment

class x
    implements cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback
{

    final StatisticWeeklyFragment a;

    x(StatisticWeeklyFragment statisticweeklyfragment)
    {
        a = statisticweeklyfragment;
        super();
    }

    public boolean hasData(int i)
    {
        SportDay sportday = a.mInitDay.addWeek(i);
        Debug.i("Chart.StatisticWeekly", (new StringBuilder()).append("Has Week : ").append(a.formatDate(sportday)).toString());
        if (sportday.getWeekStartDay().before(a.mStartDay.getWeekStartDay()) || sportday.getWeekStartDay().after(a.mStopDay.getWeekStartDay()))
        {
            Debug.w("Chart.StatisticWeekly", "False!!");
            return false;
        } else
        {
            return true;
        }
    }

    public cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData loadData(int i)
    {
        int j;
        SportDay sportday;
        SportDay sportday1;
        int k;
        int l;
        int i1;
        int j1;
        j = 0;
        sportday = a.mInitDay.addWeek(i);
        Debug.i("Chart.StatisticWeekly", (new StringBuilder()).append("Load Week : ").append(a.formatDate(sportday)).toString());
        sportday1 = sportday.getWeekStartDay();
        k = 0;
        l = 0;
        i1 = 0;
        j1 = 0;
_L2:
        int l1;
        int i2;
        int j2;
        int k2;
        if (k >= 7)
        {
            break; /* Loop/switch isn't completed */
        }
        SportDay sportday2 = sportday1.addDay(k);
        Debug.i("Chart.StatisticWeekly", (new StringBuilder()).append("Load Day : ").append(sportday2).toString());
        cn.com.smartdevices.bracelet.model.DaySportData.Summary summary = a.mDataManager.getSummary(sportday2);
        Debug.i("Chart.StatisticWeekly", (new StringBuilder()).append("Summary : ").append(summary).toString());
        if (summary == null)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        if (summary.getSteps() > 0)
        {
            j1 += summary.getSteps();
            j++;
        }
        if (summary.getSleep() <= 0)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        int i3 = i1 + (100 * summary.getSleep()) / 480;
        int j3 = l + 1;
        l1 = i3;
        i2 = j1;
        j2 = j;
        k2 = j3;
_L3:
        k++;
        int l2 = k2;
        j = j2;
        j1 = i2;
        i1 = l1;
        l = l2;
        if (true) goto _L2; else goto _L1
_L1:
        StatisticChartViewOld.StatisticChartData statisticchartdata = a.newStatisticChartData(j1, i1, j, l);
        statisticchartdata.date = a.formatDateShort(sportday);
        return statisticchartdata;
        int k1 = l;
        l1 = i1;
        i2 = j1;
        j2 = j;
        k2 = k1;
          goto _L3
    }

    public void onDataLoaded(cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata)
    {
    }

    public void onToItem(int i)
    {
        SportDay sportday = a.mInitDay.addWeek(i);
        Debug.i("Chart.StatisticWeekly", (new StringBuilder()).append("To Week : ").append(a.formatDate(sportday)).toString());
        a.mCurrentDay = sportday;
        a.updateDateTitle(sportday);
        a.cleanStatisticData();
        SportDay sportday1 = sportday.getWeekStartDay();
        for (int j = 0; j < 7; j++)
        {
            SportDay sportday2 = sportday1.addDay(j);
            Debug.i("Chart.StatisticWeekly", (new StringBuilder()).append("Load Day : ").append(sportday2).toString());
            a.totalStatisticData(sportday2);
        }

        a.updateStatisticInfo();
    }
}
