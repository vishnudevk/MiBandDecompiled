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

// Referenced classes of package com.handmark.pulltorefresh.library.internal:
//            LoadingLayout

public class RotateLoadingLayout extends LoadingLayout
{

    static final int a = 1200;
    private final Animation d = new RotateAnimation(0.0F, 720F, 1, 0.5F, 1, 0.5F);
    private final Matrix e = new Matrix();
    private float f;
    private float g;
    private final boolean h;

    public RotateLoadingLayout(Context context, com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mode, com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation orientation, TypedArray typedarray)
    {
        super(context, mode, orientation, typedarray);
        h = typedarray.getBoolean(15, true);
        mHeaderImage.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        mHeaderImage.setImageMatrix(e);
        d.setInterpolator(c);
        d.setDuration(1200L);
        d.setRepeatCount(-1);
        d.setRepeatMode(1);
    }

    private void a()
    {
        if (e != null)
        {
            e.reset();
            mHeaderImage.setImageMatrix(e);
        }
    }

    protected int getDefaultDrawableResId()
    {
        return 0x7f02005c;
    }

    public void onLoadingDrawableSet(Drawable drawable)
    {
        if (drawable != null)
        {
            f = Math.round((float)drawable.getIntrinsicWidth() / 2.0F);
            g = Math.round((float)drawable.getIntrinsicHeight() / 2.0F);
        }
    }

    protected void onPullImpl(float f1)
    {
        float f2;
        if (h)
        {
            f2 = 90F * f1;
        } else
        {
            f2 = Math.max(0.0F, Math.min(180F, 360F * f1 - 180F));
        }
        e.setRotate(f2, f, g);
        mHeaderImage.setImageMatrix(e);
    }

    protected void pullToRefreshImpl()
    {
    }

    protected void refreshingImpl()
    {
        mHeaderImage.startAnimation(d);
    }

    protected void releaseToRefreshImpl()
    {
    }

    protected void resetImpl()
    {
        mHeaderImage.clearAnimation();
        a();
    }
}
