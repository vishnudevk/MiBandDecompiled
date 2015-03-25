// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.graphics.RectF;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            c, DynamicDetailChart, b, a

class d extends c
{

    final DynamicDetailChart b;

    private d(DynamicDetailChart dynamicdetailchart)
    {
        b = dynamicdetailchart;
        super(dynamicdetailchart, null);
    }

    d(DynamicDetailChart dynamicdetailchart, a a)
    {
        this(dynamicdetailchart);
    }

    protected float itemHeight(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        if (baritem.value != 3) goto _L2; else goto _L1
_L1:
        float f = 196.6F * mDensity;
_L4:
        return f;
_L2:
        int i;
        if (baritem.value == 2 || baritem.value == 1)
        {
            break; /* Loop/switch isn't completed */
        }
        i = baritem.value;
        f = 0.0F;
        if (i != 4) goto _L4; else goto _L3
_L3:
        return 160F * mDensity;
    }

    protected float itemOffsetX(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        if (baritem.index > DynamicDetailChart.e(b) || baritem.index < DynamicDetailChart.d(b) || DynamicDetailChart.d(b) == DynamicDetailChart.e(b))
        {
            return 0.0F;
        } else
        {
            return ((rectf.width() - mPaddingLeft - mPaddingRight) / (float)(1 + (DynamicDetailChart.e(b) - DynamicDetailChart.d(b)))) * (float)(baritem.index - DynamicDetailChart.d(b)) + mPaddingLeft + ((b)DynamicDetailChart.g(b)).c();
        }
    }

    protected float itemOffsetY(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        return 0.0F;
    }

    protected float itemWidth(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        float f;
        if (baritem.index > DynamicDetailChart.e(b) || baritem.index < DynamicDetailChart.d(b) || DynamicDetailChart.d(b) == DynamicDetailChart.e(b))
        {
            f = 0.0F;
        } else
        {
            f = ((rectf.width() - mPaddingLeft - mPaddingRight) / (float)(1 + (DynamicDetailChart.e(b) - DynamicDetailChart.d(b)))) * (float)baritem.scope - 2.0F * mItemPadding;
            if (f < 1.0F * mDensity)
            {
                return 1.0F * mDensity;
            }
        }
        return f;
    }

    protected void onItemsChanged(List list)
    {
        if (DynamicDetailChart.d(b) == DynamicDetailChart.e(b))
        {
            return;
        } else
        {
            super.onItemsChanged(list);
            return;
        }
    }
}
