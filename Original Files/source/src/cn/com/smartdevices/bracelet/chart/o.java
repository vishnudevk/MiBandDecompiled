// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import cn.com.smartdevices.bracelet.Debug;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            StatisticChart

class o extends cn.com.smartdevices.bracelet.chart.base.BarChart.XAxis
{

    final StatisticChart a;
    private Paint b;
    private Paint c;

    public o(StatisticChart statisticchart)
    {
        a = statisticchart;
        super();
        b = new TextPaint(1);
        b.setColor(0x66000000);
        b.setTextSize(9F * mDensity);
        c = new Paint();
        c.setColor(0xfff2f2f2);
    }

    private void b(Canvas canvas, RectF rectf, float f, float f1, float f2)
    {
        int k;
        int l;
        Rect rect;
        int i = 255;
        int j = 128;
        if (f1 > -1F)
        {
            i = (int)(255F * f);
            j = (int)(128F * f);
        }
        if (f2 > -1F)
        {
            i = (int)(255F * (1.0F - f));
            j = (int)(128F * (1.0F - f));
        }
        k = 0x799ed | i << 24;
        l = 0 | j << 24;
        rect = new Rect();
        List list = StatisticChart.b(a);
        list;
        JVM INSTR monitorenter ;
        Iterator iterator = StatisticChart.b(a).iterator();
_L2:
        StatisticChart.DateItem dateitem;
        float f3;
        float f4;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_375;
            }
            dateitem = (StatisticChart.DateItem)iterator.next();
        } while (dateitem.a > 1 + (offset + (-1 + StatisticChart.c(a)) / 2) || dateitem.a < (offset + (-1 + StatisticChart.c(a)) / 2) - StatisticChart.c(a));
        f3 = ((rectf.right - mPaddingRight) + (float)(-1 + dateitem.a) * StatisticChart.a(a) + mScroll) - (float)((-1 + StatisticChart.c(a)) / 2) * StatisticChart.a(a);
        f4 = rectf.top;
        if (dateitem.a != offset)
        {
            break; /* Loop/switch isn't completed */
        }
        b.setColor(k);
_L3:
        b.getTextBounds(dateitem.b, 0, dateitem.b.length(), rect);
        float f5 = f3 + (StatisticChart.a(a) - (float)rect.width()) / 2.0F;
        float f6 = f4 + (float)(stroke + rect.height()) / 2.0F;
        canvas.drawText(dateitem.b, f5, f6, b);
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        b.setColor(l);
          goto _L3
        list;
        JVM INSTR monitorexit ;
    }

    public void a(Canvas canvas, float f, float f1, float f2)
    {
        a(canvas, mRect, f, f1, f2);
    }

    public void a(Canvas canvas, RectF rectf, float f, float f1, float f2)
    {
        b(canvas, rectf, f, f1, f2);
    }

    protected void doScroll(float f)
    {
        offset = -Math.round(mScroll / StatisticChart.a(a));
        Debug.i("Chart.StatisticChart", (new StringBuilder()).append("DateLine Offset : ").append(offset).toString());
    }
}
