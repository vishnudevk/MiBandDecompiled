// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

// Referenced classes of package android.support.v4.app:
//            Fragment, H, I

public class ListFragment extends Fragment
{

    static final int a = 0xff0001;
    static final int b = 0xff0002;
    static final int c = 0xff0003;
    CharSequence ae;
    boolean af;
    private final Handler ag = new Handler();
    private final Runnable ah = new H(this);
    private final android.widget.AdapterView.OnItemClickListener ai = new I(this);
    ListAdapter d;
    ListView e;
    View f;
    TextView g;
    View h;
    View i;

    public ListFragment()
    {
    }

    private void a(boolean flag, boolean flag1)
    {
        l();
        if (h == null)
        {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (af == flag)
        {
            return;
        }
        af = flag;
        if (flag)
        {
            if (flag1)
            {
                h.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0001));
                i.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0000));
            } else
            {
                h.clearAnimation();
                i.clearAnimation();
            }
            h.setVisibility(8);
            i.setVisibility(0);
            return;
        }
        if (flag1)
        {
            h.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0000));
            i.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0001));
        } else
        {
            h.clearAnimation();
            i.clearAnimation();
        }
        h.setVisibility(0);
        i.setVisibility(8);
    }

    private void l()
    {
        if (e != null)
        {
            return;
        }
        View view = getView();
        if (view == null)
        {
            throw new IllegalStateException("Content view not yet created");
        }
        if (view instanceof ListView)
        {
            e = (ListView)view;
        } else
        {
            g = (TextView)view.findViewById(0xff0001);
            View view1;
            if (g == null)
            {
                f = view.findViewById(0x1020004);
            } else
            {
                g.setVisibility(8);
            }
            h = view.findViewById(0xff0002);
            i = view.findViewById(0xff0003);
            view1 = view.findViewById(0x102000a);
            if (!(view1 instanceof ListView))
            {
                if (view1 == null)
                {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                } else
                {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
            }
            e = (ListView)view1;
            if (f != null)
            {
                e.setEmptyView(f);
            } else
            if (ae != null)
            {
                g.setText(ae);
                e.setEmptyView(g);
            }
        }
        af = true;
        e.setOnItemClickListener(ai);
        if (d != null)
        {
            ListAdapter listadapter = d;
            d = null;
            setListAdapter(listadapter);
        } else
        if (h != null)
        {
            a(false, false);
        }
        ag.post(ah);
    }

    public ListAdapter getListAdapter()
    {
        return d;
    }

    public ListView getListView()
    {
        l();
        return e;
    }

    public long getSelectedItemId()
    {
        l();
        return e.getSelectedItemId();
    }

    public int getSelectedItemPosition()
    {
        l();
        return e.getSelectedItemPosition();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        FragmentActivity fragmentactivity = getActivity();
        FrameLayout framelayout = new FrameLayout(fragmentactivity);
        LinearLayout linearlayout = new LinearLayout(fragmentactivity);
        linearlayout.setId(0xff0002);
        linearlayout.setOrientation(1);
        linearlayout.setVisibility(8);
        linearlayout.setGravity(17);
        linearlayout.addView(new ProgressBar(fragmentactivity, null, 0x101007a), new android.widget.FrameLayout.LayoutParams(-2, -2));
        framelayout.addView(linearlayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
        FrameLayout framelayout1 = new FrameLayout(fragmentactivity);
        framelayout1.setId(0xff0003);
        TextView textview = new TextView(getActivity());
        textview.setId(0xff0001);
        textview.setGravity(17);
        framelayout1.addView(textview, new android.widget.FrameLayout.LayoutParams(-1, -1));
        ListView listview = new ListView(getActivity());
        listview.setId(0x102000a);
        listview.setDrawSelectorOnTop(false);
        framelayout1.addView(listview, new android.widget.FrameLayout.LayoutParams(-1, -1));
        framelayout.addView(framelayout1, new android.widget.FrameLayout.LayoutParams(-1, -1));
        framelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        return framelayout;
    }

    public void onDestroyView()
    {
        ag.removeCallbacks(ah);
        e = null;
        af = false;
        i = null;
        h = null;
        f = null;
        g = null;
        super.onDestroyView();
    }

    public void onListItemClick(ListView listview, View view, int j, long l1)
    {
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        l();
    }

    public void setEmptyText(CharSequence charsequence)
    {
        l();
        if (g == null)
        {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        g.setText(charsequence);
        if (ae == null)
        {
            e.setEmptyView(g);
        }
        ae = charsequence;
    }

    public void setListAdapter(ListAdapter listadapter)
    {
        boolean flag;
        if (d != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = listadapter;
        if (e != null)
        {
            e.setAdapter(listadapter);
            if (!af && !flag)
            {
                android.os.IBinder ibinder = getView().getWindowToken();
                boolean flag1 = false;
                if (ibinder != null)
                {
                    flag1 = true;
                }
                a(true, flag1);
            }
        }
    }

    public void setListShown(boolean flag)
    {
        a(flag, true);
    }

    public void setListShownNoAnimation(boolean flag)
    {
        a(flag, false);
    }

    public void setSelection(int j)
    {
        l();
        e.setSelection(j);
    }
}
