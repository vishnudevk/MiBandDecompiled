// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            PagerSlidingTabStrip, o

class q
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    final PagerSlidingTabStrip a;

    private q(PagerSlidingTabStrip pagerslidingtabstrip)
    {
        a = pagerslidingtabstrip;
        super();
    }

    q(PagerSlidingTabStrip pagerslidingtabstrip, o o)
    {
        this(pagerslidingtabstrip);
    }

    public void onPageScrollStateChanged(int i)
    {
        if (i == 0)
        {
            PagerSlidingTabStrip.a(a, PagerSlidingTabStrip.a(a).getCurrentItem(), 0);
        }
        if (a.delegatePageListener != null)
        {
            a.delegatePageListener.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        PagerSlidingTabStrip.a(a, i);
        PagerSlidingTabStrip.a(a, f);
        PagerSlidingTabStrip.a(a, i, (int)(f * (float)PagerSlidingTabStrip.c(a).getChildAt(i).getWidth()));
        a.invalidate();
        if (a.delegatePageListener != null)
        {
            a.delegatePageListener.onPageScrolled(i, f, j);
        }
    }

    public void onPageSelected(int i)
    {
        if (a.delegatePageListener != null)
        {
            a.delegatePageListener.onPageSelected(i);
        }
    }
}
