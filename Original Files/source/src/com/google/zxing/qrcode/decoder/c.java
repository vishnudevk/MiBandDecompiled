// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

// Referenced classes of package com.google.zxing.qrcode.decoder:
//            e, f, g, h, 
//            i, j, k, l, 
//            d

abstract class c
{

    private static final c a[];

    private c()
    {
    }

    c(d d)
    {
        this();
    }

    static c a(int i1)
    {
        if (i1 < 0 || i1 > 7)
        {
            throw new IllegalArgumentException();
        } else
        {
            return a[i1];
        }
    }

    final void a(BitMatrix bitmatrix, int i1)
    {
        for (int j1 = 0; j1 < i1; j1++)
        {
            for (int k1 = 0; k1 < i1; k1++)
            {
                if (a(j1, k1))
                {
                    bitmatrix.flip(k1, j1);
                }
            }

        }

    }

    abstract boolean a(int i1, int j1);

    static 
    {
        c ac[] = new c[8];
        ac[0] = new e(null);
        ac[1] = new f(null);
        ac[2] = new g(null);
        ac[3] = new h(null);
        ac[4] = new i(null);
        ac[5] = new j(null);
        ac[6] = new k(null);
        ac[7] = new l(null);
        a = ac;
    }
}
