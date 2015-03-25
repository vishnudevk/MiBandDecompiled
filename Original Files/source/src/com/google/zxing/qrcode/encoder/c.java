// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.encoder;


// Referenced classes of package com.google.zxing.qrcode.encoder:
//            ByteMatrix, QRCode

final class c
{

    private c()
    {
    }

    static int a(ByteMatrix bytematrix)
    {
        return a(bytematrix, true) + a(bytematrix, false);
    }

    private static int a(ByteMatrix bytematrix, boolean flag)
    {
        byte byte0 = -1;
        int i;
        int j;
        byte abyte0[][];
        int k;
        int l;
        if (flag)
        {
            i = bytematrix.getHeight();
        } else
        {
            i = bytematrix.getWidth();
        }
        if (flag)
        {
            j = bytematrix.getWidth();
        } else
        {
            j = bytematrix.getHeight();
        }
        abyte0 = bytematrix.getArray();
        k = 0;
        l = 0;
        do
        {
            if (k >= i)
            {
                break;
            }
            int i1 = 0;
            int j1 = 0;
            while (i1 < j) 
            {
                byte byte1;
                int k1;
                if (flag)
                {
                    byte1 = abyte0[k][i1];
                } else
                {
                    byte1 = abyte0[i1][k];
                }
                if (byte1 == byte0)
                {
                    k1 = j1 + 1;
                    if (k1 == 5)
                    {
                        l += 3;
                    } else
                    if (k1 > 5)
                    {
                        l++;
                    }
                } else
                {
                    byte byte2 = byte1;
                    k1 = 1;
                    byte0 = byte2;
                }
                i1++;
                j1 = k1;
            }
            k++;
        } while (true);
        return l;
    }

    static boolean a(int i, int j, int k)
    {
        if (!QRCode.isValidMaskPattern(i))
        {
            throw new IllegalArgumentException("Invalid mask pattern");
        }
        i;
        JVM INSTR tableswitch 0 7: default 64
    //                   0 91
    //                   1 103
    //                   2 110
    //                   3 117
    //                   4 126
    //                   5 139
    //                   6 157
    //                   7 177;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L9:
        break MISSING_BLOCK_LABEL_177;
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Invalid mask pattern: ").append(i).toString());
_L2:
        int l = 1 & k + j;
_L10:
        return l == 0;
_L3:
        l = k & 1;
          goto _L10
_L4:
        l = j % 3;
          goto _L10
_L5:
        l = (k + j) % 3;
          goto _L10
_L6:
        l = 1 & (k >>> 1) + j / 3;
          goto _L10
_L7:
        int j1 = k * j;
        l = (j1 & 1) + j1 % 3;
          goto _L10
_L8:
        int i1 = k * j;
        l = 1 & (i1 & 1) + i1 % 3;
          goto _L10
        l = 1 & (k * j) % 3 + (1 & k + j);
          goto _L10
    }

    static int b(ByteMatrix bytematrix)
    {
        byte abyte0[][] = bytematrix.getArray();
        int i = bytematrix.getWidth();
        int j = bytematrix.getHeight();
        int k = 0;
        int l = 0;
        for (; k < j - 1; k++)
        {
            for (int i1 = 0; i1 < i - 1; i1++)
            {
                byte byte0 = abyte0[k][i1];
                if (byte0 == abyte0[k][i1 + 1] && byte0 == abyte0[k + 1][i1] && byte0 == abyte0[k + 1][i1 + 1])
                {
                    l += 3;
                }
            }

        }

        return l;
    }

    static int c(ByteMatrix bytematrix)
    {
        byte abyte0[][] = bytematrix.getArray();
        int i = bytematrix.getWidth();
        int j = bytematrix.getHeight();
        int k = 0;
        int l = 0;
        for (; k < j; k++)
        {
            for (int i1 = 0; i1 < i; i1++)
            {
                if (i1 + 6 < i && abyte0[k][i1] == 1 && abyte0[k][i1 + 1] == 0 && abyte0[k][i1 + 2] == 1 && abyte0[k][i1 + 3] == 1 && abyte0[k][i1 + 4] == 1 && abyte0[k][i1 + 5] == 0 && abyte0[k][i1 + 6] == 1 && (i1 + 10 < i && abyte0[k][i1 + 7] == 0 && abyte0[k][i1 + 8] == 0 && abyte0[k][i1 + 9] == 0 && abyte0[k][i1 + 10] == 0 || i1 - 4 >= 0 && abyte0[k][i1 - 1] == 0 && abyte0[k][i1 - 2] == 0 && abyte0[k][i1 - 3] == 0 && abyte0[k][i1 - 4] == 0))
                {
                    l += 40;
                }
                if (k + 6 < j && abyte0[k][i1] == 1 && abyte0[k + 1][i1] == 0 && abyte0[k + 2][i1] == 1 && abyte0[k + 3][i1] == 1 && abyte0[k + 4][i1] == 1 && abyte0[k + 5][i1] == 0 && abyte0[k + 6][i1] == 1 && (k + 10 < j && abyte0[k + 7][i1] == 0 && abyte0[k + 8][i1] == 0 && abyte0[k + 9][i1] == 0 && abyte0[k + 10][i1] == 0 || k - 4 >= 0 && abyte0[k - 1][i1] == 0 && abyte0[k - 2][i1] == 0 && abyte0[k - 3][i1] == 0 && abyte0[k - 4][i1] == 0))
                {
                    l += 40;
                }
            }

        }

        return l;
    }

    static int d(ByteMatrix bytematrix)
    {
        byte abyte0[][] = bytematrix.getArray();
        int i = bytematrix.getWidth();
        int j = bytematrix.getHeight();
        int k = 0;
        int l = 0;
        for (; k < j; k++)
        {
            for (int j1 = 0; j1 < i; j1++)
            {
                if (abyte0[k][j1] == 1)
                {
                    l++;
                }
            }

        }

        int i1 = bytematrix.getHeight() * bytematrix.getWidth();
        return 10 * (Math.abs((int)(100D * ((double)l / (double)i1) - 50D)) / 5);
    }
}
