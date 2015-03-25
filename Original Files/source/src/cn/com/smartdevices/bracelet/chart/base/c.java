// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.base;

import android.view.MotionEvent;
import android.widget.Scroller;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.base:
//            ChartScroller

class c extends android.view.GestureDetector.SimpleOnGestureListener
{

    final ChartScroller a;

    c(ChartScroller chartscroller)
    {
        a = chartscroller;
        super();
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        ChartScroller.a(a, 0);
        ChartScroller.b(a, 0);
        ChartScroller.a(a).fling(ChartScroller.b(a), ChartScroller.d(a), (int)(-f), (int)(-f1), -5400, 5400, -5400, 5400);
        ChartScroller.c(a, 0);
        return true;
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return true;
    }
}
