// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.base:
//            c, b

public class ChartScroller
{

    public static final int MIN_DELTA_FOR_SCROLLING = 1;
    private static final String a = "Chart.Scroller";
    private static final int b = 400;
    private ScrollingListener c;
    private Context d;
    private GestureDetector e;
    private Scroller f;
    private int g;
    private float h;
    private int i;
    private float j;
    private boolean k;
    private boolean l;
    private Handler m;
    private android.view.GestureDetector.SimpleOnGestureListener n;
    private final int o = 0;
    private final int p = 1;

    public ChartScroller(Context context, ScrollingListener scrollinglistener)
    {
        n = new c(this);
        d = context;
        c = scrollinglistener;
        e = new GestureDetector(context, n);
        e.setIsLongpressEnabled(false);
        f = new Scroller(context);
        m = new b(this);
    }

    static int a(ChartScroller chartscroller, int i1)
    {
        chartscroller.g = i1;
        return i1;
    }

    static Scroller a(ChartScroller chartscroller)
    {
        return chartscroller.f;
    }

    private void a(int i1)
    {
        b();
        m.sendEmptyMessage(i1);
    }

    static int b(ChartScroller chartscroller)
    {
        return chartscroller.g;
    }

    static int b(ChartScroller chartscroller, int i1)
    {
        chartscroller.i = i1;
        return i1;
    }

    private void b()
    {
        m.removeMessages(0);
        m.removeMessages(1);
    }

    static ScrollingListener c(ChartScroller chartscroller)
    {
        return chartscroller.c;
    }

    private void c()
    {
        c.onJustify();
        a(1);
    }

    static void c(ChartScroller chartscroller, int i1)
    {
        chartscroller.a(i1);
    }

    static int d(ChartScroller chartscroller)
    {
        return chartscroller.i;
    }

    private void d()
    {
        if (!k)
        {
            k = true;
            c.onStart();
        }
    }

    static boolean e(ChartScroller chartscroller)
    {
        return chartscroller.l;
    }

    static Handler f(ChartScroller chartscroller)
    {
        return chartscroller.m;
    }

    static void g(ChartScroller chartscroller)
    {
        chartscroller.c();
    }

    void a()
    {
        if (k)
        {
            c.onFinish();
            k = false;
        }
    }

    public void forceFinishScrolling()
    {
        if (!f.isFinished())
        {
            f.forceFinished(true);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 61
    //                   1 32
    //                   2 95;
           goto _L1 _L2 _L1 _L3
_L1:
        boolean flag = true;
_L5:
        if (!e.onTouchEvent(motionevent) && motionevent.getAction() == 1)
        {
            c();
        }
        return flag;
_L2:
        h = motionevent.getX();
        j = motionevent.getY();
        f.forceFinished(true);
        b();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L3:
        int i1 = (int)(motionevent.getX() - h);
        int j1 = (int)(motionevent.getY() - j);
        if (i1 != 0)
        {
            d();
            flag = c.onScrollX(i1);
            h = motionevent.getX();
        } else
        {
            flag = true;
        }
        if (j1 != 0)
        {
            d();
            flag = c.onScrollY(j1);
            j = motionevent.getY();
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void scrollX(int i1)
    {
        scrollX(i1, 0);
    }

    public void scrollX(int i1, int j1)
    {
        l = true;
        f.forceFinished(true);
        g = 0;
        Scroller scroller = f;
        int k1;
        if (j1 != 0)
        {
            k1 = j1;
        } else
        {
            k1 = 400;
        }
        scroller.startScroll(0, 0, i1, 0, k1);
        a(0);
        d();
    }

    public void scrollY(int i1)
    {
        scrollY(i1, 0);
    }

    public void scrollY(int i1, int j1)
    {
        l = false;
        f.forceFinished(true);
        i = 0;
        Scroller scroller = f;
        int k1;
        if (j1 != 0)
        {
            k1 = j1;
        } else
        {
            k1 = 400;
        }
        scroller.startScroll(0, 0, 0, i1, k1);
        a(0);
        d();
    }

    public void setInterpolator(Interpolator interpolator)
    {
        f.forceFinished(true);
        f = new Scroller(d, interpolator);
    }

    private class ScrollingListener
    {

        public abstract void onFinish();

        public abstract void onJustify();

        public abstract boolean onScrollX(int i1);

        public abstract boolean onScrollY(int i1);

        public abstract void onStart();
    }

}
