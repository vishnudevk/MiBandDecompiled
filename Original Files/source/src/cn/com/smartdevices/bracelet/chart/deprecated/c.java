// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            d, DynamicDetailChartOld, a

class c extends BarChart
{

    final DynamicDetailChartOld a;

    private c(DynamicDetailChartOld dynamicdetailchartold)
    {
        a = dynamicdetailchartold;
        super();
    }

    c(DynamicDetailChartOld dynamicdetailchartold, a a1)
    {
        this(dynamicdetailchartold);
    }

    public void notifyChanged()
    {
        mNeedRealign = true;
        super.notifyChanged();
    }

    protected void realignItems(RectF rectf, List list)
    {
        Iterator iterator;
        if (rectf == null || list == null || list.size() == 0)
        {
            return;
        }
        iterator = list.iterator();
_L8:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        RectF rectf2;
        float f3;
        DynamicDetailChartOld.DynamicDetailBarItem dynamicdetailbaritem;
        cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem = (cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem)iterator.next();
        float f2;
        int i;
        int j;
        if (baritem.getRect() == null)
        {
            RectF rectf1 = new RectF();
            baritem.setRect(rectf1);
            rectf2 = rectf1;
        } else
        {
            rectf2 = baritem.getRect();
        }
        if (mNeedRealign || baritem.getRect() == null)
        {
            float f = itemWidth(rectf, baritem);
            float f1 = itemHeight(rectf, baritem);
            f2 = f;
            f3 = f1;
        } else
        {
            float f4 = baritem.getRect().width();
            float f5 = baritem.getRect().height();
            f2 = f4;
            f3 = f5;
        }
        rectf2.top = rectf.top + mItemPadding + mPaddingTop;
        rectf2.bottom = f3 + rectf2.top;
        if (!mMirrored)
        {
            rectf2.left = rectf.left + mPaddingLeft;
            rectf2.right = f2 + rectf2.left;
        } else
        {
            rectf2.right = rectf.right - mPaddingRight;
            rectf2.left = rectf2.right - f2;
        }
        if (this instanceof d) goto _L4; else goto _L3
_L3:
        dynamicdetailbaritem = (DynamicDetailChartOld.DynamicDetailBarItem)baritem;
        dynamicdetailbaritem.a = true;
        i = DynamicDetailChartOld.b(a) / 60;
        j = DynamicDetailChartOld.b(a) % 60;
        if (DynamicDetailChartOld.b(a) < 0)
        {
            i--;
            j += 60;
        }
        if (dynamicdetailbaritem.index != i) goto _L6; else goto _L5
_L5:
        rectf2.bottom = (rectf2.top + f3 * ((float)j / 60F)) - 1.0F;
        dynamicdetailbaritem.a = false;
_L4:
        rectf2.offset(itemOffsetX(rectf, baritem), itemOffsetY(rectf, baritem));
        baritem.needDraw = true;
        if (rectf2.bottom < rectf.top || rectf2.top > rectf.bottom)
        {
            baritem.needDraw = false;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (dynamicdetailbaritem.index == DynamicDetailChartOld.c(a) / 60)
        {
            rectf2.top = 1.0F + f3 * (((float)DynamicDetailChartOld.c(a) % 60F) / 60F);
            dynamicdetailbaritem.a = false;
        }
        if (true) goto _L4; else goto _L2
_L2:
        mNeedRealign = false;
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
