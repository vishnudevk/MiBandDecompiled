// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.RectF;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            c, DynamicDetailChartOld, b, a

class e extends c
{

    final DynamicDetailChartOld b;
    private float c;
    private int d;
    private int e;

    private e(DynamicDetailChartOld dynamicdetailchartold)
    {
        b = dynamicdetailchartold;
        super(dynamicdetailchartold, null);
        e = 10;
    }

    e(DynamicDetailChartOld dynamicdetailchartold, a a1)
    {
        this(dynamicdetailchartold);
    }

    private float a(int i)
    {
        if (i <= 0)
        {
            return 0.0F;
        } else
        {
            return c * ((float)(i * (e + (1 + (e - i)))) / 2.0F);
        }
    }

    protected void a()
    {
        if (mRect != null)
        {
            d = mMaxItemValue / e;
            c = ((mRect.width() - mPaddingLeft - mPaddingRight) * ((float)(d * e) / (float)mMaxItemValue)) / ((float)((1 + e) * e) / 2.0F);
        }
    }

    protected void a(List list)
    {
        mMaxItemValue = 1500;
        List list1 = mItems;
        list1;
        JVM INSTR monitorenter ;
        Iterator iterator = mItems.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem = (cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem)iterator.next();
            if (((DynamicDetailChartOld.DynamicDetailBarItem)baritem).index >= 0 && baritem.value > mMaxItemValue)
            {
                mMaxItemValue = baritem.value;
            }
        } while (true);
        break MISSING_BLOCK_LABEL_87;
        Exception exception;
        exception;
        list1;
        JVM INSTR monitorexit ;
        throw exception;
        list1;
        JVM INSTR monitorexit ;
    }

    protected float itemHeight(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        b b1 = (b)DynamicDetailChartOld.d(b);
        return ((float)baritem.scope / 24F) * (rectf.height() - mPaddingTop - mPaddingBottom - DynamicDetailChartOld.a(b) - b1.getPaddingBottom()) - 2.0F * mItemPadding;
    }

    protected float itemOffsetX(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        return 0.0F;
    }

    protected float itemOffsetY(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        b b1 = (b)DynamicDetailChartOld.e(b);
        return ((float)baritem.index / 24F) * (rectf.height() - mPaddingTop - mPaddingBottom - DynamicDetailChartOld.a(b) - b1.getPaddingBottom()) + b1.c();
    }

    protected float itemWidth(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        if (baritem.value >= mMaxItemValue)
        {
            return rectf.width() - mPaddingLeft - mPaddingRight;
        } else
        {
            int i = (-1 + (baritem.value + d)) / d;
            float f = (float)(1 + (-1 + baritem.value) % d) / (float)d;
            return a(i - 1) + f * (a(i) - a(i - 1));
        }
    }

    protected void onItemsChanged(List list)
    {
        super.onItemsChanged(list);
        a(list);
        a();
    }

    protected void onRectChanged(RectF rectf)
    {
        super.onRectChanged(rectf);
        a();
    }
}
