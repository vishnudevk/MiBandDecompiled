// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANWriter, ITFReader

public final class ITFWriter extends UPCEANWriter
{

    public ITFWriter()
    {
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Map map)
    {
        if (barcodeformat != BarcodeFormat.ITF)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can only encode ITF, but got ").append(barcodeformat).toString());
        } else
        {
            return super.encode(s, barcodeformat, i, j, map);
        }
    }

    public byte[] encode(String s)
    {
        int i = s.length();
        if (i % 2 != 0)
        {
            throw new IllegalArgumentException("The lenght of the input should be even");
        }
        if (i > 80)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Requested contents should be less than 80 digits long, but got ").append(i).toString());
        }
        byte abyte0[] = new byte[9 + i * 9];
        int j = appendPattern(abyte0, 0, new int[] {
            1, 1, 1, 1
        }, 1);
        int k = 0;
        int l = j;
        for (; k < i; k += 2)
        {
            int i1 = Character.digit(s.charAt(k), 10);
            int j1 = Character.digit(s.charAt(k + 1), 10);
            int ai[] = new int[18];
            for (int k1 = 0; k1 < 5; k1++)
            {
                ai[k1 << 1] = ITFReader.a[i1][k1];
                ai[1 + (k1 << 1)] = ITFReader.a[j1][k1];
            }

            l += appendPattern(abyte0, l, ai, 1);
        }

        int _tmp = l + appendPattern(abyte0, l, new int[] {
            3, 1, 1
        }, 1);
        return abyte0;
    }
}
