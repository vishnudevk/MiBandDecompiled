// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.eventbus.EventSwitchViewMode;
import cn.com.smartdevices.bracelet.eventbus.EventUpdateTitle;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SportDay;
import de.greenrobot.event.EventBus;
import java.text.DecimalFormat;
import java.util.Calendar;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            StatisticChartViewOld, StatisticHostFragment

public class StatisticBaseFragment extends Fragment
{

    private static final String a = "Chart.StatisticBaseFragment";
    private int b;
    protected StatisticChartViewOld mActiveStatisticChart;
    protected SportDay mCurrentDay;
    protected DataManager mDataManager;
    protected int mDayCountSleep;
    protected int mDayCountStep;
    protected SportDay mInitDay;
    protected int mSleepAchievement;
    protected int mSleepDeepTime;
    protected int mSleepRiseTime;
    protected int mSleepShallowTime;
    protected int mSleepStartTime;
    protected int mSleepTime;
    protected SportDay mStartDay;
    protected TextView mStatSleepAchievement;
    protected TextView mStatSleepDeepHour;
    protected TextView mStatSleepDeepMin;
    protected TextView mStatSleepHour;
    protected TextView mStatSleepMin;
    protected TextView mStatSleepRiseTime;
    protected TextView mStatSleepShallowHour;
    protected TextView mStatSleepShallowMin;
    protected TextView mStatSleepStartTime;
    protected TextView mStatStepAchievement;
    protected TextView mStatStepActiveHour;
    protected TextView mStatStepActiveMin;
    protected TextView mStatStepCalorie;
    protected TextView mStatStepContinueHour;
    protected TextView mStatStepContinueMin;
    protected TextView mStatStepCount;
    protected TextView mStatStepDistance;
    protected TextView mStatStepDistanceUnit;
    protected int mStepAchievement;
    protected int mStepActiveTime;
    protected int mStepCalorie;
    protected int mStepContinueTime;
    protected int mStepCount;
    protected int mStepDistance;
    protected SportDay mStopDay;
    protected SportDay mToday;

    public StatisticBaseFragment()
    {
    }

    private void a(View view)
    {
        mActiveStatisticChart = (StatisticChartViewOld)view.findViewById(0x7f0a012e);
        mStatStepCount = (TextView)view.findViewById(0x7f0a0130);
        mStatStepDistance = (TextView)view.findViewById(0x7f0a0133);
        mStatStepDistanceUnit = (TextView)view.findViewById(0x7f0a0132);
        mStatStepCalorie = (TextView)view.findViewById(0x7f0a0136);
        mStatStepAchievement = (TextView)view.findViewById(0x7f0a013e);
        mStatStepActiveHour = (TextView)view.findViewById(0x7f0a0138);
        mStatStepActiveMin = (TextView)view.findViewById(0x7f0a0139);
        mStatStepContinueHour = (TextView)view.findViewById(0x7f0a013b);
        mStatStepContinueMin = (TextView)view.findViewById(0x7f0a013c);
        mStatSleepHour = (TextView)view.findViewById(0x7f0a0140);
        mStatSleepMin = (TextView)view.findViewById(0x7f0a0141);
        mStatSleepDeepHour = (TextView)view.findViewById(0x7f0a0143);
        mStatSleepDeepMin = (TextView)view.findViewById(0x7f0a0144);
        mStatSleepShallowHour = (TextView)view.findViewById(0x7f0a0146);
        mStatSleepShallowMin = (TextView)view.findViewById(0x7f0a0147);
        mStatSleepAchievement = (TextView)view.findViewById(0x7f0a014d);
        mStatSleepStartTime = (TextView)view.findViewById(0x7f0a0149);
        mStatSleepRiseTime = (TextView)view.findViewById(0x7f0a014b);
    }

    private void a(TextView textview, TextView textview1, int i)
    {
        String as[] = ChartData.formatTimeLengthHourMin(i);
        if (!as[0].equals("0"))
        {
            textview.setText(as[0]);
            ((View)textview.getParent()).setVisibility(0);
        } else
        {
            ((View)textview.getParent()).setVisibility(8);
        }
        textview1.setText(as[1]);
    }

    private String[] a(Context context, int i)
    {
        String as[] = new String[2];
        float f = i;
        if (i >= 1000)
        {
            as[0] = String.valueOf((float)Math.round(100F * (f / 1000F)) / 100F);
            as[1] = context.getString(0x7f0d01c0);
            return as;
        } else
        {
            as[0] = String.valueOf(i);
            as[1] = context.getString(0x7f0d01c1);
            return as;
        }
    }

    private String[] b(Context context, int i)
    {
        String as[] = new String[2];
        String s;
        if (i < 100)
        {
            s = String.valueOf(i);
        } else
        {
            s = String.valueOf(i);
        }
        as[0] = s;
        return as;
    }

    protected void cleanStatisticData()
    {
        mStepCount = 0;
        mStepDistance = 0;
        mStepCalorie = 0;
        mStepAchievement = 0;
        mStepActiveTime = 0;
        mStepContinueTime = 0;
        mSleepTime = 0;
        mSleepDeepTime = 0;
        mSleepShallowTime = 0;
        mSleepAchievement = 0;
        mSleepStartTime = 0;
        mSleepRiseTime = 0;
        mDayCountStep = 0;
        mDayCountSleep = 0;
    }

    protected String formatDate(SportDay sportday)
    {
        return null;
    }

    protected String formatDateShort(SportDay sportday)
    {
        return null;
    }

    protected int millisToMins(long l)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        int i = calendar.get(11);
        return calendar.get(12) + i * 60;
    }

    protected StatisticChartViewOld.StatisticChartData newStatisticChartData(int i, int j, int k, int l)
    {
        StatisticChartViewOld.StatisticChartData statisticchartdata = new StatisticChartViewOld.StatisticChartData();
        if (k > 0)
        {
            statisticchartdata.stepValue = i / k;
        }
        if (l > 0)
        {
            statisticchartdata.sleepValue = j / l;
        }
        return statisticchartdata;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mActiveStatisticChart.setStepGoal(b);
        updateStatisticInfo();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        mDataManager = DataManager.getInstance();
        mToday = mDataManager.getToday();
        mInitDay = mDataManager.getCurDay();
        mCurrentDay = mInitDay;
        mStartDay = mDataManager.getStartDay();
        mStopDay = mDataManager.getStopDay();
        Debug.i("Chart.StatisticBaseFragment", (new StringBuilder()).append("Today : ").append(mToday).append(" , StartDay : ").append(mStartDay).append(" , StopDay : ").append(mStopDay).append(" , CurrentDay : ").append(mCurrentDay).toString());
        b = Keeper.readPersonInfo().getDaySportGoalSteps();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f030049, viewgroup, false);
        a(view);
        return view;
    }

    public void onDestroy()
    {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEvent(EventSwitchViewMode eventswitchviewmode)
    {
        updateStatisticInfo();
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag)
        {
            updateDateTitle(mCurrentDay);
            updateStatisticInfo();
        }
    }

    protected void totalStatisticData(SportDay sportday)
    {
        cn.com.smartdevices.bracelet.model.DaySportData.Summary summary = mDataManager.getSummary(sportday);
        Debug.i("Chart.StatisticBaseFragment", (new StringBuilder()).append("Summary : ").append(summary).toString());
        if (summary != null)
        {
            if (summary.getSteps() > 0)
            {
                totalStatisticDataStep(summary);
                mDayCountStep = 1 + mDayCountStep;
            }
            if (summary.getSleep() > 0)
            {
                totalStatisticDataSleep(summary);
                mDayCountSleep = 1 + mDayCountSleep;
            }
        }
    }

    protected void totalStatisticDataSleep(cn.com.smartdevices.bracelet.model.DaySportData.Summary summary)
    {
        mSleepTime = mSleepTime + summary.getSleep();
        mSleepDeepTime = mSleepDeepTime + summary.getSleepDeepTime();
        mSleepShallowTime = mSleepShallowTime + summary.getSleepShallowTime();
        mSleepAchievement = mSleepAchievement + (100 * summary.getSleep()) / 480;
        mSleepStartTime = mSleepStartTime + millisToMins(summary.getSleepStartTime());
        mSleepRiseTime = mSleepRiseTime + millisToMins(summary.getSleepRiseTime());
    }

    protected void totalStatisticDataStep(cn.com.smartdevices.bracelet.model.DaySportData.Summary summary)
    {
        mStepCount = mStepCount + summary.getSteps();
        mStepDistance = mStepDistance + summary.getStepDistance();
        mStepCalorie = mStepCalorie + summary.getStepCalorie();
        mStepAchievement = mStepAchievement + (100 * summary.getSteps()) / b;
        mStepActiveTime = mStepActiveTime + summary.getStepActiveTime();
        mStepContinueTime = mStepContinueTime + summary.getStepContinueTime();
    }

    protected void updateDateTitle(SportDay sportday)
    {
        if (getUserVisibleHint() && sportday != null)
        {
            String s = formatDate(sportday);
            Debug.i("Chart.StatisticBaseFragment", (new StringBuilder()).append("UpdateTitle : ").append(s).toString());
            EventBus.getDefault().post(new EventUpdateTitle(s));
        }
    }

    protected void updateSleepAchievement(int i)
    {
        mStatSleepAchievement.setText(String.valueOf(i));
    }

    protected void updateSleepDeepTime(int i)
    {
        a(mStatSleepDeepHour, mStatSleepDeepMin, i);
    }

    protected void updateSleepRiseTime(int i)
    {
        mStatSleepRiseTime.setText(ChartData.formatTime(i));
    }

    protected void updateSleepShallow(int i)
    {
        a(mStatSleepShallowHour, mStatSleepShallowMin, i);
    }

    protected void updateSleepStartTime(int i)
    {
        mStatSleepStartTime.setText(ChartData.formatTime(i));
    }

    protected void updateSleepTime(int i)
    {
        a(mStatSleepHour, mStatSleepMin, i);
    }

    protected void updateStatisticInfo()
    {
        if (getView() == null)
        {
            return;
        }
        boolean flag;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if ((0x100 & StatisticHostFragment.sMode) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mDayCountStep == 0)
        {
            mDayCountStep = 1;
        }
        if (flag)
        {
            i = mStepCount / mDayCountStep;
        } else
        {
            i = mStepCount;
        }
        updateStepCount(i);
        if (flag)
        {
            j = mStepDistance / mDayCountStep;
        } else
        {
            j = mStepDistance;
        }
        updateStepDistance(j);
        if (flag)
        {
            k = mStepCalorie / mDayCountStep;
        } else
        {
            k = mStepCalorie;
        }
        updateStepCalorie(k);
        updateStepAchievement(mStepAchievement);
        if (flag)
        {
            l = mStepActiveTime / mDayCountStep;
        } else
        {
            l = mStepActiveTime;
        }
        updateStepActiveTime(l);
        updateStepContinueTime(mStepContinueTime);
        if (mDayCountSleep == 0)
        {
            mDayCountSleep = 1;
        }
        if (flag)
        {
            i1 = mSleepTime / mDayCountSleep;
        } else
        {
            i1 = mSleepTime;
        }
        updateSleepTime(i1);
        if (flag)
        {
            j1 = mSleepDeepTime / mDayCountSleep;
        } else
        {
            j1 = mSleepDeepTime;
        }
        updateSleepDeepTime(j1);
        if (flag)
        {
            k1 = mSleepShallowTime / mDayCountSleep;
        } else
        {
            k1 = mSleepShallowTime;
        }
        updateSleepShallow(k1);
        updateSleepAchievement(mSleepAchievement);
        updateSleepStartTime(mSleepStartTime);
        updateSleepRiseTime(mSleepRiseTime);
    }

    protected void updateStepAchievement(int i)
    {
        mStatStepAchievement.setText(String.valueOf(i));
    }

    protected void updateStepActiveTime(int i)
    {
        a(mStatStepActiveHour, mStatStepActiveMin, i);
    }

    protected void updateStepCalorie(int i)
    {
        mStatStepCalorie.setText((new DecimalFormat(",###")).format(i));
    }

    protected void updateStepContinueTime(int i)
    {
        a(mStatStepContinueHour, mStatStepContinueMin, i);
    }

    protected void updateStepCount(int i)
    {
        mStatStepCount.setText((new DecimalFormat(",###")).format(i));
    }

    protected void updateStepDistance(int i)
    {
        String as[] = a(getActivity(), i);
        mStatStepDistance.setText(as[0]);
        mStatStepDistanceUnit.setText(as[1]);
    }
}
