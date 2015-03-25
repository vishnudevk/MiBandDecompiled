// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            k

public class DynamicShareChart extends BarChart
{

    private int a;

    public DynamicShareChart(Context context)
    {
        super(context);
        mXAxis = new k(this);
        mXAxis.stroke = (int)(9F * mDensity);
        mMaxItemValue = 10000;
        mItemPadding = (int)(2.0F * mDensity);
        setPadding(0.0F, 0.0F, 0.0F, mXAxis.stroke);
        a = (int)(7F * mDensity);
    }

    public int getTotalHours()
    {
        return 18;
    }

    protected float itemHeight(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        if (baritem.value >= mMaxItemValue)
        {
            return rectf.height() - mPaddingTop - mPaddingBottom;
        } else
        {
            return (float)a + ((float)baritem.value / (float)mMaxItemValue) * (rectf.height() - mPaddingTop - mPaddingBottom - (float)a);
        }
    }

    protected float itemOffsetX(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        k k1 = (k)mXAxis;
        return k1.c * (float)(((DynamicShareBarItem)baritem).index - k1.offset);
    }

    protected float itemWidth(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        return rectf.width() / 18F - 2.0F * mItemPadding;
    }

    public void setOffsetHour(int i)
    {
        ((k)mXAxis).offset = i;
    }

    private class DynamicShareBarItem extends cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem
    {

        protected void draw(Canvas canvas, RectF rectf, float f)
        {
            if (!needDraw)
            {
                return;
            } else
            {
                float f1 = rectf.width() / 2.0F;
                RectF rectf1 = new RectF(rectf);
                rectf1.bottom = f1 + rectf1.bottom;
                canvas.save();
                canvas.clipRect(rectf);
                canvas.drawRoundRect(rectf1, f1, f1, mRenderer.paint);
                canvas.restore();
                return;
            }
        }

        public DynamicShareBarItem()
        {
        }
    }

}
