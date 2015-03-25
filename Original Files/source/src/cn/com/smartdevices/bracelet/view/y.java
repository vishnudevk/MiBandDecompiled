// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            w

class y
    implements ScrollDetectors.ScrollDetector
{

    private y()
    {
    }

    y(w w)
    {
        this();
    }

    public boolean canScrollHorizontal(View view, int i)
    {
        ViewPager viewpager = (ViewPager)view;
        PagerAdapter pageradapter = viewpager.getAdapter();
        if (pageradapter != null && pageradapter.getCount() != 0)
        {
            int j = viewpager.getCurrentItem();
            if (i < 0 && j < -1 + pageradapter.getCount() || i > 0 && j > 0)
            {
                return true;
            }
        }
        return false;
    }

    public boolean canScrollVertical(View view, int i)
    {
        return false;
    }
}
