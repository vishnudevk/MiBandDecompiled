// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss.expanded;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned.rss.expanded:
//            a, b

public final class RSSExpandedReader extends AbstractRSSReader
{

    private static final int a[] = {
        7, 5, 4, 3, 1
    };
    private static final int b[] = {
        4, 20, 52, 104, 204
    };
    private static final int c[] = {
        0, 348, 1388, 2948, 3988
    };
    private static final int d[][] = {
        {
            1, 8, 4, 1
        }, {
            3, 6, 4, 1
        }, {
            3, 4, 6, 1
        }, {
            3, 2, 8, 1
        }, {
            2, 6, 5, 1
        }, {
            2, 2, 9, 1
        }
    };
    private static final int e[][] = {
        {
            1, 3, 9, 27, 81, 32, 96, 77
        }, {
            20, 60, 180, 118, 143, 7, 21, 63
        }, {
            189, 145, 13, 39, 117, 140, 209, 205
        }, {
            193, 157, 49, 147, 19, 57, 171, 91
        }, {
            62, 186, 136, 197, 169, 85, 44, 132
        }, {
            185, 133, 188, 142, 4, 12, 36, 108
        }, {
            113, 128, 173, 97, 80, 29, 87, 50
        }, {
            150, 28, 84, 41, 123, 158, 52, 156
        }, {
            46, 138, 203, 187, 139, 206, 196, 166
        }, {
            76, 17, 51, 153, 37, 111, 122, 155
        }, {
            43, 129, 176, 106, 107, 110, 119, 146
        }, {
            16, 48, 144, 10, 30, 90, 59, 177
        }, {
            109, 116, 137, 200, 178, 112, 125, 164
        }, {
            70, 210, 208, 202, 184, 130, 179, 115
        }, {
            134, 191, 151, 31, 93, 68, 204, 190
        }, {
            148, 22, 66, 198, 172, 94, 71, 2
        }, {
            6, 18, 54, 162, 64, 192, 154, 40
        }, {
            120, 149, 25, 75, 14, 42, 126, 167
        }, {
            79, 26, 78, 23, 69, 207, 199, 175
        }, {
            103, 98, 83, 38, 114, 131, 182, 124
        }, {
            161, 61, 183, 127, 170, 88, 53, 159
        }, {
            55, 165, 73, 8, 24, 72, 5, 15
        }, {
            45, 135, 194, 160, 58, 174, 100, 89
        }
    };
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 2;
    private static final int i = 3;
    private static final int j = 4;
    private static final int k = 5;
    private static final int l[][] = {
        {
            0, 0
        }, {
            0, 1, 1
        }, {
            0, 2, 1, 3
        }, {
            0, 4, 1, 3, 2
        }, {
            0, 4, 1, 3, 3, 5
        }, {
            0, 4, 1, 3, 4, 5, 5
        }, {
            0, 0, 1, 1, 2, 2, 3, 3
        }, {
            0, 0, 1, 1, 2, 2, 3, 4, 4
        }, {
            0, 0, 1, 1, 2, 2, 3, 4, 5, 5
        }, {
            0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 
            5
        }
    };
    private static final int m = 0;
    private static final int n = 11;
    private final List o = new ArrayList(11);
    private final int p[] = new int[2];
    private final int q[];

    public RSSExpandedReader()
    {
        q = new int[m];
    }

    private static int a(BitArray bitarray, int i1)
    {
        if (bitarray.get(i1))
        {
            return bitarray.getNextSet(bitarray.getNextUnset(i1));
        } else
        {
            return bitarray.getNextUnset(bitarray.getNextSet(i1));
        }
    }

    private static Result a(List list)
    {
        String s = AbstractExpandedDecoder.createDecoder(com.google.zxing.oned.rss.expanded.a.a(list)).parseInformation();
        ResultPoint aresultpoint[] = ((b)list.get(0)).d().getResultPoints();
        ResultPoint aresultpoint1[] = ((b)list.get(-1 + list.size())).d().getResultPoints();
        ResultPoint aresultpoint2[] = new ResultPoint[4];
        aresultpoint2[0] = aresultpoint[0];
        aresultpoint2[1] = aresultpoint[1];
        aresultpoint2[2] = aresultpoint1[0];
        aresultpoint2[3] = aresultpoint1[1];
        return new Result(s, null, aresultpoint2, BarcodeFormat.RSS_EXPANDED);
    }

    private FinderPattern a(BitArray bitarray, int i1, boolean flag)
    {
        int j1;
        int k1;
        int l1;
        int ai[];
        int i2;
        if (flag)
        {
            int j2;
            for (j2 = -1 + p[0]; j2 >= 0 && !bitarray.get(j2); j2--) { }
            j1 = j2 + 1;
            l1 = p[0] - j1;
            k1 = p[1];
        } else
        {
            j1 = p[0];
            k1 = bitarray.getNextUnset(1 + p[1]);
            l1 = k1 - p[1];
        }
        ai = getDecodeFinderCounters();
        System.arraycopy(ai, 0, ai, 1, -1 + ai.length);
        ai[0] = l1;
        try
        {
            i2 = parseFinderValue(ai, d);
        }
        catch (NotFoundException notfoundexception)
        {
            return null;
        }
        return new FinderPattern(i2, new int[] {
            j1, k1
        }, j1, k1, i1);
    }

    private void a(int i1)
    {
        int j1 = 1;
        int k1 = count(getOddCounts());
        int l1 = count(getEvenCounts());
        int i2 = (k1 + l1) - i1;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        if ((k1 & 1) == j1)
        {
            j2 = j1;
        } else
        {
            j2 = 0;
        }
        if ((l1 & 1) == 0)
        {
            k2 = j1;
        } else
        {
            k2 = 0;
        }
        int l3;
        int i4;
        if (k1 > 13)
        {
            l2 = j1;
            i3 = 0;
        } else
        if (k1 < 4)
        {
            i3 = j1;
            l2 = 0;
        } else
        {
            l2 = 0;
            i3 = 0;
        }
        if (l1 > 13)
        {
            k3 = 0;
            j3 = j1;
        } else
        if (l1 < 4)
        {
            k3 = j1;
            j3 = 0;
        } else
        {
            j3 = 0;
            k3 = 0;
        }
        if (i2 == j1)
        {
            if (j2 != 0)
            {
                if (k2 != 0)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                i4 = i3;
                int l4 = j1;
                j1 = k3;
                l3 = l4;
            } else
            {
                if (k2 == 0)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                j3 = j1;
                j1 = k3;
                l3 = l2;
                i4 = i3;
            }
            break MISSING_BLOCK_LABEL_147;
        }
        if (i2 == -1)
        {
            if (j2 != 0)
            {
                if (k2 != 0)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                int k4 = k3;
                l3 = l2;
                i4 = j1;
                j1 = k4;
            } else
            {
                if (k2 == 0)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                l3 = l2;
                i4 = i3;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (i2 == 0)
        {
            if (j2 != 0)
            {
                if (k2 == 0)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (k1 < l1)
                {
                    j3 = j1;
                    int j4 = k3;
                    l3 = l2;
                    i4 = j1;
                    j1 = j4;
                } else
                {
                    l3 = j1;
                    i4 = i3;
                }
                continue; /* Loop/switch isn't completed */
            }
            if (k2 != 0)
            {
                throw NotFoundException.getNotFoundInstance();
            }
        } else
        {
            throw NotFoundException.getNotFoundInstance();
        }
        j1 = k3;
        l3 = l2;
        i4 = i3;
          goto _L1
_L3:
        if (i4 != 0)
        {
            if (l3 != 0)
            {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(getOddCounts(), getOddRoundingErrors());
        }
        if (l3 != 0)
        {
            decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (j1 != 0)
        {
            if (j3 != 0)
            {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (j3 != 0)
        {
            decrement(getEvenCounts(), getEvenRoundingErrors());
        }
        return;
_L1:
        if (true) goto _L3; else goto _L2
_L2:
    }

    private static void a(int ai[])
    {
        int i1 = ai.length;
        for (int j1 = 0; j1 < i1 / 2; j1++)
        {
            int k1 = ai[j1];
            ai[j1] = ai[-1 + (i1 - j1)];
            ai[-1 + (i1 - j1)] = k1;
        }

    }

    private boolean a()
    {
        b b1 = (b)o.get(0);
        DataCharacter datacharacter = b1.b();
        int i1 = b1.c().getChecksumPortion();
        int j1 = 2;
        int k1 = i1;
        for (int l1 = 1; l1 < o.size(); l1++)
        {
            b b2 = (b)o.get(l1);
            k1 += b2.b().getChecksumPortion();
            j1++;
            DataCharacter datacharacter1 = b2.c();
            if (datacharacter1 != null)
            {
                k1 += datacharacter1.getChecksumPortion();
                j1++;
            }
        }

        return k1 % 211 + 211 * (j1 - 4) == datacharacter.getValue();
    }

    private static boolean a(FinderPattern finderpattern, boolean flag, boolean flag1)
    {
        return finderpattern.getValue() != 0 || !flag || !flag1;
    }

    private boolean a(List list, FinderPattern finderpattern)
    {
        int i1;
        int ai[][];
        int k1;
        int l1;
        i1 = 1 + list.size();
        if (i1 > q.length)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int j1 = 0; j1 < list.size(); j1++)
        {
            q[j1] = ((b)list.get(j1)).d().getValue();
        }

        q[i1 - 1] = finderpattern.getValue();
        ai = l;
        k1 = ai.length;
        l1 = 0;
_L6:
        if (l1 >= k1) goto _L2; else goto _L1
_L1:
        int ai1[];
        int i2;
        ai1 = ai[l1];
        if (ai1.length < i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        i2 = 0;
_L5:
        if (i2 >= i1)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        if (q[i2] == ai1[i2]) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L7:
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        int j2 = ai1.length;
        boolean flag1 = false;
        if (i1 == j2)
        {
            flag1 = true;
        }
        return flag1;
_L4:
        i2++;
          goto _L5
        l1++;
          goto _L6
_L2:
        throw NotFoundException.getNotFoundInstance();
        flag = true;
          goto _L7
    }

    private void b(BitArray bitarray, List list, int i1)
    {
        int ai[] = getDecodeFinderCounters();
        ai[0] = 0;
        ai[1] = 0;
        ai[2] = 0;
        ai[3] = 0;
        int j1 = bitarray.getSize();
        boolean flag;
        boolean flag1;
        int k1;
        if (i1 < 0)
        {
            if (list.isEmpty())
            {
                i1 = 0;
            } else
            {
                i1 = ((b)list.get(-1 + list.size())).d().getStartEnd()[1];
            }
        }
        if (list.size() % 2 != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = false;
        k1 = i1;
        do
        {
label0:
            {
label1:
                {
                    int l1;
                    int j2;
                    boolean flag2;
                    int k2;
                    if (k1 < j1)
                    {
                        int i2;
                        if (!bitarray.get(k1))
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (flag1)
                        {
                            break label1;
                        }
                    }
                    l1 = k1;
                    i2 = k1;
                    j2 = 0;
                    flag2 = flag1;
                    k2 = i2;
                    while (l1 < j1) 
                    {
                        if (flag2 ^ bitarray.get(l1))
                        {
                            ai[j2] = 1 + ai[j2];
                        } else
                        {
                            if (j2 == 3)
                            {
                                if (flag)
                                {
                                    a(ai);
                                }
                                if (isFinderPattern(ai))
                                {
                                    p[0] = k2;
                                    p[1] = l1;
                                    return;
                                }
                                if (flag)
                                {
                                    a(ai);
                                }
                                k2 += ai[0] + ai[1];
                                ai[0] = ai[2];
                                ai[1] = ai[3];
                                ai[2] = 0;
                                ai[3] = 0;
                                j2--;
                            } else
                            {
                                j2++;
                            }
                            ai[j2] = 1;
                            if (!flag2)
                            {
                                flag2 = true;
                            } else
                            {
                                flag2 = false;
                            }
                        }
                        l1++;
                    }
                    break label0;
                }
                k1++;
                continue;
            }
            throw NotFoundException.getNotFoundInstance();
        } while (true);
    }

    DataCharacter a(BitArray bitarray, FinderPattern finderpattern, boolean flag, boolean flag1)
    {
        int ai[] = getDataCharacterCounters();
        ai[0] = 0;
        ai[1] = 0;
        ai[2] = 0;
        ai[3] = 0;
        ai[4] = 0;
        ai[5] = 0;
        ai[6] = 0;
        ai[7] = 0;
        float f1;
        int ai1[];
        int ai2[];
        float af[];
        float af1[];
        int l1;
        if (flag1)
        {
            recordPatternInReverse(bitarray, finderpattern.getStartEnd()[0], ai);
        } else
        {
            recordPattern(bitarray, 1 + finderpattern.getStartEnd()[1], ai);
            int i1 = 0;
            int j1 = -1 + ai.length;
            while (i1 < j1) 
            {
                int k1 = ai[i1];
                ai[i1] = ai[j1];
                ai[j1] = k1;
                i1++;
                j1--;
            }
        }
        f1 = (float)count(ai) / (float)17;
        ai1 = getOddCounts();
        ai2 = getEvenCounts();
        af = getOddRoundingErrors();
        af1 = getEvenRoundingErrors();
        l1 = 0;
        do
        {
            if (l1 >= ai.length)
            {
                break;
            }
            float f2 = (1.0F * (float)ai[l1]) / f1;
            int j7 = (int)(0.5F + f2);
            int k7;
            if (j7 < 1)
            {
                j7 = 1;
            } else
            if (j7 > 8)
            {
                j7 = 8;
            }
            k7 = l1 >> 1;
            if ((l1 & 1) == 0)
            {
                ai1[k7] = j7;
                af[k7] = f2 - (float)j7;
            } else
            {
                ai2[k7] = j7;
                af1[k7] = f2 - (float)j7;
            }
            l1++;
        } while (true);
        a(17);
        int i2 = 4 * finderpattern.getValue();
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        if (flag)
        {
            j2 = 0;
        } else
        {
            j2 = 2;
        }
        k2 = i2 + j2;
        if (flag1)
        {
            l2 = 0;
        } else
        {
            l2 = 1;
        }
        i3 = -1 + (l2 + k2);
        j3 = -1 + ai1.length;
        k3 = 0;
        l3 = j3;
        i4 = 0;
        while (l3 >= 0) 
        {
            if (a(finderpattern, flag, flag1))
            {
                i4 += e[i3][l3 * 2] * ai1[l3];
            }
            int i7 = k3 + ai1[l3];
            l3--;
            k3 = i7;
        }
        int j4 = -1 + ai2.length;
        int k4 = 0;
        int l4 = 0;
        for (int i5 = j4; i5 >= 0; i5--)
        {
            if (a(finderpattern, flag, flag1))
            {
                k4 += e[i3][1 + i5 * 2] * ai2[i5];
            }
            l4 += ai2[i5];
        }

        int j5 = i4 + k4;
        if ((k3 & 1) != 0 || k3 > 13 || k3 < 4)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            int k5 = (13 - k3) / 2;
            int l5 = a[k5];
            int i6 = 9 - l5;
            int j6 = RSSUtils.getRSSvalue(ai1, l5, true);
            int k6 = RSSUtils.getRSSvalue(ai2, i6, false);
            int l6 = b[k5];
            return new DataCharacter(c[k5] + (k6 + j6 * l6), j5);
        }
    }

    b a(BitArray bitarray, List list, int i1)
    {
        boolean flag2;
        DataCharacter datacharacter1;
        boolean flag;
        int j1;
        boolean flag1;
        if (list.size() % 2 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j1 = -1;
        flag1 = true;
        do
        {
            b(bitarray, list, j1);
            FinderPattern finderpattern = a(bitarray, i1, flag);
            DataCharacter datacharacter;
            DataCharacter datacharacter2;
            if (finderpattern == null)
            {
                j1 = a(bitarray, p[0]);
            } else
            {
                flag1 = false;
            }
        } while (flag1);
        flag2 = a(list, finderpattern);
        datacharacter = a(bitarray, finderpattern, flag, true);
        datacharacter2 = a(bitarray, finderpattern, flag, false);
        datacharacter1 = datacharacter2;
_L2:
        return new b(datacharacter, datacharacter1, finderpattern, flag2);
        NotFoundException notfoundexception;
        notfoundexception;
        if (flag2)
        {
            datacharacter1 = null;
        } else
        {
            throw notfoundexception;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    List a(int i1, BitArray bitarray)
    {
        b b1;
        do
        {
            do
            {
                b1 = a(bitarray, o, i1);
                o.add(b1);
            } while (!b1.a());
            if (a())
            {
                return o;
            }
        } while (!b1.e());
        throw NotFoundException.getNotFoundInstance();
    }

    public Result decodeRow(int i1, BitArray bitarray, Map map)
    {
        reset();
        a(i1, bitarray);
        return a(o);
    }

    public void reset()
    {
        o.clear();
    }

    static 
    {
        m = l[-1 + l.length].length;
    }
}
