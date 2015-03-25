// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.zxing.qrcode.detector:
//            AlignmentPattern

final class a
{

    private final BitMatrix a;
    private final List b = new ArrayList(5);
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final float g;
    private final int h[] = new int[3];
    private final ResultPointCallback i;

    a(BitMatrix bitmatrix, int j, int k, int l, int i1, float f1, ResultPointCallback resultpointcallback)
    {
        a = bitmatrix;
        c = j;
        d = k;
        e = l;
        f = i1;
        g = f1;
        i = resultpointcallback;
    }

    private float a(int j, int k, int l, int i1)
    {
        BitMatrix bitmatrix = a;
        int j1 = bitmatrix.getHeight();
        int ai[] = h;
        ai[0] = 0;
        ai[1] = 0;
        ai[2] = 0;
        int k1;
        for (k1 = j; k1 >= 0 && bitmatrix.get(k, k1) && ai[1] <= l; k1--)
        {
            ai[1] = 1 + ai[1];
        }

        if (k1 >= 0 && ai[1] <= l)
        {
            for (; k1 >= 0 && !bitmatrix.get(k, k1) && ai[0] <= l; k1--)
            {
                ai[0] = 1 + ai[0];
            }

            if (ai[0] <= l)
            {
                int l1;
                for (l1 = j + 1; l1 < j1 && bitmatrix.get(k, l1) && ai[1] <= l; l1++)
                {
                    ai[1] = 1 + ai[1];
                }

                if (l1 != j1 && ai[1] <= l)
                {
                    for (; l1 < j1 && !bitmatrix.get(k, l1) && ai[2] <= l; l1++)
                    {
                        ai[2] = 1 + ai[2];
                    }

                    if (ai[2] <= l && 5 * Math.abs((ai[0] + ai[1] + ai[2]) - i1) < i1 * 2 && a(ai))
                    {
                        return a(ai, l1);
                    }
                }
            }
        }
        return (0.0F / 0.0F);
    }

    private static float a(int ai[], int j)
    {
        return (float)(j - ai[2]) - (float)ai[1] / 2.0F;
    }

    private AlignmentPattern a(int ai[], int j, int k)
    {
        int l = ai[0] + ai[1] + ai[2];
        float f1 = a(ai, k);
        float f2 = a(j, (int)f1, 2 * ai[1], l);
        if (!Float.isNaN(f2))
        {
            float f3 = (float)(ai[0] + ai[1] + ai[2]) / 3F;
            for (Iterator iterator = b.iterator(); iterator.hasNext();)
            {
                AlignmentPattern alignmentpattern1 = (AlignmentPattern)iterator.next();
                if (alignmentpattern1.a(f3, f2, f1))
                {
                    return alignmentpattern1.b(f2, f1, f3);
                }
            }

            AlignmentPattern alignmentpattern = new AlignmentPattern(f1, f2, f3);
            b.add(alignmentpattern);
            if (i != null)
            {
                i.foundPossibleResultPoint(alignmentpattern);
            }
        }
        return null;
    }

    private boolean a(int ai[])
    {
        float f1 = g;
        float f2 = f1 / 2.0F;
        for (int j = 0; j < 3; j++)
        {
            if (Math.abs(f1 - (float)ai[j]) >= f2)
            {
                return false;
            }
        }

        return true;
    }

    AlignmentPattern a()
    {
        int j;
        int k;
        int l;
        int i1;
        int ai[];
        int j1;
        j = c;
        k = f;
        l = j + e;
        i1 = d + (k >> 1);
        ai = new int[3];
        j1 = 0;
_L17:
        if (j1 >= k) goto _L2; else goto _L1
_L1:
        int l1;
        int j2;
        int k2;
        int k1;
        int i2;
        if ((j1 & 1) == 0)
        {
            k1 = j1 + 1 >> 1;
        } else
        {
            k1 = -(j1 + 1 >> 1);
        }
        l1 = i1 + k1;
        ai[0] = 0;
        ai[1] = 0;
        ai[2] = 0;
        for (i2 = j; i2 < l && !a.get(i2, l1); i2++) { }
        j2 = i2;
        k2 = 0;
_L9:
        if (j2 >= l) goto _L4; else goto _L3
_L3:
        if (!a.get(j2, l1)) goto _L6; else goto _L5
_L5:
        if (k2 != 1) goto _L8; else goto _L7
_L7:
        ai[k2] = 1 + ai[k2];
_L15:
        j2++;
          goto _L9
_L8:
        if (k2 != 2) goto _L11; else goto _L10
_L10:
        if (!a(ai)) goto _L13; else goto _L12
_L12:
        AlignmentPattern alignmentpattern = a(ai, l1, j2);
        if (alignmentpattern == null) goto _L13; else goto _L14
_L14:
        return alignmentpattern;
_L13:
        ai[0] = ai[2];
        ai[1] = 1;
        ai[2] = 0;
        k2 = 1;
          goto _L15
_L11:
        k2++;
        ai[k2] = 1 + ai[k2];
          goto _L15
_L6:
        if (k2 == 1)
        {
            k2++;
        }
        ai[k2] = 1 + ai[k2];
          goto _L15
_L4:
        if (!a(ai))
        {
            continue; /* Loop/switch isn't completed */
        }
        alignmentpattern = a(ai, l1, l);
        if (alignmentpattern != null) goto _L14; else goto _L16
_L16:
        j1++;
          goto _L17
_L2:
        if (!b.isEmpty())
        {
            return (AlignmentPattern)b.get(0);
        } else
        {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
