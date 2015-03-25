// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.handmark.pulltorefresh.library.internal.IndicatorLayout;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshBase, b

public abstract class PullToRefreshAdapterViewBase extends PullToRefreshBase
    implements android.widget.AbsListView.OnScrollListener
{

    private boolean m;
    private android.widget.AbsListView.OnScrollListener n;
    private PullToRefreshBase.OnLastItemVisibleListener o;
    private View p;
    private IndicatorLayout q;
    private IndicatorLayout r;
    private boolean s;
    private boolean t;

    public PullToRefreshAdapterViewBase(Context context)
    {
        super(context);
        t = true;
        ((AbsListView)l).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        t = true;
        ((AbsListView)l).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, PullToRefreshBase.Mode mode)
    {
        super(context, mode);
        t = true;
        ((AbsListView)l).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationstyle)
    {
        super(context, mode, animationstyle);
        t = true;
        ((AbsListView)l).setOnScrollListener(this);
    }

    private static android.widget.FrameLayout.LayoutParams a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        android.widget.FrameLayout.LayoutParams layoutparams1;
label0:
        {
            layoutparams1 = null;
            if (layoutparams != null)
            {
                layoutparams1 = new android.widget.FrameLayout.LayoutParams(layoutparams);
                if (!(layoutparams instanceof android.widget.LinearLayout.LayoutParams))
                {
                    break label0;
                }
                layoutparams1.gravity = ((android.widget.LinearLayout.LayoutParams)layoutparams).gravity;
            }
            return layoutparams1;
        }
        layoutparams1.gravity = 17;
        return layoutparams1;
    }

    private void a()
    {
        PullToRefreshBase.Mode mode;
        FrameLayout framelayout;
        mode = getMode();
        framelayout = getRefreshableViewWrapper();
        if (!mode.showHeaderLoadingLayout() || q != null) goto _L2; else goto _L1
_L1:
        q = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START);
        android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutparams1.rightMargin = getResources().getDimensionPixelSize(0x7f0b0030);
        layoutparams1.gravity = 53;
        framelayout.addView(q, layoutparams1);
_L8:
        if (!mode.showFooterLoadingLayout() || r != null) goto _L4; else goto _L3
_L3:
        r = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END);
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutparams.rightMargin = getResources().getDimensionPixelSize(0x7f0b0030);
        layoutparams.gravity = 85;
        framelayout.addView(r, layoutparams);
_L6:
        return;
_L2:
        if (!mode.showHeaderLoadingLayout() && q != null)
        {
            framelayout.removeView(q);
            q = null;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (mode.showFooterLoadingLayout() || r == null) goto _L6; else goto _L5
_L5:
        framelayout.removeView(r);
        r = null;
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private boolean b()
    {
        return s && isPullToRefreshEnabled();
    }

    private boolean c()
    {
        Adapter adapter = ((AbsListView)l).getAdapter();
        if (adapter == null || adapter.isEmpty())
        {
            Log.d("PullToRefresh", "isFirstItemVisible. Empty View.");
            return true;
        }
        if (((AbsListView)l).getFirstVisiblePosition() <= 1)
        {
            View view = ((AbsListView)l).getChildAt(0);
            if (view != null)
            {
                return view.getTop() >= ((AbsListView)l).getTop();
            }
        }
        return false;
    }

    private boolean d()
    {
        Adapter adapter = ((AbsListView)l).getAdapter();
        if (adapter == null || adapter.isEmpty())
        {
            Log.d("PullToRefresh", "isLastItemVisible. Empty View.");
            return true;
        }
        int i = -1 + ((AbsListView)l).getCount();
        int j = ((AbsListView)l).getLastVisiblePosition();
        Log.d("PullToRefresh", (new StringBuilder()).append("isLastItemVisible. Last Item Position: ").append(i).append(" Last Visible Pos: ").append(j).toString());
        if (j >= i - 1)
        {
            int k = j - ((AbsListView)l).getFirstVisiblePosition();
            View view = ((AbsListView)l).getChildAt(k);
            if (view != null)
            {
                return view.getBottom() <= ((AbsListView)l).getBottom();
            }
        }
        return false;
    }

    private void e()
    {
        if (q != null)
        {
            getRefreshableViewWrapper().removeView(q);
            q = null;
        }
        if (r != null)
        {
            getRefreshableViewWrapper().removeView(r);
            r = null;
        }
    }

    private void f()
    {
        if (q == null) goto _L2; else goto _L1
_L1:
        if (isRefreshing() || !isReadyForPullStart()) goto _L4; else goto _L3
_L3:
        if (!q.isVisible())
        {
            q.show();
        }
_L2:
        if (r == null) goto _L6; else goto _L5
_L5:
        if (isRefreshing() || !isReadyForPullEnd()) goto _L8; else goto _L7
_L7:
        if (!r.isVisible())
        {
            r.show();
        }
_L6:
        return;
_L4:
        if (q.isVisible())
        {
            q.hide();
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (!r.isVisible()) goto _L6; else goto _L9
_L9:
        r.hide();
        return;
        if (true) goto _L2; else goto _L10
_L10:
    }

    public boolean getShowIndicator()
    {
        return s;
    }

    protected void handleStyledAttributes(TypedArray typedarray)
    {
        boolean flag;
        if (!isPullToRefreshOverScrollEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s = typedarray.getBoolean(5, flag);
    }

    protected boolean isReadyForPullEnd()
    {
        return d();
    }

    protected boolean isReadyForPullStart()
    {
        return c();
    }

    protected void onPullToRefresh()
    {
        super.onPullToRefresh();
        if (!b()) goto _L2; else goto _L1
_L1:
        b.a[getCurrentMode().ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 45
    //                   2 53;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        r.pullToRefresh();
        return;
_L4:
        q.pullToRefresh();
        return;
    }

    protected void onRefreshing(boolean flag)
    {
        super.onRefreshing(flag);
        if (b())
        {
            f();
        }
    }

    protected void onReleaseToRefresh()
    {
        super.onReleaseToRefresh();
        if (!b()) goto _L2; else goto _L1
_L1:
        b.a[getCurrentMode().ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 45
    //                   2 53;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        r.releaseToRefresh();
        return;
_L4:
        q.releaseToRefresh();
        return;
    }

    protected void onReset()
    {
        super.onReset();
        if (b())
        {
            f();
        }
    }

    public final void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        Log.d("PullToRefresh", (new StringBuilder()).append("First Visible: ").append(i).append(". Visible Count: ").append(j).append(". Total Items:").append(k).toString());
        if (o != null)
        {
            boolean flag;
            if (k > 0 && i + j >= k - 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            m = flag;
        }
        if (b())
        {
            f();
        }
        if (n != null)
        {
            n.onScroll(abslistview, i, j, k);
        }
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        if (p != null && !t)
        {
            p.scrollTo(-i, -j);
        }
    }

    public final void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (i == 0 && o != null && m)
        {
            o.onLastItemVisible();
        }
        if (n != null)
        {
            n.onScrollStateChanged(abslistview, i);
        }
    }

    public void setAdapter(ListAdapter listadapter)
    {
        ((AdapterView)l).setAdapter(listadapter);
    }

    public final void setEmptyView(View view)
    {
        FrameLayout framelayout = getRefreshableViewWrapper();
        if (view != null)
        {
            view.setClickable(true);
            android.view.ViewParent viewparent = view.getParent();
            if (viewparent != null && (viewparent instanceof ViewGroup))
            {
                ((ViewGroup)viewparent).removeView(view);
            }
            android.widget.FrameLayout.LayoutParams layoutparams = a(view.getLayoutParams());
            if (layoutparams != null)
            {
                framelayout.addView(view, layoutparams);
            } else
            {
                framelayout.addView(view);
            }
        }
        if (l instanceof EmptyViewMethodAccessor)
        {
            ((EmptyViewMethodAccessor)l).setEmptyViewInternal(view);
        } else
        {
            ((AbsListView)l).setEmptyView(view);
        }
        p = view;
    }

    public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        ((AbsListView)l).setOnItemClickListener(onitemclicklistener);
    }

    public final void setOnLastItemVisibleListener(PullToRefreshBase.OnLastItemVisibleListener onlastitemvisiblelistener)
    {
        o = onlastitemvisiblelistener;
    }

    public final void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        n = onscrolllistener;
    }

    public final void setScrollEmptyView(boolean flag)
    {
        t = flag;
    }

    public void setShowIndicator(boolean flag)
    {
        s = flag;
        if (b())
        {
            a();
            return;
        } else
        {
            e();
            return;
        }
    }

    protected void updateUIForMode()
    {
        super.updateUIForMode();
        if (b())
        {
            a();
            return;
        } else
        {
            e();
            return;
        }
    }
}
