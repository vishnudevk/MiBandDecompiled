// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.qrcode.detector.FinderPattern;
import java.io.Serializable;
import java.util.Comparator;

// Referenced classes of package com.google.zxing.multi.qrcode.detector:
//            b

class c
    implements Serializable, Comparator
{

    private c()
    {
    }

    c(b b)
    {
        this();
    }

    public int a(FinderPattern finderpattern, FinderPattern finderpattern1)
    {
        float f = finderpattern1.getEstimatedModuleSize() - finderpattern.getEstimatedModuleSize();
        if ((double)f < 0.0D)
        {
            return -1;
        }
        return (double)f <= 0.0D ? 0 : 1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((FinderPattern)obj, (FinderPattern)obj1);
    }
}
