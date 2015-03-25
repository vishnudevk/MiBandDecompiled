// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class Animator
    implements Cloneable
{

    ArrayList a;

    public Animator()
    {
        a = null;
    }

    public void addListener(AnimatorListener animatorlistener)
    {
        if (a == null)
        {
            a = new ArrayList();
        }
        a.add(animatorlistener);
    }

    public void cancel()
    {
    }

    public Animator clone()
    {
        Animator animator;
        ArrayList arraylist;
        int i;
        animator = (Animator)super.clone();
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        arraylist = a;
        animator.a = new ArrayList();
        i = arraylist.size();
        int j = 0;
        while (j < i) 
        {
            try
            {
                animator.a.add((AnimatorListener)arraylist.get(j));
            }
            catch (CloneNotSupportedException clonenotsupportedexception)
            {
                throw new AssertionError();
            }
            j++;
        }
        return animator;
    }

    public volatile Object clone()
    {
        return clone();
    }

    public void end()
    {
    }

    public abstract long getDuration();

    public ArrayList getListeners()
    {
        return a;
    }

    public abstract long getStartDelay();

    public abstract boolean isRunning();

    public boolean isStarted()
    {
        return isRunning();
    }

    public void removeAllListeners()
    {
        if (a != null)
        {
            a.clear();
            a = null;
        }
    }

    public void removeListener(AnimatorListener animatorlistener)
    {
        if (a != null)
        {
            a.remove(animatorlistener);
            if (a.size() == 0)
            {
                a = null;
                return;
            }
        }
    }

    public abstract Animator setDuration(long l);

    public abstract void setInterpolator(Interpolator interpolator);

    public abstract void setStartDelay(long l);

    public void setTarget(Object obj)
    {
    }

    public void setupEndValues()
    {
    }

    public void setupStartValues()
    {
    }

    public void start()
    {
    }

    private class AnimatorListener
    {

        public abstract void onAnimationCancel(Animator animator);

        public abstract void onAnimationEnd(Animator animator);

        public abstract void onAnimationRepeat(Animator animator);

        public abstract void onAnimationStart(Animator animator);
    }

}
