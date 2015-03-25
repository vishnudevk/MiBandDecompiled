// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;

public class CalibrationView extends View
{

    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Paint i;
    private Paint j;
    private TextPaint k;

    public CalibrationView(Context context)
    {
        super(context);
        a = 400;
        b = 800;
        c = 0;
        d = 100;
        e = 1;
        f = 5;
        g = 0;
        h = 50;
        i = new Paint();
        j = new Paint();
        k = new TextPaint();
        i.setAntiAlias(true);
        i.setColor(0xff4cc2e0);
        i.setStrokeWidth(3F);
        j.setAntiAlias(true);
        j.setColor(0xffc9c9c9);
        i.setStrokeWidth(2.0F);
    }

    protected void onDraw(Canvas canvas)
    {
        int l = canvas.getWidth();
        int i1 = canvas.getHeight();
        canvas.drawLine((l * 2) / 3, i1 / 2, l, i1 / 2, i);
        int _tmp = (l * 9) / 10 / 2;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return super.onTouchEvent(motionevent);
    }
}
