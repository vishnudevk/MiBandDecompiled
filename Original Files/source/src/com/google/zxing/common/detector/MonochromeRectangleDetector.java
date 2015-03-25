// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class MonochromeRectangleDetector
{

    private static final int a = 32;
    private final BitMatrix b;

    public MonochromeRectangleDetector(BitMatrix bitmatrix)
    {
        b = bitmatrix;
    }

    private ResultPoint a(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2)
    {
        int j2 = i;
        int k2 = i1;
        int ai[] = null;
        int l2;
        for (; k2 < l1 && k2 >= k1 && j2 < l && j2 >= k; k2 = l2)
        {
            int ai1[];
            if (j == 0)
            {
                ai1 = a(k2, i2, k, l, true);
            } else
            {
                ai1 = a(j2, i2, k1, l1, false);
            }
            if (ai1 == null)
            {
                if (ai == null)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (j == 0)
                {
                    int j3 = k2 - j1;
                    if (ai[0] < i)
                    {
                        if (ai[1] > i)
                        {
                            float f2;
                            if (j1 > 0)
                            {
                                f2 = ai[0];
                            } else
                            {
                                f2 = ai[1];
                            }
                            return new ResultPoint(f2, j3);
                        } else
                        {
                            return new ResultPoint(ai[0], j3);
                        }
                    } else
                    {
                        return new ResultPoint(ai[1], j3);
                    }
                }
                int i3 = j2 - j;
                if (ai[0] < i1)
                {
                    if (ai[1] > i1)
                    {
                        float f = i3;
                        float f1;
                        if (j < 0)
                        {
                            f1 = ai[0];
                        } else
                        {
                            f1 = ai[1];
                        }
                        return new ResultPoint(f, f1);
                    } else
                    {
                        return new ResultPoint(i3, ai[0]);
                    }
                } else
                {
                    return new ResultPoint(i3, ai[1]);
                }
            }
            l2 = k2 + j1;
            j2 += j;
            ai = ai1;
        }

        throw NotFoundException.getNotFoundInstance();
    }

    private int[] a(int i, int j, int k, int l, boolean flag)
    {
        int i1;
        int j1;
        i1 = k + l >> 1;
        j1 = i1;
_L9:
        if (j1 < k) goto _L2; else goto _L1
_L1:
        int k1;
        int l1;
        int l2;
        if (flag ? b.get(j1, i) : b.get(i, j1))
        {
            j1--;
            continue; /* Loop/switch isn't completed */
        }
        int i3;
        for (l2 = j1; --l2 >= k && (flag ? !b.get(l2, i) : !b.get(i, l2));) { }
        i3 = j1 - l2;
        if (l2 >= k && i3 <= j) goto _L3; else goto _L2
_L2:
        k1 = j1 + 1;
        l1 = i1;
_L7:
        if (l1 < l)
        {
            break MISSING_BLOCK_LABEL_122;
        }
          goto _L4
_L3:
        j1 = l2;
        continue; /* Loop/switch isn't completed */
        int j2;
        if (flag ? b.get(l1, i) : b.get(i, l1))
        {
            l1++;
            continue; /* Loop/switch isn't completed */
        }
        int i2;
        int k2;
        for (j2 = l1; ++j2 < l && (flag ? !b.get(j2, i) : !b.get(i, j2));) { }
        k2 = j2 - l1;
        if (j2 < l && k2 <= j) goto _L5; else goto _L4
_L4:
        i2 = l1 - 1;
        if (i2 > k1)
        {
            return (new int[] {
                k1, i2
            });
        }
        break; /* Loop/switch isn't completed */
_L5:
        l1 = j2;
        if (true) goto _L7; else goto _L6
_L6:
        return null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public ResultPoint[] detect()
    {
        int i = b.getHeight();
        int j = b.getWidth();
        int k = i >> 1;
        int l = j >> 1;
        int i1 = Math.max(1, i / 256);
        int j1 = Math.max(1, j / 256);
        int k1 = -1 + (int)a(l, 0, 0, j, k, -i1, 0, i, l >> 1).getY();
        ResultPoint resultpoint = a(l, -j1, 0, j, k, 0, k1, i, k >> 1);
        int l1 = -1 + (int)resultpoint.getX();
        ResultPoint resultpoint1 = a(l, j1, l1, j, k, 0, k1, i, k >> 1);
        int i2 = 1 + (int)resultpoint1.getX();
        ResultPoint resultpoint2 = a(l, 0, l1, i2, k, i1, k1, i, l >> 1);
        int j2 = 1 + (int)resultpoint2.getY();
        return (new ResultPoint[] {
            a(l, 0, l1, i2, k, -i1, k1, j2, l >> 2), resultpoint, resultpoint1, resultpoint2
        });
    }
}
