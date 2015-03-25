// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss;


public final class RSSUtils
{

    private RSSUtils()
    {
    }

    private static int a(int i, int j)
    {
_L2:
        int k1;
        for (; k <= j; k++)
        {
            k1 /= k;
        }

        return k1;
        int k = 1;
        int i1;
        int j1;
        if (i - j > j)
        {
            i1 = i - j;
        } else
        {
            int l = i - j;
            i1 = j;
            j = l;
        }
        j1 = k;
        for (; i > i1; i--)
        {
            j1 *= i;
            if (k <= j)
            {
                j1 /= k;
                k++;
            }
        }

        k1 = j1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static int[] a(int i, int j, int k, int l, boolean flag)
    {
        int ai[];
        int i1;
        int j1;
        int k1;
        ai = new int[k];
        i1 = 0;
        j1 = 0;
        k1 = i;
_L9:
        if (j1 >= k - 1) goto _L2; else goto _L1
_L1:
        int l1;
        i1 |= 1 << j1;
        l1 = 1;
_L7:
        int i2;
        i2 = a(-1 + (j - l1), -2 + (k - j1));
        if (flag && i1 == 0 && j - l1 - (-1 + (k - j1)) >= -1 + (k - j1))
        {
            i2 -= a(j - l1 - (k - j1), -2 + (k - j1));
        }
        if (-1 + (k - j1) <= 1) goto _L4; else goto _L3
_L3:
        int j2 = 0;
        for (int k2 = j - l1 - (-2 + (k - j1)); k2 > l; k2--)
        {
            j2 += a(-1 + (j - l1 - k2), -3 + (k - j1));
        }

        i2 -= j2 * (k - 1 - j1);
_L6:
        k1 -= i2;
        if (k1 >= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k1 += i2;
        j -= l1;
        ai[j1] = l1;
        j1++;
        continue; /* Loop/switch isn't completed */
_L4:
        if (j - l1 > l)
        {
            i2--;
        }
        if (true) goto _L6; else goto _L5
_L5:
        l1++;
        i1 &= -1 ^ 1 << j1;
        if (true) goto _L7; else goto _L2
_L2:
        ai[j1] = j;
        return ai;
        if (true) goto _L9; else goto _L8
_L8:
    }

    static int[] a(int ai[], int i, int j)
    {
        int ai1[] = new int[2 + ai.length];
        int k = j << 1;
        ai1[0] = 1;
        int l = 10;
        int i1 = 1;
        for (int j1 = 1; j1 < k - 2; j1 += 2)
        {
            ai1[j1] = ai[j1 - 1] - ai1[j1 - 1];
            ai1[j1 + 1] = ai[j1] - ai1[j1];
            i1 += ai1[j1] + ai1[j1 + 1];
            if (ai1[j1] < l)
            {
                l = ai1[j1];
            }
        }

        ai1[k - 1] = i - i1;
        int k1;
        if (ai1[k - 1] < l)
        {
            k1 = ai1[k - 1];
        } else
        {
            k1 = l;
        }
        if (k1 > 1)
        {
            for (int l1 = 0; l1 < k; l1 += 2)
            {
                ai1[l1] = ai1[l1] + (k1 - 1);
                int i2 = l1 + 1;
                ai1[i2] = ai1[i2] - (k1 - 1);
            }

        }
        return ai1;
    }

    public static int getRSSvalue(int ai[], int i, boolean flag)
    {
        int j = ai.length;
        int k = 0;
        int l;
        int i4;
        for (l = 0; k < j; l = i4)
        {
            i4 = l + ai[k];
            k++;
        }

        int i1 = 0;
        int j1 = 0;
        int k1 = l;
        int l1 = 0;
        do
        {
            if (i1 >= j - 1)
            {
                break;
            }
            int i2 = l1 | 1 << i1;
            int j2 = j1;
            int k2 = i2;
            int l2 = 1;
            while (l2 < ai[i1]) 
            {
                int j3 = a(-1 + (k1 - l2), -2 + (j - i1));
                if (flag && k2 == 0 && k1 - l2 - (-1 + (j - i1)) >= -1 + (j - i1))
                {
                    j3 -= a(k1 - l2 - (j - i1), -2 + (j - i1));
                }
                if (-1 + (j - i1) > 1)
                {
                    int k3 = k1 - l2 - (-2 + (j - i1));
                    int l3 = 0;
                    for (; k3 > i; k3--)
                    {
                        l3 += a(-1 + (k1 - l2 - k3), -3 + (j - i1));
                    }

                    j3 -= l3 * (j - 1 - i1);
                } else
                if (k1 - l2 > i)
                {
                    j3--;
                }
                j2 += j3;
                l2++;
                k2 &= -1 ^ 1 << i1;
            }
            int i3 = k1 - l2;
            i1++;
            k1 = i3;
            l1 = k2;
            j1 = j2;
        } while (true);
        return j1;
    }
}
