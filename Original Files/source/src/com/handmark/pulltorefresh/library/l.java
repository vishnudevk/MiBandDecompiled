// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            k, OverscrollHelper, PullToRefreshGridView

final class l extends k
{

    final PullToRefreshGridView b;

    public l(PullToRefreshGridView pulltorefreshgridview, Context context, AttributeSet attributeset)
    {
        b = pulltorefreshgridview;
        super(pulltorefreshgridview, context, attributeset);
    }

    protected boolean overScrollBy(int i, int j, int i1, int j1, int k1, int l1, int i2, 
            int j2, boolean flag)
    {
        boolean flag1 = super.overScrollBy(i, j, i1, j1, k1, l1, i2, j2, flag);
        OverscrollHelper.overScrollBy(b, i, i1, j, j1, flag);
        return flag1;
    }
}
