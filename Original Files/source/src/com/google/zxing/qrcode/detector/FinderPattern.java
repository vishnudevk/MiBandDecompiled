// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class FinderPattern extends ResultPoint
{

    private final float a;
    private int b;

    FinderPattern(float f, float f1, float f2)
    {
        this(f, f1, f2, 1);
    }

    FinderPattern(float f, float f1, float f2, int i)
    {
        super(f, f1);
        a = f2;
        b = i;
    }

    int a()
    {
        return b;
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

    FinderPattern b(float f, float f1, float f2)
    {
        int i = 1 + b;
        return new FinderPattern((f1 + (float)b * getX()) / (float)i, (f + (float)b * getY()) / (float)i, (f2 + (float)b * a) / (float)i, i);
    }

    void b()
    {
        b = 1 + b;
    }

    public float getEstimatedModuleSize()
    {
        return a;
    }
}
