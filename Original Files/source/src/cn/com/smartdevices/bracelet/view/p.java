// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            PagerSlidingTabStrip

class p
    implements android.view.View.OnClickListener
{

    final int a;
    final PagerSlidingTabStrip b;

    p(PagerSlidingTabStrip pagerslidingtabstrip, int i)
    {
        b = pagerslidingtabstrip;
        a = i;
        super();
    }

    public void onClick(View view)
    {
        PagerSlidingTabStrip.a(b).setCurrentItem(a);
    }
}
