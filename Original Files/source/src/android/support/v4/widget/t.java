// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class t
{

    t()
    {
    }

    public static Object a(Context context, Interpolator interpolator)
    {
        if (interpolator != null)
        {
            return new OverScroller(context, interpolator);
        } else
        {
            return new OverScroller(context);
        }
    }

    public static void a(Object obj, int i, int j, int k)
    {
        ((OverScroller)obj).notifyHorizontalEdgeReached(i, j, k);
    }

    public static void a(Object obj, int i, int j, int k, int l)
    {
        ((OverScroller)obj).startScroll(i, j, k, l);
    }

    public static void a(Object obj, int i, int j, int k, int l, int i1)
    {
        ((OverScroller)obj).startScroll(i, j, k, l, i1);
    }

    public static void a(Object obj, int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        ((OverScroller)obj).fling(i, j, k, l, i1, j1, k1, l1);
    }

    public static void a(Object obj, int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2)
    {
        ((OverScroller)obj).fling(i, j, k, l, i1, j1, k1, l1, i2, j2);
    }

    public static boolean a(Object obj)
    {
        return ((OverScroller)obj).isFinished();
    }

    public static int b(Object obj)
    {
        return ((OverScroller)obj).getCurrX();
    }

    public static void b(Object obj, int i, int j, int k)
    {
        ((OverScroller)obj).notifyVerticalEdgeReached(i, j, k);
    }

    public static int c(Object obj)
    {
        return ((OverScroller)obj).getCurrY();
    }

    public static boolean d(Object obj)
    {
        return ((OverScroller)obj).computeScrollOffset();
    }

    public static void e(Object obj)
    {
        ((OverScroller)obj).abortAnimation();
    }

    public static boolean f(Object obj)
    {
        return ((OverScroller)obj).isOverScrolled();
    }

    public static int g(Object obj)
    {
        return ((OverScroller)obj).getFinalX();
    }

    public static int h(Object obj)
    {
        return ((OverScroller)obj).getFinalY();
    }
}
