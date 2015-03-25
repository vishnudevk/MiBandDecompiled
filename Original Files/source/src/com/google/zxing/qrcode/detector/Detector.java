// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

// Referenced classes of package com.google.zxing.qrcode.detector:
//            FinderPatternFinder, a, FinderPatternInfo, FinderPattern, 
//            AlignmentPattern

public class Detector
{

    private final BitMatrix a;
    private ResultPointCallback b;

    public Detector(BitMatrix bitmatrix)
    {
        a = bitmatrix;
    }

    private float a(int i, int j, int k, int l)
    {
        int i1 = 0;
        float f = b(i, j, k, l);
        int j1 = i - (k - i);
        int k1;
        float f1;
        int l1;
        float f2;
        if (j1 < 0)
        {
            f1 = (float)i / (float)(i - j1);
            k1 = 0;
        } else
        if (j1 >= a.getWidth())
        {
            float f3 = (float)((-1 + a.getWidth()) - i) / (float)(j1 - i);
            int i2 = -1 + a.getWidth();
            f1 = f3;
            k1 = i2;
        } else
        {
            k1 = j1;
            f1 = 1.0F;
        }
        l1 = (int)((float)j - f1 * (float)(l - j));
        if (l1 < 0)
        {
            f2 = (float)j / (float)(j - l1);
        } else
        if (l1 >= a.getHeight())
        {
            f2 = (float)((-1 + a.getHeight()) - j) / (float)(l1 - j);
            i1 = -1 + a.getHeight();
        } else
        {
            i1 = l1;
            f2 = 1.0F;
        }
        return (f + b(i, j, (int)((float)i + f2 * (float)(k1 - i)), i1)) - 1.0F;
    }

    private float a(ResultPoint resultpoint, ResultPoint resultpoint1)
    {
        float f = a((int)resultpoint.getX(), (int)resultpoint.getY(), (int)resultpoint1.getX(), (int)resultpoint1.getY());
        float f1 = a((int)resultpoint1.getX(), (int)resultpoint1.getY(), (int)resultpoint.getX(), (int)resultpoint.getY());
        if (Float.isNaN(f))
        {
            return f1 / 7F;
        }
        if (Float.isNaN(f1))
        {
            return f / 7F;
        } else
        {
            return (f + f1) / 14F;
        }
    }

    private static int a(float f)
    {
        return (int)(0.5F + f);
    }

    private static BitMatrix a(BitMatrix bitmatrix, PerspectiveTransform perspectivetransform, int i)
    {
        return GridSampler.getInstance().sampleGrid(bitmatrix, i, i, perspectivetransform);
    }

    private float b(int i, int j, int k, int l)
    {
        boolean flag;
        int k1;
        int l1;
        int i2;
        int j2;
        byte byte0;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int k4;
        int l4;
        boolean flag1;
        int i6;
        int j6;
        if (Math.abs(l - j) > Math.abs(k - i))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int l3;
        int i4;
        int j4;
        int i5;
        int j5;
        int k5;
        int l5;
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
        if (j < l)
        {
            j2 = 1;
        } else
        {
            j2 = -1;
        }
        if (i < k)
        {
            byte0 = 1;
        } else
        {
            byte0 = -1;
        }
        k2 = 0;
        l2 = l + j2;
        i3 = j;
        j3 = i2;
        k3 = i;
        if (i3 == l2)
        {
            break MISSING_BLOCK_LABEL_330;
        }
        if (flag)
        {
            k4 = k3;
        } else
        {
            k4 = i3;
        }
        if (flag)
        {
            l4 = i3;
        } else
        {
            l4 = k3;
        }
        if (k2 == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 == a.get(k4, l4))
        {
            if (k2 == 2)
            {
                i6 = i3 - j;
                j6 = k3 - i;
                return (float)Math.sqrt(i6 * i6 + j6 * j6);
            }
            i5 = k2 + 1;
        } else
        {
            i5 = k2;
        }
        j5 = j3 + l1;
        if (j5 <= 0) goto _L2; else goto _L1
_L1:
        if (k3 != k) goto _L4; else goto _L3
_L3:
        l3 = i5;
_L8:
        if (l3 == 2)
        {
            i4 = (l + j2) - j;
            j4 = k - i;
            return (float)Math.sqrt(i4 * i4 + j4 * j4);
        } else
        {
            return (0.0F / 0.0F);
        }
_L4:
        k5 = k3 + byte0;
        l5 = j5 - k1;
_L6:
        i3 += j2;
        k2 = i5;
        j3 = l5;
        k3 = k5;
        break MISSING_BLOCK_LABEL_85;
_L2:
        k5 = k3;
        l5 = j5;
        if (true) goto _L6; else goto _L5
_L5:
        l3 = k2;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected static int computeDimension(ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, float f)
    {
        int i = 7 + (a(ResultPoint.distance(resultpoint, resultpoint1) / f) + a(ResultPoint.distance(resultpoint, resultpoint2) / f) >> 1);
        switch (i & 3)
        {
        case 1: // '\001'
        default:
            return i;

        case 0: // '\0'
            return i + 1;

        case 2: // '\002'
            return i - 1;

        case 3: // '\003'
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public static PerspectiveTransform createTransform(ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3, int i)
    {
        float f = (float)i - 3.5F;
        float f1;
        float f2;
        float f3;
        float f4;
        if (resultpoint3 != null)
        {
            f1 = resultpoint3.getX();
            f2 = resultpoint3.getY();
            f3 = f - 3F;
            f4 = f3;
        } else
        {
            f1 = (resultpoint1.getX() - resultpoint.getX()) + resultpoint2.getX();
            f2 = (resultpoint1.getY() - resultpoint.getY()) + resultpoint2.getY();
            f3 = f;
            f4 = f;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5F, 3.5F, f, 3.5F, f4, f3, 3.5F, f, resultpoint.getX(), resultpoint.getY(), resultpoint1.getX(), resultpoint1.getY(), f1, f2, resultpoint2.getX(), resultpoint2.getY());
    }

    protected float calculateModuleSize(ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2)
    {
        return (a(resultpoint, resultpoint1) + a(resultpoint, resultpoint2)) / 2.0F;
    }

    public DetectorResult detect()
    {
        return detect(null);
    }

    public DetectorResult detect(Map map)
    {
        ResultPointCallback resultpointcallback;
        if (map == null)
        {
            resultpointcallback = null;
        } else
        {
            resultpointcallback = (ResultPointCallback)map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        b = resultpointcallback;
        return processFinderPatternInfo((new FinderPatternFinder(a, b)).b(map));
    }

    protected AlignmentPattern findAlignmentInRegion(float f, int i, int j, float f1)
    {
        int k = (int)(f1 * f);
        int l = Math.max(0, i - k);
        int i1 = Math.min(-1 + a.getWidth(), i + k);
        if ((float)(i1 - l) < f * 3F)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        int j1 = Math.max(0, j - k);
        int k1 = Math.min(-1 + a.getHeight(), k + j);
        if ((float)(k1 - j1) < f * 3F)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            return (new a(a, l, j1, i1 - l, k1 - j1, f, b)).a();
        }
    }

    protected BitMatrix getImage()
    {
        return a;
    }

    protected ResultPointCallback getResultPointCallback()
    {
        return b;
    }

    protected DetectorResult processFinderPatternInfo(FinderPatternInfo finderpatterninfo)
    {
        FinderPattern finderpattern;
        FinderPattern finderpattern1;
        FinderPattern finderpattern2;
        float f;
        int i;
        int j;
        int k;
        AlignmentPattern alignmentpattern;
        finderpattern = finderpatterninfo.getTopLeft();
        finderpattern1 = finderpatterninfo.getTopRight();
        finderpattern2 = finderpatterninfo.getBottomLeft();
        f = calculateModuleSize(finderpattern, finderpattern1, finderpattern2);
        if (f < 1.0F)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        i = computeDimension(finderpattern, finderpattern1, finderpattern2, f);
        Version version = Version.getProvisionalVersionForDimension(i);
        j = -7 + version.getDimensionForVersion();
        k = version.getAlignmentPatternCenters().length;
        alignmentpattern = null;
        if (k <= 0) goto _L2; else goto _L1
_L1:
        int l;
        int i1;
        int j1;
        float f1 = (finderpattern1.getX() - finderpattern.getX()) + finderpattern2.getX();
        float f2 = (finderpattern1.getY() - finderpattern.getY()) + finderpattern2.getY();
        float f3 = 1.0F - 3F / (float)j;
        l = (int)(finderpattern.getX() + f3 * (f1 - finderpattern.getX()));
        i1 = (int)(finderpattern.getY() + f3 * (f2 - finderpattern.getY()));
        j1 = 4;
_L5:
        alignmentpattern = null;
        if (j1 > 16) goto _L2; else goto _L3
_L3:
        float f4 = j1;
        AlignmentPattern alignmentpattern1 = findAlignmentInRegion(f, l, i1, f4);
        alignmentpattern = alignmentpattern1;
_L2:
        PerspectiveTransform perspectivetransform = createTransform(finderpattern, finderpattern1, finderpattern2, alignmentpattern, i);
        BitMatrix bitmatrix = a(a, perspectivetransform, i);
        ResultPoint aresultpoint[];
        NotFoundException notfoundexception;
        if (alignmentpattern == null)
        {
            aresultpoint = (new ResultPoint[] {
                finderpattern2, finderpattern, finderpattern1
            });
        } else
        {
            aresultpoint = (new ResultPoint[] {
                finderpattern2, finderpattern, finderpattern1, alignmentpattern
            });
        }
        return new DetectorResult(bitmatrix, aresultpoint);
        notfoundexception;
        j1 <<= 1;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
