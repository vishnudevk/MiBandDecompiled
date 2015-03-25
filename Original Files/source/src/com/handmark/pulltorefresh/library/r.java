// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshWebView

class r extends WebChromeClient
{

    final PullToRefreshWebView a;

    r(PullToRefreshWebView pulltorefreshwebview)
    {
        a = pulltorefreshwebview;
        super();
    }

    public void onProgressChanged(WebView webview, int i)
    {
        if (i == 100)
        {
            a.onRefreshComplete();
        }
    }
}
