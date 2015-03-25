// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.view.animation.Interpolator;
import com.handmark.pulltorefresh.library.internal.ViewCompat;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshBase, g

final class h
    implements Runnable
{

    final PullToRefreshBase a;
    private final Interpolator b;
    private final int c;
    private final int d;
    private final long e;
    private g f;
    private boolean g;
    private long h;
    private int i;

    public h(PullToRefreshBase pulltorefreshbase, int j, int k, long l, g g1)
    {
        a = pulltorefreshbase;
        super();
        g = true;
        h = -1L;
        i = -1;
        d = j;
        c = k;
        b = PullToRefreshBase.b(pulltorefreshbase);
        e = l;
        f = g1;
    }

    public void a()
    {
        g = false;
        a.removeCallbacks(this);
    }

    public void run()
    {
        if (h == -1L)
        {
            h = System.currentTimeMillis();
        } else
        {
            long l = Math.max(Math.min((1000L * (System.currentTimeMillis() - h)) / e, 1000L), 0L);
            int j = Math.round((float)(d - c) * b.getInterpolation((float)l / 1000F));
            i = d - j;
            a.setHeaderScroll(i);
        }
        if (g && c != i)
        {
            ViewCompat.postOnAnimation(a, this);
        } else
        if (f != null)
        {
            f.a();
            return;
        }
    }
}
