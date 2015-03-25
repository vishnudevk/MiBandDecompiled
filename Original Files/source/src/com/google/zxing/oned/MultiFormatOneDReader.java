// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.RSS14Reader;
import com.google.zxing.oned.rss.expanded.RSSExpandedReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader, MultiFormatUPCEANReader, Code39Reader, Code93Reader, 
//            Code128Reader, ITFReader, CodaBarReader

public final class MultiFormatOneDReader extends OneDReader
{

    private final OneDReader a[];

    public MultiFormatOneDReader(Map map)
    {
        Collection collection;
        boolean flag;
        ArrayList arraylist;
        if (map == null)
        {
            collection = null;
        } else
        {
            collection = (Collection)map.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        if (map != null && map.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        arraylist = new ArrayList();
        if (collection != null)
        {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E))
            {
                arraylist.add(new MultiFormatUPCEANReader(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39))
            {
                arraylist.add(new Code39Reader(flag));
            }
            if (collection.contains(BarcodeFormat.CODE_93))
            {
                arraylist.add(new Code93Reader());
            }
            if (collection.contains(BarcodeFormat.CODE_128))
            {
                arraylist.add(new Code128Reader());
            }
            if (collection.contains(BarcodeFormat.ITF))
            {
                arraylist.add(new ITFReader());
            }
            if (collection.contains(BarcodeFormat.CODABAR))
            {
                arraylist.add(new CodaBarReader());
            }
            if (collection.contains(BarcodeFormat.RSS_14))
            {
                arraylist.add(new RSS14Reader());
            }
            if (collection.contains(BarcodeFormat.RSS_EXPANDED))
            {
                arraylist.add(new RSSExpandedReader());
            }
        }
        if (arraylist.isEmpty())
        {
            arraylist.add(new MultiFormatUPCEANReader(map));
            arraylist.add(new Code39Reader());
            arraylist.add(new Code93Reader());
            arraylist.add(new Code128Reader());
            arraylist.add(new ITFReader());
            arraylist.add(new RSS14Reader());
            arraylist.add(new RSSExpandedReader());
        }
        a = (OneDReader[])arraylist.toArray(new OneDReader[arraylist.size()]);
    }

    public Result decodeRow(int i, BitArray bitarray, Map map)
    {
        OneDReader aonedreader[];
        int j;
        int k;
        aonedreader = a;
        j = aonedreader.length;
        k = 0;
_L2:
        OneDReader onedreader;
        if (k >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        onedreader = aonedreader[k];
        Result result = onedreader.decodeRow(i, bitarray, map);
        return result;
        ReaderException readerexception;
        readerexception;
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        throw NotFoundException.getNotFoundInstance();
    }

    public void reset()
    {
        OneDReader aonedreader[] = a;
        int i = aonedreader.length;
        for (int j = 0; j < i; j++)
        {
            aonedreader[j].reset();
        }

    }
}
