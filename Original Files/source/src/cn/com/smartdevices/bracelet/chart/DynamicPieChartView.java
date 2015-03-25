// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import cn.com.smartdevices.bracelet.chart.base.BaseChart;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            DynamicPieChart, i, j

public class DynamicPieChartView extends BaseChartView
{

    private static final String a = "Chart.DynamicPieChartView";
    private long b;
    private long c;
    private Animator d;

    public DynamicPieChartView(Context context)
    {
        this(context, null);
    }

    public DynamicPieChartView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DynamicPieChartView(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        mChart = new DynamicPieChart(context, this);
        mInterpolator = new DecelerateInterpolator();
        mDuration = 1L;
    }

    static BaseChart a(DynamicPieChartView dynamicpiechartview)
    {
        return dynamicpiechartview.mChart;
    }

    private void a()
    {
        float f = (float)Math.abs(c - b) / ((DynamicPieChart)mChart).getMaxValue();
        if (f > 1.0F)
        {
            f = 1.0F;
        }
        mDuration = (long)(800D * Math.sqrt(f));
        if (mDuration == 0L)
        {
            mDuration = 1L;
        }
        mAnim = animRefresh(mDuration);
    }

    private Animator b()
    {
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        valueanimator.addListener(new i(this));
        valueanimator.addUpdateListener(new j(this));
        valueanimator.setDuration(3500L);
        valueanimator.setInterpolator(new LinearInterpolator());
        valueanimator.setRepeatMode(1);
        valueanimator.setRepeatCount(-1);
        return valueanimator;
    }

    static BaseChart b(DynamicPieChartView dynamicpiechartview)
    {
        return dynamicpiechartview.mChart;
    }

    static BaseChart c(DynamicPieChartView dynamicpiechartview)
    {
        return dynamicpiechartview.mChart;
    }

    static BaseChart d(DynamicPieChartView dynamicpiechartview)
    {
        return dynamicpiechartview.mChart;
    }

    static BaseChart e(DynamicPieChartView dynamicpiechartview)
    {
        return dynamicpiechartview.mChart;
    }

    public void dismissLoading()
    {
        if (d != null)
        {
            d.end();
        }
    }

    protected void onDraw(Canvas canvas)
    {
        if (mAnimFactor < 1.0F)
        {
            long l1 = b + (long)((float)(c - b) * mAnimFactor);
            ((DynamicPieChart)mChart).setValue(l1);
            ((DynamicPieChart)mChart).draw(canvas, 1.0F);
            return;
        } else
        {
            long l = c;
            ((DynamicPieChart)mChart).setValue(l);
            ((DynamicPieChart)mChart).draw(canvas, mAnimFactor);
            return;
        }
    }

    public void setMaxValue(long l)
    {
        ((DynamicPieChart)mChart).setMaxValue(l);
    }

    public void setMode(int k)
    {
        ((DynamicPieChart)mChart).setMode(k);
        invalidate();
    }

    public void setValue(long l)
    {
        c = l;
        a();
    }

    public void showLoading()
    {
        showLoading(0L);
    }

    public void showLoading(long l)
    {
        if (d == null)
        {
            d = b();
        }
        if (!d.isStarted())
        {
            if (l > 0L)
            {
                d.setStartDelay(l);
            }
            d.start();
        }
    }
}
