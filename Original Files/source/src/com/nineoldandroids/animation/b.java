// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.nineoldandroids.animation:
//            AnimatorSet, Animator, e

class b
    implements Animator.AnimatorListener
{

    final AnimatorSet a;
    private AnimatorSet b;

    b(AnimatorSet animatorset, AnimatorSet animatorset1)
    {
        a = animatorset;
        super();
        b = animatorset1;
    }

    public void onAnimationCancel(Animator animator)
    {
        if (a.b || AnimatorSet.a(a).size() != 0 || a.a == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = a.a.size();
        j = 0;
_L5:
        if (j < i) goto _L3; else goto _L2
_L2:
        return;
_L3:
        ((Animator.AnimatorListener)a.a.get(j)).onAnimationCancel(b);
        j++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onAnimationEnd(Animator animator)
    {
        animator.removeListener(this);
        AnimatorSet.a(a).remove(animator);
        ((e)AnimatorSet.b(b).get(animator)).f = true;
        if (a.b) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        int i;
        int j;
        arraylist = AnimatorSet.c(b);
        i = arraylist.size();
        j = 0;
_L6:
        boolean flag;
        ArrayList arraylist1;
        int k;
        int l;
        if (j >= i)
        {
            flag = true;
        } else
        {
label0:
            {
                if (((e)arraylist.get(j)).f)
                {
                    break label0;
                }
                flag = false;
            }
        }
        if (!flag) goto _L2; else goto _L3
_L3:
        if (a.a == null) goto _L5; else goto _L4
_L4:
        arraylist1 = (ArrayList)a.a.clone();
        k = arraylist1.size();
        l = 0;
_L7:
        if (l < k)
        {
            break MISSING_BLOCK_LABEL_155;
        }
_L5:
        AnimatorSet.a(b, false);
_L2:
        return;
        j++;
          goto _L6
        ((Animator.AnimatorListener)arraylist1.get(l)).onAnimationEnd(b);
        l++;
          goto _L7
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }
}
