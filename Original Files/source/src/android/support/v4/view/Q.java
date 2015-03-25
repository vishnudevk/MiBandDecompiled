// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.database.DataSetObserver;

// Referenced classes of package android.support.v4.view:
//            aE, PagerTitleStrip, ViewPager, P, 
//            PagerAdapter

class Q extends DataSetObserver
    implements ViewPager.OnPageChangeListener, aE
{

    final PagerTitleStrip a;
    private int b;

    private Q(PagerTitleStrip pagertitlestrip)
    {
        a = pagertitlestrip;
        super();
    }

    Q(PagerTitleStrip pagertitlestrip, P p)
    {
        this(pagertitlestrip);
    }

    public void a(PagerAdapter pageradapter, PagerAdapter pageradapter1)
    {
        a.a(pageradapter, pageradapter1);
    }

    public void onChanged()
    {
        a.a(a.a.getCurrentItem(), a.a.getAdapter());
        int i = PagerTitleStrip.a(a) != 0.0F;
        float f = 0.0F;
        if (i >= 0)
        {
            f = PagerTitleStrip.a(a);
        }
        a.a(a.a.getCurrentItem(), f, true);
    }

    public void onPageScrollStateChanged(int i)
    {
        b = i;
    }

    public void onPageScrolled(int i, float f, int j)
    {
        if (f > 0.5F)
        {
            i++;
        }
        a.a(i, f, false);
    }

    public void onPageSelected(int i)
    {
        if (b == 0)
        {
            a.a(a.a.getCurrentItem(), a.a.getAdapter());
            int j = PagerTitleStrip.a(a) != 0.0F;
            float f = 0.0F;
            if (j >= 0)
            {
                f = PagerTitleStrip.a(a);
            }
            a.a(a.a.getCurrentItem(), f, true);
        }
    }
}
