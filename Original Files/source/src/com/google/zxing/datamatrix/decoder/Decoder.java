// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.datamatrix.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

// Referenced classes of package com.google.zxing.datamatrix.decoder:
//            a, b, c

public final class Decoder
{

    private final ReedSolomonDecoder a;

    public Decoder()
    {
        a = new ReedSolomonDecoder(GenericGF.DATA_MATRIX_FIELD_256);
    }

    private void a(byte abyte0[], int i)
    {
        int j = 0;
        int k = abyte0.length;
        int ai[] = new int[k];
        for (int l = 0; l < k; l++)
        {
            ai[l] = 0xff & abyte0[l];
        }

        int i1 = abyte0.length - i;
        try
        {
            a.decode(ai, i1);
        }
        catch (ReedSolomonException reedsolomonexception)
        {
            throw ChecksumException.getChecksumInstance();
        }
        for (; j < i; j++)
        {
            abyte0[j] = (byte)ai[j];
        }

    }

    public DecoderResult decode(BitMatrix bitmatrix)
    {
        a a1 = new a(bitmatrix);
        Version version = a1.a();
        b ab[] = b.a(a1.b(), version);
        int i = ab.length;
        int j = 0;
        int k = 0;
        for (; j < i; j++)
        {
            k += ab[j].a();
        }

        byte abyte0[] = new byte[k];
        for (int l = 0; l < i; l++)
        {
            b b1 = ab[l];
            byte abyte1[] = b1.b();
            int i1 = b1.a();
            a(abyte1, i1);
            for (int j1 = 0; j1 < i1; j1++)
            {
                abyte0[l + j1 * i] = abyte1[j1];
            }

        }

        return c.a(abyte0);
    }

    public DecoderResult decode(boolean aflag[][])
    {
        int i = aflag.length;
        BitMatrix bitmatrix = new BitMatrix(i);
        for (int j = 0; j < i; j++)
        {
            for (int k = 0; k < i; k++)
            {
                if (aflag[j][k])
                {
                    bitmatrix.set(k, j);
                }
            }

        }

        return decode(bitmatrix);
    }
}
