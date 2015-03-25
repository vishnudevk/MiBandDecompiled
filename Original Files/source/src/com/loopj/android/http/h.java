// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;


// Referenced classes of package com.loopj.android.http:
//            g

class h extends g
{

    private static final int c[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1
    };
    private static final int d[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1
    };
    private static final int e = -1;
    private static final int f = -2;
    private int g;
    private int h;
    private final int i[];

    public h(int j, byte abyte0[])
    {
        a = abyte0;
        int ai[];
        if ((j & 8) == 0)
        {
            ai = c;
        } else
        {
            ai = d;
        }
        i = ai;
        g = 0;
        h = 0;
    }

    public int a(int j)
    {
        return 10 + (j * 3) / 4;
    }

    public boolean a(byte abyte0[], int j, int k, boolean flag)
    {
        int l;
        int i1;
        int j1;
        int k1;
        byte abyte1[];
        int ai[];
        int l1;
        if (g == 6)
        {
            return false;
        }
        l = k + j;
        i1 = g;
        j1 = h;
        k1 = 0;
        abyte1 = a;
        ai = i;
        l1 = j;
_L14:
        if (l1 >= l) goto _L2; else goto _L1
_L1:
        if (i1 != 0) goto _L4; else goto _L3
_L3:
        do
        {
            if (l1 + 4 > l)
            {
                break;
            }
            j1 = ai[0xff & abyte0[l1]] << 18 | ai[0xff & abyte0[l1 + 1]] << 12 | ai[0xff & abyte0[l1 + 2]] << 6 | ai[0xff & abyte0[l1 + 3]];
            if (j1 < 0)
            {
                break;
            }
            abyte1[k1 + 2] = (byte)j1;
            abyte1[k1 + 1] = (byte)(j1 >> 8);
            abyte1[k1] = (byte)(j1 >> 16);
            k1 += 3;
            l1 += 4;
        } while (true);
        if (l1 < l) goto _L4; else goto _L5
_L5:
        int i2 = j1;
_L27:
        if (!flag)
        {
            g = i1;
            h = i2;
            b = k1;
            return true;
        }
          goto _L6
_L4:
        int l2;
        int i3;
        l2 = l1 + 1;
        i3 = ai[0xff & abyte0[l1]];
        i1;
        JVM INSTR tableswitch 0 5: default 276
    //                   0 291
    //                   1 323
    //                   2 361
    //                   3 432
    //                   4 543
    //                   5 573;
           goto _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L7:
        int j3 = i1;
_L15:
        i1 = j3;
        l1 = l2;
          goto _L14
_L8:
        if (i3 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        j3 = i1 + 1;
        j1 = i3;
          goto _L15
        if (i3 == -1) goto _L7; else goto _L16
_L16:
        g = 6;
        return false;
_L9:
        if (i3 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        j1 = i3 | j1 << 6;
        j3 = i1 + 1;
          goto _L15
        if (i3 == -1) goto _L7; else goto _L17
_L17:
        g = 6;
        return false;
_L10:
        if (i3 >= 0)
        {
            j1 = i3 | j1 << 6;
            j3 = i1 + 1;
        } else
        {
            if (i3 != -2)
            {
                continue; /* Loop/switch isn't completed */
            }
            int k3 = k1 + 1;
            abyte1[k1] = (byte)(j1 >> 4);
            j3 = 4;
            k1 = k3;
        }
          goto _L15
        if (i3 == -1) goto _L7; else goto _L18
_L18:
        g = 6;
        return false;
_L11:
        if (i3 >= 0)
        {
            j1 = i3 | j1 << 6;
            abyte1[k1 + 2] = (byte)j1;
            abyte1[k1 + 1] = (byte)(j1 >> 8);
            abyte1[k1] = (byte)(j1 >> 16);
            k1 += 3;
            j3 = 0;
        } else
        {
            if (i3 != -2)
            {
                continue; /* Loop/switch isn't completed */
            }
            abyte1[k1 + 1] = (byte)(j1 >> 2);
            abyte1[k1] = (byte)(j1 >> 10);
            k1 += 2;
            j3 = 5;
        }
          goto _L15
        if (i3 == -1) goto _L7; else goto _L19
_L19:
        g = 6;
        return false;
_L12:
        if (i3 != -2)
        {
            continue; /* Loop/switch isn't completed */
        }
        j3 = i1 + 1;
          goto _L15
        if (i3 == -1) goto _L7; else goto _L20
_L20:
        g = 6;
        return false;
_L13:
        if (i3 == -1) goto _L7; else goto _L21
_L21:
        g = 6;
        return false;
_L6:
        i1;
        JVM INSTR tableswitch 0 4: default 624
    //                   0 624
    //                   1 638
    //                   2 646
    //                   3 669
    //                   4 705;
           goto _L22 _L22 _L23 _L24 _L25 _L26
_L22:
        g = i1;
        b = k1;
        return true;
_L23:
        g = 6;
        return false;
_L24:
        int k2 = k1 + 1;
        abyte1[k1] = (byte)(i2 >> 4);
        k1 = k2;
        continue; /* Loop/switch isn't completed */
_L25:
        int j2 = k1 + 1;
        abyte1[k1] = (byte)(i2 >> 10);
        k1 = j2 + 1;
        abyte1[j2] = (byte)(i2 >> 2);
        if (true) goto _L22; else goto _L26
_L26:
        g = 6;
        return false;
_L2:
        i2 = j1;
          goto _L27
    }

}
