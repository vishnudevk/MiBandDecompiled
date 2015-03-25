// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            DynamicShareChart

class k extends cn.com.smartdevices.bracelet.chart.base.BarChart.XAxis
{

    static final int a = 18;
    static final int b = 1;
    float c;
    Paint d;
    final DynamicShareChart e;

    public k(DynamicShareChart dynamicsharechart)
    {
        e = dynamicsharechart;
        super();
        value = 18;
        offset = 1;
        d = new TextPaint();
        d.setColor(-1);
        d.setTextSize(6.5F * mDensity);
        d.setAntiAlias(true);
    }

    protected void draw(Canvas canvas, RectF rectf, float f)
    {
        Rect rect = new Rect();
        for (int i = 0; (float)i < f * (float)value; i++)
        {
            int j = i + offset % value;
            if (j % 2 == 0)
            {
                String s = String.valueOf(j);
                d.getTextBounds(s, 0, s.length(), rect);
                canvas.drawText(s, (float)i * c + (c - (float)rect.width()) / 2.0F + rectf.left, (float)(stroke + rect.height()) / 2.0F + rectf.top, d);
            }
        }

    }

    protected void onRectChanged(RectF rectf)
    {
        c = rectf.width() / (float)value;
    }
}
