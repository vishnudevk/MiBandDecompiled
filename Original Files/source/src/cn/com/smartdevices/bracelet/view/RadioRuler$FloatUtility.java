// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import java.math.BigDecimal;

public class 
{

    public static float add(float f, float f1)
    {
        return (new BigDecimal(Float.toString(f))).add(new BigDecimal(Float.toString(f1))).floatValue();
    }

    public static float divide(float f, float f1)
    {
        return (new BigDecimal(Float.toString(f))).divide(new BigDecimal(Float.toString(f1))).floatValue();
    }

    public static float mulitiply(float f, float f1)
    {
        return (new BigDecimal(Float.toString(f))).multiply(new BigDecimal(Float.toString(f1))).floatValue();
    }

    public ()
    {
    }
}
