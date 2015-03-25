// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

// Referenced classes of package com.tencent.connect.avatar:
//            j

public class b extends ImageView
{

    final String a;
    public boolean b;
    private Matrix c;
    private Matrix d;
    private int e;
    private float f;
    private float g;
    private Bitmap h;
    private boolean i;
    private float j;
    private float k;
    private PointF l;
    private PointF m;
    private float n;
    private float o;
    private Rect p;

    public b(Context context)
    {
        super(context);
        c = new Matrix();
        d = new Matrix();
        e = 0;
        f = 1.0F;
        g = 1.0F;
        i = false;
        a = "TouchView";
        l = new PointF();
        m = new PointF();
        n = 1.0F;
        o = 0.0F;
        b = false;
        p = new Rect();
        getDrawingRect(p);
        a();
    }

    public b(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = new Matrix();
        d = new Matrix();
        e = 0;
        f = 1.0F;
        g = 1.0F;
        i = false;
        a = "TouchView";
        l = new PointF();
        m = new PointF();
        n = 1.0F;
        o = 0.0F;
        b = false;
        p = new Rect();
        getDrawingRect(p);
        a();
    }

    private float a(MotionEvent motionevent)
    {
        if (motionevent.getPointerCount() < 2)
        {
            return 0.0F;
        } else
        {
            float f1 = motionevent.getX(0) - motionevent.getX(1);
            float f2 = motionevent.getY(0) - motionevent.getY(1);
            return FloatMath.sqrt(f1 * f1 + f2 * f2);
        }
    }

    private void a()
    {
    }

    private void a(PointF pointf)
    {
        float f1 = 1.0F;
        if (h == null)
        {
            return;
        }
        float af[] = new float[9];
        c.getValues(af);
        float f2 = af[2];
        float f3 = af[5];
        float f4 = af[0];
        float f5 = h.getWidth();
        float f6 = h.getHeight();
        float f7 = f5 * f4;
        float f8 = f6 * f4;
        float f9 = (float)p.left - f2;
        if (f9 <= f1)
        {
            f9 = f1;
        }
        float f10 = (f2 + f7) - (float)p.right;
        if (f10 <= f1)
        {
            f10 = f1;
        }
        float f11 = f10 + f9;
        float f12 = (f9 * (float)p.width()) / f11 + (float)p.left;
        float f13 = (float)p.top - f3;
        float f14 = (f3 + f8) - (float)p.bottom;
        if (f13 <= f1)
        {
            f13 = f1;
        }
        float f15;
        if (f14 > f1)
        {
            f1 = f14;
        }
        f15 = f13 + f1;
        pointf.set(f12, (f13 * (float)p.height()) / f15 + (float)p.top);
    }

    static void a(b b1)
    {
        b1.b();
    }

    static boolean a(b b1, boolean flag)
    {
        b1.i = flag;
        return flag;
    }

    private void b()
    {
        if (h != null)
        {
            float f1 = p.width();
            float f2 = p.height();
            float af[] = new float[9];
            c.getValues(af);
            float f3 = af[2];
            float f4 = af[5];
            float f5 = af[0];
            Object obj;
            if (f5 > f)
            {
                o = f / f5;
                c.postScale(o, o, m.x, m.y);
                setImageMatrix(c);
                obj = new ScaleAnimation(1.0F / o, 1.0F, 1.0F / o, 1.0F, m.x, m.y);
            } else
            if (f5 < g)
            {
                o = g / f5;
                c.postScale(o, o, m.x, m.y);
                obj = new ScaleAnimation(1.0F, o, 1.0F, o, m.x, m.y);
            } else
            {
                float f6 = f5 * (float)h.getWidth();
                float f7 = f5 * (float)h.getHeight();
                float f8 = (float)p.left - f3;
                float f9 = (float)p.top - f4;
                int i1 = f8 != 0.0F;
                boolean flag = false;
                if (i1 < 0)
                {
                    f3 = p.left;
                    flag = true;
                }
                if (f9 < 0.0F)
                {
                    f4 = p.top;
                    flag = true;
                }
                float f10 = f6 - f8;
                float f11 = f7 - f9;
                if (f10 < f1)
                {
                    float f15 = f6 - f1;
                    f3 = (float)p.left - f15;
                    flag = true;
                }
                if (f11 < f2)
                {
                    float f14 = f7 - f2;
                    f4 = (float)p.top - f14;
                    flag = true;
                }
                if (flag)
                {
                    float f12 = af[2] - f3;
                    float f13 = af[5] - f4;
                    af[2] = f3;
                    af[5] = f4;
                    c.setValues(af);
                    setImageMatrix(c);
                    obj = new TranslateAnimation(f12, 0.0F, f13, 0.0F);
                } else
                {
                    setImageMatrix(c);
                    obj = null;
                }
            }
            if (obj != null)
            {
                i = true;
                ((Animation) (obj)).setDuration(300L);
                startAnimation(((Animation) (obj)));
                (new Thread(new j(this))).start();
                return;
            }
        }
    }

    private void c()
    {
        if (h == null)
        {
            return;
        }
        float af[] = new float[9];
        c.getValues(af);
        float f1 = Math.max((float)p.width() / (float)h.getWidth(), (float)p.height() / (float)h.getHeight());
        j = (float)p.left - (f1 * (float)h.getWidth() - (float)p.width()) / 2.0F;
        k = (float)p.top - (f1 * (float)h.getHeight() - (float)p.height()) / 2.0F;
        af[2] = j;
        af[5] = k;
        af[4] = f1;
        af[0] = f1;
        c.setValues(af);
        f = Math.min(2048F / (float)h.getWidth(), 2048F / (float)h.getHeight());
        g = f1;
        if (f < g)
        {
            f = g;
        }
        setImageMatrix(c);
    }

    public void a(Rect rect)
    {
        p = rect;
        if (h != null)
        {
            c();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (i)
        {
            return true;
        }
        0xff & motionevent.getAction();
        JVM INSTR tableswitch 0 6: default 60
    //                   0 67
    //                   1 158
    //                   2 170
    //                   3 60
    //                   4 60
    //                   5 112
    //                   6 158;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L3
_L1:
        b = true;
        return true;
_L2:
        c.set(getImageMatrix());
        d.set(c);
        l.set(motionevent.getX(), motionevent.getY());
        e = 1;
        continue; /* Loop/switch isn't completed */
_L5:
        n = a(motionevent);
        if (n > 10F)
        {
            d.set(c);
            a(m);
            e = 2;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        b();
        e = 0;
        continue; /* Loop/switch isn't completed */
_L4:
        if (e == 1)
        {
            c.set(d);
            float f3 = motionevent.getX() - l.x;
            float f4 = motionevent.getY() - l.y;
            c.postTranslate(f3, f4);
            setImageMatrix(c);
        } else
        if (e == 2)
        {
            c.set(c);
            float f1 = a(motionevent);
            if (f1 > 10F)
            {
                c.set(d);
                float f2 = f1 / n;
                c.postScale(f2, f2, m.x, m.y);
            }
            setImageMatrix(c);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        super.setImageBitmap(bitmap);
        h = bitmap;
        if (bitmap != null)
        {
            h = bitmap;
        }
    }
}
