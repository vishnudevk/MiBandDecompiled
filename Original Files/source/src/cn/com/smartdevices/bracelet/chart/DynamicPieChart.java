// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import cn.com.smartdevices.bracelet.chart.base.PieChart;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;

public class DynamicPieChart extends PieChart
{

    private static final String a = "Chart.DynamicPieChart";
    private static final float b = 1.33F;
    private static final float c = 14.33F;
    private static final float d = 16.33F;
    private static final int e = 200;
    private boolean f;
    private int g;
    private Bitmap h;
    private Bitmap i;
    private Paint j;
    private Paint k;
    private float l;
    private Paint m;
    private RectF n;
    private float o;
    private float p[];
    private Bitmap q;
    private Canvas r;
    private boolean s;
    private View t;

    public DynamicPieChart(Context context)
    {
        super(context);
        h = ((BitmapDrawable)context.getResources().getDrawable(0x7f02006a)).getBitmap();
        i = ((BitmapDrawable)context.getResources().getDrawable(0x7f020069)).getBitmap();
        j = new Paint(1);
        k = new Paint(1);
        j.setColor(Color.parseColor("#e8edf3"));
        j.setStrokeWidth(1.33F * mDensity);
        j.setStyle(android.graphics.Paint.Style.STROKE);
        k.setColor(Color.parseColor("#33e8edf3"));
        k.setStrokeWidth(1.33F * mDensity);
        k.setStyle(android.graphics.Paint.Style.STROKE);
        o = 14.33F * mDensity;
        l = 16.33F * mDensity;
        m = new Paint(1);
        m.setColor(Color.parseColor("#33e8edf3"));
        m.setStrokeWidth(1.0F);
        m.setStyle(android.graphics.Paint.Style.STROKE);
    }

    public DynamicPieChart(Context context, View view)
    {
        this(context);
        t = view;
    }

    private void a(float f1, float f2, float f3, Canvas canvas)
    {
        canvas.drawCircle(f1, f2, f3 - m.getStrokeWidth() / 2.0F - l, m);
        if (g > 0)
        {
            ChartUtil.erase(canvas, n);
        }
        a(canvas, f1, f2, f3, k, 200);
    }

    private void a(Canvas canvas, float f1, float f2, float f3, Paint paint, int i1)
    {
        if (p == null)
        {
            p = new float[800];
            float f4 = f3 - m.getStrokeWidth() / 2.0F - 2.0F * l;
            float f5 = f3 - m.getStrokeWidth() / 2.0F - 2.0F * l - o;
            for (int j1 = 0; j1 < 200; j1++)
            {
                float f6 = 0.03141593F * (float)j1;
                float f7 = (float)((double)f1 + Math.sin(f6) * (double)f4);
                float f8 = (float)((double)f2 - Math.cos(f6) * (double)f4);
                float f9 = (float)((double)f1 + Math.sin(f6) * (double)f5);
                float f10 = (float)((double)f2 - Math.cos(f6) * (double)f5);
                p[j1 * 4] = f7;
                p[1 + j1 * 4] = f8;
                p[2 + j1 * 4] = f9;
                p[3 + j1 * 4] = f10;
            }

        }
        canvas.drawLines(p, 0, i1 * 4, paint);
    }

    public void dismissLoading()
    {
        f = false;
    }

    protected void drawPie(Canvas canvas, RectF rectf, float f1, float f2, float f3, float f4, float f5)
    {
        float f6;
        if (q != null)
        {
            if (!s)
            {
                a(f1, f2, f3, r);
                s = true;
            }
            canvas.drawBitmap(q, 0.0F, 0.0F, null);
        } else
        {
            a(f1, f2, f3, canvas);
        }
        g;
        JVM INSTR lookupswitch 2: default 72
    //                   1: 177
    //                   16: 207;
           goto _L1 _L2 _L3
_L1:
        f6 = f4 * f5;
        if (f6 > 1.0F)
        {
            f6 = 1.0F;
        }
        if (!f) goto _L5; else goto _L4
_L4:
        canvas.save();
        canvas.rotate(360F * mRotate, f1, f2);
        if (f6 < 0.3F)
        {
            f6 = 0.3F;
        }
        if (f6 > 0.6F)
        {
            f6 = 0.6F;
        }
        a(canvas, f1, f2, f3, j, (int)(f6 * 200F));
        canvas.restore();
_L7:
        return;
_L2:
        ChartUtil.drawBitmapCenter(canvas, n.centerX(), n.centerY(), mDensityScale, h, null);
        continue; /* Loop/switch isn't completed */
_L3:
        ChartUtil.drawBitmapCenter(canvas, n.centerX(), n.centerY(), mDensityScale, i, null);
        continue; /* Loop/switch isn't completed */
_L5:
        if (f6 > 0.0F || f6 < 1.0F)
        {
            a(canvas, f1, f2, f3, j, (int)(f6 * 200F));
            return;
        }
        if (f6 != 1.0F) goto _L7; else goto _L6
_L6:
        a(canvas, f1, f2, f3, j, 200);
        return;
        if (true) goto _L1; else goto _L8
_L8:
    }

    protected void onRectChanged(RectF rectf)
    {
        super.onRectChanged(rectf);
        n = new RectF();
        n.left = rectf.centerX() - 15.5F * mDensity;
        n.top = rectf.top + 2.0F * mDensity;
        n.right = n.left + 31F * mDensity;
        n.bottom = n.top + 31F * mDensity;
        s = false;
        if (r != null)
        {
            r.setBitmap(null);
            if (q != null)
            {
                q.recycle();
                q = null;
            }
        }
        r = new Canvas();
        r.setDrawFilter(new PaintFlagsDrawFilter(0, 7));
        try
        {
            q = Bitmap.createBitmap((int)rectf.width(), (int)rectf.height(), android.graphics.Bitmap.Config.ARGB_8888);
            r.setBitmap(q);
            return;
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            outofmemoryerror.printStackTrace();
        }
        r = null;
        q = null;
        t.setLayerType(1, null);
    }

    public void setMode(int i1)
    {
        g = i1;
    }

    public void showLoading()
    {
        f = true;
    }
}
