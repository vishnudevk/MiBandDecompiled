// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANWriter, UPCEANReader

public final class EAN8Writer extends UPCEANWriter
{

    private static final int a = 67;

    public EAN8Writer()
    {
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Map map)
    {
        if (barcodeformat != BarcodeFormat.EAN_8)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can only encode EAN_8, but got ").append(barcodeformat).toString());
        } else
        {
            return super.encode(s, barcodeformat, i, j, map);
        }
    }

    public byte[] encode(String s)
    {
        if (s.length() != 8)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Requested contents should be 8 digits long, but got ").append(s.length()).toString());
        }
        byte abyte0[] = new byte[67];
        int i = 0 + appendPattern(abyte0, 0, UPCEANReader.b, 1);
        for (int j = 0; j <= 3; j++)
        {
            int j1 = Integer.parseInt(s.substring(j, j + 1));
            i += appendPattern(abyte0, i, UPCEANReader.d[j1], 0);
        }

        int k = i + appendPattern(abyte0, i, UPCEANReader.c, 0);
        for (int l = 4; l <= 7; l++)
        {
            int i1 = Integer.parseInt(s.substring(l, l + 1));
            k += appendPattern(abyte0, k, UPCEANReader.d[i1], 1);
        }

        int _tmp = k + appendPattern(abyte0, k, UPCEANReader.b, 1);
        return abyte0;
    }
}
