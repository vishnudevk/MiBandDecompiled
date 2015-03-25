// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.zxing.common.reedsolomon:
//            GenericGF, a

public final class ReedSolomonEncoder
{

    private final GenericGF a;
    private final List b;

    public ReedSolomonEncoder(GenericGF genericgf)
    {
        if (!GenericGF.QR_CODE_FIELD_256.equals(genericgf))
        {
            throw new IllegalArgumentException("Only QR Code is supported at this time");
        } else
        {
            a = genericgf;
            b = new ArrayList();
            b.add(new a(genericgf, new int[] {
                1
            }));
            return;
        }
    }

    private a a(int i)
    {
        if (i >= b.size())
        {
            a a1 = (a)b.get(-1 + b.size());
            int j = b.size();
            a a2 = a1;
            for (int k = j; k <= i; k++)
            {
                GenericGF genericgf = a;
                int ai[] = new int[2];
                ai[0] = 1;
                ai[1] = a.a(k - 1);
                a2 = a2.b(new a(genericgf, ai));
                b.add(a2);
            }

        }
        return (a)b.get(i);
    }

    public void encode(int ai[], int i)
    {
        if (i == 0)
        {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int j = ai.length - i;
        if (j <= 0)
        {
            throw new IllegalArgumentException("No data bytes provided");
        }
        a a1 = a(i);
        int ai1[] = new int[j];
        System.arraycopy(ai, 0, ai1, 0, j);
        int ai2[] = (new a(a, ai1)).a(i, 1).c(a1)[1].a();
        int k = i - ai2.length;
        for (int l = 0; l < k; l++)
        {
            ai[j + l] = 0;
        }

        System.arraycopy(ai2, 0, ai, j + k, ai2.length);
    }
}
