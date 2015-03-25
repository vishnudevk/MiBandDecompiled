// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kankan.wheel.widget;


// Referenced classes of package kankan.wheel.widget:
//            WheelView, WheelScroller

class d
    implements WheelScroller.ScrollingListener
{

    final WheelView a;

    d(WheelView wheelview)
    {
        a = wheelview;
        super();
    }

    public void onFinished()
    {
        if (WheelView.c(a))
        {
            a.notifyScrollingListenersAboutEnd();
            WheelView.a(a, false);
        }
        WheelView.b(a, 0);
        a.invalidate();
    }

    public void onJustify()
    {
        if (Math.abs(WheelView.a(a)) > 1)
        {
            WheelView.b(a).scroll(WheelView.a(a), 0);
        }
    }

    public void onScroll(int i)
    {
        WheelView.a(a, i);
        int j = a.getHeight();
        if (WheelView.a(a) > j)
        {
            WheelView.b(a, j);
            WheelView.b(a).stopScrolling();
        } else
        if (WheelView.a(a) < -j)
        {
            WheelView.b(a, -j);
            WheelView.b(a).stopScrolling();
            return;
        }
    }

    public void onStarted()
    {
        WheelView.a(a, true);
        a.notifyScrollingListenersAboutStart();
    }
}
