// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import cn.com.smartdevices.bracelet.chart.compat.Compat;

class n
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final DynamicView.FlowBgView a;

    n(DynamicView.FlowBgView flowbgview)
    {
        a = flowbgview;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        float f1 = 1.0F - 0.1948262F;
        int i = (int)(DynamicView.FlowBgView.a(a) * (0.1948262F + f * f1));
        DynamicView.FlowBgView.a(a, i);
        Compat.postOnAnimationInvalidate(a);
    }
}
