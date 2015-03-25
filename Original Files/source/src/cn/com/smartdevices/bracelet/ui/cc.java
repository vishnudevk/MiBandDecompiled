// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import cn.com.smartdevices.bracelet.chart.StatisticChartView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            StatisticFragment

class cc
    implements android.animation.Animator.AnimatorListener
{

    final StatisticFragment a;

    cc(StatisticFragment statisticfragment)
    {
        a = statisticfragment;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        StatisticFragment.o(a).setScrollable(true);
        StatisticFragment.p(a).setScrollable(true);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }
}
