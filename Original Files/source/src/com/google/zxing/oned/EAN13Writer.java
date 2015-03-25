// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANWriter, EAN13Reader, UPCEANReader

public final class EAN13Writer extends UPCEANWriter
{

    private static final int a = 95;

    public EAN13Writer()
    {
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Map map)
    {
        if (barcodeformat != BarcodeFormat.EAN_13)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can only encode EAN_13, but got ").append(barcodeformat).toString());
        } else
        {
            return super.encode(s, barcodeformat, i, j, map);
        }
    }

    public byte[] encode(String s)
    {
        if (s.length() != 13)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Requested contents should be 13 digits long, but got ").append(s.length()).toString());
        }
        int i = Integer.parseInt(s.substring(0, 1));
        int j = EAN13Reader.a[i];
        byte abyte0[] = new byte[95];
        int k = 0 + appendPattern(abyte0, 0, UPCEANReader.b, 1);
        int l = 1;
        int i1 = k;
        for (; l <= 6; l++)
        {
            int i2 = Integer.parseInt(s.substring(l, l + 1));
            if ((1 & j >> 6 - l) == 1)
            {
                i2 += 10;
            }
            i1 += appendPattern(abyte0, i1, UPCEANReader.e[i2], 0);
        }

        int j1 = i1 + appendPattern(abyte0, i1, UPCEANReader.c, 0);
        for (int k1 = 7; k1 <= 12; k1++)
        {
            int l1 = Integer.parseInt(s.substring(k1, k1 + 1));
            j1 += appendPattern(abyte0, j1, UPCEANReader.d[l1], 1);
        }

        int _tmp = j1 + appendPattern(abyte0, j1, UPCEANReader.b, 1);
        return abyte0;
    }
}
