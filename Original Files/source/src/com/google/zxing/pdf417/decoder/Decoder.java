// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;

// Referenced classes of package com.google.zxing.pdf417.decoder:
//            a, b

public final class Decoder
{

    private static final int a = 3;
    private static final int b = 512;

    public Decoder()
    {
    }

    private static int a(int ai[], int ai1[], int i)
    {
        if (ai1.length > 3 + i / 2 || i < 0 || i > 512)
        {
            throw FormatException.getFormatInstance();
        }
        if (ai1.length > 3)
        {
            throw FormatException.getFormatInstance();
        } else
        {
            return 0;
        }
    }

    private static void a(int ai[], int i)
    {
label0:
        {
            if (ai.length < 4)
            {
                throw FormatException.getFormatInstance();
            }
            int j = ai[0];
            if (j > ai.length)
            {
                throw FormatException.getFormatInstance();
            }
            if (j == 0)
            {
                if (i >= ai.length)
                {
                    break label0;
                }
                ai[0] = ai.length - i;
            }
            return;
        }
        throw FormatException.getFormatInstance();
    }

    public DecoderResult decode(BitMatrix bitmatrix)
    {
        a a1 = new a(bitmatrix);
        int ai[] = a1.a();
        if (ai.length == 0)
        {
            throw FormatException.getFormatInstance();
        } else
        {
            int i = 1 << 1 + a1.c();
            a(ai, a1.b(), i);
            a(ai, i);
            return com.google.zxing.pdf417.decoder.b.a(ai);
        }
    }

    public DecoderResult decode(boolean aflag[][])
    {
        int i = aflag.length;
        BitMatrix bitmatrix = new BitMatrix(i);
        for (int j = 0; j < i; j++)
        {
            for (int k = 0; k < i; k++)
            {
                if (aflag[k][j])
                {
                    bitmatrix.set(k, j);
                }
            }

        }

        return decode(bitmatrix);
    }
}
