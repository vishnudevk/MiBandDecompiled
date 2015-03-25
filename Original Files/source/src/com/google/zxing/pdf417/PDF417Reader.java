// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.pdf417.decoder.Decoder;
import com.google.zxing.pdf417.detector.Detector;
import java.util.Map;

public final class PDF417Reader
    implements Reader
{

    private static final ResultPoint a[] = new ResultPoint[0];
    private final Decoder b = new Decoder();

    public PDF417Reader()
    {
    }

    private static int a(int i, int j, BitMatrix bitmatrix)
    {
        int k = bitmatrix.getWidth();
        int l = 0;
        boolean flag1;
        for (boolean flag = true; i < k - 1 && l < 8; flag = flag1)
        {
            i++;
            flag1 = bitmatrix.get(i, j);
            if (flag != flag1)
            {
                l++;
            }
        }

        if (i == k - 1)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            return i;
        }
    }

    private static int a(int ai[], BitMatrix bitmatrix)
    {
        int i = ai[0];
        int j = ai[1];
        int k;
        for (k = bitmatrix.getWidth(); i < k && bitmatrix.get(i, j); i++) { }
        if (i == k)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        int l = i - ai[0] >>> 3;
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
        int l = a(ai[0], j, bitmatrix);
        int i1 = (1 + (b(ai[0], j, bitmatrix) - l)) / i;
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

    private static int b(int i, int j, BitMatrix bitmatrix)
    {
        int k;
        for (k = -1 + bitmatrix.getWidth(); k > i && !bitmatrix.get(k, j); k--) { }
        int l = 0;
        boolean flag = true;
        int i1;
        for (; k > i && l < 9; k = i1)
        {
            i1 = k - 1;
            boolean flag1 = bitmatrix.get(i1, j);
            if (flag != flag1)
            {
                l++;
            }
            flag = flag1;
        }

        if (k == i)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            return k;
        }
    }

    public Result decode(BinaryBitmap binarybitmap)
    {
        return decode(binarybitmap, null);
    }

    public Result decode(BinaryBitmap binarybitmap, Map map)
    {
        DecoderResult decoderresult;
        ResultPoint aresultpoint[];
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE))
        {
            BitMatrix bitmatrix = a(binarybitmap.getBlackMatrix());
            decoderresult = b.decode(bitmatrix);
            aresultpoint = a;
        } else
        {
            DetectorResult detectorresult = (new Detector(binarybitmap)).detect();
            decoderresult = b.decode(detectorresult.getBits());
            aresultpoint = detectorresult.getPoints();
        }
        return new Result(decoderresult.getText(), decoderresult.getRawBytes(), aresultpoint, BarcodeFormat.PDF_417);
    }

    public void reset()
    {
    }

}
