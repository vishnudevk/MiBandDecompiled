// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;


class a
{

    static final int a[];

    static 
    {
        a = new int[PullToRefreshBase.Orientation.values().length];
        try
        {
            a[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1)
        {
            return;
        }
    }
}
