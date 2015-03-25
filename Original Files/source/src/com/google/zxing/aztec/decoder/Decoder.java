// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.aztec.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

// Referenced classes of package com.google.zxing.aztec.decoder:
//            b, a

public final class Decoder
{

    private static final int a[] = {
        0, 104, 240, 408, 608
    };
    private static final int b[] = {
        0, 128, 288, 480, 704, 960, 1248, 1568, 1920, 2304, 
        2720, 3168, 3648, 4160, 4704, 5280, 5888, 6528, 7200, 7904, 
        8640, 9408, 10208, 11040, 11904, 12800, 13728, 14688, 15680, 16704, 
        17760, 18848, 19968
    };
    private static final int c[] = {
        0, 17, 40, 51, 76
    };
    private static final int d[] = {
        0, 21, 48, 60, 88, 120, 156, 196, 240, 230, 
        272, 316, 364, 416, 470, 528, 588, 652, 720, 790, 
        864, 940, 1020, 920, 992, 1066, 1144, 1224, 1306, 1392, 
        1480, 1570, 1664
    };
    private static final String e[] = {
        "CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", 
        "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", 
        "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", 
        "CTRL_DL", "CTRL_BS"
    };
    private static final String f[] = {
        "CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", 
        "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", 
        "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", 
        "CTRL_DL", "CTRL_BS"
    };
    private static final String g[] = {
        "CTRL_PS", " ", "\001", "\002", "\003", "\004", "\005", "\006", "\007", "\b", 
        "\t", "\n", "\013", "\f", "\r", "\033", "\034", "\035", "\036", "\037", 
        "@", "\\", "^", "_", "`", "|", "~", "\177", "CTRL_LL", "CTRL_UL", 
        "CTRL_PL", "CTRL_BS"
    };
    private static final String h[] = {
        "", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", 
        "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", 
        "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", 
        "}", "CTRL_UL"
    };
    private static final String i[] = {
        "CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", 
        "8", "9", ",", ".", "CTRL_UL", "CTRL_US"
    };
    private int j;
    private int k;
    private AztecDetectorResult l;
    private int m;

    public Decoder()
    {
    }

    private static int a(boolean aflag[], int i1, int j1)
    {
        int k1 = 0;
        for (int l1 = i1; l1 < i1 + j1; l1++)
        {
            k1 <<= 1;
            if (aflag[l1])
            {
                k1++;
            }
        }

        return k1;
    }

    private static b a(char c1)
    {
        switch (c1)
        {
        default:
            return b.a;

        case 76: // 'L'
            return b.b;

        case 80: // 'P'
            return b.e;

        case 77: // 'M'
            return b.c;

        case 68: // 'D'
            return b.d;

        case 66: // 'B'
            return b.f;
        }
    }

    private static String a(b b1, int i1)
    {
        switch (a.a[b1.ordinal()])
        {
        default:
            return "";

        case 2: // '\002'
            return e[i1];

        case 3: // '\003'
            return f[i1];

        case 4: // '\004'
            return g[i1];

        case 5: // '\005'
            return h[i1];

        case 6: // '\006'
            return i[i1];
        }
    }

    private String a(boolean aflag[])
    {
        int i1;
        b b1;
        b b2;
        int j1;
        StringBuilder stringbuilder;
        boolean flag;
        boolean flag1;
        boolean flag2;
        i1 = k * l.getNbDatablocks() - m;
        if (i1 > aflag.length)
        {
            throw FormatException.getFormatInstance();
        }
        b1 = b.a;
        b2 = b.a;
        j1 = 0;
        stringbuilder = new StringBuilder(20);
        flag = false;
        flag1 = false;
        flag2 = false;
_L3:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_362;
        }
        boolean flag9;
        if (flag1)
        {
            flag2 = true;
        } else
        {
            b1 = b2;
        }
        a.a[b2.ordinal()];
        JVM INSTR tableswitch 1 1: default 100
    //                   1 173;
           goto _L1 _L2
_L1:
        byte byte0 = 5;
        if (b2 == b.d)
        {
            byte0 = 4;
        }
        int k1;
        int l1;
        boolean flag3;
        boolean flag4;
        int i2;
        b b3;
        boolean flag5;
        boolean flag7;
        if (i1 - j1 < byte0)
        {
            flag9 = flag1;
            flag4 = true;
            i2 = j1;
            b3 = b2;
            flag5 = flag9;
        } else
        {
            int j2 = a(aflag, j1, byte0);
            int k2 = j1 + byte0;
            String s = a(b2, j2);
            if (s.startsWith("CTRL_"))
            {
                b b4 = a(s.charAt(5));
                boolean flag6;
                boolean flag8;
                if (s.charAt(6) == 'S')
                {
                    flag5 = true;
                    flag4 = flag;
                    i2 = k2;
                    b3 = b4;
                } else
                {
                    flag5 = flag1;
                    flag4 = flag;
                    i2 = k2;
                    b3 = b4;
                }
            } else
            {
                stringbuilder.append(s);
                flag8 = flag1;
                flag4 = flag;
                i2 = k2;
                b3 = b2;
                flag5 = flag8;
            }
        }
_L4:
        if (flag2)
        {
            j1 = i2;
            flag = flag4;
            b2 = b1;
            flag2 = false;
            flag1 = false;
        } else
        {
            flag6 = flag5;
            b2 = b3;
            j1 = i2;
            flag = flag4;
            flag1 = flag6;
        }
        if (true) goto _L3; else goto _L2
_L2:
        if (i1 - j1 < 8)
        {
            flag7 = flag1;
            flag4 = true;
            i2 = j1;
            b3 = b2;
            flag5 = flag7;
        } else
        {
            k1 = a(aflag, j1, 8);
            l1 = j1 + 8;
            stringbuilder.append((char)k1);
            flag3 = flag1;
            flag4 = flag;
            i2 = l1;
            b3 = b2;
            flag5 = flag3;
        }
          goto _L4
        return stringbuilder.toString();
    }

    private boolean[] a(BitMatrix bitmatrix)
    {
        boolean aflag[];
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        if (l.isCompact())
        {
            if (l.getNbLayers() > a.length)
            {
                throw FormatException.getFormatInstance();
            }
            aflag = new boolean[a[l.getNbLayers()]];
            j = c[l.getNbLayers()];
        } else
        {
            if (l.getNbLayers() > b.length)
            {
                throw FormatException.getFormatInstance();
            }
            aflag = new boolean[b[l.getNbLayers()]];
            j = d[l.getNbLayers()];
        }
        i1 = l.getNbLayers();
        j1 = bitmatrix.getHeight();
        k1 = 0;
        l1 = 0;
        i2 = j1;
        for (int j2 = i1; j2 != 0;)
        {
            int k2 = 0;
            int l2 = 0;
            for (; k2 < -4 + i2 * 2; k2++)
            {
                aflag[l1 + k2] = bitmatrix.get(k1 + l2, k1 + k2 / 2);
                aflag[k2 + (-4 + (l1 + i2 * 2))] = bitmatrix.get(k1 + k2 / 2, (-1 + (k1 + i2)) - l2);
                l2 = (l2 + 1) % 2;
            }

            int i3 = 1 + i2 * 2;
            int j3 = 0;
            for (; i3 > 5; i3--)
            {
                aflag[1 + (-8 + (l1 + i2 * 4) + (i2 * 2 - i3))] = bitmatrix.get((-1 + (k1 + i2)) - j3, -1 + (k1 + i3 / 2));
                aflag[1 + (-12 + (l1 + i2 * 6) + (i2 * 2 - i3))] = bitmatrix.get(-1 + (k1 + i3 / 2), k1 + j3);
                j3 = (j3 + 1) % 2;
            }

            int k3 = k1 + 2;
            int l3 = l1 + (-16 + i2 * 8);
            int i4 = j2 - 1;
            i2 -= 4;
            j2 = i4;
            k1 = k3;
            l1 = l3;
        }

        return aflag;
    }

    private static BitMatrix b(BitMatrix bitmatrix)
    {
        int i1 = 1 + 2 * ((-1 + bitmatrix.getWidth()) / 2 / 16);
        BitMatrix bitmatrix1 = new BitMatrix(bitmatrix.getWidth() - i1, bitmatrix.getHeight() - i1);
        int j1 = 0;
        int k1 = 0;
        while (j1 < bitmatrix.getWidth()) 
        {
            if ((bitmatrix.getWidth() / 2 - j1) % 16 != 0)
            {
                int l1 = 0;
                int i2 = 0;
                while (l1 < bitmatrix.getHeight()) 
                {
                    if ((bitmatrix.getWidth() / 2 - l1) % 16 != 0)
                    {
                        if (bitmatrix.get(j1, l1))
                        {
                            bitmatrix1.set(k1, i2);
                        }
                        i2++;
                    }
                    l1++;
                }
                k1++;
            }
            j1++;
        }
        return bitmatrix1;
    }

    private boolean[] b(boolean aflag[])
    {
        GenericGF genericgf;
        int i1;
        int j1;
        int k1;
        int ai[];
        if (l.getNbLayers() <= 2)
        {
            k = 6;
            genericgf = GenericGF.AZTEC_DATA_6;
        } else
        if (l.getNbLayers() <= 8)
        {
            k = 8;
            genericgf = GenericGF.AZTEC_DATA_8;
        } else
        if (l.getNbLayers() <= 22)
        {
            k = 10;
            genericgf = GenericGF.AZTEC_DATA_10;
        } else
        {
            k = 12;
            genericgf = GenericGF.AZTEC_DATA_12;
        }
        i1 = l.getNbDatablocks();
        if (l.isCompact())
        {
            j1 = a[l.getNbLayers()] - j * k;
            k1 = c[l.getNbLayers()] - i1;
        } else
        {
            j1 = b[l.getNbLayers()] - j * k;
            k1 = d[l.getNbLayers()] - i1;
        }
        ai = new int[j];
        for (int l1 = 0; l1 < j; l1++)
        {
            int l3 = 1;
            int i4 = 1;
            for (; l3 <= k; l3++)
            {
                if (aflag[j1 + ((l1 * k + k) - l3)])
                {
                    ai[l1] = i4 + ai[l1];
                }
                i4 <<= 1;
            }

        }

        boolean aflag1[];
        int i2;
        try
        {
            (new ReedSolomonDecoder(genericgf)).decode(ai, k1);
        }
        catch (ReedSolomonException reedsolomonexception)
        {
            throw FormatException.getFormatInstance();
        }
        m = 0;
        aflag1 = new boolean[i1 * k];
        i2 = 0;
        int i3;
        for (int j2 = 0; i2 < i1; j2 = i3)
        {
            int k2 = 1 << -1 + k;
            int l2 = 0;
            boolean flag = false;
            i3 = j2;
            int j3 = k2;
            int k3 = 0;
            while (k3 < k) 
            {
                boolean flag1;
                if ((j3 & ai[i2]) == j3)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (l2 == -1 + k)
                {
                    if (flag1 == flag)
                    {
                        throw FormatException.getFormatInstance();
                    }
                    i3++;
                    m = 1 + m;
                    l2 = 0;
                    flag = false;
                } else
                {
                    if (flag == flag1)
                    {
                        l2++;
                    } else
                    {
                        l2 = 1;
                        flag = flag1;
                    }
                    aflag1[(k3 + i2 * k) - i3] = flag1;
                }
                j3 >>>= 1;
                k3++;
            }
            i2++;
        }

        return aflag1;
    }

    public DecoderResult decode(AztecDetectorResult aztecdetectorresult)
    {
        l = aztecdetectorresult;
        BitMatrix bitmatrix = aztecdetectorresult.getBits();
        if (!l.isCompact())
        {
            bitmatrix = b(l.getBits());
        }
        return new DecoderResult(null, a(b(a(bitmatrix))), null, null);
    }

}
