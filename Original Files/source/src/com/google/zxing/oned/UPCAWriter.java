// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            EAN13Writer

public class UPCAWriter
    implements Writer
{

    private final EAN13Writer a = new EAN13Writer();

    public UPCAWriter()
    {
    }

    private static String a(String s)
    {
        int i = s.length();
        if (i == 11)
        {
            int j = 0;
            int k = 0;
            while (j < 11) 
            {
                int l = -48 + s.charAt(j);
                byte byte0;
                if (j % 2 == 0)
                {
                    byte0 = 3;
                } else
                {
                    byte0 = 1;
                }
                k += byte0 * l;
                j++;
            }
            s = (new StringBuilder()).append(s).append((1000 - k) % 10).toString();
        } else
        if (i != 12)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Requested contents should be 11 or 12 digits long, but got ").append(s.length()).toString());
        }
        return (new StringBuilder()).append('0').append(s).toString();
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j)
    {
        return encode(s, barcodeformat, i, j, null);
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Map map)
    {
        if (barcodeformat != BarcodeFormat.UPC_A)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can only encode UPC-A, but got ").append(barcodeformat).toString());
        } else
        {
            return a.encode(a(s), BarcodeFormat.EAN_13, i, j, map);
        }
    }
}
