// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            OverscrollHelper, PullToRefreshListView

final class o extends PullToRefreshListView.InternalListView
{

    final PullToRefreshListView b;

    public o(PullToRefreshListView pulltorefreshlistview, Context context, AttributeSet attributeset)
    {
        b = pulltorefreshlistview;
        super(pulltorefreshlistview, context, attributeset);
    }

    protected boolean overScrollBy(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag)
    {
        boolean flag1 = super.overScrollBy(i, j, k, l, i1, j1, k1, l1, flag);
        OverscrollHelper.overScrollBy(b, i, k, j, l, flag);
        return flag1;
    }
}
