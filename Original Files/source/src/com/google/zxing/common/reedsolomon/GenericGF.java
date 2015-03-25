// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common.reedsolomon;


// Referenced classes of package com.google.zxing.common.reedsolomon:
//            a

public final class GenericGF
{

    public static final GenericGF AZTEC_DATA_10 = new GenericGF(1033, 1024);
    public static final GenericGF AZTEC_DATA_12 = new GenericGF(4201, 4096);
    public static final GenericGF AZTEC_DATA_6;
    public static final GenericGF AZTEC_DATA_8;
    public static final GenericGF AZTEC_PARAM = new GenericGF(19, 16);
    public static final GenericGF DATA_MATRIX_FIELD_256;
    public static final GenericGF MAXICODE_FIELD_64;
    public static final GenericGF QR_CODE_FIELD_256 = new GenericGF(285, 256);
    private static final int a;
    private int b[];
    private int c[];
    private a d;
    private a e;
    private final int f;
    private final int g;
    private boolean h;

    public GenericGF(int i, int j)
    {
        h = false;
        g = i;
        f = j;
        if (j <= 0)
        {
            c();
        }
    }

    static int b(int i, int j)
    {
        return i ^ j;
    }

    private void c()
    {
        b = new int[f];
        c = new int[f];
        int i = 0;
        int j = 1;
        for (; i < f; i++)
        {
            b[i] = j;
            j <<= 1;
            if (j >= f)
            {
                j = (j ^ g) & -1 + f;
            }
        }

        for (int k = 0; k < -1 + f; k++)
        {
            c[b[k]] = k;
        }

        d = new a(this, new int[] {
            0
        });
        e = new a(this, new int[] {
            1
        });
        h = true;
    }

    private void d()
    {
        if (!h)
        {
            c();
        }
    }

    int a(int i)
    {
        d();
        return b[i];
    }

    a a()
    {
        d();
        return d;
    }

    a a(int i, int j)
    {
        d();
        if (i < 0)
        {
            throw new IllegalArgumentException();
        }
        if (j == 0)
        {
            return d;
        } else
        {
            int ai[] = new int[i + 1];
            ai[0] = j;
            return new a(this, ai);
        }
    }

    int b(int i)
    {
        d();
        if (i == 0)
        {
            throw new IllegalArgumentException();
        } else
        {
            return c[i];
        }
    }

    a b()
    {
        d();
        return e;
    }

    int c(int i)
    {
        d();
        if (i == 0)
        {
            throw new ArithmeticException();
        } else
        {
            return b[-1 + (f - c[i])];
        }
    }

    int c(int i, int j)
    {
        d();
        if (i == 0 || j == 0)
        {
            return 0;
        }
        if (i < 0 || j < 0 || i >= f || j >= f)
        {
            i++;
        }
        int k = c[i] + c[j];
        return b[k % f + k / f];
    }

    public int getSize()
    {
        return f;
    }

    static 
    {
        AZTEC_DATA_6 = new GenericGF(67, 64);
        DATA_MATRIX_FIELD_256 = new GenericGF(301, 256);
        AZTEC_DATA_8 = DATA_MATRIX_FIELD_256;
        MAXICODE_FIELD_64 = AZTEC_DATA_6;
    }
}
