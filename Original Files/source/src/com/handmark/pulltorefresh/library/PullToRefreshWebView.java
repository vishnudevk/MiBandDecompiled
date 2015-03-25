// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshBase, q, r, s

public class PullToRefreshWebView extends PullToRefreshBase
{

    private static final PullToRefreshBase.OnRefreshListener m = new q();
    private final WebChromeClient n;

    public PullToRefreshWebView(Context context)
    {
        super(context);
        n = new r(this);
        setOnRefreshListener(m);
        ((WebView)l).setWebChromeClient(n);
    }

    public PullToRefreshWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        n = new r(this);
        setOnRefreshListener(m);
        ((WebView)l).setWebChromeClient(n);
    }

    public PullToRefreshWebView(Context context, PullToRefreshBase.Mode mode)
    {
        super(context, mode);
        n = new r(this);
        setOnRefreshListener(m);
        ((WebView)l).setWebChromeClient(n);
    }

    public PullToRefreshWebView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationstyle)
    {
        super(context, mode, animationstyle);
        n = new r(this);
        setOnRefreshListener(m);
        ((WebView)l).setWebChromeClient(n);
    }

    protected volatile View createRefreshableView(Context context, AttributeSet attributeset)
    {
        return createRefreshableView(context, attributeset);
    }

    protected WebView createRefreshableView(Context context, AttributeSet attributeset)
    {
        Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            obj = new s(this, context, attributeset);
        } else
        {
            obj = new WebView(context, attributeset);
        }
        ((WebView) (obj)).setId(0x7f0a0023);
        return ((WebView) (obj));
    }

    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
    {
        return PullToRefreshBase.Orientation.VERTICAL;
    }

    protected boolean isReadyForPullEnd()
    {
        float f = FloatMath.floor((float)((WebView)l).getContentHeight() * ((WebView)l).getScale());
        return (float)((WebView)l).getScrollY() >= f - (float)((WebView)l).getHeight();
    }

    protected boolean isReadyForPullStart()
    {
        return ((WebView)l).getScrollY() == 0;
    }

    protected void onPtrRestoreInstanceState(Bundle bundle)
    {
        super.onPtrRestoreInstanceState(bundle);
        ((WebView)l).restoreState(bundle);
    }

    protected void onPtrSaveInstanceState(Bundle bundle)
    {
        super.onPtrSaveInstanceState(bundle);
        ((WebView)l).saveState(bundle);
    }

}
