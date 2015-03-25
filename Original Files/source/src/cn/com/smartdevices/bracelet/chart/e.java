// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.graphics.RectF;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            c, DynamicDetailChart, b, a

class e extends c
{

    final DynamicDetailChart b;
    private float c;
    private int d;

    private e(DynamicDetailChart dynamicdetailchart)
    {
        b = dynamicdetailchart;
        super(dynamicdetailchart, null);
        d = 10;
    }

    e(DynamicDetailChart dynamicdetailchart, a a)
    {
        this(dynamicdetailchart);
    }

    protected float itemHeight(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        if (baritem.value >= mMaxItemValue)
        {
            return rectf.height() - mPaddingTop - mPaddingBottom;
        } else
        {
            return ChartUtil.itemLevelSize(mMaxItemValue, baritem.value, c, d);
        }
    }

    protected float itemOffsetX(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        return ((rectf.width() - mPaddingLeft - mPaddingRight) / (float)(1 + (DynamicDetailChart.b(b) - DynamicDetailChart.a(b)))) * (float)(baritem.index - DynamicDetailChart.a(b)) + mPaddingLeft + ((b)DynamicDetailChart.f(b)).c();
    }

    protected float itemOffsetY(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        return 0.0F;
    }

    protected float itemWidth(RectF rectf, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem)
    {
        return (rectf.width() - mPaddingLeft - mPaddingRight) / (float)(1 + (DynamicDetailChart.b(b) - DynamicDetailChart.a(b))) - 2.0F * mItemPadding;
    }

    protected void onItemsChanged(List list)
    {
        super.onItemsChanged(list);
        mMaxItemValue = ChartUtil.updateMaxItemValue(list, 0, 1500);
        if (mRect != null)
        {
            float f = mRect.height() - mPaddingTop - mPaddingBottom;
            c = ChartUtil.updateLevelSize(mMaxItemValue, f, d);
        }
        DynamicDetailChart.a(b, 0x7fffffff);
        DynamicDetailChart.b(b, 0);
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem = (cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem)iterator.next();
            Debug.i("Chart.DynamicDetailChart", (new StringBuilder()).append("Step Item : ").append(baritem).toString());
            if (baritem.index < DynamicDetailChart.a(b))
            {
                DynamicDetailChart.a(b, baritem.index);
            }
            if (baritem.index > DynamicDetailChart.b(b))
            {
                DynamicDetailChart.b(b, baritem.index);
            }
        } while (true);
        if (list.size() == 0)
        {
            DynamicDetailChart.a(b, 0);
            DynamicDetailChart.b(b, 0);
        }
        DynamicDetailChart.c(b, 60 * DynamicDetailChart.a(b));
        DynamicDetailChart.d(b, 60 * DynamicDetailChart.b(b));
        b.justifyStartEndTimeIndex(8);
    }

    protected void onRectChanged(RectF rectf)
    {
        super.onRectChanged(rectf);
        if (rectf != null)
        {
            float f = rectf.height() - mPaddingTop - mPaddingBottom;
            c = ChartUtil.updateLevelSize(mMaxItemValue, f, d);
        }
    }
}
