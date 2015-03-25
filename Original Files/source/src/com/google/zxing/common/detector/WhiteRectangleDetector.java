// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector
{

    private static final int a = 30;
    private static final int b = 1;
    private final BitMatrix c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;

    public WhiteRectangleDetector(BitMatrix bitmatrix)
    {
        c = bitmatrix;
        d = bitmatrix.getHeight();
        e = bitmatrix.getWidth();
        f = -30 + e >> 1;
        g = 30 + e >> 1;
        i = -30 + d >> 1;
        h = 30 + d >> 1;
        if (i < 0 || f < 0 || h >= d || g >= e)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            return;
        }
    }

    public WhiteRectangleDetector(BitMatrix bitmatrix, int j, int k, int l)
    {
        c = bitmatrix;
        d = bitmatrix.getHeight();
        e = bitmatrix.getWidth();
        int i1 = j >> 1;
        f = k - i1;
        g = k + i1;
        i = l - i1;
        h = i1 + l;
        if (i < 0 || f < 0 || h >= d || g >= e)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            return;
        }
    }

    private static int a(float f1)
    {
        return (int)(0.5F + f1);
    }

    private ResultPoint a(float f1, float f2, float f3, float f4)
    {
        int j = b(f1, f2, f3, f4);
        float f5 = (f3 - f1) / (float)j;
        float f6 = (f4 - f2) / (float)j;
        for (int k = 0; k < j; k++)
        {
            int l = a(f1 + f5 * (float)k);
            int i1 = a(f2 + f6 * (float)k);
            if (c.get(l, i1))
            {
                return new ResultPoint(l, i1);
            }
        }

        return null;
    }

    private boolean a(int j, int k, int l, boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        for (; j <= k; j++)
        {
            if (c.get(j, l))
            {
                return true;
            }
        }

          goto _L3
_L4:
        j++;
_L2:
        if (j > k)
        {
            break; /* Loop/switch isn't completed */
        }
        if (c.get(l, j))
        {
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        return false;
    }

    private ResultPoint[] a(ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3)
    {
        float f1 = resultpoint.getX();
        float f2 = resultpoint.getY();
        float f3 = resultpoint1.getX();
        float f4 = resultpoint1.getY();
        float f5 = resultpoint2.getX();
        float f6 = resultpoint2.getY();
        float f7 = resultpoint3.getX();
        float f8 = resultpoint3.getY();
        if (f1 < (float)(e / 2))
        {
            ResultPoint aresultpoint1[] = new ResultPoint[4];
            aresultpoint1[0] = new ResultPoint(f7 - 1.0F, f8 + 1.0F);
            aresultpoint1[1] = new ResultPoint(f3 + 1.0F, f4 + 1.0F);
            aresultpoint1[2] = new ResultPoint(f5 - 1.0F, f6 - 1.0F);
            aresultpoint1[3] = new ResultPoint(f1 + 1.0F, f2 - 1.0F);
            return aresultpoint1;
        } else
        {
            ResultPoint aresultpoint[] = new ResultPoint[4];
            aresultpoint[0] = new ResultPoint(f7 + 1.0F, f8 + 1.0F);
            aresultpoint[1] = new ResultPoint(f3 + 1.0F, f4 - 1.0F);
            aresultpoint[2] = new ResultPoint(f5 - 1.0F, f6 + 1.0F);
            aresultpoint[3] = new ResultPoint(f1 - 1.0F, f2 - 1.0F);
            return aresultpoint;
        }
    }

    private static int b(float f1, float f2, float f3, float f4)
    {
        float f5 = f1 - f3;
        float f6 = f2 - f4;
        return a((float)Math.sqrt(f5 * f5 + f6 * f6));
    }

    public ResultPoint[] detect()
    {
        boolean flag;
        int j;
        int k;
        int l;
        int i1;
        boolean flag1;
        int j1;
        flag = true;
        j = f;
        k = g;
        l = i;
        i1 = h;
        flag1 = false;
        j1 = ((flag) ? 1 : 0);
_L1:
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        ResultPoint resultpoint;
        ResultPoint resultpoint1;
        if (j1 == 0)
        {
            break MISSING_BLOCK_LABEL_605;
        }
        int l3 = ((flag) ? 1 : 0);
        int i4 = 0;
        do
        {
            if (l3 == 0 || k >= e)
            {
                break;
            }
            l3 = a(l, i1, k, false);
            if (l3 != 0)
            {
                k++;
                i4 = ((flag) ? 1 : 0);
            }
        } while (true);
        if (k >= e)
        {
            k2 = ((flag) ? 1 : 0);
            k1 = k;
            l1 = i1;
            i2 = j;
            j2 = l;
        } else
        {
            int j4 = ((flag) ? 1 : 0);
            do
            {
                if (j4 == 0 || i1 >= d)
                {
                    break;
                }
                j4 = a(j, k, i1, flag);
                if (j4 != 0)
                {
                    i1++;
                    i4 = ((flag) ? 1 : 0);
                }
            } while (true);
            if (i1 >= d)
            {
                k2 = ((flag) ? 1 : 0);
                k1 = k;
                l1 = i1;
                i2 = j;
                j2 = l;
            } else
            {
                boolean flag2 = flag;
                do
                {
                    if (!flag2 || j < 0)
                    {
                        break;
                    }
                    flag2 = a(l, i1, j, false);
                    if (flag2)
                    {
                        j--;
                        i4 = ((flag) ? 1 : 0);
                    }
                } while (true);
                if (j < 0)
                {
                    k2 = ((flag) ? 1 : 0);
                    k1 = k;
                    l1 = i1;
                    i2 = j;
                    j2 = l;
                } else
                {
label0:
                    {
                        j1 = i4;
                        boolean flag3 = flag;
                        do
                        {
                            if (!flag3 || l < 0)
                            {
                                break;
                            }
                            flag3 = a(j, k, l, flag);
                            if (flag3)
                            {
                                l--;
                                j1 = ((flag) ? 1 : 0);
                            }
                        } while (true);
                        if (l >= 0)
                        {
                            break label0;
                        }
                        k2 = ((flag) ? 1 : 0);
                        k1 = k;
                        l1 = i1;
                        i2 = j;
                        j2 = l;
                    }
                }
            }
        }
_L5:
        if (k2 == 0 && flag1)
        {
            l2 = k1 - i2;
            i3 = ((flag) ? 1 : 0);
            resultpoint = null;
            break MISSING_BLOCK_LABEL_128;
        } else
        {
            throw NotFoundException.getNotFoundInstance();
        }
        if (j1 != 0)
        {
            flag1 = flag;
        }
          goto _L1
        do
        {
            {
                if (i3 >= l2)
                {
                    break MISSING_BLOCK_LABEL_598;
                }
                resultpoint = a(i2, l1 - i3, i2 + i3, l1);
                if (resultpoint != null)
                {
                    resultpoint1 = resultpoint;
                    break MISSING_BLOCK_LABEL_168;
                }
                i3++;
            }
        } while (true);
_L2:
        if (resultpoint5 == null)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint resultpoint6 = null;
        do
        {
label1:
            {
                if (flag < l2)
                {
                    resultpoint6 = a(k1, l1 - flag, k1 - flag, l1);
                    if (resultpoint6 == null)
                    {
                        break label1;
                    }
                }
                if (resultpoint6 == null)
                {
                    throw NotFoundException.getNotFoundInstance();
                } else
                {
                    return a(resultpoint6, resultpoint1, resultpoint5, resultpoint3);
                }
            }
            flag++;
        } while (true);
_L4:
        if (resultpoint1 == null)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        int j3 = ((flag) ? 1 : 0);
        ResultPoint resultpoint2 = null;
        ResultPoint resultpoint3;
        int k3;
        ResultPoint resultpoint4;
        ResultPoint resultpoint5;
        for (; j3 < l2; j3++)
        {
            resultpoint2 = a(i2, j2 + j3, i2 + j3, j2);
            if (resultpoint2 != null)
            {
                resultpoint3 = resultpoint2;
                break MISSING_BLOCK_LABEL_440;
            }
        }

        resultpoint3 = resultpoint2;
        if (resultpoint3 == null)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        k3 = ((flag) ? 1 : 0);
        resultpoint4 = null;
        for (; k3 < l2; k3++)
        {
            resultpoint4 = a(k1, j2 + k3, k1 - k3, j2);
            if (resultpoint4 != null)
            {
                resultpoint5 = resultpoint4;
                break MISSING_BLOCK_LABEL_501;
            }
        }

        resultpoint5 = resultpoint4;
          goto _L2
        resultpoint1 = resultpoint;
        if (true) goto _L4; else goto _L3
_L3:
        k1 = k;
        l1 = i1;
        i2 = j;
        j2 = l;
        k2 = 0;
          goto _L5
    }
}
