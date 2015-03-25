// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import cn.com.smartdevices.bracelet.chart.util.ChartData;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DynamicFragment

class aa
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    final DynamicFragment a;

    aa(DynamicFragment dynamicfragment)
    {
        a = dynamicfragment;
        super();
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
        if (DynamicFragment.b(a) != null)
        {
            if (i % 2 == 1 && f == 0.0F)
            {
                f = 1.0F;
            }
            long l = (long)(f * (float)DynamicFragment.b(a).getDuration());
            DynamicFragment.b(a).setCurrentPlayTime(l);
        }
    }

    public void onPageSelected(int i)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        DynamicFragment.a(a, 16);
_L4:
        DynamicFragment.b(a, DynamicFragment.a(a));
        ChartData.getDynamicData().setCurrentMode(DynamicFragment.a(a));
        return;
_L2:
        if (i == 1)
        {
            DynamicFragment.a(a, 1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
