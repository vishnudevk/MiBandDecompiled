// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitArray;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANReader

public final class EAN8Reader extends UPCEANReader
{

    private final int a[] = new int[4];

    public EAN8Reader()
    {
    }

    BarcodeFormat a()
    {
        return BarcodeFormat.EAN_8;
    }

    protected int decodeMiddle(BitArray bitarray, int ai[], StringBuilder stringbuilder)
    {
        int ai1[] = a;
        ai1[0] = 0;
        ai1[1] = 0;
        ai1[2] = 0;
        ai1[3] = 0;
        int i = bitarray.getSize();
        int j = ai[1];
        int j2;
        for (int k = 0; k < 4 && j < i; j = j2)
        {
            stringbuilder.append((char)(48 + a(bitarray, ai1, j, d)));
            int i2 = ai1.length;
            j2 = j;
            for (int k2 = 0; k2 < i2; k2++)
            {
                j2 += ai1[k2];
            }

            k++;
        }

        int l = a(bitarray, j, true, c)[1];
        int k1;
        for (int i1 = 0; i1 < 4 && l < i; l = k1)
        {
            stringbuilder.append((char)(48 + a(bitarray, ai1, l, d)));
            int j1 = ai1.length;
            k1 = l;
            for (int l1 = 0; l1 < j1; l1++)
            {
                k1 += ai1[l1];
            }

            i1++;
        }

        return l;
    }
}
