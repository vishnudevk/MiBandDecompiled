// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.oned.OneDReader;

public abstract class AbstractRSSReader extends OneDReader
{

    private static final int a = 51;
    private static final int b = 102;
    private static final float c = 0.7916667F;
    private static final float d = 0.8928571F;
    private final int e[] = new int[4];
    private final int f[] = new int[8];
    private final float g[] = new float[4];
    private final float h[] = new float[4];
    private final int i[];
    private final int j[];

    protected AbstractRSSReader()
    {
        i = new int[f.length / 2];
        j = new int[f.length / 2];
    }

    protected static int count(int ai[])
    {
        int k = 0;
        int l = ai.length;
        int i1 = 0;
        for (; k < l; k++)
        {
            i1 += ai[k];
        }

        return i1;
    }

    protected static void decrement(int ai[], float af[])
    {
        int k = 0;
        float f1 = af[0];
        for (int l = 1; l < ai.length; l++)
        {
            if (af[l] < f1)
            {
                f1 = af[l];
                k = l;
            }
        }

        ai[k] = -1 + ai[k];
    }

    protected static void increment(int ai[], float af[])
    {
        int k = 0;
        float f1 = af[0];
        for (int l = 1; l < ai.length; l++)
        {
            if (af[l] > f1)
            {
                f1 = af[l];
                k = l;
            }
        }

        ai[k] = 1 + ai[k];
    }

    protected static boolean isFinderPattern(int ai[])
    {
        int k = ai[0] + ai[1];
        int l = k + ai[2] + ai[3];
        float f1 = (float)k / (float)l;
        if (f1 >= 0.7916667F && f1 <= 0.8928571F)
        {
            int i1 = 0x7fffffff;
            int j1 = 0x80000000;
            int k1 = ai.length;
            int l1 = 0;
            while (l1 < k1) 
            {
                int i2 = ai[l1];
                if (i2 > j1)
                {
                    j1 = i2;
                }
                if (i2 >= i1)
                {
                    i2 = i1;
                }
                l1++;
                i1 = i2;
            }
            return j1 < i1 * 10;
        } else
        {
            return false;
        }
    }

    protected static int parseFinderValue(int ai[], int ai1[][])
    {
        for (int k = 0; k < ai1.length; k++)
        {
            if (patternMatchVariance(ai, ai1[k], 102) < 51)
            {
                return k;
            }
        }

        throw NotFoundException.getNotFoundInstance();
    }

    protected int[] getDataCharacterCounters()
    {
        return f;
    }

    protected int[] getDecodeFinderCounters()
    {
        return e;
    }

    protected int[] getEvenCounts()
    {
        return j;
    }

    protected float[] getEvenRoundingErrors()
    {
        return h;
    }

    protected int[] getOddCounts()
    {
        return i;
    }

    protected float[] getOddRoundingErrors()
    {
        return g;
    }
}
