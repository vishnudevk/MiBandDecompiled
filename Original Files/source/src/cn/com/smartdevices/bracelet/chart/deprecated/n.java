// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.animation.ValueAnimator;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            DynamicPieChartViewOld, DynamicPieChartOld

class n
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final DynamicPieChartViewOld a;

    n(DynamicPieChartViewOld dynamicpiechartviewold)
    {
        a = dynamicpiechartviewold;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = 360F * ((Float)valueanimator.getAnimatedValue()).floatValue();
        ((DynamicPieChartOld)DynamicPieChartViewOld.e(a)).rotate(f);
        a.postInvalidateOnAnimation();
    }
}
