// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.zxing.multi.qrcode.detector:
//            c

final class a extends FinderPatternFinder
{

    private static final FinderPatternInfo a[] = new FinderPatternInfo[0];
    private static final float b = 180F;
    private static final float c = 9F;
    private static final float d = 0.05F;
    private static final float e = 0.5F;

    a(BitMatrix bitmatrix)
    {
        super(bitmatrix);
    }

    a(BitMatrix bitmatrix, ResultPointCallback resultpointcallback)
    {
        super(bitmatrix, resultpointcallback);
    }

    private FinderPattern[][] a()
    {
        List list;
        int i;
        ArrayList arraylist;
        int j;
        list = getPossibleCenters();
        i = list.size();
        if (i < 3)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        if (i == 3)
        {
            FinderPattern afinderpattern1[][] = new FinderPattern[1][];
            FinderPattern afinderpattern2[] = new FinderPattern[3];
            afinderpattern2[0] = (FinderPattern)list.get(0);
            afinderpattern2[1] = (FinderPattern)list.get(1);
            afinderpattern2[2] = (FinderPattern)list.get(2);
            afinderpattern1[0] = afinderpattern2;
            return afinderpattern1;
        }
        Collections.sort(list, new c(null));
        arraylist = new ArrayList();
        j = 0;
_L2:
        FinderPattern finderpattern;
        if (j >= i - 2)
        {
            break MISSING_BLOCK_LABEL_515;
        }
        finderpattern = (FinderPattern)list.get(j);
        if (finderpattern != null)
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        int k = j + 1;
_L7:
        if (k >= i - 1) goto _L4; else goto _L3
_L3:
        FinderPattern finderpattern1 = (FinderPattern)list.get(k);
        if (finderpattern1 != null) goto _L6; else goto _L5
_L5:
        k++;
          goto _L7
_L6:
        float f = (finderpattern.getEstimatedModuleSize() - finderpattern1.getEstimatedModuleSize()) / Math.min(finderpattern.getEstimatedModuleSize(), finderpattern1.getEstimatedModuleSize());
        if (Math.abs(finderpattern.getEstimatedModuleSize() - finderpattern1.getEstimatedModuleSize()) > 0.5F && f >= 0.05F) goto _L4; else goto _L8
_L8:
        int l = k + 1;
_L12:
        if (l >= i) goto _L5; else goto _L9
_L9:
        FinderPattern finderpattern2 = (FinderPattern)list.get(l);
        if (finderpattern2 != null) goto _L11; else goto _L10
_L10:
        l++;
          goto _L12
_L11:
        float f1 = (finderpattern1.getEstimatedModuleSize() - finderpattern2.getEstimatedModuleSize()) / Math.min(finderpattern1.getEstimatedModuleSize(), finderpattern2.getEstimatedModuleSize());
        if (Math.abs(finderpattern1.getEstimatedModuleSize() - finderpattern2.getEstimatedModuleSize()) > 0.5F && f1 >= 0.05F) goto _L5; else goto _L13
_L13:
        FinderPattern afinderpattern[] = {
            finderpattern, finderpattern1, finderpattern2
        };
        ResultPoint.orderBestPatterns(afinderpattern);
        FinderPatternInfo finderpatterninfo = new FinderPatternInfo(afinderpattern);
        float f2 = ResultPoint.distance(finderpatterninfo.getTopLeft(), finderpatterninfo.getBottomLeft());
        float f3 = ResultPoint.distance(finderpatterninfo.getTopRight(), finderpatterninfo.getBottomLeft());
        float f4 = ResultPoint.distance(finderpatterninfo.getTopLeft(), finderpatterninfo.getTopRight());
        float f5 = (f2 + f4) / (2.0F * finderpattern.getEstimatedModuleSize());
        if (f5 <= 180F && f5 >= 9F && Math.abs((f2 - f4) / Math.min(f2, f4)) < 0.1F)
        {
            float f6 = (float)Math.sqrt(f2 * f2 + f4 * f4);
            if (Math.abs((f3 - f6) / Math.min(f3, f6)) < 0.1F)
            {
                arraylist.add(afinderpattern);
            }
        }
          goto _L10
        if (!arraylist.isEmpty())
        {
            return (FinderPattern[][])arraylist.toArray(new FinderPattern[arraylist.size()][]);
        } else
        {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public FinderPatternInfo[] a(Map map)
    {
        int i = 0;
        boolean flag;
        BitMatrix bitmatrix;
        int j;
        int k;
        int l;
        int i1;
        int ai[];
        int j1;
        if (map != null && map.containsKey(DecodeHintType.TRY_HARDER))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bitmatrix = getImage();
        j = bitmatrix.getHeight();
        k = bitmatrix.getWidth();
        l = (int)(3F * ((float)j / 228F));
        if (l < 3 || flag)
        {
            i1 = 3;
        } else
        {
            i1 = l;
        }
        ai = new int[5];
        j1 = i1 - 1;
        while (j1 < j) 
        {
            ai[0] = 0;
            ai[1] = 0;
            ai[2] = 0;
            ai[3] = 0;
            ai[4] = 0;
            int l1 = 0;
            int i2 = 0;
            while (l1 < k) 
            {
                if (bitmatrix.get(l1, j1))
                {
                    if ((i2 & 1) == 1)
                    {
                        i2++;
                    }
                    ai[i2] = 1 + ai[i2];
                } else
                if ((i2 & 1) == 0)
                {
                    if (i2 == 4)
                    {
                        if (foundPatternCross(ai))
                        {
                            FinderPattern afinderpattern[][];
                            ArrayList arraylist;
                            int k1;
                            FinderPattern afinderpattern1[];
                            int j2;
                            if (!handlePossibleCenter(ai, j1, l1))
                            {
                                while (++l1 < k && !bitmatrix.get(l1, j1)) ;
                                j2 = l1 - 1;
                            } else
                            {
                                j2 = l1;
                            }
                            ai[0] = 0;
                            ai[1] = 0;
                            ai[2] = 0;
                            ai[3] = 0;
                            ai[4] = 0;
                            l1 = j2;
                            i2 = 0;
                        } else
                        {
                            ai[0] = ai[2];
                            ai[1] = ai[3];
                            ai[2] = ai[4];
                            ai[3] = 1;
                            ai[4] = 0;
                            i2 = 3;
                        }
                    } else
                    {
                        i2++;
                        ai[i2] = 1 + ai[i2];
                    }
                } else
                {
                    ai[i2] = 1 + ai[i2];
                }
                l1++;
            }
            if (foundPatternCross(ai))
            {
                handlePossibleCenter(ai, j1, k);
            }
            j1 += i1;
        }
        afinderpattern = a();
        arraylist = new ArrayList();
        for (k1 = afinderpattern.length; i < k1; i++)
        {
            afinderpattern1 = afinderpattern[i];
            ResultPoint.orderBestPatterns(afinderpattern1);
            arraylist.add(new FinderPatternInfo(afinderpattern1));
        }

        if (arraylist.isEmpty())
        {
            return a;
        } else
        {
            return (FinderPatternInfo[])arraylist.toArray(new FinderPatternInfo[arraylist.size()]);
        }
    }

}
