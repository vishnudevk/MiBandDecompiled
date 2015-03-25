// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

// Referenced classes of package com.google.zxing:
//            LuminanceSource

public abstract class Binarizer
{

    private final LuminanceSource a;

    protected Binarizer(LuminanceSource luminancesource)
    {
        a = luminancesource;
    }

    public abstract Binarizer createBinarizer(LuminanceSource luminancesource);

    public abstract BitMatrix getBlackMatrix();

    public abstract BitArray getBlackRow(int i, BitArray bitarray);

    public int getHeight()
    {
        return a.getHeight();
    }

    public LuminanceSource getLuminanceSource()
    {
        return a;
    }

    public int getWidth()
    {
        return a.getWidth();
    }
}
