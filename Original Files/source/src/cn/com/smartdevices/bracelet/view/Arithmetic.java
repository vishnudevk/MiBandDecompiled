// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import java.math.BigDecimal;

public class Arithmetic
{

    public Arithmetic()
    {
    }

    public static float add(float f, float f1)
    {
        return (new BigDecimal(Float.toString(f))).add(new BigDecimal(Float.toString(f1))).floatValue();
    }

    public static float div(float f, float f1, int i)
    {
        if (i < 0)
        {
            i = 0;
        }
        return (new BigDecimal(Float.toString(f))).divide(new BigDecimal(Float.toString(f1)), i, 4).floatValue();
    }

    public static float mul(float f, float f1)
    {
        return (new BigDecimal(Float.toString(f))).multiply(new BigDecimal(Float.toString(f1))).floatValue();
    }

    public static float round(float f, int i)
    {
        if (i < 0)
        {
            i = 0;
        }
        return (new BigDecimal(Float.toString(f))).divide(new BigDecimal("1"), i, 4).floatValue();
    }

    public static float sub(float f, float f1)
    {
        return (new BigDecimal(Float.toString(f))).subtract(new BigDecimal(Float.toString(f1))).floatValue();
    }
}
