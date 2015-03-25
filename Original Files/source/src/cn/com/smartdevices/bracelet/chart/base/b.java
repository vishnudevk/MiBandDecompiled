// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.base;

import android.os.Handler;
import android.os.Message;
import android.widget.Scroller;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.base:
//            ChartScroller

class b extends Handler
{

    final ChartScroller a;

    b(ChartScroller chartscroller)
    {
        a = chartscroller;
        super();
    }

    public void handleMessage(Message message)
    {
        ChartScroller.a(a).computeScrollOffset();
        int i = ChartScroller.a(a).getCurrX();
        int j = ChartScroller.b(a) - i;
        ChartScroller.a(a, i);
        if (j != 0)
        {
            ChartScroller.c(a).onScrollX(j);
        }
        int k = ChartScroller.a(a).getCurrY();
        int l = ChartScroller.d(a) - k;
        ChartScroller.b(a, k);
        if (l != 0)
        {
            ChartScroller.c(a).onScrollY(l);
        }
        if (ChartScroller.e(a) && Math.abs(i - ChartScroller.a(a).getFinalX()) < 1)
        {
            ChartScroller.a(a).getFinalX();
            ChartScroller.a(a).forceFinished(true);
        }
        if (!ChartScroller.e(a) && Math.abs(k - ChartScroller.a(a).getFinalY()) < 1)
        {
            ChartScroller.a(a).getFinalY();
            ChartScroller.a(a).forceFinished(true);
        }
        if (!ChartScroller.a(a).isFinished())
        {
            ChartScroller.f(a).sendEmptyMessage(message.what);
            return;
        }
        if (message.what == 0)
        {
            ChartScroller.g(a);
            return;
        } else
        {
            a.a();
            return;
        }
    }
}
