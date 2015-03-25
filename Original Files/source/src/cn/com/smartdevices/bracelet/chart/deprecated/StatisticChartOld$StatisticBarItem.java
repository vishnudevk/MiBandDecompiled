// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.Renderer;

public class  extends cn.com.smartdevices.bracelet.chart.base.rItem
{

    protected void draw(Canvas canvas, RectF rectf, float f)
    {
        if (!needDraw && rectf.height() == 0.0F)
        {
            return;
        } else
        {
            float f1 = rectf.left + rectf.width() / 2.0F;
            float f2 = rectf.bottom;
            float f3 = rectf.bottom - f * rectf.height();
            mRenderer.paint.setStrokeWidth(rectf.width());
            canvas.drawLine(f1, f2, f1, f3, mRenderer.paint);
            return;
        }
    }

    public ()
    {
    }
}
