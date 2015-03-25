// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;


// Referenced classes of package com.nineoldandroids.animation:
//            TypeEvaluator

public class ArgbEvaluator
    implements TypeEvaluator
{

    public ArgbEvaluator()
    {
    }

    public Object evaluate(float f, Object obj, Object obj1)
    {
        int i = ((Integer)obj).intValue();
        int j = i >> 24;
        int k = 0xff & i >> 16;
        int l = 0xff & i >> 8;
        int i1 = i & 0xff;
        int j1 = ((Integer)obj1).intValue();
        int k1 = j1 >> 24;
        int l1 = 0xff & j1 >> 16;
        int i2 = 0xff & j1 >> 8;
        int j2 = j1 & 0xff;
        return Integer.valueOf(j + (int)(f * (float)(k1 - j)) << 24 | k + (int)(f * (float)(l1 - k)) << 16 | l + (int)(f * (float)(i2 - l)) << 8 | i1 + (int)(f * (float)(j2 - i1)));
    }
}
