// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.DataCharacter;
import java.util.List;

// Referenced classes of package com.google.zxing.oned.rss.expanded:
//            b

final class a
{

    private a()
    {
    }

    static BitArray a(List list)
    {
        int i = -1 + (list.size() << 1);
        int j;
        BitArray bitarray;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if (((b)list.get(-1 + list.size())).c() == null)
        {
            j = i - 1;
        } else
        {
            j = i;
        }
        bitarray = new BitArray(j * 12);
        k = ((b)list.get(0)).c().getValue();
        l = 11;
        int i3;
        for (i1 = 0; l >= 0; i1 = i3)
        {
            if ((k & 1 << l) != 0)
            {
                bitarray.set(i1);
            }
            i3 = i1 + 1;
            l--;
        }

        j1 = 1;
        k1 = i1;
label0:
        for (; j1 < list.size(); j1++)
        {
            b b1 = (b)list.get(j1);
            int l1 = b1.b().getValue();
            for (int i2 = 11; i2 >= 0;)
            {
                if ((l1 & 1 << i2) != 0)
                {
                    bitarray.set(k1);
                }
                int l2 = k1 + 1;
                i2--;
                k1 = l2;
            }

            if (b1.c() == null)
            {
                continue;
            }
            int j2 = b1.c().getValue();
            int k2 = 11;
            do
            {
                if (k2 < 0)
                {
                    continue label0;
                }
                if ((j2 & 1 << k2) != 0)
                {
                    bitarray.set(k1);
                }
                k1++;
                k2--;
            } while (true);
        }

        return bitarray;
    }
}
