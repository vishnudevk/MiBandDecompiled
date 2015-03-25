// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import cn.com.smartdevices.bracelet.Debug;

public class RadioRuler extends View
{

    public static final int RULER_TYPE_AM = 1002;
    public static final int RULER_TYPE_FM = 1001;
    public static final int RULER_TYPE_NONE = 1000;
    private static final float k = 84F;
    private static final float l = 1F;
    private static final float m = 110F;
    private static final float n = 83.5F;
    private static final float o = 500F;
    private static final float p = 495F;
    private static final float q = 1600F;
    private static final float r = 10F;
    private Bitmap a;
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private final int e = 15;
    private Paint f;
    private float g;
    private float h;
    private float i;
    private final String j = "Ruler";
    private int s;
    private final int t = 405;
    private float u;
    private Scroller v;
    private ScrollListener w;

    public RadioRuler(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        b = null;
        c = null;
        d = null;
        f = null;
        g = 0.0F;
        h = 0.0F;
        i = 0.0F;
        s = 1000;
        u = 0.0F;
        v = null;
        w = null;
        v = new Scroller(context);
        setFocusable(true);
        f = new Paint();
        f.setAntiAlias(true);
        f.setColor(-1);
        f.setTextSize(15F);
        if (1000 == s)
        {
            setRulerType(1001);
        }
    }

    private float a()
    {
        return s != 1002 ? 110F : 1600F;
    }

    private void a(float f1)
    {
        if (f1 < 0.0F && u > a())
        {
            return;
        }
        if (f1 + g > 0.0F) goto _L2; else goto _L1
_L1:
        g = f1 + g;
        h = g % 300F;
        if (h <= 0.0F) goto _L4; else goto _L3
_L3:
        h = h - 300F;
_L5:
        invalidate();
        return;
_L4:
        if (h < -300F)
        {
            h = 300F + h;
        }
        if (true) goto _L5; else goto _L2
_L2:
        g = 0.0F;
        h = 0.0F;
        invalidate();
        return;
    }

    private void a(Canvas canvas)
    {
        float f1;
        int i1;
        f1 = 68F + g;
        i1 = -1;
_L7:
        if (f1 > 800F) goto _L2; else goto _L1
_L1:
        i1++;
        if (f1 < 0.0F)
        {
            f1 += 150F;
            continue; /* Loop/switch isn't completed */
        }
        s;
        JVM INSTR tableswitch 1002 1002: default 56
    //                   1002 108;
           goto _L3 _L4
_L3:
        u = 84F + 1.0F * (float)i1;
_L5:
        canvas.drawText((new StringBuilder()).append(u).append("").toString(), f1, 15F, f);
        f1 += 150F;
        continue; /* Loop/switch isn't completed */
_L4:
        u = 500F + 10F * (float)i1;
        if (true) goto _L5; else goto _L2
_L2:
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private float b()
    {
        int i1 = Math.abs((int)FloatUtility.divide(g, 15F));
        switch (s)
        {
        default:
            return 0.0F;

        case 1001: 
            return FloatUtility.add(2.7F, FloatUtility.add(83.5F, FloatUtility.mulitiply(i1, FloatUtility.divide(1.0F, 10F))));

        case 1002: 
            return FloatUtility.add(27F, FloatUtility.add(495F, FloatUtility.mulitiply(i1, FloatUtility.divide(10F, 10F))));
        }
    }

    private void b(float f1)
    {
        v.startScroll((int)g, 0, (int)f1, 0, 100);
        for (; v.computeScrollOffset(); invalidate())
        {
            g = v.getCurrX();
        }

    }

    public void DrawRuler(Canvas canvas)
    {
        canvas.drawBitmap(b, 0.0F, 0.0F, null);
        Debug.i("Ruler", (new StringBuilder()).append("startview position is ").append(h).toString());
        Debug.i("Ruler", (new StringBuilder()).append("scroll distance position is ").append(g).toString());
        h = g % 300F;
        if (h < -100F)
        {
            canvas.drawBitmap(a, 900F + h, 20F, null);
        }
        canvas.drawBitmap(a, h, 20F, null);
        canvas.drawBitmap(a, 300F + h, 20F, null);
        canvas.drawBitmap(a, 600F + h, 20F, null);
        a(canvas);
        canvas.drawBitmap(d, 395F, 20F, null);
        canvas.drawBitmap(c, 0.0F, 0.0F, null);
    }

    public void initalSrc(Bitmap bitmap, Bitmap bitmap1, Bitmap bitmap2, Bitmap bitmap3)
    {
        a = bitmap;
        b = bitmap1;
        c = bitmap2;
        d = bitmap3;
    }

    protected void onDraw(Canvas canvas)
    {
        DrawRuler(canvas);
    }

    protected void onMeasure(int i1, int j1)
    {
        setMeasuredDimension(800, 72);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (v == null || v.isFinished()) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        switch (motionevent.getAction())
        {
        default:
            return true;

        case 0: // '\0'
            i = motionevent.getX();
            return true;

        case 2: // '\002'
            float f1 = motionevent.getX() - i;
            i = motionevent.getX();
            a(f1);
            if (w != null)
            {
                w.onScroll();
                return true;
            }
            break;

        case 1: // '\001'
            b(-(g % 15F));
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (w == null) goto _L1; else goto _L4
_L4:
        w.onScrollEnd(b());
        return true;
    }

    public void setFreq(int i1, float f1)
    {
        switch (i1)
        {
        default:
            return;

        case 1001: 
            s = 1001;
            g = 15F * -((f1 - 83.5F) / 0.1F - 27F);
            return;

        case 1002: 
            s = 1002;
            break;
        }
        g = 15F * -((f1 - 495F) / 1.0F - 27F);
    }

    public void setRulerType(int i1)
    {
        switch (i1)
        {
        default:
            s = 1001;
            return;

        case 1002: 
            s = 1002;
            break;
        }
    }

    public void setScrollListener(ScrollListener scrolllistener)
    {
        w = scrolllistener;
    }

    public void smoothScrollToFreq(float f1)
    {
        int i1;
        float f2;
        i1 = s;
        f2 = 0.0F;
        i1;
        JVM INSTR tableswitch 1001 1002: default 32
    //                   1001 43
    //                   1002 61;
           goto _L1 _L2 _L3
_L1:
        b(f2 - g);
        return;
_L2:
        f2 = 15F * -((f1 - 83.5F) / 0.1F - 27F);
        continue; /* Loop/switch isn't completed */
_L3:
        f2 = 15F * -((f1 - 495F) / 1.0F - 27F);
        if (true) goto _L1; else goto _L4
_L4:
    }

    private class FloatUtility
    {

        public static float add(float f1, float f2)
        {
            return (new BigDecimal(Float.toString(f1))).add(new BigDecimal(Float.toString(f2))).floatValue();
        }

        public static float divide(float f1, float f2)
        {
            return (new BigDecimal(Float.toString(f1))).divide(new BigDecimal(Float.toString(f2))).floatValue();
        }

        public static float mulitiply(float f1, float f2)
        {
            return (new BigDecimal(Float.toString(f1))).multiply(new BigDecimal(Float.toString(f2))).floatValue();
        }

        public FloatUtility()
        {
        }
    }


    private class ScrollListener
    {

        public abstract void onScroll();

        public abstract void onScrollEnd(float f1);
    }

}
