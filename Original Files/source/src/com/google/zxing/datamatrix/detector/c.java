// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.datamatrix.detector;

import java.io.Serializable;
import java.util.Comparator;

// Referenced classes of package com.google.zxing.datamatrix.detector:
//            b, a

class c
    implements Serializable, Comparator
{

    private c()
    {
    }

    c(a a1)
    {
        this();
    }

    public int a(b b1, b b2)
    {
        return b1.c() - b2.c();
    }

    public int compare(Object obj, Object obj1)
    {
        return a((b)obj, (b)obj1);
    }
}
