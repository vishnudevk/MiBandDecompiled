// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common;


public final class PerspectiveTransform
{

    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;

    private PerspectiveTransform(float f1, float f2, float f3, float f4, float f5, float f6, float f7, 
            float f8, float f9)
    {
        a = f1;
        b = f4;
        c = f7;
        d = f2;
        e = f5;
        f = f8;
        g = f3;
        h = f6;
        i = f9;
    }

    public static PerspectiveTransform quadrilateralToQuadrilateral(float f1, float f2, float f3, float f4, float f5, float f6, float f7, float f8, 
            float f9, float f10, float f11, float f12, float f13, float f14, float f15, 
            float f16)
    {
        PerspectiveTransform perspectivetransform = quadrilateralToSquare(f1, f2, f3, f4, f5, f6, f7, f8);
        return squareToQuadrilateral(f9, f10, f11, f12, f13, f14, f15, f16).a(perspectivetransform);
    }

    public static PerspectiveTransform quadrilateralToSquare(float f1, float f2, float f3, float f4, float f5, float f6, float f7, float f8)
    {
        return squareToQuadrilateral(f1, f2, f3, f4, f5, f6, f7, f8).a();
    }

    public static PerspectiveTransform squareToQuadrilateral(float f1, float f2, float f3, float f4, float f5, float f6, float f7, float f8)
    {
        float f9 = f8 - f6;
        float f10 = (f6 + (f2 - f4)) - f8;
        if (f9 == 0.0F && f10 == 0.0F)
        {
            return new PerspectiveTransform(f3 - f1, f5 - f3, f1, f4 - f2, f6 - f4, f2, 0.0F, 0.0F, 1.0F);
        } else
        {
            float f11 = f3 - f5;
            float f12 = f7 - f5;
            float f13 = (f5 + (f1 - f3)) - f7;
            float f14 = f4 - f6;
            float f15 = f11 * f9 - f12 * f14;
            float f16 = (f9 * f13 - f12 * f10) / f15;
            float f17 = (f11 * f10 - f13 * f14) / f15;
            return new PerspectiveTransform((f3 - f1) + f16 * f3, (f7 - f1) + f17 * f7, f1, (f4 - f2) + f16 * f4, (f8 - f2) + f17 * f8, f2, f16, f17, 1.0F);
        }
    }

    PerspectiveTransform a()
    {
        return new PerspectiveTransform(e * i - f * h, f * g - d * i, d * h - e * g, c * h - b * i, a * i - c * g, b * g - a * h, b * f - c * e, c * d - a * f, a * e - b * d);
    }

    PerspectiveTransform a(PerspectiveTransform perspectivetransform)
    {
        return new PerspectiveTransform(a * perspectivetransform.a + d * perspectivetransform.b + g * perspectivetransform.c, a * perspectivetransform.d + d * perspectivetransform.e + g * perspectivetransform.f, a * perspectivetransform.g + d * perspectivetransform.h + g * perspectivetransform.i, b * perspectivetransform.a + e * perspectivetransform.b + h * perspectivetransform.c, b * perspectivetransform.d + e * perspectivetransform.e + h * perspectivetransform.f, b * perspectivetransform.g + e * perspectivetransform.h + h * perspectivetransform.i, c * perspectivetransform.a + f * perspectivetransform.b + i * perspectivetransform.c, c * perspectivetransform.d + f * perspectivetransform.e + i * perspectivetransform.f, c * perspectivetransform.g + f * perspectivetransform.h + i * perspectivetransform.i);
    }

    public void transformPoints(float af[])
    {
        int j = af.length;
        float f1 = a;
        float f2 = b;
        float f3 = c;
        float f4 = d;
        float f5 = e;
        float f6 = f;
        float f7 = g;
        float f8 = h;
        float f9 = i;
        for (int k = 0; k < j; k += 2)
        {
            float f10 = af[k];
            float f11 = af[k + 1];
            float f12 = f9 + (f3 * f10 + f6 * f11);
            af[k] = (f7 + (f1 * f10 + f4 * f11)) / f12;
            af[k + 1] = (f8 + (f10 * f2 + f11 * f5)) / f12;
        }

    }

    public void transformPoints(float af[], float af1[])
    {
        int j = af.length;
        for (int k = 0; k < j; k++)
        {
            float f1 = af[k];
            float f2 = af1[k];
            float f3 = f1 * c + f2 * f + i;
            af[k] = (f1 * a + f2 * d + g) / f3;
            af1[k] = (f1 * b + f2 * e + h) / f3;
        }

    }
}
