// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode;

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
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.detector.Detector;
import java.util.Map;

public class QRCodeReader
    implements Reader
{

    private static final ResultPoint a[] = new ResultPoint[0];
    private final Decoder b = new Decoder();

    public QRCodeReader()
    {
    }

    private static float a(int ai[], BitMatrix bitmatrix)
    {
        int i;
        int j;
        boolean flag;
        int i1;
        int j1;
        int k1;
        i = bitmatrix.getHeight();
        j = bitmatrix.getWidth();
        int k = ai[0];
        int l = ai[1];
        flag = true;
        i1 = l;
        j1 = k;
        k1 = 0;
_L2:
        boolean flag1;
label0:
        {
            int l1;
            if (j1 < j && i1 < i)
            {
                if (flag == bitmatrix.get(j1, i1))
                {
                    break; /* Loop/switch isn't completed */
                }
                l1 = k1 + 1;
                if (l1 != 5)
                {
                    break label0;
                }
            }
            boolean flag2;
            if (j1 == j || i1 == i)
            {
                throw NotFoundException.getNotFoundInstance();
            } else
            {
                return (float)(j1 - ai[0]) / 7F;
            }
        }
        if (!flag)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        flag1 = flag2;
        k1 = l1;
_L3:
        j1++;
        i1++;
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
        flag1 = flag;
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    private static BitMatrix a(BitMatrix bitmatrix)
    {
        int ai[] = bitmatrix.getTopLeftOnBit();
        int ai1[] = bitmatrix.getBottomRightOnBit();
        if (ai == null || ai1 == null)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        float f = a(ai, bitmatrix);
        int i = ai[1];
        int j = ai1[1];
        int k = ai[0];
        int l = ai1[0];
        if (j - i != l - k)
        {
            l = k + (j - i);
        }
        int i1 = Math.round((float)(1 + (l - k)) / f);
        int j1 = Math.round((float)(1 + (j - i)) / f);
        if (i1 <= 0 || j1 <= 0)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        if (j1 != i1)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        int k1 = Math.round(f / 2.0F);
        int l1 = i + k1;
        int i2 = k + k1;
        BitMatrix bitmatrix1 = new BitMatrix(i1, j1);
        for (int j2 = 0; j2 < j1; j2++)
        {
            int k2 = l1 + (int)(f * (float)j2);
            for (int l2 = 0; l2 < i1; l2++)
            {
                if (bitmatrix.get(i2 + (int)(f * (float)l2), k2))
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
            decoderresult = b.decode(bitmatrix, map);
            aresultpoint = a;
        } else
        {
            DetectorResult detectorresult = (new Detector(binarybitmap.getBlackMatrix())).detect(map);
            decoderresult = b.decode(detectorresult.getBits(), map);
            aresultpoint = detectorresult.getPoints();
        }
        result = new Result(decoderresult.getText(), decoderresult.getRawBytes(), aresultpoint, BarcodeFormat.QR_CODE);
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

    protected Decoder getDecoder()
    {
        return b;
    }

    public void reset()
    {
    }

}
