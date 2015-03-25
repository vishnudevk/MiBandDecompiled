// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

// Referenced classes of package com.google.zxing.qrcode.detector:
//            FinderPattern, b

class d
    implements Serializable, Comparator
{

    private final float a;

    private d(float f)
    {
        a = f;
    }

    d(float f, b b)
    {
        this(f);
    }

    public int a(FinderPattern finderpattern, FinderPattern finderpattern1)
    {
        float f = Math.abs(finderpattern1.getEstimatedModuleSize() - a);
        float f1 = Math.abs(finderpattern.getEstimatedModuleSize() - a);
        if (f < f1)
        {
            return -1;
        }
        return f != f1 ? 1 : 0;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((FinderPattern)obj, (FinderPattern)obj1);
    }
}
