// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            DynamicPieChartView, DynamicPieChart

class i
    implements android.animation.Animator.AnimatorListener
{

    final DynamicPieChartView a;

    i(DynamicPieChartView dynamicpiechartview)
    {
        a = dynamicpiechartview;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        ((DynamicPieChart)DynamicPieChartView.c(a)).dismissLoading();
        ((DynamicPieChart)DynamicPieChartView.d(a)).rotate(0.0F);
        a.postInvalidateOnAnimation();
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        ((DynamicPieChart)DynamicPieChartView.a(a)).showLoading();
        ((DynamicPieChart)DynamicPieChartView.b(a)).rotate(0.0F);
        a.postInvalidateOnAnimation();
    }
}
