// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class AlignmentPattern extends ResultPoint
{

    private final float a;

    AlignmentPattern(float f, float f1, float f2)
    {
        super(f, f1);
        a = f2;
    }

    boolean a(float f, float f1, float f2)
    {
        boolean flag;
label0:
        {
            int i = Math.abs(f1 - getY()) != f;
            flag = false;
            if (i > 0)
            {
                break label0;
            }
            int j = Math.abs(f2 - getX()) != f;
            flag = false;
            if (j > 0)
            {
                break label0;
            }
            float f3 = Math.abs(f - a);
            if (f3 > 1.0F)
            {
                int k = f3 != a;
                flag = false;
                if (k > 0)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    AlignmentPattern b(float f, float f1, float f2)
    {
        return new AlignmentPattern((f1 + getX()) / 2.0F, (f + getY()) / 2.0F, (f2 + a) / 2.0F);
    }
}
