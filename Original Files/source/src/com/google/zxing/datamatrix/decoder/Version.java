// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;

// Referenced classes of package com.google.zxing.datamatrix.decoder:
//            h, g

public final class Version
{

    private static final Version a[] = b();
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final h g;
    private final int h;

    private Version(int i, int j, int k, int l, int i1, h h1)
    {
        int j1 = 0;
        super();
        b = i;
        c = j;
        d = k;
        e = l;
        f = i1;
        g = h1;
        int k1 = h1.a();
        g ag[] = h1.b();
        int l1 = ag.length;
        int i2 = 0;
        for (; j1 < l1; j1++)
        {
            g g1 = ag[j1];
            i2 += g1.a() * (k1 + g1.b());
        }

        h = i2;
    }

    private static Version[] b()
    {
        Version aversion[] = new Version[30];
        aversion[0] = new Version(1, 10, 10, 8, 8, new h(5, new g(1, 3, null), null));
        aversion[1] = new Version(2, 12, 12, 10, 10, new h(7, new g(1, 5, null), null));
        aversion[2] = new Version(3, 14, 14, 12, 12, new h(10, new g(1, 8, null), null));
        aversion[3] = new Version(4, 16, 16, 14, 14, new h(12, new g(1, 12, null), null));
        aversion[4] = new Version(5, 18, 18, 16, 16, new h(14, new g(1, 18, null), null));
        aversion[5] = new Version(6, 20, 20, 18, 18, new h(18, new g(1, 22, null), null));
        aversion[6] = new Version(7, 22, 22, 20, 20, new h(20, new g(1, 30, null), null));
        aversion[7] = new Version(8, 24, 24, 22, 22, new h(24, new g(1, 36, null), null));
        aversion[8] = new Version(9, 26, 26, 24, 24, new h(28, new g(1, 44, null), null));
        aversion[9] = new Version(10, 32, 32, 14, 14, new h(36, new g(1, 62, null), null));
        aversion[10] = new Version(11, 36, 36, 16, 16, new h(42, new g(1, 86, null), null));
        aversion[11] = new Version(12, 40, 40, 18, 18, new h(48, new g(1, 114, null), null));
        aversion[12] = new Version(13, 44, 44, 20, 20, new h(56, new g(1, 144, null), null));
        aversion[13] = new Version(14, 48, 48, 22, 22, new h(68, new g(1, 174, null), null));
        aversion[14] = new Version(15, 52, 52, 24, 24, new h(42, new g(2, 102, null), null));
        aversion[15] = new Version(16, 64, 64, 14, 14, new h(56, new g(2, 140, null), null));
        aversion[16] = new Version(17, 72, 72, 16, 16, new h(36, new g(4, 92, null), null));
        aversion[17] = new Version(18, 80, 80, 18, 18, new h(48, new g(4, 114, null), null));
        aversion[18] = new Version(19, 88, 88, 20, 20, new h(56, new g(4, 144, null), null));
        aversion[19] = new Version(20, 96, 96, 22, 22, new h(68, new g(4, 174, null), null));
        aversion[20] = new Version(21, 104, 104, 24, 24, new h(56, new g(6, 136, null), null));
        aversion[21] = new Version(22, 120, 120, 18, 18, new h(68, new g(6, 175, null), null));
        aversion[22] = new Version(23, 132, 132, 20, 20, new h(62, new g(8, 163, null), null));
        aversion[23] = new Version(24, 144, 144, 22, 22, new h(62, new g(8, 156, null), new g(2, 155, null), null));
        aversion[24] = new Version(25, 8, 18, 6, 16, new h(7, new g(1, 5, null), null));
        aversion[25] = new Version(26, 8, 32, 6, 14, new h(11, new g(1, 10, null), null));
        aversion[26] = new Version(27, 12, 26, 10, 24, new h(14, new g(1, 16, null), null));
        aversion[27] = new Version(28, 12, 36, 10, 16, new h(18, new g(1, 22, null), null));
        aversion[28] = new Version(29, 16, 36, 14, 16, new h(24, new g(1, 32, null), null));
        aversion[29] = new Version(30, 16, 48, 14, 22, new h(28, new g(1, 49, null), null));
        return aversion;
    }

    public static Version getVersionForDimensions(int i, int j)
    {
        if ((i & 1) != 0 || (j & 1) != 0)
        {
            throw FormatException.getFormatInstance();
        }
        int k = a.length;
        for (int l = 0; l < k; l++)
        {
            Version version = a[l];
            if (version.c == i && version.d == j)
            {
                return version;
            }
        }

        throw FormatException.getFormatInstance();
    }

    h a()
    {
        return g;
    }

    public int getDataRegionSizeColumns()
    {
        return f;
    }

    public int getDataRegionSizeRows()
    {
        return e;
    }

    public int getSymbolSizeColumns()
    {
        return d;
    }

    public int getSymbolSizeRows()
    {
        return c;
    }

    public int getTotalCodewords()
    {
        return h;
    }

    public int getVersionNumber()
    {
        return b;
    }

    public String toString()
    {
        return String.valueOf(b);
    }

}
