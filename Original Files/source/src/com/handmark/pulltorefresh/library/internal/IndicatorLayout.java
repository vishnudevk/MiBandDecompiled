// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

// Referenced classes of package com.handmark.pulltorefresh.library.internal:
//            b

public class IndicatorLayout extends FrameLayout
    implements android.view.animation.Animation.AnimationListener
{

    static final int a = 150;
    private Animation b;
    private Animation c;
    private ImageView d;
    private final Animation e;
    private final Animation f;

    public IndicatorLayout(Context context, com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mode)
    {
        Drawable drawable;
        super(context);
        d = new ImageView(context);
        drawable = getResources().getDrawable(0x7f020079);
        d.setImageDrawable(drawable);
        int i = getResources().getDimensionPixelSize(0x7f0b002f);
        d.setPadding(i, i, i, i);
        addView(d);
        b.a[mode.ordinal()];
        JVM INSTR tableswitch 1 1: default 96
    //                   1 250;
           goto _L1 _L2
_L1:
        int j;
        int k;
        j = 0x7f04000e;
        k = 0x7f040010;
        setBackgroundResource(0x7f02007b);
_L4:
        b = AnimationUtils.loadAnimation(context, j);
        b.setAnimationListener(this);
        c = AnimationUtils.loadAnimation(context, k);
        c.setAnimationListener(this);
        LinearInterpolator linearinterpolator = new LinearInterpolator();
        e = new RotateAnimation(0.0F, -180F, 1, 0.5F, 1, 0.5F);
        e.setInterpolator(linearinterpolator);
        e.setDuration(150L);
        e.setFillAfter(true);
        f = new RotateAnimation(-180F, 0.0F, 1, 0.5F, 1, 0.5F);
        f.setInterpolator(linearinterpolator);
        f.setDuration(150L);
        f.setFillAfter(true);
        return;
_L2:
        j = 0x7f04000d;
        k = 0x7f04000f;
        setBackgroundResource(0x7f02007a);
        d.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.setRotate(180F, (float)drawable.getIntrinsicWidth() / 2.0F, (float)drawable.getIntrinsicHeight() / 2.0F);
        d.setImageMatrix(matrix);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void hide()
    {
        startAnimation(c);
    }

    public final boolean isVisible()
    {
        Animation animation = getAnimation();
        if (animation == null) goto _L2; else goto _L1
_L1:
        if (b != animation) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (getVisibility() != 0)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void onAnimationEnd(Animation animation)
    {
        if (animation != c) goto _L2; else goto _L1
_L1:
        d.clearAnimation();
        setVisibility(8);
_L4:
        clearAnimation();
        return;
_L2:
        if (animation == b)
        {
            setVisibility(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        setVisibility(0);
    }

    public void pullToRefresh()
    {
        d.startAnimation(f);
    }

    public void releaseToRefresh()
    {
        d.startAnimation(e);
    }

    public void show()
    {
        d.clearAnimation();
        startAnimation(b);
    }
}
