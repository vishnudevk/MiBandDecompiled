// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import java.util.Iterator;
import java.util.List;

public class ChartUtil
{

    private static float a = -1F;
    private static float b = -1F;

    public ChartUtil()
    {
    }

    public static int colorToColor(int i, int j, float f)
    {
        int k = Color.alpha(i);
        int l = Color.red(i);
        int i1 = Color.green(i);
        int j1 = Color.blue(i);
        int k1 = Color.alpha(j);
        int l1 = Color.red(j);
        int i2 = Color.green(j);
        int j2 = Color.blue(j);
        return Color.argb((int)(f * (float)k1 + (float)k * (1.0F - f)), (int)(f * (float)l1 + (float)l * (1.0F - f)), (int)(f * (float)i2 + (float)i1 * (1.0F - f)), (int)(f * (float)j2 + (float)j1 * (1.0F - f)));
    }

    public static Canvas createFilterCanvas(Bitmap bitmap)
    {
        Canvas canvas = new Canvas(bitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 7));
        return canvas;
    }

    public static void drawBitmapCenter(Canvas canvas, float f, float f1, float f2, Bitmap bitmap, Paint paint)
    {
        drawBitmapCenter(canvas, f, f1, f2, true, true, bitmap, paint);
    }

    public static void drawBitmapCenter(Canvas canvas, float f, float f1, float f2, boolean flag, boolean flag1, Bitmap bitmap, Paint paint)
    {
        if (flag)
        {
            f -= (f2 * (float)bitmap.getWidth()) / 2.0F;
        }
        if (flag1)
        {
            f1 -= (f2 * (float)bitmap.getHeight()) / 2.0F;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f2);
        matrix.postTranslate(f, f1);
        canvas.drawBitmap(bitmap, matrix, paint);
    }

    public static void drawTextCenter(Canvas canvas, RectF rectf, String s, Paint paint)
    {
        Rect rect = new Rect();
        paint.getTextBounds(s, 0, s.length(), rect);
        canvas.drawText(s, rectf.left + (rectf.width() - (float)rect.width()) / 2.0F, rectf.top + (rectf.height() + (float)rect.height()) / 2.0F, paint);
    }

    public static void drawTextCenter(Canvas canvas, RectF rectf, String s, String s1, Paint paint, Paint paint1)
    {
        Rect rect = new Rect();
        paint.getTextBounds(s, 0, s.length(), rect);
        float f = rectf.left + (rectf.width() - (float)rect.width()) / 2.0F;
        float f1 = rectf.top + (rectf.height() + (float)rect.height()) / 2.0F;
        canvas.drawText(s, f, f1, paint);
        Rect rect1 = new Rect();
        paint1.getTextBounds(s, 0, s.length(), rect1);
        canvas.drawText(s1, 6F + (f + (float)rect.width()), (f1 - (float)rect.height()) + (float)rect1.height(), paint1);
    }

    public static void erase(Canvas canvas, RectF rectf)
    {
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setDither(true);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        canvas.drawRect(rectf, paint);
    }

    public static float getDensity()
    {
        if (a < 0.0F)
        {
            a = 1.0F;
        }
        return a;
    }

    public static float getDensity(Context context)
    {
        if (a < 0.0F)
        {
            a = context.getResources().getDisplayMetrics().density;
        }
        return a;
    }

    public static float getDensityScale()
    {
        if (b < 0.0F)
        {
            b = 1.0F;
        }
        return b;
    }

    public static float getDensityScale(Context context)
    {
        if (b < 0.0F)
        {
            b = context.getResources().getDisplayMetrics().density / 3F;
        }
        return b;
    }

    public static float itemLevelSize(int i, int j, float f, int k)
    {
        int l = i / k;
        int i1 = (-1 + (j + l)) / l;
        float f1 = (float)(1 + (j - 1) % l) / (float)l;
        return levelSize(i1 - 1, f, k) + f1 * (levelSize(i1, f, k) - levelSize(i1 - 1, f, k));
    }

    public static float levelSize(int i, float f, int j)
    {
        if (i <= 0)
        {
            return 0.0F;
        } else
        {
            return f * ((float)(i * (j + (1 + (j - i)))) / 2.0F);
        }
    }

    public static float updateLevelSize(int i, float f, int j)
    {
        return (f * ((float)(j * (i / j)) / (float)i)) / ((float)(j * (j + 1)) / 2.0F);
    }

    public static int updateMaxItemValue(List list, int i, int j)
    {
        list;
        JVM INSTR monitorenter ;
        Iterator iterator = list.iterator();
        int k = j;
_L2:
        int l;
        if (iterator.hasNext())
        {
            cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem = (cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem)iterator.next();
            if (baritem.index >= i && baritem.value > k)
            {
                l = baritem.value;
                break MISSING_BLOCK_LABEL_78;
            }
            break MISSING_BLOCK_LABEL_74;
        }
        list;
        JVM INSTR monitorexit ;
        return k;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        l = k;
        k = l;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
