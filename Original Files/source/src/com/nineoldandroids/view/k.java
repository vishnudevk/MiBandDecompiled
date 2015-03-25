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
//            i, m, l

class k
    implements com.nineoldandroids.animation.Animator.AnimatorListener, com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
{

    final i a;

    private k(i j)
    {
        a = j;
        super();
    }

    k(i j, k k1)
    {
        this(j);
    }

    public void onAnimationCancel(Animator animator)
    {
        if (i.b(a) != null)
        {
            i.b(a).onAnimationCancel(animator);
        }
    }

    public void onAnimationEnd(Animator animator)
    {
        if (i.b(a) != null)
        {
            i.b(a).onAnimationEnd(animator);
        }
        i.c(a).remove(animator);
        if (i.c(a).isEmpty())
        {
            i.a(a, null);
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
        if (i.b(a) != null)
        {
            i.b(a).onAnimationRepeat(animator);
        }
    }

    public void onAnimationStart(Animator animator)
    {
        if (i.b(a) != null)
        {
            i.b(a).onAnimationStart(animator);
        }
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f;
        ArrayList arraylist;
        f = valueanimator.getAnimatedFraction();
        m m1 = (m)i.c(a).get(valueanimator);
        if ((0x1ff & m1.a) != 0)
        {
            View view1 = (View)i.d(a).get();
            if (view1 != null)
            {
                view1.invalidate();
            }
        }
        arraylist = m1.b;
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        int j;
        int i1;
        j = arraylist.size();
        i1 = 0;
_L5:
        if (i1 < j) goto _L3; else goto _L2
_L2:
        View view = (View)i.d(a).get();
        if (view != null)
        {
            view.invalidate();
        }
        return;
_L3:
        l l1 = (l)arraylist.get(i1);
        float f1 = l1.b + f * l1.c;
        i.a(a, l1.a, f1);
        i1++;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
