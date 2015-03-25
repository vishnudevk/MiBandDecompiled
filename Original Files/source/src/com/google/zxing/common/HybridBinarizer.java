// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import java.lang.reflect.Array;

// Referenced classes of package com.google.zxing.common:
//            GlobalHistogramBinarizer, BitMatrix

public final class HybridBinarizer extends GlobalHistogramBinarizer
{

    private static final int a = 3;
    private static final int b = 8;
    private static final int c = 7;
    private static final int d = 40;
    private BitMatrix e;

    public HybridBinarizer(LuminanceSource luminancesource)
    {
        super(luminancesource);
    }

    private static void a(byte abyte0[], int i, int j, int k, int l, BitMatrix bitmatrix)
    {
        int i1 = i + j * l;
        for (int j1 = 0; j1 < 8;)
        {
            for (int k1 = 0; k1 < 8; k1++)
            {
                if ((0xff & abyte0[i1 + k1]) <= k)
                {
                    bitmatrix.set(i + k1, j + j1);
                }
            }

            j1++;
            i1 += l;
        }

    }

    private static void a(byte abyte0[], int i, int j, int k, int l, int ai[][], BitMatrix bitmatrix)
    {
        for (int i1 = 0; i1 < j; i1++)
        {
            int j1 = i1 << 3;
            if (j1 + 8 >= l)
            {
                j1 = l - 8;
            }
            for (int k1 = 0; k1 < i; k1++)
            {
                int l1 = k1 << 3;
                if (l1 + 8 >= k)
                {
                    l1 = k - 8;
                }
                int i2;
                int j2;
                int k2;
                int l2;
                if (k1 > 1)
                {
                    i2 = k1;
                } else
                {
                    i2 = 2;
                }
                if (i2 < i - 2)
                {
                    j2 = i2;
                } else
                {
                    j2 = i - 3;
                }
                if (i1 > 1)
                {
                    k2 = i1;
                } else
                {
                    k2 = 2;
                }
                if (k2 >= j - 2)
                {
                    k2 = j - 3;
                }
                l2 = 0;
                for (int i3 = -2; i3 <= 2; i3++)
                {
                    int ai1[] = ai[k2 + i3];
                    l2 += ai1[j2 - 2] + ai1[j2 - 1] + ai1[j2] + ai1[j2 + 1] + ai1[j2 + 2];
                }

                a(abyte0, l1, j1, l2 / 25, k, bitmatrix);
            }

        }

    }

    private static int[][] a(byte abyte0[], int i, int j, int k, int l)
    {
        int ai1[][];
        int i1;
        int ai[] = {
            j, i
        };
        ai1 = (int[][])Array.newInstance(Integer.TYPE, ai);
        i1 = 0;
_L5:
        if (i1 >= j) goto _L2; else goto _L1
_L1:
        int j1;
        int k1;
        j1 = i1 << 3;
        if (j1 + 8 >= l)
        {
            j1 = l - 8;
        }
        k1 = 0;
_L4:
        if (k1 >= i)
        {
            continue; /* Loop/switch isn't completed */
        }
        int l1 = k1 << 3;
        if (l1 + 8 >= k)
        {
            l1 = k - 8;
        }
        int i2 = l1 + j1 * k;
        int j2 = 0;
        int k2 = 0;
        int l2 = 255;
        int i3 = 0;
        while (j2 < 8) 
        {
            int l3 = i3;
            int i4 = 0;
            while (i4 < 8) 
            {
                int k4 = 0xff & abyte0[i2 + i4];
                l3 += k4;
                if (k4 < l2)
                {
                    l2 = k4;
                }
                int j3;
                int k3;
                int j4;
                if (k4 <= k2)
                {
                    k4 = k2;
                }
                i4++;
                k2 = k4;
            }
            j4 = j2 + 1;
            i2 += k;
            j2 = j4;
            i3 = l3;
        }
        j3 = i3 >> 6;
        if (k2 - l2 <= 24)
        {
            k3 = l2 >> 1;
            if (i1 <= 0 || k1 <= 0)
            {
                break MISSING_BLOCK_LABEL_308;
            }
            j3 = ai1[i1 - 1][k1] + 2 * ai1[i1][k1 - 1] + ai1[i1 - 1][k1 - 1] >> 2;
            if (l2 >= j3)
            {
                break MISSING_BLOCK_LABEL_308;
            }
        }
_L6:
        ai1[i1][k1] = j3;
        k1++;
        if (true) goto _L4; else goto _L3
_L3:
        i1++;
          goto _L5
_L2:
        return ai1;
        j3 = k3;
          goto _L6
    }

    public Binarizer createBinarizer(LuminanceSource luminancesource)
    {
        return new HybridBinarizer(luminancesource);
    }

    public BitMatrix getBlackMatrix()
    {
        if (e != null)
        {
            return e;
        }
        LuminanceSource luminancesource = getLuminanceSource();
        if (luminancesource.getWidth() >= 40 && luminancesource.getHeight() >= 40)
        {
            byte abyte0[] = luminancesource.getMatrix();
            int i = luminancesource.getWidth();
            int j = luminancesource.getHeight();
            int k = i >> 3;
            if ((i & 7) != 0)
            {
                k++;
            }
            int l = j >> 3;
            if ((j & 7) != 0)
            {
                l++;
            }
            int ai[][] = a(abyte0, k, l, i, j);
            BitMatrix bitmatrix = new BitMatrix(i, j);
            a(abyte0, k, l, i, j, ai, bitmatrix);
            e = bitmatrix;
        } else
        {
            e = super.getBlackMatrix();
        }
        return e;
    }
}
