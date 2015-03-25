// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader

public final class CodaBarReader extends OneDReader
{

    static final char a[] = "0123456789-$:/.+ABCDTN".toCharArray();
    static final int b[] = {
        3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 
        12, 24, 69, 81, 84, 21, 26, 41, 11, 14, 
        26, 41
    };
    private static final String c = "0123456789-$:/.+ABCDTN";
    private static final int d = 6;
    private static final char e[] = {
        'E', '*', 'A', 'B', 'C', 'D', 'T', 'N'
    };

    public CodaBarReader()
    {
    }

    private static char a(int ai[])
    {
        int i = ai.length;
        int j = 0x7fffffff;
        int k = 0;
        int l = 0;
        for (; k < i; k++)
        {
            if (ai[k] < j)
            {
                j = ai[k];
            }
            if (ai[k] > l)
            {
                l = ai[k];
            }
        }

        do
        {
            int i1 = 0;
            int j1 = 0;
            int k1 = 0;
            for (; i1 < i; i1++)
            {
                if (ai[i1] > l)
                {
                    j1 |= 1 << i - 1 - i1;
                    k1++;
                }
            }

            if (k1 == 2 || k1 == 3)
            {
                for (int l1 = 0; l1 < b.length; l1++)
                {
                    if (b[l1] == j1)
                    {
                        return a[l1];
                    }
                }

            }
        } while (--l > j);
        return '!';
    }

    static boolean a(char ac[], char c1)
    {
        boolean flag = false;
        if (ac == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = ac.length;
        j = 0;
_L7:
        flag = false;
        if (j >= i) goto _L2; else goto _L3
_L3:
        if (ac[j] != c1) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        j++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static int[] a(BitArray bitarray)
    {
        int i;
        int j;
        int ai[];
        int k;
        int l;
        boolean flag;
        int i1;
        i = bitarray.getSize();
        j = bitarray.getNextSet(0);
        ai = new int[7];
        k = ai.length;
        l = j;
        flag = false;
        i1 = 0;
_L2:
        int k1;
        int l1;
        boolean flag2;
        if (l >= i)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        if (!(flag ^ bitarray.get(l)))
        {
            break; /* Loop/switch isn't completed */
        }
        ai[i1] = 1 + ai[i1];
        boolean flag4 = flag;
        k1 = i1;
        l1 = j;
        flag2 = flag4;
_L3:
        l++;
        boolean flag3 = flag2;
        j = l1;
        i1 = k1;
        flag = flag3;
        if (true) goto _L2; else goto _L1
_L1:
        if (i1 != k - 1)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        int ai1[];
        if (!a(e, a(ai)) || !bitarray.isRange(Math.max(0, j - (l - j) / 2), j, false))
        {
            break MISSING_BLOCK_LABEL_155;
        }
        ai1 = (new int[] {
            j, l
        });
        return ai1;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        int j1;
        j += ai[0] + ai[1];
        System.arraycopy(ai, 2, ai, 0, k - 2);
        ai[k - 2] = 0;
        ai[k - 1] = 0;
        j1 = i1 - 1;
_L4:
        ai[j1] = 1;
        boolean flag1 = flag ^ true;
        k1 = j1;
        l1 = j;
        flag2 = flag1;
          goto _L3
        j1 = i1 + 1;
          goto _L4
        throw NotFoundException.getNotFoundInstance();
          goto _L3
    }

    public Result decodeRow(int i, BitArray bitarray, Map map)
    {
        int ai[] = a(bitarray);
        ai[1] = 0;
        int j = bitarray.getNextSet(ai[1]);
        int k = bitarray.getSize();
        StringBuilder stringbuilder = new StringBuilder();
        int ai1[] = new int[7];
        do
        {
            for (int l = 0; l < ai1.length; l++)
            {
                ai1[l] = 0;
            }

            recordPattern(bitarray, j, ai1);
            char c1 = a(ai1);
            if (c1 == '!')
            {
                throw NotFoundException.getNotFoundInstance();
            }
            stringbuilder.append(c1);
            int i1 = ai1.length;
            int j1 = 0;
            int k1 = j;
            for (; j1 < i1; j1++)
            {
                k1 += ai1[j1];
            }

            int l1 = bitarray.getNextSet(k1);
            if (l1 >= k)
            {
                int i2 = 0;
                int j2 = ai1.length;
                for (int k2 = 0; k2 < j2; k2++)
                {
                    i2 += ai1[k2];
                }

                int l2 = l1 - j - i2;
                if (l1 != k && l2 / 2 < i2)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (stringbuilder.length() < 2)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                char c2 = stringbuilder.charAt(0);
                if (!a(e, c2))
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                int i3 = 1;
                do
                {
label0:
                    {
                        if (i3 < stringbuilder.length())
                        {
                            if (stringbuilder.charAt(i3) != c2 || i3 + 1 == stringbuilder.length())
                            {
                                break label0;
                            }
                            stringbuilder.delete(i3 + 1, -1 + stringbuilder.length());
                        }
                        if (stringbuilder.length() <= 6)
                        {
                            throw NotFoundException.getNotFoundInstance();
                        } else
                        {
                            stringbuilder.deleteCharAt(-1 + stringbuilder.length());
                            stringbuilder.deleteCharAt(0);
                            float f = (float)(ai[1] + ai[0]) / 2.0F;
                            float f1 = (float)(j + l1) / 2.0F;
                            String s = stringbuilder.toString();
                            ResultPoint aresultpoint[] = new ResultPoint[2];
                            aresultpoint[0] = new ResultPoint(f, i);
                            aresultpoint[1] = new ResultPoint(f1, i);
                            return new Result(s, null, aresultpoint, BarcodeFormat.CODABAR);
                        }
                    }
                    i3++;
                } while (true);
            }
            j = l1;
        } while (true);
    }

}
