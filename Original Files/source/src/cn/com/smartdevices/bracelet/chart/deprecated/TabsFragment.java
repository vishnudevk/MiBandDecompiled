// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import java.util.ArrayList;

public class TabsFragment extends Fragment
    implements android.view.View.OnClickListener
{

    private static final String a = "TabsFragment";
    protected FragmentTabAdapter mAdapter;
    protected ArrayList mFragmentTabs;
    protected ViewPager mPager;
    protected ViewGroup mTabHost;
    protected View mTabHostItems[];

    public TabsFragment()
    {
    }

    private void a(int i)
    {
        View aview[] = mTabHostItems;
        int j = aview.length;
        for (int k = 0; k < j; k++)
        {
            aview[k].setActivated(false);
        }

        mTabHostItems[i].setActivated(true);
        mPager.setCurrentItem(i);
    }

    public void fillFragmentTabs(ArrayList arraylist)
    {
    }

    protected int inflateLayout()
    {
        return 0x7f03004d;
    }

    public void onActivityCreated(Bundle bundle)
    {
        int i;
        super.onActivityCreated(bundle);
        Debug.i("TabsFragment", "OnActivityCreated!!");
        mTabHost = (ViewGroup)getView().findViewById(0x7f0a015d);
        mPager = (ViewPager)getView().findViewById(0x7f0a015c);
        mTabHostItems = new View[mFragmentTabs.size()];
        i = 0;
_L6:
        if (i >= mFragmentTabs.size())
        {
            break MISSING_BLOCK_LABEL_186;
        }
        i;
        JVM INSTR tableswitch 0 2: default 100
    //                   0 138
    //                   1 154
    //                   2 170;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_170;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        Object obj = null;
_L7:
        mTabHostItems[i] = ((View) (obj));
        ((TextView) (obj)).setOnClickListener(this);
        ((TextView) (obj)).setText(((FragmentTab)mFragmentTabs.get(i)).a);
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        obj = (TextView)mTabHost.findViewById(0x7f0a015e);
          goto _L7
_L3:
        obj = (TextView)mTabHost.findViewById(0x7f0a015f);
          goto _L7
        obj = (TextView)mTabHost.findViewById(0x7f0a0160);
          goto _L7
        mAdapter = new FragmentTabAdapter(getChildFragmentManager());
        mPager.setAdapter(mAdapter);
        a(0);
        return;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        Debug.i("TabsFragment", "OnAttach!!");
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131362142: 
            a(0);
            return;

        case 2131362143: 
            a(1);
            return;

        case 2131362144: 
            a(2);
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Debug.i("TabsFragment", "OnCreate!!");
        mFragmentTabs = new ArrayList();
        fillFragmentTabs(mFragmentTabs);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Debug.i("TabsFragment", "OnCreateView!!");
        return layoutinflater.inflate(inflateLayout(), viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
        Debug.i("TabsFragment", "OnDestroy!!");
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        Debug.i("TabsFragment", "OnDestroyView!!");
    }

    public void onDetach()
    {
        super.onDetach();
        Debug.i("TabsFragment", "OnDetach!!");
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        int i = mPager.getCurrentItem();
        Debug.i("TabsFragment", (new StringBuilder()).append("Save Current Item : ").append(i).toString());
        bundle.putInt("CurrentTab", i);
    }

    public void onViewStateRestored(Bundle bundle)
    {
        super.onViewStateRestored(bundle);
        if (bundle != null)
        {
            int i = bundle.getInt("CurrentTab", 0);
            Debug.i("TabsFragment", (new StringBuilder()).append("Restore Last Item : ").append(i).toString());
            if (i != mPager.getCurrentItem())
            {
                a(i);
            }
        }
    }

    private class FragmentTab
    {

        String a;
        Class b;
        Bundle c;
        final TabsFragment d;

        public FragmentTab()
        {
            d = TabsFragment.this;
            super();
        }

        public FragmentTab(String s, Class class1, Bundle bundle)
        {
            d = TabsFragment.this;
            super();
            a = s;
            b = class1;
            c = bundle;
        }
    }


    private class FragmentTabAdapter extends FragmentPagerAdapter
    {

        final TabsFragment a;

        public int getCount()
        {
            return a.mFragmentTabs.size();
        }

        public Fragment getItem(int i)
        {
            FragmentTab fragmenttab = (FragmentTab)a.mFragmentTabs.get(i);
            return Fragment.instantiate(a.getActivity(), fragmenttab.b.getName(), fragmenttab.c);
        }

        public CharSequence getPageTitle(int i)
        {
            return ((FragmentTab)a.mFragmentTabs.get(i)).a;
        }

        public FragmentTabAdapter(FragmentManager fragmentmanager)
        {
            a = TabsFragment.this;
            super(fragmentmanager);
        }
    }

}
