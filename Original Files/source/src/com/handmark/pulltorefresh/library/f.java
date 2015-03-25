// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;


class f
{

    static final int a[];
    static final int b[];
    static final int c[];
    static final int d[];

    static 
    {
        d = new int[PullToRefreshBase.AnimationStyle.values().length];
        try
        {
            d[PullToRefreshBase.AnimationStyle.ROTATE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            d[PullToRefreshBase.AnimationStyle.FLIP.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        c = new int[PullToRefreshBase.Mode.values().length];
        try
        {
            c[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            c[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            c[PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            c[PullToRefreshBase.Mode.BOTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        b = new int[PullToRefreshBase.State.values().length];
        try
        {
            b[PullToRefreshBase.State.RESET.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            b[PullToRefreshBase.State.PULL_TO_REFRESH.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            b[PullToRefreshBase.State.RELEASE_TO_REFRESH.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            b[PullToRefreshBase.State.REFRESHING.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            b[PullToRefreshBase.State.MANUAL_REFRESHING.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            b[PullToRefreshBase.State.OVERSCROLLING.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        a = new int[PullToRefreshBase.Orientation.values().length];
        try
        {
            a[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror13)
        {
            return;
        }
    }
}
