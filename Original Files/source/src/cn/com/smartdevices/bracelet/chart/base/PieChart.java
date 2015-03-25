// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.base:
//            BaseChart

public abstract class PieChart extends BaseChart
{

    protected float mMaxValue;
    protected float mRadius;
    protected float mRate;
    protected float mRotate;
    protected float mValue;

    public PieChart(Context context)
    {
        super(context);
    }

    protected void draw(Canvas canvas, RectF rectf, float f)
    {
        drawPie(canvas, rectf, rectf.left + mRadius, rectf.top + mRadius, mRadius, mRate, f);
    }

    protected abstract void drawPie(Canvas canvas, RectF rectf, float f, float f1, float f2, float f3, float f4);

    public float getMaxValue()
    {
        return mMaxValue;
    }

    protected void onRectChanged(RectF rectf)
    {
        mRadius = Math.min(rectf.width(), rectf.height()) / 2.0F;
    }

    public void rotate(float f)
    {
        mRotate = f;
    }

    public void setMaxValue(long l)
    {
        mMaxValue = l;
        updateRate();
    }

    public void setValue(float f)
    {
        mValue = f;
        updateRate();
    }

    protected void updateRate()
    {
        if (mMaxValue == 0.0F)
        {
            mRate = 0.0F;
            return;
        }
        if (mValue >= mMaxValue)
        {
            mRate = 1.0F;
            return;
        } else
        {
            mRate = mValue / mMaxValue;
            return;
        }
    }
}
