// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

// Referenced classes of package com.google.zxing.qrcode.decoder:
//            a, n, b, m

public final class Decoder
{

    private final ReedSolomonDecoder a;

    public Decoder()
    {
        a = new ReedSolomonDecoder(GenericGF.QR_CODE_FIELD_256);
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
        return decode(bitmatrix, null);
    }

    public DecoderResult decode(BitMatrix bitmatrix, Map map)
    {
        a a1 = new a(bitmatrix);
        Version version = a1.b();
        ErrorCorrectionLevel errorcorrectionlevel = a1.a().a();
        b ab[] = b.a(a1.c(), version, errorcorrectionlevel);
        int i = ab.length;
        int j = 0;
        int k = 0;
        for (; j < i; j++)
        {
            k += ab[j].a();
        }

        byte abyte0[] = new byte[k];
        int l = ab.length;
        int i1 = 0;
        int l1;
        for (int j1 = 0; i1 < l; j1 = l1)
        {
            b b1 = ab[i1];
            byte abyte1[] = b1.b();
            int k1 = b1.a();
            a(abyte1, k1);
            l1 = j1;
            for (int i2 = 0; i2 < k1;)
            {
                int j2 = l1 + 1;
                abyte0[l1] = abyte1[i2];
                i2++;
                l1 = j2;
            }

            i1++;
        }

        return m.a(abyte0, version, errorcorrectionlevel, map);
    }

    public DecoderResult decode(boolean aflag[][])
    {
        return decode(aflag, null);
    }

    public DecoderResult decode(boolean aflag[][], Map map)
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

        return decode(bitmatrix, map);
    }
}
