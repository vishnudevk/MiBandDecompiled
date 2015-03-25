// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.zxing.qrcode.detector:
//            FinderPattern, d, c, FinderPatternInfo

public class FinderPatternFinder
{

    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;
    private static final int a = 2;
    private static final int b = 8;
    private final BitMatrix c;
    private final List d;
    private boolean e;
    private final int f[];
    private final ResultPointCallback g;

    public FinderPatternFinder(BitMatrix bitmatrix)
    {
        this(bitmatrix, null);
    }

    public FinderPatternFinder(BitMatrix bitmatrix, ResultPointCallback resultpointcallback)
    {
        c = bitmatrix;
        d = new ArrayList();
        f = new int[5];
        g = resultpointcallback;
    }

    private float a(int i, int j, int k, int l)
    {
        BitMatrix bitmatrix = c;
        int i1 = bitmatrix.getHeight();
        int ai[] = a();
        int j1;
        for (j1 = i; j1 >= 0 && bitmatrix.get(j, j1); j1--)
        {
            ai[2] = 1 + ai[2];
        }

        if (j1 >= 0)
        {
            for (; j1 >= 0 && !bitmatrix.get(j, j1) && ai[1] <= k; j1--)
            {
                ai[1] = 1 + ai[1];
            }

            if (j1 >= 0 && ai[1] <= k)
            {
                for (; j1 >= 0 && bitmatrix.get(j, j1) && ai[0] <= k; j1--)
                {
                    ai[0] = 1 + ai[0];
                }

                if (ai[0] <= k)
                {
                    int k1;
                    for (k1 = i + 1; k1 < i1 && bitmatrix.get(j, k1); k1++)
                    {
                        ai[2] = 1 + ai[2];
                    }

                    if (k1 != i1)
                    {
                        for (; k1 < i1 && !bitmatrix.get(j, k1) && ai[3] < k; k1++)
                        {
                            ai[3] = 1 + ai[3];
                        }

                        if (k1 != i1 && ai[3] < k)
                        {
                            for (; k1 < i1 && bitmatrix.get(j, k1) && ai[4] < k; k1++)
                            {
                                ai[4] = 1 + ai[4];
                            }

                            if (ai[4] < k && 5 * Math.abs((ai[0] + ai[1] + ai[2] + ai[3] + ai[4]) - l) < l * 2 && foundPatternCross(ai))
                            {
                                return a(ai, k1);
                            }
                        }
                    }
                }
            }
        }
        return (0.0F / 0.0F);
    }

    private static float a(int ai[], int i)
    {
        return (float)(i - ai[4] - ai[3]) - (float)ai[2] / 2.0F;
    }

    private int[] a()
    {
        f[0] = 0;
        f[1] = 0;
        f[2] = 0;
        f[3] = 0;
        f[4] = 0;
        return f;
    }

    private float b(int i, int j, int k, int l)
    {
        BitMatrix bitmatrix = c;
        int i1 = bitmatrix.getWidth();
        int ai[] = a();
        int j1;
        for (j1 = i; j1 >= 0 && bitmatrix.get(j1, j); j1--)
        {
            ai[2] = 1 + ai[2];
        }

        if (j1 >= 0)
        {
            for (; j1 >= 0 && !bitmatrix.get(j1, j) && ai[1] <= k; j1--)
            {
                ai[1] = 1 + ai[1];
            }

            if (j1 >= 0 && ai[1] <= k)
            {
                for (; j1 >= 0 && bitmatrix.get(j1, j) && ai[0] <= k; j1--)
                {
                    ai[0] = 1 + ai[0];
                }

                if (ai[0] <= k)
                {
                    int k1;
                    for (k1 = i + 1; k1 < i1 && bitmatrix.get(k1, j); k1++)
                    {
                        ai[2] = 1 + ai[2];
                    }

                    if (k1 != i1)
                    {
                        for (; k1 < i1 && !bitmatrix.get(k1, j) && ai[3] < k; k1++)
                        {
                            ai[3] = 1 + ai[3];
                        }

                        if (k1 != i1 && ai[3] < k)
                        {
                            for (; k1 < i1 && bitmatrix.get(k1, j) && ai[4] < k; k1++)
                            {
                                ai[4] = 1 + ai[4];
                            }

                            if (ai[4] < k && 5 * Math.abs((ai[0] + ai[1] + ai[2] + ai[3] + ai[4]) - l) < l && foundPatternCross(ai))
                            {
                                return a(ai, k1);
                            }
                        }
                    }
                }
            }
        }
        return (0.0F / 0.0F);
    }

    private int b()
    {
        FinderPattern finderpattern;
        Iterator iterator;
        if (d.size() <= 1)
        {
            return 0;
        }
        finderpattern = null;
        iterator = d.iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        FinderPattern finderpattern1;
        finderpattern1 = (FinderPattern)iterator.next();
        if (finderpattern1.a() < 2)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (finderpattern != null) goto _L4; else goto _L3
_L3:
        finderpattern = finderpattern1;
          goto _L5
_L4:
        e = true;
        return (int)(Math.abs(finderpattern.getX() - finderpattern1.getX()) - Math.abs(finderpattern.getY() - finderpattern1.getY())) / 2;
_L2:
        return 0;
        finderpattern1 = finderpattern;
          goto _L3
    }

    private boolean c()
    {
        float f1 = 0.0F;
        int i = d.size();
        Iterator iterator = d.iterator();
        float f2 = 0.0F;
        int j = 0;
        while (iterator.hasNext()) 
        {
            FinderPattern finderpattern = (FinderPattern)iterator.next();
            float f3;
            Iterator iterator1;
            float f4;
            int k;
            if (finderpattern.a() >= 2)
            {
                int l = j + 1;
                f4 = f2 + finderpattern.getEstimatedModuleSize();
                k = l;
            } else
            {
                f4 = f2;
                k = j;
            }
            j = k;
            f2 = f4;
        }
        if (j >= 3)
        {
            f3 = f2 / (float)i;
            for (iterator1 = d.iterator(); iterator1.hasNext();)
            {
                f1 += Math.abs(((FinderPattern)iterator1.next()).getEstimatedModuleSize() - f3);
            }

            if (f1 <= 0.05F * f2)
            {
                return true;
            }
        }
        return false;
    }

    private FinderPattern[] d()
    {
        float f1 = 0.0F;
        int i = d.size();
        if (i < 3)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        if (i > 3)
        {
            Iterator iterator1 = d.iterator();
            float f3 = 0.0F;
            float f4 = 0.0F;
            while (iterator1.hasNext()) 
            {
                float f8 = ((FinderPattern)iterator1.next()).getEstimatedModuleSize();
                f4 += f8;
                f3 += f8 * f8;
            }
            float f5 = f4 / (float)i;
            float f6 = (float)Math.sqrt(f3 / (float)i - f5 * f5);
            Collections.sort(d, new d(f5, null));
            float f7 = Math.max(0.2F * f5, f6);
            for (int j = 0; j < d.size() && d.size() > 3; j++)
            {
                if (Math.abs(((FinderPattern)d.get(j)).getEstimatedModuleSize() - f5) > f7)
                {
                    d.remove(j);
                    j--;
                }
            }

        }
        if (d.size() > 3)
        {
            for (Iterator iterator = d.iterator(); iterator.hasNext();)
            {
                f1 += ((FinderPattern)iterator.next()).getEstimatedModuleSize();
            }

            float f2 = f1 / (float)d.size();
            Collections.sort(d, new c(f2, null));
            d.subList(3, d.size()).clear();
        }
        FinderPattern afinderpattern[] = new FinderPattern[3];
        afinderpattern[0] = (FinderPattern)d.get(0);
        afinderpattern[1] = (FinderPattern)d.get(1);
        afinderpattern[2] = (FinderPattern)d.get(2);
        return afinderpattern;
    }

    protected static boolean foundPatternCross(int ai[])
    {
        boolean flag;
        int i;
        int j;
        flag = true;
        i = 0;
        j = 0;
_L7:
        if (i >= 5) goto _L2; else goto _L1
_L1:
        int i1 = ai[i];
        if (i1 != 0) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        j += i1;
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (j < 7) goto _L3; else goto _L5
_L5:
        int k = (j << 8) / 7;
        int l = k / 2;
        if (Math.abs(k - (ai[0] << 8)) >= l || Math.abs(k - (ai[flag] << 8)) >= l || Math.abs(k * 3 - (ai[2] << 8)) >= l * 3 || Math.abs(k - (ai[3] << 8)) >= l || Math.abs(k - (ai[4] << 8)) >= l)
        {
            flag = false;
        }
        return flag;
        if (true) goto _L7; else goto _L6
_L6:
    }

    FinderPatternInfo b(Map map)
    {
        boolean flag;
        int i;
        int j;
        int k;
        int l;
        int ai[];
        int i1;
        boolean flag1;
        int j1;
        if (map != null && map.containsKey(DecodeHintType.TRY_HARDER))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = c.getHeight();
        j = c.getWidth();
        k = (i * 3) / 228;
        if (k < 3 || flag)
        {
            l = 3;
        } else
        {
            l = k;
        }
        ai = new int[5];
        i1 = l - 1;
        flag1 = false;
        j1 = l;
        while (i1 < i && !flag1) 
        {
            ai[0] = 0;
            ai[1] = 0;
            ai[2] = 0;
            ai[3] = 0;
            ai[4] = 0;
            int k1 = 0;
            int l1 = 0;
            while (k1 < j) 
            {
                if (c.get(k1, i1))
                {
                    if ((l1 & 1) == 1)
                    {
                        l1++;
                    }
                    ai[l1] = 1 + ai[l1];
                } else
                if ((l1 & 1) == 0)
                {
                    if (l1 == 4)
                    {
                        if (foundPatternCross(ai))
                        {
                            if (handlePossibleCenter(ai, i1, k1))
                            {
                                boolean flag2;
                                if (e)
                                {
                                    flag2 = c();
                                } else
                                {
                                    int i2 = b();
                                    FinderPattern afinderpattern[];
                                    int j2;
                                    int k2;
                                    if (i2 > ai[2])
                                    {
                                        k2 = i1 + (i2 - ai[2] - 2);
                                        j2 = j - 1;
                                    } else
                                    {
                                        j2 = k1;
                                        k2 = i1;
                                    }
                                    i1 = k2;
                                    k1 = j2;
                                    flag2 = flag1;
                                }
                                ai[0] = 0;
                                ai[1] = 0;
                                ai[2] = 0;
                                ai[3] = 0;
                                ai[4] = 0;
                                flag1 = flag2;
                                j1 = 2;
                                l1 = 0;
                            } else
                            {
                                ai[0] = ai[2];
                                ai[1] = ai[3];
                                ai[2] = ai[4];
                                ai[3] = 1;
                                ai[4] = 0;
                                l1 = 3;
                            }
                        } else
                        {
                            ai[0] = ai[2];
                            ai[1] = ai[3];
                            ai[2] = ai[4];
                            ai[3] = 1;
                            ai[4] = 0;
                            l1 = 3;
                        }
                    } else
                    {
                        l1++;
                        ai[l1] = 1 + ai[l1];
                    }
                } else
                {
                    ai[l1] = 1 + ai[l1];
                }
                k1++;
            }
            if (!foundPatternCross(ai) || !handlePossibleCenter(ai, i1, j))
            {
                continue;
            }
            j1 = ai[0];
            if (e)
            {
                flag1 = c();
            }
            i1 += j1;
        }
        afinderpattern = d();
        ResultPoint.orderBestPatterns(afinderpattern);
        return new FinderPatternInfo(afinderpattern);
    }

    protected BitMatrix getImage()
    {
        return c;
    }

    protected List getPossibleCenters()
    {
        return d;
    }

    protected boolean handlePossibleCenter(int ai[], int i, int j)
    {
        int k;
        float f1;
        float f2;
        boolean flag;
        boolean flag1;
        k = ai[0] + ai[1] + ai[2] + ai[3] + ai[4];
        f1 = a(ai, j);
        f2 = a(i, (int)f1, ai[2], k);
        flag = Float.isNaN(f2);
        flag1 = false;
        if (flag) goto _L2; else goto _L1
_L1:
        float f3;
        boolean flag2;
        f3 = b((int)f1, (int)f2, ai[2], k);
        flag2 = Float.isNaN(f3);
        flag1 = false;
        if (flag2) goto _L2; else goto _L3
_L3:
        float f4;
        int l;
        f4 = (float)k / 7F;
        l = 0;
_L9:
        int i1;
        boolean flag3;
        i1 = d.size();
        flag3 = false;
        if (l >= i1) goto _L5; else goto _L4
_L4:
        FinderPattern finderpattern1 = (FinderPattern)d.get(l);
        if (!finderpattern1.a(f4, f2, f3)) goto _L7; else goto _L6
_L6:
        d.set(l, finderpattern1.b(f2, f3, f4));
        flag3 = true;
_L5:
        if (!flag3)
        {
            FinderPattern finderpattern = new FinderPattern(f3, f2, f4);
            d.add(finderpattern);
            if (g != null)
            {
                g.foundPossibleResultPoint(finderpattern);
            }
        }
        flag1 = true;
_L2:
        return flag1;
_L7:
        l++;
        if (true) goto _L9; else goto _L8
_L8:
    }
}
