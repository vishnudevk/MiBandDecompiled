// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kankan.wheel.widget;

import android.view.MotionEvent;
import android.widget.Scroller;

// Referenced classes of package kankan.wheel.widget:
//            WheelScroller

class a extends android.view.GestureDetector.SimpleOnGestureListener
{

    final WheelScroller a;

    a(WheelScroller wheelscroller)
    {
        a = wheelscroller;
        super();
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        WheelScroller.a(a, 0);
        WheelScroller.b(a).fling(0, WheelScroller.a(a), 0, (int)(-f1), 0, 0, 0x80000001, 0x7fffffff);
        WheelScroller.b(a, 0);
        return true;
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return true;
    }
}
