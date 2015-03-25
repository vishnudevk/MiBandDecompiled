// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.util.Map;

public final class StringUtils
{

    public static final String GB2312 = "GB2312";
    public static final String SHIFT_JIS = "SJIS";
    private static final String a = System.getProperty("file.encoding");
    private static final String b = "EUC_JP";
    private static final String c = "UTF8";
    private static final String d = "ISO8859_1";
    private static final boolean e;

    private StringUtils()
    {
    }

    public static String guessEncoding(byte abyte0[], Map map)
    {
        int i;
        int j;
        int k;
        boolean flag;
        boolean flag1;
        int l;
        boolean flag2;
        int i1;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        if (map != null)
        {
            String s = (String)map.get(DecodeHintType.CHARACTER_SET);
            if (s != null)
            {
                return s;
            }
        }
        if (abyte0.length > 3 && abyte0[0] == -17 && abyte0[1] == -69 && abyte0[2] == -65)
        {
            return "UTF8";
        }
        i = abyte0.length;
        j = 0;
        k = 0;
        flag = false;
        flag1 = false;
        l = 0;
        flag2 = false;
        i1 = 0;
        flag3 = true;
        flag4 = true;
        flag5 = true;
_L3:
        int j1;
        if (l >= i || !flag5 && !flag4 && !flag3)
        {
            break MISSING_BLOCK_LABEL_519;
        }
        j1 = 0xff & abyte0[l];
        if (j1 < 128 || j1 > 191) goto _L2; else goto _L1
_L1:
        boolean flag6;
        boolean flag7;
        int i2;
        boolean flag8;
        if (j > 0)
        {
            j--;
            flag6 = flag3;
        } else
        {
            flag6 = flag3;
        }
        if ((j1 == 194 || j1 == 195) && l < i - 1)
        {
            int k2 = 0xff & abyte0[l + 1];
            if (k2 <= 191 && (j1 == 194 && k2 >= 160 || j1 == 195 && k2 >= 128))
            {
                flag = true;
            }
        }
        if (j1 >= 127 && j1 <= 159)
        {
            flag5 = false;
        }
        if (j1 >= 161 && j1 <= 223 && !flag2)
        {
            k++;
        }
        if (!flag2 && (j1 >= 240 && j1 <= 255 || j1 == 128 || j1 == 160))
        {
            flag7 = false;
        } else
        {
            flag7 = flag4;
        }
        if (j1 >= 129 && j1 <= 159 || j1 >= 224 && j1 <= 239)
        {
            if (flag2)
            {
                flag4 = flag7;
                i2 = i1;
                flag8 = false;
            } else
            if (l >= -1 + abyte0.length)
            {
                i2 = i1;
                flag8 = true;
                flag4 = false;
            } else
            {
                int j2 = 0xff & abyte0[l + 1];
                if (j2 < 64 || j2 > 252)
                {
                    flag7 = false;
                } else
                {
                    i1++;
                }
                flag4 = flag7;
                i2 = i1;
                flag8 = true;
            }
        } else
        {
            flag4 = flag7;
            i2 = i1;
            flag8 = false;
        }
        l++;
        flag2 = flag8;
        i1 = i2;
        flag3 = flag6;
        if (true) goto _L3; else goto _L2
_L2:
        int k1;
        if (j > 0)
        {
            flag6 = false;
        } else
        {
            flag6 = flag3;
        }
        if (j1 >= 192 && j1 <= 253)
        {
            k1 = j;
            for (int l1 = j1; (l1 & 0x40) != 0;)
            {
                int l2 = k1 + 1;
                l1 <<= 1;
                k1 = l2;
            }

            break MISSING_BLOCK_LABEL_600;
        } else
        {
            break MISSING_BLOCK_LABEL_149;
        }
        if (j > 0)
        {
            flag3 = false;
        }
        if (flag4 && e)
        {
            return "SJIS";
        }
        if (flag3 && flag1)
        {
            return "UTF8";
        }
        if (flag4 && (i1 >= 3 || k * 20 > i))
        {
            return "SJIS";
        }
        if (!flag && flag5)
        {
            return "ISO8859_1";
        } else
        {
            return a;
        }
        j = k1;
        flag1 = true;
        break MISSING_BLOCK_LABEL_149;
    }

    static 
    {
        boolean flag;
        if ("SJIS".equalsIgnoreCase(a) || "EUC_JP".equalsIgnoreCase(a))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
    }
}
