// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;


// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshBase

class d
    implements Runnable
{

    final PullToRefreshBase a;

    d(PullToRefreshBase pulltorefreshbase)
    {
        a = pulltorefreshbase;
        super();
    }

    public void run()
    {
        a.requestLayout();
    }
}
