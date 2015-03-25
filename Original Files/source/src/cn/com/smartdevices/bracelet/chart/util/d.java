// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;

final class d extends AnimatorListenerAdapter
{

    d()
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        ((View)((ObjectAnimator)animator).getTarget()).setRotationY(0.0F);
    }
}
