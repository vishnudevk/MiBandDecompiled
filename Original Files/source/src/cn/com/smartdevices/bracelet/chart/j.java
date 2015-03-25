// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.animation.ValueAnimator;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            DynamicPieChartView, DynamicPieChart

class j
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final DynamicPieChartView a;

    j(DynamicPieChartView dynamicpiechartview)
    {
        a = dynamicpiechartview;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        ((DynamicPieChart)DynamicPieChartView.e(a)).rotate(f);
        a.postInvalidateOnAnimation();
    }
}
