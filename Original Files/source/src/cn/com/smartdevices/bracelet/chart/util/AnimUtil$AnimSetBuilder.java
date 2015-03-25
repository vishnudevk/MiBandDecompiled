// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import java.util.ArrayList;
import java.util.Iterator;

public class 
{

    private static Animator a;
    private static ArrayList b = new ArrayList();

    private static void a()
    {
        a = null;
        b.clear();
    }

    public static void addAnim(Animator animator)
    {
        b.add(animator);
    }

    public static void addAnim(Animator animator, long l)
    {
        animator.setDuration(l);
        b.add(animator);
    }

    public static void addAnim(Animator animator, long l, long l1)
    {
        animator.setStartDelay(l1);
        if (l > 0L)
        {
            animator.setDuration(l);
        }
        b.add(animator);
    }

    public static AnimatorSet build()
    {
        AnimatorSet animatorset = new AnimatorSet();
        android.animation.imUtil.AnimSetBuilder.b b1 = animatorset.play(a);
        for (Iterator iterator = b.iterator(); iterator.hasNext(); b1.((Animator)iterator.next())) { }
        a();
        return animatorset;
    }

    public static void setFirstAnim(Animator animator)
    {
        a = animator;
    }

    public static void setFirstAnim(Animator animator, long l)
    {
        animator.setDuration(l);
        a = animator;
    }


    private ()
    {
    }
}
