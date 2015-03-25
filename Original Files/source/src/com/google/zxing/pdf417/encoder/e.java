// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.pdf417.encoder;

import com.google.zxing.WriterException;
import java.math.BigInteger;
import java.util.Arrays;

// Referenced classes of package com.google.zxing.pdf417.encoder:
//            Compaction

final class e
{

    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private static final int h = 900;
    private static final int i = 901;
    private static final int j = 902;
    private static final int k = 913;
    private static final int l = 924;
    private static final byte m[] = {
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
        38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 
        43, 37, 42, 61, 94, 0, 32, 0, 0, 0
    };
    private static final byte n[] = {
        59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 
        33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 
        34, 124, 42, 40, 41, 63, 123, 125, 39, 0
    };
    private static final byte o[];
    private static final byte p[];

    private e()
    {
    }

    private static int a(CharSequence charsequence, int i1)
    {
        int j1 = charsequence.length();
        int k1 = 0;
        if (i1 < j1)
        {
            char c1 = charsequence.charAt(i1);
            do
            {
                if (!a(c1) || i1 >= j1)
                {
                    break;
                }
                k1++;
                if (++i1 < j1)
                {
                    c1 = charsequence.charAt(i1);
                }
            } while (true);
        }
        return k1;
    }

    private static int a(CharSequence charsequence, int i1, int j1, StringBuilder stringbuilder, int k1)
    {
        StringBuilder stringbuilder1;
        int l1;
        stringbuilder1 = new StringBuilder(j1);
        l1 = 0;
_L10:
        char c1 = charsequence.charAt(i1 + l1);
        k1;
        JVM INSTR tableswitch 0 2: default 52
    //                   0 150
    //                   1 259
    //                   2 377;
           goto _L1 _L2 _L3 _L4
_L1:
        if (!e(c1)) goto _L6; else goto _L5
_L5:
        stringbuilder1.append((char)p[c1]);
_L8:
        int i2;
        int k2;
        if (++l1 >= j1)
        {
            i2 = stringbuilder1.length();
            int j2 = 0;
            k2 = 0;
            while (j2 < i2) 
            {
                boolean flag;
                char c2;
                if (j2 % 2 != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    c2 = (char)(k2 * 30 + stringbuilder1.charAt(j2));
                    stringbuilder.append(c2);
                } else
                {
                    c2 = stringbuilder1.charAt(j2);
                }
                j2++;
                k2 = c2;
            }
            break; /* Loop/switch isn't completed */
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (b(c1))
        {
            if (c1 == ' ')
            {
                stringbuilder1.append('\032');
            } else
            {
                stringbuilder1.append((char)(c1 - 65));
            }
            continue; /* Loop/switch isn't completed */
        }
        if (c(c1))
        {
            stringbuilder1.append('\033');
            k1 = 1;
        } else
        if (d(c1))
        {
            k1 = 2;
            stringbuilder1.append('\034');
        } else
        {
            stringbuilder1.append('\035');
            stringbuilder1.append((char)p[c1]);
            continue; /* Loop/switch isn't completed */
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (c(c1))
        {
            if (c1 == ' ')
            {
                stringbuilder1.append('\032');
            } else
            {
                stringbuilder1.append((char)(c1 - 97));
            }
            continue; /* Loop/switch isn't completed */
        }
        if (b(c1))
        {
            stringbuilder1.append('\033');
            stringbuilder1.append((char)(c1 - 65));
            continue; /* Loop/switch isn't completed */
        }
        if (d(c1))
        {
            k1 = 2;
            stringbuilder1.append('\034');
        } else
        {
            stringbuilder1.append('\035');
            stringbuilder1.append((char)p[c1]);
            continue; /* Loop/switch isn't completed */
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (d(c1))
        {
            stringbuilder1.append((char)o[c1]);
            continue; /* Loop/switch isn't completed */
        }
        if (b(c1))
        {
            stringbuilder1.append('\034');
            k1 = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (c(c1))
        {
            stringbuilder1.append('\033');
            k1 = 1;
            continue; /* Loop/switch isn't completed */
        }
        if (1 + (i1 + l1) < j1 && e(charsequence.charAt(1 + (i1 + l1))))
        {
            k1 = 3;
            stringbuilder1.append('\031');
            continue; /* Loop/switch isn't completed */
        }
        stringbuilder1.append('\035');
        stringbuilder1.append((char)p[c1]);
        if (true) goto _L8; else goto _L7
_L7:
        break; /* Loop/switch isn't completed */
_L6:
        stringbuilder1.append('\035');
        k1 = 0;
        if (true) goto _L10; else goto _L9
_L9:
        if (i2 % 2 != 0)
        {
            stringbuilder.append((char)(29 + k2 * 30));
        }
        return k1;
    }

    private static int a(CharSequence charsequence, byte abyte0[], int i1)
    {
        int j1 = charsequence.length();
        int k1 = i1;
        do
        {
            if (k1 >= j1)
            {
                break;
            }
            char c1 = charsequence.charAt(k1);
            int l1 = 0;
label0:
            do
            {
                int k2;
label1:
                {
                    if (l1 < 13 && a(c1))
                    {
                        l1++;
                        k2 = k1 + l1;
                        if (k2 < j1)
                        {
                            break label1;
                        }
                    }
                    if (l1 >= 13)
                    {
                        return k1 - i1;
                    }
                    break label0;
                }
                c1 = charsequence.charAt(k2);
            } while (true);
            char c2 = c1;
            int i2 = 0;
label2:
            do
            {
                int j2;
label3:
                {
                    if (i2 < 5 && f(c2))
                    {
                        i2++;
                        j2 = k1 + i2;
                        if (j2 < j1)
                        {
                            break label3;
                        }
                    }
                    if (i2 >= 5)
                    {
                        return k1 - i1;
                    }
                    break label2;
                }
                c2 = charsequence.charAt(j2);
            } while (true);
            char c3 = charsequence.charAt(k1);
            if (abyte0[k1] == 63 && c3 != '?')
            {
                throw new WriterException((new StringBuilder()).append("Non-encodable character detected: ").append(c3).append(" (Unicode: ").append(c3).append(')').toString());
            }
            k1++;
        } while (true);
        return k1 - i1;
    }

    static String a(String s, Compaction compaction)
    {
        StringBuilder stringbuilder;
        int i1;
        stringbuilder = new StringBuilder(s.length());
        i1 = s.length();
        if (compaction != Compaction.TEXT) goto _L2; else goto _L1
_L1:
        a(((CharSequence) (s)), 0, i1, stringbuilder, 0);
_L4:
        return stringbuilder.toString();
_L2:
        if (compaction == Compaction.BYTE)
        {
            byte abyte2[] = a(s);
            a(abyte2, 0, abyte2.length, 1, stringbuilder);
            continue;
        }
        if (compaction != Compaction.NUMERIC)
        {
            break;
        }
        stringbuilder.append('\u0386');
        a(s, 0, i1, stringbuilder);
        continue;
        while (false) 
        {
            abyte0 = null;
            j1 = 0;
            byte0 = 0;
            k1 = 0;
            while (k1 < i1) 
            {
                int l1 = a(((CharSequence) (s)), k1);
                byte abyte1[];
                int k2;
                int l2;
                if (l1 >= 13)
                {
                    stringbuilder.append('\u0386');
                    byte0 = 2;
                    a(s, k1, l1, stringbuilder);
                    int k3 = k1 + l1;
                    abyte1 = abyte0;
                    k2 = k3;
                    j1 = 0;
                } else
                {
                    int i2 = b(s, k1);
                    if (i2 >= 5 || l1 == i1)
                    {
                        if (byte0 != 0)
                        {
                            stringbuilder.append('\u0384');
                            j1 = 0;
                            byte0 = 0;
                        }
                        j1 = a(((CharSequence) (s)), k1, i2, stringbuilder, j1);
                        int j2 = k1 + i2;
                        abyte1 = abyte0;
                        k2 = j2;
                    } else
                    {
                        if (abyte0 == null)
                        {
                            abyte0 = a(s);
                        }
                        int i3 = a(((CharSequence) (s)), abyte0, k1);
                        if (i3 == 0)
                        {
                            i3 = 1;
                        }
                        int j3;
                        if (i3 == 1 && byte0 == 0)
                        {
                            a(abyte0, k1, 1, 0, stringbuilder);
                        } else
                        {
                            a(abyte0, k1, i3, byte0, stringbuilder);
                            byte0 = 1;
                            j1 = 0;
                        }
                        j3 = k1 + i3;
                        abyte1 = abyte0;
                        k2 = j3;
                    }
                }
                l2 = k2;
                abyte0 = abyte1;
                k1 = l2;
            }
        }
_L6:
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static void a(String s, int i1, int j1, StringBuilder stringbuilder)
    {
        StringBuilder stringbuilder1 = new StringBuilder(1 + j1 / 3);
        BigInteger biginteger = BigInteger.valueOf(900L);
        BigInteger biginteger1 = BigInteger.valueOf(0L);
        int l1;
        for (int k1 = 0; k1 < j1 - 1; k1 += l1)
        {
            stringbuilder1.setLength(0);
            l1 = Math.min(44, j1 - k1);
            BigInteger biginteger2 = new BigInteger((new StringBuilder()).append('1').append(s.substring(i1 + k1, l1 + (i1 + k1))).toString());
            do
            {
                stringbuilder1.append((char)biginteger2.mod(biginteger).intValue());
                biginteger2 = biginteger2.divide(biginteger);
            } while (!biginteger2.equals(biginteger1));
            for (int i2 = -1 + stringbuilder1.length(); i2 >= 0; i2--)
            {
                stringbuilder.append(stringbuilder1.charAt(i2));
            }

        }

    }

    private static void a(byte abyte0[], int i1, int j1, int k1, StringBuilder stringbuilder)
    {
        if (j1 == 1 && k1 == 0)
        {
            stringbuilder.append('\u0391');
        }
        int l1;
        if (j1 >= 6)
        {
            stringbuilder.append('\u039C');
            char ac[] = new char[5];
            for (l1 = i1; (i1 + j1) - l1 >= 6; l1 += 6)
            {
                long l2 = 0L;
                for (int i2 = 0; i2 < 6; i2++)
                {
                    l2 = (l2 << 8) + (long)(0xff & abyte0[l1 + i2]);
                }

                for (int j2 = 0; j2 < 5; j2++)
                {
                    ac[j2] = (char)(int)(l2 % 900L);
                    l2 /= 900L;
                }

                for (int k2 = -1 + ac.length; k2 >= 0; k2--)
                {
                    stringbuilder.append(ac[k2]);
                }

            }

        } else
        {
            l1 = i1;
        }
        if (l1 < i1 + j1)
        {
            stringbuilder.append('\u0385');
        }
        for (; l1 < i1 + j1; l1++)
        {
            stringbuilder.append((char)(0xff & abyte0[l1]));
        }

    }

    private static boolean a(char c1)
    {
        return c1 >= '0' && c1 <= '9';
    }

    private static byte[] a(String s)
    {
        return s.getBytes();
    }

    private static int b(CharSequence charsequence, int i1)
    {
        int j1 = charsequence.length();
        int k1 = i1;
        do
        {
label0:
            {
                if (k1 < j1)
                {
                    char c1 = charsequence.charAt(k1);
                    for (int l1 = 0; l1 < 13 && a(c1) && k1 < j1;)
                    {
                        l1++;
                        int i2 = k1 + 1;
                        if (i2 < j1)
                        {
                            c1 = charsequence.charAt(i2);
                            k1 = i2;
                        } else
                        {
                            k1 = i2;
                        }
                    }

                    if (l1 >= 13)
                    {
                        return k1 - i1 - l1;
                    }
                    if (l1 > 0)
                    {
                        continue;
                    }
                    if (f(charsequence.charAt(k1)))
                    {
                        break label0;
                    }
                }
                return k1 - i1;
            }
            k1++;
        } while (true);
    }

    private static boolean b(char c1)
    {
        return c1 == ' ' || c1 >= 'A' && c1 <= 'Z';
    }

    private static boolean c(char c1)
    {
        return c1 == ' ' || c1 >= 'a' && c1 <= 'z';
    }

    private static boolean d(char c1)
    {
        return o[c1] != -1;
    }

    private static boolean e(char c1)
    {
        return p[c1] != -1;
    }

    private static boolean f(char c1)
    {
        return c1 == '\t' || c1 == '\n' || c1 == '\r' || c1 >= ' ' && c1 <= '~';
    }

    static 
    {
        byte byte0 = 0;
        o = new byte[128];
        p = new byte[128];
        Arrays.fill(o, (byte)-1);
        for (byte byte1 = 0; byte1 < m.length; byte1++)
        {
            byte byte3 = m[byte1];
            if (byte3 > 0)
            {
                o[byte3] = byte1;
            }
        }

        Arrays.fill(p, (byte)-1);
        for (; byte0 < n.length; byte0++)
        {
            byte byte2 = n[byte0];
            if (byte2 > 0)
            {
                p[byte2] = byte0;
            }
        }

    }
}
