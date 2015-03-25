// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.detector.Detector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.zxing.multi.qrcode.detector:
//            a

public final class MultiDetector extends Detector
{

    private static final DetectorResult a[] = new DetectorResult[0];

    public MultiDetector(BitMatrix bitmatrix)
    {
        super(bitmatrix);
    }

    public DetectorResult[] detectMulti(Map map)
    {
        BitMatrix bitmatrix = getImage();
        ResultPointCallback resultpointcallback;
        com.google.zxing.qrcode.detector.FinderPatternInfo afinderpatterninfo[];
        if (map == null)
        {
            resultpointcallback = null;
        } else
        {
            resultpointcallback = (ResultPointCallback)map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        afinderpatterninfo = (new a(bitmatrix, resultpointcallback)).a(map);
        if (afinderpatterninfo.length == 0)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        ArrayList arraylist = new ArrayList();
        int i = afinderpatterninfo.length;
        int j = 0;
        while (j < i) 
        {
            com.google.zxing.qrcode.detector.FinderPatternInfo finderpatterninfo = afinderpatterninfo[j];
            try
            {
                arraylist.add(processFinderPatternInfo(finderpatterninfo));
            }
            catch (ReaderException readerexception) { }
            j++;
        }
        if (arraylist.isEmpty())
        {
            return a;
        } else
        {
            return (DetectorResult[])arraylist.toArray(new DetectorResult[arraylist.size()]);
        }
    }

}
