// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

// Referenced classes of package com.nineoldandroids.animation:
//            k, h, Keyframe, TypeEvaluator

class f extends k
{

    private float g;
    private float h;
    private float i;
    private boolean j;

    public transient f(h ah[])
    {
        super(ah);
        j = true;
    }

    public f a()
    {
        ArrayList arraylist = e;
        int l = e.size();
        h ah[] = new h[l];
        int i1 = 0;
        do
        {
            if (i1 >= l)
            {
                return new f(ah);
            }
            ah[i1] = (h)((Keyframe)arraylist.get(i1)).clone();
            i1++;
        } while (true);
    }

    public Object a(float f1)
    {
        return Float.valueOf(b(f1));
    }

    public float b(float f1)
    {
        int l = 1;
        if (a == 2)
        {
            if (j)
            {
                j = false;
                g = ((h)e.get(0)).a();
                h = ((h)e.get(l)).a();
                i = h - g;
            }
            if (d != null)
            {
                f1 = d.getInterpolation(f1);
            }
            if (f == null)
            {
                return g + f1 * i;
            } else
            {
                return ((Number)f.evaluate(f1, Float.valueOf(g), Float.valueOf(h))).floatValue();
            }
        }
        if (f1 <= 0.0F)
        {
            h h5 = (h)e.get(0);
            h h6 = (h)e.get(l);
            float f10 = h5.a();
            float f11 = h6.a();
            float f12 = h5.getFraction();
            float f13 = h6.getFraction();
            Interpolator interpolator2 = h6.getInterpolator();
            if (interpolator2 != null)
            {
                f1 = interpolator2.getInterpolation(f1);
            }
            float f14 = (f1 - f12) / (f13 - f12);
            if (f == null)
            {
                return f10 + f14 * (f11 - f10);
            } else
            {
                return ((Number)f.evaluate(f14, Float.valueOf(f10), Float.valueOf(f11))).floatValue();
            }
        }
        if (f1 >= 1.0F)
        {
            h h3 = (h)e.get(-2 + a);
            h h4 = (h)e.get(-1 + a);
            float f5 = h3.a();
            float f6 = h4.a();
            float f7 = h3.getFraction();
            float f8 = h4.getFraction();
            Interpolator interpolator1 = h4.getInterpolator();
            if (interpolator1 != null)
            {
                f1 = interpolator1.getInterpolation(f1);
            }
            float f9 = (f1 - f7) / (f8 - f7);
            if (f == null)
            {
                return f5 + f9 * (f6 - f5);
            } else
            {
                return ((Number)f.evaluate(f9, Float.valueOf(f5), Float.valueOf(f6))).floatValue();
            }
        }
        h h1 = (h)e.get(0);
        do
        {
            if (l >= a)
            {
                return ((Number)((Keyframe)e.get(-1 + a)).getValue()).floatValue();
            }
            h h2 = (h)e.get(l);
            if (f1 < h2.getFraction())
            {
                Interpolator interpolator = h2.getInterpolator();
                if (interpolator != null)
                {
                    f1 = interpolator.getInterpolation(f1);
                }
                float f2 = (f1 - h1.getFraction()) / (h2.getFraction() - h1.getFraction());
                float f3 = h1.a();
                float f4 = h2.a();
                if (f == null)
                {
                    return f3 + f2 * (f4 - f3);
                } else
                {
                    return ((Number)f.evaluate(f2, Float.valueOf(f3), Float.valueOf(f4))).floatValue();
                }
            }
            l++;
            h1 = h2;
        } while (true);
    }

    public k b()
    {
        return a();
    }
}
