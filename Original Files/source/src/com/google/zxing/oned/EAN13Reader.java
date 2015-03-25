// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANReader

public final class EAN13Reader extends UPCEANReader
{

    static final int a[] = {
        0, 11, 13, 14, 19, 25, 28, 21, 22, 26
    };
    private final int f[] = new int[4];

    public EAN13Reader()
    {
    }

    private static void a(StringBuilder stringbuilder, int i)
    {
        for (int j = 0; j < 10; j++)
        {
            if (i == a[j])
            {
                stringbuilder.insert(0, (char)(j + 48));
                return;
            }
        }

        throw NotFoundException.getNotFoundInstance();
    }

    BarcodeFormat a()
    {
        return BarcodeFormat.EAN_13;
    }

    protected int decodeMiddle(BitArray bitarray, int ai[], StringBuilder stringbuilder)
    {
        int ai1[] = f;
        ai1[0] = 0;
        ai1[1] = 0;
        ai1[2] = 0;
        ai1[3] = 0;
        int i = bitarray.getSize();
        int j = ai[1];
        int k = 0;
        int l = 0;
        int l2;
        for (; k < 6 && j < i; j = l2)
        {
            int j2 = a(bitarray, ai1, j, e);
            stringbuilder.append((char)(48 + j2 % 10));
            int k2 = ai1.length;
            l2 = j;
            for (int i3 = 0; i3 < k2; i3++)
            {
                l2 += ai1[i3];
            }

            if (j2 >= 10)
            {
                l |= 1 << 5 - k;
            }
            k++;
        }

        a(stringbuilder, l);
        int i1 = a(bitarray, j, true, c)[1];
        int l1;
        for (int j1 = 0; j1 < 6 && i1 < i; i1 = l1)
        {
            stringbuilder.append((char)(48 + a(bitarray, ai1, i1, d)));
            int k1 = ai1.length;
            l1 = i1;
            for (int i2 = 0; i2 < k1; i2++)
            {
                l1 += ai1[i2];
            }

            j1++;
        }

        return i1;
    }

}
