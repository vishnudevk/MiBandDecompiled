// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import java.util.Map;

public final class ByQuadrantReader
    implements Reader
{

    private final Reader a;

    public ByQuadrantReader(Reader reader)
    {
        a = reader;
    }

    public Result decode(BinaryBitmap binarybitmap)
    {
        return decode(binarybitmap, null);
    }

    public Result decode(BinaryBitmap binarybitmap, Map map)
    {
        int i = binarybitmap.getWidth();
        int j = binarybitmap.getHeight();
        int k = i / 2;
        int l = j / 2;
        BinaryBitmap binarybitmap1 = binarybitmap.crop(0, 0, k, l);
        Result result3;
        try
        {
            result3 = a.decode(binarybitmap1, map);
        }
        catch (NotFoundException notfoundexception)
        {
            BinaryBitmap binarybitmap2 = binarybitmap.crop(k, 0, k, l);
            Result result2;
            try
            {
                result2 = a.decode(binarybitmap2, map);
            }
            catch (NotFoundException notfoundexception1)
            {
                BinaryBitmap binarybitmap3 = binarybitmap.crop(0, l, k, l);
                Result result1;
                try
                {
                    result1 = a.decode(binarybitmap3, map);
                }
                catch (NotFoundException notfoundexception2)
                {
                    BinaryBitmap binarybitmap4 = binarybitmap.crop(k, l, k, l);
                    Result result;
                    try
                    {
                        result = a.decode(binarybitmap4, map);
                    }
                    catch (NotFoundException notfoundexception3)
                    {
                        BinaryBitmap binarybitmap5 = binarybitmap.crop(k / 2, l / 2, k, l);
                        return a.decode(binarybitmap5, map);
                    }
                    return result;
                }
                return result1;
            }
            return result2;
        }
        return result3;
    }

    public void reset()
    {
        a.reset();
    }
}
