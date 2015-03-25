// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.chart.data.AsyncChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.model.SportDay;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            StatisticBaseFragment, w, StatisticChartViewOld

public class StatisticMonthlyFragment extends StatisticBaseFragment
{

    private static final String a = "Chart.StatisticMonthly";
    private String b[];

    public StatisticMonthlyFragment()
    {
    }

    protected String formatDate(SportDay sportday)
    {
        if (sportday.year == mToday.year && sportday.mon == mToday.mon)
        {
            return getString(0x7f0d0059);
        }
        if (sportday.addMonth(1).year == mToday.year && sportday.addMonth(1).mon == mToday.mon)
        {
            return getString(0x7f0d0052);
        } else
        {
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(sportday.year);
            aobj[1] = b[sportday.mon];
            return getString(0x7f0d005c, aobj);
        }
    }

    protected String formatDateShort(SportDay sportday)
    {
        if (sportday.year == mToday.year && sportday.mon == mToday.mon)
        {
            return getString(0x7f0d0059);
        }
        if (sportday.addMonth(1).year == mToday.year && sportday.addMonth(1).mon == mToday.mon)
        {
            return getString(0x7f0d0052);
        } else
        {
            return (new StringBuilder()).append(sportday.year).append(b[sportday.mon]).toString();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        AsyncChartDataLoader asyncchartdataloader = new AsyncChartDataLoader();
        asyncchartdataloader.setLoadCallback(new w(this));
        mActiveStatisticChart.setDataLoader(asyncchartdataloader);
        mActiveStatisticChart.loadData(0);
        mActiveStatisticChart.setScrollable(true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        b = getResources().getStringArray(0x7f070001);
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
