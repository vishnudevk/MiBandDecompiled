// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshBase, m

public class PullToRefreshHorizontalScrollView extends PullToRefreshBase
{

    public PullToRefreshHorizontalScrollView(Context context)
    {
        super(context);
    }

    public PullToRefreshHorizontalScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PullToRefreshHorizontalScrollView(Context context, PullToRefreshBase.Mode mode)
    {
        super(context, mode);
    }

    public PullToRefreshHorizontalScrollView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationstyle)
    {
        super(context, mode, animationstyle);
    }

    protected volatile View createRefreshableView(Context context, AttributeSet attributeset)
    {
        return createRefreshableView(context, attributeset);
    }

    protected HorizontalScrollView createRefreshableView(Context context, AttributeSet attributeset)
    {
        Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            obj = new m(this, context, attributeset);
        } else
        {
            obj = new HorizontalScrollView(context, attributeset);
        }
        ((HorizontalScrollView) (obj)).setId(0x7f0a0022);
        return ((HorizontalScrollView) (obj));
    }

    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
    {
        return PullToRefreshBase.Orientation.HORIZONTAL;
    }

    protected boolean isReadyForPullEnd()
    {
        View view = ((HorizontalScrollView)l).getChildAt(0);
        if (view != null)
        {
            return ((HorizontalScrollView)l).getScrollX() >= view.getWidth() - getWidth();
        } else
        {
            return false;
        }
    }

    protected boolean isReadyForPullStart()
    {
        return ((HorizontalScrollView)l).getScrollX() == 0;
    }
}
