// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshBase, p

public class PullToRefreshScrollView extends PullToRefreshBase
{

    public PullToRefreshScrollView(Context context)
    {
        super(context);
    }

    public PullToRefreshScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PullToRefreshScrollView(Context context, PullToRefreshBase.Mode mode)
    {
        super(context, mode);
    }

    public PullToRefreshScrollView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationstyle)
    {
        super(context, mode, animationstyle);
    }

    protected volatile View createRefreshableView(Context context, AttributeSet attributeset)
    {
        return createRefreshableView(context, attributeset);
    }

    protected ScrollView createRefreshableView(Context context, AttributeSet attributeset)
    {
        Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            obj = new p(this, context, attributeset);
        } else
        {
            obj = new ScrollView(context, attributeset);
        }
        ((ScrollView) (obj)).setId(0x7f0a0022);
        return ((ScrollView) (obj));
    }

    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
    {
        return PullToRefreshBase.Orientation.VERTICAL;
    }

    protected boolean isReadyForPullEnd()
    {
        View view = ((ScrollView)l).getChildAt(0);
        if (view != null)
        {
            return ((ScrollView)l).getScrollY() >= view.getHeight() - getHeight();
        } else
        {
            return false;
        }
    }

    protected boolean isReadyForPullStart()
    {
        return ((ScrollView)l).getScrollY() == 0;
    }
}
