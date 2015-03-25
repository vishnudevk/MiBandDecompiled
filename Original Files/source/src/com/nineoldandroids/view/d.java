// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.nineoldandroids.view:
//            b, f, e

class d
    implements com.nineoldandroids.animation.Animator.AnimatorListener, com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
{

    final b a;

    private d(b b1)
    {
        a = b1;
        super();
    }

    d(b b1, d d1)
    {
        this(b1);
    }

    public void onAnimationCancel(Animator animator)
    {
        if (b.b(a) != null)
        {
            b.b(a).onAnimationCancel(animator);
        }
    }

    public void onAnimationEnd(Animator animator)
    {
        if (b.b(a) != null)
        {
            b.b(a).onAnimationEnd(animator);
        }
        b.c(a).remove(animator);
        if (b.c(a).isEmpty())
        {
            b.a(a, null);
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
        if (b.b(a) != null)
        {
            b.b(a).onAnimationRepeat(animator);
        }
    }

    public void onAnimationStart(Animator animator)
    {
        if (b.b(a) != null)
        {
            b.b(a).onAnimationStart(animator);
        }
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f1;
        ArrayList arraylist;
        f1 = valueanimator.getAnimatedFraction();
        f f2 = (f)b.c(a).get(valueanimator);
        if ((0x1ff & f2.a) != 0)
        {
            View view1 = (View)b.d(a).get();
            if (view1 != null)
            {
                view1.invalidate();
            }
        }
        arraylist = f2.b;
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = arraylist.size();
        j = 0;
_L5:
        if (j < i) goto _L3; else goto _L2
_L2:
        View view = (View)b.d(a).get();
        if (view != null)
        {
            view.invalidate();
        }
        return;
_L3:
        e e1 = (e)arraylist.get(j);
        float f3 = e1.b + f1 * e1.c;
        b.a(a, e1.a, f3);
        j++;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
