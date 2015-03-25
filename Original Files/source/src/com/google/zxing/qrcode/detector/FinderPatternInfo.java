// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.detector;


// Referenced classes of package com.google.zxing.qrcode.detector:
//            FinderPattern

public final class FinderPatternInfo
{

    private final FinderPattern a;
    private final FinderPattern b;
    private final FinderPattern c;

    public FinderPatternInfo(FinderPattern afinderpattern[])
    {
        a = afinderpattern[0];
        b = afinderpattern[1];
        c = afinderpattern[2];
    }

    public FinderPattern getBottomLeft()
    {
        return a;
    }

    public FinderPattern getTopLeft()
    {
        return b;
    }

    public FinderPattern getTopRight()
    {
        return c;
    }
}
