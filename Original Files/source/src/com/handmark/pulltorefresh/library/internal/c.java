// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.internal;


class c
{

    static final int a[];
    static final int b[];

    static 
    {
        b = new int[com.handmark.pulltorefresh.library.PullToRefreshBase.Mode.values().length];
        try
        {
            b[com.handmark.pulltorefresh.library.PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            b[com.handmark.pulltorefresh.library.PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        a = new int[com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation.values().length];
        try
        {
            a[com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3)
        {
            return;
        }
    }
}
