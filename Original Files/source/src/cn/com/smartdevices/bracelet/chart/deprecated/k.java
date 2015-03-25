// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.util.Calendar;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            DynamicDetailFragmentOld, DynamicDetailChartViewOld

class k
    implements cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback
{

    final DynamicDetailFragmentOld a;

    k(DynamicDetailFragmentOld dynamicdetailfragmentold)
    {
        a = dynamicdetailfragmentold;
        super();
    }

    private int a(Calendar calendar)
    {
        return -(60 * (-1 + (24 - calendar.get(11))) + (60 - calendar.get(12)));
    }

    private int b(Calendar calendar)
    {
        return 60 * calendar.get(11) + calendar.get(12);
    }

    public boolean hasData(int i)
    {
        SportDay sportday = DynamicDetailFragmentOld.b(a).addDay(i);
        Debug.i("DDDD", (new StringBuilder()).append("Has Day : ").append(sportday).toString());
        if (sportday.before(DynamicDetailFragmentOld.a(a)) || sportday.after(DynamicDetailFragmentOld.c(a)))
        {
            Debug.w("DDDD", "False!!");
            return false;
        } else
        {
            return true;
        }
    }

    public cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData loadData(int i)
    {
        SportDay sportday = DynamicDetailFragmentOld.b(a).addDay(i);
        Debug.i("DDDD", (new StringBuilder()).append("Load Data : ").append(sportday).toString());
        DynamicDetailFragmentOld.e(a).load(sportday);
        DaySportData daysportdata = DynamicDetailFragmentOld.e(a).get(sportday);
        DynamicDetailChartViewOld.DynamicDetailChartData dynamicdetailchartdata;
        String s;
        if (daysportdata != null)
        {
            dynamicdetailchartdata = DynamicDetailFragmentOld.a(a, daysportdata);
        } else
        {
            dynamicdetailchartdata = new DynamicDetailChartViewOld.DynamicDetailChartData();
        }
        if (sportday.equals(DynamicDetailFragmentOld.f(a)))
        {
            s = "\u4ECA\u5929";
        } else
        if (sportday.addDay(1).equals(DynamicDetailFragmentOld.f(a)))
        {
            s = "\u6628\u5929";
        } else
        {
            s = DynamicDetailFragmentOld.b(a, DynamicDetailFragmentOld.b(a).addDay(i));
        }
        dynamicdetailchartdata.date = s;
        dynamicdetailchartdata.prevDate = DynamicDetailFragmentOld.b(a, DynamicDetailFragmentOld.b(a).addDay(i - 1));
        return dynamicdetailchartdata;
    }

    public void onDataLoaded(cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata)
    {
    }

    public void onToItem(int i)
    {
        SportDay sportday = DynamicDetailFragmentOld.b(a).addDay(i);
        Debug.i("DDDD", (new StringBuilder()).append("On To : ").append(sportday).toString());
        DaySportData daysportdata = DynamicDetailFragmentOld.e(a).get(sportday);
        StepsInfo stepsinfo;
        SleepInfo sleepinfo;
        Calendar calendar;
        Calendar calendar1;
        String s;
        String s1;
        if (daysportdata != null)
        {
            sleepinfo = daysportdata.getSleepInfo();
            stepsinfo = daysportdata.getStepsInfo();
        } else
        {
            stepsinfo = null;
            sleepinfo = null;
        }
        if (sleepinfo == null)
        {
            sleepinfo = new SleepInfo();
        }
        if (stepsinfo == null)
        {
            stepsinfo = new StepsInfo();
        }
        calendar = Calendar.getInstance();
        calendar.setTime(sleepinfo.getStartDate());
        calendar1 = Calendar.getInstance();
        calendar1.setTime(sleepinfo.getStopDate());
        DynamicDetailFragmentOld.g(a).setOffset(0);
        if (!calendar.equals(calendar1))
        {
            int j = calendar.get(11);
            String as[];
            String s2;
            int l;
            int i1;
            if (sportday.addDay(-1).equals(calendar))
            {
                DynamicDetailFragmentOld.g(a).setOffset(-(24 - j));
                l = a(calendar);
            } else
            {
                l = b(calendar);
            }
            if (sportday.addDay(-1).equals(calendar1))
            {
                i1 = a(calendar1);
            } else
            {
                i1 = b(calendar1);
            }
            DynamicDetailFragmentOld.g(a).setSleepStartTime(l, a.formatTime(calendar.get(11), calendar.get(12)), " \u4F11\u517B\u751F\u606F");
            DynamicDetailFragmentOld.g(a).setSleepRiseTime(i1, a.formatTime(calendar1.get(11), calendar1.get(12)), " \u65B0\u7684\u4E00\u5929");
        }
        s = new String();
        as = a.formatTimeHourMin(stepsinfo.getActMinutes());
        if (as[0] != null)
        {
            s1 = (new StringBuilder()).append(s).append(as[0]).append("\u5C0F\u65F6").toString();
        } else
        {
            s1 = s;
        }
        s2 = (new StringBuilder()).append(s1).append(as[1]).append("\u5206\u949F").toString();
        DynamicDetailFragmentOld.g(a).setStepTime("\u603B\u6D3B\u52A8\u65F6\u95F4", s2);
        DynamicDetailFragmentOld.g(a).notifyChanged();
    }
}
