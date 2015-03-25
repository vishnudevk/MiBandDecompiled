// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;

// Referenced classes of package com.handmark.pulltorefresh.library.internal:
//            LoadingLayout, a

public class FlipLoadingLayout extends LoadingLayout
{

    static final int a = 150;
    private final Animation d;
    private final Animation e;

    public FlipLoadingLayout(Context context, com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mode, com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation orientation, TypedArray typedarray)
    {
        super(context, mode, orientation, typedarray);
        int i;
        if (mode == com.handmark.pulltorefresh.library.PullToRefreshBase.Mode.PULL_FROM_START)
        {
            i = -180;
        } else
        {
            i = 180;
        }
        d = new RotateAnimation(0.0F, i, 1, 0.5F, 1, 0.5F);
        d.setInterpolator(c);
        d.setDuration(150L);
        d.setFillAfter(true);
        e = new RotateAnimation(i, 0.0F, 1, 0.5F, 1, 0.5F);
        e.setInterpolator(c);
        e.setDuration(150L);
        e.setFillAfter(true);
    }

    private float a()
    {
        a.a[mMode.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 34
    //                   2 50;
           goto _L1 _L2 _L3
_L1:
        return 0.0F;
_L2:
        return mScrollDirection != com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation.HORIZONTAL ? 180F : 90F;
_L3:
        if (mScrollDirection == com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation.HORIZONTAL)
        {
            return 270F;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected int getDefaultDrawableResId()
    {
        return 0x7f02005b;
    }

    protected void onLoadingDrawableSet(Drawable drawable)
    {
        if (drawable != null)
        {
            int i = drawable.getIntrinsicHeight();
            int j = drawable.getIntrinsicWidth();
            android.view.ViewGroup.LayoutParams layoutparams = mHeaderImage.getLayoutParams();
            int k = Math.max(i, j);
            layoutparams.height = k;
            layoutparams.width = k;
            mHeaderImage.requestLayout();
            mHeaderImage.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((float)(layoutparams.width - j) / 2.0F, (float)(layoutparams.height - i) / 2.0F);
            matrix.postRotate(a(), (float)layoutparams.width / 2.0F, (float)layoutparams.height / 2.0F);
            mHeaderImage.setImageMatrix(matrix);
        }
    }

    protected void onPullImpl(float f)
    {
    }

    protected void pullToRefreshImpl()
    {
        if (d == mHeaderImage.getAnimation())
        {
            mHeaderImage.startAnimation(e);
        }
    }

    protected void refreshingImpl()
    {
        mHeaderImage.clearAnimation();
        mHeaderImage.setVisibility(4);
        mHeaderProgress.setVisibility(0);
    }

    protected void releaseToRefreshImpl()
    {
        mHeaderImage.startAnimation(d);
    }

    protected void resetImpl()
    {
        mHeaderImage.clearAnimation();
        mHeaderProgress.setVisibility(8);
        mHeaderImage.setVisibility(0);
    }
}
