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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader, EAN13Reader, EAN8Reader, UPCEReader, 
//            UPCEANReader, UPCAReader

public final class MultiFormatUPCEANReader extends OneDReader
{

    private final UPCEANReader a[];

    public MultiFormatUPCEANReader(Map map)
    {
        Collection collection;
        ArrayList arraylist;
        if (map == null)
        {
            collection = null;
        } else
        {
            collection = (Collection)map.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        arraylist = new ArrayList();
        if (collection == null) goto _L2; else goto _L1
_L1:
        if (!collection.contains(BarcodeFormat.EAN_13)) goto _L4; else goto _L3
_L3:
        arraylist.add(new EAN13Reader());
_L6:
        if (collection.contains(BarcodeFormat.EAN_8))
        {
            arraylist.add(new EAN8Reader());
        }
        if (collection.contains(BarcodeFormat.UPC_E))
        {
            arraylist.add(new UPCEReader());
        }
_L2:
        if (arraylist.isEmpty())
        {
            arraylist.add(new EAN13Reader());
            arraylist.add(new EAN8Reader());
            arraylist.add(new UPCEReader());
        }
        a = (UPCEANReader[])arraylist.toArray(new UPCEANReader[arraylist.size()]);
        return;
_L4:
        if (collection.contains(BarcodeFormat.UPC_A))
        {
            arraylist.add(new UPCAReader());
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Result decodeRow(int i, BitArray bitarray, Map map)
    {
        int ai[];
        UPCEANReader aupceanreader[];
        int j;
        int k;
        ai = UPCEANReader.a(bitarray);
        aupceanreader = a;
        j = aupceanreader.length;
        k = 0;
_L2:
        UPCEANReader upceanreader;
        if (k >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        upceanreader = aupceanreader[k];
        Result result = upceanreader.decodeRow(i, bitarray, ai, map);
        boolean flag;
        Collection collection;
        boolean flag1;
        if (result.getBarcodeFormat() == BarcodeFormat.EAN_13 && result.getText().charAt(0) == '0')
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (map == null)
        {
            collection = null;
        } else
        {
            collection = (Collection)map.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        if (collection == null || collection.contains(BarcodeFormat.UPC_A))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag && flag1)
        {
            return new Result(result.getText().substring(1), null, result.getResultPoints(), BarcodeFormat.UPC_A);
        } else
        {
            return result;
        }
        ReaderException readerexception;
        readerexception;
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        throw NotFoundException.getNotFoundInstance();
    }

    public void reset()
    {
        UPCEANReader aupceanreader[] = a;
        int i = aupceanreader.length;
        for (int j = 0; j < i; j++)
        {
            aupceanreader[j].reset();
        }

    }
}
