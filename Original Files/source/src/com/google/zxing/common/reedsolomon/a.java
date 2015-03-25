// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common.reedsolomon;


// Referenced classes of package com.google.zxing.common.reedsolomon:
//            GenericGF

final class a
{

    private final GenericGF a;
    private final int b[];

    a(GenericGF genericgf, int ai[])
    {
        int i = 1;
        super();
        if (ai.length == 0)
        {
            throw new IllegalArgumentException();
        }
        a = genericgf;
        int j = ai.length;
        if (j > i && ai[0] == 0)
        {
            for (; i < j && ai[i] == 0; i++) { }
            if (i == j)
            {
                b = genericgf.a().b;
                return;
            } else
            {
                b = new int[j - i];
                System.arraycopy(ai, i, b, 0, b.length);
                return;
            }
        } else
        {
            b = ai;
            return;
        }
    }

    int a(int i)
    {
        return b[(-1 + b.length) - i];
    }

    a a(int i, int j)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException();
        }
        if (j == 0)
        {
            return a.a();
        }
        int k = b.length;
        int ai[] = new int[k + i];
        for (int l = 0; l < k; l++)
        {
            ai[l] = a.c(b[l], j);
        }

        return new a(a, ai);
    }

    a a(a a1)
    {
        if (!a.equals(a1.a))
        {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (c())
        {
            return a1;
        }
        if (a1.c())
        {
            return this;
        }
        int ai[] = b;
        int ai1[] = a1.b;
        int ai3[];
        int i;
        if (ai.length <= ai1.length)
        {
            int ai2[] = ai1;
            ai1 = ai;
            ai = ai2;
        }
        ai3 = new int[ai.length];
        i = ai.length - ai1.length;
        System.arraycopy(ai, 0, ai3, 0, i);
        for (int j = i; j < ai.length; j++)
        {
            ai3[j] = GenericGF.b(ai1[j - i], ai[j]);
        }

        return new a(a, ai3);
    }

    int[] a()
    {
        return b;
    }

    int b()
    {
        return -1 + b.length;
    }

    int b(int i)
    {
        int j = 0;
        if (i != 0) goto _L2; else goto _L1
_L1:
        int l = a(0);
_L4:
        return l;
_L2:
        int k;
        k = b.length;
        if (i != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        l = 0;
        while (j < k) 
        {
            int k1 = GenericGF.b(l, b[j]);
            j++;
            l = k1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        l = b[0];
        int i1 = 1;
        while (i1 < k) 
        {
            int j1 = GenericGF.b(a.c(i, l), b[i1]);
            i1++;
            l = j1;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    a b(a a1)
    {
        if (!a.equals(a1.a))
        {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (c() || a1.c())
        {
            return a.a();
        }
        int ai[] = b;
        int i = ai.length;
        int ai1[] = a1.b;
        int j = ai1.length;
        int ai2[] = new int[-1 + (i + j)];
        for (int k = 0; k < i; k++)
        {
            int l = ai[k];
            for (int i1 = 0; i1 < j; i1++)
            {
                ai2[k + i1] = GenericGF.b(ai2[k + i1], a.c(l, ai1[i1]));
            }

        }

        return new a(a, ai2);
    }

    a c(int i)
    {
        if (i == 0)
        {
            this = a.a();
        } else
        if (i != 1)
        {
            int j = b.length;
            int ai[] = new int[j];
            for (int k = 0; k < j; k++)
            {
                ai[k] = a.c(b[k], i);
            }

            return new a(a, ai);
        }
        return this;
    }

    boolean c()
    {
        int i = b[0];
        boolean flag = false;
        if (i == 0)
        {
            flag = true;
        }
        return flag;
    }

    a[] c(a a1)
    {
        if (!a.equals(a1.a))
        {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (a1.c())
        {
            throw new IllegalArgumentException("Divide by 0");
        }
        a a2 = a.a();
        int i = a1.a(a1.b());
        int j = a.c(i);
        a a3 = a2;
        a a4;
        a a5;
        for (a4 = this; a4.b() >= a1.b() && !a4.c(); a4 = a4.a(a5))
        {
            int k = a4.b() - a1.b();
            int l = a.c(a4.a(a4.b()), j);
            a5 = a1.a(k, l);
            a3 = a3.a(a.a(k, l));
        }

        return (new a[] {
            a3, a4
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(8 * b());
        int i = b();
        do
        {
            if (i >= 0)
            {
                int j = a(i);
                if (j != 0)
                {
                    if (j < 0)
                    {
                        stringbuilder.append(" - ");
                        j = -j;
                    } else
                    if (stringbuilder.length() > 0)
                    {
                        stringbuilder.append(" + ");
                    }
                    if (i == 0 || j != 1)
                    {
                        int k = a.b(j);
                        if (k == 0)
                        {
                            stringbuilder.append('1');
                        } else
                        if (k == 1)
                        {
                            stringbuilder.append('a');
                        } else
                        {
                            stringbuilder.append("a^");
                            stringbuilder.append(k);
                        }
                    }
                    if (i != 0)
                    {
                        if (i == 1)
                        {
                            stringbuilder.append('x');
                        } else
                        {
                            stringbuilder.append("x^");
                            stringbuilder.append(i);
                        }
                    }
                }
                i--;
                continue;
            }
            return stringbuilder.toString();
        } while (true);
    }
}
