// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import java.util.ArrayList;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            TabsFragment

public class a extends FragmentPagerAdapter
{

    final TabsFragment a;

    public int getCount()
    {
        return a.mFragmentTabs.size();
    }

    public Fragment getItem(int i)
    {
        a a1 = (a)a.mFragmentTabs.get(i);
        return Fragment.instantiate(a.getActivity(), a1.a.getName(), a1.a);
    }

    public CharSequence getPageTitle(int i)
    {
        return ((a)a.mFragmentTabs.get(i)).a;
    }

    public (TabsFragment tabsfragment, FragmentManager fragmentmanager)
    {
        a = tabsfragment;
        super(fragmentmanager);
    }
}
