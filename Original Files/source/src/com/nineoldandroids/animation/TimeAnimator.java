// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;


// Referenced classes of package com.nineoldandroids.animation:
//            ValueAnimator

public class TimeAnimator extends ValueAnimator
{

    private TimeListener m;
    private long n;

    public TimeAnimator()
    {
        n = -1L;
    }

    void a()
    {
    }

    void a(float f)
    {
    }

    boolean a(long l)
    {
        long l1 = 0L;
        if (i == 0)
        {
            i = 1;
            long l2;
            if (h < l1)
            {
                g = l;
            } else
            {
                g = l - h;
                h = -1L;
            }
        }
        if (m != null)
        {
            l2 = l - g;
            if (n >= l1)
            {
                l1 = l - n;
            }
            n = l;
            m.onTimeUpdate(this, l2, l1);
        }
        return false;
    }

    public void setTimeListener(TimeListener timelistener)
    {
        m = timelistener;
    }

    private class TimeListener
    {

        public abstract void onTimeUpdate(TimeAnimator timeanimator, long l, long l1);
    }

}
