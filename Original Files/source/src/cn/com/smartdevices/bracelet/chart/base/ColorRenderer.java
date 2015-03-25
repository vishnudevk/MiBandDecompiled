// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.base;

import android.graphics.Paint;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.base:
//            Renderer

public class ColorRenderer extends Renderer
{

    public ColorRenderer(int i)
    {
        paint = new Paint(1);
        paint.setColor(i);
    }

    public void setColor(int i)
    {
        paint.setColor(i);
    }
}
