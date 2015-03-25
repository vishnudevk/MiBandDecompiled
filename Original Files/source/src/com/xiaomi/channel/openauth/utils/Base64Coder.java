// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.openauth.utils;


public class Base64Coder
{

    private static final String a;
    private static char b[];
    private static byte c[];

    private Base64Coder()
    {
    }

    public static byte[] decode(String s)
    {
        return decode(s.toCharArray());
    }

    public static byte[] decode(char ac[])
    {
        return decode(ac, 0, ac.length);
    }

    public static byte[] decode(char ac[], int i, int j)
    {
        if (j % 4 != 0)
        {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        for (; j > 0 && ac[-1 + (i + j)] == '='; j--) { }
        int k = (j * 3) / 4;
        byte abyte0[] = new byte[k];
        int l = i + j;
        int i1 = 0;
        int j1 = i;
        do
        {
            if (j1 >= l)
            {
                return abyte0;
            }
            int k1 = j1 + 1;
            char c1 = ac[j1];
            int l1 = k1 + 1;
            char c2 = ac[k1];
            char c3;
            char c4;
            if (l1 < l)
            {
                int l3 = l1 + 1;
                c3 = ac[l1];
                l1 = l3;
            } else
            {
                c3 = 'A';
            }
            if (l1 < l)
            {
                int k3 = l1 + 1;
                c4 = ac[l1];
                j1 = k3;
            } else
            {
                j1 = l1;
                c4 = 'A';
            }
            if (c1 > '\177' || c2 > '\177' || c3 > '\177' || c4 > '\177')
            {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte byte0 = c[c1];
            byte byte1 = c[c2];
            byte byte2 = c[c3];
            byte byte3 = c[c4];
            if (byte0 < 0 || byte1 < 0 || byte2 < 0 || byte3 < 0)
            {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            int i2 = byte0 << 2 | byte1 >>> 4;
            int j2 = (byte1 & 0xf) << 4 | byte2 >>> 2;
            int k2 = byte3 | (byte2 & 3) << 6;
            int l2 = i1 + 1;
            abyte0[i1] = (byte)i2;
            int i3;
            if (l2 < k)
            {
                i3 = l2 + 1;
                abyte0[l2] = (byte)j2;
            } else
            {
                i3 = l2;
            }
            if (i3 < k)
            {
                int j3 = i3 + 1;
                abyte0[i3] = (byte)k2;
                i1 = j3;
            } else
            {
                i1 = i3;
            }
        } while (true);
    }

    public static byte[] decodeLines(String s)
    {
        char ac[] = new char[s.length()];
        int i = 0;
        int j = 0;
        do
        {
            if (i >= s.length())
            {
                return decode(ac, 0, j);
            }
            char c1 = s.charAt(i);
            if (c1 != ' ' && c1 != '\r' && c1 != '\n' && c1 != '\t')
            {
                int k = j + 1;
                ac[j] = c1;
                j = k;
            }
            i++;
        } while (true);
    }

    public static String decodeString(String s)
    {
        return new String(decode(s));
    }

    public static char[] encode(byte abyte0[])
    {
        return encode(abyte0, 0, abyte0.length);
    }

    public static char[] encode(byte abyte0[], int i)
    {
        return encode(abyte0, 0, i);
    }

    public static char[] encode(byte abyte0[], int i, int j)
    {
        int k = (2 + j * 4) / 3;
        char ac[] = new char[4 * ((j + 2) / 3)];
        int l = i + j;
        int i1 = 0;
        do
        {
            if (i >= l)
            {
                return ac;
            }
            int j1 = i + 1;
            int k1 = 0xff & abyte0[i];
            int l1;
            int i2;
            int j2;
            int k2;
            int l2;
            int i3;
            int j3;
            int k3;
            int l3;
            char c1;
            int i4;
            char c2;
            if (j1 < l)
            {
                int j4 = j1 + 1;
                l1 = 0xff & abyte0[j1];
                j1 = j4;
            } else
            {
                l1 = 0;
            }
            if (j1 < l)
            {
                i2 = j1 + 1;
                j2 = 0xff & abyte0[j1];
            } else
            {
                i2 = j1;
                j2 = 0;
            }
            k2 = k1 >>> 2;
            l2 = (k1 & 3) << 4 | l1 >>> 4;
            i3 = (l1 & 0xf) << 2 | j2 >>> 6;
            j3 = j2 & 0x3f;
            k3 = i1 + 1;
            ac[i1] = b[k2];
            l3 = k3 + 1;
            ac[k3] = b[l2];
            if (l3 < k)
            {
                c1 = b[i3];
            } else
            {
                c1 = '=';
            }
            ac[l3] = c1;
            i4 = l3 + 1;
            if (i4 < k)
            {
                c2 = b[j3];
            } else
            {
                c2 = '=';
            }
            ac[i4] = c2;
            i1 = i4 + 1;
            i = i2;
        } while (true);
    }

    public static String encodeLines(byte abyte0[])
    {
        return encodeLines(abyte0, 0, abyte0.length, 76, a);
    }

    public static String encodeLines(byte abyte0[], int i, int j, int k, String s)
    {
        int l = (k * 3) / 4;
        if (l <= 0)
        {
            throw new IllegalArgumentException();
        }
        int i1 = (-1 + (j + l)) / l;
        StringBuilder stringbuilder = new StringBuilder(4 * ((j + 2) / 3) + i1 * s.length());
        int j1 = 0;
        do
        {
            if (j1 >= j)
            {
                return stringbuilder.toString();
            }
            int k1 = Math.min(j - j1, l);
            stringbuilder.append(encode(abyte0, i + j1, k1));
            stringbuilder.append(s);
            j1 += k1;
        } while (true);
    }

    public static String encodeString(String s)
    {
        return new String(encode(s.getBytes()));
    }

    static 
    {
        char c1;
        int i;
        a = System.getProperty("line.separator");
        b = new char[64];
        c1 = 'A';
        i = 0;
_L9:
        if (c1 <= 'Z') goto _L2; else goto _L1
_L1:
        char c2 = 'a';
_L10:
        if (c2 <= 'z') goto _L4; else goto _L3
_L3:
        char c3 = '0';
_L11:
        if (c3 <= '9') goto _L6; else goto _L5
_L5:
        int j1;
        char ac3[] = b;
        int i1 = i + 1;
        ac3[i] = '+';
        char ac4[] = b;
        i1 + 1;
        ac4[i1] = '/';
        c = new byte[128];
        j1 = 0;
_L12:
        int k1;
        int l1;
        k1 = c.length;
        l1 = 0;
        if (j1 < k1) goto _L8; else goto _L7
_L7:
        if (l1 >= 64)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_209;
_L2:
        char ac[] = b;
        int j = i + 1;
        ac[i] = c1;
        c1++;
        i = j;
          goto _L9
_L4:
        char ac1[] = b;
        int k = i + 1;
        ac1[i] = c2;
        c2++;
        i = k;
          goto _L10
_L6:
        char ac2[] = b;
        int l = i + 1;
        ac2[i] = c3;
        c3++;
        i = l;
          goto _L11
_L8:
        c[j1] = -1;
        j1++;
          goto _L12
        c[b[l1]] = (byte)l1;
        l1++;
          goto _L7
    }
}
