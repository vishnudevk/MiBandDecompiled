// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.base:
//            Renderer

public class init> extends init>
{

    protected void draw(Canvas canvas, RectF rectf, float f)
    {
        canvas.drawRect(rectf, mRenderer.paint);
    }

    public ()
    {
    }

    public (Context context)
    {
        super(context);
    }
}
