// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common.reedsolomon;


// Referenced classes of package com.google.zxing.common.reedsolomon:
//            a, GenericGF, ReedSolomonException

public final class ReedSolomonDecoder
{

    private final GenericGF a;

    public ReedSolomonDecoder(GenericGF genericgf)
    {
        a = genericgf;
    }

    private int[] a(a a1)
    {
        int i = 0;
        int j = 1;
        int k = a1.b();
        if (k == j)
        {
            int ai1[] = new int[j];
            ai1[0] = a1.a(j);
            return ai1;
        }
        int ai[] = new int[k];
        for (; j < a.getSize() && i < k; j++)
        {
            if (a1.b(j) == 0)
            {
                ai[i] = a.c(j);
                i++;
            }
        }

        if (i != k)
        {
            throw new ReedSolomonException("Error locator degree does not match number of roots");
        } else
        {
            return ai;
        }
    }

    private int[] a(a a1, int ai[], boolean flag)
    {
        int i = ai.length;
        int ai1[] = new int[i];
        int j = 0;
        while (j < i) 
        {
            int k = a.c(ai[j]);
            int l = 1;
            int i1 = 0;
            while (i1 < i) 
            {
                int j1;
                if (j != i1)
                {
                    int k1 = a.c(ai[i1], k);
                    int l1;
                    if ((k1 & 1) == 0)
                    {
                        l1 = k1 | 1;
                    } else
                    {
                        l1 = k1 & -2;
                    }
                    j1 = a.c(l, l1);
                } else
                {
                    j1 = l;
                }
                i1++;
                l = j1;
            }
            ai1[j] = a.c(a1.b(k), a.c(l));
            if (flag)
            {
                ai1[j] = a.c(ai1[j], k);
            }
            j++;
        }
        return ai1;
    }

    private a[] a(a a1, a a2, int i)
    {
        a a4;
        a a5;
        a a6;
        a a7;
        int j;
        if (a1.b() >= a2.b())
        {
            a a3 = a2;
            a2 = a1;
            a1 = a3;
        }
        a4 = a.b();
        a5 = a.a();
        a6 = a.a();
        a7 = a.b();
        while (a1.b() >= i / 2) 
        {
            if (a1.c())
            {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            a a8 = a.a();
            int l = a1.a(a1.b());
            int i1 = a.c(l);
            a a9 = a8;
            a a10;
            int j1;
            int k1;
            for (a10 = a2; a10.b() >= a1.b() && !a10.c(); a10 = a10.a(a1.a(j1, k1)))
            {
                j1 = a10.b() - a1.b();
                k1 = a.c(a10.a(a10.b()), i1);
                a9 = a9.a(a.a(j1, k1));
            }

            a a11 = a9.b(a5).a(a4);
            a a12 = a9.b(a7).a(a6);
            a2 = a1;
            a1 = a10;
            a4 = a5;
            a5 = a11;
            a a13 = a7;
            a7 = a12;
            a6 = a13;
        }
        j = a7.a(0);
        if (j == 0)
        {
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        } else
        {
            int k = a.c(j);
            return (new a[] {
                a7.c(k), a1.c(k)
            });
        }
    }

    public void decode(int ai[], int i)
    {
        int j = 0;
        a a1 = new a(a, ai);
        int ai1[] = new int[i];
        boolean flag = a.equals(GenericGF.DATA_MATRIX_FIELD_256);
        int k = 0;
        boolean flag1 = true;
        while (k < i) 
        {
            GenericGF genericgf = a;
            int i1;
            int j1;
            boolean flag2;
            if (flag)
            {
                i1 = k + 1;
            } else
            {
                i1 = k;
            }
            j1 = a1.b(genericgf.a(i1));
            ai1[(-1 + ai1.length) - k] = j1;
            a a2;
            a aa[];
            a a3;
            a a4;
            int ai2[];
            int ai3[];
            int l;
            if (j1 != 0)
            {
                flag2 = false;
            } else
            {
                flag2 = flag1;
            }
            k++;
            flag1 = flag2;
        }
        if (!flag1)
        {
            a2 = new a(a, ai1);
            aa = a(a.a(i, 1), a2, i);
            a3 = aa[0];
            a4 = aa[1];
            ai2 = a(a3);
            ai3 = a(a4, ai2, flag);
            while (j < ai2.length) 
            {
                l = (-1 + ai.length) - a.b(ai2[j]);
                if (l < 0)
                {
                    throw new ReedSolomonException("Bad error location");
                }
                ai[l] = GenericGF.b(ai[l], ai3[j]);
                j++;
            }
        }
    }
}
