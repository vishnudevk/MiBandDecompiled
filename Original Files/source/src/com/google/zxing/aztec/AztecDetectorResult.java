// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.aztec;

import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;

public final class AztecDetectorResult extends DetectorResult
{

    private final boolean a;
    private final int b;
    private final int c;

    public AztecDetectorResult(BitMatrix bitmatrix, ResultPoint aresultpoint[], boolean flag, int i, int j)
    {
        super(bitmatrix, aresultpoint);
        a = flag;
        b = i;
        c = j;
    }

    public int getNbDatablocks()
    {
        return b;
    }

    public int getNbLayers()
    {
        return c;
    }

    public boolean isCompact()
    {
        return a;
    }
}
