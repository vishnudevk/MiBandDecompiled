// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.ILoadingLayout;

// Referenced classes of package com.handmark.pulltorefresh.library.internal:
//            c, ViewCompat, Utils

public abstract class LoadingLayout extends FrameLayout
    implements ILoadingLayout
{

    static final String b = "PullToRefresh-LoadingLayout";
    static final Interpolator c = new LinearInterpolator();
    private FrameLayout a;
    private boolean d;
    private final TextView e;
    private final TextView f;
    private CharSequence g;
    private CharSequence h;
    private CharSequence i;
    protected final ImageView mHeaderImage;
    protected final ProgressBar mHeaderProgress;
    protected final com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mMode;
    protected final com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation mScrollDirection;

    public LoadingLayout(Context context, com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mode, com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation orientation, TypedArray typedarray)
    {
        super(context);
        mMode = mode;
        mScrollDirection = orientation;
        c.a[orientation.ordinal()];
        JVM INSTR tableswitch 1 1: default 40
    //                   1 476;
           goto _L1 _L2
_L1:
        LayoutInflater.from(context).inflate(0x7f030057, this);
_L5:
        android.widget.FrameLayout.LayoutParams layoutparams;
        a = (FrameLayout)findViewById(0x7f0a0191);
        e = (TextView)a.findViewById(0x7f0a0194);
        mHeaderProgress = (ProgressBar)a.findViewById(0x7f0a0193);
        f = (TextView)a.findViewById(0x7f0a0195);
        mHeaderImage = (ImageView)a.findViewById(0x7f0a0192);
        layoutparams = (android.widget.FrameLayout.LayoutParams)a.getLayoutParams();
        c.b[mode.ordinal()];
        JVM INSTR tableswitch 1 1: default 168
    //                   1 490;
           goto _L3 _L4
_L3:
        Drawable drawable;
        int j;
        TypedValue typedvalue;
        TypedValue typedvalue1;
        boolean flag;
        ColorStateList colorstatelist;
        ColorStateList colorstatelist1;
        Drawable drawable1;
        int k;
        if (orientation == com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation.VERTICAL)
        {
            k = 80;
        } else
        {
            k = 5;
        }
        layoutparams.gravity = k;
        g = context.getString(0x7f0d0131);
        h = context.getString(0x7f0d0132);
        i = context.getString(0x7f0d0133);
_L6:
        if (typedarray.hasValue(1))
        {
            drawable1 = typedarray.getDrawable(1);
            if (drawable1 != null)
            {
                ViewCompat.setBackground(this, drawable1);
            }
        }
        if (typedarray.hasValue(10))
        {
            typedvalue = new TypedValue();
            typedarray.getValue(10, typedvalue);
            b(typedvalue.data);
        }
        if (typedarray.hasValue(11))
        {
            typedvalue1 = new TypedValue();
            typedarray.getValue(11, typedvalue1);
            a(typedvalue1.data);
        }
        if (typedarray.hasValue(2))
        {
            colorstatelist1 = typedarray.getColorStateList(2);
            if (colorstatelist1 != null)
            {
                b(colorstatelist1);
            }
        }
        if (typedarray.hasValue(3))
        {
            colorstatelist = typedarray.getColorStateList(3);
            if (colorstatelist != null)
            {
                a(colorstatelist);
            }
        }
        flag = typedarray.hasValue(6);
        drawable = null;
        if (flag)
        {
            drawable = typedarray.getDrawable(6);
        }
        switch (c.b[mode.ordinal()])
        {
        default:
            if (typedarray.hasValue(7))
            {
                drawable = typedarray.getDrawable(7);
            } else
            if (typedarray.hasValue(17))
            {
                Utils.warnDeprecation("ptrDrawableTop", "ptrDrawableStart");
                drawable = typedarray.getDrawable(17);
            }
            break;

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_582;
        }
_L7:
        if (drawable == null)
        {
            drawable = context.getResources().getDrawable(getDefaultDrawableResId());
        }
        setLoadingDrawable(drawable);
        reset();
        return;
_L2:
        LayoutInflater.from(context).inflate(0x7f030056, this);
          goto _L5
_L4:
        if (orientation == com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation.VERTICAL)
        {
            j = 48;
        } else
        {
            j = 3;
        }
        layoutparams.gravity = j;
        g = context.getString(0x7f0d012e);
        h = context.getString(0x7f0d012f);
        i = context.getString(0x7f0d0130);
          goto _L6
        if (typedarray.hasValue(8))
        {
            drawable = typedarray.getDrawable(8);
        } else
        if (typedarray.hasValue(18))
        {
            Utils.warnDeprecation("ptrDrawableBottom", "ptrDrawableEnd");
            drawable = typedarray.getDrawable(18);
        }
          goto _L7
    }

    private void a(int j)
    {
        if (f != null)
        {
            f.setTextAppearance(getContext(), j);
        }
    }

    private void a(ColorStateList colorstatelist)
    {
        if (f != null)
        {
            f.setTextColor(colorstatelist);
        }
    }

    private void a(CharSequence charsequence)
    {
        if (f != null)
        {
            if (TextUtils.isEmpty(charsequence))
            {
                f.setVisibility(8);
            } else
            {
                f.setText(charsequence);
                if (8 == f.getVisibility())
                {
                    f.setVisibility(0);
                    return;
                }
            }
        }
    }

    private void b(int j)
    {
        if (e != null)
        {
            e.setTextAppearance(getContext(), j);
        }
        if (f != null)
        {
            f.setTextAppearance(getContext(), j);
        }
    }

    private void b(ColorStateList colorstatelist)
    {
        if (e != null)
        {
            e.setTextColor(colorstatelist);
        }
        if (f != null)
        {
            f.setTextColor(colorstatelist);
        }
    }

    public final int getContentSize()
    {
        switch (c.a[mScrollDirection.ordinal()])
        {
        default:
            return a.getHeight();

        case 1: // '\001'
            return a.getWidth();
        }
    }

    protected abstract int getDefaultDrawableResId();

    public final void hideAllViews()
    {
        if (e.getVisibility() == 0)
        {
            e.setVisibility(4);
        }
        if (mHeaderProgress.getVisibility() == 0)
        {
            mHeaderProgress.setVisibility(4);
        }
        if (mHeaderImage.getVisibility() == 0)
        {
            mHeaderImage.setVisibility(4);
        }
        if (f.getVisibility() == 0)
        {
            f.setVisibility(4);
        }
    }

    protected abstract void onLoadingDrawableSet(Drawable drawable);

    public final void onPull(float f1)
    {
        if (!d)
        {
            onPullImpl(f1);
        }
    }

    protected abstract void onPullImpl(float f1);

    public final void pullToRefresh()
    {
        if (e != null)
        {
            e.setText(g);
        }
        pullToRefreshImpl();
    }

    protected abstract void pullToRefreshImpl();

    public final void refreshing()
    {
        if (e != null)
        {
            e.setText(h);
        }
        if (d)
        {
            ((AnimationDrawable)mHeaderImage.getDrawable()).start();
        } else
        {
            refreshingImpl();
        }
        if (f != null)
        {
            f.setVisibility(8);
        }
    }

    protected abstract void refreshingImpl();

    public final void releaseToRefresh()
    {
        if (e != null)
        {
            e.setText(i);
        }
        releaseToRefreshImpl();
    }

    protected abstract void releaseToRefreshImpl();

    public final void reset()
    {
label0:
        {
            if (e != null)
            {
                e.setText(g);
            }
            mHeaderImage.setVisibility(0);
            if (d)
            {
                ((AnimationDrawable)mHeaderImage.getDrawable()).stop();
            } else
            {
                resetImpl();
            }
            if (f != null)
            {
                if (!TextUtils.isEmpty(f.getText()))
                {
                    break label0;
                }
                f.setVisibility(8);
            }
            return;
        }
        f.setVisibility(0);
    }

    protected abstract void resetImpl();

    public final void setHeight(int j)
    {
        getLayoutParams().height = j;
        requestLayout();
    }

    public void setLastUpdatedLabel(CharSequence charsequence)
    {
        a(charsequence);
    }

    public final void setLoadingDrawable(Drawable drawable)
    {
        mHeaderImage.setImageDrawable(drawable);
        d = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    public void setPullLabel(CharSequence charsequence)
    {
        g = charsequence;
    }

    public void setRefreshingLabel(CharSequence charsequence)
    {
        h = charsequence;
    }

    public void setReleaseLabel(CharSequence charsequence)
    {
        i = charsequence;
    }

    public void setTextTypeface(Typeface typeface)
    {
        e.setTypeface(typeface);
    }

    public final void setWidth(int j)
    {
        getLayoutParams().width = j;
        requestLayout();
    }

    public final void showInvisibleViews()
    {
        if (4 == e.getVisibility())
        {
            e.setVisibility(0);
        }
        if (4 == mHeaderProgress.getVisibility())
        {
            mHeaderProgress.setVisibility(0);
        }
        if (4 == mHeaderImage.getVisibility())
        {
            mHeaderImage.setVisibility(0);
        }
        if (4 == f.getVisibility())
        {
            f.setVisibility(0);
        }
    }

}
