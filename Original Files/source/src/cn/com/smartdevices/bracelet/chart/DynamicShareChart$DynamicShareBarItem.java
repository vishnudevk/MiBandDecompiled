// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.Renderer;

public class  extends cn.com.smartdevices.bracelet.chart.base.
{

    protected void draw(Canvas canvas, RectF rectf, float f)
    {
        if (!needDraw)
        {
            return;
        } else
        {
            float f1 = rectf.width() / 2.0F;
            RectF rectf1 = new RectF(rectf);
            rectf1.bottom = f1 + rectf1.bottom;
            canvas.save();
            canvas.clipRect(rectf);
            canvas.drawRoundRect(rectf1, f1, f1, mRenderer.paint);
            canvas.restore();
            return;
        }
    }

    public ()
    {
    }
}
