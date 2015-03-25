// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            i, OverscrollHelper, PullToRefreshExpandableListView

final class j extends i
{

    final PullToRefreshExpandableListView b;

    public j(PullToRefreshExpandableListView pulltorefreshexpandablelistview, Context context, AttributeSet attributeset)
    {
        b = pulltorefreshexpandablelistview;
        super(pulltorefreshexpandablelistview, context, attributeset);
    }

    protected boolean overScrollBy(int k, int l, int i1, int j1, int k1, int l1, int i2, 
            int j2, boolean flag)
    {
        boolean flag1 = super.overScrollBy(k, l, i1, j1, k1, l1, i2, j2, flag);
        OverscrollHelper.overScrollBy(b, k, i1, l, j1, flag);
        return flag1;
    }
}
