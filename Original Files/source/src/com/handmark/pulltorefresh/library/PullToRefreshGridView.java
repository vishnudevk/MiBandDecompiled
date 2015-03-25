// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshAdapterViewBase, l, k

public class PullToRefreshGridView extends PullToRefreshAdapterViewBase
{

    public PullToRefreshGridView(Context context)
    {
        super(context);
    }

    public PullToRefreshGridView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PullToRefreshGridView(Context context, PullToRefreshBase.Mode mode)
    {
        super(context, mode);
    }

    public PullToRefreshGridView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationstyle)
    {
        super(context, mode, animationstyle);
    }

    protected volatile View createRefreshableView(Context context, AttributeSet attributeset)
    {
        return createRefreshableView(context, attributeset);
    }

    protected final GridView createRefreshableView(Context context, AttributeSet attributeset)
    {
        Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            obj = new l(this, context, attributeset);
        } else
        {
            obj = new k(this, context, attributeset);
        }
        ((GridView) (obj)).setId(0x7f0a0021);
        return ((GridView) (obj));
    }

    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
    {
        return PullToRefreshBase.Orientation.VERTICAL;
    }
}
