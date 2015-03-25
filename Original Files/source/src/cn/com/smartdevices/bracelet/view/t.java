// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            RoundProgressBar

class t
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final RoundProgressBar a;

    t(RoundProgressBar roundprogressbar)
    {
        a = roundprogressbar;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        RoundProgressBar.b(a, (int)f);
        a.postInvalidate();
    }
}
