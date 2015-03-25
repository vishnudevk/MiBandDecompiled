// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader

public final class ITFReader extends OneDReader
{

    static final int a[][] = {
        {
            1, 1, 3, 3, 1
        }, {
            3, 1, 1, 1, 3
        }, {
            1, 3, 1, 1, 3
        }, {
            3, 3, 1, 1, 1
        }, {
            1, 1, 3, 1, 3
        }, {
            3, 1, 3, 1, 1
        }, {
            1, 3, 3, 1, 1
        }, {
            1, 1, 1, 3, 3
        }, {
            3, 1, 1, 3, 1
        }, {
            1, 3, 1, 3, 1
        }
    };
    private static final int b = 107;
    private static final int c = 204;
    private static final int d = 3;
    private static final int e = 1;
    private static final int f[] = {
        44, 24, 20, 18, 16, 14, 12, 10, 8, 6
    };
    private static final int h[] = {
        1, 1, 1, 1
    };
    private static final int i[] = {
        1, 1, 3
    };
    private int g;

    public ITFReader()
    {
        g = -1;
    }

    private static int a(int ai[])
    {
        int j = 107;
        int k = -1;
        int l = a.length;
        int i1 = 0;
        while (i1 < l) 
        {
            int j1 = patternMatchVariance(ai, a[i1], 204);
            if (j1 < j)
            {
                k = i1;
            } else
            {
                j1 = j;
            }
            i1++;
            j = j1;
        }
        if (k >= 0)
        {
            return k;
        } else
        {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private void a(BitArray bitarray, int j)
    {
        int k = 10 * g;
        int l = j - 1;
        do
        {
            if (k <= 0 || l < 0 || bitarray.get(l))
            {
                if (k != 0)
                {
                    throw NotFoundException.getNotFoundInstance();
                } else
                {
                    return;
                }
            }
            k--;
            l--;
        } while (true);
    }

    private static void a(BitArray bitarray, int j, int k, StringBuilder stringbuilder)
    {
        int ai[] = new int[10];
        int ai1[] = new int[5];
        int ai2[] = new int[5];
        int k1;
        for (int l = j; l < k; l = k1)
        {
            recordPattern(bitarray, l, ai);
            for (int i1 = 0; i1 < 5; i1++)
            {
                int i2 = i1 << 1;
                ai1[i1] = ai[i2];
                ai2[i1] = ai[i2 + 1];
            }

            stringbuilder.append((char)(48 + a(ai1)));
            stringbuilder.append((char)(48 + a(ai2)));
            int j1 = ai.length;
            k1 = l;
            for (int l1 = 0; l1 < j1; l1++)
            {
                k1 += ai[l1];
            }

        }

    }

    private static int[] a(BitArray bitarray, int j, int ai[])
    {
        int k = ai.length;
        int ai1[] = new int[k];
        int l = bitarray.getSize();
        int i1 = j;
        int j1 = 0;
        boolean flag = false;
        while (j < l) 
        {
            if (flag ^ bitarray.get(j))
            {
                ai1[j1] = 1 + ai1[j1];
            } else
            {
                if (j1 == k - 1)
                {
                    if (patternMatchVariance(ai1, ai, 204) < 107)
                    {
                        return (new int[] {
                            i1, j
                        });
                    }
                    i1 += ai1[0] + ai1[1];
                    System.arraycopy(ai1, 2, ai1, 0, k - 2);
                    ai1[k - 2] = 0;
                    ai1[k - 1] = 0;
                    j1--;
                } else
                {
                    j1++;
                }
                ai1[j1] = 1;
                if (!flag)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            j++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int c(BitArray bitarray)
    {
        int j = bitarray.getSize();
        int k = bitarray.getNextSet(0);
        if (k == j)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            return k;
        }
    }

    int[] a(BitArray bitarray)
    {
        int ai[] = a(bitarray, c(bitarray), h);
        g = ai[1] - ai[0] >> 2;
        a(bitarray, ai[0]);
        return ai;
    }

    int[] b(BitArray bitarray)
    {
        bitarray.reverse();
        int ai[];
        ai = a(bitarray, c(bitarray), i);
        a(bitarray, ai[0]);
        int j = ai[0];
        ai[0] = bitarray.getSize() - ai[1];
        ai[1] = bitarray.getSize() - j;
        bitarray.reverse();
        return ai;
        Exception exception;
        exception;
        bitarray.reverse();
        throw exception;
    }

    public Result decodeRow(int j, BitArray bitarray, Map map)
    {
        int ai[] = a(bitarray);
        int ai1[] = b(bitarray);
        StringBuilder stringbuilder = new StringBuilder(20);
        a(bitarray, ai[1], ai1[0], stringbuilder);
        String s = stringbuilder.toString();
        int ai2[];
        int k;
        int l;
        int i1;
        boolean flag;
        ResultPoint aresultpoint[];
        if (map != null)
        {
            ai2 = (int[])(int[])map.get(DecodeHintType.ALLOWED_LENGTHS);
        } else
        {
            ai2 = null;
        }
        if (ai2 == null)
        {
            ai2 = f;
        }
        k = s.length();
        l = ai2.length;
        i1 = 0;
        if (i1 >= l)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        if (k != ai2[i1]) goto _L2; else goto _L1
_L1:
        flag = true;
_L4:
        if (!flag)
        {
            throw FormatException.getFormatInstance();
        } else
        {
            aresultpoint = new ResultPoint[2];
            aresultpoint[0] = new ResultPoint(ai[1], j);
            aresultpoint[1] = new ResultPoint(ai1[0], j);
            return new Result(s, null, aresultpoint, BarcodeFormat.ITF);
        }
_L2:
        i1++;
        break MISSING_BLOCK_LABEL_92;
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

}
