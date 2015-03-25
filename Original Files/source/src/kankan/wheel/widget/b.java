// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kankan.wheel.widget;

import android.os.Handler;
import android.os.Message;
import android.widget.Scroller;

// Referenced classes of package kankan.wheel.widget:
//            WheelScroller

class b extends Handler
{

    final WheelScroller a;

    b(WheelScroller wheelscroller)
    {
        a = wheelscroller;
        super();
    }

    public void handleMessage(Message message)
    {
        WheelScroller.b(a).computeScrollOffset();
        int i = WheelScroller.b(a).getCurrY();
        int j = WheelScroller.a(a) - i;
        WheelScroller.a(a, i);
        if (j != 0)
        {
            WheelScroller.c(a).onScroll(j);
        }
        if (Math.abs(i - WheelScroller.b(a).getFinalY()) < 1)
        {
            WheelScroller.b(a).getFinalY();
            WheelScroller.b(a).forceFinished(true);
        }
        if (!WheelScroller.b(a).isFinished())
        {
            WheelScroller.d(a).sendEmptyMessage(message.what);
            return;
        }
        if (message.what == 0)
        {
            WheelScroller.e(a);
            return;
        } else
        {
            a.a();
            return;
        }
    }
}
