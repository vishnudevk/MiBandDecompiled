// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.util;

import android.animation.Animator;
import android.widget.TextView;

final class a
    implements android.animation.Animator.AnimatorListener
{

    final TextView a;
    final String b;
    final TextView c;
    final String d;

    a(TextView textview, String s, TextView textview1, String s1)
    {
        a = textview;
        b = s;
        c = textview1;
        d = s1;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        a.setText(b);
        a.setAlpha(0.9F);
        a.setScaleX(0.9F);
        a.setScaleY(0.9F);
        c.setText(d);
        c.setAlpha(0.5F);
        c.setScaleX(0.5F);
        c.setScaleY(0.5F);
    }
}
