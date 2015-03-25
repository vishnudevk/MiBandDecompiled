// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.zxing.datamatrix.detector:
//            b, c

public final class Detector
{

    private final BitMatrix a;
    private final WhiteRectangleDetector b;

    public Detector(BitMatrix bitmatrix)
    {
        a = bitmatrix;
        b = new WhiteRectangleDetector(bitmatrix);
    }

    private static int a(float f)
    {
        return (int)(0.5F + f);
    }

    private static int a(ResultPoint resultpoint, ResultPoint resultpoint1)
    {
        return a((float)Math.sqrt((resultpoint.getX() - resultpoint1.getX()) * (resultpoint.getX() - resultpoint1.getX()) + (resultpoint.getY() - resultpoint1.getY()) * (resultpoint.getY() - resultpoint1.getY())));
    }

    private ResultPoint a(ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3, int i)
    {
        ResultPoint resultpoint4;
        ResultPoint resultpoint5;
        float f = (float)a(resultpoint, resultpoint1) / (float)i;
        int j = a(resultpoint2, resultpoint3);
        float f1 = (resultpoint3.getX() - resultpoint2.getX()) / (float)j;
        float f2 = (resultpoint3.getY() - resultpoint2.getY()) / (float)j;
        resultpoint4 = new ResultPoint(resultpoint3.getX() + f1 * f, resultpoint3.getY() + f * f2);
        float f3 = (float)a(resultpoint, resultpoint1) / (float)i;
        int k = a(resultpoint1, resultpoint3);
        float f4 = (resultpoint3.getX() - resultpoint1.getX()) / (float)k;
        float f5 = (resultpoint3.getY() - resultpoint1.getY()) / (float)k;
        resultpoint5 = new ResultPoint(resultpoint3.getX() + f4 * f3, resultpoint3.getY() + f3 * f5);
        if (a(resultpoint4)) goto _L2; else goto _L1
_L1:
        if (!a(resultpoint5)) goto _L4; else goto _L3
_L3:
        resultpoint4 = resultpoint5;
_L6:
        return resultpoint4;
_L4:
        return null;
_L2:
        if (a(resultpoint5) && Math.abs(b(resultpoint2, resultpoint4).c() - b(resultpoint1, resultpoint4).c()) > Math.abs(b(resultpoint2, resultpoint5).c() - b(resultpoint1, resultpoint5).c()))
        {
            return resultpoint5;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private ResultPoint a(ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3, int i, int j)
    {
        ResultPoint resultpoint4;
        ResultPoint resultpoint5;
        float f = (float)a(resultpoint, resultpoint1) / (float)i;
        int k = a(resultpoint2, resultpoint3);
        float f1 = (resultpoint3.getX() - resultpoint2.getX()) / (float)k;
        float f2 = (resultpoint3.getY() - resultpoint2.getY()) / (float)k;
        resultpoint4 = new ResultPoint(resultpoint3.getX() + f1 * f, resultpoint3.getY() + f * f2);
        float f3 = (float)a(resultpoint, resultpoint2) / (float)j;
        int l = a(resultpoint1, resultpoint3);
        float f4 = (resultpoint3.getX() - resultpoint1.getX()) / (float)l;
        float f5 = (resultpoint3.getY() - resultpoint1.getY()) / (float)l;
        resultpoint5 = new ResultPoint(resultpoint3.getX() + f4 * f3, resultpoint3.getY() + f3 * f5);
        if (a(resultpoint4)) goto _L2; else goto _L1
_L1:
        if (!a(resultpoint5)) goto _L4; else goto _L3
_L3:
        return resultpoint5;
_L4:
        return null;
_L2:
        if (!a(resultpoint5))
        {
            return resultpoint4;
        }
        if (Math.abs(i - b(resultpoint2, resultpoint4).c()) + Math.abs(j - b(resultpoint1, resultpoint4).c()) <= Math.abs(i - b(resultpoint2, resultpoint5).c()) + Math.abs(j - b(resultpoint1, resultpoint5).c()))
        {
            return resultpoint4;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private static BitMatrix a(BitMatrix bitmatrix, ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3, int i, int j)
    {
        return GridSampler.getInstance().sampleGrid(bitmatrix, i, j, 0.5F, 0.5F, (float)i - 0.5F, 0.5F, (float)i - 0.5F, (float)j - 0.5F, 0.5F, (float)j - 0.5F, resultpoint.getX(), resultpoint.getY(), resultpoint3.getX(), resultpoint3.getY(), resultpoint2.getX(), resultpoint2.getY(), resultpoint1.getX(), resultpoint1.getY());
    }

    private static void a(Map map, ResultPoint resultpoint)
    {
        Integer integer = (Integer)map.get(resultpoint);
        int i;
        if (integer == null)
        {
            i = 1;
        } else
        {
            i = 1 + integer.intValue();
        }
        map.put(resultpoint, Integer.valueOf(i));
    }

    private boolean a(ResultPoint resultpoint)
    {
        return resultpoint.getX() >= 0.0F && resultpoint.getX() < (float)a.getWidth() && resultpoint.getY() > 0.0F && resultpoint.getY() < (float)a.getHeight();
    }

    private b b(ResultPoint resultpoint, ResultPoint resultpoint1)
    {
        int i = (int)resultpoint.getX();
        int j = (int)resultpoint.getY();
        int k = (int)resultpoint1.getX();
        int l = (int)resultpoint1.getY();
        boolean flag;
        int k1;
        int l1;
        int i2;
        byte byte0;
        byte byte1;
        int j2;
        BitMatrix bitmatrix;
        int k2;
        int l2;
        boolean flag1;
        int i3;
        int j3;
        int k3;
        BitMatrix bitmatrix1;
        int l3;
        int i4;
        boolean flag2;
        int j4;
        if (Math.abs(l - j) > Math.abs(k - i))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            int i1 = l;
            l = k;
            k = i1;
            int j1 = j;
            j = i;
            i = j1;
        }
        k1 = Math.abs(l - j);
        l1 = Math.abs(k - i);
        i2 = -k1 >> 1;
        if (i < k)
        {
            byte0 = 1;
        } else
        {
            byte0 = -1;
        }
        if (j < l)
        {
            byte1 = 1;
        } else
        {
            byte1 = -1;
        }
        j2 = 0;
        bitmatrix = a;
        if (flag)
        {
            k2 = i;
        } else
        {
            k2 = j;
        }
        if (flag)
        {
            l2 = j;
        } else
        {
            l2 = i;
        }
        flag1 = bitmatrix.get(k2, l2);
        i3 = i;
        j3 = i2;
        if (j == l) goto _L2; else goto _L1
_L1:
        bitmatrix1 = a;
        if (flag)
        {
            l3 = i3;
        } else
        {
            l3 = j;
        }
        if (flag)
        {
            i4 = j;
        } else
        {
            i4 = i3;
        }
        flag2 = bitmatrix1.get(l3, i4);
        if (flag2 != flag1)
        {
            j2++;
            flag1 = flag2;
        }
        j4 = j3 + l1;
        if (j4 <= 0) goto _L4; else goto _L3
_L3:
        if (i3 != k) goto _L6; else goto _L5
_L5:
        k3 = j2;
_L8:
        return new b(resultpoint, resultpoint1, k3, null);
_L6:
        i3 += byte0;
        j4 -= k1;
_L4:
        j += byte1;
        j3 = j4;
        break MISSING_BLOCK_LABEL_142;
_L2:
        k3 = j2;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public DetectorResult detect()
    {
        ResultPoint aresultpoint[] = b.detect();
        ResultPoint resultpoint = aresultpoint[0];
        ResultPoint resultpoint1 = aresultpoint[1];
        ResultPoint resultpoint2 = aresultpoint[2];
        ResultPoint resultpoint3 = aresultpoint[3];
        ArrayList arraylist = new ArrayList(4);
        arraylist.add(b(resultpoint, resultpoint1));
        arraylist.add(b(resultpoint, resultpoint2));
        arraylist.add(b(resultpoint1, resultpoint3));
        arraylist.add(b(resultpoint2, resultpoint3));
        Collections.sort(arraylist, new c(null));
        b b1 = (b)arraylist.get(0);
        b b2 = (b)arraylist.get(1);
        HashMap hashmap = new HashMap();
        a(hashmap, b1.a());
        a(hashmap, b1.b());
        a(hashmap, b2.a());
        a(hashmap, b2.b());
        ResultPoint resultpoint4 = null;
        ResultPoint resultpoint5 = null;
        ResultPoint resultpoint6 = null;
        Iterator iterator = hashmap.entrySet().iterator();
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            ResultPoint resultpoint12 = (ResultPoint)entry.getKey();
            ResultPoint resultpoint13;
            ResultPoint resultpoint14;
            if (((Integer)entry.getValue()).intValue() == 2)
            {
                resultpoint13 = resultpoint12;
                resultpoint12 = resultpoint6;
                resultpoint14 = resultpoint4;
            } else
            if (resultpoint4 == null)
            {
                resultpoint13 = resultpoint5;
                ResultPoint resultpoint15 = resultpoint6;
                resultpoint14 = resultpoint12;
                resultpoint12 = resultpoint15;
            } else
            {
                resultpoint13 = resultpoint5;
                resultpoint14 = resultpoint4;
            }
            resultpoint5 = resultpoint13;
            resultpoint4 = resultpoint14;
            resultpoint6 = resultpoint12;
        }
        if (resultpoint4 == null || resultpoint5 == null || resultpoint6 == null)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint aresultpoint1[] = {
            resultpoint4, resultpoint5, resultpoint6
        };
        ResultPoint.orderBestPatterns(aresultpoint1);
        ResultPoint resultpoint7 = aresultpoint1[0];
        ResultPoint resultpoint8 = aresultpoint1[1];
        ResultPoint resultpoint9 = aresultpoint1[2];
        ResultPoint resultpoint10;
        int i;
        int j;
        int k;
        int l;
        ResultPoint resultpoint11;
        BitMatrix bitmatrix;
        if (!hashmap.containsKey(resultpoint))
        {
            resultpoint10 = resultpoint;
        } else
        if (!hashmap.containsKey(resultpoint1))
        {
            resultpoint10 = resultpoint1;
        } else
        if (!hashmap.containsKey(resultpoint2))
        {
            resultpoint10 = resultpoint2;
        } else
        {
            resultpoint10 = resultpoint3;
        }
        i = b(resultpoint9, resultpoint10).c();
        j = b(resultpoint7, resultpoint10).c();
        if ((i & 1) == 1)
        {
            i++;
        }
        k = i + 2;
        if ((j & 1) == 1)
        {
            j++;
        }
        l = j + 2;
        if (k * 4 >= l * 7 || l * 4 >= k * 7)
        {
            resultpoint11 = a(resultpoint8, resultpoint7, resultpoint9, resultpoint10, k, l);
            if (resultpoint11 == null)
            {
                resultpoint11 = resultpoint10;
            }
            int i1 = b(resultpoint9, resultpoint11).c();
            int j1 = b(resultpoint7, resultpoint11).c();
            if ((i1 & 1) == 1)
            {
                i1++;
            }
            if ((j1 & 1) == 1)
            {
                j1++;
            }
            bitmatrix = a(a, resultpoint9, resultpoint8, resultpoint7, resultpoint11, i1, j1);
        } else
        {
            resultpoint11 = a(resultpoint8, resultpoint7, resultpoint9, resultpoint10, Math.min(l, k));
            if (resultpoint11 == null)
            {
                resultpoint11 = resultpoint10;
            }
            int k1 = 1 + Math.max(b(resultpoint9, resultpoint11).c(), b(resultpoint7, resultpoint11).c());
            if ((k1 & 1) == 1)
            {
                k1++;
            }
            bitmatrix = a(a, resultpoint9, resultpoint8, resultpoint7, resultpoint11, k1, k1);
        }
        return new DetectorResult(bitmatrix, new ResultPoint[] {
            resultpoint9, resultpoint8, resultpoint7, resultpoint11
        });
    }
}
