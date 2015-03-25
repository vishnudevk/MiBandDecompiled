// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

// Referenced classes of package com.google.zxing.qrcode.encoder:
//            ByteMatrix, c, QRCode

final class d
{

    private static final int a[][] = {
        {
            1, 1, 1, 1, 1, 1, 1
        }, {
            1, 0, 0, 0, 0, 0, 1
        }, {
            1, 0, 1, 1, 1, 0, 1
        }, {
            1, 0, 1, 1, 1, 0, 1
        }, {
            1, 0, 1, 1, 1, 0, 1
        }, {
            1, 0, 0, 0, 0, 0, 1
        }, {
            1, 1, 1, 1, 1, 1, 1
        }
    };
    private static final int b[][] = {
        {
            0, 0, 0, 0, 0, 0, 0, 0
        }
    };
    private static final int c[][] = {
        {
            0
        }, {
            0
        }, {
            0
        }, {
            0
        }, {
            0
        }, {
            0
        }, {
            0
        }
    };
    private static final int d[][] = {
        {
            1, 1, 1, 1, 1
        }, {
            1, 0, 0, 0, 1
        }, {
            1, 0, 1, 0, 1
        }, {
            1, 0, 0, 0, 1
        }, {
            1, 1, 1, 1, 1
        }
    };
    private static final int e[][] = {
        {
            -1, -1, -1, -1, -1, -1, -1
        }, {
            6, 18, -1, -1, -1, -1, -1
        }, {
            6, 22, -1, -1, -1, -1, -1
        }, {
            6, 26, -1, -1, -1, -1, -1
        }, {
            6, 30, -1, -1, -1, -1, -1
        }, {
            6, 34, -1, -1, -1, -1, -1
        }, {
            6, 22, 38, -1, -1, -1, -1
        }, {
            6, 24, 42, -1, -1, -1, -1
        }, {
            6, 26, 46, -1, -1, -1, -1
        }, {
            6, 28, 50, -1, -1, -1, -1
        }, {
            6, 30, 54, -1, -1, -1, -1
        }, {
            6, 32, 58, -1, -1, -1, -1
        }, {
            6, 34, 62, -1, -1, -1, -1
        }, {
            6, 26, 46, 66, -1, -1, -1
        }, {
            6, 26, 48, 70, -1, -1, -1
        }, {
            6, 26, 50, 74, -1, -1, -1
        }, {
            6, 30, 54, 78, -1, -1, -1
        }, {
            6, 30, 56, 82, -1, -1, -1
        }, {
            6, 30, 58, 86, -1, -1, -1
        }, {
            6, 34, 62, 90, -1, -1, -1
        }, {
            6, 28, 50, 72, 94, -1, -1
        }, {
            6, 26, 50, 74, 98, -1, -1
        }, {
            6, 30, 54, 78, 102, -1, -1
        }, {
            6, 28, 54, 80, 106, -1, -1
        }, {
            6, 32, 58, 84, 110, -1, -1
        }, {
            6, 30, 58, 86, 114, -1, -1
        }, {
            6, 34, 62, 90, 118, -1, -1
        }, {
            6, 26, 50, 74, 98, 122, -1
        }, {
            6, 30, 54, 78, 102, 126, -1
        }, {
            6, 26, 52, 78, 104, 130, -1
        }, {
            6, 30, 56, 82, 108, 134, -1
        }, {
            6, 34, 60, 86, 112, 138, -1
        }, {
            6, 30, 58, 86, 114, 142, -1
        }, {
            6, 34, 62, 90, 118, 146, -1
        }, {
            6, 30, 54, 78, 102, 126, 150
        }, {
            6, 24, 50, 76, 102, 128, 154
        }, {
            6, 28, 54, 80, 106, 132, 158
        }, {
            6, 32, 58, 84, 110, 136, 162
        }, {
            6, 26, 54, 82, 110, 138, 166
        }, {
            6, 30, 58, 86, 114, 142, 170
        }
    };
    private static final int f[][] = {
        {
            8, 0
        }, {
            8, 1
        }, {
            8, 2
        }, {
            8, 3
        }, {
            8, 4
        }, {
            8, 5
        }, {
            8, 7
        }, {
            8, 8
        }, {
            7, 8
        }, {
            5, 8
        }, {
            4, 8
        }, {
            3, 8
        }, {
            2, 8
        }, {
            1, 8
        }, {
            0, 8
        }
    };
    private static final int g = 7973;
    private static final int h = 1335;
    private static final int i = 21522;

    private d()
    {
    }

    static int a(int j)
    {
        int k;
        for (k = 0; j != 0; k++)
        {
            j >>>= 1;
        }

        return k;
    }

    static int a(int j, int k)
    {
        int l = a(k);
        int i1;
        for (i1 = j << l - 1; a(i1) >= l; i1 ^= k << a(i1) - l) { }
        return i1;
    }

    private static void a(int j, int k, ByteMatrix bytematrix)
    {
        if (b[0].length != 8 || b.length != 1)
        {
            throw new WriterException("Bad horizontal separation pattern");
        }
        for (int l = 0; l < 8; l++)
        {
            if (!b(bytematrix.get(j + l, k)))
            {
                throw new WriterException();
            }
            bytematrix.set(j + l, k, b[0][l]);
        }

    }

    static void a(int j, BitArray bitarray)
    {
        bitarray.appendBits(j, 6);
        bitarray.appendBits(a(j, 7973), 12);
        if (bitarray.getSize() != 18)
        {
            throw new WriterException((new StringBuilder()).append("should not happen but we got: ").append(bitarray.getSize()).toString());
        } else
        {
            return;
        }
    }

    static void a(int j, ByteMatrix bytematrix)
    {
        d(bytematrix);
        c(bytematrix);
        c(j, bytematrix);
        b(bytematrix);
    }

    static void a(BitArray bitarray, int j, ByteMatrix bytematrix)
    {
        int k = -1 + bytematrix.getWidth();
        int l = -1 + bytematrix.getHeight();
        int i1 = -1;
        int j1 = 0;
        while (k > 0) 
        {
            int k1;
            int l1;
            int i2;
            int j2;
            if (k == 6)
            {
                int j3 = k - 1;
                k1 = l;
                l1 = j3;
                i2 = j1;
            } else
            {
                k1 = l;
                l1 = k;
                i2 = j1;
            }
            for (; k1 >= 0 && k1 < bytematrix.getHeight(); k1 += i1)
            {
                int k2 = 0;
                while (k2 < 2) 
                {
                    int l2 = l1 - k2;
                    if (b(bytematrix.get(l2, k1)))
                    {
                        int i3;
                        boolean flag;
                        if (i2 < bitarray.getSize())
                        {
                            boolean flag1 = bitarray.get(i2);
                            i3 = i2 + 1;
                            flag = flag1;
                        } else
                        {
                            i3 = i2;
                            flag = false;
                        }
                        if (j != -1 && com.google.zxing.qrcode.encoder.c.a(j, l2, k1))
                        {
                            if (!flag)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                        }
                        bytematrix.set(l2, k1, flag);
                        i2 = i3;
                    }
                    k2++;
                }
            }

            i1 = -i1;
            j2 = k1 + i1;
            k = l1 - 2;
            j1 = i2;
            l = j2;
        }
        if (j1 != bitarray.getSize())
        {
            throw new WriterException((new StringBuilder()).append("Not all bits consumed: ").append(j1).append('/').append(bitarray.getSize()).toString());
        } else
        {
            return;
        }
    }

    static void a(BitArray bitarray, ErrorCorrectionLevel errorcorrectionlevel, int j, int k, ByteMatrix bytematrix)
    {
        a(bytematrix);
        a(j, bytematrix);
        a(errorcorrectionlevel, k, bytematrix);
        b(j, bytematrix);
        a(bitarray, k, bytematrix);
    }

    static void a(ErrorCorrectionLevel errorcorrectionlevel, int j, BitArray bitarray)
    {
        if (!QRCode.isValidMaskPattern(j))
        {
            throw new WriterException("Invalid mask pattern");
        }
        int k = j | errorcorrectionlevel.getBits() << 3;
        bitarray.appendBits(k, 5);
        bitarray.appendBits(a(k, 1335), 10);
        BitArray bitarray1 = new BitArray();
        bitarray1.appendBits(21522, 15);
        bitarray.xor(bitarray1);
        if (bitarray.getSize() != 15)
        {
            throw new WriterException((new StringBuilder()).append("should not happen but we got: ").append(bitarray.getSize()).toString());
        } else
        {
            return;
        }
    }

    static void a(ErrorCorrectionLevel errorcorrectionlevel, int j, ByteMatrix bytematrix)
    {
        BitArray bitarray = new BitArray();
        a(errorcorrectionlevel, j, bitarray);
        int k = 0;
        while (k < bitarray.getSize()) 
        {
            boolean flag = bitarray.get((-1 + bitarray.getSize()) - k);
            bytematrix.set(f[k][0], f[k][1], flag);
            if (k < 8)
            {
                bytematrix.set(-1 + (bytematrix.getWidth() - k), 8, flag);
            } else
            {
                bytematrix.set(8, -7 + bytematrix.getHeight() + (k - 8), flag);
            }
            k++;
        }
    }

    static void a(ByteMatrix bytematrix)
    {
        bytematrix.clear((byte)-1);
    }

    private static void b(int j, int k, ByteMatrix bytematrix)
    {
        if (c[0].length != 1 || c.length != 7)
        {
            throw new WriterException("Bad vertical separation pattern");
        }
        for (int l = 0; l < 7; l++)
        {
            if (!b(bytematrix.get(j, k + l)))
            {
                throw new WriterException();
            }
            bytematrix.set(j, k + l, c[l][0]);
        }

    }

    static void b(int j, ByteMatrix bytematrix)
    {
        if (j >= 7)
        {
            BitArray bitarray = new BitArray();
            a(j, bitarray);
            int k = 17;
            int l = 0;
            while (l < 6) 
            {
                int i1 = k;
                for (int j1 = 0; j1 < 3; j1++)
                {
                    boolean flag = bitarray.get(i1);
                    i1--;
                    bytematrix.set(l, j1 + (-11 + bytematrix.getHeight()), flag);
                    bytematrix.set(j1 + (-11 + bytematrix.getHeight()), l, flag);
                }

                l++;
                k = i1;
            }
        }
    }

    private static void b(ByteMatrix bytematrix)
    {
        for (int j = 8; j < -8 + bytematrix.getWidth(); j++)
        {
            int k = (j + 1) % 2;
            if (!c(bytematrix.get(j, 6)))
            {
                throw new WriterException();
            }
            if (b(bytematrix.get(j, 6)))
            {
                bytematrix.set(j, 6, k);
            }
            if (!c(bytematrix.get(6, j)))
            {
                throw new WriterException();
            }
            if (b(bytematrix.get(6, j)))
            {
                bytematrix.set(6, j, k);
            }
        }

    }

    private static boolean b(int j)
    {
        return j == -1;
    }

    private static void c(int j, int k, ByteMatrix bytematrix)
    {
        if (d[0].length != 5 || d.length != 5)
        {
            throw new WriterException("Bad position adjustment");
        }
        for (int l = 0; l < 5; l++)
        {
            for (int i1 = 0; i1 < 5; i1++)
            {
                if (!b(bytematrix.get(j + i1, k + l)))
                {
                    throw new WriterException();
                }
                bytematrix.set(j + i1, k + l, d[l][i1]);
            }

        }

    }

    private static void c(int j, ByteMatrix bytematrix)
    {
        if (j >= 2) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k = j - 1;
        int ai[] = e[k];
        int l = e[k].length;
        int i1 = 0;
        do
        {
            if (i1 >= l)
            {
                continue;
            }
            int j1 = 0;
            do
            {
                if (j1 >= l)
                {
                    break;
                }
                int k1 = ai[i1];
                int l1 = ai[j1];
                if (l1 != -1 && k1 != -1 && b(bytematrix.get(l1, k1)))
                {
                    c(l1 - 2, k1 - 2, bytematrix);
                }
                j1++;
            } while (true);
            i1++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    private static void c(ByteMatrix bytematrix)
    {
        if (bytematrix.get(8, -8 + bytematrix.getHeight()) == 0)
        {
            throw new WriterException();
        } else
        {
            bytematrix.set(8, -8 + bytematrix.getHeight(), 1);
            return;
        }
    }

    private static boolean c(int j)
    {
        return j == -1 || j == 0 || j == 1;
    }

    private static void d(int j, int k, ByteMatrix bytematrix)
    {
        if (a[0].length != 7 || a.length != 7)
        {
            throw new WriterException("Bad position detection pattern");
        }
        for (int l = 0; l < 7; l++)
        {
            for (int i1 = 0; i1 < 7; i1++)
            {
                if (!b(bytematrix.get(j + i1, k + l)))
                {
                    throw new WriterException();
                }
                bytematrix.set(j + i1, k + l, a[l][i1]);
            }

        }

    }

    private static void d(ByteMatrix bytematrix)
    {
        int j = a[0].length;
        d(0, 0, bytematrix);
        d(bytematrix.getWidth() - j, 0, bytematrix);
        d(0, bytematrix.getWidth() - j, bytematrix);
        int k = b[0].length;
        a(0, k - 1, bytematrix);
        a(bytematrix.getWidth() - k, k - 1, bytematrix);
        a(0, bytematrix.getWidth() - k, bytematrix);
        int l = c.length;
        b(l, 0, bytematrix);
        b(-1 + (bytematrix.getHeight() - l), 0, bytematrix);
        b(l, bytematrix.getHeight() - l, bytematrix);
    }

}
