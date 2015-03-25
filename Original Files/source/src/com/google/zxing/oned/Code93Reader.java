// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader

public final class Code93Reader extends OneDReader
{

    private static final String a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final char b[] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    private static final int c[] = {
        276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 
        424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 
        282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 
        406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 
        366, 374, 430, 294, 474, 470, 306, 350
    };
    private static final int d = c[47];

    public Code93Reader()
    {
    }

    private static char a(int i)
    {
        for (int j = 0; j < c.length; j++)
        {
            if (c[j] == i)
            {
                return b[j];
            }
        }

        throw NotFoundException.getNotFoundInstance();
    }

    private static int a(int ai[])
    {
        int i = ai.length;
        int j = 0;
        int k;
        int k2;
        for (k = 0; j < i; k = k2)
        {
            k2 = k + ai[j];
            j++;
        }

        int l = 0;
        int i1 = 0;
        do
        {
label0:
            {
                if (l < i)
                {
                    int j1 = (9 * (ai[l] << 8)) / k;
                    int k1 = j1 >> 8;
                    int l1;
                    int i2;
                    int j2;
                    if ((j1 & 0xff) > 127)
                    {
                        l1 = k1 + 1;
                    } else
                    {
                        l1 = k1;
                    }
                    if (l1 >= 1 && l1 <= 4)
                    {
                        break label0;
                    }
                    i1 = -1;
                }
                return i1;
            }
            if ((l & 1) == 0)
            {
                for (i2 = 0; i2 < l1;)
                {
                    j2 = 1 | i1 << 1;
                    i2++;
                    i1 = j2;
                }

            } else
            {
                i1 <<= l1;
            }
            l++;
        } while (true);
    }

    private static String a(CharSequence charsequence)
    {
        int i;
        StringBuilder stringbuilder;
        int j;
        i = charsequence.length();
        stringbuilder = new StringBuilder(i);
        j = 0;
_L9:
        char c1;
        char c2;
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        c1 = charsequence.charAt(j);
        if (c1 < 'a' || c1 > 'd')
        {
            break MISSING_BLOCK_LABEL_266;
        }
        c2 = charsequence.charAt(j + 1);
        c1;
        JVM INSTR tableswitch 97 100: default 88
    //                   97 140
    //                   98 169
    //                   99 223
    //                   100 111;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        char c3 = '\0';
_L6:
        int k;
        stringbuilder.append(c3);
        k = j + 1;
_L7:
        j = k + 1;
        continue; /* Loop/switch isn't completed */
_L5:
        if (c2 >= 'A' && c2 <= 'Z')
        {
            c3 = (char)(c2 + 32);
        } else
        {
            throw FormatException.getFormatInstance();
        }
          goto _L6
_L2:
        if (c2 >= 'A' && c2 <= 'Z')
        {
            c3 = (char)(c2 - 64);
        } else
        {
            throw FormatException.getFormatInstance();
        }
          goto _L6
_L3:
        if (c2 >= 'A' && c2 <= 'E')
        {
            c3 = (char)(c2 - 38);
        } else
        if (c2 >= 'F' && c2 <= 'W')
        {
            c3 = (char)(c2 - 11);
        } else
        {
            throw FormatException.getFormatInstance();
        }
          goto _L6
_L4:
        if (c2 >= 'A' && c2 <= 'O')
        {
            c3 = (char)(c2 - 32);
        } else
        if (c2 == 'Z')
        {
            c3 = ':';
        } else
        {
            throw FormatException.getFormatInstance();
        }
          goto _L6
        stringbuilder.append(c1);
        k = j;
          goto _L7
        return stringbuilder.toString();
        if (true) goto _L9; else goto _L8
_L8:
    }

    private static void a(CharSequence charsequence, int i, int j)
    {
        int k = i - 1;
        int l = 1;
        int i1 = k;
        int j1;
        int k1;
        for (j1 = 0; i1 >= 0; j1 = k1)
        {
            k1 = j1 + l * "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charsequence.charAt(i1));
            int l1 = l + 1;
            if (l1 > j)
            {
                l1 = 1;
            }
            i1--;
            l = l1;
        }

        if (charsequence.charAt(i) != b[j1 % 47])
        {
            throw ChecksumException.getChecksumInstance();
        } else
        {
            return;
        }
    }

    private static int[] a(BitArray bitarray)
    {
        int i = bitarray.getSize();
        int j = bitarray.getNextSet(0);
        int ai[] = new int[6];
        int k = ai.length;
        int l = j;
        boolean flag = false;
        int i1 = 0;
        while (l < i) 
        {
            if (flag ^ bitarray.get(l))
            {
                ai[i1] = 1 + ai[i1];
            } else
            {
                if (i1 == k - 1)
                {
                    if (a(ai) == d)
                    {
                        return (new int[] {
                            j, l
                        });
                    }
                    j += ai[0] + ai[1];
                    System.arraycopy(ai, 2, ai, 0, k - 2);
                    ai[k - 2] = 0;
                    ai[k - 1] = 0;
                    i1--;
                } else
                {
                    i1++;
                }
                ai[i1] = 1;
                if (!flag)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            l++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static void b(CharSequence charsequence)
    {
        int i = charsequence.length();
        a(charsequence, i - 2, 20);
        a(charsequence, i - 1, 15);
    }

    public Result decodeRow(int i, BitArray bitarray, Map map)
    {
        int ai[] = a(bitarray);
        int j = bitarray.getNextSet(ai[1]);
        int k = bitarray.getSize();
        StringBuilder stringbuilder = new StringBuilder(20);
        int ai1[] = new int[6];
        do
        {
            recordPattern(bitarray, j, ai1);
            int l = a(ai1);
            if (l < 0)
            {
                throw NotFoundException.getNotFoundInstance();
            }
            char c1 = a(l);
            stringbuilder.append(c1);
            int i1 = ai1.length;
            int j1 = 0;
            int k1 = j;
            for (; j1 < i1; j1++)
            {
                k1 += ai1[j1];
            }

            int l1 = bitarray.getNextSet(k1);
            if (c1 == '*')
            {
                stringbuilder.deleteCharAt(-1 + stringbuilder.length());
                if (l1 == k || !bitarray.get(l1))
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (stringbuilder.length() < 2)
                {
                    throw NotFoundException.getNotFoundInstance();
                } else
                {
                    b(stringbuilder);
                    stringbuilder.setLength(-2 + stringbuilder.length());
                    String s = a(stringbuilder);
                    float f = (float)(ai[1] + ai[0]) / 2.0F;
                    float f1 = (float)(j + l1) / 2.0F;
                    ResultPoint aresultpoint[] = new ResultPoint[2];
                    aresultpoint[0] = new ResultPoint(f, i);
                    aresultpoint[1] = new ResultPoint(f1, i);
                    return new Result(s, null, aresultpoint, BarcodeFormat.CODE_93);
                }
            }
            j = l1;
        } while (true);
    }

}
