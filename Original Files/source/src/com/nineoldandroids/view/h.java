// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view;

import android.animation.Animator;

// Referenced classes of package com.nineoldandroids.view:
//            g

class h
    implements android.animation.Animator.AnimatorListener
{

    final g a;
    private final com.nineoldandroids.animation.Animator.AnimatorListener b;

    h(g g, com.nineoldandroids.animation.Animator.AnimatorListener animatorlistener)
    {
        a = g;
        b = animatorlistener;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
        b.onAnimationCancel(null);
    }

    public void onAnimationEnd(Animator animator)
    {
        b.onAnimationEnd(null);
    }

    public void onAnimationRepeat(Animator animator)
    {
        b.onAnimationRepeat(null);
    }

    public void onAnimationStart(Animator animator)
    {
        b.onAnimationStart(null);
    }
}
