// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            LinePieChartView, LinePieChart

class l
    implements android.animation.Animator.AnimatorListener
{

    final LinePieChartView a;

    l(LinePieChartView linepiechartview)
    {
        a = linepiechartview;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        ((LinePieChart)LinePieChartView.c(a)).dismissLoading();
        ((LinePieChart)LinePieChartView.d(a)).rotate(0.0F);
        a.postInvalidateOnAnimation();
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        ((LinePieChart)LinePieChartView.a(a)).showLoading();
        ((LinePieChart)LinePieChartView.b(a)).rotate(0.0F);
        a.postInvalidateOnAnimation();
    }
}
