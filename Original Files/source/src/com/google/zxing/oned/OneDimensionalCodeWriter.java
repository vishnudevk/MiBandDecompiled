// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public abstract class OneDimensionalCodeWriter
    implements Writer
{

    private final int a;

    protected OneDimensionalCodeWriter(int i)
    {
        a = i;
    }

    private BitMatrix a(byte abyte0[], int i, int j)
    {
        int k = abyte0.length;
        int l = k + a;
        int i1 = Math.max(i, l);
        int j1 = Math.max(1, j);
        int k1 = i1 / l;
        int l1 = (i1 - k * k1) / 2;
        BitMatrix bitmatrix = new BitMatrix(i1, j1);
        for (int i2 = 0; i2 < k;)
        {
            if (abyte0[i2] == 1)
            {
                bitmatrix.setRegion(l1, 0, k1, j1);
            }
            i2++;
            l1 += k1;
        }

        return bitmatrix;
    }

    protected static int appendPattern(byte abyte0[], int i, int ai[], int j)
    {
        if (j != 0 && j != 1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("startColor must be either 0 or 1, but got: ").append(j).toString());
        }
        byte byte0 = (byte)j;
        int k = ai.length;
        int l = 0;
        byte byte1 = byte0;
        int i1 = i;
        int j1 = 0;
        while (l < k) 
        {
            int k1 = ai[l];
            int l1 = i1;
            int i2 = j1;
            for (int j2 = 0; j2 < k1; j2++)
            {
                abyte0[l1] = byte1;
                l1++;
                i2++;
            }

            byte1 ^= 1;
            l++;
            j1 = i2;
            i1 = l1;
        }
        return j1;
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j)
    {
        return encode(s, barcodeformat, i, j, null);
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Map map)
    {
        if (s.length() == 0)
        {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i < 0 || j < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Negative size is not allowed. Input: ").append(i).append('x').append(j).toString());
        } else
        {
            return a(encode(s), i, j);
        }
    }

    public abstract byte[] encode(String s);
}
