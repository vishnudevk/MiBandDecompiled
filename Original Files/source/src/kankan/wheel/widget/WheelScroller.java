// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kankan.wheel.widget;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

// Referenced classes of package kankan.wheel.widget:
//            a, b

public class WheelScroller
{

    public static final int MIN_DELTA_FOR_SCROLLING = 1;
    private static final int a = 400;
    private ScrollingListener b;
    private Context c;
    private GestureDetector d;
    private Scroller e;
    private int f;
    private float g;
    private boolean h;
    private android.view.GestureDetector.SimpleOnGestureListener i;
    private final int j = 0;
    private final int k = 1;
    private Handler l;

    public WheelScroller(Context context, ScrollingListener scrollinglistener)
    {
        i = new a(this);
        l = new b(this);
        d = new GestureDetector(context, i);
        d.setIsLongpressEnabled(false);
        e = new Scroller(context);
        b = scrollinglistener;
        c = context;
    }

    static int a(WheelScroller wheelscroller)
    {
        return wheelscroller.f;
    }

    static int a(WheelScroller wheelscroller, int i1)
    {
        wheelscroller.f = i1;
        return i1;
    }

    private void a(int i1)
    {
        b();
        l.sendEmptyMessage(i1);
    }

    static Scroller b(WheelScroller wheelscroller)
    {
        return wheelscroller.e;
    }

    private void b()
    {
        l.removeMessages(0);
        l.removeMessages(1);
    }

    static void b(WheelScroller wheelscroller, int i1)
    {
        wheelscroller.a(i1);
    }

    static ScrollingListener c(WheelScroller wheelscroller)
    {
        return wheelscroller.b;
    }

    private void c()
    {
        b.onJustify();
        a(1);
    }

    static Handler d(WheelScroller wheelscroller)
    {
        return wheelscroller.l;
    }

    private void d()
    {
        if (!h)
        {
            h = true;
            b.onStarted();
        }
    }

    static void e(WheelScroller wheelscroller)
    {
        wheelscroller.c();
    }

    void a()
    {
        if (h)
        {
            b.onFinished();
            h = false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 57
    //                   1 32
    //                   2 80;
           goto _L1 _L2 _L1 _L3
_L1:
        if (!d.onTouchEvent(motionevent) && motionevent.getAction() == 1)
        {
            c();
        }
        return true;
_L2:
        g = motionevent.getY();
        e.forceFinished(true);
        b();
        continue; /* Loop/switch isn't completed */
_L3:
        int i1 = (int)(motionevent.getY() - g);
        if (i1 != 0)
        {
            d();
            b.onScroll(i1);
            g = motionevent.getY();
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void scroll(int i1, int j1)
    {
        e.forceFinished(true);
        f = 0;
        Scroller scroller = e;
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
        e.forceFinished(true);
        e = new Scroller(c, interpolator);
    }

    public void stopScrolling()
    {
        e.forceFinished(true);
    }

    private class ScrollingListener
    {

        public abstract void onFinished();

        public abstract void onJustify();

        public abstract void onScroll(int i1);

        public abstract void onStarted();
    }

}
