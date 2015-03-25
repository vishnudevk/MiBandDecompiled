// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import cn.com.smartdevices.bracelet.chart.data.AsyncChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            StatisticBaseFragment, u, StatisticChartViewOld, StatisticHostFragment

public class StatisticDailyFragment extends StatisticBaseFragment
{

    private static final String a = "Chart.StatisticDaily";
    private String b[];
    private String c[];

    public StatisticDailyFragment()
    {
    }

    protected String formatDate(SportDay sportday)
    {
        if (sportday.equals(mToday))
        {
            return getString(0x7f0d01b9);
        }
        if (sportday.addDay(1).equals(mToday) && !Locale.getDefault().toString().startsWith(Locale.ENGLISH.toString()))
        {
            return getString(0x7f0d005e);
        } else
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat(getString(0x7f0d0055));
            Date date = new Date();
            date.setMonth(sportday.mon);
            date.setDate(sportday.day);
            String s = simpledateformat.format(date);
            Object aobj[] = new Object[2];
            aobj[0] = s;
            aobj[1] = b[sportday.getWeek()];
            return getString(0x7f0d0057, aobj);
        }
    }

    protected String formatDateShort(SportDay sportday)
    {
        if (sportday.equals(mToday))
        {
            return getString(0x7f0d01b9);
        }
        if (sportday.addDay(1).equals(mToday) && !Locale.getDefault().toString().startsWith(Locale.ENGLISH.toString()))
        {
            return getString(0x7f0d005e);
        } else
        {
            Object aobj[] = new Object[3];
            aobj[0] = Integer.valueOf(1 + sportday.mon);
            aobj[1] = Integer.valueOf(sportday.day);
            aobj[2] = c[sportday.getWeek()];
            return getString(0x7f0d0058, aobj);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        AsyncChartDataLoader asyncchartdataloader = new AsyncChartDataLoader();
        asyncchartdataloader.setLoadCallback(new u(this));
        mActiveStatisticChart.setDataLoader(asyncchartdataloader);
        mActiveStatisticChart.loadData(0);
        mActiveStatisticChart.setScrollable(true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        b = getResources().getStringArray(0x7f07000d);
        c = getResources().getStringArray(0x7f07000e);
    }

    protected void updateSleepAchievement(int i)
    {
        if ((1 & StatisticHostFragment.sMode) > 0)
        {
            getView().findViewById(0x7f0a014c).setVisibility(8);
            return;
        } else
        {
            getView().findViewById(0x7f0a014c).setVisibility(0);
            super.updateSleepAchievement(i);
            return;
        }
    }

    protected void updateSleepRiseTime(int i)
    {
        if ((1 & StatisticHostFragment.sMode) > 0)
        {
            getView().findViewById(0x7f0a014a).setVisibility(8);
            return;
        } else
        {
            getView().findViewById(0x7f0a014a).setVisibility(0);
            super.updateSleepRiseTime(i);
            return;
        }
    }

    protected void updateSleepStartTime(int i)
    {
        if ((1 & StatisticHostFragment.sMode) > 0)
        {
            getView().findViewById(0x7f0a0148).setVisibility(8);
            return;
        } else
        {
            getView().findViewById(0x7f0a0148).setVisibility(0);
            super.updateSleepStartTime(i);
            return;
        }
    }

    protected void updateStepAchievement(int i)
    {
        if ((1 & StatisticHostFragment.sMode) > 0)
        {
            getView().findViewById(0x7f0a013d).setVisibility(8);
            return;
        } else
        {
            getView().findViewById(0x7f0a013d).setVisibility(0);
            super.updateStepAchievement(i);
            return;
        }
    }

    protected void updateStepActiveTime(int i)
    {
        super.updateStepActiveTime(i);
    }

    protected void updateStepContinueTime(int i)
    {
        if ((1 & StatisticHostFragment.sMode) > 0)
        {
            getView().findViewById(0x7f0a013a).setVisibility(8);
            return;
        } else
        {
            getView().findViewById(0x7f0a013a).setVisibility(0);
            super.updateStepContinueTime(i);
            return;
        }
    }
}
