// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            DynamicView

class m
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final DynamicView a;

    m(DynamicView dynamicview)
    {
        a = dynamicview;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        DynamicView.e(a).setRotationY(-90F + (90F * f) / 100F);
        float f1 = 300F - (300F * f) / 100F;
        DynamicView.e(a).setTranslationY(f1);
        if (f < 50F)
        {
            float f3 = (f * 0.5F) / 100F;
            DynamicView.e(a).setAlpha(f3);
            return;
        } else
        {
            float f2 = f / 100F;
            DynamicView.e(a).setAlpha(f2);
            return;
        }
    }
}
