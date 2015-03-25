// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

public class d extends ReplacementSpan
{

    private float a;
    private float b;
    private float c;
    private float d;

    public void draw(Canvas canvas, CharSequence charsequence, int i, int j, float f, int k, int l, 
            int i1, Paint paint)
    {
        canvas.drawText(charsequence.subSequence(i, j).toString(), (f + a) - c, ((float)l + b) - d, paint);
    }

    public int getSize(Paint paint, CharSequence charsequence, int i, int j, android.graphics.artData.TextMarginSpan textmarginspan)
    {
        return (int)paint.measureText(charsequence.subSequence(i, j).toString());
    }

    public (float f, float f1, float f2, float f3)
    {
        a = f;
        b = f1;
        c = f2;
        d = f3;
    }
}
