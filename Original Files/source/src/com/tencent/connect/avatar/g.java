// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class g extends View
{

    private Rect a;
    private Paint b;

    public g(Context context)
    {
        super(context);
        b();
    }

    public g(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    private void b()
    {
        b = new Paint();
    }

    public Rect a()
    {
        if (a == null)
        {
            a = new Rect();
            int i = getMeasuredWidth();
            int j = getMeasuredHeight();
            int k = Math.min(Math.min(-80 + (j - 60), i), 640);
            int l = (i - k) / 2;
            int i1 = (j - k) / 2;
            int j1 = l + k;
            int k1 = k + i1;
            a.set(l, i1, j1, k1);
        }
        return a;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Rect rect = a();
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        b.setStyle(android.graphics.Paint.Style.FILL);
        b.setColor(Color.argb(100, 0, 0, 0));
        canvas.drawRect(0.0F, 0.0F, i, rect.top, b);
        canvas.drawRect(0.0F, rect.bottom, i, j, b);
        canvas.drawRect(0.0F, rect.top, rect.left, rect.bottom, b);
        canvas.drawRect(rect.right, rect.top, i, rect.bottom, b);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        b.setStyle(android.graphics.Paint.Style.STROKE);
        b.setColor(-1);
        canvas.drawRect(rect.left, rect.top, -1 + rect.right, rect.bottom, b);
    }
}
