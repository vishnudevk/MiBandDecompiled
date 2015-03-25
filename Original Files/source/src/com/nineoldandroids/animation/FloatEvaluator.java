// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;


// Referenced classes of package com.nineoldandroids.animation:
//            TypeEvaluator

public class FloatEvaluator
    implements TypeEvaluator
{

    public FloatEvaluator()
    {
    }

    public Float evaluate(float f, Number number, Number number1)
    {
        float f1 = number.floatValue();
        return Float.valueOf(f1 + f * (number1.floatValue() - f1));
    }

    public volatile Object evaluate(float f, Object obj, Object obj1)
    {
        return evaluate(f, (Number)obj, (Number)obj1);
    }
}
