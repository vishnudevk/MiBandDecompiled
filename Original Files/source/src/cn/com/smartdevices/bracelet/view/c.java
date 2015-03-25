// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.widget.ImageView;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            DynamicView

class c
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final DynamicView a;

    c(DynamicView dynamicview)
    {
        a = dynamicview;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        DynamicView.h(a).setTranslationX((400F * f) / 100F);
        DynamicView.h(a).setTranslationY((-200F * f) / 100F);
        DynamicView.h(a).setScaleX(1.0F - (0.7F * f) / 100F);
        DynamicView.h(a).setScaleY(1.0F - (0.2F * f) / 100F);
        if (f <= 50F)
        {
            DynamicView.h(a).setAlpha(1.0F - (1.0F * f) / 50F);
            DynamicView.i(a).setAlpha(1.0F - (1.0F * f) / 50F);
        }
        DynamicView.i(a).setTranslationX((450F * f) / 100F);
        DynamicView.i(a).setTranslationY((f * 400F) / 100F);
    }
}
