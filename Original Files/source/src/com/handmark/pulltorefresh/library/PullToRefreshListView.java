// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshAdapterViewBase, o, LoadingLayoutProxy, n

public class PullToRefreshListView extends PullToRefreshAdapterViewBase
{

    private LoadingLayout m;
    private LoadingLayout n;
    private FrameLayout o;
    private boolean p;

    public PullToRefreshListView(Context context)
    {
        super(context);
    }

    public PullToRefreshListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PullToRefreshListView(Context context, PullToRefreshBase.Mode mode)
    {
        super(context, mode);
    }

    public PullToRefreshListView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationstyle)
    {
        super(context, mode, animationstyle);
    }

    static FrameLayout a(PullToRefreshListView pulltorefreshlistview)
    {
        return pulltorefreshlistview.o;
    }

    protected ListView createListView(Context context, AttributeSet attributeset)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            return new o(this, context, attributeset);
        } else
        {
            return new InternalListView(context, attributeset);
        }
    }

    protected LoadingLayoutProxy createLoadingLayoutProxy(boolean flag, boolean flag1)
    {
        LoadingLayoutProxy loadinglayoutproxy = super.createLoadingLayoutProxy(flag, flag1);
        if (p)
        {
            PullToRefreshBase.Mode mode = getMode();
            if (flag && mode.showHeaderLoadingLayout())
            {
                loadinglayoutproxy.addLayout(m);
            }
            if (flag1 && mode.showFooterLoadingLayout())
            {
                loadinglayoutproxy.addLayout(n);
            }
        }
        return loadinglayoutproxy;
    }

    protected volatile View createRefreshableView(Context context, AttributeSet attributeset)
    {
        return createRefreshableView(context, attributeset);
    }

    protected ListView createRefreshableView(Context context, AttributeSet attributeset)
    {
        ListView listview = createListView(context, attributeset);
        listview.setId(0x102000a);
        return listview;
    }

    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
    {
        return PullToRefreshBase.Orientation.VERTICAL;
    }

    protected void handleStyledAttributes(TypedArray typedarray)
    {
        super.handleStyledAttributes(typedarray);
        p = typedarray.getBoolean(14, true);
        if (p)
        {
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -2, 1);
            FrameLayout framelayout = new FrameLayout(getContext());
            m = createLoadingLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START, typedarray);
            m.setVisibility(8);
            framelayout.addView(m, layoutparams);
            ((ListView)l).addHeaderView(framelayout, null, false);
            o = new FrameLayout(getContext());
            n = createLoadingLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END, typedarray);
            n.setVisibility(8);
            o.addView(n, layoutparams);
            if (!typedarray.hasValue(13))
            {
                setScrollingWhileRefreshingEnabled(true);
            }
        }
    }

    protected void onRefreshing(boolean flag)
    {
        ListAdapter listadapter = ((ListView)l).getAdapter();
        if (p && getShowViewWhileRefreshing() && listadapter != null && !listadapter.isEmpty()) goto _L2; else goto _L1
_L1:
        super.onRefreshing(flag);
_L4:
        return;
_L2:
        LoadingLayout loadinglayout;
        LoadingLayout loadinglayout1;
        LoadingLayout loadinglayout2;
        int i;
        int j;
        super.onRefreshing(false);
        switch (n.a[getCurrentMode().ordinal()])
        {
        default:
            LoadingLayout loadinglayout3 = getHeaderLayout();
            LoadingLayout loadinglayout4 = m;
            LoadingLayout loadinglayout5 = n;
            j = getScrollY() + getHeaderSize();
            loadinglayout = loadinglayout3;
            loadinglayout1 = loadinglayout4;
            loadinglayout2 = loadinglayout5;
            i = 0;
            break;

        case 1: // '\001'
        case 2: // '\002'
            break; /* Loop/switch isn't completed */
        }
_L5:
        loadinglayout.reset();
        loadinglayout.hideAllViews();
        loadinglayout2.setVisibility(8);
        loadinglayout1.setVisibility(0);
        loadinglayout1.refreshing();
        if (flag)
        {
            disableLoadingLayoutVisibilityChanges();
            setHeaderScroll(j);
            ((ListView)l).setSelection(i);
            smoothScrollTo(0);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        loadinglayout = getFooterLayout();
        loadinglayout1 = n;
        loadinglayout2 = m;
        i = -1 + ((ListView)l).getCount();
        j = getScrollY() - getFooterSize();
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    protected void onReset()
    {
        int i;
        int j;
        i = 0;
        j = 1;
        if (!p)
        {
            super.onReset();
            return;
        }
        n.a[getCurrentMode().ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 158
    //                   2 158;
           goto _L1 _L2 _L2
_L1:
        LoadingLayout loadinglayout4 = getHeaderLayout();
        LoadingLayout loadinglayout5 = m;
        int k1 = -getHeaderSize();
        LoadingLayout loadinglayout;
        LoadingLayout loadinglayout1;
        int k;
        int l;
        int i1;
        int j1;
        LoadingLayout loadinglayout2;
        LoadingLayout loadinglayout3;
        if (Math.abs(((ListView)this.l).getFirstVisiblePosition() - 0) > j)
        {
            j = 0;
        }
        i1 = j;
        j1 = k1;
        loadinglayout2 = loadinglayout5;
        loadinglayout3 = loadinglayout4;
_L4:
        if (loadinglayout2.getVisibility() == 0)
        {
            loadinglayout3.showInvisibleViews();
            loadinglayout2.setVisibility(8);
            if (i1 != 0 && getState() != PullToRefreshBase.State.MANUAL_REFRESHING)
            {
                ((ListView)this.l).setSelection(i);
                setHeaderScroll(j1);
            }
        }
        super.onReset();
        return;
_L2:
        loadinglayout = getFooterLayout();
        loadinglayout1 = n;
        k = -1 + ((ListView)this.l).getCount();
        l = getFooterSize();
        if (Math.abs(((ListView)this.l).getLastVisiblePosition() - k) <= j)
        {
            i1 = j;
        } else
        {
            i1 = 0;
        }
        i = k;
        j1 = l;
        loadinglayout2 = loadinglayout1;
        loadinglayout3 = loadinglayout;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private class InternalListView extends ListView
        implements EmptyViewMethodAccessor
    {

        final PullToRefreshListView a;
        private boolean b;

        protected void dispatchDraw(Canvas canvas)
        {
            try
            {
                super.dispatchDraw(canvas);
                return;
            }
            catch (IndexOutOfBoundsException indexoutofboundsexception)
            {
                indexoutofboundsexception.printStackTrace();
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionevent)
        {
            boolean flag;
            try
            {
                flag = super.dispatchTouchEvent(motionevent);
            }
            catch (IndexOutOfBoundsException indexoutofboundsexception)
            {
                indexoutofboundsexception.printStackTrace();
                return false;
            }
            return flag;
        }

        public volatile void setAdapter(Adapter adapter)
        {
            setAdapter((ListAdapter)adapter);
        }

        public void setAdapter(ListAdapter listadapter)
        {
            if (PullToRefreshListView.a(a) != null && !b)
            {
                addFooterView(PullToRefreshListView.a(a), null, false);
                b = true;
            }
            super.setAdapter(listadapter);
        }

        public void setEmptyView(View view)
        {
            a.setEmptyView(view);
        }

        public void setEmptyViewInternal(View view)
        {
            super.setEmptyView(view);
        }

        public InternalListView(Context context, AttributeSet attributeset)
        {
            a = PullToRefreshListView.this;
            super(context, attributeset);
            b = false;
        }
    }

}
