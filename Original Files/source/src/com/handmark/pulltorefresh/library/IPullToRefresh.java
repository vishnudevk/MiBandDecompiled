// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.view.View;
import android.view.animation.Interpolator;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            ILoadingLayout

public interface IPullToRefresh
{

    public abstract boolean demo();

    public abstract PullToRefreshBase.Mode getCurrentMode();

    public abstract boolean getFilterTouchEvents();

    public abstract ILoadingLayout getLoadingLayoutProxy();

    public abstract ILoadingLayout getLoadingLayoutProxy(boolean flag, boolean flag1);

    public abstract PullToRefreshBase.Mode getMode();

    public abstract View getRefreshableView();

    public abstract boolean getShowViewWhileRefreshing();

    public abstract PullToRefreshBase.State getState();

    public abstract boolean isPullToRefreshEnabled();

    public abstract boolean isPullToRefreshOverScrollEnabled();

    public abstract boolean isRefreshing();

    public abstract boolean isScrollingWhileRefreshingEnabled();

    public abstract void onRefreshComplete();

    public abstract void setFilterTouchEvents(boolean flag);

    public abstract void setMode(PullToRefreshBase.Mode mode);

    public abstract void setOnPullEventListener(PullToRefreshBase.OnPullEventListener onpulleventlistener);

    public abstract void setOnRefreshListener(PullToRefreshBase.OnRefreshListener2 onrefreshlistener2);

    public abstract void setOnRefreshListener(PullToRefreshBase.OnRefreshListener onrefreshlistener);

    public abstract void setPullToRefreshOverScrollEnabled(boolean flag);

    public abstract void setRefreshing();

    public abstract void setRefreshing(boolean flag);

    public abstract void setScrollAnimationInterpolator(Interpolator interpolator);

    public abstract void setScrollingWhileRefreshingEnabled(boolean flag);

    public abstract void setShowViewWhileRefreshing(boolean flag);
}
