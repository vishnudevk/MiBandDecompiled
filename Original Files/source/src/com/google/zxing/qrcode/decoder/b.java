// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;


// Referenced classes of package com.google.zxing.qrcode.decoder:
//            Version, ErrorCorrectionLevel

final class b
{

    private final int a;
    private final byte b[];

    private b(int i, byte abyte0[])
    {
        a = i;
        b = abyte0;
    }

    static b[] a(byte abyte0[], Version version, ErrorCorrectionLevel errorcorrectionlevel)
    {
        Version.ECBlocks ecblocks;
        b ab[];
        int j1;
        int k1;
        int l1;
        if (abyte0.length != version.getTotalCodewords())
        {
            throw new IllegalArgumentException();
        }
        ecblocks = version.getECBlocksForLevel(errorcorrectionlevel);
        Version.ECB aecb[] = ecblocks.getECBlocks();
        int i = aecb.length;
        int j = 0;
        int k = 0;
        for (; j < i; j++)
        {
            k += aecb[j].getCount();
        }

        ab = new b[k];
        int l = aecb.length;
        int i1 = 0;
        int k5;
        for (j1 = 0; i1 < l; j1 = k5)
        {
            Version.ECB ecb = aecb[i1];
            k5 = j1;
            for (int l5 = 0; l5 < ecb.getCount();)
            {
                int i6 = ecb.getDataCodewords();
                int j6 = i6 + ecblocks.getECCodewordsPerBlock();
                int k6 = k5 + 1;
                ab[k5] = new b(i6, new byte[j6]);
                l5++;
                k5 = k6;
            }

            i1++;
        }

        k1 = ab[0].b.length;
        l1 = -1 + ab.length;
_L6:
        if (l1 >= 0 && ab[l1].b.length != k1) goto _L2; else goto _L1
_L1:
        int i2;
        int j2;
        int k2;
        int l2;
        i2 = l1 + 1;
        j2 = k1 - ecblocks.getECCodewordsPerBlock();
        k2 = 0;
        l2 = 0;
_L4:
        if (k2 >= j2)
        {
            break; /* Loop/switch isn't completed */
        }
        int l4 = l2;
        for (int i5 = 0; i5 < j1;)
        {
            byte abyte3[] = ab[i5].b;
            int j5 = l4 + 1;
            abyte3[k2] = abyte0[l4];
            i5++;
            l4 = j5;
        }

        k2++;
        l2 = l4;
        continue; /* Loop/switch isn't completed */
_L2:
        l1--;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        for (int i3 = i2; i3 < j1;)
        {
            byte abyte2[] = ab[i3].b;
            int k4 = l2 + 1;
            abyte2[j2] = abyte0[l2];
            i3++;
            l2 = k4;
        }

        for (int j3 = ab[0].b.length; j2 < j3;)
        {
            int k3 = 0;
            int l3 = l2;
            while (k3 < j1) 
            {
                int i4;
                byte abyte1[];
                int j4;
                if (k3 < i2)
                {
                    i4 = j2;
                } else
                {
                    i4 = j2 + 1;
                }
                abyte1 = ab[k3].b;
                j4 = l3 + 1;
                abyte1[i4] = abyte0[l3];
                k3++;
                l3 = j4;
            }
            j2++;
            l2 = l3;
        }

        return ab;
        if (true) goto _L6; else goto _L5
_L5:
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
