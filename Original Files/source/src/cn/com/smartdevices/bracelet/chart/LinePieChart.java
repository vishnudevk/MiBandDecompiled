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
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.PieChart;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;

public class LinePieChart extends PieChart
{

    private static final String a = "LinePieChart";
    private static final float b = 1.33F;
    private static final float c = 16.33F;
    private int d;
    private final Paint e = new Paint(1);
    private SweepGradient f;
    private boolean g;
    private int h;
    private Bitmap i;
    private Paint j;
    private Paint k;
    private float l;
    private Paint m;
    private Paint n;
    private RectF o;
    private Bitmap p;
    private Canvas q;
    private boolean r;

    public LinePieChart(Context context)
    {
        super(context);
        d = 0;
        i = ((BitmapDrawable)context.getResources().getDrawable(0x7f020078)).getBitmap();
        j = new Paint(1);
        k = new Paint(1);
        j.setColor(Color.parseColor("#e8edf3"));
        j.setStrokeWidth(1.33F * mDensity);
        j.setStyle(android.graphics.Paint.Style.STROKE);
        k.setColor(Color.parseColor("#33e8edf3"));
        k.setStrokeWidth(1.33F * mDensity);
        k.setStyle(android.graphics.Paint.Style.STROKE);
        l = 16.33F * mDensity;
        m = new Paint(1);
        m.setColor(Color.parseColor("#33e8edf3"));
        m.setStrokeWidth(4F);
        m.setStyle(android.graphics.Paint.Style.STROKE);
        n = new Paint(1);
        n.setColor(Color.parseColor("#ffffffff"));
        n.setStrokeWidth(4F);
        n.setStyle(android.graphics.Paint.Style.STROKE);
        e.setStrokeWidth(4F);
        e.setStyle(android.graphics.Paint.Style.STROKE);
    }

    public void dismissLoading()
    {
        Debug.i("LinePieChart", "dismissLoading.");
        g = false;
        r = false;
    }

    protected void drawPie(Canvas canvas, RectF rectf, float f1, float f2, float f3, float f4, float f5)
    {
        h;
        JVM INSTR tableswitch 0 2: default 32
    //                   0 269
    //                   1 219
    //                   2 261;
           goto _L1 _L2 _L3 _L4
_L1:
        RectF rectf1;
        float f6 = f3 - m.getStrokeWidth() / 2.0F - l;
        rectf1 = new RectF(f1 - f6, f2 - f6, f1 + f6, f6 + f2);
        if (!r)
        {
            if (g)
            {
                f = new SweepGradient(f1, f2, new int[] {
                    0x44ffffff, -1
                }, null);
                e.setShader(f);
            }
            r = true;
        }
        if (h == 1 || h == 0)
        {
            canvas.drawArc(rectf1, 270 + d / 2, 360 - d, false, m);
        }
        if (!g) goto _L6; else goto _L5
_L5:
        canvas.rotate(360F * mRotate, f1, f2);
        canvas.drawArc(rectf1, 270F, 360F, false, e);
_L8:
        return;
_L3:
        f4 = 1.0F - f4;
        ChartUtil.drawBitmapCenter(canvas, o.centerX(), o.centerY(), mDensityScale, i, null);
        d = 18;
        continue; /* Loop/switch isn't completed */
_L4:
        d = 0;
        continue; /* Loop/switch isn't completed */
_L2:
        d = 0;
        continue; /* Loop/switch isn't completed */
_L6:
        if (h == 1)
        {
            canvas.drawArc(rectf1, 270 + d / 2, f4 * (float)(360 - d), false, n);
            return;
        }
        if (h != 0) goto _L8; else goto _L7
_L7:
        return;
        if (true) goto _L1; else goto _L9
_L9:
    }

    protected void onRectChanged(RectF rectf)
    {
        super.onRectChanged(rectf);
        o = new RectF();
        o.left = rectf.centerX() - 15.5F * mDensity;
        o.top = rectf.top + 2.0F * mDensity;
        o.right = o.left + 31F * mDensity;
        o.bottom = o.top + 31F * mDensity;
        p = Bitmap.createBitmap((int)rectf.width(), (int)rectf.height(), android.graphics.Bitmap.Config.ARGB_8888);
        r = false;
        if (q == null)
        {
            q = new Canvas();
            q.setDrawFilter(new PaintFlagsDrawFilter(0, 7));
        }
        q.setBitmap(p);
    }

    public void setMode(int i1)
    {
        h = i1;
        r = false;
    }

    public void showLoading()
    {
        g = true;
        r = false;
    }
}
