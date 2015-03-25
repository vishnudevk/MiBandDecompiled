// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.base;

import android.animation.ValueAnimator;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.base:
//            BaseChartView

class a
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final BaseChartView a;

    a(BaseChartView basechartview)
    {
        a = basechartview;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        a.mAnimFactor = valueanimator.getAnimatedFraction();
        a.postInvalidateOnAnimation();
    }
}
