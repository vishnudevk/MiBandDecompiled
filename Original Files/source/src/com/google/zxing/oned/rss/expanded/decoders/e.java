// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

// Referenced classes of package com.google.zxing.oned.rss.expanded.decoders:
//            i, s

final class e extends i
{

    private static final int b = 8;
    private static final int c = 20;
    private static final int d = 16;
    private final String e;
    private final String f;

    e(BitArray bitarray, String s1, String s2)
    {
        super(bitarray);
        e = s2;
        f = s1;
    }

    private void c(StringBuilder stringbuilder, int j)
    {
        int k = getGeneralDecoder().a(j, 16);
        if (k == 38400)
        {
            return;
        }
        stringbuilder.append('(');
        stringbuilder.append(e);
        stringbuilder.append(')');
        int l = k % 32;
        int i1 = k / 32;
        int j1 = 1 + i1 % 12;
        int k1 = i1 / 12;
        if (k1 / 10 == 0)
        {
            stringbuilder.append('0');
        }
        stringbuilder.append(k1);
        if (j1 / 10 == 0)
        {
            stringbuilder.append('0');
        }
        stringbuilder.append(j1);
        if (l / 10 == 0)
        {
            stringbuilder.append('0');
        }
        stringbuilder.append(l);
    }

    protected int a(int j)
    {
        return j % 0x186a0;
    }

    protected void a(StringBuilder stringbuilder, int j)
    {
        int k = j / 0x186a0;
        stringbuilder.append('(');
        stringbuilder.append(f);
        stringbuilder.append(k);
        stringbuilder.append(')');
    }

    public String parseInformation()
    {
        if (getInformation().getSize() != 84)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            b(stringbuilder, 8);
            b(stringbuilder, 48, 20);
            c(stringbuilder, 68);
            return stringbuilder.toString();
        }
    }
}
