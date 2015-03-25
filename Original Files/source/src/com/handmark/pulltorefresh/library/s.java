// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.webkit.WebView;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshWebView, OverscrollHelper

final class s extends WebView
{

    static final int a = 2;
    static final float b = 1.5F;
    final PullToRefreshWebView c;

    public s(PullToRefreshWebView pulltorefreshwebview, Context context, AttributeSet attributeset)
    {
        c = pulltorefreshwebview;
        super(context, attributeset);
    }

    private int a()
    {
        return (int)Math.max(0.0F, FloatMath.floor((float)((WebView)c.l).getContentHeight() * ((WebView)c.l).getScale()) - (float)(getHeight() - getPaddingBottom() - getPaddingTop()));
    }

    protected boolean overScrollBy(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag)
    {
        boolean flag1 = super.overScrollBy(i, j, k, l, i1, j1, k1, l1, flag);
        OverscrollHelper.overScrollBy(c, i, k, j, l, a(), 2, 1.5F, flag);
        return flag1;
    }
}
