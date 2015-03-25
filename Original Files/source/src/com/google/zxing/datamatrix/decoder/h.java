// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.datamatrix.decoder;


// Referenced classes of package com.google.zxing.datamatrix.decoder:
//            g, f

final class h
{

    private final int a;
    private final g b[];

    private h(int i, g g1)
    {
        a = i;
        b = (new g[] {
            g1
        });
    }

    h(int i, g g1, f f)
    {
        this(i, g1);
    }

    private h(int i, g g1, g g2)
    {
        a = i;
        b = (new g[] {
            g1, g2
        });
    }

    h(int i, g g1, g g2, f f)
    {
        this(i, g1, g2);
    }

    int a()
    {
        return a;
    }

    g[] b()
    {
        return b;
    }
}
