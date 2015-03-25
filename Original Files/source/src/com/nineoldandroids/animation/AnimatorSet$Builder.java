// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.nineoldandroids.animation:
//            AnimatorSet, e, ValueAnimator, c, 
//            Animator

public class b
{

    final AnimatorSet a;
    private e b;

    public b after(long l)
    {
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        valueanimator.setDuration(l);
        after(((Animator) (valueanimator)));
        return this;
    }

    public after after(Animator animator)
    {
        e e1 = (e)AnimatorSet.b(a).get(animator);
        if (e1 == null)
        {
            e1 = new e(animator);
            AnimatorSet.b(a).put(animator, e1);
            AnimatorSet.d(a).add(e1);
        }
        c c1 = new c(e1, 1);
        b.a(c1);
        return this;
    }

    public b before(Animator animator)
    {
        e e1 = (e)AnimatorSet.b(a).get(animator);
        if (e1 == null)
        {
            e1 = new e(animator);
            AnimatorSet.b(a).put(animator, e1);
            AnimatorSet.d(a).add(e1);
        }
        e1.a(new c(b, 1));
        return this;
    }

    public b with(Animator animator)
    {
        e e1 = (e)AnimatorSet.b(a).get(animator);
        if (e1 == null)
        {
            e1 = new e(animator);
            AnimatorSet.b(a).put(animator, e1);
            AnimatorSet.d(a).add(e1);
        }
        e1.a(new c(b, 0));
        return this;
    }

    (AnimatorSet animatorset, Animator animator)
    {
        a = animatorset;
        super();
        b = (e)AnimatorSet.b(animatorset).get(animator);
        if (b == null)
        {
            b = new e(animator);
            AnimatorSet.b(animatorset).put(animator, b);
            AnimatorSet.d(animatorset).add(b);
        }
    }
}
