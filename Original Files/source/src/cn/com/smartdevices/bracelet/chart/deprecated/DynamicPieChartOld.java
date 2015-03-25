// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import cn.com.smartdevices.bracelet.chart.base.PieChart;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;

public class DynamicPieChartOld extends PieChart
{

    public static final int MODE_CALORIE = 2;
    public static final int MODE_GOAL = 3;
    public static final int MODE_NONE = 0;
    public static final int MODE_STEPS = 1;
    private static final String a = "Chart.DynamicPieChart";
    private static final float b = 8.3F;
    private boolean c;
    private int d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Paint h;
    private Paint i;
    private Matrix j;
    private Shader k;
    private float l;
    private RectF m;
    private float n;
    private Paint o;
    private RectF p;

    public DynamicPieChartOld(Context context)
    {
        super(context);
        d = 1;
        h = new Paint(1);
        i = new Paint(1);
        h.setStrokeWidth(8.3F * mDensity);
        h.setStyle(android.graphics.Paint.Style.STROKE);
        h.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        i.setColor(Color.parseColor("#33ffffff"));
        i.setStrokeWidth(8.3F * mDensity);
        i.setStyle(android.graphics.Paint.Style.STROKE);
        j = new Matrix();
        n = 20F * mDensity;
        o = new Paint(1);
        o.setColor(Color.parseColor("#33ffffff"));
        o.setStrokeWidth(1.0F * mDensity);
        o.setStyle(android.graphics.Paint.Style.STROKE);
    }

    public void dismissLoading()
    {
        c = false;
    }

    protected void drawPie(Canvas canvas, RectF rectf, float f1, float f2, float f3, float f4, float f5)
    {
        canvas.drawCircle(f1, f2, f3 - o.getStrokeWidth() / 2.0F - n, o);
        canvas.drawCircle(f1, f2, f3 - i.getStrokeWidth() / 2.0F - 2.0F * n, i);
        float f6 = f4 * f5;
        if (f6 > 1.0F)
        {
            f6 = 1.0F;
        }
        if (c)
        {
            int ai[] = {
                0xffffff, -1, 0xffffff
            };
            if (f6 == 0.0F)
            {
                f6 = 0.5F;
            }
            k = new SweepGradient(f1, f2, ai, new float[] {
                0.0F, f6, 1.0F
            });
            j.setRotate(-90F + mRotate, f1, f2);
            k.setLocalMatrix(j);
            h.setShader(k);
        } else
        {
            h.setShader(null);
            h.setColor(-1);
        }
        if (f6 < 1.0F)
        {
            canvas.drawArc(m, -90F + mRotate + l, f6 * (360F - 2.0F * l), false, h);
        } else
        {
            canvas.drawCircle(f1, f2, f3 - i.getStrokeWidth() / 2.0F - 2.0F * n, h);
        }
        switch (d)
        {
        case 0: // '\0'
        default:
            return;

        case 1: // '\001'
            ChartUtil.erase(canvas, p);
            ChartUtil.drawBitmapCenter(canvas, p.centerX(), p.centerY(), mDensityScale, e, null);
            return;

        case 2: // '\002'
            ChartUtil.erase(canvas, p);
            ChartUtil.drawBitmapCenter(canvas, p.centerX(), p.centerY(), mDensityScale, f, null);
            return;

        case 3: // '\003'
            ChartUtil.erase(canvas, p);
            break;
        }
        ChartUtil.drawBitmapCenter(canvas, p.centerX(), p.centerY(), mDensityScale, g, null);
    }

    protected void onRectChanged(RectF rectf)
    {
        super.onRectChanged(rectf);
        l = (float)(360D * ((double)(h.getStrokeWidth() / 2.0F) / (3.1415926535897931D * (double)(2.0F * (mRadius - 2.0F * n)))));
        m = new RectF(rectf);
        RectF rectf1 = m;
        rectf1.left = rectf1.left + (h.getStrokeWidth() / 2.0F + 2.0F * n);
        RectF rectf2 = m;
        rectf2.top = rectf2.top + (h.getStrokeWidth() / 2.0F + 2.0F * n);
        RectF rectf3 = m;
        rectf3.right = rectf3.right - (h.getStrokeWidth() / 2.0F + 2.0F * n);
        RectF rectf4 = m;
        rectf4.bottom = rectf4.bottom - (h.getStrokeWidth() / 2.0F + 2.0F * n);
        p = new RectF();
        p.left = (rectf.left + rectf.width() / 2.0F) - 16F * mDensity;
        p.top = rectf.top + 8F * mDensity;
        p.right = p.left + 32F * mDensity;
        p.bottom = p.top + 24F * mDensity;
    }

    public void showLoading()
    {
        c = true;
    }

    public void updateMode(int i1)
    {
        d = i1;
    }
}
