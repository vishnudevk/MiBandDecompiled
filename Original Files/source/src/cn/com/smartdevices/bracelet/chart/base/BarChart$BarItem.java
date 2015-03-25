// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.base;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.base:
//            BaseChart, Renderer

public class  extends BaseChart
{

    public int index;
    public boolean needDraw;
    public int scope;
    public int value;

    protected void draw(Canvas canvas, RectF rectf, float f)
    {
        if (!needDraw)
        {
            return;
        } else
        {
            float f1 = rectf.left + rectf.width() / 2.0F;
            float f2 = rectf.bottom;
            float f3 = rectf.left + rectf.width() / 2.0F;
            float f4 = rectf.bottom - f * rectf.height();
            mRenderer.paint.setStrokeWidth(rectf.width());
            canvas.drawLine(f1, f2, f3, f4, mRenderer.paint);
            return;
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
            float f1 = rectf.left + rectf.width() / 2.0F;
            float f2 = rectf.top;
            float f3 = rectf.left + rectf.width() / 2.0F;
            float f4 = rectf.top + f * rectf.height();
            mRenderer.paint.setStrokeWidth(rectf.width());
            canvas.drawLine(f1, f2, f3, f4, mRenderer.paint);
            return;
        } else
        {
            draw(canvas, rectf, f);
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder()).append("Value : ").append(value).toString()).append(" , ");
        stringbuilder.append((new StringBuilder()).append("Index : ").append(index).toString()).append(" , ");
        stringbuilder.append((new StringBuilder()).append("Scope : ").append(scope).toString()).append(" , ");
        stringbuilder.append((new StringBuilder()).append("NeedDrow : ").append(needDraw).toString());
        return stringbuilder.toString();
    }

    public ()
    {
    }
}
