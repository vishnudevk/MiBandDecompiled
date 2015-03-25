// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;

import com.google.zxing.aztec.AztecReader;
import com.google.zxing.datamatrix.DataMatrixReader;
import com.google.zxing.maxicode.MaxiCodeReader;
import com.google.zxing.oned.MultiFormatOneDReader;
import com.google.zxing.pdf417.PDF417Reader;
import com.google.zxing.qrcode.QRCodeReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

// Referenced classes of package com.google.zxing:
//            Reader, ReaderException, NotFoundException, DecodeHintType, 
//            BarcodeFormat, BinaryBitmap, Result

public final class MultiFormatReader
    implements Reader
{

    private Map a;
    private Reader b[];

    public MultiFormatReader()
    {
    }

    private Result a(BinaryBitmap binarybitmap)
    {
        if (b == null) goto _L2; else goto _L1
_L1:
        Reader areader[];
        int i;
        int j;
        areader = b;
        i = areader.length;
        j = 0;
_L3:
        Reader reader;
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        reader = areader[j];
        Result result = reader.decode(binarybitmap, a);
        return result;
        ReaderException readerexception;
        readerexception;
        j++;
        if (true) goto _L3; else goto _L2
_L2:
        throw NotFoundException.getNotFoundInstance();
    }

    public Result decode(BinaryBitmap binarybitmap)
    {
        setHints(null);
        return a(binarybitmap);
    }

    public Result decode(BinaryBitmap binarybitmap, Map map)
    {
        setHints(map);
        return a(binarybitmap);
    }

    public Result decodeWithState(BinaryBitmap binarybitmap)
    {
        if (b == null)
        {
            setHints(null);
        }
        return a(binarybitmap);
    }

    public void reset()
    {
        if (b != null)
        {
            Reader areader[] = b;
            int i = areader.length;
            for (int j = 0; j < i; j++)
            {
                areader[j].reset();
            }

        }
    }

    public void setHints(Map map)
    {
label0:
        {
label1:
            {
                a = map;
                boolean flag;
                Collection collection;
                ArrayList arraylist;
                boolean flag1;
                if (map != null && map.containsKey(DecodeHintType.TRY_HARDER))
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
                arraylist = new ArrayList();
                if (collection == null)
                {
                    break label0;
                }
                if (!collection.contains(BarcodeFormat.UPC_A) && !collection.contains(BarcodeFormat.UPC_E) && !collection.contains(BarcodeFormat.EAN_13) && !collection.contains(BarcodeFormat.EAN_8) && !collection.contains(BarcodeFormat.CODE_39) && !collection.contains(BarcodeFormat.CODE_93) && !collection.contains(BarcodeFormat.CODE_128) && !collection.contains(BarcodeFormat.ITF) && !collection.contains(BarcodeFormat.RSS_14))
                {
                    boolean flag2 = collection.contains(BarcodeFormat.RSS_EXPANDED);
                    flag1 = false;
                    if (!flag2)
                    {
                        break label1;
                    }
                }
                flag1 = true;
            }
            if (flag1 && !flag)
            {
                arraylist.add(new MultiFormatOneDReader(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE))
            {
                arraylist.add(new QRCodeReader());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX))
            {
                arraylist.add(new DataMatrixReader());
            }
            if (collection.contains(BarcodeFormat.AZTEC))
            {
                arraylist.add(new AztecReader());
            }
            if (collection.contains(BarcodeFormat.PDF_417))
            {
                arraylist.add(new PDF417Reader());
            }
            if (collection.contains(BarcodeFormat.MAXICODE))
            {
                arraylist.add(new MaxiCodeReader());
            }
            if (flag1 && flag)
            {
                arraylist.add(new MultiFormatOneDReader(map));
            }
        }
        if (arraylist.isEmpty())
        {
            if (!flag)
            {
                arraylist.add(new MultiFormatOneDReader(map));
            }
            arraylist.add(new QRCodeReader());
            arraylist.add(new DataMatrixReader());
            arraylist.add(new AztecReader());
            arraylist.add(new PDF417Reader());
            arraylist.add(new MaxiCodeReader());
            if (flag)
            {
                arraylist.add(new MultiFormatOneDReader(map));
            }
        }
        b = (Reader[])arraylist.toArray(new Reader[arraylist.size()]);
    }
}
