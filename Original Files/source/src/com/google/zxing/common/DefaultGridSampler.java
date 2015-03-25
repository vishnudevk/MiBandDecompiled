// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common;

import com.google.zxing.NotFoundException;

// Referenced classes of package com.google.zxing.common:
//            GridSampler, PerspectiveTransform, BitMatrix

public final class DefaultGridSampler extends GridSampler
{

    public DefaultGridSampler()
    {
    }

    public BitMatrix sampleGrid(BitMatrix bitmatrix, int i, int j, float f, float f1, float f2, float f3, 
            float f4, float f5, float f6, float f7, float f8, float f9, float f10, 
            float f11, float f12, float f13, float f14, float f15)
    {
        return sampleGrid(bitmatrix, i, j, PerspectiveTransform.quadrilateralToQuadrilateral(f, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15));
    }

    public BitMatrix sampleGrid(BitMatrix bitmatrix, int i, int j, PerspectiveTransform perspectivetransform)
    {
        if (i <= 0 || j <= 0)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        BitMatrix bitmatrix1 = new BitMatrix(i, j);
        float af[] = new float[i << 1];
        for (int k = 0; k < j; k++)
        {
            int l = af.length;
            float f = 0.5F + (float)k;
            for (int i1 = 0; i1 < l; i1 += 2)
            {
                af[i1] = 0.5F + (float)(i1 >> 1);
                af[i1 + 1] = f;
            }

            perspectivetransform.transformPoints(af);
            checkAndNudgePoints(bitmatrix, af);
            int j1 = 0;
            while (j1 < l) 
            {
                try
                {
                    if (bitmatrix.get((int)af[j1], (int)af[j1 + 1]))
                    {
                        bitmatrix1.set(j1 >> 1, k);
                    }
                }
                catch (ArrayIndexOutOfBoundsException arrayindexoutofboundsexception)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                j1 += 2;
            }
        }

        return bitmatrix1;
    }
}
