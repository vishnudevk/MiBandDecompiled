// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import cn.com.smartdevices.bracelet.Debug;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            StatisticChartOld

class p extends cn.com.smartdevices.bracelet.chart.base.BarChart.XAxis
{

    final StatisticChartOld a;
    private Paint b;

    public p(StatisticChartOld statisticchartold)
    {
        a = statisticchartold;
        super();
        b = new TextPaint(1);
        b.setColor(-1);
        b.setTextSize(8F * mDensity);
    }

    protected void doScroll(float f)
    {
        offset = -Math.round(mScroll / StatisticChartOld.a());
        Debug.i("Chart.StatisticChart", (new StringBuilder()).append("DateLine Offset : ").append(offset).toString());
    }

    protected void draw(Canvas canvas, RectF rectf, float f)
    {
        Rect rect;
        canvas.save();
        RectF rectf1 = new RectF(rectf);
        rectf1.right = rectf.right - mPaddingRight;
        canvas.clipRect(rectf1);
        rect = new Rect();
        List list = StatisticChartOld.a(a);
        list;
        JVM INSTR monitorenter ;
        Iterator iterator = StatisticChartOld.a(a).iterator();
_L2:
        StatisticChartOld.DateItem dateitem;
        float f1;
        float f2;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_298;
            }
            dateitem = (StatisticChartOld.DateItem)iterator.next();
        } while (dateitem.a > 1 + offset || dateitem.a < -8 + offset);
        f1 = (rectf.right - mPaddingRight) + (float)(-1 + dateitem.a) * StatisticChartOld.a() + mScroll;
        f2 = rectf.top;
        if (f1 > mRect.right - mPaddingRight - 2.0F * StatisticChartOld.a())
        {
            break; /* Loop/switch isn't completed */
        }
        b.setTextSize(8F * mDensity);
_L3:
        b.getTextBounds(dateitem.b, 0, dateitem.b.length(), rect);
        float f3 = f1 + (StatisticChartOld.a() - (float)rect.width()) / 2.0F;
        float f4 = f2 + (float)(stroke + rect.height()) / 2.0F;
        canvas.drawText(dateitem.b, f3, f4, b);
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        b.setTextSize(10F * mDensity);
          goto _L3
        list;
        JVM INSTR monitorexit ;
        canvas.restore();
        return;
    }
}
