// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v4.app:
//            Fragment, FragmentManager, FragmentTransaction

public abstract class FragmentStatePagerAdapter extends PagerAdapter
{

    private static final String a = "FragmentStatePagerAdapter";
    private static final boolean b;
    private final FragmentManager c;
    private FragmentTransaction d;
    private ArrayList e;
    private ArrayList f;
    private Fragment g;

    public FragmentStatePagerAdapter(FragmentManager fragmentmanager)
    {
        d = null;
        e = new ArrayList();
        f = new ArrayList();
        g = null;
        c = fragmentmanager;
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        Fragment fragment = (Fragment)obj;
        if (d == null)
        {
            d = c.beginTransaction();
        }
        for (; e.size() <= i; e.add(null)) { }
        e.set(i, c.saveFragmentInstanceState(fragment));
        f.set(i, null);
        d.remove(fragment);
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

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        if (f.size() > i)
        {
            Fragment fragment1 = (Fragment)f.get(i);
            if (fragment1 != null)
            {
                return fragment1;
            }
        }
        if (d == null)
        {
            d = c.beginTransaction();
        }
        Fragment fragment = getItem(i);
        if (e.size() > i)
        {
            Fragment.SavedState savedstate = (Fragment.SavedState)e.get(i);
            if (savedstate != null)
            {
                fragment.setInitialSavedState(savedstate);
            }
        }
        for (; f.size() <= i; f.add(null)) { }
        fragment.setMenuVisibility(false);
        fragment.setUserVisibleHint(false);
        f.set(i, fragment);
        d.add(viewgroup.getId(), fragment);
        return fragment;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return ((Fragment)obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classloader)
    {
        if (parcelable != null)
        {
            Bundle bundle = (Bundle)parcelable;
            bundle.setClassLoader(classloader);
            Parcelable aparcelable[] = bundle.getParcelableArray("states");
            e.clear();
            f.clear();
            if (aparcelable != null)
            {
                for (int j = 0; j < aparcelable.length; j++)
                {
                    e.add((Fragment.SavedState)aparcelable[j]);
                }

            }
            Iterator iterator = bundle.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if (s.startsWith("f"))
                {
                    int i = Integer.parseInt(s.substring(1));
                    Fragment fragment = c.getFragment(bundle, s);
                    if (fragment != null)
                    {
                        for (; f.size() <= i; f.add(null)) { }
                        fragment.setMenuVisibility(false);
                        f.set(i, fragment);
                    } else
                    {
                        Log.w("FragmentStatePagerAdapter", (new StringBuilder()).append("Bad fragment at key ").append(s).toString());
                    }
                }
            } while (true);
        }
    }

    public Parcelable saveState()
    {
        int i = e.size();
        Bundle bundle = null;
        if (i > 0)
        {
            bundle = new Bundle();
            Fragment.SavedState asavedstate[] = new Fragment.SavedState[e.size()];
            e.toArray(asavedstate);
            bundle.putParcelableArray("states", asavedstate);
        }
        int j = 0;
        Bundle bundle1 = bundle;
        for (; j < f.size(); j++)
        {
            Fragment fragment = (Fragment)f.get(j);
            if (fragment == null)
            {
                continue;
            }
            if (bundle1 == null)
            {
                bundle1 = new Bundle();
            }
            String s = (new StringBuilder()).append("f").append(j).toString();
            c.putFragment(bundle1, s, fragment);
        }

        return bundle1;
    }

    public void setPrimaryItem(ViewGroup viewgroup, int i, Object obj)
    {
        Fragment fragment = (Fragment)obj;
        if (fragment != g)
        {
            if (g != null)
            {
                g.setMenuVisibility(false);
                g.setUserVisibleHint(false);
            }
            if (fragment != null)
            {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            g = fragment;
        }
    }

    public void startUpdate(ViewGroup viewgroup)
    {
    }
}
