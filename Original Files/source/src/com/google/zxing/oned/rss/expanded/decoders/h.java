// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

// Referenced classes of package com.google.zxing.oned.rss.expanded.decoders:
//            AbstractExpandedDecoder, s

abstract class h extends AbstractExpandedDecoder
{

    protected static final int a = 40;

    h(BitArray bitarray)
    {
        super(bitarray);
    }

    private static void a(StringBuilder stringbuilder, int i)
    {
        int j = 0;
        int k = 0;
        for (; j < 13; j++)
        {
            int i1 = -48 + stringbuilder.charAt(j + i);
            if ((j & 1) == 0)
            {
                i1 *= 3;
            }
            k += i1;
        }

        int l = 10 - k % 10;
        if (l == 10)
        {
            l = 0;
        }
        stringbuilder.append(l);
    }

    protected void a(StringBuilder stringbuilder, int i, int j)
    {
        for (int k = 0; k < 4; k++)
        {
            int l = getGeneralDecoder().a(i + k * 10, 10);
            if (l / 100 == 0)
            {
                stringbuilder.append('0');
            }
            if (l / 10 == 0)
            {
                stringbuilder.append('0');
            }
            stringbuilder.append(l);
        }

        a(stringbuilder, j);
    }

    protected void b(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("(01)");
        int j = stringbuilder.length();
        stringbuilder.append('9');
        a(stringbuilder, i, j);
    }
}
