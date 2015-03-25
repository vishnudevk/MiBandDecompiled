// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.animation.Animator;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            DynamicPieChartViewOld, DynamicPieChartOld

class m
    implements android.animation.Animator.AnimatorListener
{

    final DynamicPieChartViewOld a;

    m(DynamicPieChartViewOld dynamicpiechartviewold)
    {
        a = dynamicpiechartviewold;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        ((DynamicPieChartOld)DynamicPieChartViewOld.c(a)).dismissLoading();
        ((DynamicPieChartOld)DynamicPieChartViewOld.d(a)).rotate(0.0F);
        a.postInvalidateOnAnimation();
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        ((DynamicPieChartOld)DynamicPieChartViewOld.a(a)).showLoading();
        ((DynamicPieChartOld)DynamicPieChartViewOld.b(a)).rotate(0.0F);
        a.postInvalidateOnAnimation();
    }
}
