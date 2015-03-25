// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.datamatrix.decoder;


// Referenced classes of package com.google.zxing.datamatrix.decoder:
//            Version, h, g

final class b
{

    private final int a;
    private final byte b[];

    private b(int i, byte abyte0[])
    {
        a = i;
        b = abyte0;
    }

    static b[] a(byte abyte0[], Version version)
    {
        h h1 = version.a();
        g ag[] = h1.b();
        int i = ag.length;
        int j = 0;
        int k = 0;
        for (; j < i; j++)
        {
            k += ag[j].a();
        }

        b ab[] = new b[k];
        int l = ag.length;
        int i1 = 0;
        int j1;
        int k5;
        for (j1 = 0; i1 < l; j1 = k5)
        {
            g g1 = ag[i1];
            k5 = j1;
            for (int l5 = 0; l5 < g1.a();)
            {
                int i6 = g1.b();
                int j6 = i6 + h1.a();
                int k6 = k5 + 1;
                ab[k5] = new b(i6, new byte[j6]);
                l5++;
                k5 = k6;
            }

            i1++;
        }

        int k1 = ab[0].b.length - h1.a();
        int l1 = k1 - 1;
        int i2 = 0;
        int j2 = 0;
        for (; i2 < l1; i2++)
        {
            for (int i5 = 0; i5 < j1;)
            {
                byte abyte3[] = ab[i5].b;
                int j5 = j2 + 1;
                abyte3[i2] = abyte0[j2];
                i5++;
                j2 = j5;
            }

        }

        boolean flag;
        int k2;
        int l2;
        if (version.getVersionNumber() == 24)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            k2 = 8;
        } else
        {
            k2 = j1;
        }
        for (l2 = 0; l2 < k2;)
        {
            byte abyte2[] = ab[l2].b;
            int k4 = k1 - 1;
            int l4 = j2 + 1;
            abyte2[k4] = abyte0[j2];
            l2++;
            j2 = l4;
        }

        int i3 = ab[0].b.length;
        int j3;
        int l3;
        for (j3 = j2; k1 < i3; j3 = l3)
        {
            int k3 = 0;
            l3 = j3;
            while (k3 < j1) 
            {
                int i4;
                byte abyte1[];
                int j4;
                if (flag && k3 > 7)
                {
                    i4 = k1 - 1;
                } else
                {
                    i4 = k1;
                }
                abyte1 = ab[k3].b;
                j4 = l3 + 1;
                abyte1[i4] = abyte0[l3];
                k3++;
                l3 = j4;
            }
            k1++;
        }

        if (j3 != abyte0.length)
        {
            throw new IllegalArgumentException();
        } else
        {
            return ab;
        }
    }

    int a()
    {
        return a;
    }

    byte[] b()
    {
        return b;
    }
}
