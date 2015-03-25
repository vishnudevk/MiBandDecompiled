// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextPaint;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            DynamicDetailChart

class b extends cn.com.smartdevices.bracelet.chart.base.BarChart.XAxis
{

    final DynamicDetailChart a;
    private int b;
    private float c;
    private Paint d;
    private Paint e;
    private Bitmap f;
    private Bitmap g;

    public b(DynamicDetailChart dynamicdetailchart, Context context)
    {
        a = dynamicdetailchart;
        super(context);
        b = 0;
        value = 24;
        offset = b;
        d = new TextPaint(1);
        d.setColor(0x66000000);
        d.setTextSize(9F * mDensity);
        e = new Paint();
        e.setColor(0xfff2f2f2);
    }

    static int a(b b1, int j)
    {
        b1.b = j;
        return j;
    }

    private void a(Canvas canvas, RectF rectf)
    {
        if (DynamicDetailChart.d(a) == DynamicDetailChart.e(a))
        {
            return;
        } else
        {
            Rect rect = new Rect();
            float f1 = rectf.left + 8F * mDensity;
            float f2 = rectf.centerY();
            ChartUtil.drawBitmapCenter(canvas, f1, f2, mDensityScale, false, true, f, null);
            String s = ChartData.formatTime(DynamicDetailChart.d(a));
            d.getTextBounds(s, 0, s.length(), rect);
            rect.offset((int)(f1 + 15F * mDensity), (int)((double)(f2 + (float)(rect.height() / 2)) - 0.66000000000000003D * (double)mDensity));
            ChartUtil.drawTextCenter(canvas, new RectF(rect), s, d);
            float f3 = rectf.right - 8F * mDensity - (float)g.getWidth() * mDensityScale;
            float f4 = rectf.centerY();
            ChartUtil.drawBitmapCenter(canvas, f3, f4, mDensityScale, false, true, g, null);
            String s1 = ChartData.formatTime(DynamicDetailChart.e(a));
            d.getTextBounds(s1, 0, s1.length(), rect);
            rect.offset((int)(f3 - (float)rect.width() - 6F * mDensity), (int)((double)(f4 + (float)(rect.height() / 2)) - 0.66000000000000003D * (double)mDensity));
            ChartUtil.drawTextCenter(canvas, new RectF(rect), s1, d);
            return;
        }
    }

    private void b(Canvas canvas, RectF rectf)
    {
        if (DynamicDetailChart.a(a) != DynamicDetailChart.b(a))
        {
            Rect rect = new Rect();
            boolean flag;
            int j;
            if (1 + (DynamicDetailChart.b(a) - DynamicDetailChart.a(a)) >= 20)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            j = 0;
            while (j < 1 + (DynamicDetailChart.b(a) - DynamicDetailChart.a(a))) 
            {
                int k = j + DynamicDetailChart.a(a);
                if (k < 0)
                {
                    k += 24;
                }
                if (k % 2 == 0)
                {
                    float f1;
                    String s;
                    if ((mScroll / c) % 1.0F == 0.0F)
                    {
                        f1 = 0.0F;
                    } else
                    {
                        f1 = mScroll % c;
                    }
                    if (!flag)
                    {
                        s = ChartData.formatTime(k * 60);
                    } else
                    {
                        s = String.valueOf(k);
                    }
                    d.getTextBounds(s, 0, s.length(), rect);
                    canvas.drawText(s, f1 + ((float)j * c + (c - (float)rect.width()) / 2.0F + rectf.left + mPaddingLeft), (float)(stroke + rect.height()) / 2.0F + rectf.top, d);
                }
                j++;
            }
        }
    }

    private void i()
    {
        if (f == null)
        {
            f = ((BitmapDrawable)mContext.getResources().getDrawable(0x7f020068)).getBitmap();
        }
        if (g == null)
        {
            g = ((BitmapDrawable)mContext.getResources().getDrawable(0x7f020067)).getBitmap();
        }
    }

    public void a()
    {
        mScroll = (float)(b - offset) * c;
        DynamicDetailChart.a(a, mScroll);
    }

    public float b()
    {
        return c * (float)value;
    }

    public float c()
    {
        return mScroll - (float)b * c;
    }

    public float d()
    {
        return (float)b * c;
    }

    protected void doScroll(float f1)
    {
        offset = -(int)(mScroll / c) + b;
    }

    protected void draw(Canvas canvas, RectF rectf, float f1)
    {
        canvas.drawRect(rectf, e);
        if (DynamicDetailChart.c(a) == 16)
        {
            i();
            a(canvas, rectf);
        } else
        if (DynamicDetailChart.c(a) == 1)
        {
            b(canvas, rectf);
            return;
        }
    }

    public float e()
    {
        int j = -offset % value;
        if (f())
        {
            j = -offset % value + value;
        }
        return (float)j * c + mScroll % c;
    }

    public boolean f()
    {
        return mScroll - (float)b * c < 0.0F && (mScroll - (float)b * c) % b() < 0.0F;
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
            f1 = (float)(-g()) * b() + c * (float)b;
        }
        return f1;
    }

    public void notifyChanged()
    {
        if (mRect != null && DynamicDetailChart.a(a) != DynamicDetailChart.b(a))
        {
            c = (mRect.width() - mPaddingLeft - mPaddingRight) / (float)(1 + (DynamicDetailChart.b(a) - DynamicDetailChart.a(a)));
        }
    }

    protected void onRectChanged(RectF rectf)
    {
        a();
    }
}
