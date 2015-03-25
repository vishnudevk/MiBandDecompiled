// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.aztec.detector;

import com.google.zxing.ResultPoint;

// Referenced classes of package com.google.zxing.aztec.detector:
//            a

class b
{

    public final int a;
    public final int b;

    private b(int i, int j)
    {
        a = i;
        b = j;
    }

    b(int i, int j, a a1)
    {
        this(i, j);
    }

    public ResultPoint a()
    {
        return new ResultPoint(a, b);
    }
}
