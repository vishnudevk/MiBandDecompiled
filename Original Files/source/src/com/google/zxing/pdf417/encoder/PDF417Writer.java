// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.pdf417.encoder;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.lang.reflect.Array;
import java.util.Map;

// Referenced classes of package com.google.zxing.pdf417.encoder:
//            c, a, Compaction

public final class PDF417Writer
    implements Writer
{

    public PDF417Writer()
    {
    }

    private static BitMatrix a(c c1, String s, int i, int j)
    {
        c1.a(s, 2);
        byte abyte0[][] = c1.a().a(2, 8);
        boolean flag;
        boolean flag1;
        boolean flag2;
        int k;
        int l;
        if (j > i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (abyte0[0].length < abyte0.length)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag ^ flag1)
        {
            abyte0 = b(abyte0);
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        k = i / abyte0[0].length;
        l = j / abyte0.length;
        if (k >= l)
        {
            k = l;
        }
        if (k > 1)
        {
            byte abyte1[][] = c1.a().a(k * 2, 2 * (k * 4));
            byte abyte2[][];
            if (flag2)
            {
                abyte2 = b(abyte1);
            } else
            {
                abyte2 = abyte1;
            }
            return a(abyte2);
        } else
        {
            return a(abyte0);
        }
    }

    private static BitMatrix a(byte abyte0[][])
    {
        BitMatrix bitmatrix = new BitMatrix(60 + abyte0.length, 60 + abyte0[0].length);
        bitmatrix.clear();
        for (int i = 0; i < abyte0.length; i++)
        {
            for (int j = 0; j < abyte0[0].length; j++)
            {
                if (abyte0[i][j] == 1)
                {
                    bitmatrix.set(i + 30, j + 30);
                }
            }

        }

        return bitmatrix;
    }

    private static c a(BarcodeFormat barcodeformat, boolean flag)
    {
        if (barcodeformat != BarcodeFormat.PDF_417)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can only encode PDF_417, but got ").append(barcodeformat).toString());
        } else
        {
            c c1 = new c();
            c1.a(flag);
            return c1;
        }
    }

    private static byte[][] b(byte abyte0[][])
    {
        int ai[] = {
            abyte0[0].length, abyte0.length
        };
        byte abyte1[][] = (byte[][])Array.newInstance(Byte.TYPE, ai);
        for (int i = 0; i < abyte0.length; i++)
        {
            int j = -1 + (abyte0.length - i);
            for (int k = 0; k < abyte0[0].length; k++)
            {
                abyte1[k][j] = abyte0[i][k];
            }

        }

        return abyte1;
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j)
    {
        return a(a(barcodeformat, false), s, i, j);
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Map map)
    {
        return encode(s, barcodeformat, i, j);
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, boolean flag, int i, int j, int k, int l, 
            int i1, int j1, Compaction compaction)
    {
        c c1 = a(barcodeformat, flag);
        c1.a(l, k, j1, i1);
        c1.a(compaction);
        return a(c1, s, i, j);
    }
}
