// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANReader

public final class UPCEReader extends UPCEANReader
{

    private static final int a[] = {
        1, 1, 1, 1, 1, 1
    };
    private static final int f[][] = {
        {
            56, 52, 50, 49, 44, 38, 35, 42, 41, 37
        }, {
            7, 11, 13, 14, 19, 25, 28, 21, 22, 26
        }
    };
    private final int g[] = new int[4];

    public UPCEReader()
    {
    }

    private static void a(StringBuilder stringbuilder, int i)
    {
        for (int j = 0; j <= 1; j++)
        {
            for (int k = 0; k < 10; k++)
            {
                if (i == f[j][k])
                {
                    stringbuilder.insert(0, (char)(j + 48));
                    stringbuilder.append((char)(k + 48));
                    return;
                }
            }

        }

        throw NotFoundException.getNotFoundInstance();
    }

    public static String convertUPCEtoUPCA(String s)
    {
        char ac[];
        StringBuilder stringbuilder;
        char c;
        ac = new char[6];
        s.getChars(1, 7, ac, 0);
        stringbuilder = new StringBuilder(12);
        stringbuilder.append(s.charAt(0));
        c = ac[5];
        c;
        JVM INSTR tableswitch 48 52: default 76
    //                   48 114
    //                   49 114
    //                   50 114
    //                   51 147
    //                   52 173;
           goto _L1 _L2 _L2 _L2 _L3 _L4
_L1:
        stringbuilder.append(ac, 0, 5);
        stringbuilder.append("0000");
        stringbuilder.append(c);
_L6:
        stringbuilder.append(s.charAt(7));
        return stringbuilder.toString();
_L2:
        stringbuilder.append(ac, 0, 2);
        stringbuilder.append(c);
        stringbuilder.append("0000");
        stringbuilder.append(ac, 2, 3);
        continue; /* Loop/switch isn't completed */
_L3:
        stringbuilder.append(ac, 0, 3);
        stringbuilder.append("00000");
        stringbuilder.append(ac, 3, 2);
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuilder.append(ac, 0, 4);
        stringbuilder.append("00000");
        stringbuilder.append(ac[4]);
        if (true) goto _L6; else goto _L5
_L5:
    }

    BarcodeFormat a()
    {
        return BarcodeFormat.UPC_E;
    }

    protected boolean checkChecksum(String s)
    {
        return super.checkChecksum(convertUPCEtoUPCA(s));
    }

    protected int[] decodeEnd(BitArray bitarray, int i)
    {
        return a(bitarray, i, true, a);
    }

    protected int decodeMiddle(BitArray bitarray, int ai[], StringBuilder stringbuilder)
    {
        int ai1[] = g;
        ai1[0] = 0;
        ai1[1] = 0;
        ai1[2] = 0;
        ai1[3] = 0;
        int i = bitarray.getSize();
        int j = ai[1];
        int k = 0;
        int l = 0;
        int k1;
        for (; k < 6 && j < i; j = k1)
        {
            int i1 = a(bitarray, ai1, j, e);
            stringbuilder.append((char)(48 + i1 % 10));
            int j1 = ai1.length;
            k1 = j;
            for (int l1 = 0; l1 < j1; l1++)
            {
                k1 += ai1[l1];
            }

            if (i1 >= 10)
            {
                l |= 1 << 5 - k;
            }
            k++;
        }

        a(stringbuilder, l);
        return j;
    }

}
