// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.compat;

import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.compat:
//            d

class c
{

    c()
    {
    }

    static void a(View view)
    {
        view.postDelayed(new d(view), ValueAnimator.getFrameDelay());
    }

    static void a(View view, float f)
    {
        view.setAlpha(f);
    }

    static void a(View view, Runnable runnable)
    {
        view.postDelayed(runnable, ValueAnimator.getFrameDelay());
    }
}
