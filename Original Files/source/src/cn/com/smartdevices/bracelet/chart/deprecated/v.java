// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            StatisticHostFragment

class v
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    final StatisticHostFragment a;

    v(StatisticHostFragment statistichostfragment)
    {
        a = statistichostfragment;
        super();
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        if (i == 0)
        {
            a.getView().findViewById(0x7f0a014e).setVisibility(0);
            a.getView().findViewById(0x7f0a0151).setVisibility(4);
            return;
        } else
        {
            a.getView().findViewById(0x7f0a014e).setVisibility(4);
            a.getView().findViewById(0x7f0a0151).setVisibility(0);
            return;
        }
    }
}
