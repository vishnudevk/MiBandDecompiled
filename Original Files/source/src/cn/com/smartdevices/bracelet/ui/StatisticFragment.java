// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.StatisticChartView;
import cn.com.smartdevices.bracelet.chart.data.AsyncChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.SportDay;
import de.greenrobot.event.EventBus;
import java.util.HashMap;
import java.util.Locale;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            ca, cb, cc, cd, 
//            cf, SystemBarTintActivity, ce, cg, 
//            ci, ch, bZ, ShareActivity, 
//            BaseSCActivity

public class StatisticFragment extends Fragment
    implements android.view.View.OnClickListener
{

    private static final String a = "Statistic.Main";
    private static final int b = 1;
    private static final int c = 16;
    private static final int d = 256;
    private static final int e = 11;
    private static final int f = 7;
    private static final int g = 5;
    private boolean A;
    private String B;
    private String C;
    private HashMap D;
    private View E;
    private TextView F;
    private TextView G;
    private View H;
    private StatisticChartView I;
    private StatisticChartView J;
    private StatisticChartView K;
    private StatisticChartView L;
    private ImageButton M;
    private View N;
    private View O;
    private SparseArray P;
    private SparseArray Q;
    private View R;
    private View S;
    private int T;
    private int U;
    private Animator V;
    private Animator W;
    private boolean X;
    private boolean Y;
    private SportDay Z;
    private int aa;
    private boolean ab;
    private int h;
    private int i;
    private DataManager j;
    private SportDay k;
    private SportDay l;
    private SportDay m;
    private SportDay n;
    private SportDay o;
    private SportDay p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem v;
    private cf w;
    private SparseArray x;
    private cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback y;
    private SparseArray z;

    public StatisticFragment()
    {
    }

    static SparseArray A(StatisticFragment statisticfragment)
    {
        return statisticfragment.P;
    }

    static SparseArray B(StatisticFragment statisticfragment)
    {
        return statisticfragment.Q;
    }

    static SportDay C(StatisticFragment statisticfragment)
    {
        return statisticfragment.k;
    }

    static boolean D(StatisticFragment statisticfragment)
    {
        return statisticfragment.ab;
    }

    static int E(StatisticFragment statisticfragment)
    {
        return statisticfragment.r;
    }

    static SportDay F(StatisticFragment statisticfragment)
    {
        return statisticfragment.p;
    }

    static SportDay G(StatisticFragment statisticfragment)
    {
        return statisticfragment.o;
    }

    static int a(StatisticFragment statisticfragment, int i1)
    {
        statisticfragment.t = i1;
        return i1;
    }

    private Animator a(int i1, int j1, long l1)
    {
        Animator animator = K.animRefreshTo(l1 / 2L, 0.0F, 0.0F);
        animator.addListener(new ca(this, l1));
        animator.setInterpolator(new AccelerateInterpolator(1.5F));
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.setFirstAnim(animator);
        cb cb1 = new cb(this);
        View aview[] = new View[2];
        aview[0] = E;
        aview[1] = (View)K.getParent();
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(AnimUtil.animColorTrans(i1, j1, cb1, aview), 2L * (l1 / 3L));
        android.animation.AnimatorSet animatorset = cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.build();
        animatorset.addListener(new cc(this));
        return animatorset;
    }

    private Animator a(StatisticChartView statisticchartview, StatisticChartView statisticchartview1, int i1, int j1, int k1, int l1, int i2)
    {
        Animator animator = AnimUtil.animScaleX(statisticchartview, (float)i1 / (float)j1, 1.0F);
        Animator animator1 = AnimUtil.animScaleX(statisticchartview1, 1.0F, (float)j1 / (float)i1);
        Animator animator2 = AnimUtil.animFade(statisticchartview1, 1.0F, 0.0F);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.setFirstAnim(animator, i2);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(animator1, i2);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(animator2, i2);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(statisticchartview.animRefresh(i2, k1, l1));
        android.animation.AnimatorSet animatorset = cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.build();
        animatorset.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorset.addListener(new cd(this, statisticchartview, statisticchartview1));
        return animatorset;
    }

    static Animator a(StatisticFragment statisticfragment, Animator animator)
    {
        statisticfragment.W = animator;
        return animator;
    }

    static Animator a(StatisticFragment statisticfragment, StatisticChartView statisticchartview, StatisticChartView statisticchartview1, int i1, int j1, int k1, int l1, int i2)
    {
        return statisticfragment.a(statisticchartview, statisticchartview1, i1, j1, k1, l1, i2);
    }

    static cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem a(StatisticFragment statisticfragment, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        statisticfragment.v = baritem;
        return baritem;
    }

    static SportDay a(StatisticFragment statisticfragment, SportDay sportday)
    {
        statisticfragment.Z = sportday;
        return sportday;
    }

    static cf a(StatisticFragment statisticfragment)
    {
        return statisticfragment.w;
    }

    private void a()
    {
        AnimUtil.dismissChildren((ViewGroup)P.get(1));
        AnimUtil.dismissChildren((ViewGroup)P.get(16));
        AnimUtil.dismissChildren((ViewGroup)P.get(256));
        AnimUtil.dismissChildren((ViewGroup)Q.get(1));
        AnimUtil.dismissChildren((ViewGroup)Q.get(16));
        AnimUtil.dismissChildren((ViewGroup)Q.get(256));
    }

    private void a(int i1, int j1, int k1, int l1, boolean flag)
    {
        View view;
        View view1;
        if (i1 == 16)
        {
            view = (View)P.get(k1);
        } else
        if (i1 == 1)
        {
            view = (View)Q.get(k1);
        } else
        {
            view = null;
        }
        if (j1 == 16)
        {
            view1 = (View)P.get(l1);
        } else
        {
            view1 = null;
            if (j1 == 1)
            {
                view1 = (View)Q.get(l1);
            }
        }
        l1;
        JVM INSTR lookupswitch 3: default 76
    //                   1: 175
    //                   16: 210
    //                   256: 245;
           goto _L1 _L2 _L3 _L4
_L1:
        w = (cf)x.get(l1);
        S = view;
        R = view1;
        a(K, y, l1);
        a(K, l1);
        return;
_L2:
        O.setEnabled(true);
        N.setEnabled(false);
        UmengAnalytics.event(getActivity(), "ViewStatistic", "Level", "StatisticLevelDaily");
        continue; /* Loop/switch isn't completed */
_L3:
        O.setEnabled(true);
        N.setEnabled(true);
        UmengAnalytics.event(getActivity(), "ViewStatistic", "Level", "StatisticLevelWeekly");
        continue; /* Loop/switch isn't completed */
_L4:
        O.setEnabled(false);
        N.setEnabled(true);
        UmengAnalytics.event(getActivity(), "ViewStatistic", "Level", "StatisticLevelMonthly");
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void a(int i1, int j1, boolean flag)
    {
        a(h, h, i1, j1, flag);
    }

    private void a(int i1, cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback loadcallback, SparseArray sparsearray)
    {
        AsyncChartDataLoader asyncchartdataloader = new AsyncChartDataLoader();
        asyncchartdataloader.setLoadCallback(loadcallback);
        sparsearray.put(i1, asyncchartdataloader);
    }

    private void a(int i1, boolean flag)
    {
        int j1;
        int k1;
        if (i1 == 16)
        {
            M.setImageResource(0x7f020027);
            int j2 = U;
            int k2 = T;
            UmengAnalytics.event(getActivity(), "ViewStatistic", "Mode", "ModeSleep");
            j1 = j2;
            k1 = k2;
        } else
        if (i1 == 1)
        {
            M.setImageResource(0x7f020024);
            int l1 = T;
            int i2 = U;
            UmengAnalytics.event(getActivity(), "ViewStatistic", "Mode", "ModeStep");
            j1 = l1;
            k1 = i2;
        } else
        {
            j1 = 0;
            k1 = 0;
        }
        if (flag)
        {
            E.setBackgroundColor(k1);
            ((View)K.getParent()).setBackgroundColor(k1);
            ((SystemBarTintActivity)getActivity()).applyStatusBarTint(k1);
            I.setMode(i1);
            J.setMode(i1);
        } else
        {
            V = a(j1, k1, 650L);
            V.start();
        }
        a(m);
    }

    private void a(View view)
    {
        E = view.findViewById(0x7f0a0033);
        F = (TextView)view.findViewById(0x7f0a0034);
        F.setOnClickListener(this);
        G = (TextView)view.findViewById(0x7f0a00a9);
        H = view.findViewById(0x7f0a00aa);
        H.setOnClickListener(this);
        I = (StatisticChartView)view.findViewById(0x7f0a0124);
        J = (StatisticChartView)view.findViewById(0x7f0a0125);
        M = (ImageButton)view.findViewById(0x7f0a00ac);
        M.setOnClickListener(this);
        O = view.findViewById(0x7f0a012c);
        N = view.findViewById(0x7f0a012d);
        O.setOnClickListener(this);
        N.setOnClickListener(this);
        View view1 = view.findViewById(0x7f0a0126);
        View view2 = view.findViewById(0x7f0a0127);
        View view3 = view.findViewById(0x7f0a0128);
        View view4 = view.findViewById(0x7f0a0129);
        View view5 = view.findViewById(0x7f0a012a);
        View view6 = view.findViewById(0x7f0a012b);
        P = new SparseArray(3);
        Q = new SparseArray(3);
        P.put(1, view1);
        P.put(16, view2);
        P.put(256, view3);
        Q.put(1, view4);
        Q.put(16, view5);
        Q.put(256, view6);
        a();
    }

    private void a(StatisticChartView statisticchartview, int i1)
    {
        switch (i1)
        {
        default:
            return;

        case 1: // '\001'
            statisticchartview.updateBarItemCount(11);
            return;

        case 16: // '\020'
            statisticchartview.updateBarItemCount(7);
            return;

        case 256: 
            statisticchartview.updateBarItemCount(5);
            break;
        }
    }

    private void a(StatisticChartView statisticchartview, cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback loadcallback, int i1)
    {
        ChartDataLoader chartdataloader = (ChartDataLoader)z.get(i1);
        chartdataloader.setLoadCallback(loadcallback);
        statisticchartview.setDataLoader(chartdataloader);
    }

    private void a(SportDay sportday)
    {
        if (h != 16) goto _L2; else goto _L1
_L1:
        if (w == null) goto _L4; else goto _L3
_L3:
        String s1;
        String s3 = B;
        Object aobj1[] = new Object[1];
        aobj1[0] = w.a(sportday);
        s1 = String.format(s3, aobj1);
_L6:
        String s2;
        Object aobj[];
        if (i == 1 && sportday.equals(k) || i == 16 && sportday.offsetWeek(k) == 0 || i == 256 && sportday.offsetMonth(k) == 0)
        {
            ((View)G.getParent()).setVisibility(0);
        } else
        {
            ((View)G.getParent()).setVisibility(8);
        }
        a(s1);
        return;
_L2:
        if (h == 1 && w != null)
        {
            s2 = C;
            aobj = new Object[1];
            aobj[0] = w.a(sportday);
            s1 = String.format(s2, aobj);
            continue; /* Loop/switch isn't completed */
        }
_L4:
        s1 = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a(BaseSCActivity.ConnStatus connstatus)
    {
        Log.d("Statistic.Main", (new StringBuilder()).append("Current Sync Status : ").append(connstatus).toString());
        TextView textview;
        switch (connstatus.a)
        {
        default:
            G.setText(Utils.getSyncTime(getActivity(), 0x7f0d008c));
            return;

        case 9: // '\t'
            TextView textview1 = G;
            Object aobj1[] = new Object[1];
            aobj1[0] = Integer.valueOf(0);
            textview1.setText(getString(0x7f0d008b, aobj1));
            return;

        case 10: // '\n'
            textview = G;
            break;
        }
        Object aobj[] = new Object[1];
        aobj[0] = (Integer)connstatus.b;
        textview.setText(getString(0x7f0d008b, aobj));
    }

    private void a(String s1)
    {
        F.setText(s1);
    }

    static boolean a(StatisticFragment statisticfragment, boolean flag)
    {
        statisticfragment.A = flag;
        return flag;
    }

    static int b(StatisticFragment statisticfragment, int i1)
    {
        statisticfragment.u = i1;
        return i1;
    }

    private Animator b(StatisticChartView statisticchartview, StatisticChartView statisticchartview1, int i1, int j1, int k1, int l1, int i2)
    {
        float f1 = (float)i1 / (float)j1;
        Animator animator = AnimUtil.animFade(statisticchartview, 0.0F, 1.0F);
        Animator animator1 = AnimUtil.animScaleX(statisticchartview, f1, 1.0F);
        Animator animator2 = AnimUtil.animScaleX(statisticchartview1, 1.0F, (float)j1 / (float)i1);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.setFirstAnim(animator1, i2);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(animator, i2);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(animator2, i2);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(statisticchartview1.animRefreshTo(i2, k1, l1));
        android.animation.AnimatorSet animatorset = cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.build();
        animatorset.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorset.addListener(new ce(this, statisticchartview, statisticchartview1));
        return animatorset;
    }

    static Animator b(StatisticFragment statisticfragment, StatisticChartView statisticchartview, StatisticChartView statisticchartview1, int i1, int j1, int k1, int l1, int i2)
    {
        return statisticfragment.b(statisticchartview, statisticchartview1, i1, j1, k1, l1, i2);
    }

    static StatisticChartView b(StatisticFragment statisticfragment)
    {
        return statisticfragment.K;
    }

    static SportDay b(StatisticFragment statisticfragment, SportDay sportday)
    {
        statisticfragment.m = sportday;
        return sportday;
    }

    private void b()
    {
        y = c();
        z = new SparseArray(3);
        a(1, y, z);
        a(16, y, z);
        a(256, y, z);
        int i1 = Keeper.readPersonInfo().getDaySportGoalSteps();
        I.setScrollable(true);
        I.setStepGoal(i1);
        J.setScrollable(true);
        J.setStepGoal(i1);
        I.attach();
        J.attach();
        J.setVisibility(4);
        K = I;
        x = new SparseArray(3);
        x.put(1, new cg(this));
        x.put(16, new ci(this));
        x.put(256, new ch(this));
    }

    private void b(int i1, boolean flag)
    {
        a(h, h, i1, i1, flag);
    }

    static boolean b(StatisticFragment statisticfragment, boolean flag)
    {
        statisticfragment.X = flag;
        return flag;
    }

    static int c(StatisticFragment statisticfragment, int i1)
    {
        statisticfragment.aa = i1;
        return i1;
    }

    private cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback c()
    {
        return new bZ(this);
    }

    static void c(StatisticFragment statisticfragment, SportDay sportday)
    {
        statisticfragment.a(sportday);
    }

    static boolean c(StatisticFragment statisticfragment)
    {
        return statisticfragment.X;
    }

    static int d(StatisticFragment statisticfragment, int i1)
    {
        statisticfragment.q = i1;
        return i1;
    }

    static View d(StatisticFragment statisticfragment)
    {
        return statisticfragment.S;
    }

    private void d()
    {
        ShareData sharedata = e();
        Intent intent = new Intent();
        intent.setClass(getActivity(), cn/com/smartdevices/bracelet/ui/ShareActivity);
        intent.putExtra("share_data", sharedata);
        getActivity().startActivity(intent);
        UmengAnalytics.event(getActivity(), "ShareFrom", "ShareFromStatistic");
    }

    static int e(StatisticFragment statisticfragment, int i1)
    {
        statisticfragment.r = i1;
        return i1;
    }

    static View e(StatisticFragment statisticfragment)
    {
        return statisticfragment.R;
    }

    private ShareData e()
    {
        return w.a(m, h);
    }

    private void f()
    {
        int i1;
        while (V != null && V.isStarted() || W != null && W.isStarted()) 
        {
            return;
        }
        I.setScrollable(false);
        J.setScrollable(false);
        i1 = h;
        if (i1 != 16) goto _L2; else goto _L1
_L1:
        h = 1;
_L4:
        a(h, A);
        a(i1, h, i, i, A);
        AnimUtil.animInfoSwitch((ViewGroup)S, (ViewGroup)R);
        return;
_L2:
        if (i1 == 1)
        {
            h = 16;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean f(StatisticFragment statisticfragment)
    {
        return statisticfragment.Y;
    }

    static StatisticChartView g(StatisticFragment statisticfragment)
    {
        return statisticfragment.L;
    }

    private void g()
    {
        while (W != null && W.isStarted() || V != null && V.isStarted()) 
        {
            return;
        }
        v = K.getBarItem(h, q);
        int i1;
        if (v != null)
        {
            t = (int)v.getRect().height();
            int j1 = v.value;
            int k1 = ((cn.com.smartdevices.bracelet.chart.StatisticChart.StatisticBarItem)v).value1;
            u = (int)((float)t * ((float)k1 / (float)j1));
        } else
        {
            t = 0;
            u = 0;
        }
        Debug.i("Statistic.Main", (new StringBuilder()).append("BarItem Height : ").append(t).toString());
        i1 = i;
        if (i != 256) goto _L2; else goto _L1
_L1:
        i = 16;
        s = m.offsetWeek(l);
        Debug.i("Statistic.Main", (new StringBuilder()).append("Offset Week From Month : ").append(s).toString());
        K = J;
        L = I;
_L4:
        if (q != r)
        {
            p = m;
        }
        r = 0x7fffffff;
        a(i1, i, A);
        I.setScrollable(false);
        J.setScrollable(false);
        K.clearData();
        K.loadStatisticData(s);
        K.offsetTo(s);
        X = true;
        Y = true;
        return;
_L2:
        if (i == 16)
        {
            i = 1;
            s = m.offsetDay(l);
            Debug.i("Statistic.Main", (new StringBuilder()).append("Offset Day : ").append(s).toString());
            K = I;
            L = J;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static int h(StatisticFragment statisticfragment)
    {
        return statisticfragment.t;
    }

    private void h()
    {
        int i1;
        while (W != null && W.isStarted() || V != null && V.isStarted()) 
        {
            return;
        }
        i1 = i;
        if (i != 1) goto _L2; else goto _L1
_L1:
        i = 16;
        s = m.offsetWeek(l);
        Debug.i("Statistic.Main", (new StringBuilder()).append("Offset Week From Day : ").append(s).toString());
        K = J;
        L = I;
_L4:
        q = 0x7fffffff;
        r = 0x7fffffff;
        p = m;
        a(i1, i, A);
        I.setScrollable(false);
        J.setScrollable(false);
        K.clearData();
        K.loadStatisticData(s);
        K.offsetTo(s);
        X = true;
        Y = false;
        return;
_L2:
        if (i == 16)
        {
            i = 256;
            s = m.offsetMonth(l);
            Debug.i("Statistic.Main", (new StringBuilder()).append("Offset Month : ").append(s).toString());
            K = I;
            L = J;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static int i(StatisticFragment statisticfragment)
    {
        return statisticfragment.u;
    }

    private void i()
    {
        Debug.i("Statistic.Main", (new StringBuilder()).append("Current Index : ").append(q).append(" Last Index : ").append(r).toString());
        Debug.i("Statistic.Main", (new StringBuilder()).append("Current Day : ").append(m).append(" Last Day : ").append(p).toString());
    }

    static int j(StatisticFragment statisticfragment)
    {
        return statisticfragment.h;
    }

    static int k(StatisticFragment statisticfragment)
    {
        return statisticfragment.s;
    }

    static cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem l(StatisticFragment statisticfragment)
    {
        return statisticfragment.v;
    }

    static Animator m(StatisticFragment statisticfragment)
    {
        return statisticfragment.W;
    }

    static boolean n(StatisticFragment statisticfragment)
    {
        return statisticfragment.A;
    }

    static StatisticChartView o(StatisticFragment statisticfragment)
    {
        return statisticfragment.I;
    }

    static StatisticChartView p(StatisticFragment statisticfragment)
    {
        return statisticfragment.J;
    }

    static int q(StatisticFragment statisticfragment)
    {
        return statisticfragment.i;
    }

    static View r(StatisticFragment statisticfragment)
    {
        return statisticfragment.N;
    }

    static View s(StatisticFragment statisticfragment)
    {
        return statisticfragment.O;
    }

    static HashMap t(StatisticFragment statisticfragment)
    {
        return statisticfragment.D;
    }

    static SportDay u(StatisticFragment statisticfragment)
    {
        return statisticfragment.Z;
    }

    static int v(StatisticFragment statisticfragment)
    {
        return statisticfragment.aa;
    }

    static SportDay w(StatisticFragment statisticfragment)
    {
        return statisticfragment.m;
    }

    static SportDay x(StatisticFragment statisticfragment)
    {
        return statisticfragment.l;
    }

    static DataManager y(StatisticFragment statisticfragment)
    {
        return statisticfragment.j;
    }

    static SportDay z(StatisticFragment statisticfragment)
    {
        return statisticfragment.n;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a(getView());
        b();
        A = true;
        a(h, A);
        b(i, A);
        K.clearData();
        K.loadStatisticData(0);
        EventBus.getDefault().register(this);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361844: 
            getActivity().finish();
            return;

        case 2131361962: 
            d();
            return;

        case 2131361964: 
            f();
            return;

        case 2131362092: 
            h();
            return;

        case 2131362093: 
            g();
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Bundle bundle1 = getArguments();
        if (bundle1 != null)
        {
            h = bundle1.getInt("Mode", 1);
            Debug.i("Statistic.Main", (new StringBuilder()).append("Mode : ").append(h).toString());
        }
        i = 1;
        j = DataManager.getInstance();
        k = j.getToday();
        l = j.getCurDay();
        n = j.getStartDay();
        o = j.getStopDay();
        m = l;
        Debug.i("Statistic.Main", (new StringBuilder()).append("Today : ").append(k).append(" , StartDay : ").append(n).append(" , StopDay : ").append(o).append(" , CurrentDay : ").append(m).toString());
        B = getString(0x7f0d006e);
        C = getString(0x7f0d0071);
        D = new HashMap();
        ab = Locale.getDefault().toString().startsWith(Locale.ENGLISH.toString());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f030048, viewgroup, false);
        Resources resources = getActivity().getResources();
        T = resources.getColor(0x7f09000a);
        U = resources.getColor(0x7f09000b);
        return view;
    }

    public void onDestroy()
    {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onDetach()
    {
        super.onDetach();
        I.detach();
        J.detach();
    }

    public void onEvent(BaseSCActivity.ConnStatus connstatus)
    {
        Debug.i("Statistic.Main", (new StringBuilder()).append("On BLE Status Changed : ").append(connstatus.a).toString());
        if (isVisible())
        {
            a(connstatus);
            if (connstatus.a == 11 && ((Boolean)connstatus.b).booleanValue())
            {
                A = true;
                D.clear();
                ChartDataLoader chartdataloader = K.getDataLoader();
                chartdataloader.cancel();
                chartdataloader.clearData();
                K.clearData();
                K.loadStatisticData(0);
            }
        }
    }

    public void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageStatistic");
    }

    public void onResume()
    {
        super.onResume();
        a(BaseSCActivity.mConnStatus);
        UmengAnalytics.startPage("PageStatistic");
    }
}
