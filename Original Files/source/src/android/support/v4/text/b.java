// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.text;


class b
{

    private static final int a = 1792;
    private static final byte b[];
    private final String c;
    private final boolean d;
    private final int e;
    private int f;
    private char g;

    b(String s, boolean flag)
    {
        c = s;
        d = flag;
        e = s.length();
    }

    private static byte a(char c1)
    {
        if (c1 < '\u0700')
        {
            return b[c1];
        } else
        {
            return Character.getDirectionality(c1);
        }
    }

    private byte e()
    {
        int i = f;
        while (f < e) 
        {
            String s = c;
            int j = f;
            f = j + 1;
            g = s.charAt(j);
            if (g == '>')
            {
                return 12;
            }
            if (g != '"' && g != '\'')
            {
                break;
            }
            char c1 = g;
            char c2;
            do
            {
                if (f >= e)
                {
                    break;
                }
                String s1 = c;
                int k = f;
                f = k + 1;
                c2 = s1.charAt(k);
                g = c2;
            } while (c2 != c1);
        }
        f = i;
        g = '<';
        return 13;
    }

    private byte f()
    {
        int i = f;
        do
        {
            do
            {
                if (f > 0)
                {
                    String s = c;
                    int j = -1 + f;
                    f = j;
                    g = s.charAt(j);
                    if (g == '<')
                    {
                        return 12;
                    }
                    if (g != '>')
                    {
                        continue;
                    }
                }
                f = i;
                g = '>';
                return 13;
            } while (g != '"' && g != '\'');
            char c1 = g;
            char c2;
            do
            {
                if (f <= 0)
                {
                    break;
                }
                String s1 = c;
                int k = -1 + f;
                f = k;
                c2 = s1.charAt(k);
                g = c2;
            } while (c2 != c1);
        } while (true);
    }

    private byte g()
    {
        char c1;
        do
        {
            if (f >= e)
            {
                break;
            }
            String s = c;
            int i = f;
            f = i + 1;
            c1 = s.charAt(i);
            g = c1;
        } while (c1 != ';');
        return 12;
    }

    private byte h()
    {
        int i = f;
        do
        {
            if (f <= 0)
            {
                break;
            }
            String s = c;
            int j = -1 + f;
            f = j;
            g = s.charAt(j);
            if (g == '&')
            {
                return 12;
            }
        } while (g != ';');
        f = i;
        g = ';';
        return 13;
    }

    int a()
    {
        int i;
        byte byte0;
        int j;
        f = 0;
        i = 0;
        byte0 = 0;
        j = 0;
_L6:
        if (f >= e || i != 0) goto _L2; else goto _L1
_L1:
        c();
        JVM INSTR tableswitch 0 18: default 120
    //                   0 149
    //                   1 160
    //                   2 160
    //                   3 120
    //                   4 120
    //                   5 120
    //                   6 120
    //                   7 120
    //                   8 120
    //                   9 11
    //                   10 120
    //                   11 120
    //                   12 120
    //                   13 120
    //                   14 125
    //                   15 125
    //                   16 133
    //                   17 133
    //                   18 141;
           goto _L3 _L4 _L5 _L5 _L3 _L3 _L3 _L3 _L3 _L3 _L6 _L3 _L3 _L3 _L3 _L7 _L7 _L8 _L8 _L9
_L3:
        i = j;
          goto _L6
_L7:
        j++;
        byte0 = -1;
          goto _L6
_L8:
        j++;
        byte0 = 1;
          goto _L6
_L9:
        j--;
        byte0 = 0;
          goto _L6
_L4:
        if (j != 0) goto _L11; else goto _L10
_L10:
        return -1;
_L11:
        i = j;
          goto _L6
_L5:
        if (j == 0)
        {
            return 1;
        }
        i = j;
          goto _L6
_L2:
        if (i == 0)
        {
            return 0;
        }
        if (byte0 != 0)
        {
            return byte0;
        }
_L14:
        if (f <= 0) goto _L13; else goto _L12
_L12:
        d();
        JVM INSTR tableswitch 14 18: default 228
    //                   14 231
    //                   15 231
    //                   16 242
    //                   17 242
    //                   18 255;
           goto _L14 _L15 _L15 _L16 _L16 _L17
_L15:
        if (i == j) goto _L10; else goto _L18
_L18:
        j--;
          goto _L14
_L16:
        if (i == j)
        {
            return 1;
        }
        j--;
          goto _L14
_L17:
        j++;
          goto _L14
_L13:
        return 0;
    }

    int b()
    {
        f = e;
        int i = 0;
        int j = 0;
        do
        {
label0:
            {
label1:
                {
label2:
                    {
label3:
                        {
label4:
                            {
                                int k = f;
                                byte byte0 = 0;
                                if (k > 0)
                                {
                                    switch (d())
                                    {
                                    case 3: // '\003'
                                    case 4: // '\004'
                                    case 5: // '\005'
                                    case 6: // '\006'
                                    case 7: // '\007'
                                    case 8: // '\b'
                                    case 10: // '\n'
                                    case 11: // '\013'
                                    case 12: // '\f'
                                    case 13: // '\r'
                                    default:
                                        if (i == 0)
                                        {
                                            i = j;
                                        }
                                        continue;

                                    case 1: // '\001'
                                    case 2: // '\002'
                                        break label2;

                                    case 9: // '\t'
                                        continue;

                                    case 14: // '\016'
                                    case 15: // '\017'
                                        break label3;

                                    case 16: // '\020'
                                    case 17: // '\021'
                                        break label1;

                                    case 18: // '\022'
                                        break label0;

                                    case 0: // '\0'
                                        break;
                                    }
                                    if (j != 0)
                                    {
                                        break label4;
                                    }
                                    byte0 = -1;
                                }
                                return byte0;
                            }
                            if (i == 0)
                            {
                                i = j;
                            }
                            continue;
                        }
                        if (i == j)
                        {
                            return -1;
                        }
                        j--;
                        continue;
                    }
                    if (j == 0)
                    {
                        return 1;
                    }
                    if (i == 0)
                    {
                        i = j;
                    }
                    continue;
                }
                if (i == j)
                {
                    return 1;
                }
                j--;
                continue;
            }
            j++;
        } while (true);
    }

    byte c()
    {
        g = c.charAt(f);
        byte byte0;
        if (Character.isHighSurrogate(g))
        {
            int i = Character.codePointAt(c, f);
            f = f + Character.charCount(i);
            byte0 = Character.getDirectionality(i);
        } else
        {
            f = 1 + f;
            byte0 = a(g);
            if (d)
            {
                if (g == '<')
                {
                    return e();
                }
                if (g == '&')
                {
                    return g();
                }
            }
        }
        return byte0;
    }

    byte d()
    {
        g = c.charAt(-1 + f);
        byte byte0;
        if (Character.isLowSurrogate(g))
        {
            int i = Character.codePointBefore(c, f);
            f = f - Character.charCount(i);
            byte0 = Character.getDirectionality(i);
        } else
        {
            f = -1 + f;
            byte0 = a(g);
            if (d)
            {
                if (g == '>')
                {
                    return f();
                }
                if (g == ';')
                {
                    return h();
                }
            }
        }
        return byte0;
    }

    static 
    {
        b = new byte[1792];
        for (int i = 0; i < 1792; i++)
        {
            b[i] = Character.getDirectionality(i);
        }

    }
}
