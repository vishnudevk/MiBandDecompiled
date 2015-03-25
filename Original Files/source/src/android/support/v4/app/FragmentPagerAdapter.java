// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.v4.app:
//            FragmentManager, Fragment, FragmentTransaction

public abstract class FragmentPagerAdapter extends PagerAdapter
{

    private static final String a = "FragmentPagerAdapter";
    private static final boolean b;
    private final FragmentManager c;
    private FragmentTransaction d;
    private Fragment e;

    public FragmentPagerAdapter(FragmentManager fragmentmanager)
    {
        d = null;
        e = null;
        c = fragmentmanager;
    }

    private static String a(int i, long l)
    {
        return (new StringBuilder()).append("android:switcher:").append(i).append(":").append(l).toString();
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        if (d == null)
        {
            d = c.beginTransaction();
        }
        d.detach((Fragment)obj);
    }

    public void finishUpdate(ViewGroup viewgroup)
    {
        if (d != null)
        {
            d.commitAllowingStateLoss();
            d = null;
            c.executePendingTransactions();
        }
    }

    public abstract Fragment getItem(int i);

    public long getItemId(int i)
    {
        return (long)i;
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        if (d == null)
        {
            d = c.beginTransaction();
        }
        long l = getItemId(i);
        String s = a(viewgroup.getId(), l);
        Fragment fragment = c.findFragmentByTag(s);
        if (fragment != null)
        {
            d.attach(fragment);
        } else
        {
            fragment = getItem(i);
            d.add(viewgroup.getId(), fragment, a(viewgroup.getId(), l));
        }
        if (fragment != e)
        {
            fragment.setMenuVisibility(false);
            fragment.setUserVisibleHint(false);
        }
        return fragment;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return ((Fragment)obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classloader)
    {
    }

    public Parcelable saveState()
    {
        return null;
    }

    public void setPrimaryItem(ViewGroup viewgroup, int i, Object obj)
    {
        Fragment fragment = (Fragment)obj;
        if (fragment != e)
        {
            if (e != null)
            {
                e.setMenuVisibility(false);
                e.setUserVisibleHint(false);
            }
            if (fragment != null)
            {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            e = fragment;
        }
    }

    public void startUpdate(ViewGroup viewgroup)
    {
    }
}
