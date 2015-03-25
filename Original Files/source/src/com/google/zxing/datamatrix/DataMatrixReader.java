// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.datamatrix;

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
import com.google.zxing.common.DetectorResult;
import com.google.zxing.datamatrix.decoder.Decoder;
import com.google.zxing.datamatrix.detector.Detector;
import java.util.Map;

public final class DataMatrixReader
    implements Reader
{

    private static final ResultPoint a[] = new ResultPoint[0];
    private final Decoder b = new Decoder();

    public DataMatrixReader()
    {
    }

    private static int a(int ai[], BitMatrix bitmatrix)
    {
        int i = bitmatrix.getWidth();
        int j = ai[0];
        for (int k = ai[1]; j < i && bitmatrix.get(j, k); j++) { }
        if (j == i)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        int l = j - ai[0];
        if (l == 0)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            return l;
        }
    }

    private static BitMatrix a(BitMatrix bitmatrix)
    {
        int ai[] = bitmatrix.getTopLeftOnBit();
        int ai1[] = bitmatrix.getBottomRightOnBit();
        if (ai == null || ai1 == null)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        int i = a(ai, bitmatrix);
        int j = ai[1];
        int k = ai1[1];
        int l = ai[0];
        int i1 = (1 + (ai1[0] - l)) / i;
        int j1 = (1 + (k - j)) / i;
        if (i1 <= 0 || j1 <= 0)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        int k1 = i >> 1;
        int l1 = j + k1;
        int i2 = l + k1;
        BitMatrix bitmatrix1 = new BitMatrix(i1, j1);
        for (int j2 = 0; j2 < j1; j2++)
        {
            int k2 = l1 + j2 * i;
            for (int l2 = 0; l2 < i1; l2++)
            {
                if (bitmatrix.get(i2 + l2 * i, k2))
                {
                    bitmatrix1.set(l2, j2);
                }
            }

        }

        return bitmatrix1;
    }

    public Result decode(BinaryBitmap binarybitmap)
    {
        return decode(binarybitmap, null);
    }

    public Result decode(BinaryBitmap binarybitmap, Map map)
    {
        DecoderResult decoderresult;
        ResultPoint aresultpoint[];
        Result result;
        java.util.List list;
        String s;
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE))
        {
            BitMatrix bitmatrix = a(binarybitmap.getBlackMatrix());
            decoderresult = b.decode(bitmatrix);
            aresultpoint = a;
        } else
        {
            DetectorResult detectorresult = (new Detector(binarybitmap.getBlackMatrix())).detect();
            decoderresult = b.decode(detectorresult.getBits());
            aresultpoint = detectorresult.getPoints();
        }
        result = new Result(decoderresult.getText(), decoderresult.getRawBytes(), aresultpoint, BarcodeFormat.DATA_MATRIX);
        list = decoderresult.getByteSegments();
        if (list != null)
        {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, list);
        }
        s = decoderresult.getECLevel();
        if (s != null)
        {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, s);
        }
        return result;
    }

    public void reset()
    {
    }

}
