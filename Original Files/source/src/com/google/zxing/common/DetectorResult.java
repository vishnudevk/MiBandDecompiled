// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common;

import com.google.zxing.ResultPoint;

// Referenced classes of package com.google.zxing.common:
//            BitMatrix

public class DetectorResult
{

    private final BitMatrix a;
    private final ResultPoint b[];

    public DetectorResult(BitMatrix bitmatrix, ResultPoint aresultpoint[])
    {
        a = bitmatrix;
        b = aresultpoint;
    }

    public BitMatrix getBits()
    {
        return a;
    }

    public ResultPoint[] getPoints()
    {
        return b;
    }
}
