// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import cn.com.smartdevices.bracelet.chart.DynamicPieChartView;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            DynamicView

class k
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final DynamicView a;

    k(DynamicView dynamicview)
    {
        a = dynamicview;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        DynamicView.d(a).setRotationY(f);
    }
}
