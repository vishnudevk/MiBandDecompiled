// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

// Referenced classes of package com.google.zxing.oned.rss.expanded.decoders:
//            l, k, p, o, 
//            n, r

final class s
{

    private final BitArray a;
    private final l b = new l();
    private final StringBuilder c = new StringBuilder();

    s(BitArray bitarray)
    {
        a = bitarray;
    }

    static int a(BitArray bitarray, int j, int i1)
    {
        int j1 = 0;
        if (i1 > 32)
        {
            throw new IllegalArgumentException("extractNumberValueFromBitArray can't handle more than 32 bits");
        }
        for (int k1 = 0; k1 < i1; k1++)
        {
            if (bitarray.get(j + k1))
            {
                j1 |= 1 << -1 + (i1 - k1);
            }
        }

        return j1;
    }

    private o a()
    {
        do
        {
            int j = b.a();
            k k1;
            boolean flag;
            boolean flag1;
            if (b.b())
            {
                k1 = d();
                flag = k1.b();
            } else
            if (b.d())
            {
                k1 = c();
                flag = k1.b();
            } else
            {
                k1 = b();
                flag = k1.b();
            }
            if (j != b.a())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            while (!flag1 && !flag || flag) 
            {
                return k1.a();
            }
        } while (true);
    }

    private boolean a(int j)
    {
        if (j + 7 <= a.getSize()) goto _L2; else goto _L1
_L1:
        if (j + 4 > a.getSize()) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        int i1 = j;
label0:
        do
        {
label1:
            {
                if (i1 >= j + 3)
                {
                    break label1;
                }
                if (a.get(i1))
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L3; else goto _L5
_L5:
        return a.get(j + 3);
    }

    private k b()
    {
        p p1;
        for (; a(b.a()); c.append(p1.b()))
        {
            p1 = b(b.a());
            b.a(p1.g());
            if (p1.d())
            {
                o o1;
                if (p1.e())
                {
                    o1 = new o(b.a(), c.toString());
                } else
                {
                    o1 = new o(b.a(), c.toString(), p1.b());
                }
                return new k(o1, true);
            }
            c.append(p1.a());
            if (p1.e())
            {
                return new k(new o(b.a(), c.toString()), true);
            }
        }

        if (i(b.a()))
        {
            b.f();
            b.b(4);
        }
        return new k(false);
    }

    private p b(int j)
    {
        if (j + 7 > a.getSize())
        {
            int l1 = a(j, 4);
            if (l1 == 0)
            {
                return new p(a.getSize(), 10, 10);
            } else
            {
                return new p(a.getSize(), l1 - 1, 10);
            }
        } else
        {
            int i1 = a(j, 7);
            int j1 = (i1 - 8) / 11;
            int k1 = (i1 - 8) % 11;
            return new p(j + 7, j1, k1);
        }
    }

    private k c()
    {
        n n1;
        for (; c(b.a()); c.append(n1.a()))
        {
            n1 = d(b.a());
            b.a(n1.g());
            if (n1.b())
            {
                return new k(new o(b.a(), c.toString()), true);
            }
        }

        if (!h(b.a())) goto _L2; else goto _L1
_L1:
        b.b(3);
        b.e();
_L4:
        return new k(false);
_L2:
        if (g(b.a()))
        {
            if (5 + b.a() < a.getSize())
            {
                b.b(5);
            } else
            {
                b.a(a.getSize());
            }
            b.f();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean c(int j)
    {
        boolean flag = true;
        if (j + 5 <= a.getSize())
        {
            int i1 = a(j, 5);
            if (i1 >= 5 && i1 < 16)
            {
                return flag;
            }
            if (j + 7 <= a.getSize())
            {
                int j1 = a(j, 7);
                if (j1 >= 64 && j1 < 116)
                {
                    return flag;
                }
                if (j + 8 <= a.getSize())
                {
                    int k1 = a(j, 8);
                    if (k1 < 232 || k1 >= 253)
                    {
                        flag = false;
                    }
                    return flag;
                }
            }
        }
        return false;
    }

    private k d()
    {
        n n1;
        for (; e(b.a()); c.append(n1.a()))
        {
            n1 = f(b.a());
            b.a(n1.g());
            if (n1.b())
            {
                return new k(new o(b.a(), c.toString()), true);
            }
        }

        if (!h(b.a())) goto _L2; else goto _L1
_L1:
        b.b(3);
        b.e();
_L4:
        return new k(false);
_L2:
        if (g(b.a()))
        {
            if (5 + b.a() < a.getSize())
            {
                b.b(5);
            } else
            {
                b.a(a.getSize());
            }
            b.g();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private n d(int j)
    {
        int k1;
        int i1 = a(j, 5);
        if (i1 == 15)
        {
            return new n(j + 5, '$');
        }
        if (i1 >= 5 && i1 < 15)
        {
            return new n(j + 5, (char)(-5 + (i1 + 48)));
        }
        int j1 = a(j, 7);
        if (j1 >= 64 && j1 < 90)
        {
            return new n(j + 7, (char)(j1 + 1));
        }
        if (j1 >= 90 && j1 < 116)
        {
            return new n(j + 7, (char)(j1 + 7));
        }
        k1 = a(j, 8);
        k1;
        JVM INSTR tableswitch 232 252: default 232
    //                   232 260
    //                   233 278
    //                   234 285
    //                   235 292
    //                   236 299
    //                   237 306
    //                   238 313
    //                   239 320
    //                   240 327
    //                   241 334
    //                   242 341
    //                   243 348
    //                   244 355
    //                   245 362
    //                   246 369
    //                   247 376
    //                   248 383
    //                   249 390
    //                   250 397
    //                   251 404
    //                   252 411;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Decoding invalid ISO/IEC 646 value: ").append(k1).toString());
_L2:
        char c1 = '!';
_L24:
        return new n(j + 8, c1);
_L3:
        c1 = '"';
        continue; /* Loop/switch isn't completed */
_L4:
        c1 = '%';
        continue; /* Loop/switch isn't completed */
_L5:
        c1 = '&';
        continue; /* Loop/switch isn't completed */
_L6:
        c1 = '\'';
        continue; /* Loop/switch isn't completed */
_L7:
        c1 = '(';
        continue; /* Loop/switch isn't completed */
_L8:
        c1 = ')';
        continue; /* Loop/switch isn't completed */
_L9:
        c1 = '*';
        continue; /* Loop/switch isn't completed */
_L10:
        c1 = '+';
        continue; /* Loop/switch isn't completed */
_L11:
        c1 = ',';
        continue; /* Loop/switch isn't completed */
_L12:
        c1 = '-';
        continue; /* Loop/switch isn't completed */
_L13:
        c1 = '.';
        continue; /* Loop/switch isn't completed */
_L14:
        c1 = '/';
        continue; /* Loop/switch isn't completed */
_L15:
        c1 = ':';
        continue; /* Loop/switch isn't completed */
_L16:
        c1 = ';';
        continue; /* Loop/switch isn't completed */
_L17:
        c1 = '<';
        continue; /* Loop/switch isn't completed */
_L18:
        c1 = '=';
        continue; /* Loop/switch isn't completed */
_L19:
        c1 = '>';
        continue; /* Loop/switch isn't completed */
_L20:
        c1 = '?';
        continue; /* Loop/switch isn't completed */
_L21:
        c1 = '_';
        continue; /* Loop/switch isn't completed */
_L22:
        c1 = ' ';
        if (true) goto _L24; else goto _L23
_L23:
    }

    private boolean e(int j)
    {
        boolean flag = true;
        if (j + 5 <= a.getSize())
        {
            int i1 = a(j, 5);
            if (i1 >= 5 && i1 < 16)
            {
                return flag;
            }
            if (j + 6 <= a.getSize())
            {
                int j1 = a(j, 6);
                if (j1 < 16 || j1 >= 63)
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    private n f(int j)
    {
        int j1;
        int i1 = a(j, 5);
        if (i1 == 15)
        {
            return new n(j + 5, '$');
        }
        if (i1 >= 5 && i1 < 15)
        {
            return new n(j + 5, (char)(-5 + (i1 + 48)));
        }
        j1 = a(j, 6);
        if (j1 >= 32 && j1 < 58)
        {
            return new n(j + 6, (char)(j1 + 33));
        }
        j1;
        JVM INSTR tableswitch 58 62: default 128
    //                   58 155
    //                   59 173
    //                   60 180
    //                   61 187
    //                   62 194;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        throw new IllegalStateException((new StringBuilder()).append("Decoding invalid alphanumeric value: ").append(j1).toString());
_L2:
        char c1 = '*';
_L8:
        return new n(j + 6, c1);
_L3:
        c1 = ',';
        continue; /* Loop/switch isn't completed */
_L4:
        c1 = '-';
        continue; /* Loop/switch isn't completed */
_L5:
        c1 = '.';
        continue; /* Loop/switch isn't completed */
_L6:
        c1 = '/';
        if (true) goto _L8; else goto _L7
_L7:
    }

    private boolean g(int j)
    {
        if (j + 1 <= a.getSize()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i1 = 0;
_L6:
        if (i1 >= 5 || i1 + j >= a.getSize())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (i1 != 2) goto _L4; else goto _L3
_L3:
        if (!a.get(j + 2)) goto _L1; else goto _L5
_L5:
        i1++;
          goto _L6
_L4:
        if (!a.get(j + i1)) goto _L5; else goto _L7
_L7:
        return false;
        return true;
    }

    private boolean h(int j)
    {
        if (j + 3 <= a.getSize()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i1 = j;
label0:
        do
        {
label1:
            {
                if (i1 >= j + 3)
                {
                    break label1;
                }
                if (a.get(i1))
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    private boolean i(int j)
    {
        if (j + 1 <= a.getSize()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= 4 || i1 + j >= a.getSize())
                {
                    break label1;
                }
                if (a.get(j + i1))
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    int a(int j, int i1)
    {
        return a(a, j, i1);
    }

    o a(int j, String s1)
    {
        c.setLength(0);
        if (s1 != null)
        {
            c.append(s1);
        }
        b.a(j);
        o o1 = a();
        if (o1 != null && o1.b())
        {
            return new o(b.a(), c.toString(), o1.c());
        } else
        {
            return new o(b.a(), c.toString());
        }
    }

    String a(StringBuilder stringbuilder, int j)
    {
        String s1 = null;
        do
        {
            o o1 = a(j, s1);
            String s2 = r.a(o1.a());
            if (s2 != null)
            {
                stringbuilder.append(s2);
            }
            if (o1.b())
            {
                s1 = String.valueOf(o1.c());
            } else
            {
                s1 = null;
            }
            if (j == o1.g())
            {
                return stringbuilder.toString();
            }
            j = o1.g();
        } while (true);
    }
}
