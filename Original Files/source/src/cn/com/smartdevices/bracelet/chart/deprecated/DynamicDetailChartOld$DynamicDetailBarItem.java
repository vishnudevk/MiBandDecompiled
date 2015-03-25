// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import cn.com.smartdevices.bracelet.chart.base.Renderer;

public class  extends cn.com.smartdevices.bracelet.chart.base.rItem
{

    boolean a;

    protected void draw(Canvas canvas, RectF rectf, float f)
    {
        if (needDraw)
        {
            float f1 = rectf.height() / 2.0F;
            if (f1 > 30F * mDensity)
            {
                f1 = 30F * mDensity;
            }
            RectF rectf1 = new RectF(rectf);
            rectf1.left = rectf1.left - f1;
            rectf1.right = rectf1.left + f * rectf1.width();
            canvas.save();
            canvas.clipRect(rectf);
            canvas.drawRoundRect(rectf1, f1, f1, mRenderer.paint);
            canvas.restore();
            Paint paint = new Paint(1);
            paint.setTextSize(8.5F * mDensity);
            paint.setColor(-1);
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            Rect rect = new Rect();
            paint.getTextBounds(String.valueOf(value), 0, String.valueOf(value).length(), rect);
            float f2 = f * (rectf.right - (float)rect.width() - 10F * mDensity);
            float f3 = rectf.top + 13.5F * mDensity;
            if (value >= 500 && a)
            {
                canvas.save();
                canvas.clipRect(rectf);
                canvas.drawText(String.valueOf(value), f2, f3, paint);
                canvas.restore();
                return;
            }
        }
    }

    protected void draw(Canvas canvas, RectF rectf, float f, boolean flag)
    {
        if (!needDraw)
        {
            return;
        }
        if (flag)
        {
            float f1 = rectf.height() / 2.0F;
            RectF rectf1 = new RectF(rectf);
            rectf1.right = f1 + rectf1.right;
            canvas.save();
            canvas.clipRect(rectf);
            canvas.drawRoundRect(rectf1, f1, f1, mRenderer.paint);
            canvas.restore();
            return;
        } else
        {
            draw(canvas, rectf, f);
            return;
        }
    }

    public ()
    {
    }
}
