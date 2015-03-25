// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.base;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.base:
//            a, BaseChart, ChartScroller

public abstract class BaseChartView extends View
{

    private static final String a = "Chart.BaseView";
    protected Animator mAnim;
    protected float mAnimFactor;
    protected BaseChart mChart;
    protected long mDuration;
    protected Interpolator mInterpolator;
    protected boolean mIsAttached;
    protected boolean mIsScrollingPerformed;
    protected ChartDataLoader mLoader;
    protected boolean mScrollable;
    protected ChartScroller mScroller;
    protected int mScrollingOffset;

    public BaseChartView(Context context)
    {
        this(context, null);
    }

    public BaseChartView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public BaseChartView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mIsAttached = true;
        mAnimFactor = 1.0F;
        mInterpolator = new LinearInterpolator();
        mDuration = 500L;
    }

    private void a(float f, boolean flag)
    {
        if (flag)
        {
            animRefresh();
            if (!mAnim.isStarted())
            {
                mAnim.start();
            }
            return;
        } else
        {
            mAnimFactor = f;
            postInvalidateOnAnimation();
            return;
        }
    }

    public Animator animRefresh()
    {
        if (mAnim == null)
        {
            mAnim = animRefresh(mDuration);
        }
        return mAnim;
    }

    public Animator animRefresh(long l)
    {
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            0.0F
        });
        valueanimator.setDuration(l);
        valueanimator.setInterpolator(mInterpolator);
        valueanimator.addUpdateListener(new a(this));
        return valueanimator;
    }

    public void attach()
    {
        mIsAttached = true;
    }

    public void detach()
    {
        mIsAttached = false;
    }

    public ChartDataLoader getDataLoader()
    {
        return mLoader;
    }

    public boolean isAttached()
    {
        return mIsAttached;
    }

    protected void onDraw(Canvas canvas)
    {
        mChart.draw(canvas, mAnimFactor);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        Rect rect = new Rect();
        rect.left = getPaddingLeft();
        rect.top = getPaddingTop();
        rect.right = i - getPaddingRight();
        rect.bottom = j - getPaddingBottom();
        mChart.setRect(rect);
    }

    public void refresh()
    {
        a(1.0F, false);
    }

    public void refresh(float f)
    {
        a(f, false);
    }

    public void refresh(boolean flag)
    {
        float f;
        if (flag)
        {
            f = 0.0F;
        } else
        {
            f = 1.0F;
        }
        a(f, flag);
    }

    public void setDataLoader(ChartDataLoader chartdataloader)
    {
        mLoader = chartdataloader;
    }

    public void setScrollable(boolean flag)
    {
        mScrollable = flag;
    }
}
