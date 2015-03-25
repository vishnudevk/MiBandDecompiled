// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

// Referenced classes of package com.google.zxing:
//            ResultPoint, ResultMetadataType, BarcodeFormat

public final class Result
{

    private final String a;
    private final byte b[];
    private ResultPoint c[];
    private final BarcodeFormat d;
    private Map e;
    private final long f;

    public Result(String s, byte abyte0[], ResultPoint aresultpoint[], BarcodeFormat barcodeformat)
    {
        this(s, abyte0, aresultpoint, barcodeformat, System.currentTimeMillis());
    }

    public Result(String s, byte abyte0[], ResultPoint aresultpoint[], BarcodeFormat barcodeformat, long l)
    {
        a = s;
        b = abyte0;
        c = aresultpoint;
        d = barcodeformat;
        e = null;
        f = l;
    }

    public void addResultPoints(ResultPoint aresultpoint[])
    {
        ResultPoint aresultpoint1[] = c;
        if (aresultpoint1 == null)
        {
            c = aresultpoint;
        } else
        if (aresultpoint != null && aresultpoint.length > 0)
        {
            ResultPoint aresultpoint2[] = new ResultPoint[aresultpoint1.length + aresultpoint.length];
            System.arraycopy(aresultpoint1, 0, aresultpoint2, 0, aresultpoint1.length);
            System.arraycopy(aresultpoint, 0, aresultpoint2, aresultpoint1.length, aresultpoint.length);
            c = aresultpoint2;
            return;
        }
    }

    public BarcodeFormat getBarcodeFormat()
    {
        return d;
    }

    public byte[] getRawBytes()
    {
        return b;
    }

    public Map getResultMetadata()
    {
        return e;
    }

    public ResultPoint[] getResultPoints()
    {
        return c;
    }

    public String getText()
    {
        return a;
    }

    public long getTimestamp()
    {
        return f;
    }

    public void putAllMetadata(Map map)
    {
label0:
        {
            if (map != null)
            {
                if (e != null)
                {
                    break label0;
                }
                e = map;
            }
            return;
        }
        e.putAll(map);
    }

    public void putMetadata(ResultMetadataType resultmetadatatype, Object obj)
    {
        if (e == null)
        {
            e = new EnumMap(com/google/zxing/ResultMetadataType);
        }
        e.put(resultmetadatatype, obj);
    }

    public String toString()
    {
        return a;
    }
}
