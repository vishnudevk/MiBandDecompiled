// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Referenced classes of package com.google.zxing.datamatrix.decoder:
//            e, d

final class c
{

    private static final char a[] = {
        '*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', 
        '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 
        'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    private static final char b[] = {
        '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', 
        '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', 
        '?', '@', '[', '\\', ']', '^', '_'
    };
    private static final char c[] = {
        '*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', 
        '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 
        'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 
        'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    private static final char d[] = {
        '\'', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 
        'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 
        'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', 
        '~', '\177'
    };

    private c()
    {
    }

    private static int a(int i, int j)
    {
        int k = i - (1 + (j * 149) % 255);
        if (k >= 0)
        {
            return k;
        } else
        {
            return k + 256;
        }
    }

    static DecoderResult a(byte abyte0[])
    {
        BitSource bitsource;
        StringBuilder stringbuilder;
        StringBuilder stringbuilder1;
        ArrayList arraylist;
        e e1;
        bitsource = new BitSource(abyte0);
        stringbuilder = new StringBuilder(100);
        stringbuilder1 = new StringBuilder(0);
        arraylist = new ArrayList(1);
        e1 = e.b;
_L3:
        if (e1 != e.b) goto _L2; else goto _L1
_L1:
        e1 = a(bitsource, stringbuilder, stringbuilder1);
_L10:
        if (e1 == e.a || bitsource.available() <= 0)
        {
            if (stringbuilder1.length() > 0)
            {
                stringbuilder.append(stringbuilder1.toString());
            }
            String s = stringbuilder.toString();
            Object obj;
            if (arraylist.isEmpty())
            {
                obj = null;
            } else
            {
                obj = arraylist;
            }
            return new DecoderResult(abyte0, s, ((List) (obj)), null);
        }
        if (true) goto _L3; else goto _L2
_L2:
        d.a[e1.ordinal()];
        JVM INSTR tableswitch 1 5: default 168
    //                   1 172
    //                   2 185
    //                   3 193
    //                   4 201
    //                   5 209;
           goto _L4 _L5 _L6 _L7 _L8 _L9
_L9:
        break MISSING_BLOCK_LABEL_209;
_L4:
        throw FormatException.getFormatInstance();
_L5:
        a(bitsource, stringbuilder);
_L11:
        e1 = e.b;
          goto _L10
_L6:
        b(bitsource, stringbuilder);
          goto _L11
_L7:
        c(bitsource, stringbuilder);
          goto _L11
_L8:
        d(bitsource, stringbuilder);
          goto _L11
        a(bitsource, stringbuilder, ((Collection) (arraylist)));
          goto _L11
    }

    private static e a(BitSource bitsource, StringBuilder stringbuilder, StringBuilder stringbuilder1)
    {
        boolean flag = false;
        do
        {
            int i = bitsource.readBits(8);
            if (i == 0)
            {
                throw FormatException.getFormatInstance();
            }
            if (i <= 128)
            {
                int j;
                int k;
                if (flag)
                {
                    k = i + 128;
                } else
                {
                    k = i;
                }
                stringbuilder.append((char)(k - 1));
                return e.b;
            }
            if (i == 129)
            {
                return e.a;
            }
            if (i <= 229)
            {
                j = i - 130;
                if (j < 10)
                {
                    stringbuilder.append('0');
                }
                stringbuilder.append(j);
            } else
            {
                if (i == 230)
                {
                    return e.c;
                }
                if (i == 231)
                {
                    return e.g;
                }
                if (i == 232)
                {
                    stringbuilder.append('\035');
                } else
                if (i != 233 && i != 234)
                {
                    if (i == 235)
                    {
                        flag = true;
                    } else
                    if (i == 236)
                    {
                        stringbuilder.append("[)>\03605\035");
                        stringbuilder1.insert(0, "\036\004");
                    } else
                    if (i == 237)
                    {
                        stringbuilder.append("[)>\03606\035");
                        stringbuilder1.insert(0, "\036\004");
                    } else
                    {
                        if (i == 238)
                        {
                            return e.e;
                        }
                        if (i == 239)
                        {
                            return e.d;
                        }
                        if (i == 240)
                        {
                            return e.f;
                        }
                        if (i != 241 && i >= 242 && (i != 254 || bitsource.available() != 0))
                        {
                            throw FormatException.getFormatInstance();
                        }
                    }
                }
            }
            if (bitsource.available() <= 0)
            {
                return e.b;
            }
        } while (true);
    }

    private static void a(int i, int j, int ai[])
    {
        int k = -1 + (j + (i << 8));
        int l = k / 1600;
        ai[0] = l;
        int i1 = k - l * 1600;
        int j1 = i1 / 40;
        ai[1] = j1;
        ai[2] = i1 - j1 * 40;
    }

    private static void a(BitSource bitsource, StringBuilder stringbuilder)
    {
        int ai[];
        int i;
        boolean flag;
        ai = new int[3];
        i = 0;
        flag = false;
_L13:
        if (bitsource.available() != 8) goto _L2; else goto _L1
_L1:
        int j;
        return;
_L2:
        if ((j = bitsource.readBits(8)) == 254) goto _L1; else goto _L3
_L3:
        int k;
        a(j, bitsource.readBits(8), ai);
        k = 0;
_L10:
        int l;
        if (k >= 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        l = ai[k];
        i;
        JVM INSTR tableswitch 0 3: default 92
    //                   0 96
    //                   1 167
    //                   2 203
    //                   3 289;
           goto _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_289;
_L6:
        break; /* Loop/switch isn't completed */
_L4:
        throw FormatException.getFormatInstance();
_L5:
        if (l < 3)
        {
            i = l + 1;
        } else
        if (l < a.length)
        {
            char c2 = a[l];
            if (flag)
            {
                stringbuilder.append((char)(c2 + 128));
                flag = false;
            } else
            {
                stringbuilder.append(c2);
            }
        } else
        {
            throw FormatException.getFormatInstance();
        }
_L11:
        k++;
        if (true) goto _L10; else goto _L9
_L9:
        if (flag)
        {
            stringbuilder.append((char)(l + 128));
            flag = false;
        } else
        {
            stringbuilder.append((char)l);
        }
        i = 0;
          goto _L11
_L7:
        if (l < b.length)
        {
            char c1 = b[l];
            if (flag)
            {
                stringbuilder.append((char)(c1 + 128));
                flag = false;
            } else
            {
                stringbuilder.append(c1);
            }
        } else
        if (l == 27)
        {
            stringbuilder.append('\035');
        } else
        if (l == 30)
        {
            flag = true;
        } else
        {
            throw FormatException.getFormatInstance();
        }
        i = 0;
          goto _L11
        if (flag)
        {
            stringbuilder.append((char)(l + 224));
            flag = false;
        } else
        {
            stringbuilder.append((char)(l + 96));
        }
        i = 0;
          goto _L11
        if (bitsource.available() > 0) goto _L13; else goto _L12
_L12:
    }

    private static void a(BitSource bitsource, StringBuilder stringbuilder, Collection collection)
    {
        int i = 1 + bitsource.getByteOffset();
        int j = bitsource.readBits(8);
        int k = i + 1;
        int l = a(j, i);
        int l1;
        if (l == 0)
        {
            l1 = bitsource.available() / 8;
        } else
        if (l < 250)
        {
            l1 = l;
        } else
        {
            int i1 = 250 * (l - 249);
            int j1 = bitsource.readBits(8);
            int k1 = k + 1;
            l1 = i1 + a(j1, k);
            k = k1;
        }
        if (l1 < 0)
        {
            throw FormatException.getFormatInstance();
        }
        byte abyte0[] = new byte[l1];
        for (int i2 = 0; i2 < l1;)
        {
            if (bitsource.available() < 8)
            {
                throw FormatException.getFormatInstance();
            }
            int j2 = bitsource.readBits(8);
            int k2 = k + 1;
            abyte0[i2] = (byte)a(j2, k);
            i2++;
            k = k2;
        }

        collection.add(abyte0);
        try
        {
            stringbuilder.append(new String(abyte0, "ISO8859_1"));
            return;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new IllegalStateException((new StringBuilder()).append("Platform does not support required encoding: ").append(unsupportedencodingexception).toString());
        }
    }

    private static void b(BitSource bitsource, StringBuilder stringbuilder)
    {
        int ai[];
        int i;
        boolean flag;
        ai = new int[3];
        i = 0;
        flag = false;
_L13:
        if (bitsource.available() != 8) goto _L2; else goto _L1
_L1:
        int j;
        return;
_L2:
        if ((j = bitsource.readBits(8)) == 254) goto _L1; else goto _L3
_L3:
        int k;
        a(j, bitsource.readBits(8), ai);
        k = 0;
_L10:
        int l;
        if (k >= 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        l = ai[k];
        i;
        JVM INSTR tableswitch 0 3: default 92
    //                   0 96
    //                   1 167
    //                   2 203
    //                   3 289;
           goto _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_289;
_L6:
        break; /* Loop/switch isn't completed */
_L4:
        throw FormatException.getFormatInstance();
_L5:
        if (l < 3)
        {
            i = l + 1;
        } else
        if (l < c.length)
        {
            char c3 = c[l];
            if (flag)
            {
                stringbuilder.append((char)(c3 + 128));
                flag = false;
            } else
            {
                stringbuilder.append(c3);
            }
        } else
        {
            throw FormatException.getFormatInstance();
        }
_L11:
        k++;
        if (true) goto _L10; else goto _L9
_L9:
        if (flag)
        {
            stringbuilder.append((char)(l + 128));
            flag = false;
        } else
        {
            stringbuilder.append((char)l);
        }
        i = 0;
          goto _L11
_L7:
        if (l < b.length)
        {
            char c2 = b[l];
            if (flag)
            {
                stringbuilder.append((char)(c2 + 128));
                flag = false;
            } else
            {
                stringbuilder.append(c2);
            }
        } else
        if (l == 27)
        {
            stringbuilder.append('\035');
        } else
        if (l == 30)
        {
            flag = true;
        } else
        {
            throw FormatException.getFormatInstance();
        }
        i = 0;
          goto _L11
        if (l < d.length)
        {
            char c1 = d[l];
            if (flag)
            {
                stringbuilder.append((char)(c1 + 128));
                flag = false;
            } else
            {
                stringbuilder.append(c1);
            }
            i = 0;
        } else
        {
            throw FormatException.getFormatInstance();
        }
          goto _L11
        if (bitsource.available() > 0) goto _L13; else goto _L12
_L12:
    }

    private static void c(BitSource bitsource, StringBuilder stringbuilder)
    {
        int ai[] = new int[3];
_L5:
        if (bitsource.available() != 8) goto _L2; else goto _L1
_L1:
        int i;
        return;
_L2:
        if ((i = bitsource.readBits(8)) == 254) goto _L1; else goto _L3
_L3:
        a(i, bitsource.readBits(8), ai);
        int j = 0;
        while (j < 3) 
        {
            int k = ai[j];
            if (k == 0)
            {
                stringbuilder.append('\r');
            } else
            if (k == 1)
            {
                stringbuilder.append('*');
            } else
            if (k == 2)
            {
                stringbuilder.append('>');
            } else
            if (k == 3)
            {
                stringbuilder.append(' ');
            } else
            if (k < 14)
            {
                stringbuilder.append((char)(k + 44));
            } else
            if (k < 40)
            {
                stringbuilder.append((char)(k + 51));
            } else
            {
                throw FormatException.getFormatInstance();
            }
            j++;
        }
        if (bitsource.available() <= 0)
        {
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static void d(BitSource bitsource, StringBuilder stringbuilder)
    {
        boolean flag = false;
        do
        {
            if (bitsource.available() <= 16)
            {
                return;
            }
            int i = 0;
            while (i < 4) 
            {
                int j = bitsource.readBits(6);
                boolean flag1;
                if (j == 31)
                {
                    flag1 = true;
                } else
                {
                    flag1 = flag;
                }
                if (!flag1)
                {
                    int k;
                    if ((j & 0x20) == 0)
                    {
                        k = j | 0x40;
                    } else
                    {
                        k = j;
                    }
                    stringbuilder.append((char)k);
                }
                i++;
                flag = flag1;
            }
        } while (!flag && bitsource.available() > 0);
    }

}
