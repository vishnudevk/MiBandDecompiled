// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.DecoderResult;
import java.math.BigInteger;

// Referenced classes of package com.google.zxing.pdf417.decoder:
//            d, c

final class b
{

    private static final int a = 900;
    private static final int b = 901;
    private static final int c = 902;
    private static final int d = 924;
    private static final int e = 928;
    private static final int f = 923;
    private static final int g = 922;
    private static final int h = 913;
    private static final int i = 15;
    private static final int j = 25;
    private static final int k = 27;
    private static final int l = 27;
    private static final int m = 28;
    private static final int n = 28;
    private static final int o = 29;
    private static final int p = 29;
    private static final char q[] = {
        ';', '<', '>', '@', '[', '\\', '}', '_', '`', '~', 
        '!', '\r', '\t', ',', ':', '\n', '-', '.', '$', '/', 
        '"', '|', '*', '(', ')', '?', '{', '}', '\''
    };
    private static final char r[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        '&', '\r', '\t', ',', ':', '#', '-', '.', '$', '/', 
        '+', '%', '*', '=', '^'
    };
    private static final BigInteger s[];

    private b()
    {
    }

    private static int a(int i1, int ai[], int j1, StringBuilder stringbuilder)
    {
        if (i1 == 901)
        {
            int i3 = 0;
            long l3 = 0L;
            char ac1[] = new char[6];
            int ai1[] = new int[6];
            boolean flag1 = false;
            do
            {
                if (j1 >= ai[0] || flag1)
                {
                    break;
                }
                int k3 = j1 + 1;
                int i4 = ai[j1];
                int k1;
                long l1;
                boolean flag;
                int i2;
                int j2;
                char ac[];
                int k2;
                long l2;
                int j3;
                if (i4 < 900)
                {
                    ai1[i3] = i4;
                    i3++;
                    l3 = l3 * 900L + (long)i4;
                    j1 = k3;
                } else
                if (i4 == 900 || i4 == 901 || i4 == 902 || i4 == 924 || i4 == 928 || i4 == 923 || i4 == 922)
                {
                    j1 = k3 - 1;
                    flag1 = true;
                } else
                {
                    j1 = k3;
                }
                if (i3 % 5 == 0 && i3 > 0)
                {
                    for (int j4 = 0; j4 < 6;)
                    {
                        ac1[5 - j4] = (char)(int)(l3 % 256L);
                        long l4 = l3 >> 8;
                        j4++;
                        l3 = l4;
                    }

                    stringbuilder.append(ac1);
                    i3 = 0;
                }
            } while (true);
            for (j3 = 5 * (i3 / 5); j3 < i3; j3++)
            {
                stringbuilder.append((char)ai1[j3]);
            }

        } else
        if (i1 == 924)
        {
            k1 = 0;
            l1 = 0L;
            flag = false;
            do
            {
                if (j1 >= ai[0] || flag)
                {
                    break;
                }
                i2 = j1 + 1;
                j2 = ai[j1];
                if (j2 < 900)
                {
                    k1++;
                    l1 = l1 * 900L + (long)j2;
                    j1 = i2;
                } else
                if (j2 == 900 || j2 == 901 || j2 == 902 || j2 == 924 || j2 == 928 || j2 == 923 || j2 == 922)
                {
                    j1 = i2 - 1;
                    flag = true;
                } else
                {
                    j1 = i2;
                }
                if (k1 % 5 == 0 && k1 > 0)
                {
                    ac = new char[6];
                    for (k2 = 0; k2 < 6;)
                    {
                        ac[5 - k2] = (char)(int)(255L & l1);
                        l2 = l1 >> 8;
                        k2++;
                        l1 = l2;
                    }

                    stringbuilder.append(ac);
                }
            } while (true);
        }
        return j1;
    }

    private static int a(int ai[], int i1, StringBuilder stringbuilder)
    {
        int ai1[] = new int[ai[0] << 1];
        int ai2[] = new int[ai[0] << 1];
        boolean flag = false;
        int j1 = 0;
label0:
        do
        {
            while (i1 < ai[0] && !flag) 
            {
                int k1 = i1 + 1;
                int l1 = ai[i1];
                if (l1 < 900)
                {
                    ai1[j1] = l1 / 30;
                    ai1[j1 + 1] = l1 % 30;
                    j1 += 2;
                    i1 = k1;
                } else
                {
                    switch (l1)
                    {
                    default:
                        i1 = k1;
                        break;

                    case 900: 
                        i1 = k1 - 1;
                        flag = true;
                        break;

                    case 901: 
                        i1 = k1 - 1;
                        flag = true;
                        break;

                    case 902: 
                        i1 = k1 - 1;
                        flag = true;
                        break;

                    case 913: 
                        ai1[j1] = 913;
                        i1 = k1 + 1;
                        ai2[j1] = ai[k1];
                        j1++;
                        break;

                    case 924: 
                        i1 = k1 - 1;
                        flag = true;
                        break;
                    }
                    continue label0;
                }
            }
            a(ai1, ai2, j1, stringbuilder);
            return i1;
        } while (true);
    }

    static DecoderResult a(int ai[])
    {
        StringBuilder stringbuilder;
        int i1;
        int j1;
        stringbuilder = new StringBuilder(100);
        i1 = 2;
        j1 = ai[1];
_L7:
        if (i1 >= ai[0])
        {
            break MISSING_BLOCK_LABEL_168;
        }
        j1;
        JVM INSTR lookupswitch 5: default 76
    //                   900: 106
    //                   901: 117
    //                   902: 129
    //                   913: 140
    //                   924: 152;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        int k1 = a(ai, i1 - 1, stringbuilder);
_L8:
        if (k1 < ai.length)
        {
            i1 = k1 + 1;
            j1 = ai[k1];
        } else
        {
            throw FormatException.getFormatInstance();
        }
        if (true) goto _L7; else goto _L2
_L2:
        k1 = a(ai, i1, stringbuilder);
          goto _L8
_L3:
        k1 = a(j1, ai, i1, stringbuilder);
          goto _L8
_L4:
        k1 = b(ai, i1, stringbuilder);
          goto _L8
_L5:
        k1 = a(j1, ai, i1, stringbuilder);
          goto _L8
_L6:
        k1 = a(j1, ai, i1, stringbuilder);
          goto _L8
        return new DecoderResult(null, stringbuilder.toString(), null, null);
    }

    private static String a(int ai[], int i1)
    {
        BigInteger biginteger = BigInteger.ZERO;
        for (int j1 = 0; j1 < i1; j1++)
        {
            biginteger = biginteger.add(s[-1 + (i1 - j1)].multiply(BigInteger.valueOf(ai[j1])));
        }

        String s1 = biginteger.toString();
        if (s1.charAt(0) != '1')
        {
            throw FormatException.getFormatInstance();
        } else
        {
            return s1.substring(1);
        }
    }

    private static void a(int ai[], int ai1[], int i1, StringBuilder stringbuilder)
    {
        d d1;
        d d2;
        int j1;
        d1 = d.a;
        d2 = d.a;
        j1 = 0;
_L10:
        if (j1 >= i1) goto _L2; else goto _L1
_L1:
        int k1;
        int l1;
        char c1;
        k1 = ai[j1];
        l1 = c.a[d1.ordinal()];
        c1 = '\0';
        l1;
        JVM INSTR tableswitch 1 6: default 80
    //                   1 98
    //                   2 223
    //                   3 360
    //                   4 503
    //                   5 566
    //                   6 606;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
        if (c1 != 0)
        {
            stringbuilder.append(c1);
        }
        j1++;
          goto _L10
_L4:
        if (k1 < 26)
        {
            c1 = (char)(k1 + 65);
        } else
        if (k1 == 26)
        {
            c1 = ' ';
        } else
        if (k1 == 27)
        {
            d1 = d.b;
            c1 = '\0';
        } else
        if (k1 == 28)
        {
            d1 = d.c;
            c1 = '\0';
        } else
        if (k1 == 29)
        {
            d d9 = d.f;
            d d10 = d1;
            d1 = d9;
            d2 = d10;
            c1 = '\0';
        } else
        {
            c1 = '\0';
            if (k1 == 913)
            {
                stringbuilder.append((char)ai1[j1]);
                c1 = '\0';
            }
        }
          goto _L3
_L5:
        if (k1 < 26)
        {
            c1 = (char)(k1 + 97);
        } else
        if (k1 == 26)
        {
            c1 = ' ';
        } else
        if (k1 == 27)
        {
            d d7 = d.e;
            d d8 = d1;
            d1 = d7;
            d2 = d8;
            c1 = '\0';
        } else
        if (k1 == 28)
        {
            d1 = d.c;
            c1 = '\0';
        } else
        if (k1 == 29)
        {
            d d5 = d.f;
            d d6 = d1;
            d1 = d5;
            d2 = d6;
            c1 = '\0';
        } else
        {
            c1 = '\0';
            if (k1 == 913)
            {
                stringbuilder.append((char)ai1[j1]);
                c1 = '\0';
            }
        }
          goto _L3
_L6:
        if (k1 < 25)
        {
            c1 = r[k1];
        } else
        if (k1 == 25)
        {
            d1 = d.d;
            c1 = '\0';
        } else
        if (k1 == 26)
        {
            c1 = ' ';
        } else
        if (k1 == 27)
        {
            d1 = d.b;
            c1 = '\0';
        } else
        if (k1 == 28)
        {
            d1 = d.a;
            c1 = '\0';
        } else
        if (k1 == 29)
        {
            d d3 = d.f;
            d d4 = d1;
            d1 = d3;
            d2 = d4;
            c1 = '\0';
        } else
        {
            c1 = '\0';
            if (k1 == 913)
            {
                stringbuilder.append((char)ai1[j1]);
                c1 = '\0';
            }
        }
          goto _L3
_L7:
        if (k1 < 29)
        {
            c1 = q[k1];
        } else
        if (k1 == 29)
        {
            d1 = d.a;
            c1 = '\0';
        } else
        {
            c1 = '\0';
            if (k1 == 913)
            {
                stringbuilder.append((char)ai1[j1]);
                c1 = '\0';
            }
        }
          goto _L3
_L8:
        if (k1 < 26)
        {
            c1 = (char)(k1 + 65);
            d1 = d2;
        } else
        {
            if (k1 != 26)
            {
                break MISSING_BLOCK_LABEL_647;
            }
            c1 = ' ';
            d1 = d2;
        }
          goto _L3
_L9:
        if (k1 < 29)
        {
            c1 = q[k1];
            d1 = d2;
        } else
        {
            if (k1 != 29)
            {
                break MISSING_BLOCK_LABEL_647;
            }
            d1 = d.a;
            c1 = '\0';
        }
          goto _L3
_L2:
        return;
        d1 = d2;
        c1 = '\0';
          goto _L3
    }

    private static int b(int ai[], int i1, StringBuilder stringbuilder)
    {
        int ai1[] = new int[15];
        boolean flag = false;
        int j1 = 0;
        do
        {
            if (i1 >= ai[0] || flag)
            {
                break;
            }
            int k1 = i1 + 1;
            int l1 = ai[i1];
            if (k1 == ai[0])
            {
                flag = true;
            }
            if (l1 < 900)
            {
                ai1[j1] = l1;
                j1++;
                i1 = k1;
            } else
            if (l1 == 900 || l1 == 901 || l1 == 924 || l1 == 928 || l1 == 923 || l1 == 922)
            {
                i1 = k1 - 1;
                flag = true;
            } else
            {
                i1 = k1;
            }
            if (j1 % 15 == 0 || l1 == 902 || flag)
            {
                stringbuilder.append(a(ai1, j1));
                j1 = 0;
            }
        } while (true);
        return i1;
    }

    static 
    {
        s = new BigInteger[16];
        s[0] = BigInteger.ONE;
        BigInteger biginteger = BigInteger.valueOf(900L);
        s[1] = biginteger;
        for (int i1 = 2; i1 < s.length; i1++)
        {
            s[i1] = s[i1 - 1].multiply(biginteger);
        }

    }
}
