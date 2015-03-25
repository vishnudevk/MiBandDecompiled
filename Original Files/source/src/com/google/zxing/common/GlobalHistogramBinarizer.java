// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

// Referenced classes of package com.google.zxing.common:
//            BitMatrix, BitArray

public class GlobalHistogramBinarizer extends Binarizer
{

    private static final int a = 5;
    private static final int b = 3;
    private static final int c = 32;
    private byte d[];
    private final int e[] = new int[32];

    public GlobalHistogramBinarizer(LuminanceSource luminancesource)
    {
        super(luminancesource);
        d = new byte[0];
    }

    private static int a(int ai[])
    {
        int i = 0;
        int j = ai.length;
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        for (; k < j; k++)
        {
            if (ai[k] > l)
            {
                l = ai[k];
                i1 = k;
            }
            if (ai[k] > j1)
            {
                j1 = ai[k];
            }
        }

        int k1 = 0;
        int l1 = 0;
        while (i < j) 
        {
            int l3 = i - i1;
            int i4 = l3 * (l3 * ai[i]);
            int i2;
            int j2;
            int k2;
            int l2;
            int i3;
            int j3;
            int k3;
            int j4;
            if (i4 > k1)
            {
                j4 = i;
            } else
            {
                i4 = k1;
                j4 = l1;
            }
            i++;
            l1 = j4;
            k1 = i4;
        }
        if (i1 > l1)
        {
            i2 = l1;
            l1 = i1;
        } else
        {
            i2 = i1;
        }
        if (l1 - i2 <= j >> 4)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        j2 = l1 - 1;
        k2 = -1;
        l2 = l1 - 1;
        while (l2 > i2) 
        {
            i3 = l2 - i2;
            j3 = i3 * i3 * (l1 - l2) * (j1 - ai[l2]);
            if (j3 > k2)
            {
                k3 = l2;
            } else
            {
                j3 = k2;
                k3 = j2;
            }
            l2--;
            j2 = k3;
            k2 = j3;
        }
        return j2 << 3;
    }

    private void a(int i)
    {
        if (d.length < i)
        {
            d = new byte[i];
        }
        for (int j = 0; j < 32; j++)
        {
            e[j] = 0;
        }

    }

    public Binarizer createBinarizer(LuminanceSource luminancesource)
    {
        return new GlobalHistogramBinarizer(luminancesource);
    }

    public BitMatrix getBlackMatrix()
    {
        LuminanceSource luminancesource = getLuminanceSource();
        int i = luminancesource.getWidth();
        int j = luminancesource.getHeight();
        BitMatrix bitmatrix = new BitMatrix(i, j);
        a(i);
        int ai[] = e;
        for (int k = 1; k < 5; k++)
        {
            byte abyte1[] = luminancesource.getRow((j * k) / 5, d);
            int l1 = (i << 2) / 5;
            for (int i2 = i / 5; i2 < l1; i2++)
            {
                int j2 = (0xff & abyte1[i2]) >> 3;
                ai[j2] = 1 + ai[j2];
            }

        }

        int l = a(ai);
        byte abyte0[] = luminancesource.getMatrix();
        for (int i1 = 0; i1 < j; i1++)
        {
            int j1 = i1 * i;
            for (int k1 = 0; k1 < i; k1++)
            {
                if ((0xff & abyte0[j1 + k1]) < l)
                {
                    bitmatrix.set(k1, i1);
                }
            }

        }

        return bitmatrix;
    }

    public BitArray getBlackRow(int i, BitArray bitarray)
    {
        int j = 1;
        LuminanceSource luminancesource = getLuminanceSource();
        int k = luminancesource.getWidth();
        byte abyte0[];
        int ai[];
        if (bitarray == null || bitarray.getSize() < k)
        {
            bitarray = new BitArray(k);
        } else
        {
            bitarray.clear();
        }
        a(k);
        abyte0 = luminancesource.getRow(i, d);
        ai = e;
        for (int l = 0; l < k; l++)
        {
            int j2 = (0xff & abyte0[l]) >> 3;
            ai[j2] = 1 + ai[j2];
        }

        int i1 = a(ai);
        int j1 = 0xff & abyte0[0];
        int k1 = 0xff & abyte0[j];
        int l1 = j1;
        while (j < k - 1) 
        {
            int i2 = 0xff & abyte0[j + 1];
            if ((k1 << 2) - l1 - i2 >> 1 < i1)
            {
                bitarray.set(j);
            }
            j++;
            l1 = k1;
            k1 = i2;
        }
        return bitarray;
    }
}
