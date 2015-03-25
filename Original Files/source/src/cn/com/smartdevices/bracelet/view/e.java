// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            DynamicView

class e
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final DynamicView a;

    e(DynamicView dynamicview)
    {
        a = dynamicview;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue() / 600F;
        DynamicView.k(a).setRotationY(180F * f);
        DynamicView.e(a).setRotationY(-180F + 180F * f);
        DynamicView.e(a).setAlpha(f);
        float f1 = 1.0F - 2.0F * f;
        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        DynamicView.k(a).setAlpha(f1);
        DynamicView.e(a).setTranslationY(400F * (1.0F - f));
        DynamicView.k(a).setTranslationY(400F * (1.0F - f));
    }
}
