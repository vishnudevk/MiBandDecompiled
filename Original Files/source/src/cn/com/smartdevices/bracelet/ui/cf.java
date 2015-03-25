// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.util.Calendar;
import java.util.HashMap;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            StatisticFragment, bZ

abstract class cf
{

    protected int a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected int m;
    protected int n;
    protected int o;
    final StatisticFragment p;

    private cf(StatisticFragment statisticfragment)
    {
        p = statisticfragment;
        super();
    }

    cf(StatisticFragment statisticfragment, bZ bz)
    {
        this(statisticfragment);
    }

    protected int a(long l1)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l1);
        int i1 = calendar.get(11);
        return calendar.get(12) + i1 * 60;
    }

    protected abstract cn.com.smartdevices.bracelet.chart.StatisticChartView.StatisticChartData a(int i1);

    protected cn.com.smartdevices.bracelet.chart.StatisticChartView.StatisticChartData a(int i1, int j1, int k1, int l1, int i2)
    {
        cn.com.smartdevices.bracelet.chart.StatisticChartView.StatisticChartData statisticchartdata = new cn.com.smartdevices.bracelet.chart.StatisticChartView.StatisticChartData();
        if (l1 > 0)
        {
            statisticchartdata.stepValue = i1 / l1;
        }
        if (i2 > 0)
        {
            statisticchartdata.sleepValue = j1 / i2;
            statisticchartdata.sleepDeepValue = k1 / i2;
        }
        return statisticchartdata;
    }

    protected abstract ShareData a(SportDay sportday, int i1);

    protected abstract String a(SportDay sportday);

    protected void a()
    {
        a = 0;
        b = 0;
        o = 0;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        j = 0;
        k = 0;
        l = 0;
        m = 0;
        n = 0;
        StatisticFragment.a(p, null);
        StatisticFragment.c(p, 0);
    }

    protected void a(int i1, ShareData sharedata, SportDay sportday)
    {
        int j1;
        sharedata.setType(2);
        j1 = 0x7f0d0164;
        i1;
        JVM INSTR lookupswitch 3: default 44
    //                   1: 230
    //                   16: 238
    //                   256: 250;
           goto _L1 _L2 _L3 _L4
_L1:
        int k1 = g / n;
        sharedata.content = (new StringBuilder()).append(k1).append("").toString();
        sharedata.time = StatisticFragment.w(p).formatStringDay();
        int l1 = h / n;
        int i2 = i / n;
        String s = ChartData.formatTime(j / n);
        String s1 = ChartData.formatTime(k / n);
        StatisticFragment statisticfragment = p;
        Object aobj[] = new Object[6];
        aobj[0] = Integer.valueOf(l1 / 60);
        aobj[1] = Integer.valueOf(l1 % 60);
        aobj[2] = Integer.valueOf(i2 / 60);
        aobj[3] = Integer.valueOf(i2 % 60);
        aobj[4] = s;
        aobj[5] = s1;
        sharedata.description = statisticfragment.getString(j1, aobj);
        return;
_L2:
        sharedata.setType(2);
        continue; /* Loop/switch isn't completed */
_L3:
        sharedata.setType(3);
        j1 = 0x7f0d0165;
        continue; /* Loop/switch isn't completed */
_L4:
        sharedata.setType(4);
        j1 = 0x7f0d0165;
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void a(View view)
    {
        TextView textview = (TextView)view.findViewById(0x7f0a00bc);
        TextView textview1 = (TextView)view.findViewById(0x7f0a00bd);
        TextView textview2 = (TextView)view.findViewById(0x7f0a00be);
        TextView textview3 = (TextView)view.findViewById(0x7f0a00c1);
        TextView textview4 = (TextView)view.findViewById(0x7f0a00c4);
        TextView textview5 = (TextView)view.findViewById(0x7f0a00c5);
        if (n == 0)
        {
            n = 1;
        }
        textview.setText(ChartData.formatTimeLength(p.getActivity(), g / n, 14));
        textview1.setText(ChartData.formatTimeLength(p.getActivity(), h / n, 14));
        textview2.setText(ChartData.formatTimeLength(p.getActivity(), i / n, 14));
        int i1 = j / n;
        if (i1 < 0)
        {
            i1 += 1440;
        }
        textview3.setText(ChartData.formatTime(i1));
        int j1 = k / n;
        if (j1 < 0)
        {
            j1 += 1440;
        }
        textview4.setText(ChartData.formatTime(j1));
        textview5.setText(ChartData.formatTimeLength(p.getActivity(), l / n, 14));
    }

    protected void a(cn.com.smartdevices.bracelet.model.DaySportData.Summary summary)
    {
        a = a + summary.getSteps();
        b = b + summary.getStepDistance();
        c = c + summary.getStepCalorie();
        d = d + summary.getStepActiveTime();
        e = e + summary.getStepWalkTime();
        f = f + summary.getStepRunTime();
        o = o + summary.getStepRunDistance();
    }

    protected abstract String b(SportDay sportday);

    protected void b(View view)
    {
        TextView textview = (TextView)view.findViewById(0x7f0a00c7);
        TextView textview1 = (TextView)view.findViewById(0x7f0a00c8);
        TextView textview2 = (TextView)view.findViewById(0x7f0a00ba);
        TextView textview3 = (TextView)view.findViewById(0x7f0a00c9);
        TextView textview4 = (TextView)view.findViewById(0x7f0a00cb);
        TextView textview5 = (TextView)view.findViewById(0x7f0a00cc);
        TextView textview6 = (TextView)view.findViewById(0x7f0a00cd);
        TextView textview7 = (TextView)view.findViewById(0x7f0a0154);
        TextView textview8 = (TextView)view.findViewById(0x7f0a0155);
        TextView textview9 = (TextView)view.findViewById(0x7f0a0156);
        TextView textview10 = (TextView)view.findViewById(0x7f0a0157);
        TextView textview11 = (TextView)view.findViewById(0x7f0a0159);
        TextView textview12 = (TextView)view.findViewById(0x7f0a015a);
        TextView textview13 = (TextView)view.findViewById(0x7f0a015b);
        textview.setText(String.valueOf(a));
        String as[] = ChartData.formatDistance(p.getActivity(), b);
        textview1.setText(as[0]);
        textview2.setText(as[1]);
        textview3.setText(String.valueOf(c));
        textview4.setText(ChartData.formatTimeLength(p.getActivity(), d, 14));
        textview5.setText(ChartData.formatTimeLength(p.getActivity(), e, 14));
        textview6.setText(ChartData.formatTimeLength(p.getActivity(), f, 14));
        if (m == 0)
        {
            m = 1;
        }
        textview7.setText(String.valueOf(a / m));
        String as1[] = ChartData.formatDistance(p.getActivity(), b / m);
        textview8.setText(as1[0]);
        textview9.setText(as1[1]);
        textview10.setText(String.valueOf(c / m));
        textview11.setText(ChartData.formatTimeLength(p.getActivity(), d / m, 14));
        textview12.setText(ChartData.formatTimeLength(p.getActivity(), e / m, 14));
        textview13.setText(ChartData.formatTimeLength(p.getActivity(), f / m, 14));
    }

    protected void b(cn.com.smartdevices.bracelet.model.DaySportData.Summary summary)
    {
        g = g + summary.getSleep();
        h = h + summary.getSleepDeepTime();
        i = i + summary.getSleepShallowTime();
        int i1 = a(summary.getSleepStartTime());
        int j1;
        int k1;
        int l1;
        if (i1 > 720)
        {
            j1 = i1 - 1440;
        } else
        {
            j1 = i1;
        }
        j = j1 + j;
        k1 = a(summary.getSleepRiseTime());
        if (k1 >= i1)
        {
            l1 = k1 - i1;
        } else
        {
            l1 = k1 + (1440 - i1);
        }
        k = j1 + l1 + k;
        l = l + summary.getSleepWakeTime();
    }

    protected abstract boolean b(int i1);

    protected abstract void c(int i1);

    protected void c(SportDay sportday)
    {
        cn.com.smartdevices.bracelet.model.DaySportData.Summary summary = (cn.com.smartdevices.bracelet.model.DaySportData.Summary)StatisticFragment.t(p).get(sportday.getKey());
        if (summary != null && !summary.isEmpty())
        {
            if (summary.getSteps() > 0)
            {
                a(summary);
                m = 1 + m;
            }
            if (summary.getSleep() > 0)
            {
                b(summary);
                n = 1 + n;
            }
            if (StatisticFragment.u(p) == null)
            {
                StatisticFragment.a(p, sportday);
                StatisticFragment.c(p, summary.getSteps());
            } else
            if (StatisticFragment.v(p) < summary.getSteps())
            {
                StatisticFragment.c(p, summary.getSteps());
                StatisticFragment.a(p, sportday);
                Debug.i("Statistic.Main", (new StringBuilder()).append("find a bigger steps: ").append(StatisticFragment.v(p)).toString());
                return;
            }
        }
    }
}
