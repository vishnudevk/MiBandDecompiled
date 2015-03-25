// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.view.View;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.StatisticChartView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            StatisticFragment

class ce
    implements android.animation.Animator.AnimatorListener
{

    final StatisticChartView a;
    final StatisticChartView b;
    final StatisticFragment c;

    ce(StatisticFragment statisticfragment, StatisticChartView statisticchartview, StatisticChartView statisticchartview1)
    {
        c = statisticfragment;
        a = statisticchartview;
        b = statisticchartview1;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        Debug.i("Statistic.Main", (new StringBuilder()).append("OUT VIEW : ").append(b).toString());
        b.setVisibility(4);
        b.setAlpha(1.0F);
        b.setScaleX(1.0F);
        if (StatisticFragment.q(c) != 1)
        {
            StatisticFragment.r(c).setEnabled(true);
        }
        if (StatisticFragment.q(c) != 256)
        {
            StatisticFragment.s(c).setEnabled(true);
        }
        StatisticFragment.o(c).setScrollable(true);
        StatisticFragment.p(c).setScrollable(true);
        StatisticFragment.b(c, false);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        Debug.i("Statistic.Main", (new StringBuilder()).append("IN VIEW : ").append(a).toString());
        a.setVisibility(0);
        a.refresh();
    }
}
