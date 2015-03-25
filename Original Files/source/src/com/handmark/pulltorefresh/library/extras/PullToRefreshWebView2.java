// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.extras;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import com.handmark.pulltorefresh.library.PullToRefreshWebView;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.handmark.pulltorefresh.library.extras:
//            a

public class PullToRefreshWebView2 extends PullToRefreshWebView
{

    static final String m = "ptr";
    static final String n = "javascript:isReadyForPullDown();";
    static final String o = "javascript:isReadyForPullUp();";
    private a p;
    private final AtomicBoolean q;
    private final AtomicBoolean r;

    public PullToRefreshWebView2(Context context)
    {
        super(context);
        q = new AtomicBoolean(false);
        r = new AtomicBoolean(false);
    }

    public PullToRefreshWebView2(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        q = new AtomicBoolean(false);
        r = new AtomicBoolean(false);
    }

    public PullToRefreshWebView2(Context context, com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mode)
    {
        super(context, mode);
        q = new AtomicBoolean(false);
        r = new AtomicBoolean(false);
    }

    static AtomicBoolean a(PullToRefreshWebView2 pulltorefreshwebview2)
    {
        return pulltorefreshwebview2.r;
    }

    static AtomicBoolean b(PullToRefreshWebView2 pulltorefreshwebview2)
    {
        return pulltorefreshwebview2.q;
    }

    protected volatile View createRefreshableView(Context context, AttributeSet attributeset)
    {
        return createRefreshableView(context, attributeset);
    }

    protected WebView createRefreshableView(Context context, AttributeSet attributeset)
    {
        WebView webview = super.createRefreshableView(context, attributeset);
        p = new a(this);
        webview.addJavascriptInterface(p, "ptr");
        return webview;
    }

    protected boolean isReadyForPullEnd()
    {
        ((WebView)getRefreshableView()).loadUrl("javascript:isReadyForPullUp();");
        return r.get();
    }

    protected boolean isReadyForPullStart()
    {
        ((WebView)getRefreshableView()).loadUrl("javascript:isReadyForPullDown();");
        return q.get();
    }
}
