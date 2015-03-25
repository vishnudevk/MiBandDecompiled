// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;


// Referenced classes of package com.loopj.android.http:
//            g

class i extends g
{

    public static final int c = 19;
    private static final byte h[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte i[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95
    };
    int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    private final byte j[] = new byte[2];
    private int k;
    private final byte l[];

    public i(int i1, byte abyte0[])
    {
        boolean flag = true;
        super();
        a = abyte0;
        boolean flag1;
        boolean flag2;
        byte abyte1[];
        int j1;
        if ((i1 & 1) == 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        e = flag1;
        if ((i1 & 2) == 0)
        {
            flag2 = flag;
        } else
        {
            flag2 = false;
        }
        f = flag2;
        if ((i1 & 4) == 0)
        {
            flag = false;
        }
        g = flag;
        if ((i1 & 8) == 0)
        {
            abyte1 = h;
        } else
        {
            abyte1 = i;
        }
        l = abyte1;
        d = 0;
        if (f)
        {
            j1 = 19;
        } else
        {
            j1 = -1;
        }
        k = j1;
    }

    public int a(int i1)
    {
        return 10 + (i1 * 8) / 5;
    }

    public boolean a(byte abyte0[], int i1, int j1, boolean flag)
    {
        byte abyte1[];
        byte abyte2[];
        int k1;
        int l1;
        int i2;
        abyte1 = l;
        abyte2 = a;
        k1 = k;
        l1 = j1 + i1;
        i2 = -1;
        d;
        JVM INSTR tableswitch 0 2: default 56
    //                   0 352
    //                   1 358
    //                   2 432;
           goto _L1 _L2 _L3 _L4
_L1:
        int k2 = i1;
_L10:
        int l2 = 0;
        if (i2 == -1) goto _L6; else goto _L5
_L5:
        abyte2[0] = abyte1[0x3f & i2 >> 18];
        abyte2[1] = abyte1[0x3f & i2 >> 12];
        abyte2[2] = abyte1[0x3f & i2 >> 6];
        l2 = 4;
        abyte2[3] = abyte1[i2 & 0x3f];
        if (--k1 != 0) goto _L6; else goto _L7
_L7:
        int j2;
        int i3;
        int j3;
        byte abyte3[];
        int k3;
        byte abyte4[];
        int l3;
        byte abyte5[];
        int i4;
        int j4;
        int k4;
        byte byte0;
        int l4;
        int i5;
        int j5;
        byte byte1;
        int k5;
        int l5;
        int i6;
        int j6;
        int k6;
        int l6;
        int i7;
        byte abyte6[];
        int j7;
        byte abyte7[];
        byte byte2;
        int k7;
        int l7;
        int i8;
        int j8;
        int k8;
        int l8;
        int i9;
        byte abyte8[];
        int j9;
        int k9;
        int l9;
        int i10;
        int j10;
        int k10;
        int l10;
        int i11;
        int j11;
        if (g)
        {
            i10 = 5;
            abyte2[l2] = 13;
        } else
        {
            i10 = l2;
        }
        j10 = i10 + 1;
        abyte2[i10] = 10;
        i3 = 19;
        j3 = j10;
        if (k2 + 3 > l1) goto _L9; else goto _L8
_L8:
        j9 = (0xff & abyte0[k2]) << 16 | (0xff & abyte0[k2 + 1]) << 8 | 0xff & abyte0[k2 + 2];
        abyte2[j3] = abyte1[0x3f & j9 >> 18];
        abyte2[j3 + 1] = abyte1[0x3f & j9 >> 12];
        abyte2[j3 + 2] = abyte1[0x3f & j9 >> 6];
        abyte2[j3 + 3] = abyte1[j9 & 0x3f];
        k2 += 3;
        l2 = j3 + 4;
        k1 = i3 - 1;
        if (k1 == 0)
        {
            if (g)
            {
                k9 = l2 + 1;
                abyte2[l2] = 13;
            } else
            {
                k9 = l2;
            }
            l9 = k9 + 1;
            abyte2[k9] = 10;
            i3 = 19;
            j3 = l9;
            break MISSING_BLOCK_LABEL_174;
        }
          goto _L6
_L2:
        k2 = i1;
          goto _L10
_L3:
        if (i1 + 2 > l1) goto _L1; else goto _L11
_L11:
        k10 = (0xff & j[0]) << 16;
        l10 = i1 + 1;
        i11 = k10 | (0xff & abyte0[i1]) << 8;
        j11 = l10 + 1;
        i2 = i11 | 0xff & abyte0[l10];
        d = 0;
        k2 = j11;
          goto _L10
_L4:
        if (i1 + 1 > l1) goto _L1; else goto _L12
_L12:
        j2 = (0xff & j[0]) << 16 | (0xff & j[1]) << 8;
        k2 = i1 + 1;
        i2 = j2 | 0xff & abyte0[i1];
        d = 0;
          goto _L10
_L9:
        if (!flag) goto _L14; else goto _L13
_L13:
        if (k2 - d != l1 - 1) goto _L16; else goto _L15
_L15:
        if (d > 0)
        {
            abyte8 = j;
            k7 = 1;
            byte2 = abyte8[0];
        } else
        {
            k2 + 1;
            byte2 = abyte0[k2];
            k7 = 0;
        }
        l7 = (byte2 & 0xff) << 4;
        d = d - k7;
        i8 = j3 + 1;
        abyte2[j3] = abyte1[0x3f & l7 >> 6];
        j8 = i8 + 1;
        abyte2[i8] = abyte1[l7 & 0x3f];
        if (e)
        {
            i9 = j8 + 1;
            abyte2[j8] = 61;
            j8 = i9 + 1;
            abyte2[i9] = 61;
        }
        if (f)
        {
            if (g)
            {
                l8 = j8 + 1;
                abyte2[j8] = 13;
                j8 = l8;
            }
            k8 = j8 + 1;
            abyte2[j8] = 10;
            j8 = k8;
        }
        j3 = j8;
_L17:
        b = j3;
        k = i3;
        return true;
_L16:
        if (k2 - d == l1 - 2)
        {
            if (d > 1)
            {
                abyte7 = j;
                i5 = 1;
                byte0 = abyte7[0];
                l4 = k2;
            } else
            {
                k4 = k2 + 1;
                byte0 = abyte0[k2];
                l4 = k4;
                i5 = 0;
            }
            j5 = (byte0 & 0xff) << 10;
            if (d > 0)
            {
                abyte6 = j;
                j7 = i5 + 1;
                byte1 = abyte6[i5];
                i5 = j7;
            } else
            {
                l4 + 1;
                byte1 = abyte0[l4];
            }
            k5 = j5 | (byte1 & 0xff) << 2;
            d = d - i5;
            l5 = j3 + 1;
            abyte2[j3] = abyte1[0x3f & k5 >> 12];
            i6 = l5 + 1;
            abyte2[l5] = abyte1[0x3f & k5 >> 6];
            j6 = i6 + 1;
            abyte2[i6] = abyte1[k5 & 0x3f];
            if (e)
            {
                k6 = j6 + 1;
                abyte2[j6] = 61;
            } else
            {
                k6 = j6;
            }
            if (f)
            {
                if (g)
                {
                    i7 = k6 + 1;
                    abyte2[k6] = 13;
                    k6 = i7;
                }
                l6 = k6 + 1;
                abyte2[k6] = 10;
                k6 = l6;
            }
            j3 = k6;
        } else
        if (f && j3 > 0 && i3 != 19)
        {
            if (g)
            {
                j4 = j3 + 1;
                abyte2[j3] = 13;
            } else
            {
                j4 = j3;
            }
            j3 = j4 + 1;
            abyte2[j4] = 10;
        }
        continue; /* Loop/switch isn't completed */
_L14:
        if (k2 == l1 - 1)
        {
            abyte5 = j;
            i4 = d;
            d = i4 + 1;
            abyte5[i4] = abyte0[k2];
        } else
        if (k2 == l1 - 2)
        {
            abyte3 = j;
            k3 = d;
            d = k3 + 1;
            abyte3[k3] = abyte0[k2];
            abyte4 = j;
            l3 = d;
            d = l3 + 1;
            abyte4[l3] = abyte0[k2 + 1];
        }
        if (true) goto _L17; else goto _L6
_L6:
        i3 = k1;
        j3 = l2;
        break MISSING_BLOCK_LABEL_174;
    }

}
