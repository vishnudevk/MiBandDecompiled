// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.aztec.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

// Referenced classes of package com.google.zxing.aztec.detector:
//            b

public final class Detector
{

    private final BitMatrix a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;

    public Detector(BitMatrix bitmatrix)
    {
        a = bitmatrix;
    }

    private static int a(float f1)
    {
        return (int)(0.5F + f1);
    }

    private int a(b b1, b b2)
    {
        float f1 = b(b1, b2);
        float f2 = (float)(b2.a - b1.a) / f1;
        float f3 = (float)(b2.b - b1.b) / f1;
        float f4 = b1.a;
        float f5 = b1.b;
        boolean flag = a.get(b1.a, b1.b);
        int i = 0;
        float f6 = f4;
        float f7 = f5;
        for (int j = 0; (float)j < f1; j++)
        {
            f6 += f2;
            f7 += f3;
            if (a.get(a(f6), a(f7)) != flag)
            {
                i++;
            }
        }

        float f8 = (float)i / f1;
        if ((double)f8 > 0.10000000000000001D && (double)f8 < 0.90000000000000002D)
        {
            return 0;
        }
        if ((double)f8 <= 0.10000000000000001D)
        {
            return !flag ? -1 : 1;
        }
        return !flag ? 1 : -1;
    }

    private b a()
    {
        ResultPoint resultpoint;
        ResultPoint resultpoint1;
        ResultPoint resultpoint2;
        ResultPoint resultpoint3;
        int k;
        int l;
        ResultPoint resultpoint4;
        ResultPoint resultpoint5;
        ResultPoint resultpoint6;
        ResultPoint resultpoint7;
        try
        {
            ResultPoint aresultpoint1[] = (new WhiteRectangleDetector(a)).detect();
            resultpoint = aresultpoint1[0];
            resultpoint1 = aresultpoint1[1];
            resultpoint2 = aresultpoint1[2];
            resultpoint3 = aresultpoint1[3];
        }
        catch (NotFoundException notfoundexception)
        {
            int i = a.getWidth() / 2;
            int j = a.getHeight() / 2;
            resultpoint = a(new b(i + 7, j - 7, null), false, 1, -1).a();
            resultpoint1 = a(new b(i + 7, j + 7, null), false, 1, 1).a();
            resultpoint2 = a(new b(i - 7, j + 7, null), false, -1, 1).a();
            resultpoint3 = a(new b(i - 7, j - 7, null), false, -1, -1).a();
        }
        k = a((resultpoint.getX() + resultpoint3.getX() + resultpoint1.getX() + resultpoint2.getX()) / 4F);
        l = a((resultpoint.getY() + resultpoint3.getY() + resultpoint1.getY() + resultpoint2.getY()) / 4F);
        try
        {
            ResultPoint aresultpoint[] = (new WhiteRectangleDetector(a, 15, k, l)).detect();
            resultpoint4 = aresultpoint[0];
            resultpoint5 = aresultpoint[1];
            resultpoint6 = aresultpoint[2];
            resultpoint7 = aresultpoint[3];
        }
        catch (NotFoundException notfoundexception1)
        {
            resultpoint4 = a(new b(k + 7, l - 7, null), false, 1, -1).a();
            resultpoint5 = a(new b(k + 7, l + 7, null), false, 1, 1).a();
            resultpoint6 = a(new b(k - 7, l + 7, null), false, -1, 1).a();
            resultpoint7 = a(new b(k - 7, l - 7, null), false, -1, -1).a();
        }
        return new b(a((resultpoint4.getX() + resultpoint7.getX() + resultpoint5.getX() + resultpoint6.getX()) / 4F), a((resultpoint4.getY() + resultpoint7.getY() + resultpoint5.getY() + resultpoint6.getY()) / 4F), null);
    }

    private b a(b b1, boolean flag, int i, int j)
    {
        int k = i + b1.a;
        int l;
        for (l = j + b1.b; a(k, l) && a.get(k, l) == flag; l += j)
        {
            k += i;
        }

        int i1 = k - i;
        int j1 = l - j;
        int k1;
        for (k1 = i1; a(k1, j1) && a.get(k1, j1) == flag; k1 += i) { }
        int l1 = k1 - i;
        int i2;
        for (i2 = j1; a(l1, i2) && a.get(l1, i2) == flag; i2 += j) { }
        return new b(l1, i2 - j, null);
    }

    private BitMatrix a(BitMatrix bitmatrix, ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3)
    {
        int i;
        GridSampler gridsampler;
        float f1;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        if (b)
        {
            i = 11 + 4 * c;
        } else
        if (c <= 4)
        {
            i = 15 + 4 * c;
        } else
        {
            i = 15 + (4 * c + 2 * (1 + (-4 + c) / 8));
        }
        gridsampler = GridSampler.getInstance();
        f1 = (float)i - 0.5F;
        f2 = (float)i - 0.5F;
        f3 = (float)i - 0.5F;
        f4 = (float)i - 0.5F;
        f5 = resultpoint.getX();
        f6 = resultpoint.getY();
        f7 = resultpoint3.getX();
        f8 = resultpoint3.getY();
        f9 = resultpoint2.getX();
        f10 = resultpoint2.getY();
        f11 = resultpoint1.getX();
        f12 = resultpoint1.getY();
        return gridsampler.sampleGrid(bitmatrix, i, i, 0.5F, 0.5F, f1, 0.5F, f2, f3, 0.5F, f4, f5, f6, f7, f8, f9, f10, f11, f12);
    }

    private void a(b ab[])
    {
        int i = 0;
        boolean aflag[] = a(ab[0], ab[1], 1 + 2 * e);
        boolean aflag1[] = a(ab[1], ab[2], 1 + 2 * e);
        boolean aflag2[] = a(ab[2], ab[3], 1 + 2 * e);
        boolean aflag3[] = a(ab[3], ab[0], 1 + 2 * e);
        if (aflag[0] && aflag[2 * e])
        {
            f = 0;
        } else
        if (aflag1[0] && aflag1[2 * e])
        {
            f = 1;
        } else
        if (aflag2[0] && aflag2[2 * e])
        {
            f = 2;
        } else
        if (aflag3[0] && aflag3[2 * e])
        {
            f = 3;
        } else
        {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean aflag5[];
        if (b)
        {
            boolean aflag6[] = new boolean[28];
            for (int k = 0; k < 7; k++)
            {
                aflag6[k] = aflag[k + 2];
                aflag6[k + 7] = aflag1[k + 2];
                aflag6[k + 14] = aflag2[k + 2];
                aflag6[k + 21] = aflag3[k + 2];
            }

            aflag5 = new boolean[28];
            for (; i < 28; i++)
            {
                aflag5[i] = aflag6[(i + 7 * f) % 28];
            }

        } else
        {
            boolean aflag4[] = new boolean[40];
            for (int j = 0; j < 11; j++)
            {
                if (j < 5)
                {
                    aflag4[j] = aflag[j + 2];
                    aflag4[j + 10] = aflag1[j + 2];
                    aflag4[j + 20] = aflag2[j + 2];
                    aflag4[j + 30] = aflag3[j + 2];
                }
                if (j > 5)
                {
                    aflag4[j - 1] = aflag[j + 2];
                    aflag4[-1 + (j + 10)] = aflag1[j + 2];
                    aflag4[-1 + (j + 20)] = aflag2[j + 2];
                    aflag4[-1 + (j + 30)] = aflag3[j + 2];
                }
            }

            aflag5 = new boolean[40];
            for (; i < 40; i++)
            {
                aflag5[i] = aflag4[(i + 10 * f) % 40];
            }

        }
        a(aflag5, b);
        a(aflag5);
    }

    private void a(boolean aflag[])
    {
        byte byte0;
        byte byte1;
        int i;
        if (b)
        {
            byte0 = 2;
            byte1 = 6;
        } else
        {
            byte0 = 5;
            byte1 = 11;
        }
        for (i = 0; i < byte0; i++)
        {
            c = c << 1;
            if (aflag[i])
            {
                c = 1 + c;
            }
        }

        for (int j = byte0; j < byte0 + byte1; j++)
        {
            d = d << 1;
            if (aflag[j])
            {
                d = 1 + d;
            }
        }

        c = 1 + c;
        d = 1 + d;
    }

    private static void a(boolean aflag[], boolean flag)
    {
        byte byte0;
        byte byte1;
        int i;
        int ai[];
        if (flag)
        {
            byte0 = 7;
            byte1 = 2;
        } else
        {
            byte0 = 10;
            byte1 = 4;
        }
        i = byte0 - byte1;
        ai = new int[byte0];
        for (int j = 0; j < byte0; j++)
        {
            int k1 = 1;
            int l1 = 1;
            for (; k1 <= 4; k1++)
            {
                if (aflag[(4 + 4 * j) - k1])
                {
                    ai[j] = l1 + ai[j];
                }
                l1 <<= 1;
            }

        }

        int k;
        try
        {
            (new ReedSolomonDecoder(GenericGF.AZTEC_PARAM)).decode(ai, i);
        }
        catch (ReedSolomonException reedsolomonexception)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        for (k = 0; k < byte1; k++)
        {
            int l = 1;
            int i1 = 1;
            while (l <= 4) 
            {
                int j1 = (4 + k * 4) - l;
                boolean flag1;
                if ((i1 & ai[k]) == i1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                aflag[j1] = flag1;
                i1 <<= 1;
                l++;
            }
        }

    }

    private boolean a(int i, int j)
    {
        return i >= 0 && i < a.getWidth() && j > 0 && j < a.getHeight();
    }

    private boolean a(b b1, b b2, b b3, b b4)
    {
        b b5 = new b(b1.a - 3, 3 + b1.b, null);
        b b6 = new b(b2.a - 3, b2.b - 3, null);
        b b7 = new b(3 + b3.a, b3.b - 3, null);
        b b8 = new b(3 + b4.a, 3 + b4.b, null);
        for (int i = a(b8, b5); i == 0 || a(b5, b6) != i || a(b6, b7) != i || a(b7, b8) != i;)
        {
            return false;
        }

        return true;
    }

    private b[] a(b b1)
    {
        boolean flag = true;
        e = 1;
        b b2 = b1;
        b b3 = b1;
        b b4 = b1;
label0:
        do
        {
            b b5;
            b b6;
            b b7;
            b b8;
label1:
            {
                if (e < 9)
                {
                    b5 = a(b4, flag, 1, -1);
                    b6 = a(b3, flag, 1, 1);
                    b7 = a(b2, flag, -1, 1);
                    b8 = a(b1, flag, -1, -1);
                    if (e <= 2)
                    {
                        break label1;
                    }
                    float f2 = (b(b8, b5) * (float)e) / (b(b1, b4) * (float)(2 + e));
                    if ((double)f2 >= 0.75D && (double)f2 <= 1.25D && a(b5, b6, b7, b8))
                    {
                        break label1;
                    }
                }
                if (e != 5 && e != 7)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                break label0;
            }
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            e = 1 + e;
            b1 = b8;
            b2 = b7;
            b3 = b6;
            b4 = b5;
        } while (true);
        boolean flag1;
        float f1;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        if (e == 5)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        b = flag1;
        f1 = 1.5F / (float)(-3 + 2 * e);
        i = b4.a - b2.a;
        j = b4.b - b2.b;
        k = a((float)b2.a - f1 * (float)i);
        l = a((float)b2.b - f1 * (float)j);
        i1 = a((float)b4.a + f1 * (float)i);
        j1 = a((float)b4.b + f1 * (float)j);
        k1 = b3.a - b1.a;
        l1 = b3.b - b1.b;
        i2 = a((float)b1.a - f1 * (float)k1);
        j2 = a((float)b1.b - f1 * (float)l1);
        k2 = a((float)b3.a + f1 * (float)k1);
        l2 = a((float)b3.b + f1 * (float)l1);
        if (!a(i1, j1) || !a(k2, l2) || !a(k, l) || !a(i2, j2))
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            return (new b[] {
                new b(i1, j1, null), new b(k2, l2, null), new b(k, l, null), new b(i2, j2, null)
            });
        }
    }

    private boolean[] a(b b1, b b2, int i)
    {
        boolean aflag[] = new boolean[i];
        float f1 = b(b1, b2);
        float f2 = f1 / (float)(i - 1);
        float f3 = (f2 * (float)(b2.a - b1.a)) / f1;
        float f4 = (f2 * (float)(b2.b - b1.b)) / f1;
        float f5 = b1.a;
        float f6 = b1.b;
        for (int j = 0; j < i; j++)
        {
            aflag[j] = a.get(a(f5), a(f6));
            f5 += f3;
            f6 += f4;
        }

        return aflag;
    }

    private static float b(b b1, b b2)
    {
        return (float)Math.sqrt((b1.a - b2.a) * (b1.a - b2.a) + (b1.b - b2.b) * (b1.b - b2.b));
    }

    private ResultPoint[] b(b ab[])
    {
        byte byte0 = -1;
        int i = 2 * c;
        int j;
        float f1;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        if (c > 4)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        f1 = (float)(j + i + (-4 + c) / 8) / (2.0F * (float)e);
        k = ab[0].a - ab[2].a;
        if (k > 0)
        {
            l = 1;
        } else
        {
            l = byte0;
        }
        i1 = k + l;
        j1 = ab[0].b - ab[2].b;
        if (j1 > 0)
        {
            k1 = 1;
        } else
        {
            k1 = byte0;
        }
        l1 = k1 + j1;
        i2 = a((float)ab[2].a - f1 * (float)i1);
        j2 = a((float)ab[2].b - f1 * (float)l1);
        k2 = a((float)ab[0].a + f1 * (float)i1);
        l2 = a((float)ab[0].b + f1 * (float)l1);
        i3 = ab[1].a - ab[3].a;
        if (i3 > 0)
        {
            j3 = 1;
        } else
        {
            j3 = byte0;
        }
        k3 = j3 + i3;
        l3 = ab[1].b - ab[3].b;
        if (l3 > 0)
        {
            byte0 = 1;
        }
        i4 = byte0 + l3;
        j4 = a((float)ab[3].a - f1 * (float)k3);
        k4 = a((float)ab[3].b - f1 * (float)i4);
        l4 = a((float)ab[1].a + f1 * (float)k3);
        i5 = a((float)ab[1].b + f1 * (float)i4);
        if (!a(k2, l2) || !a(l4, i5) || !a(i2, j2) || !a(j4, k4))
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            ResultPoint aresultpoint[] = new ResultPoint[4];
            aresultpoint[0] = new ResultPoint(k2, l2);
            aresultpoint[1] = new ResultPoint(l4, i5);
            aresultpoint[2] = new ResultPoint(i2, j2);
            aresultpoint[3] = new ResultPoint(j4, k4);
            return aresultpoint;
        }
    }

    public AztecDetectorResult detect()
    {
        b ab[] = a(a());
        a(ab);
        ResultPoint aresultpoint[] = b(ab);
        return new AztecDetectorResult(a(a, aresultpoint[f % 4], aresultpoint[(3 + f) % 4], aresultpoint[(2 + f) % 4], aresultpoint[(1 + f) % 4]), aresultpoint, b, d, c);
    }
}
