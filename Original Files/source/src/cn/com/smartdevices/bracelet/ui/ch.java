// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.util.SparseArray;
import android.view.View;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            cf, StatisticFragment

class ch extends cf
{

    final StatisticFragment q;
    private final String r;
    private final String s;
    private String t;
    private String u;
    private String v;
    private String w;

    public ch(StatisticFragment statisticfragment)
    {
        q = statisticfragment;
        super(statisticfragment, null);
        t = statisticfragment.getString(0x7f0d0059);
        u = statisticfragment.getString(0x7f0d0052);
        v = statisticfragment.getString(0x7f0d0054);
        w = statisticfragment.getString(0x7f0d005c);
        r = statisticfragment.getString(0x7f0d0056);
        s = statisticfragment.getString(0x7f0d0051);
    }

    protected cn.com.smartdevices.bracelet.chart.StatisticChartView.StatisticChartData a(int i)
    {
        SportDay sportday = StatisticFragment.x(q).addMonth(i);
        Debug.i("Statistic.Main", (new StringBuilder()).append("Load Month : ").append(a(sportday)).toString());
        SportDay sportday1 = sportday.getMonthStartDay();
        SportDay sportday2 = sportday.getMonthEndDay();
        Debug.i("Statistic.Main", (new StringBuilder()).append(sportday1).append("~").append(sportday2).toString());
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        while (j < sportday2.day) 
        {
            SportDay sportday3 = sportday1.addDay(j);
            Debug.i("Statistic.Main", (new StringBuilder()).append("Load Day : ").append(sportday3).toString());
            String s1 = sportday3.getKey();
            cn.com.smartdevices.bracelet.model.DaySportData.Summary summary;
            if (!StatisticFragment.t(q).containsKey(s1))
            {
                summary = StatisticFragment.y(q).getSummary(sportday3);
                StatisticFragment.t(q).put(s1, summary);
            } else
            {
                summary = (cn.com.smartdevices.bracelet.model.DaySportData.Summary)StatisticFragment.t(q).get(s1);
            }
            if (summary == null)
            {
                continue;
            }
            if (summary.getSteps() > 0)
            {
                k1 += summary.getSteps();
                l++;
            }
            if (summary.getSleep() > 0)
            {
                j1 += summary.getSleep();
                i1 += summary.getSleepDeepTime();
                k++;
            }
            j++;
        }
        cn.com.smartdevices.bracelet.chart.StatisticChartView.StatisticChartData statisticchartdata = a(k1, j1, i1, l, k);
        statisticchartdata.date = b(sportday);
        return statisticchartdata;
    }

    protected ShareData a(SportDay sportday, int i)
    {
        ShareData sharedata = new ShareData();
        SimpleDateFormat simpledateformat = new SimpleDateFormat();
        Date date = new Date();
        String s2;
        SportDay sportday1;
        SportDay sportday2;
        String s5;
        Object aobj[];
        String s6;
        String s7;
        Object aobj1[];
        String s8;
        if (sportday.offsetMonth(StatisticFragment.C(q)) == 0)
        {
            s2 = t;
        } else
        {
            simpledateformat.applyPattern(v);
            date.setMonth(sportday.mon);
            String s1 = simpledateformat.format(date);
            s2 = (new StringBuilder()).append(q.getString(0x7f0d00ce)).append(s1).toString();
        }
        if (i == 16)
        {
            a(StatisticFragment.q(q), sharedata, sportday);
            sharedata.title = (new StringBuilder()).append(s2).append(", ").append(q.getString(0x7f0d0167)).toString();
        } else
        if (i == 1)
        {
            sharedata.setType(6);
            String s3 = StatisticFragment.u(q).formatStringDay();
            String s4 = Utils.getMonthShareTips(q.getActivity(), a, b, c, s3, StatisticFragment.v(q), o);
            sharedata.title = (new StringBuilder()).append(s2).append(", ").append(q.getString(0x7f0d0173)).toString();
            sharedata.content = (new StringBuilder()).append("").append(a).toString();
            sharedata.description = s4;
            sharedata.contentUnit = q.getString(0x7f0d01c4);
        }
        sportday1 = sportday.getMonthStartDay();
        sportday2 = sportday1.addMonth(1).addDay(-1);
        if (sportday.offsetMonth(StatisticFragment.C(q)) == 0)
        {
            sportday2 = StatisticFragment.C(q);
        }
        if (sportday1.before(StatisticFragment.z(q)))
        {
            sportday1 = StatisticFragment.z(q);
        } else
        if (sportday2.after(StatisticFragment.G(q)))
        {
            sportday2 = StatisticFragment.G(q);
        }
        s5 = r;
        aobj = new Object[2];
        aobj[0] = Integer.valueOf(1 + sportday1.mon);
        aobj[1] = Integer.valueOf(sportday1.day);
        s6 = String.format(s5, aobj);
        s7 = r;
        aobj1 = new Object[2];
        aobj1[0] = Integer.valueOf(1 + sportday2.mon);
        aobj1[1] = Integer.valueOf(sportday2.day);
        s8 = String.format(s7, aobj1);
        sharedata.time = String.format(s, new Object[] {
            s6, s8
        });
        return sharedata;
    }

    protected String a(SportDay sportday)
    {
        if (sportday.offsetMonth(StatisticFragment.C(q)) == 0)
        {
            return t;
        }
        if (sportday.offsetMonth(StatisticFragment.C(q)) == -1)
        {
            return u;
        }
        Date date = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat();
        if (1 + sportday.mon == 1)
        {
            date.setYear(sportday.year);
            date.setMonth(sportday.mon);
            simpledateformat.applyPattern(w);
            return simpledateformat.format(date);
        } else
        {
            date.setMonth(sportday.mon);
            simpledateformat.applyPattern(v);
            return simpledateformat.format(date);
        }
    }

    protected String b(SportDay sportday)
    {
        return a(sportday);
    }

    protected boolean b(int i)
    {
        if (i > 0 || i < StatisticFragment.z(q).offsetMonth(StatisticFragment.x(q)))
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
        SportDay sportday;
        SportDay sportday1;
        SportDay sportday2;
        sportday = StatisticFragment.x(q).addMonth(i);
        sportday1 = sportday.getMonthStartDay();
        sportday2 = sportday.getMonthEndDay();
        Debug.i("Statistic.Main", (new StringBuilder()).append(sportday1).append("~").append(sportday2).toString());
        Debug.i("Statistic.Main", (new StringBuilder()).append("To Month : ").append(a(sportday)).toString());
        StatisticFragment.d(q, i);
        if (StatisticFragment.E(q) == 0x7fffffff)
        {
            StatisticFragment.e(q, i);
        }
        if (StatisticFragment.E(q) != i) goto _L2; else goto _L1
_L1:
        StatisticFragment.b(q, StatisticFragment.F(q));
_L4:
        StatisticFragment.c(q, sportday);
        a();
        for (int j = 0; j < sportday2.day; j++)
        {
            SportDay sportday3 = sportday1.addDay(j);
            Debug.i("Statistic.Main", (new StringBuilder()).append("Load Day : ").append(sportday3).toString());
            c(sportday3);
        }

        break; /* Loop/switch isn't completed */
_L2:
        StatisticFragment.b(q, sportday1);
        if (StatisticFragment.w(q).before(StatisticFragment.z(q)))
        {
            StatisticFragment.b(q, StatisticFragment.z(q));
        }
        if (true) goto _L4; else goto _L3
_L3:
        a((View)StatisticFragment.A(q).get(256));
        b((View)StatisticFragment.B(q).get(256));
        return;
    }
}
