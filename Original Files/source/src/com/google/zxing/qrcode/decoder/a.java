// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

// Referenced classes of package com.google.zxing.qrcode.decoder:
//            n, Version, c

final class a
{

    private final BitMatrix a;
    private Version b;
    private n c;

    a(BitMatrix bitmatrix)
    {
        int i = bitmatrix.getHeight();
        if (i < 21 || (i & 3) != 1)
        {
            throw FormatException.getFormatInstance();
        } else
        {
            a = bitmatrix;
            return;
        }
    }

    private int a(int i, int j, int k)
    {
        if (a.get(i, j))
        {
            return 1 | k << 1;
        } else
        {
            return k << 1;
        }
    }

    n a()
    {
        int i = 0;
        if (c != null)
        {
            return c;
        }
        int j = 0;
        int k = 0;
        for (; j < 6; j++)
        {
            k = a(j, 8, k);
        }

        int l = a(8, 7, a(8, 8, a(7, 8, k)));
        for (int i1 = 5; i1 >= 0; i1--)
        {
            l = a(8, i1, l);
        }

        int j1 = a.getHeight();
        int k1 = j1 - 7;
        for (int l1 = j1 - 1; l1 >= k1; l1--)
        {
            i = a(8, l1, i);
        }

        for (int i2 = j1 - 8; i2 < j1; i2++)
        {
            i = a(i2, 8, i);
        }

        c = n.b(l, i);
        if (c != null)
        {
            return c;
        } else
        {
            throw FormatException.getFormatInstance();
        }
    }

    Version b()
    {
        if (b != null)
        {
            return b;
        }
        int i = a.getHeight();
        int j = i - 17 >> 2;
        if (j <= 6)
        {
            return Version.getVersionForNumber(j);
        }
        int k = i - 11;
        int l = 5;
        int i1 = 0;
        for (; l >= 0; l--)
        {
            for (int i2 = i - 9; i2 >= k; i2--)
            {
                i1 = a(i2, l, i1);
            }

        }

        Version version = Version.a(i1);
        if (version != null && version.getDimensionForVersion() == i)
        {
            b = version;
            return version;
        }
        int j1 = 0;
        for (int k1 = 5; k1 >= 0; k1--)
        {
            for (int l1 = i - 9; l1 >= k; l1--)
            {
                j1 = a(k1, l1, j1);
            }

        }

        Version version1 = Version.a(j1);
        if (version1 != null && version1.getDimensionForVersion() == i)
        {
            b = version1;
            return version1;
        } else
        {
            throw FormatException.getFormatInstance();
        }
    }

    byte[] c()
    {
        n n1 = a();
        Version version = b();
        c c1 = com.google.zxing.qrcode.decoder.c.a(n1.b());
        int i = a.getHeight();
        c1.a(a, i);
        BitMatrix bitmatrix = version.a();
        byte abyte0[] = new byte[version.getTotalCodewords()];
        int j = i - 1;
        int k = 0;
        int l = 0;
        int i1 = 0;
        boolean flag1;
        for (boolean flag = true; j > 0; flag = flag1)
        {
            if (j == 6)
            {
                j--;
            }
            int k1;
            for (int j1 = 0; j1 < i; j1++)
            {
                int l1;
                if (flag)
                {
                    k1 = i - 1 - j1;
                } else
                {
                    k1 = j1;
                }
                for (l1 = 0; l1 < 2; l1++)
                {
                    if (bitmatrix.get(j - l1, k1))
                    {
                        continue;
                    }
                    k++;
                    l <<= 1;
                    if (a.get(j - l1, k1))
                    {
                        l |= 1;
                    }
                    if (k == 8)
                    {
                        int i2 = i1 + 1;
                        abyte0[i1] = (byte)l;
                        l = 0;
                        i1 = i2;
                        k = 0;
                    }
                }

            }

            flag1 = flag ^ true;
            j -= 2;
        }

        if (i1 != version.getTotalCodewords())
        {
            throw FormatException.getFormatInstance();
        } else
        {
            return abyte0;
        }
    }
}
