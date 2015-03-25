// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            OverscrollHelper, PullToRefreshScrollView

final class p extends ScrollView
{

    final PullToRefreshScrollView a;

    public p(PullToRefreshScrollView pulltorefreshscrollview, Context context, AttributeSet attributeset)
    {
        a = pulltorefreshscrollview;
        super(context, attributeset);
    }

    private int a()
    {
        int i = getChildCount();
        int j = 0;
        if (i > 0)
        {
            j = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
        }
        return j;
    }

    protected boolean overScrollBy(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag)
    {
        boolean flag1 = super.overScrollBy(i, j, k, l, i1, j1, k1, l1, flag);
        OverscrollHelper.overScrollBy(a, i, k, j, l, a(), flag);
        return flag1;
    }
}
