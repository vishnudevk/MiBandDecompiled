// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            MainUIActivity

class aH
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final MainUIActivity a;

    aH(MainUIActivity mainuiactivity)
    {
        a = mainuiactivity;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = 0.5F + 0.5F * ((Float)valueanimator.getAnimatedValue()).floatValue();
        float f1 = ((Float)valueanimator.getAnimatedValue()).floatValue();
        MainUIActivity.h(a).setScaleX(f);
        MainUIActivity.h(a).setScaleY(f);
        MainUIActivity.i(a).setScaleX(f);
        MainUIActivity.i(a).setScaleY(f);
        MainUIActivity.h(a).setAlpha(f);
        MainUIActivity.i(a).setAlpha(f);
        MainUIActivity.a(a, Boolean.valueOf(false));
        MainUIActivity.j(a).setRotation(360F - f1 * 180F);
    }
}
