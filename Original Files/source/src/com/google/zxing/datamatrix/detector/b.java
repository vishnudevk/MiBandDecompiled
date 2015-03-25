// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.datamatrix.detector;

import com.google.zxing.ResultPoint;

// Referenced classes of package com.google.zxing.datamatrix.detector:
//            a

class b
{

    private final ResultPoint a;
    private final ResultPoint b;
    private final int c;

    private b(ResultPoint resultpoint, ResultPoint resultpoint1, int i)
    {
        a = resultpoint;
        b = resultpoint1;
        c = i;
    }

    b(ResultPoint resultpoint, ResultPoint resultpoint1, int i, a a1)
    {
        this(resultpoint, resultpoint1, i);
    }

    ResultPoint a()
    {
        return a;
    }

    ResultPoint b()
    {
        return b;
    }

    public int c()
    {
        return c;
    }

    public String toString()
    {
        return (new StringBuilder()).append(a).append("/").append(b).append('/').append(c).toString();
    }
}
