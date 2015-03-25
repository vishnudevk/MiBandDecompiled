// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

public final class FinderPattern
{

    private final int a;
    private final int b[];
    private final ResultPoint c[];

    public FinderPattern(int i, int ai[], int j, int k, int l)
    {
        a = i;
        b = ai;
        ResultPoint aresultpoint[] = new ResultPoint[2];
        aresultpoint[0] = new ResultPoint(j, l);
        aresultpoint[1] = new ResultPoint(k, l);
        c = aresultpoint;
    }

    public ResultPoint[] getResultPoints()
    {
        return c;
    }

    public int[] getStartEnd()
    {
        return b;
    }

    public int getValue()
    {
        return a;
    }
}
