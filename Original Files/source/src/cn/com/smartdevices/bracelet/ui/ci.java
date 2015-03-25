// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            cf, StatisticFragment

class ci extends cf
{

    final StatisticFragment q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;

    public ci(StatisticFragment statisticfragment)
    {
        q = statisticfragment;
        super(statisticfragment, null);
        r = statisticfragment.getString(0x7f0d005a);
        s = statisticfragment.getString(0x7f0d0053);
        t = statisticfragment.getString(0x7f0d0050);
        u = statisticfragment.getString(0x7f0d0051);
        v = statisticfragment.getString(0x7f0d0055);
        w = statisticfragment.getString(0x7f0d005d);
        x = statisticfragment.getString(0x7f0d0056);
    }

    protected cn.com.smartdevices.bracelet.chart.StatisticChartView.StatisticChartData a(int i)
    {
        SportDay sportday = StatisticFragment.x(q).addWeek(i);
        Debug.i("Statistic.Main", (new StringBuilder()).append("Load Week : ").append(a(sportday)).toString());
        SportDay sportday1 = sportday.getWeekStartDay();
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        while (j < 7) 
        {
            SportDay sportday2 = sportday1.addDay(j);
            Debug.i("Statistic.Main", (new StringBuilder()).append("Load Day : ").append(sportday2).toString());
            String s1 = sportday2.getKey();
            cn.com.smartdevices.bracelet.model.DaySportData.Summary summary;
            if (!StatisticFragment.t(q).containsKey(s1))
            {
                summary = StatisticFragment.y(q).getSummary(sportday2);
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
        SportDay sportday1;
        SportDay sportday2;
        String s3;
        Object aobj[];
        String s4;
        String s5;
        Object aobj1[];
        String s6;
        if (i == 16)
        {
            a(StatisticFragment.q(q), sharedata, sportday);
            String s7 = q.getString(0x7f0d01ed);
            if (sportday.offsetWeek(StatisticFragment.C(q)) == 0)
            {
                s7 = (new StringBuilder()).append(r).append(", ").toString();
            }
            sharedata.title = (new StringBuilder()).append(s7).append(q.getString(0x7f0d0167)).toString();
        } else
        if (i == 1)
        {
            sharedata.setType(7);
            String s1 = q.getString(0x7f0d0120);
            if (sportday.offsetWeek(StatisticFragment.C(q)) == 0)
            {
                s1 = (new StringBuilder()).append(r).append(", ").toString();
            }
            sharedata.title = (new StringBuilder()).append(s1).append(q.getString(0x7f0d0173)).toString();
            sharedata.content = (new StringBuilder()).append("").append(a).toString();
            String s2 = q.getResources().getStringArray(0x7f07000d)[StatisticFragment.u(q).getWeek()];
            sharedata.description = Utils.getWeekShareTips(q.getActivity(), b, c, s2, StatisticFragment.v(q), o);
            sharedata.contentUnit = q.getString(0x7f0d01c4);
        }
        sportday1 = sportday.getWeekStartDay();
        sportday2 = sportday1.addDay(6);
        if (sportday.offsetWeek(StatisticFragment.C(q)) == 0)
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
        s3 = x;
        aobj = new Object[2];
        aobj[0] = Integer.valueOf(1 + sportday1.mon);
        aobj[1] = Integer.valueOf(sportday1.day);
        s4 = String.format(s3, aobj);
        s5 = x;
        aobj1 = new Object[2];
        aobj1[0] = Integer.valueOf(1 + sportday2.mon);
        aobj1[1] = Integer.valueOf(sportday2.day);
        s6 = String.format(s5, aobj1);
        sharedata.time = String.format(u, new Object[] {
            s4, s6
        });
        return sharedata;
    }

    protected String a(SportDay sportday)
    {
        if (sportday.offsetWeek(StatisticFragment.C(q)) == 0)
        {
            return r;
        }
        if (sportday.offsetWeek(StatisticFragment.C(q)) == -1)
        {
            return s;
        }
        SportDay sportday1 = sportday.getWeekStartDay();
        SportDay sportday2 = sportday1.addDay(6);
        Date date;
        SimpleDateFormat simpledateformat;
        SimpleDateFormat simpledateformat1;
        String s1;
        String s2;
        if (sportday1.before(StatisticFragment.z(q)))
        {
            sportday1 = StatisticFragment.z(q);
        } else
        if (sportday2.after(StatisticFragment.G(q)))
        {
            sportday2 = StatisticFragment.G(q);
        }
        date = new Date();
        simpledateformat = new SimpleDateFormat(v);
        simpledateformat1 = new SimpleDateFormat(w);
        if (1 + sportday1.mon == 1 && sportday1.calendar.get(3) == 1)
        {
            date.setYear(-1900 + sportday1.year);
            date.setMonth(sportday1.mon);
            date.setDate(sportday1.day);
            s1 = simpledateformat1.format(date);
        } else
        {
            date.setMonth(sportday1.mon);
            date.setDate(sportday1.day);
            s1 = simpledateformat.format(date);
        }
        if (1 + sportday2.mon == 1 && sportday2.calendar.get(3) == 1)
        {
            date.setYear(-1900 + sportday2.year);
            date.setMonth(sportday2.mon);
            date.setDate(sportday2.day);
            s2 = simpledateformat1.format(date);
        } else
        {
            date.setMonth(sportday2.mon);
            date.setDate(sportday2.day);
            s2 = simpledateformat.format(date);
        }
        return String.format(t, new Object[] {
            s1, s2
        });
    }

    protected String b(SportDay sportday)
    {
        SportDay sportday1;
        SportDay sportday2;
        if (sportday.offsetWeek(StatisticFragment.C(q)) == 0)
        {
            return r;
        }
        if (sportday.offsetWeek(StatisticFragment.C(q)) == -1)
        {
            return s;
        }
        sportday1 = sportday.getWeekStartDay();
        sportday2 = sportday1.addDay(6);
        if (!sportday1.before(StatisticFragment.z(q))) goto _L2; else goto _L1
_L1:
        sportday1 = StatisticFragment.z(q);
_L4:
        String s1 = x;
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(1 + sportday1.mon);
        aobj[1] = Integer.valueOf(sportday1.day);
        String s2 = String.format(s1, aobj);
        String s3 = x;
        Object aobj1[] = new Object[2];
        aobj1[0] = Integer.valueOf(1 + sportday2.mon);
        aobj1[1] = Integer.valueOf(sportday2.day);
        String s4 = String.format(s3, aobj1);
        return String.format(u, new Object[] {
            s2, s4
        });
_L2:
        if (sportday2.after(StatisticFragment.G(q)))
        {
            sportday2 = StatisticFragment.G(q);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected boolean b(int i)
    {
        if (i > 0 || i < StatisticFragment.z(q).offsetWeek(StatisticFragment.x(q)))
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
        sportday = StatisticFragment.x(q).addWeek(i);
        sportday1 = sportday.getWeekStartDay();
        Debug.i("Statistic.Main", (new StringBuilder()).append("To Week : ").append(a(sportday)).toString());
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
        for (int j = 0; j < 7; j++)
        {
            SportDay sportday2 = sportday1.addDay(j);
            Debug.i("Statistic.Main", (new StringBuilder()).append("Load Day : ").append(sportday2).toString());
            c(sportday2);
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
        a((View)StatisticFragment.A(q).get(16));
        b((View)StatisticFragment.B(q).get(16));
        return;
    }
}
