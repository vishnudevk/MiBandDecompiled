// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned.rss:
//            AbstractRSSReader, a, FinderPattern, RSSUtils, 
//            DataCharacter

public final class RSS14Reader extends AbstractRSSReader
{

    private static final int a[] = {
        1, 10, 34, 70, 126
    };
    private static final int b[] = {
        4, 20, 48, 81
    };
    private static final int c[] = {
        0, 161, 961, 2015, 2715
    };
    private static final int d[] = {
        0, 336, 1036, 1516
    };
    private static final int e[] = {
        8, 6, 4, 3, 1
    };
    private static final int f[] = {
        2, 4, 6, 8
    };
    private static final int g[][] = {
        {
            3, 8, 2, 1
        }, {
            3, 5, 5, 1
        }, {
            3, 3, 7, 1
        }, {
            3, 1, 9, 1
        }, {
            2, 7, 4, 1
        }, {
            2, 5, 6, 1
        }, {
            2, 3, 8, 1
        }, {
            1, 5, 7, 1
        }, {
            1, 3, 9, 1
        }
    };
    private final List h = new ArrayList();
    private final List i = new ArrayList();

    public RSS14Reader()
    {
    }

    private static Result a(a a1, a a2)
    {
        String s = String.valueOf(0x453af5L * (long)a1.getValue() + (long)a2.getValue());
        StringBuilder stringbuilder = new StringBuilder(14);
        for (int j = 13 - s.length(); j > 0; j--)
        {
            stringbuilder.append('0');
        }

        stringbuilder.append(s);
        int k = 0;
        int l = 0;
        for (; k < 13; k++)
        {
            int j1 = -48 + stringbuilder.charAt(k);
            if ((k & 1) == 0)
            {
                j1 *= 3;
            }
            l += j1;
        }

        int i1 = 10 - l % 10;
        if (i1 == 10)
        {
            i1 = 0;
        }
        stringbuilder.append(i1);
        ResultPoint aresultpoint[] = a1.a().getResultPoints();
        ResultPoint aresultpoint1[] = a2.a().getResultPoints();
        String s1 = String.valueOf(stringbuilder.toString());
        ResultPoint aresultpoint2[] = new ResultPoint[4];
        aresultpoint2[0] = aresultpoint[0];
        aresultpoint2[1] = aresultpoint[1];
        aresultpoint2[2] = aresultpoint1[0];
        aresultpoint2[3] = aresultpoint1[1];
        return new Result(s1, null, aresultpoint2, BarcodeFormat.RSS_14);
    }

    private DataCharacter a(BitArray bitarray, FinderPattern finderpattern, boolean flag)
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
        int i1;
        float f1;
        int ai1[];
        int ai2[];
        float af[];
        float af1[];
        int j1;
        if (flag)
        {
            recordPatternInReverse(bitarray, finderpattern.getStartEnd()[0], ai);
        } else
        {
            recordPattern(bitarray, 1 + finderpattern.getStartEnd()[1], ai);
            int j = 0;
            int k = -1 + ai.length;
            while (j < k) 
            {
                int l = ai[j];
                ai[j] = ai[k];
                ai[k] = l;
                j++;
                k--;
            }
        }
        if (flag)
        {
            i1 = 16;
        } else
        {
            i1 = 15;
        }
        f1 = (float)count(ai) / (float)i1;
        ai1 = getOddCounts();
        ai2 = getEvenCounts();
        af = getOddRoundingErrors();
        af1 = getEvenRoundingErrors();
        j1 = 0;
        do
        {
            if (j1 >= ai.length)
            {
                break;
            }
            float f2 = (float)ai[j1] / f1;
            int l6 = (int)(0.5F + f2);
            int i7;
            if (l6 < 1)
            {
                l6 = 1;
            } else
            if (l6 > 8)
            {
                l6 = 8;
            }
            i7 = j1 >> 1;
            if ((j1 & 1) == 0)
            {
                ai1[i7] = l6;
                af[i7] = f2 - (float)l6;
            } else
            {
                ai2[i7] = l6;
                af1[i7] = f2 - (float)l6;
            }
            j1++;
        } while (true);
        a(flag, i1);
        int k1 = -1 + ai1.length;
        int l1 = 0;
        int i2;
        int k6;
        for (i2 = 0; k1 >= 0; i2 = k6)
        {
            int j6 = l1 * 9 + ai1[k1];
            k6 = i2 + ai1[k1];
            k1--;
            l1 = j6;
        }

        int j2 = 0;
        int k2 = 0;
        for (int l2 = -1 + ai2.length; l2 >= 0; l2--)
        {
            j2 = j2 * 9 + ai2[l2];
            k2 += ai2[l2];
        }

        int i3 = l1 + j2 * 3;
        if (flag)
        {
            if ((i2 & 1) != 0 || i2 > 12 || i2 < 4)
            {
                throw NotFoundException.getNotFoundInstance();
            } else
            {
                int l4 = (12 - i2) / 2;
                int i5 = e[l4];
                int j5 = 9 - i5;
                int k5 = RSSUtils.getRSSvalue(ai1, i5, false);
                int l5 = RSSUtils.getRSSvalue(ai2, j5, true);
                int i6 = a[l4];
                return new DataCharacter(c[l4] + (l5 + k5 * i6), i3);
            }
        }
        if ((k2 & 1) != 0 || k2 > 10 || k2 < 4)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            int j3 = (10 - k2) / 2;
            int k3 = f[j3];
            int l3 = 9 - k3;
            int i4 = RSSUtils.getRSSvalue(ai1, k3, true);
            int j4 = RSSUtils.getRSSvalue(ai2, l3, false);
            int k4 = b[j3];
            return new DataCharacter(d[j3] + (i4 + j4 * k4), i3);
        }
    }

    private FinderPattern a(BitArray bitarray, int j, boolean flag, int ai[])
    {
        boolean flag1 = bitarray.get(ai[0]);
        int k;
        for (k = -1 + ai[0]; k >= 0 && flag1 ^ bitarray.get(k); k--) { }
        int l = k + 1;
        int i1 = ai[0] - l;
        int ai1[] = getDecodeFinderCounters();
        System.arraycopy(ai1, 0, ai1, 1, -1 + ai1.length);
        ai1[0] = i1;
        int j1 = parseFinderValue(ai1, g);
        int k1 = ai[1];
        int l1;
        int ai2[];
        if (flag)
        {
            l1 = (-1 + bitarray.getSize()) - l;
            k1 = (-1 + bitarray.getSize()) - k1;
        } else
        {
            l1 = l;
        }
        ai2 = new int[2];
        ai2[0] = l;
        ai2[1] = ai[1];
        return new FinderPattern(j1, ai2, l1, k1, j);
    }

    private a a(BitArray bitarray, boolean flag, int j, Map map)
    {
        int ai[];
        FinderPattern finderpattern;
        ResultPointCallback resultpointcallback;
        ResultPointCallback resultpointcallback1;
        float f1;
        try
        {
            ai = a(bitarray, 0, flag);
            finderpattern = a(bitarray, j, flag, ai);
        }
        catch (NotFoundException notfoundexception)
        {
            return null;
        }
        if (map != null) goto _L2; else goto _L1
_L1:
        resultpointcallback1 = null;
_L4:
        if (resultpointcallback1 == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        f1 = (float)(ai[0] + ai[1]) / 2.0F;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        f1 = (float)(-1 + bitarray.getSize()) - f1;
        resultpointcallback1.foundPossibleResultPoint(new ResultPoint(f1, j));
        DataCharacter datacharacter = a(bitarray, finderpattern, true);
        DataCharacter datacharacter1 = a(bitarray, finderpattern, false);
        return new a(1597 * datacharacter.getValue() + datacharacter1.getValue(), datacharacter.getChecksumPortion() + 4 * datacharacter1.getChecksumPortion(), finderpattern);
_L2:
        resultpointcallback = (ResultPointCallback)map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        resultpointcallback1 = resultpointcallback;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static void a(Collection collection, a a1)
    {
        if (a1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag;
        Iterator iterator = collection.iterator();
        a a2;
        do
        {
            if (!iterator.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            a2 = (a)iterator.next();
        } while (a2.getValue() != a1.getValue());
        a2.c();
        flag = true;
_L4:
        if (!flag)
        {
            collection.add(a1);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        flag = false;
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void a(boolean flag, int j)
    {
        int k;
        int l;
        int i1;
        int j1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        k = 1;
        l = count(getOddCounts());
        i1 = count(getEvenCounts());
        j1 = (l + i1) - j;
        int k1 = l & 1;
        int l1;
        if (flag)
        {
            l1 = k;
        } else
        {
            l1 = 0;
        }
        if (k1 == l1)
        {
            i2 = k;
        } else
        {
            i2 = 0;
        }
        if ((i1 & 1) == k)
        {
            j2 = k;
        } else
        {
            j2 = 0;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (l > 12)
        {
            k2 = k;
            l2 = 0;
        } else
        if (l < 4)
        {
            l2 = k;
            k2 = 0;
        } else
        {
            k2 = 0;
            l2 = 0;
        }
        if (i1 <= 12) goto _L4; else goto _L3
_L3:
        j3 = 0;
        i3 = k;
_L7:
        if (j1 == k)
        {
            if (i2 != 0)
            {
                if (j2 != 0)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                int l3 = l2;
                int k4 = k;
                k = j3;
                int k3 = k4;
                do
                {
                    if (l3 != 0)
                    {
                        int i4;
                        int j4;
                        if (k3 != 0)
                        {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        increment(getOddCounts(), getOddRoundingErrors());
                    }
                    if (k3 != 0)
                    {
                        decrement(getOddCounts(), getOddRoundingErrors());
                    }
                    if (k != 0)
                    {
                        if (i3 != 0)
                        {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        increment(getEvenCounts(), getOddRoundingErrors());
                    }
                    if (i3 != 0)
                    {
                        decrement(getEvenCounts(), getEvenRoundingErrors());
                    }
                    return;
                } while (true);
            } else
            {
                if (j2 == 0)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                i3 = k;
                k = j3;
                k3 = k2;
                l3 = l2;
                continue;
            }
        } else
        {
            if (j1 == -1)
            {
                if (i2 != 0)
                {
                    if (j2 != 0)
                    {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    j4 = j3;
                    k3 = k2;
                    l3 = k;
                    k = j4;
                } else
                {
                    if (j2 == 0)
                    {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    k3 = k2;
                    l3 = l2;
                }
                continue;
            }
            if (j1 == 0)
            {
                if (i2 != 0)
                {
                    if (j2 == 0)
                    {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    if (l < i1)
                    {
                        i3 = k;
                        i4 = j3;
                        k3 = k2;
                        l3 = k;
                        k = i4;
                    } else
                    {
                        k3 = k;
                        l3 = l2;
                    }
                    continue;
                }
                if (j2 != 0)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else
            {
                throw NotFoundException.getNotFoundInstance();
            }
            k = j3;
            k3 = k2;
            l3 = l2;
            continue;
        }
_L4:
        if (i1 < 4)
        {
            j3 = k;
            i3 = 0;
            continue; /* Loop/switch isn't completed */
        }
          goto _L5
_L2:
        if (l > 11)
        {
            k2 = k;
            l2 = 0;
        } else
        if (l < 5)
        {
            l2 = k;
            k2 = 0;
        } else
        {
            k2 = 0;
            l2 = 0;
        }
        if (i1 > 10)
        {
            i3 = k;
            j3 = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (i1 < 4)
        {
            j3 = k;
            i3 = 0;
            continue; /* Loop/switch isn't completed */
        }
_L5:
        i3 = 0;
        j3 = 0;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private int[] a(BitArray bitarray, int j, boolean flag)
    {
        int ai[] = getDecodeFinderCounters();
        ai[0] = 0;
        ai[1] = 0;
        ai[2] = 0;
        ai[3] = 0;
        int k = bitarray.getSize();
        boolean flag1 = false;
        int l = j;
        do
        {
label0:
            {
label1:
                {
                    int i1;
                    boolean flag2;
                    int j1;
                    int k1;
                    if (l < k)
                    {
                        if (!bitarray.get(l))
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (flag != flag1)
                        {
                            break label1;
                        }
                    }
                    i1 = l;
                    flag2 = flag1;
                    j1 = l;
                    k1 = 0;
                    while (i1 < k) 
                    {
                        if (flag2 ^ bitarray.get(i1))
                        {
                            ai[k1] = 1 + ai[k1];
                        } else
                        {
                            if (k1 == 3)
                            {
                                if (isFinderPattern(ai))
                                {
                                    return (new int[] {
                                        j1, i1
                                    });
                                }
                                j1 += ai[0] + ai[1];
                                ai[0] = ai[2];
                                ai[1] = ai[3];
                                ai[2] = 0;
                                ai[3] = 0;
                                k1--;
                            } else
                            {
                                k1++;
                            }
                            ai[k1] = 1;
                            if (!flag2)
                            {
                                flag2 = true;
                            } else
                            {
                                flag2 = false;
                            }
                        }
                        i1++;
                    }
                    break label0;
                }
                l++;
                continue;
            }
            throw NotFoundException.getNotFoundInstance();
        } while (true);
    }

    private static boolean b(a a1, a a2)
    {
        int j = a1.a().getValue();
        int k = a2.a().getValue();
        if ((j != 0 || k != 8) && j == 8)
        {
            if (k != 0);
        }
        int l = (a1.getChecksumPortion() + 16 * a2.getChecksumPortion()) % 79;
        int i1 = 9 * a1.a().getValue() + a2.a().getValue();
        if (i1 > 72)
        {
            i1--;
        }
        if (i1 > 8)
        {
            i1--;
        }
        return l == i1;
    }

    public Result decodeRow(int j, BitArray bitarray, Map map)
    {
        a a1 = a(bitarray, false, j, map);
        a(h, a1);
        bitarray.reverse();
        a a2 = a(bitarray, true, j, map);
        a(i, a2);
        bitarray.reverse();
        Iterator iterator = h.iterator();
        a a3;
        a a4;
label0:
        do
        {
            if (iterator.hasNext())
            {
                a3 = (a)iterator.next();
                if (a3.b() <= 1)
                {
                    continue;
                }
                Iterator iterator1 = i.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    a4 = (a)iterator1.next();
                } while (a4.b() <= 1 || !b(a3, a4));
                break;
            } else
            {
                throw NotFoundException.getNotFoundInstance();
            }
        } while (true);
        return a(a3, a4);
    }

    public void reset()
    {
        h.clear();
        i.clear();
    }

}
