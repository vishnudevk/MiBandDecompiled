// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.util;

import android.animation.ValueAnimator;
import android.widget.TextView;

final class f
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final TextView a;
    final TextView b;

    f(TextView textview, TextView textview1)
    {
        a = textview;
        b = textview1;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f1 = ((Float)valueanimator.getAnimatedValue()).floatValue();
        float f2 = 0.9F * (1.0F - f1);
        float f3 = 0.5F + f1 * 0.5F;
        a.setAlpha(f2);
        a.setScaleX(f2);
        a.setScaleY(f2);
        b.setAlpha(f3);
        b.setScaleX(f3);
        b.setScaleY(f3);
    }
}
