// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            b, LoginActivity

class c
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final b a;

    c(b b1)
    {
        a = b1;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        Float float1 = (Float)valueanimator.getAnimatedValue();
        LoginActivity.e(a.a).setAlpha(float1.floatValue());
        LoginActivity.f(a.a).setAlpha(float1.floatValue());
        LoginActivity.a(a.a).setAlpha(float1.floatValue());
        LoginActivity.b(a.a).setAlpha(float1.floatValue());
        LoginActivity.c(a.a).setAlpha(float1.floatValue());
    }
}
