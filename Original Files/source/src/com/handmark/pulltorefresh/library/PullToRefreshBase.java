// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;
import com.handmark.pulltorefresh.library.internal.Utils;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            IPullToRefresh, e, h, f, 
//            LoadingLayoutProxy, OverscrollHelper, c, d, 
//            ILoadingLayout, g

public abstract class PullToRefreshBase extends LinearLayout
    implements IPullToRefresh
{

    public static final int SMOOTH_SCROLL_DURATION_MS = 200;
    public static final int SMOOTH_SCROLL_LONG_DURATION_MS = 325;
    static final boolean a = true;
    static final boolean b = false;
    static final String c = "PullToRefresh";
    static final float d = 4.2F;
    static final int e = 225;
    static final String f = "ptr_state";
    static final String g = "ptr_mode";
    static final String h = "ptr_current_mode";
    static final String i = "ptr_disable_scrolling";
    static final String j = "ptr_show_refreshing_view";
    static final String k = "ptr_super";
    private boolean A;
    private Interpolator B;
    private AnimationStyle C;
    private LoadingLayout D;
    private LoadingLayout E;
    private OnRefreshListener F;
    private OnRefreshListener2 G;
    private OnPullEventListener H;
    private h I;
    View l;
    private int m;
    private float n;
    private float o;
    private float p;
    private float q;
    private boolean r;
    private State s;
    private Mode t;
    private Mode u;
    private FrameLayout v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public PullToRefreshBase(Context context)
    {
        super(context);
        r = false;
        s = State.RESET;
        t = Mode.a();
        w = true;
        x = false;
        y = true;
        z = true;
        A = true;
        C = AnimationStyle.a();
        a(context, ((AttributeSet) (null)));
    }

    public PullToRefreshBase(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        r = false;
        s = State.RESET;
        t = Mode.a();
        w = true;
        x = false;
        y = true;
        z = true;
        A = true;
        C = AnimationStyle.a();
        a(context, attributeset);
    }

    public PullToRefreshBase(Context context, Mode mode)
    {
        super(context);
        r = false;
        s = State.RESET;
        t = Mode.a();
        w = true;
        x = false;
        y = true;
        z = true;
        A = true;
        C = AnimationStyle.a();
        t = mode;
        a(context, ((AttributeSet) (null)));
    }

    public PullToRefreshBase(Context context, Mode mode, AnimationStyle animationstyle)
    {
        super(context);
        r = false;
        s = State.RESET;
        t = Mode.a();
        w = true;
        x = false;
        y = true;
        z = true;
        A = true;
        C = AnimationStyle.a();
        t = mode;
        C = animationstyle;
        a(context, ((AttributeSet) (null)));
    }

    private void a()
    {
        if (F != null)
        {
            F.onRefresh(this);
        } else
        if (G != null)
        {
            if (u == Mode.PULL_FROM_START)
            {
                G.onPullDownToRefresh(this);
                return;
            }
            if (u == Mode.PULL_FROM_END)
            {
                G.onPullUpToRefresh(this);
                return;
            }
        }
    }

    private final void a(int i1)
    {
        a(i1, 200L, 0L, ((g) (new e(this))));
    }

    private final void a(int i1, long l1)
    {
        a(i1, l1, 0L, null);
    }

    private final void a(int i1, long l1, long l2, g g1)
    {
        if (I != null)
        {
            I.a();
        }
        f.a[getPullToRefreshScrollDirection().ordinal()];
        JVM INSTR tableswitch 1 1: default 44
    //                   1 111;
           goto _L1 _L2
_L1:
        int j1 = getScrollY();
_L4:
        if (j1 != i1)
        {
            if (B == null)
            {
                B = new DecelerateInterpolator();
            }
            I = new h(this, j1, i1, l1, g1);
            if (l2 <= 0L)
            {
                break; /* Loop/switch isn't completed */
            }
            postDelayed(I, l2);
        }
        return;
_L2:
        j1 = getScrollX();
        if (true) goto _L4; else goto _L3
_L3:
        post(I);
        return;
    }

    private void a(Context context, AttributeSet attributeset)
    {
        switch (f.a[getPullToRefreshScrollDirection().ordinal()])
        {
        default:
            setOrientation(1);
            break;

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_231;
        }
_L1:
        setGravity(17);
        m = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.xiaomi.hm.health.R.styleable.PullToRefresh);
        if (typedarray.hasValue(4))
        {
            t = Mode.a(typedarray.getInteger(4, 0));
        }
        if (typedarray.hasValue(12))
        {
            C = AnimationStyle.a(typedarray.getInteger(12, 0));
        }
        l = createRefreshableView(context, attributeset);
        a(context, l);
        D = createLoadingLayout(context, Mode.PULL_FROM_START, typedarray);
        E = createLoadingLayout(context, Mode.PULL_FROM_END, typedarray);
        if (typedarray.hasValue(0))
        {
            Drawable drawable1 = typedarray.getDrawable(0);
            if (drawable1 != null)
            {
                l.setBackgroundDrawable(drawable1);
            }
        } else
        if (typedarray.hasValue(16))
        {
            Utils.warnDeprecation("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable = typedarray.getDrawable(16);
            if (drawable != null)
            {
                l.setBackgroundDrawable(drawable);
            }
        }
        if (typedarray.hasValue(9))
        {
            z = typedarray.getBoolean(9, true);
        }
        if (typedarray.hasValue(13))
        {
            x = typedarray.getBoolean(13, false);
        }
        handleStyledAttributes(typedarray);
        typedarray.recycle();
        updateUIForMode();
        return;
        setOrientation(0);
          goto _L1
    }

    private void a(Context context, View view)
    {
        v = new FrameLayout(context);
        v.addView(view, -1, -1);
        addViewInternal(v, new android.widget.LinearLayout.LayoutParams(-1, -1));
    }

    static void a(PullToRefreshBase pulltorefreshbase)
    {
        pulltorefreshbase.a();
    }

    static void a(PullToRefreshBase pulltorefreshbase, int i1, long l1, long l2, g g1)
    {
        pulltorefreshbase.a(i1, l1, l2, g1);
    }

    static Interpolator b(PullToRefreshBase pulltorefreshbase)
    {
        return pulltorefreshbase.B;
    }

    private boolean b()
    {
        f.c[t.ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 47
    //                   2 42
    //                   3 40
    //                   4 52;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        return false;
_L3:
        return isReadyForPullStart();
_L2:
        return isReadyForPullEnd();
_L4:
        if (isReadyForPullEnd() || isReadyForPullStart())
        {
            return true;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void c()
    {
        f.a[getPullToRefreshScrollDirection().ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 183;
           goto _L1 _L2
_L1:
        float f1;
        float f2;
        f1 = q;
        f2 = o;
_L15:
        f.c[u.ordinal()];
        JVM INSTR tableswitch 1 1: default 68
    //                   1 196;
           goto _L3 _L4
_L3:
        int i1;
        int j1;
        i1 = Math.round(Math.min(f1 - f2, 0.0F) / 4.2F);
        j1 = getHeaderSize();
_L11:
        setHeaderScroll(i1);
        if (i1 == 0 || isRefreshing()) goto _L6; else goto _L5
_L5:
        float f3 = (float)Math.abs(i1) / (float)j1;
        f.c[u.ordinal()];
        JVM INSTR tableswitch 1 1: default 144
    //                   1 219;
           goto _L7 _L8
_L7:
        D.onPull(f3);
_L12:
        if (s == State.PULL_TO_REFRESH || j1 < Math.abs(i1)) goto _L10; else goto _L9
_L9:
        a(State.PULL_TO_REFRESH, new boolean[0]);
_L6:
        return;
_L2:
        f1 = p;
        f2 = n;
        continue; /* Loop/switch isn't completed */
_L4:
        i1 = Math.round(Math.max(f1 - f2, 0.0F) / 4.2F);
        j1 = getFooterSize();
          goto _L11
_L8:
        E.onPull(f3);
          goto _L12
_L10:
        if (s != State.PULL_TO_REFRESH || j1 >= Math.abs(i1)) goto _L6; else goto _L13
_L13:
        a(State.RELEASE_TO_REFRESH, new boolean[0]);
        return;
        if (true) goto _L15; else goto _L14
_L14:
    }

    private android.widget.LinearLayout.LayoutParams d()
    {
        switch (f.a[getPullToRefreshScrollDirection().ordinal()])
        {
        default:
            return new android.widget.LinearLayout.LayoutParams(-1, -2);

        case 1: // '\001'
            return new android.widget.LinearLayout.LayoutParams(-2, -1);
        }
    }

    private int e()
    {
        switch (f.a[getPullToRefreshScrollDirection().ordinal()])
        {
        default:
            return Math.round((float)getHeight() / 4.2F);

        case 1: // '\001'
            return Math.round((float)getWidth() / 4.2F);
        }
    }

    final transient void a(State state, boolean aflag[])
    {
        s = state;
        Log.d("PullToRefresh", (new StringBuilder()).append("State: ").append(s.name()).toString());
        f.b[s.ordinal()];
        JVM INSTR tableswitch 1 5: default 84
    //                   1 110
    //                   2 117
    //                   3 124
    //                   4 131
    //                   5 131;
           goto _L1 _L2 _L3 _L4 _L5 _L5
_L1:
        if (H != null)
        {
            H.onPullEvent(this, s, u);
        }
        return;
_L2:
        onReset();
        continue; /* Loop/switch isn't completed */
_L3:
        onPullToRefresh();
        continue; /* Loop/switch isn't completed */
_L4:
        onReleaseToRefresh();
        continue; /* Loop/switch isn't completed */
_L5:
        onRefreshing(aflag[0]);
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void addView(View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        Log.d("PullToRefresh", (new StringBuilder()).append("addView: ").append(view.getClass().getSimpleName()).toString());
        View view1 = getRefreshableView();
        if (view1 instanceof ViewGroup)
        {
            ((ViewGroup)view1).addView(view, i1, layoutparams);
            return;
        } else
        {
            throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
        }
    }

    protected final void addViewInternal(View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.addView(view, i1, layoutparams);
    }

    protected final void addViewInternal(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.addView(view, -1, layoutparams);
    }

    protected LoadingLayout createLoadingLayout(Context context, Mode mode, TypedArray typedarray)
    {
        LoadingLayout loadinglayout = C.a(context, mode, getPullToRefreshScrollDirection(), typedarray);
        loadinglayout.setVisibility(4);
        return loadinglayout;
    }

    protected LoadingLayoutProxy createLoadingLayoutProxy(boolean flag, boolean flag1)
    {
        LoadingLayoutProxy loadinglayoutproxy = new LoadingLayoutProxy();
        if (flag && t.showHeaderLoadingLayout())
        {
            loadinglayoutproxy.addLayout(D);
        }
        if (flag1 && t.showFooterLoadingLayout())
        {
            loadinglayoutproxy.addLayout(E);
        }
        return loadinglayoutproxy;
    }

    protected abstract View createRefreshableView(Context context, AttributeSet attributeset);

    public final boolean demo()
    {
        if (t.showHeaderLoadingLayout() && isReadyForPullStart())
        {
            a(2 * -getHeaderSize());
            return true;
        }
        if (t.showFooterLoadingLayout() && isReadyForPullEnd())
        {
            a(2 * getFooterSize());
            return true;
        } else
        {
            return false;
        }
    }

    protected final void disableLoadingLayoutVisibilityChanges()
    {
        A = false;
    }

    public final Mode getCurrentMode()
    {
        return u;
    }

    public final boolean getFilterTouchEvents()
    {
        return y;
    }

    protected final LoadingLayout getFooterLayout()
    {
        return E;
    }

    protected final int getFooterSize()
    {
        return E.getContentSize();
    }

    protected final LoadingLayout getHeaderLayout()
    {
        return D;
    }

    protected final int getHeaderSize()
    {
        return D.getContentSize();
    }

    public final ILoadingLayout getLoadingLayoutProxy()
    {
        return getLoadingLayoutProxy(true, true);
    }

    public final ILoadingLayout getLoadingLayoutProxy(boolean flag, boolean flag1)
    {
        return createLoadingLayoutProxy(flag, flag1);
    }

    public final Mode getMode()
    {
        return t;
    }

    public abstract Orientation getPullToRefreshScrollDirection();

    protected int getPullToRefreshScrollDuration()
    {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger()
    {
        return 325;
    }

    public final View getRefreshableView()
    {
        return l;
    }

    protected FrameLayout getRefreshableViewWrapper()
    {
        return v;
    }

    public final boolean getShowViewWhileRefreshing()
    {
        return w;
    }

    public final State getState()
    {
        return s;
    }

    protected void handleStyledAttributes(TypedArray typedarray)
    {
    }

    public final boolean isDisableScrollingWhileRefreshing()
    {
        return !isScrollingWhileRefreshingEnabled();
    }

    public final boolean isPullToRefreshEnabled()
    {
        return t.b();
    }

    public final boolean isPullToRefreshOverScrollEnabled()
    {
        return android.os.Build.VERSION.SDK_INT >= 9 && z && OverscrollHelper.a(l);
    }

    protected abstract boolean isReadyForPullEnd();

    protected abstract boolean isReadyForPullStart();

    public final boolean isRefreshing()
    {
        return s == State.REFRESHING || s == State.MANUAL_REFRESHING;
    }

    public final boolean isScrollingWhileRefreshingEnabled()
    {
        return x;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        if (!isPullToRefreshEnabled())
        {
            return false;
        }
        i1 = motionevent.getAction();
        if (i1 == 3 || i1 == 1)
        {
            r = false;
            return false;
        }
        if (i1 != 0 && r)
        {
            return true;
        }
        i1;
        JVM INSTR tableswitch 0 2: default 72
    //                   0 339
    //                   1 72
    //                   2 77;
           goto _L1 _L2 _L1 _L3
_L1:
        return r;
_L3:
        float f3;
        float f4;
        if (!x && isRefreshing())
        {
            return true;
        }
        if (!b())
        {
            continue; /* Loop/switch isn't completed */
        }
        f3 = motionevent.getY();
        f4 = motionevent.getX();
        f.a[getPullToRefreshScrollDirection().ordinal()];
        JVM INSTR tableswitch 1 1: default 140
    //                   1 255;
           goto _L4 _L5
_L4:
        float f5;
        float f6;
        f5 = f3 - o;
        f6 = f4 - n;
_L6:
        float f7 = Math.abs(f5);
        if (f7 > (float)m && (!y || f7 > Math.abs(f6)))
        {
            if (t.showHeaderLoadingLayout() && f5 >= 1.0F && isReadyForPullStart())
            {
                o = f3;
                n = f4;
                r = true;
                if (t == Mode.BOTH)
                {
                    u = Mode.PULL_FROM_START;
                }
            } else
            if (t.showFooterLoadingLayout() && f5 <= -1F && isReadyForPullEnd())
            {
                o = f3;
                n = f4;
                r = true;
                if (t == Mode.BOTH)
                {
                    u = Mode.PULL_FROM_END;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        f5 = f4 - n;
        f6 = f3 - o;
          goto _L6
_L2:
        if (b())
        {
            float f1 = motionevent.getY();
            q = f1;
            o = f1;
            float f2 = motionevent.getX();
            p = f2;
            n = f2;
            r = false;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    protected void onPtrRestoreInstanceState(Bundle bundle)
    {
    }

    protected void onPtrSaveInstanceState(Bundle bundle)
    {
    }

    protected void onPullToRefresh()
    {
        switch (f.c[u.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            E.pullToRefresh();
            return;

        case 2: // '\002'
            D.pullToRefresh();
            break;
        }
    }

    public final void onRefreshComplete()
    {
        if (isRefreshing())
        {
            a(State.RESET, new boolean[0]);
        }
    }

    protected void onRefreshing(boolean flag)
    {
        if (t.showHeaderLoadingLayout())
        {
            D.refreshing();
        }
        if (t.showFooterLoadingLayout())
        {
            E.refreshing();
        }
        if (flag)
        {
            if (w)
            {
                c c1 = new c(this);
                switch (f.c[u.ordinal()])
                {
                case 2: // '\002'
                default:
                    smoothScrollTo(-getHeaderSize(), c1);
                    return;

                case 1: // '\001'
                case 3: // '\003'
                    smoothScrollTo(getFooterSize(), c1);
                    break;
                }
                return;
            } else
            {
                smoothScrollTo(0);
                return;
            }
        } else
        {
            a();
            return;
        }
    }

    protected void onReleaseToRefresh()
    {
        switch (f.c[u.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            E.releaseToRefresh();
            return;

        case 2: // '\002'
            D.releaseToRefresh();
            break;
        }
    }

    protected void onReset()
    {
        r = false;
        A = true;
        D.reset();
        E.reset();
        smoothScrollTo(0);
    }

    protected final void onRestoreInstanceState(Parcelable parcelable)
    {
        if (parcelable instanceof Bundle)
        {
            Bundle bundle = (Bundle)parcelable;
            setMode(Mode.a(bundle.getInt("ptr_mode", 0)));
            u = Mode.a(bundle.getInt("ptr_current_mode", 0));
            x = bundle.getBoolean("ptr_disable_scrolling", false);
            w = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State state = State.a(bundle.getInt("ptr_state", 0));
            if (state == State.REFRESHING || state == State.MANUAL_REFRESHING)
            {
                a(state, new boolean[] {
                    true
                });
            }
            onPtrRestoreInstanceState(bundle);
            return;
        } else
        {
            super.onRestoreInstanceState(parcelable);
            return;
        }
    }

    protected final Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        onPtrSaveInstanceState(bundle);
        bundle.putInt("ptr_state", s.a());
        bundle.putInt("ptr_mode", t.c());
        bundle.putInt("ptr_current_mode", u.c());
        bundle.putBoolean("ptr_disable_scrolling", x);
        bundle.putBoolean("ptr_show_refreshing_view", w);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    protected final void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(i1);
        aobj[1] = Integer.valueOf(j1);
        Log.d("PullToRefresh", String.format("onSizeChanged. W: %d, H: %d", aobj));
        super.onSizeChanged(i1, j1, k1, l1);
        refreshLoadingViewsSize();
        refreshRefreshableViewSize(i1, j1);
        post(new d(this));
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        if (isPullToRefreshEnabled()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (!x && isRefreshing())
        {
            return true;
        }
        if (motionevent.getAction() == 0 && motionevent.getEdgeFlags() != 0) goto _L1; else goto _L3
_L3:
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 72
    //                   0 74
    //                   1 142
    //                   2 113
    //                   3 142;
           goto _L4 _L5 _L6 _L7 _L6
_L6:
        continue; /* Loop/switch isn't completed */
_L4:
        return false;
_L5:
        if (!b()) goto _L1; else goto _L8
_L8:
        float f1 = motionevent.getY();
        q = f1;
        o = f1;
        float f2 = motionevent.getX();
        p = f2;
        n = f2;
        return true;
_L7:
        if (!r) goto _L1; else goto _L9
_L9:
        o = motionevent.getY();
        n = motionevent.getX();
        c();
        return true;
        if (!r) goto _L1; else goto _L10
_L10:
        r = false;
        if (s == State.RELEASE_TO_REFRESH && (F != null || G != null))
        {
            a(State.REFRESHING, new boolean[] {
                true
            });
            return true;
        }
        if (isRefreshing())
        {
            smoothScrollTo(0);
            return true;
        } else
        {
            a(State.RESET, new boolean[0]);
            return true;
        }
    }

    protected final void refreshLoadingViewsSize()
    {
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        i1 = (int)(1.2F * (float)e());
        j1 = getPaddingLeft();
        k1 = getPaddingTop();
        l1 = getPaddingRight();
        i2 = getPaddingBottom();
        f.a[getPullToRefreshScrollDirection().ordinal()];
        JVM INSTR tableswitch 1 2: default 68
    //                   1 151
    //                   2 232;
           goto _L1 _L2 _L3
_L1:
        int k2;
        int l2;
        int i3;
        int j3;
        j3 = i2;
        k2 = l1;
        i3 = k1;
        l2 = j1;
_L5:
        Object aobj[] = new Object[4];
        aobj[0] = Integer.valueOf(l2);
        aobj[1] = Integer.valueOf(i3);
        aobj[2] = Integer.valueOf(k2);
        aobj[3] = Integer.valueOf(j3);
        Log.d("PullToRefresh", String.format("Setting Padding. L: %d, T: %d, R: %d, B: %d", aobj));
        setPadding(l2, i3, k2, j3);
        return;
_L2:
        int l3;
        if (t.showHeaderLoadingLayout())
        {
            D.setWidth(i1);
            l3 = -i1;
        } else
        {
            l3 = 0;
        }
        if (t.showFooterLoadingLayout())
        {
            E.setWidth(i1);
            k2 = -i1;
            i3 = k1;
            l2 = l3;
            j3 = i2;
        } else
        {
            i3 = k1;
            l2 = l3;
            j3 = i2;
            k2 = 0;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        int j2;
        if (t.showHeaderLoadingLayout())
        {
            D.setHeight(i1);
            j2 = -i1;
        } else
        {
            j2 = 0;
        }
        if (t.showFooterLoadingLayout())
        {
            E.setHeight(i1);
            int k3 = -i1;
            l2 = j1;
            i3 = j2;
            j3 = k3;
            k2 = l1;
        } else
        {
            k2 = l1;
            l2 = j1;
            i3 = j2;
            j3 = 0;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected final void refreshRefreshableViewSize(int i1, int j1)
    {
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)v.getLayoutParams();
        f.a[getPullToRefreshScrollDirection().ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 45
    //                   2 66;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (layoutparams.width != i1)
        {
            layoutparams.width = i1;
            v.requestLayout();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (layoutparams.height != j1)
        {
            layoutparams.height = j1;
            v.requestLayout();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setDisableScrollingWhileRefreshing(boolean flag)
    {
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        setScrollingWhileRefreshingEnabled(flag1);
    }

    public final void setFilterTouchEvents(boolean flag)
    {
        y = flag;
    }

    protected final void setHeaderScroll(int i1)
    {
        Log.d("PullToRefresh", (new StringBuilder()).append("setHeaderScroll: ").append(i1).toString());
        int j1 = e();
        int k1 = Math.min(j1, Math.max(-j1, i1));
        if (A)
        {
            if (k1 < 0)
            {
                D.setVisibility(0);
            } else
            if (k1 > 0)
            {
                E.setVisibility(0);
            } else
            {
                D.setVisibility(4);
                E.setVisibility(4);
            }
        }
        switch (f.a[getPullToRefreshScrollDirection().ordinal()])
        {
        default:
            return;

        case 2: // '\002'
            scrollTo(0, k1);
            return;

        case 1: // '\001'
            scrollTo(k1, 0);
            return;
        }
    }

    public void setLastUpdatedLabel(CharSequence charsequence)
    {
        getLoadingLayoutProxy().setLastUpdatedLabel(charsequence);
    }

    public void setLoadingDrawable(Drawable drawable)
    {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode)
    {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    public void setLongClickable(boolean flag)
    {
        getRefreshableView().setLongClickable(flag);
    }

    public final void setMode(Mode mode)
    {
        if (mode != t)
        {
            Log.d("PullToRefresh", (new StringBuilder()).append("Setting mode to: ").append(mode).toString());
            t = mode;
            updateUIForMode();
        }
    }

    public void setOnPullEventListener(OnPullEventListener onpulleventlistener)
    {
        H = onpulleventlistener;
    }

    public final void setOnRefreshListener(OnRefreshListener2 onrefreshlistener2)
    {
        G = onrefreshlistener2;
        F = null;
    }

    public final void setOnRefreshListener(OnRefreshListener onrefreshlistener)
    {
        F = onrefreshlistener;
        G = null;
    }

    public void setPullLabel(CharSequence charsequence)
    {
        getLoadingLayoutProxy().setPullLabel(charsequence);
    }

    public void setPullLabel(CharSequence charsequence, Mode mode)
    {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charsequence);
    }

    public final void setPullToRefreshEnabled(boolean flag)
    {
        Mode mode;
        if (flag)
        {
            mode = Mode.a();
        } else
        {
            mode = Mode.DISABLED;
        }
        setMode(mode);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean flag)
    {
        z = flag;
    }

    public final void setRefreshing()
    {
        setRefreshing(true);
    }

    public final void setRefreshing(boolean flag)
    {
        if (!isRefreshing())
        {
            a(State.MANUAL_REFRESHING, new boolean[] {
                flag
            });
        }
    }

    public void setRefreshingLabel(CharSequence charsequence)
    {
        getLoadingLayoutProxy().setRefreshingLabel(charsequence);
    }

    public void setRefreshingLabel(CharSequence charsequence, Mode mode)
    {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charsequence);
    }

    public void setReleaseLabel(CharSequence charsequence)
    {
        setReleaseLabel(charsequence, Mode.BOTH);
    }

    public void setReleaseLabel(CharSequence charsequence, Mode mode)
    {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charsequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator)
    {
        B = interpolator;
    }

    public final void setScrollingWhileRefreshingEnabled(boolean flag)
    {
        x = flag;
    }

    public final void setShowViewWhileRefreshing(boolean flag)
    {
        w = flag;
    }

    protected final void smoothScrollTo(int i1)
    {
        a(i1, getPullToRefreshScrollDuration());
    }

    protected final void smoothScrollTo(int i1, g g1)
    {
        a(i1, getPullToRefreshScrollDuration(), 0L, g1);
    }

    protected final void smoothScrollToLonger(int i1)
    {
        a(i1, getPullToRefreshScrollDurationLonger());
    }

    protected void updateUIForMode()
    {
        android.widget.LinearLayout.LayoutParams layoutparams = d();
        if (this == D.getParent())
        {
            removeView(D);
        }
        if (t.showHeaderLoadingLayout())
        {
            addViewInternal(D, 0, layoutparams);
        }
        if (this == E.getParent())
        {
            removeView(E);
        }
        if (t.showFooterLoadingLayout())
        {
            addViewInternal(E, layoutparams);
        }
        refreshLoadingViewsSize();
        Mode mode;
        if (t != Mode.BOTH)
        {
            mode = t;
        } else
        {
            mode = Mode.PULL_FROM_START;
        }
        u = mode;
    }

    private class State extends Enum
    {

        public static final State MANUAL_REFRESHING;
        public static final State OVERSCROLLING;
        public static final State PULL_TO_REFRESH;
        public static final State REFRESHING;
        public static final State RELEASE_TO_REFRESH;
        public static final State RESET;
        private static final State b[];
        private int a;

        static State a(int i1)
        {
            State astate[] = values();
            int j1 = astate.length;
            for (int k1 = 0; k1 < j1; k1++)
            {
                State state = astate[k1];
                if (i1 == state.a())
                {
                    return state;
                }
            }

            return RESET;
        }

        public static State valueOf(String s1)
        {
            return (State)Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$State, s1);
        }

        public static State[] values()
        {
            return (State[])b.clone();
        }

        int a()
        {
            return a;
        }

        static 
        {
            RESET = new State("RESET", 0, 0);
            PULL_TO_REFRESH = new State("PULL_TO_REFRESH", 1, 1);
            RELEASE_TO_REFRESH = new State("RELEASE_TO_REFRESH", 2, 2);
            REFRESHING = new State("REFRESHING", 3, 8);
            MANUAL_REFRESHING = new State("MANUAL_REFRESHING", 4, 9);
            OVERSCROLLING = new State("OVERSCROLLING", 5, 16);
            State astate[] = new State[6];
            astate[0] = RESET;
            astate[1] = PULL_TO_REFRESH;
            astate[2] = RELEASE_TO_REFRESH;
            astate[3] = REFRESHING;
            astate[4] = MANUAL_REFRESHING;
            astate[5] = OVERSCROLLING;
            b = astate;
        }

        private State(String s1, int i1, int j1)
        {
            super(s1, i1);
            a = j1;
        }
    }


    private class Mode extends Enum
    {

        public static final Mode BOTH;
        public static final Mode DISABLED;
        public static final Mode MANUAL_REFRESH_ONLY;
        public static Mode PULL_DOWN_TO_REFRESH;
        public static final Mode PULL_FROM_END;
        public static final Mode PULL_FROM_START;
        public static Mode PULL_UP_TO_REFRESH;
        private static final Mode b[];
        private int a;

        static Mode a()
        {
            return PULL_FROM_START;
        }

        static Mode a(int i1)
        {
            Mode amode[] = values();
            int j1 = amode.length;
            for (int k1 = 0; k1 < j1; k1++)
            {
                Mode mode = amode[k1];
                if (i1 == mode.c())
                {
                    return mode;
                }
            }

            return a();
        }

        public static Mode valueOf(String s1)
        {
            return (Mode)Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$Mode, s1);
        }

        public static Mode[] values()
        {
            return (Mode[])b.clone();
        }

        boolean b()
        {
            return this != DISABLED && this != MANUAL_REFRESH_ONLY;
        }

        int c()
        {
            return a;
        }

        public boolean showFooterLoadingLayout()
        {
            return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        public boolean showHeaderLoadingLayout()
        {
            return this == PULL_FROM_START || this == BOTH;
        }

        static 
        {
            DISABLED = new Mode("DISABLED", 0, 0);
            PULL_FROM_START = new Mode("PULL_FROM_START", 1, 1);
            PULL_FROM_END = new Mode("PULL_FROM_END", 2, 2);
            BOTH = new Mode("BOTH", 3, 3);
            MANUAL_REFRESH_ONLY = new Mode("MANUAL_REFRESH_ONLY", 4, 4);
            Mode amode[] = new Mode[5];
            amode[0] = DISABLED;
            amode[1] = PULL_FROM_START;
            amode[2] = PULL_FROM_END;
            amode[3] = BOTH;
            amode[4] = MANUAL_REFRESH_ONLY;
            b = amode;
            PULL_DOWN_TO_REFRESH = PULL_FROM_START;
            PULL_UP_TO_REFRESH = PULL_FROM_END;
        }

        private Mode(String s1, int i1, int j1)
        {
            super(s1, i1);
            a = j1;
        }
    }


    private class AnimationStyle extends Enum
    {

        public static final AnimationStyle FLIP;
        public static final AnimationStyle ROTATE;
        private static final AnimationStyle a[];

        static AnimationStyle a()
        {
            return ROTATE;
        }

        static AnimationStyle a(int i1)
        {
            switch (i1)
            {
            default:
                return ROTATE;

            case 1: // '\001'
                return FLIP;
            }
        }

        public static AnimationStyle valueOf(String s1)
        {
            return (AnimationStyle)Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$AnimationStyle, s1);
        }

        public static AnimationStyle[] values()
        {
            return (AnimationStyle[])a.clone();
        }

        LoadingLayout a(Context context, Mode mode, Orientation orientation, TypedArray typedarray)
        {
            switch (f.d[ordinal()])
            {
            default:
                return new RotateLoadingLayout(context, mode, orientation, typedarray);

            case 2: // '\002'
                return new FlipLoadingLayout(context, mode, orientation, typedarray);
            }
        }

        static 
        {
            ROTATE = new AnimationStyle("ROTATE", 0);
            FLIP = new AnimationStyle("FLIP", 1);
            AnimationStyle aanimationstyle[] = new AnimationStyle[2];
            aanimationstyle[0] = ROTATE;
            aanimationstyle[1] = FLIP;
            a = aanimationstyle;
        }

        private AnimationStyle(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class OnRefreshListener
    {

        public abstract void onRefresh(PullToRefreshBase pulltorefreshbase);
    }


    private class OnRefreshListener2
    {

        public abstract void onPullDownToRefresh(PullToRefreshBase pulltorefreshbase);

        public abstract void onPullUpToRefresh(PullToRefreshBase pulltorefreshbase);
    }


    private class Orientation extends Enum
    {

        public static final Orientation HORIZONTAL;
        public static final Orientation VERTICAL;
        private static final Orientation a[];

        public static Orientation valueOf(String s1)
        {
            return (Orientation)Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$Orientation, s1);
        }

        public static Orientation[] values()
        {
            return (Orientation[])a.clone();
        }

        static 
        {
            VERTICAL = new Orientation("VERTICAL", 0);
            HORIZONTAL = new Orientation("HORIZONTAL", 1);
            Orientation aorientation[] = new Orientation[2];
            aorientation[0] = VERTICAL;
            aorientation[1] = HORIZONTAL;
            a = aorientation;
        }

        private Orientation(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class OnPullEventListener
    {

        public abstract void onPullEvent(PullToRefreshBase pulltorefreshbase, State state, Mode mode);
    }

}
