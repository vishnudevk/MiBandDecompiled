// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;

// Referenced classes of package android.support.v4.widget:
//            s, r, q, p

public class ScrollerCompat
{

    static final p b;
    Object a;

    ScrollerCompat(Context context, Interpolator interpolator)
    {
        a = b.a(context, interpolator);
    }

    public static ScrollerCompat create(Context context)
    {
        return create(context, null);
    }

    public static ScrollerCompat create(Context context, Interpolator interpolator)
    {
        return new ScrollerCompat(context, interpolator);
    }

    public void abortAnimation()
    {
        b.f(a);
    }

    public boolean computeScrollOffset()
    {
        return b.e(a);
    }

    public void fling(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        b.a(a, i, j, k, l, i1, j1, k1, l1);
    }

    public void fling(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2)
    {
        b.a(a, i, j, k, l, i1, j1, k1, l1, i2, j2);
    }

    public float getCurrVelocity()
    {
        return b.d(a);
    }

    public int getCurrX()
    {
        return b.b(a);
    }

    public int getCurrY()
    {
        return b.c(a);
    }

    public int getFinalX()
    {
        return b.h(a);
    }

    public int getFinalY()
    {
        return b.i(a);
    }

    public boolean isFinished()
    {
        return b.a(a);
    }

    public boolean isOverScrolled()
    {
        return b.g(a);
    }

    public void notifyHorizontalEdgeReached(int i, int j, int k)
    {
        b.a(a, i, j, k);
    }

    public void notifyVerticalEdgeReached(int i, int j, int k)
    {
        b.b(a, i, j, k);
    }

    public void startScroll(int i, int j, int k, int l)
    {
        b.a(a, i, j, k, l);
    }

    public void startScroll(int i, int j, int k, int l, int i1)
    {
        b.a(a, i, j, k, l, i1);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 14)
        {
            b = new s();
        } else
        if (i >= 9)
        {
            b = new r();
        } else
        {
            b = new q();
        }
    }
}
