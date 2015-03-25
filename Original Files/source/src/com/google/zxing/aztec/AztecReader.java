// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.common.DecoderResult;
import java.util.Map;

// Referenced classes of package com.google.zxing.aztec:
//            AztecDetectorResult

public final class AztecReader
    implements Reader
{

    public AztecReader()
    {
    }

    public Result decode(BinaryBitmap binarybitmap)
    {
        return decode(binarybitmap, null);
    }

    public Result decode(BinaryBitmap binarybitmap, Map map)
    {
        AztecDetectorResult aztecdetectorresult = (new Detector(binarybitmap.getBlackMatrix())).detect();
        com.google.zxing.ResultPoint aresultpoint[] = aztecdetectorresult.getPoints();
        if (map != null)
        {
            ResultPointCallback resultpointcallback = (ResultPointCallback)map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultpointcallback != null)
            {
                int i = aresultpoint.length;
                for (int j = 0; j < i; j++)
                {
                    resultpointcallback.foundPossibleResultPoint(aresultpoint[j]);
                }

            }
        }
        DecoderResult decoderresult = (new Decoder()).decode(aztecdetectorresult);
        Result result = new Result(decoderresult.getText(), decoderresult.getRawBytes(), aresultpoint, BarcodeFormat.AZTEC);
        java.util.List list = decoderresult.getByteSegments();
        if (list != null)
        {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, list);
        }
        String s = decoderresult.getECLevel();
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
