// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.maxicode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

// Referenced classes of package com.google.zxing.maxicode.decoder:
//            a, b

public final class Decoder
{

    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private final ReedSolomonDecoder d;

    public Decoder()
    {
        d = new ReedSolomonDecoder(GenericGF.MAXICODE_FIELD_64);
    }

    private void a(byte abyte0[], int i, int j, int k, int l)
    {
        int i1 = 0;
        int j1 = j + k;
        int k1;
        int ai[];
        if (l == 0)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        ai = new int[j1 / k1];
        for (int l1 = 0; l1 < j1; l1++)
        {
            if (l == 0 || l1 % 2 == l - 1)
            {
                ai[l1 / k1] = 0xff & abyte0[l1 + i];
            }
        }

        try
        {
            d.decode(ai, k / k1);
        }
        catch (ReedSolomonException reedsolomonexception)
        {
            throw ChecksumException.getChecksumInstance();
        }
        for (; i1 < j; i1++)
        {
            if (l == 0 || i1 % 2 == l - 1)
            {
                abyte0[i1 + i] = (byte)ai[i1 / k1];
            }
        }

    }

    public DecoderResult decode(BitMatrix bitmatrix)
    {
        return decode(bitmatrix, null);
    }

    public DecoderResult decode(BitMatrix bitmatrix, Map map)
    {
        byte abyte0[];
        int i;
        abyte0 = (new a(bitmatrix)).a();
        a(abyte0, 0, 10, 10, 0);
        i = 0xf & abyte0[0];
        i;
        JVM INSTR tableswitch 2 5: default 64
    //                   2 68
    //                   3 68
    //                   4 68
    //                   5 132;
           goto _L1 _L2 _L2 _L2 _L3
_L1:
        throw FormatException.getFormatInstance();
_L2:
        byte abyte1[];
        a(abyte0, 20, 84, 40, 1);
        a(abyte0, 20, 84, 40, 2);
        abyte1 = new byte[94];
_L5:
        System.arraycopy(abyte0, 0, abyte1, 0, 10);
        System.arraycopy(abyte0, 20, abyte1, 10, -10 + abyte1.length);
        return com.google.zxing.maxicode.decoder.b.a(abyte1, i);
_L3:
        a(abyte0, 20, 68, 56, 1);
        a(abyte0, 20, 68, 56, 2);
        abyte1 = new byte[78];
        if (true) goto _L5; else goto _L4
_L4:
    }
}
