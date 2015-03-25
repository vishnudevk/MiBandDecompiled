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

public final class Code39Reader extends OneDReader
{

    static final String a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
    static final int b[] = {
        52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 
        265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 
        259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 
        385, 193, 448, 145, 400, 208, 133, 388, 196, 148, 
        168, 162, 138, 42
    };
    private static final char c[] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".toCharArray();
    private static final int d = b[39];
    private final boolean e;
    private final boolean f;

    public Code39Reader()
    {
        e = false;
        f = false;
    }

    public Code39Reader(boolean flag)
    {
        e = flag;
        f = false;
    }

    public Code39Reader(boolean flag, boolean flag1)
    {
        e = flag;
        f = flag1;
    }

    private static char a(int i)
    {
        for (int j = 0; j < b.length; j++)
        {
            if (b[j] == i)
            {
                return c[j];
            }
        }

        throw NotFoundException.getNotFoundInstance();
    }

    private static int a(int ai[])
    {
        int i = ai.length;
        int j = 0;
        do
        {
            int k = 0x7fffffff;
            for (int l = 0; l < i; l++)
            {
                int i3 = ai[l];
                if (i3 < k && i3 > j)
                {
                    k = i3;
                }
            }

            int i1 = 0;
            int j1 = 0;
            int k1 = 0;
            int l1 = 0;
            for (; i1 < i; i1++)
            {
                int l2 = ai[i1];
                if (ai[i1] > k)
                {
                    j1 |= 1 << i - 1 - i1;
                    l1++;
                    k1 += l2;
                }
            }

            if (l1 == 3)
            {
                int i2 = l1;
                int j2 = 0;
                do
                {
label0:
                    {
                        if (j2 < i && i2 > 0)
                        {
                            int k2 = ai[j2];
                            if (ai[j2] <= k)
                            {
                                break label0;
                            }
                            i2--;
                            if (k2 << 1 < k1)
                            {
                                break label0;
                            }
                            j1 = -1;
                        }
                        return j1;
                    }
                    j2++;
                } while (true);
            }
            if (l1 <= 3)
            {
                return -1;
            }
            j = k;
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
            break MISSING_BLOCK_LABEL_307;
        }
        c1 = charsequence.charAt(j);
        if (c1 != '+' && c1 != '$' && c1 != '%' && c1 != '/')
        {
            break MISSING_BLOCK_LABEL_294;
        }
        c2 = charsequence.charAt(j + 1);
        c1;
        JVM INSTR lookupswitch 4: default 116
    //                   36: 168
    //                   37: 197
    //                   43: 139
    //                   47: 251;
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
_L4:
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
_L5:
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

    private static int[] a(BitArray bitarray, int ai[])
    {
        int i = bitarray.getSize();
        int j = bitarray.getNextSet(0);
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
                    if (a(ai) == d && bitarray.isRange(Math.max(0, j - (l - j >> 1)), j, false))
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

    public Result decodeRow(int i, BitArray bitarray, Map map)
    {
        int ai[] = new int[9];
        int ai1[] = a(bitarray, ai);
        int j = bitarray.getNextSet(ai1[1]);
        int k = bitarray.getSize();
        StringBuilder stringbuilder = new StringBuilder(20);
        do
        {
            recordPattern(bitarray, j, ai);
            int l = a(ai);
            if (l < 0)
            {
                throw NotFoundException.getNotFoundInstance();
            }
            char c1 = a(l);
            stringbuilder.append(c1);
            int i1 = ai.length;
            int j1 = 0;
            int k1 = j;
            for (; j1 < i1; j1++)
            {
                k1 += ai[j1];
            }

            int l1 = bitarray.getNextSet(k1);
            if (c1 == '*')
            {
                stringbuilder.setLength(-1 + stringbuilder.length());
                int i2 = 0;
                int j2 = ai.length;
                for (int k2 = 0; k2 < j2; k2++)
                {
                    i2 += ai[k2];
                }

                int l2 = l1 - j - i2;
                if (l1 != k && l2 >> 1 < i2)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (e)
                {
                    int i3 = -1 + stringbuilder.length();
                    int j3 = 0;
                    for (int k3 = 0; k3 < i3; k3++)
                    {
                        j3 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(stringbuilder.charAt(k3));
                    }

                    if (stringbuilder.charAt(i3) != c[j3 % 43])
                    {
                        throw ChecksumException.getChecksumInstance();
                    }
                    stringbuilder.setLength(i3);
                }
                if (stringbuilder.length() == 0)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                String s;
                float f1;
                float f2;
                ResultPoint aresultpoint[];
                if (f)
                {
                    s = a(stringbuilder);
                } else
                {
                    s = stringbuilder.toString();
                }
                f1 = (float)(ai1[1] + ai1[0]) / 2.0F;
                f2 = (float)(j + l1) / 2.0F;
                aresultpoint = new ResultPoint[2];
                aresultpoint[0] = new ResultPoint(f1, i);
                aresultpoint[1] = new ResultPoint(f2, i);
                return new Result(s, null, aresultpoint, BarcodeFormat.CODE_39);
            }
            j = l1;
        } while (true);
    }

}
