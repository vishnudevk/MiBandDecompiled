// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.util;

import android.animation.ValueAnimator;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;

final class j
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final TextView a;

    j(TextView textview)
    {
        a = textview;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        String s = (String)valueanimator.getAnimatedValue("Text");
        Debug.i("Chart.AnimUtil", (new StringBuilder()).append("Text : ").append(s).toString());
        a.setText(s);
    }
}
