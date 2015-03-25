// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.util;

import android.animation.ValueAnimator;
import android.widget.TextView;

final class h
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final TextView a;

    h(TextView textview)
    {
        a = textview;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        CharSequence charsequence = (CharSequence)valueanimator.getAnimatedValue("Text");
        a.setText(charsequence);
    }
}
