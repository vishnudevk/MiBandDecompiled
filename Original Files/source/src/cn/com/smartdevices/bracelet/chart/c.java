// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            DynamicDetailChart, a

class c extends BarChart
{

    final DynamicDetailChart a;

    private c(DynamicDetailChart dynamicdetailchart)
    {
        a = dynamicdetailchart;
        super();
    }

    c(DynamicDetailChart dynamicdetailchart, a a1)
    {
        this(dynamicdetailchart);
    }

    protected void draw(Canvas canvas, RectF rectf, float f)
    {
        List list = mItems;
        list;
        JVM INSTR monitorenter ;
        Iterator iterator = mItems.iterator();
        int i = 0;
_L4:
        int k;
        if (iterator.hasNext())
        {
            Exception exception;
            Iterator iterator1;
            int j;
            cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem;
            float f1;
            if (((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem)iterator.next()).needDraw)
            {
                k = i + 1;
            } else
            {
                k = i;
            }
            break MISSING_BLOCK_LABEL_158;
        }
        iterator1 = mItems.iterator();
        j = 0;
_L2:
        if (!iterator1.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        baritem = (cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem)iterator1.next();
        if (!baritem.needDraw)
        {
            continue; /* Loop/switch isn't completed */
        }
        f1 = f / (1.0F - (float)j * (0.6F / (float)i));
        if (f1 > 1.0F)
        {
            f1 = 1.0F;
        }
        baritem.draw(canvas, f1);
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        list;
        JVM INSTR monitorexit ;
        return;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        i = k;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
