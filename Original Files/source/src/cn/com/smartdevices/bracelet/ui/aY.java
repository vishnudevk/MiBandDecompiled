// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            MainUIActivity

class aY
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final MainUIActivity a;

    aY(MainUIActivity mainuiactivity)
    {
        a = mainuiactivity;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        MainUIActivity.e(a).setScaleX(f);
        MainUIActivity.e(a).setScaleY(f);
        MainUIActivity.e(a).setAlpha(f);
    }
}
