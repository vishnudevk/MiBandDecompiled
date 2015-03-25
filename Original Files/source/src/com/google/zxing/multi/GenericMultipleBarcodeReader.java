// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.zxing.multi:
//            MultipleBarcodeReader

public final class GenericMultipleBarcodeReader
    implements MultipleBarcodeReader
{

    private static final int a = 100;
    private final Reader b;

    public GenericMultipleBarcodeReader(Reader reader)
    {
        b = reader;
    }

    private static Result a(Result result, int i, int j)
    {
        ResultPoint aresultpoint[] = result.getResultPoints();
        if (aresultpoint == null)
        {
            return result;
        }
        ResultPoint aresultpoint1[] = new ResultPoint[aresultpoint.length];
        for (int k = 0; k < aresultpoint.length; k++)
        {
            ResultPoint resultpoint = aresultpoint[k];
            aresultpoint1[k] = new ResultPoint(resultpoint.getX() + (float)i, resultpoint.getY() + (float)j);
        }

        return new Result(result.getText(), result.getRawBytes(), aresultpoint1, result.getBarcodeFormat());
    }

    private void a(BinaryBitmap binarybitmap, Map map, List list, int i, int j)
    {
        boolean flag;
        Result result;
        Iterator iterator;
        ResultPoint aresultpoint[];
        int k;
        int l;
        int i1;
        int j1;
        ResultPoint resultpoint;
        try
        {
            result = b.decode(binarybitmap, map);
        }
        catch (ReaderException readerexception)
        {
            return;
        }
        iterator = list.iterator();
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (!((Result)iterator.next()).getText().equals(result.getText()))
        {
            break MISSING_BLOCK_LABEL_21;
        }
        flag = true;
_L8:
        if (!flag) goto _L4; else goto _L3
_L3:
        return;
_L4:
        list.add(a(result, i, j));
        aresultpoint = result.getResultPoints();
        if (aresultpoint == null || aresultpoint.length == 0) goto _L3; else goto _L5
_L5:
        k = binarybitmap.getWidth();
        l = binarybitmap.getHeight();
        float f = k;
        float f1 = l;
        float f2 = 0.0F;
        float f3 = 0.0F;
        i1 = aresultpoint.length;
        j1 = 0;
        while (j1 < i1) 
        {
            resultpoint = aresultpoint[j1];
            float f4 = resultpoint.getX();
            float f5 = resultpoint.getY();
            float f6;
            float f7;
            if (f4 < f)
            {
                f6 = f4;
            } else
            {
                f6 = f;
            }
            if (f5 < f1)
            {
                f7 = f5;
            } else
            {
                f7 = f1;
            }
            if (f4 <= f2)
            {
                f4 = f2;
            }
            if (f5 <= f3)
            {
                f5 = f3;
            }
            j1++;
            f3 = f5;
            f2 = f4;
            f1 = f7;
            f = f6;
        }
        if (f > 100F)
        {
            a(binarybitmap.crop(0, 0, (int)f, l), map, list, i, j);
        }
        if (f1 > 100F)
        {
            a(binarybitmap.crop(0, 0, k, (int)f1), map, list, i, j);
        }
        if (f2 < (float)(k - 100))
        {
            a(binarybitmap.crop((int)f2, 0, k - (int)f2, l), map, list, i + (int)f2, j);
        }
        if (f3 >= (float)(l - 100)) goto _L3; else goto _L6
_L6:
        a(binarybitmap.crop(0, (int)f3, k, l - (int)f3), map, list, i, j + (int)f3);
        return;
_L2:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public Result[] decodeMultiple(BinaryBitmap binarybitmap)
    {
        return decodeMultiple(binarybitmap, null);
    }

    public Result[] decodeMultiple(BinaryBitmap binarybitmap, Map map)
    {
        ArrayList arraylist = new ArrayList();
        a(binarybitmap, map, arraylist, 0, 0);
        if (arraylist.isEmpty())
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            return (Result[])arraylist.toArray(new Result[arraylist.size()]);
        }
    }
}
