// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            s, t

public class RoundProgressBar extends View
{

    public static final int FILL = 1;
    public static final int STROKE;
    private Paint a;
    private int b;
    private int c;
    private int d;
    private float e;
    private float f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private int m;
    private Bitmap n;
    private ValueAnimator o;

    public RoundProgressBar(Context context)
    {
        this(context, null);
    }

    public RoundProgressBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        i = 0;
        j = 0;
        m = -1;
        n = null;
        o = null;
        a = new Paint();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.xiaomi.hm.health.R.styleable.RoundProgressBar);
        b = typedarray.getColor(0, 0xffff0000);
        c = typedarray.getColor(1, 0xff00ff00);
        d = typedarray.getColor(3, 0xff00ff00);
        e = typedarray.getDimension(4, 15F);
        f = typedarray.getDimension(2, 5F);
        g = typedarray.getInteger(5, 100);
        k = typedarray.getBoolean(6, true);
        l = typedarray.getInt(7, 0);
        m = typedarray.getResourceId(8, -1);
        if (m != -1)
        {
            n = BitmapFactory.decodeResource(getResources(), m);
        }
        typedarray.recycle();
    }

    static int a(RoundProgressBar roundprogressbar)
    {
        return roundprogressbar.i;
    }

    static int a(RoundProgressBar roundprogressbar, int i1)
    {
        roundprogressbar.i = i1;
        return i1;
    }

    private void a(int i1, float f1, float f2)
    {
        while (i1 <= 0 || f1 >= f2) 
        {
            return;
        }
        o = ValueAnimator.ofFloat(new float[] {
            f1, f2
        });
        o.setDuration(i1 * 20);
        LinearInterpolator linearinterpolator = new LinearInterpolator();
        o.setInterpolator(linearinterpolator);
        o.addListener(new s(this));
        o.addUpdateListener(new t(this));
        o.start();
    }

    static void a(RoundProgressBar roundprogressbar, int i1, float f1, float f2)
    {
        roundprogressbar.a(i1, f1, f2);
    }

    static int b(RoundProgressBar roundprogressbar)
    {
        return roundprogressbar.j;
    }

    static int b(RoundProgressBar roundprogressbar, int i1)
    {
        roundprogressbar.h = i1;
        return i1;
    }

    static int c(RoundProgressBar roundprogressbar)
    {
        return roundprogressbar.h;
    }

    public int getCricleColor()
    {
        return b;
    }

    public int getCricleProgressColor()
    {
        return c;
    }

    public int getMax()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = g;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public int getProgress()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = h;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public float getRoundWidth()
    {
        return f;
    }

    public int getTextColor()
    {
        return d;
    }

    public float getTextSize()
    {
        return e;
    }

    protected void onDraw(Canvas canvas)
    {
        RectF rectf;
        super.onDraw(canvas);
        int i1 = getWidth() / 2;
        int j1 = (int)((float)i1 - f / 2.0F);
        a.setColor(b);
        a.setStyle(android.graphics.Paint.Style.STROKE);
        a.setStrokeWidth(f);
        a.setAntiAlias(true);
        canvas.drawCircle(i1, i1, j1, a);
        a.setStrokeWidth(0.0F);
        a.setColor(d);
        a.setTextSize(e);
        a.setTypeface(Typeface.DEFAULT_BOLD);
        int k1 = (int)(100F * ((float)h / (float)g));
        float f1 = a.measureText((new StringBuilder()).append(k1).append("%").toString());
        if (k && k1 != 0 && l == 0)
        {
            canvas.drawText((new StringBuilder()).append(k1).append("%").toString(), (float)i1 - f1 / 2.0F, (float)i1 + e / 2.0F, a);
        }
        if (n != null)
        {
            int l1 = n.getWidth();
            int i2 = n.getHeight();
            canvas.drawBitmap(n, i1 - l1 / 2, i1 - i2 / 2, null);
        }
        a.setStrokeWidth(f);
        a.setColor(c);
        rectf = new RectF(i1 - j1, i1 - j1, i1 + j1, i1 + j1);
        l;
        JVM INSTR tableswitch 0 1: default 348
    //                   0 349
    //                   1 389;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        a.setStyle(android.graphics.Paint.Style.STROKE);
        canvas.drawArc(rectf, -90F, 360F * ((float)h / (float)g), false, a);
        return;
_L3:
        a.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        if (h != 0)
        {
            canvas.drawArc(rectf, -90F, 360F * ((float)h / (float)g), true, a);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setCricleColor(int i1)
    {
        b = i1;
    }

    public void setCricleProgressColor(int i1)
    {
        c = i1;
    }

    public void setMax(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (i1 >= 0)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        throw new IllegalArgumentException("max not less than 0");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        g = i1;
        this;
        JVM INSTR monitorexit ;
    }

    public void setProgress(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (i1 >= 0)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        throw new IllegalArgumentException("progress not less than 0");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (i1 > g)
        {
            h = g;
        }
        if (i1 <= g)
        {
            h = i1;
            postInvalidateOnAnimation();
        }
        this;
        JVM INSTR monitorexit ;
    }

    public void setRoundWidth(float f1)
    {
        f = f1;
    }

    public void setTextColor(int i1)
    {
        d = i1;
    }

    public void setTextSize(float f1)
    {
        e = f1;
    }
}
