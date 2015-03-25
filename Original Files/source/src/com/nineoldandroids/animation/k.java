// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.nineoldandroids.animation:
//            Keyframe, h, f, i, 
//            g, j, TypeEvaluator

class k
{

    int a;
    Keyframe b;
    Keyframe c;
    Interpolator d;
    ArrayList e;
    TypeEvaluator f;

    public transient k(Keyframe akeyframe[])
    {
        a = akeyframe.length;
        e = new ArrayList();
        e.addAll(Arrays.asList(akeyframe));
        b = (Keyframe)e.get(0);
        c = (Keyframe)e.get(-1 + a);
        d = c.getInterpolator();
    }

    public static transient k a(float af[])
    {
        int l = 1;
        int i1 = af.length;
        h ah[] = new h[Math.max(i1, 2)];
        if (i1 == l)
        {
            ah[0] = (h)Keyframe.ofFloat(0.0F);
            ah[l] = (h)Keyframe.ofFloat(1.0F, af[0]);
        } else
        {
            ah[0] = (h)Keyframe.ofFloat(0.0F, af[0]);
            while (l < i1) 
            {
                ah[l] = (h)Keyframe.ofFloat((float)l / (float)(i1 - 1), af[l]);
                l++;
            }
        }
        return new f(ah);
    }

    public static transient k a(int ai[])
    {
        int l = 1;
        int i1 = ai.length;
        i ai1[] = new i[Math.max(i1, 2)];
        if (i1 == l)
        {
            ai1[0] = (i)Keyframe.ofInt(0.0F);
            ai1[l] = (i)Keyframe.ofInt(1.0F, ai[0]);
        } else
        {
            ai1[0] = (i)Keyframe.ofInt(0.0F, ai[0]);
            while (l < i1) 
            {
                ai1[l] = (i)Keyframe.ofInt((float)l / (float)(i1 - 1), ai[l]);
                l++;
            }
        }
        return new g(ai1);
    }

    public static transient k a(Keyframe akeyframe[])
    {
        int l;
        int i1;
        int j1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        l = 0;
        i1 = akeyframe.length;
        j1 = 0;
        flag = false;
        flag1 = false;
        flag2 = false;
_L7:
        if (j1 < i1) goto _L2; else goto _L1
_L1:
        if (!flag2 || flag1 || flag) goto _L4; else goto _L3
_L3:
        h ah[] = new h[i1];
_L5:
        if (l >= i1)
        {
            return new f(ah);
        }
        ah[l] = (h)akeyframe[l];
        l++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (akeyframe[j1] instanceof h)
        {
            flag2 = true;
        } else
        if (akeyframe[j1] instanceof i)
        {
            flag1 = true;
        } else
        {
            flag = true;
        }
        j1++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L5; else goto _L4
_L4:
        if (flag1 && !flag2 && !flag)
        {
            i ai[] = new i[i1];
            int k1 = 0;
            do
            {
                if (k1 >= i1)
                {
                    return new g(ai);
                }
                ai[k1] = (i)akeyframe[k1];
                k1++;
            } while (true);
        }
        return new k(akeyframe);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static transient k a(Object aobj[])
    {
        int l = 1;
        int i1 = aobj.length;
        j aj[] = new j[Math.max(i1, 2)];
        if (i1 == l)
        {
            aj[0] = (j)Keyframe.ofObject(0.0F);
            aj[l] = (j)Keyframe.ofObject(1.0F, aobj[0]);
        } else
        {
            aj[0] = (j)Keyframe.ofObject(0.0F, aobj[0]);
            while (l < i1) 
            {
                aj[l] = (j)Keyframe.ofObject((float)l / (float)(i1 - 1), aobj[l]);
                l++;
            }
        }
        return new k(aj);
    }

    public Object a(float f1)
    {
        if (a == 2)
        {
            if (d != null)
            {
                f1 = d.getInterpolation(f1);
            }
            return f.evaluate(f1, b.getValue(), c.getValue());
        }
        if (f1 <= 0.0F)
        {
            Keyframe keyframe3 = (Keyframe)e.get(1);
            Interpolator interpolator2 = keyframe3.getInterpolator();
            if (interpolator2 != null)
            {
                f1 = interpolator2.getInterpolation(f1);
            }
            float f6 = b.getFraction();
            float f7 = (f1 - f6) / (keyframe3.getFraction() - f6);
            return f.evaluate(f7, b.getValue(), keyframe3.getValue());
        }
        if (f1 >= 1.0F)
        {
            Keyframe keyframe2 = (Keyframe)e.get(-2 + a);
            Interpolator interpolator1 = c.getInterpolator();
            if (interpolator1 != null)
            {
                f1 = interpolator1.getInterpolation(f1);
            }
            float f4 = keyframe2.getFraction();
            float f5 = (f1 - f4) / (c.getFraction() - f4);
            return f.evaluate(f5, keyframe2.getValue(), c.getValue());
        }
        Keyframe keyframe = b;
        int l = 1;
        do
        {
            if (l >= a)
            {
                return c.getValue();
            }
            Keyframe keyframe1 = (Keyframe)e.get(l);
            if (f1 < keyframe1.getFraction())
            {
                Interpolator interpolator = keyframe1.getInterpolator();
                if (interpolator != null)
                {
                    f1 = interpolator.getInterpolation(f1);
                }
                float f2 = keyframe.getFraction();
                float f3 = (f1 - f2) / (keyframe1.getFraction() - f2);
                return f.evaluate(f3, keyframe.getValue(), keyframe1.getValue());
            }
            l++;
            keyframe = keyframe1;
        } while (true);
    }

    public void a(TypeEvaluator typeevaluator)
    {
        f = typeevaluator;
    }

    public k b()
    {
        ArrayList arraylist = e;
        int l = e.size();
        Keyframe akeyframe[] = new Keyframe[l];
        int i1 = 0;
        do
        {
            if (i1 >= l)
            {
                return new k(akeyframe);
            }
            akeyframe[i1] = ((Keyframe)arraylist.get(i1)).clone();
            i1++;
        } while (true);
    }

    public Object clone()
    {
        return b();
    }

    public String toString()
    {
        String s = " ";
        int l = 0;
        do
        {
            if (l >= a)
            {
                return s;
            }
            String s1 = (new StringBuilder(String.valueOf(s))).append(((Keyframe)e.get(l)).getValue()).append("  ").toString();
            l++;
            s = s1;
        } while (true);
    }
}
