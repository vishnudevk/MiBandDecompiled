// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.internal;


class a
{

    static final int a[];

    static 
    {
        a = new int[com.handmark.pulltorefresh.library.PullToRefreshBase.Mode.values().length];
        try
        {
            a[com.handmark.pulltorefresh.library.PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[com.handmark.pulltorefresh.library.PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1)
        {
            return;
        }
    }
}
