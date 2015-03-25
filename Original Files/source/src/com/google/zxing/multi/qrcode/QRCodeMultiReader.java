// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.multi.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.multi.qrcode.detector.MultiDetector;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.Decoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class QRCodeMultiReader extends QRCodeReader
    implements MultipleBarcodeReader
{

    private static final Result a[] = new Result[0];

    public QRCodeMultiReader()
    {
    }

    public Result[] decodeMultiple(BinaryBitmap binarybitmap)
    {
        return decodeMultiple(binarybitmap, null);
    }

    public Result[] decodeMultiple(BinaryBitmap binarybitmap, Map map)
    {
        ArrayList arraylist;
        DetectorResult adetectorresult[];
        int i;
        int j;
        arraylist = new ArrayList();
        adetectorresult = (new MultiDetector(binarybitmap.getBlackMatrix())).detectMulti(map);
        i = adetectorresult.length;
        j = 0;
_L2:
        DetectorResult detectorresult;
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        detectorresult = adetectorresult[j];
        DecoderResult decoderresult;
        Result result;
        List list;
        decoderresult = getDecoder().decode(detectorresult.getBits());
        com.google.zxing.ResultPoint aresultpoint[] = detectorresult.getPoints();
        result = new Result(decoderresult.getText(), decoderresult.getRawBytes(), aresultpoint, BarcodeFormat.QR_CODE);
        list = decoderresult.getByteSegments();
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, list);
        String s = decoderresult.getECLevel();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, s);
        arraylist.add(result);
_L3:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        if (arraylist.isEmpty())
        {
            return a;
        } else
        {
            return (Result[])arraylist.toArray(new Result[arraylist.size()]);
        }
        ReaderException readerexception;
        readerexception;
          goto _L3
    }

}
