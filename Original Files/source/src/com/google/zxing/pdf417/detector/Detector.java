// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import java.util.Arrays;
import java.util.Map;

public final class Detector
{

    private static final int a = 107;
    private static final int b = 204;
    private static final int c = 2;
    private static final int d[] = {
        8, 1, 1, 1, 1, 1, 1, 3
    };
    private static final int e[] = {
        3, 1, 1, 1, 1, 1, 1, 8
    };
    private static final int f[] = {
        7, 1, 1, 3, 1, 1, 1, 2, 1
    };
    private static final int g[] = {
        1, 2, 1, 1, 1, 3, 1, 1, 7
    };
    private final BinaryBitmap h;

    public Detector(BinaryBitmap binarybitmap)
    {
        h = binarybitmap;
    }

    private static float a(ResultPoint aresultpoint[])
    {
        return ((ResultPoint.distance(aresultpoint[0], aresultpoint[4]) + ResultPoint.distance(aresultpoint[1], aresultpoint[5])) / 34F + (ResultPoint.distance(aresultpoint[6], aresultpoint[2]) + ResultPoint.distance(aresultpoint[7], aresultpoint[3])) / 36F) / 2.0F;
    }

    private static int a(float f1)
    {
        return (int)(0.5F + f1);
    }

    private static int a(ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3, float f1)
    {
        return 17 * ((8 + (a(ResultPoint.distance(resultpoint, resultpoint1) / f1) + a(ResultPoint.distance(resultpoint2, resultpoint3) / f1) >> 1)) / 17);
    }

    private static int a(int ai[], int ai1[], int i)
    {
        int j;
        int l;
        int i1;
        j = ai.length;
        int k = 0;
        l = 0;
        i1 = 0;
        for (; k < j; k++)
        {
            i1 += ai[k];
            l += ai1[k];
        }

        if (i1 >= l) goto _L2; else goto _L1
_L1:
        return 0x7fffffff;
_L2:
        int i2;
        int j1 = (i1 << 8) / l;
        int k1 = i * j1 >> 8;
        int l1 = 0;
        i2 = 0;
        do
        {
label0:
            {
                if (l1 >= j)
                {
                    break label0;
                }
                int j2 = ai[l1] << 8;
                int k2 = j1 * ai1[l1];
                int l2;
                if (j2 > k2)
                {
                    l2 = j2 - k2;
                } else
                {
                    l2 = k2 - j2;
                }
                if (l2 > k1)
                {
                    continue; /* Loop/switch isn't completed */
                }
                i2 += l2;
                l1++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return i2 / i1;
    }

    private static BitMatrix a(BitMatrix bitmatrix, ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3, int i)
    {
        return GridSampler.getInstance().sampleGrid(bitmatrix, i, i, 0.0F, 0.0F, i, 0.0F, i, i, 0.0F, i, resultpoint.getX(), resultpoint.getY(), resultpoint2.getX(), resultpoint2.getY(), resultpoint3.getX(), resultpoint3.getY(), resultpoint1.getX(), resultpoint1.getY());
    }

    private static void a(ResultPoint aresultpoint[], boolean flag)
    {
        float f1;
        f1 = aresultpoint[4].getY() - aresultpoint[6].getY();
        if (flag)
        {
            f1 = -f1;
        }
        if (f1 <= 2.0F) goto _L2; else goto _L1
_L1:
        float f12 = aresultpoint[4].getX() - aresultpoint[0].getX();
        float f13 = aresultpoint[6].getX() - aresultpoint[0].getX();
        float f14 = (f12 * (aresultpoint[6].getY() - aresultpoint[0].getY())) / f13;
        aresultpoint[4] = new ResultPoint(aresultpoint[4].getX(), f14 + aresultpoint[4].getY());
_L8:
        float f5;
        f5 = aresultpoint[7].getY() - aresultpoint[5].getY();
        if (flag)
        {
            f5 = -f5;
        }
        if (f5 <= 2.0F) goto _L4; else goto _L3
_L3:
        float f9 = aresultpoint[5].getX() - aresultpoint[1].getX();
        float f10 = aresultpoint[7].getX() - aresultpoint[1].getX();
        float f11 = (f9 * (aresultpoint[7].getY() - aresultpoint[1].getY())) / f10;
        aresultpoint[5] = new ResultPoint(aresultpoint[5].getX(), f11 + aresultpoint[5].getY());
_L6:
        return;
_L2:
        if (-f1 > 2.0F)
        {
            float f2 = aresultpoint[2].getX() - aresultpoint[6].getX();
            float f3 = aresultpoint[2].getX() - aresultpoint[4].getX();
            float f4 = (f2 * (aresultpoint[2].getY() - aresultpoint[4].getY())) / f3;
            aresultpoint[6] = new ResultPoint(aresultpoint[6].getX(), aresultpoint[6].getY() - f4);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (-f5 <= 2.0F) goto _L6; else goto _L5
_L5:
        float f6 = aresultpoint[3].getX() - aresultpoint[7].getX();
        float f7 = aresultpoint[3].getX() - aresultpoint[5].getX();
        float f8 = (f6 * (aresultpoint[3].getY() - aresultpoint[5].getY())) / f7;
        aresultpoint[7] = new ResultPoint(aresultpoint[7].getX(), aresultpoint[7].getY() - f8);
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static int[] a(BitMatrix bitmatrix, int i, int j, int k, boolean flag, int ai[], int ai1[])
    {
        Arrays.fill(ai1, 0, ai1.length, 0);
        int l = ai.length;
        int i1 = 0;
        int j1 = i;
        int k1 = i;
        boolean flag1 = flag;
        while (j1 < i + k) 
        {
            if (flag1 ^ bitmatrix.get(j1, j))
            {
                ai1[i1] = 1 + ai1[i1];
            } else
            {
                if (i1 == l - 1)
                {
                    if (a(ai1, ai, 204) < 107)
                    {
                        return (new int[] {
                            k1, j1
                        });
                    }
                    k1 += ai1[0] + ai1[1];
                    System.arraycopy(ai1, 2, ai1, 0, l - 2);
                    ai1[l - 2] = 0;
                    ai1[l - 1] = 0;
                    i1--;
                } else
                {
                    i1++;
                }
                ai1[i1] = 1;
                if (!flag1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            j1++;
        }
        return null;
    }

    private static ResultPoint[] a(BitMatrix bitmatrix)
    {
        int i;
        int j;
        int k;
        ResultPoint aresultpoint[];
        int ai[];
        int l;
        i = 1;
        j = bitmatrix.getHeight();
        k = bitmatrix.getWidth();
        aresultpoint = new ResultPoint[8];
        ai = new int[d.length];
        l = 0;
_L21:
        int ai5[];
        if (l >= j)
        {
            break MISSING_BLOCK_LABEL_391;
        }
        ai5 = a(bitmatrix, 0, l, k, false, d, ai);
        if (ai5 == null) goto _L2; else goto _L1
_L1:
        int i1;
        aresultpoint[0] = new ResultPoint(ai5[0], l);
        aresultpoint[4] = new ResultPoint(ai5[i], l);
        i1 = i;
_L26:
        if (i1 == 0) goto _L4; else goto _L3
_L3:
        int l1 = j - 1;
_L22:
        if (l1 <= 0) goto _L6; else goto _L5
_L5:
        int ai4[] = a(bitmatrix, 0, l1, k, false, d, ai);
        if (ai4 == null) goto _L8; else goto _L7
_L7:
        aresultpoint[i] = new ResultPoint(ai4[0], l1);
        aresultpoint[5] = new ResultPoint(ai4[i], l1);
        i1 = i;
_L4:
        int ai1[] = new int[f.length];
        if (i1 == 0) goto _L10; else goto _L9
_L9:
        int k1 = 0;
_L23:
        if (k1 >= j) goto _L12; else goto _L11
_L11:
        int ai3[] = a(bitmatrix, 0, k1, k, false, f, ai1);
        if (ai3 == null) goto _L14; else goto _L13
_L13:
        aresultpoint[2] = new ResultPoint(ai3[i], k1);
        aresultpoint[6] = new ResultPoint(ai3[0], k1);
        i1 = i;
_L10:
        if (i1 == 0) goto _L16; else goto _L15
_L15:
        int j1 = j - 1;
_L24:
        if (j1 <= 0) goto _L18; else goto _L17
_L17:
        int ai2[] = a(bitmatrix, 0, j1, k, false, f, ai1);
        if (ai2 == null) goto _L20; else goto _L19
_L19:
        aresultpoint[3] = new ResultPoint(ai2[i], j1);
        aresultpoint[7] = new ResultPoint(ai2[0], j1);
_L25:
        if (i != 0)
        {
            return aresultpoint;
        } else
        {
            return null;
        }
_L2:
        l++;
          goto _L21
_L8:
        l1--;
          goto _L22
_L14:
        k1++;
          goto _L23
_L20:
        j1--;
          goto _L24
_L18:
        i = 0;
          goto _L25
_L16:
        i = i1;
          goto _L25
_L12:
        i1 = 0;
          goto _L10
_L6:
        i1 = 0;
          goto _L4
        i1 = 0;
          goto _L26
    }

    private static ResultPoint[] b(BitMatrix bitmatrix)
    {
        boolean flag;
        int i;
        int j;
        ResultPoint aresultpoint[];
        int ai[];
        int k;
        flag = true;
        i = bitmatrix.getHeight();
        j = bitmatrix.getWidth() >> 1;
        aresultpoint = new ResultPoint[8];
        ai = new int[e.length];
        k = i - 1;
_L21:
        int ai5[];
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_393;
        }
        ai5 = a(bitmatrix, j, k, j, flag, e, ai);
        if (ai5 == null) goto _L2; else goto _L1
_L1:
        int l;
        aresultpoint[0] = new ResultPoint(ai5[flag], k);
        aresultpoint[4] = new ResultPoint(ai5[0], k);
        l = ((flag) ? 1 : 0);
_L26:
        if (l == 0) goto _L4; else goto _L3
_L3:
        int k1 = 0;
_L22:
        if (k1 >= i) goto _L6; else goto _L5
_L5:
        int ai4[] = a(bitmatrix, j, k1, j, flag, e, ai);
        if (ai4 == null) goto _L8; else goto _L7
_L7:
        aresultpoint[flag] = new ResultPoint(ai4[flag], k1);
        aresultpoint[5] = new ResultPoint(ai4[0], k1);
        l = ((flag) ? 1 : 0);
_L4:
        int ai1[] = new int[g.length];
        if (l == 0) goto _L10; else goto _L9
_L9:
        int j1 = i - 1;
_L23:
        if (j1 <= 0) goto _L12; else goto _L11
_L11:
        int ai3[] = a(bitmatrix, 0, j1, j, false, g, ai1);
        if (ai3 == null) goto _L14; else goto _L13
_L13:
        aresultpoint[2] = new ResultPoint(ai3[0], j1);
        aresultpoint[6] = new ResultPoint(ai3[flag], j1);
        l = ((flag) ? 1 : 0);
_L10:
        if (l == 0) goto _L16; else goto _L15
_L15:
        int i1 = 0;
_L24:
        if (i1 >= i) goto _L18; else goto _L17
_L17:
        int ai2[] = a(bitmatrix, 0, i1, j, false, g, ai1);
        if (ai2 == null) goto _L20; else goto _L19
_L19:
        aresultpoint[3] = new ResultPoint(ai2[0], i1);
        aresultpoint[7] = new ResultPoint(ai2[flag], i1);
_L25:
        if (flag)
        {
            return aresultpoint;
        } else
        {
            return null;
        }
_L2:
        k--;
          goto _L21
_L8:
        k1++;
          goto _L22
_L14:
        j1--;
          goto _L23
_L20:
        i1++;
          goto _L24
_L18:
        flag = false;
          goto _L25
_L16:
        flag = l;
          goto _L25
_L12:
        l = 0;
          goto _L10
_L6:
        l = 0;
          goto _L4
        l = 0;
          goto _L26
    }

    public DetectorResult detect()
    {
        return detect(null);
    }

    public DetectorResult detect(Map map)
    {
        BitMatrix bitmatrix;
        ResultPoint aresultpoint[];
        bitmatrix = h.getBlackMatrix();
        aresultpoint = a(bitmatrix);
        if (aresultpoint != null) goto _L2; else goto _L1
_L1:
        aresultpoint = b(bitmatrix);
        if (aresultpoint == null) goto _L4; else goto _L3
_L3:
        ResultPoint aresultpoint1[];
        a(aresultpoint, true);
        aresultpoint1 = aresultpoint;
_L6:
        if (aresultpoint1 == null)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        break; /* Loop/switch isn't completed */
_L2:
        a(aresultpoint, false);
_L4:
        aresultpoint1 = aresultpoint;
        if (true) goto _L6; else goto _L5
_L5:
        float f1 = a(aresultpoint1);
        if (f1 < 1.0F)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        int i = a(aresultpoint1[4], aresultpoint1[6], aresultpoint1[5], aresultpoint1[7], f1);
        if (i < 1)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            BitMatrix bitmatrix1 = a(bitmatrix, aresultpoint1[4], aresultpoint1[5], aresultpoint1[6], aresultpoint1[7], i);
            ResultPoint aresultpoint2[] = new ResultPoint[4];
            aresultpoint2[0] = aresultpoint1[5];
            aresultpoint2[1] = aresultpoint1[4];
            aresultpoint2[2] = aresultpoint1[6];
            aresultpoint2[3] = aresultpoint1[7];
            return new DetectorResult(bitmatrix1, aresultpoint2);
        }
    }

}
