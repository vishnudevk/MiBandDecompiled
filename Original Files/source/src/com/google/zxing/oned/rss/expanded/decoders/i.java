// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

// Referenced classes of package com.google.zxing.oned.rss.expanded.decoders:
//            h, s

abstract class i extends h
{

    i(BitArray bitarray)
    {
        super(bitarray);
    }

    protected abstract int a(int j);

    protected abstract void a(StringBuilder stringbuilder, int j);

    protected void b(StringBuilder stringbuilder, int j, int k)
    {
        int l = getGeneralDecoder().a(j, k);
        a(stringbuilder, l);
        int i1 = a(l);
        int j1 = 0x186a0;
        for (int k1 = 0; k1 < 5; k1++)
        {
            if (i1 / j1 == 0)
            {
                stringbuilder.append('0');
            }
            j1 /= 10;
        }

        stringbuilder.append(i1);
    }
}
