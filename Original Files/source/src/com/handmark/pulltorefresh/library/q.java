// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.webkit.WebView;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshBase

final class q
    implements PullToRefreshBase.OnRefreshListener
{

    q()
    {
    }

    public void onRefresh(PullToRefreshBase pulltorefreshbase)
    {
        ((WebView)pulltorefreshbase.getRefreshableView()).reload();
    }
}
