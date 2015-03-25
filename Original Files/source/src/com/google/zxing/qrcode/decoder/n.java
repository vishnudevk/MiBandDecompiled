// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;


// Referenced classes of package com.google.zxing.qrcode.decoder:
//            ErrorCorrectionLevel

final class n
{

    private static final int a = 21522;
    private static final int b[][] = {
        {
            21522, 0
        }, {
            20773, 1
        }, {
            24188, 2
        }, {
            23371, 3
        }, {
            17913, 4
        }, {
            16590, 5
        }, {
            20375, 6
        }, {
            19104, 7
        }, {
            30660, 8
        }, {
            29427, 9
        }, {
            32170, 10
        }, {
            30877, 11
        }, {
            26159, 12
        }, {
            25368, 13
        }, {
            27713, 14
        }, {
            26998, 15
        }, {
            5769, 16
        }, {
            5054, 17
        }, {
            7399, 18
        }, {
            6608, 19
        }, {
            1890, 20
        }, {
            597, 21
        }, {
            3340, 22
        }, {
            2107, 23
        }, {
            13663, 24
        }, {
            12392, 25
        }, {
            16177, 26
        }, {
            14854, 27
        }, {
            9396, 28
        }, {
            8579, 29
        }, {
            11994, 30
        }, {
            11245, 31
        }
    };
    private static final int c[] = {
        0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 
        2, 3, 2, 3, 3, 4
    };
    private final ErrorCorrectionLevel d;
    private final byte e;

    private n(int i)
    {
        d = ErrorCorrectionLevel.forBits(3 & i >> 3);
        e = (byte)(i & 7);
    }

    static int a(int i, int j)
    {
        int k = i ^ j;
        return c[k & 0xf] + c[0xf & k >>> 4] + c[0xf & k >>> 8] + c[0xf & k >>> 12] + c[0xf & k >>> 16] + c[0xf & k >>> 20] + c[0xf & k >>> 24] + c[0xf & k >>> 28];
    }

    static n b(int i, int j)
    {
        n n1 = c(i, j);
        if (n1 != null)
        {
            return n1;
        } else
        {
            return c(i ^ 0x5412, j ^ 0x5412);
        }
    }

    private static n c(int i, int j)
    {
        int k;
        int ai[][];
        int l;
        int i1;
        int j1;
        k = 0x7fffffff;
        ai = b;
        l = ai.length;
        i1 = 0;
        j1 = 0;
_L2:
        if (i1 >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        int ai1[] = ai[i1];
        int k1 = ai1[0];
        if (k1 == i || k1 == j)
        {
            return new n(ai1[1]);
        }
        int l1 = a(i, k1);
        int i2;
        int j2;
        int k2;
        if (l1 < k)
        {
            i2 = ai1[1];
        } else
        {
            l1 = k;
            i2 = j1;
        }
        if (i == j)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        j2 = a(j, k1);
        if (j2 >= l1)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        i2 = ai1[1];
_L3:
        i1++;
        k2 = i2;
        k = j2;
        j1 = k2;
        if (true) goto _L2; else goto _L1
_L1:
        if (k <= 3)
        {
            return new n(j1);
        } else
        {
            return null;
        }
        j2 = l1;
          goto _L3
    }

    ErrorCorrectionLevel a()
    {
        return d;
    }

    byte b()
    {
        return e;
    }

    public boolean equals(Object obj)
    {
        n n1;
        if (obj instanceof n)
        {
            if (d == (n1 = (n)obj).d && e == n1.e)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return d.ordinal() << 3 | e;
    }

}
