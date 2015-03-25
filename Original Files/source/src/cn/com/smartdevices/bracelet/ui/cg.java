// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            cf, StatisticFragment

class cg extends cf
{

    final StatisticFragment q;
    private String r[];
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;

    public cg(StatisticFragment statisticfragment)
    {
        q = statisticfragment;
        super(statisticfragment, null);
        r = statisticfragment.getResources().getStringArray(0x7f07000d);
        s = statisticfragment.getString(0x7f0d005b);
        t = statisticfragment.getString(0x7f0d005e);
        u = statisticfragment.getString(0x7f0d0055);
        v = statisticfragment.getString(0x7f0d005d);
        w = statisticfragment.getString(0x7f0d0056);
    }

    protected cn.com.smartdevices.bracelet.chart.StatisticChartView.StatisticChartData a(int i)
    {
        SportDay sportday = StatisticFragment.x(q).addDay(i);
        Debug.i("Statistic.Main", (new StringBuilder()).append("Load Day : ").append(sportday).toString());
        String s1 = sportday.getKey();
        cn.com.smartdevices.bracelet.model.DaySportData.Summary summary;
        cn.com.smartdevices.bracelet.chart.StatisticChartView.StatisticChartData statisticchartdata;
        if (!StatisticFragment.t(q).containsKey(s1))
        {
            summary = StatisticFragment.y(q).getSummary(sportday);
            StatisticFragment.t(q).put(s1, summary);
        } else
        {
            summary = (cn.com.smartdevices.bracelet.model.DaySportData.Summary)StatisticFragment.t(q).get(s1);
        }
        statisticchartdata = new cn.com.smartdevices.bracelet.chart.StatisticChartView.StatisticChartData();
        if (summary != null)
        {
            statisticchartdata.stepValue = summary.getSteps();
            statisticchartdata.sleepValue = summary.getSleep();
            statisticchartdata.sleepDeepValue = summary.getSleepDeepTime();
        }
        statisticchartdata.date = b(sportday);
        return statisticchartdata;
    }

    protected ShareData a(SportDay sportday, int i)
    {
        ShareData sharedata = new ShareData();
        if (i != 16) goto _L2; else goto _L1
_L1:
        a(StatisticFragment.q(q), sharedata, sportday);
        if (!sportday.equals(StatisticFragment.C(q))) goto _L4; else goto _L3
_L3:
        sharedata.title = q.getString(0x7f0d0166);
_L6:
        return sharedata;
_L4:
        sharedata.title = q.getString(0x7f0d0168);
        return sharedata;
_L2:
        if (i == 1)
        {
            int j = c;
            Utils.getDayShareTips(q.getActivity(), a, b, o, j, sharedata);
            sharedata.time = StatisticFragment.w(q).formatStringDay();
            return sharedata;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected String a(SportDay sportday)
    {
        Date date = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat();
        if (sportday.equals(StatisticFragment.C(q)))
        {
            return s;
        }
        if (sportday.offsetDay(StatisticFragment.C(q)) == -1 && !StatisticFragment.D(q))
        {
            return t;
        }
        if (1 + sportday.mon == 1 && sportday.day == 1)
        {
            date.setYear(sportday.year);
            date.setMonth(sportday.mon);
            date.setDate(sportday.day);
            simpledateformat.applyPattern(v);
        } else
        {
            date.setMonth(sportday.mon);
            date.setDate(sportday.day);
            simpledateformat.applyPattern(u);
        }
        return simpledateformat.format(date);
    }

    protected String b(SportDay sportday)
    {
        if (!sportday.equals(StatisticFragment.C(q))) goto _L2; else goto _L1
_L1:
        String s2 = s;
_L4:
        return s2;
_L2:
        if (sportday.offsetDay(StatisticFragment.C(q)) != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (sportday.getWeek() == 0)
        {
            s2 = r[0];
            if (1 + sportday.mon == 1 && sportday.day == 1)
            {
                return (new StringBuilder()).append(sportday.year).append("/").append(s2).toString();
            }
        } else
        if (StatisticFragment.D(q))
        {
            String s3 = w;
            Object aobj1[] = new Object[2];
            aobj1[0] = Integer.valueOf(1 + sportday.mon);
            aobj1[1] = Integer.valueOf(sportday.day);
            return String.format(s3, aobj1);
        } else
        {
            return t;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (sportday.getWeek() == 0)
        {
            s2 = r[0];
        } else
        {
            String s1 = w;
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(1 + sportday.mon);
            aobj[1] = Integer.valueOf(sportday.day);
            s2 = String.format(s1, aobj);
        }
        if (1 + sportday.mon == 1 && sportday.day == 1)
        {
            return (new StringBuilder()).append(sportday.year).append("/").append(s2).toString();
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    protected void b(View view)
    {
        TextView textview = (TextView)view.findViewById(0x7f0a00c7);
        TextView textview1 = (TextView)view.findViewById(0x7f0a00c8);
        TextView textview2 = (TextView)view.findViewById(0x7f0a00ba);
        TextView textview3 = (TextView)view.findViewById(0x7f0a00c9);
        TextView textview4 = (TextView)view.findViewById(0x7f0a00cb);
        TextView textview5 = (TextView)view.findViewById(0x7f0a00cc);
        TextView textview6 = (TextView)view.findViewById(0x7f0a00cd);
        textview.setText(String.valueOf(a));
        String as[] = ChartData.formatDistance(q.getActivity(), b);
        textview1.setText(as[0]);
        textview2.setText(as[1]);
        textview3.setText(String.valueOf(c));
        textview4.setText(ChartData.formatTimeLength(q.getActivity(), d, 14));
        textview5.setText(ChartData.formatTimeLength(q.getActivity(), e, 14));
        textview6.setText(ChartData.formatTimeLength(q.getActivity(), f, 14));
    }

    protected boolean b(int i)
    {
        if (i > 0 || i < StatisticFragment.z(q).offsetDay(StatisticFragment.x(q)))
        {
            Debug.w("Statistic.Main", (new StringBuilder()).append("Has data False : ").append(i).toString());
            return false;
        } else
        {
            return true;
        }
    }

    protected void c(int i)
    {
        SportDay sportday = StatisticFragment.x(q).addDay(i);
        Debug.i("Statistic.Main", (new StringBuilder()).append("To Day : ").append(sportday).toString());
        StatisticFragment.b(q, sportday);
        StatisticFragment.c(q, sportday);
        a();
        c(sportday);
        a((View)StatisticFragment.A(q).get(1));
        b((View)StatisticFragment.B(q).get(1));
    }
}
