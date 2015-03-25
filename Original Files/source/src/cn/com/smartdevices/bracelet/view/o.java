// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.support.v4.view.ViewPager;
import android.view.ViewTreeObserver;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            PagerSlidingTabStrip

class o
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final PagerSlidingTabStrip a;

    o(PagerSlidingTabStrip pagerslidingtabstrip)
    {
        a = pagerslidingtabstrip;
        super();
    }

    public void onGlobalLayout()
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else
        {
            a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        PagerSlidingTabStrip.a(a, PagerSlidingTabStrip.a(a).getCurrentItem());
        PagerSlidingTabStrip.a(a, PagerSlidingTabStrip.b(a), 0);
    }
}
