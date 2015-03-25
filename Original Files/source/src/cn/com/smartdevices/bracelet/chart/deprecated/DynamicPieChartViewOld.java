// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import cn.com.smartdevices.bracelet.chart.base.BaseChart;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            DynamicPieChartOld, m, n

public class DynamicPieChartViewOld extends BaseChartView
{

    private static final String a = "Chart.DynamicPieChartView";
    private long b;
    private long c;
    private Animator d;

    public DynamicPieChartViewOld(Context context)
    {
        this(context, null);
    }

    public DynamicPieChartViewOld(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DynamicPieChartViewOld(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mChart = new DynamicPieChartOld(context);
        mInterpolator = new OvershootInterpolator();
        mDuration = 1L;
    }

    static BaseChart a(DynamicPieChartViewOld dynamicpiechartviewold)
    {
        return dynamicpiechartviewold.mChart;
    }

    private void a()
    {
        float f = 1.0F;
        float f1 = (float)Math.abs(c - b) / ((DynamicPieChartOld)mChart).getMaxValue();
        if (f1 > f)
        {
            f1 = f;
        }
        mDuration = (long)(800D * Math.sqrt(f1));
        if (mDuration == 0L)
        {
            mDuration = 1L;
        }
        if (f1 < f)
        {
            f = (float)Math.sqrt(6F * (f - f1));
        }
        mInterpolator = new OvershootInterpolator(f);
    }

    private Animator b()
    {
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        valueanimator.addListener(new m(this));
        valueanimator.addUpdateListener(new n(this));
        valueanimator.setDuration(3500L);
        valueanimator.setInterpolator(new LinearInterpolator());
        valueanimator.setRepeatMode(1);
        valueanimator.setRepeatCount(-1);
        return valueanimator;
    }

    static BaseChart b(DynamicPieChartViewOld dynamicpiechartviewold)
    {
        return dynamicpiechartviewold.mChart;
    }

    static BaseChart c(DynamicPieChartViewOld dynamicpiechartviewold)
    {
        return dynamicpiechartviewold.mChart;
    }

    static BaseChart d(DynamicPieChartViewOld dynamicpiechartviewold)
    {
        return dynamicpiechartviewold.mChart;
    }

    static BaseChart e(DynamicPieChartViewOld dynamicpiechartviewold)
    {
        return dynamicpiechartviewold.mChart;
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
            ((DynamicPieChartOld)mChart).setValue(l1);
            ((DynamicPieChartOld)mChart).draw(canvas, 1.0F);
            return;
        } else
        {
            long l = c;
            ((DynamicPieChartOld)mChart).setValue(l);
            ((DynamicPieChartOld)mChart).draw(canvas, mAnimFactor);
            return;
        }
    }

    public void setMaxValue(long l)
    {
        ((DynamicPieChartOld)mChart).setMaxValue(l);
    }

    public void setValue(long l)
    {
        b = c;
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

    public void updateMode(int i)
    {
        ((DynamicPieChartOld)mChart).updateMode(i);
        invalidate();
    }
}
