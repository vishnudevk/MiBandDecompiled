// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.AbsListView;
import android.widget.ListView;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            SlidingUpPanelLayout

public class MyListView extends ListView
    implements android.widget.AbsListView.OnScrollListener
{

    private static final int MAX_Y_OVERSCROLL_DISTANCE = 200;
    private Boolean disableDrag;
    private Context mContext;
    private int mMaxYOverscrollDistance;
    private SlidingUpPanelLayout parentPanelLayout;

    public MyListView(Context context)
    {
        super(context);
        parentPanelLayout = null;
        disableDrag = Boolean.valueOf(false);
        mContext = context;
        initBounceListView();
    }

    public MyListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        parentPanelLayout = null;
        disableDrag = Boolean.valueOf(false);
        mContext = context;
        initBounceListView();
    }

    public MyListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        parentPanelLayout = null;
        disableDrag = Boolean.valueOf(false);
        mContext = context;
        initBounceListView();
    }

    private void initBounceListView()
    {
        mMaxYOverscrollDistance = (int)(200F * mContext.getResources().getDisplayMetrics().density);
        super.setOnScrollListener(this);
    }

    public Boolean getDisableDrag()
    {
        return disableDrag;
    }

    public SlidingUpPanelLayout getParentPanelLayout()
    {
        return parentPanelLayout;
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (parentPanelLayout != null && !parentPanelLayout.isCollapsed())
        {
            parentPanelLayout.setSlidingEnabled(false);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    protected boolean overScrollBy(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag)
    {
        if (!disableDrag.booleanValue() && j < 0)
        {
            parentPanelLayout.setSlidingEnabled(true);
        }
        return super.overScrollBy(i, j, k, l, i1, j1, k1, mMaxYOverscrollDistance, flag);
    }

    public void setDisableDrag(Boolean boolean1)
    {
        disableDrag = boolean1;
    }

    public void setParentPanelLayout(SlidingUpPanelLayout slidinguppanellayout)
    {
        parentPanelLayout = slidinguppanellayout;
    }
}
