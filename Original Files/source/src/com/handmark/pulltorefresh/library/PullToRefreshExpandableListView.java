// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshAdapterViewBase, j, i

public class PullToRefreshExpandableListView extends PullToRefreshAdapterViewBase
{

    public PullToRefreshExpandableListView(Context context)
    {
        super(context);
    }

    public PullToRefreshExpandableListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PullToRefreshExpandableListView(Context context, PullToRefreshBase.Mode mode)
    {
        super(context, mode);
    }

    public PullToRefreshExpandableListView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationstyle)
    {
        super(context, mode, animationstyle);
    }

    protected volatile View createRefreshableView(Context context, AttributeSet attributeset)
    {
        return createRefreshableView(context, attributeset);
    }

    protected ExpandableListView createRefreshableView(Context context, AttributeSet attributeset)
    {
        Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            obj = new j(this, context, attributeset);
        } else
        {
            obj = new i(this, context, attributeset);
        }
        ((ExpandableListView) (obj)).setId(0x102000a);
        return ((ExpandableListView) (obj));
    }

    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
    {
        return PullToRefreshBase.Orientation.VERTICAL;
    }
}
