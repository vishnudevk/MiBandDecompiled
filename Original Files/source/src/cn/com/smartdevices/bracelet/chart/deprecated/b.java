// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            DynamicDetailChartOld

class b extends cn.com.smartdevices.bracelet.chart.base.BarChart.YAxis
{

    static final float a = 24F;
    static final float b = 1440F;
    final DynamicDetailChartOld c;
    private int d;
    private float e;
    private Paint f;
    private Paint g;
    private Paint h;
    private RectF i;

    public b(DynamicDetailChartOld dynamicdetailchartold)
    {
        c = dynamicdetailchartold;
        super();
        d = 0;
        value = 24;
        offset = d;
        f = new TextPaint(1);
        f.setColor(0x4dffffff);
        f.setTextSize(9F * mDensity);
        g = new Paint(1);
        g.setColor(0x1affffff);
        h = new Paint(1);
        h.setColor(0x33ffffff);
        h.setStrokeWidth(1.0F);
        h.setStyle(android.graphics.Paint.Style.STROKE);
    }

    static int a(b b1, int j)
    {
        b1.d = j;
        return j;
    }

    public void a()
    {
        mScroll = (float)(d - offset) * e;
        DynamicDetailChartOld.a(c, mScroll);
    }

    public float b()
    {
        return e * (float)value;
    }

    public float c()
    {
        return mScroll - (float)d * e;
    }

    public float d()
    {
        return (float)d * e;
    }

    protected void doScroll(float f1)
    {
        offset = -(int)(mScroll / e) + d;
    }

    protected void draw(Canvas canvas, RectF rectf, float f1)
    {
        i.bottom = rectf.bottom;
        RectF rectf1 = i;
        rectf1.bottom = rectf1.bottom - DynamicDetailChartOld.a(c);
        RectF rectf2 = i;
        rectf2.bottom = rectf2.bottom + c();
        canvas.drawRoundRect(i, i.width() / 2.0F, i.width() / 2.0F, g);
        canvas.drawRoundRect(i, i.width() / 2.0F, i.width() / 2.0F, h);
        Rect rect = new Rect();
        int j = 0;
        while (j < value - offset) 
        {
            int k = j + offset % value;
            if (k < 0)
            {
                k += value;
            }
            if (k > value)
            {
                k %= value;
            }
            if (k == value)
            {
                k = 0;
            }
            float f2;
            String s;
            if ((mScroll / e) % 1.0F == 0.0F)
            {
                f2 = 0.0F;
            } else
            {
                f2 = mScroll % e;
            }
            s = String.valueOf(k);
            f.getTextBounds(s, 0, s.length(), rect);
            canvas.drawText(s, (float)(stroke - rect.width()) / 2.0F + rectf.left, f2 + ((float)j * e + (e + (float)rect.height()) / 2.0F + rectf.top + mPaddingTop), f);
            j++;
        }
    }

    public float e()
    {
        int j = -offset % value;
        if (f())
        {
            j = -offset % value + value;
        }
        return (float)j * e + mScroll % e;
    }

    public boolean f()
    {
        return mScroll - (float)d * e < 0.0F && (mScroll - (float)d * e) % b() < 0.0F;
    }

    public int g()
    {
        return offset / value;
    }

    public float h()
    {
        float f1 = (float)(-g()) * b();
        if (f())
        {
            f1 = (float)(-g()) * b() + e * (float)d;
        }
        return f1;
    }

    protected void onRectChanged(RectF rectf)
    {
        e = (rectf.height() - mPaddingTop - mPaddingBottom - DynamicDetailChartOld.a(c)) / (float)value;
        a();
        i = new RectF(rectf);
        float f1 = i.width() / 2.0F;
        RectF rectf1 = i;
        rectf1.top = rectf1.top - f1;
    }
}
