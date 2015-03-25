// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.view.animation.DecelerateInterpolator;
import cn.com.smartdevices.bracelet.chart.StatisticChartView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            StatisticFragment

class ca
    implements android.animation.Animator.AnimatorListener
{

    final long a;
    final StatisticFragment b;

    ca(StatisticFragment statisticfragment, long l)
    {
        b = statisticfragment;
        a = l;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        StatisticFragment.o(b).setMode(StatisticFragment.j(b));
        StatisticFragment.p(b).setMode(StatisticFragment.j(b));
        Animator animator1 = StatisticFragment.b(b).animRefresh();
        animator1.setDuration(a / 2L);
        animator1.setInterpolator(new DecelerateInterpolator(1.5F));
        animator1.start();
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }
}
