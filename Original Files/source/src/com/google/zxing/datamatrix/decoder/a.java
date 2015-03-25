// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

// Referenced classes of package com.google.zxing.datamatrix.decoder:
//            Version

final class a
{

    private final BitMatrix a;
    private final BitMatrix b;
    private final Version c;

    a(BitMatrix bitmatrix)
    {
        int i = bitmatrix.getHeight();
        if (i < 8 || i > 144 || (i & 1) != 0)
        {
            throw FormatException.getFormatInstance();
        } else
        {
            c = b(bitmatrix);
            a = a(bitmatrix);
            b = new BitMatrix(a.getWidth(), a.getHeight());
            return;
        }
    }

    private static Version b(BitMatrix bitmatrix)
    {
        return Version.getVersionForDimensions(bitmatrix.getHeight(), bitmatrix.getWidth());
    }

    int a(int i, int j)
    {
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        if (a(i - 1, 0, i, j))
        {
            k = 1;
        } else
        {
            k = 0;
        }
        l = k << 1;
        if (a(i - 1, 1, i, j))
        {
            l |= 1;
        }
        i1 = l << 1;
        if (a(i - 1, 2, i, j))
        {
            i1 |= 1;
        }
        j1 = i1 << 1;
        if (a(0, j - 2, i, j))
        {
            j1 |= 1;
        }
        k1 = j1 << 1;
        if (a(0, j - 1, i, j))
        {
            k1 |= 1;
        }
        l1 = k1 << 1;
        if (a(1, j - 1, i, j))
        {
            l1 |= 1;
        }
        i2 = l1 << 1;
        if (a(2, j - 1, i, j))
        {
            i2 |= 1;
        }
        j2 = i2 << 1;
        if (a(3, j - 1, i, j))
        {
            j2 |= 1;
        }
        return j2;
    }

    BitMatrix a(BitMatrix bitmatrix)
    {
        int i = c.getSymbolSizeRows();
        int j = c.getSymbolSizeColumns();
        if (bitmatrix.getHeight() != i)
        {
            throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
        }
        int k = c.getDataRegionSizeRows();
        int l = c.getDataRegionSizeColumns();
        int i1 = i / k;
        int j1 = j / l;
        int k1 = i1 * k;
        BitMatrix bitmatrix1 = new BitMatrix(j1 * l, k1);
        for (int l1 = 0; l1 < i1; l1++)
        {
            int i2 = l1 * k;
            for (int j2 = 0; j2 < j1; j2++)
            {
                int k2 = j2 * l;
                for (int l2 = 0; l2 < k; l2++)
                {
                    int i3 = l2 + (1 + l1 * (k + 2));
                    int j3 = i2 + l2;
                    for (int k3 = 0; k3 < l; k3++)
                    {
                        if (bitmatrix.get(k3 + (1 + j2 * (l + 2)), i3))
                        {
                            bitmatrix1.set(k2 + k3, j3);
                        }
                    }

                }

            }

        }

        return bitmatrix1;
    }

    Version a()
    {
        return c;
    }

    boolean a(int i, int j, int k, int l)
    {
        int i1;
        int j1;
        if (i < 0)
        {
            j1 = i + k;
            i1 = j + (4 - (7 & k + 4));
        } else
        {
            i1 = j;
            j1 = i;
        }
        if (i1 < 0)
        {
            i1 += l;
            j1 += 4 - (7 & l + 4);
        }
        b.set(i1, j1);
        return a.get(i1, j1);
    }

    int b(int i, int j)
    {
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        if (a(i - 3, 0, i, j))
        {
            k = 1;
        } else
        {
            k = 0;
        }
        l = k << 1;
        if (a(i - 2, 0, i, j))
        {
            l |= 1;
        }
        i1 = l << 1;
        if (a(i - 1, 0, i, j))
        {
            i1 |= 1;
        }
        j1 = i1 << 1;
        if (a(0, j - 4, i, j))
        {
            j1 |= 1;
        }
        k1 = j1 << 1;
        if (a(0, j - 3, i, j))
        {
            k1 |= 1;
        }
        l1 = k1 << 1;
        if (a(0, j - 2, i, j))
        {
            l1 |= 1;
        }
        i2 = l1 << 1;
        if (a(0, j - 1, i, j))
        {
            i2 |= 1;
        }
        j2 = i2 << 1;
        if (a(1, j - 1, i, j))
        {
            j2 |= 1;
        }
        return j2;
    }

    int b(int i, int j, int k, int l)
    {
        boolean flag = a(i - 2, j - 2, k, l);
        int i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        int j1 = i1 << 1;
        if (a(i - 2, j - 1, k, l))
        {
            j1 |= 1;
        }
        int k1 = j1 << 1;
        if (a(i - 1, j - 2, k, l))
        {
            k1 |= 1;
        }
        int l1 = k1 << 1;
        if (a(i - 1, j - 1, k, l))
        {
            l1 |= 1;
        }
        int i2 = l1 << 1;
        if (a(i - 1, j, k, l))
        {
            i2 |= 1;
        }
        int j2 = i2 << 1;
        if (a(i, j - 2, k, l))
        {
            j2 |= 1;
        }
        int k2 = j2 << 1;
        if (a(i, j - 1, k, l))
        {
            k2 |= 1;
        }
        int l2 = k2 << 1;
        if (a(i, j, k, l))
        {
            l2 |= 1;
        }
        return l2;
    }

    byte[] b()
    {
        boolean flag;
        byte abyte0[];
        int i;
        int j;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        int k;
        int l;
        int i1;
        flag = false;
        abyte0 = new byte[c.getTotalCodewords()];
        i = a.getHeight();
        j = a.getWidth();
        flag1 = false;
        flag2 = false;
        flag3 = false;
        k = 0;
        l = 4;
        i1 = 0;
_L5:
        int i4;
        int k4;
        int l4;
        if (l == i && k == 0 && !flag3)
        {
            int j7 = i1 + 1;
            abyte0[i1] = (byte)a(i, j);
            int k7 = l - 2;
            int l7 = k + 2;
            i4 = j7;
            k4 = k7;
            l4 = l7;
            flag3 = true;
        } else
        if (l == i - 2 && k == 0 && (j & 3) != 0 && !flag2)
        {
            int k6 = i1 + 1;
            abyte0[i1] = (byte)b(i, j);
            int l6 = l - 2;
            int i7 = k + 2;
            i4 = k6;
            k4 = l6;
            l4 = i7;
            flag2 = true;
        } else
        if (l == i + 4 && k == 2 && (j & 7) == 0 && !flag1)
        {
            int l5 = i1 + 1;
            abyte0[i1] = (byte)c(i, j);
            int i6 = l - 2;
            int j6 = k + 2;
            i4 = l5;
            k4 = i6;
            l4 = j6;
            flag1 = true;
        } else
        {
            if (l != i - 2 || k != 0 || (j & 7) != 4 || flag)
            {
                break MISSING_BLOCK_LABEL_583;
            }
            int i5 = i1 + 1;
            abyte0[i1] = (byte)d(i, j);
            int j5 = l - 2;
            int k5 = k + 2;
            i4 = i5;
            k4 = j5;
            l4 = k5;
            flag = true;
        }
          goto _L1
_L3:
        int j1;
        int l1;
        int j2;
        j1 = k2;
        l1 = j2;
_L7:
        int i2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int j4;
        if (i2 < i && j1 >= 0 && !b.get(j1, i2))
        {
            j2 = l1 + 1;
            abyte0[l1] = (byte)b(i2, j1, i, j);
        } else
        {
            j2 = l1;
        }
        i2 -= 2;
        k2 = j1 + 2;
        if (i2 >= 0 && k2 < j) goto _L3; else goto _L2
_L2:
        l2 = i2 + 1;
        i3 = k2 + 3;
        j3 = l2;
        k3 = i3;
        l3 = j2;
_L6:
        if (j3 >= 0 && k3 < j && !b.get(k3, j3))
        {
            i4 = l3 + 1;
            abyte0[l3] = (byte)b(j3, k3, i, j);
        } else
        {
            i4 = l3;
        }
        j3 += 2;
        j4 = k3 - 2;
        if (j3 < i && j4 >= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k4 = j3 + 3;
        l4 = j4 + 1;
_L1:
        int k2;
        if (k4 >= i && l4 >= j)
        {
            if (i4 != c.getTotalCodewords())
            {
                throw FormatException.getFormatInstance();
            } else
            {
                return abyte0;
            }
        }
        i1 = i4;
        k = l4;
        l = k4;
        if (true) goto _L5; else goto _L4
_L4:
        k3 = j4;
        l3 = i4;
          goto _L6
        j1 = k;
        int k1 = l;
        l1 = i1;
        i2 = k1;
          goto _L7
    }

    int c(int i, int j)
    {
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        if (a(i - 1, 0, i, j))
        {
            k = 1;
        } else
        {
            k = 0;
        }
        l = k << 1;
        if (a(i - 1, j - 1, i, j))
        {
            l |= 1;
        }
        i1 = l << 1;
        if (a(0, j - 3, i, j))
        {
            i1 |= 1;
        }
        j1 = i1 << 1;
        if (a(0, j - 2, i, j))
        {
            j1 |= 1;
        }
        k1 = j1 << 1;
        if (a(0, j - 1, i, j))
        {
            k1 |= 1;
        }
        l1 = k1 << 1;
        if (a(1, j - 3, i, j))
        {
            l1 |= 1;
        }
        i2 = l1 << 1;
        if (a(1, j - 2, i, j))
        {
            i2 |= 1;
        }
        j2 = i2 << 1;
        if (a(1, j - 1, i, j))
        {
            j2 |= 1;
        }
        return j2;
    }

    int d(int i, int j)
    {
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        if (a(i - 3, 0, i, j))
        {
            k = 1;
        } else
        {
            k = 0;
        }
        l = k << 1;
        if (a(i - 2, 0, i, j))
        {
            l |= 1;
        }
        i1 = l << 1;
        if (a(i - 1, 0, i, j))
        {
            i1 |= 1;
        }
        j1 = i1 << 1;
        if (a(0, j - 2, i, j))
        {
            j1 |= 1;
        }
        k1 = j1 << 1;
        if (a(0, j - 1, i, j))
        {
            k1 |= 1;
        }
        l1 = k1 << 1;
        if (a(1, j - 1, i, j))
        {
            l1 |= 1;
        }
        i2 = l1 << 1;
        if (a(2, j - 1, i, j))
        {
            i2 |= 1;
        }
        j2 = i2 << 1;
        if (a(3, j - 1, i, j))
        {
            j2 |= 1;
        }
        return j2;
    }
}
