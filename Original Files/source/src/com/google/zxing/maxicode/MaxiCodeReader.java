// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.maxicode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.maxicode.decoder.Decoder;
import java.util.Map;

public final class MaxiCodeReader
    implements Reader
{

    private static final ResultPoint a[] = new ResultPoint[0];
    private static final int b = 30;
    private static final int c = 33;
    private final Decoder d = new Decoder();

    public MaxiCodeReader()
    {
    }

    private static BitMatrix a(BitMatrix bitmatrix)
    {
        int ai[] = bitmatrix.getEnclosingRectangle();
        if (ai == null)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        int i = ai[0];
        int j = ai[1];
        int k = ai[2];
        int l = ai[3];
        BitMatrix bitmatrix1 = new BitMatrix(30, 33);
        for (int i1 = 0; i1 < 33; i1++)
        {
            int j1 = j + (i1 * l + l / 2) / 33;
            for (int k1 = 0; k1 < 30; k1++)
            {
                if (bitmatrix.get(i + (k1 * k + k / 2 + (k * (i1 & 1)) / 2) / 30, j1))
                {
                    bitmatrix1.set(k1, i1);
                }
            }

        }

        return bitmatrix1;
    }

    Decoder a()
    {
        return d;
    }

    public Result decode(BinaryBitmap binarybitmap)
    {
        return decode(binarybitmap, null);
    }

    public Result decode(BinaryBitmap binarybitmap, Map map)
    {
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE))
        {
            BitMatrix bitmatrix = a(binarybitmap.getBlackMatrix());
            DecoderResult decoderresult = d.decode(bitmatrix, map);
            ResultPoint aresultpoint[] = a;
            Result result = new Result(decoderresult.getText(), decoderresult.getRawBytes(), aresultpoint, BarcodeFormat.MAXICODE);
            String s = decoderresult.getECLevel();
            if (s != null)
            {
                result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, s);
            }
            return result;
        } else
        {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public void reset()
    {
    }

}
