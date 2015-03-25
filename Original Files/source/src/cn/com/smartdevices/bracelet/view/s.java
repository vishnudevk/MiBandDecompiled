// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            RoundProgressBar

class s
    implements android.animation.Animator.AnimatorListener
{

    final RoundProgressBar a;

    s(RoundProgressBar roundprogressbar)
    {
        a = roundprogressbar;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (RoundProgressBar.a(a) < RoundProgressBar.b(a) && RoundProgressBar.c(a) < RoundProgressBar.b(a))
        {
            RoundProgressBar.a(a, RoundProgressBar.b(a));
            RoundProgressBar.a(a, RoundProgressBar.a(a) - RoundProgressBar.c(a), RoundProgressBar.c(a), RoundProgressBar.a(a));
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }
}
