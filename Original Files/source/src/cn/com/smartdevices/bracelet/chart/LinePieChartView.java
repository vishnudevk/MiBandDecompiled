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
//            LinePieChart, l, m

public class LinePieChartView extends BaseChartView
{

    private static final String a = "LinePieChartView";
    private float b;
    private Animator c;

    public LinePieChartView(Context context)
    {
        this(context, null);
    }

    public LinePieChartView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public LinePieChartView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mChart = new LinePieChart(context);
        mInterpolator = new DecelerateInterpolator();
        mDuration = 1L;
    }

    static BaseChart a(LinePieChartView linepiechartview)
    {
        return linepiechartview.mChart;
    }

    private void a()
    {
        float f = b / ((LinePieChart)mChart).getMaxValue();
        if (f > 1.0F)
        {
            f = 1.0F;
        }
        mDuration = (long)(800D * Math.sqrt(f));
        if (mDuration == 0L)
        {
            mDuration = 1L;
        }
    }

    private Animator b()
    {
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        valueanimator.addListener(new l(this));
        valueanimator.addUpdateListener(new m(this));
        valueanimator.setDuration(3500L);
        valueanimator.setInterpolator(new LinearInterpolator());
        valueanimator.setRepeatMode(1);
        valueanimator.setRepeatCount(-1);
        return valueanimator;
    }

    static BaseChart b(LinePieChartView linepiechartview)
    {
        return linepiechartview.mChart;
    }

    static BaseChart c(LinePieChartView linepiechartview)
    {
        return linepiechartview.mChart;
    }

    static BaseChart d(LinePieChartView linepiechartview)
    {
        return linepiechartview.mChart;
    }

    static BaseChart e(LinePieChartView linepiechartview)
    {
        return linepiechartview.mChart;
    }

    public void dismissLoading()
    {
        if (c != null)
        {
            c.end();
            ((LinePieChart)mChart).dismissLoading();
        }
    }

    protected void onDraw(Canvas canvas)
    {
        if (mAnimFactor < 1.0F)
        {
            float f1 = b * mAnimFactor;
            ((LinePieChart)mChart).setValue(f1);
            ((LinePieChart)mChart).draw(canvas, 1.0F);
            return;
        } else
        {
            float f = b;
            ((LinePieChart)mChart).setValue(f);
            ((LinePieChart)mChart).draw(canvas, mAnimFactor);
            return;
        }
    }

    public void setMaxValue(long l1)
    {
        ((LinePieChart)mChart).setMaxValue(l1);
    }

    public void setMode(int i)
    {
        ((LinePieChart)mChart).setMode(i);
        invalidate();
    }

    public void setValue(long l1)
    {
        b = l1;
        a();
    }

    public void showLoading()
    {
        showLoading(0L);
    }

    public void showLoading(long l1)
    {
        if (c == null)
        {
            c = b();
        }
        if (!c.isStarted())
        {
            if (l1 > 0L)
            {
                c.setStartDelay(l1);
            }
            c.start();
        }
    }

    public void showNormalLine()
    {
        ((LinePieChart)mChart).setMode(0);
        refresh(false);
    }
}
