// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.chart.data.AsyncChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.model.SportDay;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            StatisticBaseFragment, x, StatisticChartViewOld

public class StatisticWeeklyFragment extends StatisticBaseFragment
{

    private static final String a = "Chart.StatisticWeekly";

    public StatisticWeeklyFragment()
    {
    }

    protected String formatDate(SportDay sportday)
    {
        if (sportday.getWeekStartDay().equals(mToday.getWeekStartDay()))
        {
            return "\u672C\u5468";
        }
        if (sportday.addWeek(1).getWeekStartDay().equals(mToday.getWeekStartDay()))
        {
            return "\u4E0A\u5468";
        } else
        {
            SportDay sportday1 = sportday.getWeekStartDay();
            SportDay sportday2 = sportday1.addDay(6);
            StringBuilder stringbuilder = new StringBuilder();
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(1 + sportday1.mon);
            aobj[1] = Integer.valueOf(sportday1.day);
            StringBuilder stringbuilder1 = stringbuilder.append(getString(0x7f0d0055, aobj)).append(" - ");
            Object aobj1[] = new Object[2];
            aobj1[0] = Integer.valueOf(1 + sportday2.mon);
            aobj1[1] = Integer.valueOf(sportday2.day);
            return stringbuilder1.append(getString(0x7f0d0055, aobj1)).toString();
        }
    }

    protected String formatDateShort(SportDay sportday)
    {
        if (sportday.getWeekStartDay().equals(mToday.getWeekStartDay()))
        {
            return "\u672C\u5468";
        }
        if (sportday.addWeek(1).getWeekStartDay().equals(mToday.getWeekStartDay()))
        {
            return "\u4E0A\u5468";
        } else
        {
            SportDay sportday1 = sportday.getWeekStartDay();
            SportDay sportday2 = sportday1.addDay(6);
            StringBuilder stringbuilder = new StringBuilder();
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(1 + sportday1.mon);
            aobj[1] = Integer.valueOf(sportday1.day);
            StringBuilder stringbuilder1 = stringbuilder.append(getString(0x7f0d0056, aobj)).append("-");
            Object aobj1[] = new Object[2];
            aobj1[0] = Integer.valueOf(1 + sportday2.mon);
            aobj1[1] = Integer.valueOf(sportday2.day);
            return stringbuilder1.append(getString(0x7f0d0056, aobj1)).toString();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        AsyncChartDataLoader asyncchartdataloader = new AsyncChartDataLoader();
        asyncchartdataloader.setLoadCallback(new x(this));
        mActiveStatisticChart.setDataLoader(asyncchartdataloader);
        mActiveStatisticChart.loadData(0);
        mActiveStatisticChart.setScrollable(true);
    }

    protected void updateSleepAchievement(int i)
    {
        getView().findViewById(0x7f0a014c).setVisibility(8);
    }

    protected void updateSleepRiseTime(int i)
    {
        getView().findViewById(0x7f0a014a).setVisibility(8);
    }

    protected void updateSleepStartTime(int i)
    {
        getView().findViewById(0x7f0a0148).setVisibility(8);
    }

    protected void updateStepAchievement(int i)
    {
        View view = getView().findViewById(0x7f0a013d);
        if (view != null)
        {
            ((ViewGroup)view.getParent()).removeView(view);
        }
    }

    protected void updateStepContinueTime(int i)
    {
        getView().findViewById(0x7f0a013a).setVisibility(8);
    }
}
