// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader

public final class Code128Reader extends OneDReader
{

    static final int a[][] = {
        {
            2, 1, 2, 2, 2, 2
        }, {
            2, 2, 2, 1, 2, 2
        }, {
            2, 2, 2, 2, 2, 1
        }, {
            1, 2, 1, 2, 2, 3
        }, {
            1, 2, 1, 3, 2, 2
        }, {
            1, 3, 1, 2, 2, 2
        }, {
            1, 2, 2, 2, 1, 3
        }, {
            1, 2, 2, 3, 1, 2
        }, {
            1, 3, 2, 2, 1, 2
        }, {
            2, 2, 1, 2, 1, 3
        }, {
            2, 2, 1, 3, 1, 2
        }, {
            2, 3, 1, 2, 1, 2
        }, {
            1, 1, 2, 2, 3, 2
        }, {
            1, 2, 2, 1, 3, 2
        }, {
            1, 2, 2, 2, 3, 1
        }, {
            1, 1, 3, 2, 2, 2
        }, {
            1, 2, 3, 1, 2, 2
        }, {
            1, 2, 3, 2, 2, 1
        }, {
            2, 2, 3, 2, 1, 1
        }, {
            2, 2, 1, 1, 3, 2
        }, {
            2, 2, 1, 2, 3, 1
        }, {
            2, 1, 3, 2, 1, 2
        }, {
            2, 2, 3, 1, 1, 2
        }, {
            3, 1, 2, 1, 3, 1
        }, {
            3, 1, 1, 2, 2, 2
        }, {
            3, 2, 1, 1, 2, 2
        }, {
            3, 2, 1, 2, 2, 1
        }, {
            3, 1, 2, 2, 1, 2
        }, {
            3, 2, 2, 1, 1, 2
        }, {
            3, 2, 2, 2, 1, 1
        }, {
            2, 1, 2, 1, 2, 3
        }, {
            2, 1, 2, 3, 2, 1
        }, {
            2, 3, 2, 1, 2, 1
        }, {
            1, 1, 1, 3, 2, 3
        }, {
            1, 3, 1, 1, 2, 3
        }, {
            1, 3, 1, 3, 2, 1
        }, {
            1, 1, 2, 3, 1, 3
        }, {
            1, 3, 2, 1, 1, 3
        }, {
            1, 3, 2, 3, 1, 1
        }, {
            2, 1, 1, 3, 1, 3
        }, {
            2, 3, 1, 1, 1, 3
        }, {
            2, 3, 1, 3, 1, 1
        }, {
            1, 1, 2, 1, 3, 3
        }, {
            1, 1, 2, 3, 3, 1
        }, {
            1, 3, 2, 1, 3, 1
        }, {
            1, 1, 3, 1, 2, 3
        }, {
            1, 1, 3, 3, 2, 1
        }, {
            1, 3, 3, 1, 2, 1
        }, {
            3, 1, 3, 1, 2, 1
        }, {
            2, 1, 1, 3, 3, 1
        }, {
            2, 3, 1, 1, 3, 1
        }, {
            2, 1, 3, 1, 1, 3
        }, {
            2, 1, 3, 3, 1, 1
        }, {
            2, 1, 3, 1, 3, 1
        }, {
            3, 1, 1, 1, 2, 3
        }, {
            3, 1, 1, 3, 2, 1
        }, {
            3, 3, 1, 1, 2, 1
        }, {
            3, 1, 2, 1, 1, 3
        }, {
            3, 1, 2, 3, 1, 1
        }, {
            3, 3, 2, 1, 1, 1
        }, {
            3, 1, 4, 1, 1, 1
        }, {
            2, 2, 1, 4, 1, 1
        }, {
            4, 3, 1, 1, 1, 1
        }, {
            1, 1, 1, 2, 2, 4
        }, {
            1, 1, 1, 4, 2, 2
        }, {
            1, 2, 1, 1, 2, 4
        }, {
            1, 2, 1, 4, 2, 1
        }, {
            1, 4, 1, 1, 2, 2
        }, {
            1, 4, 1, 2, 2, 1
        }, {
            1, 1, 2, 2, 1, 4
        }, {
            1, 1, 2, 4, 1, 2
        }, {
            1, 2, 2, 1, 1, 4
        }, {
            1, 2, 2, 4, 1, 1
        }, {
            1, 4, 2, 1, 1, 2
        }, {
            1, 4, 2, 2, 1, 1
        }, {
            2, 4, 1, 2, 1, 1
        }, {
            2, 2, 1, 1, 1, 4
        }, {
            4, 1, 3, 1, 1, 1
        }, {
            2, 4, 1, 1, 1, 2
        }, {
            1, 3, 4, 1, 1, 1
        }, {
            1, 1, 1, 2, 4, 2
        }, {
            1, 2, 1, 1, 4, 2
        }, {
            1, 2, 1, 2, 4, 1
        }, {
            1, 1, 4, 2, 1, 2
        }, {
            1, 2, 4, 1, 1, 2
        }, {
            1, 2, 4, 2, 1, 1
        }, {
            4, 1, 1, 2, 1, 2
        }, {
            4, 2, 1, 1, 1, 2
        }, {
            4, 2, 1, 2, 1, 1
        }, {
            2, 1, 2, 1, 4, 1
        }, {
            2, 1, 4, 1, 2, 1
        }, {
            4, 1, 2, 1, 2, 1
        }, {
            1, 1, 1, 1, 4, 3
        }, {
            1, 1, 1, 3, 4, 1
        }, {
            1, 3, 1, 1, 4, 1
        }, {
            1, 1, 4, 1, 1, 3
        }, {
            1, 1, 4, 3, 1, 1
        }, {
            4, 1, 1, 1, 1, 3
        }, {
            4, 1, 1, 3, 1, 1
        }, {
            1, 1, 3, 1, 4, 1
        }, {
            1, 1, 4, 1, 3, 1
        }, {
            3, 1, 1, 1, 4, 1
        }, {
            4, 1, 1, 1, 3, 1
        }, {
            2, 1, 1, 4, 1, 2
        }, {
            2, 1, 1, 2, 1, 4
        }, {
            2, 1, 1, 2, 3, 2
        }, {
            2, 3, 3, 1, 1, 1, 2
        }
    };
    private static final int b = 64;
    private static final int c = 179;
    private static final int d = 98;
    private static final int e = 99;
    private static final int f = 100;
    private static final int g = 101;
    private static final int h = 102;
    private static final int i = 97;
    private static final int j = 96;
    private static final int k = 101;
    private static final int l = 100;
    private static final int m = 103;
    private static final int n = 104;
    private static final int o = 105;
    private static final int p = 106;

    public Code128Reader()
    {
    }

    private static int a(BitArray bitarray, int ai[], int i1)
    {
        recordPattern(bitarray, i1, ai);
        int j1 = 64;
        int k1 = -1;
        for (int l1 = 0; l1 < a.length; l1++)
        {
            int i2 = patternMatchVariance(ai, a[l1], 179);
            if (i2 < j1)
            {
                k1 = l1;
                j1 = i2;
            }
        }

        if (k1 >= 0)
        {
            return k1;
        } else
        {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private static int[] a(BitArray bitarray)
    {
        int i1 = bitarray.getSize();
        int j1 = bitarray.getNextSet(0);
        int ai[] = new int[6];
        int k1 = ai.length;
        int l1 = j1;
        boolean flag = false;
        int i2 = j1;
        int j2 = 0;
        while (l1 < i1) 
        {
            int k2;
            boolean flag1;
            if (flag ^ bitarray.get(l1))
            {
                ai[j2] = 1 + ai[j2];
                flag1 = flag;
                k2 = j2;
            } else
            {
                if (j2 == k1 - 1)
                {
                    int i3 = 64;
                    int j3 = -1;
                    int k3 = 103;
                    while (k3 <= 105) 
                    {
                        int l3 = patternMatchVariance(ai, a[k3], 179);
                        int l2;
                        if (l3 < i3)
                        {
                            j3 = k3;
                        } else
                        {
                            l3 = i3;
                        }
                        k3++;
                        i3 = l3;
                    }
                    if (j3 >= 0 && bitarray.isRange(Math.max(0, i2 - (l1 - i2) / 2), i2, false))
                    {
                        return (new int[] {
                            i2, l1, j3
                        });
                    }
                    l2 = i2 + (ai[0] + ai[1]);
                    System.arraycopy(ai, 2, ai, 0, k1 - 2);
                    ai[k1 - 2] = 0;
                    ai[k1 - 1] = 0;
                    k2 = j2 - 1;
                } else
                {
                    k2 = j2 + 1;
                    l2 = i2;
                }
                ai[k2] = 1;
                if (!flag)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                i2 = l2;
            }
            l1++;
            flag = flag1;
            j2 = k2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public Result decodeRow(int i1, BitArray bitarray, Map map)
    {
        int ai[];
        int j1;
        ai = a(bitarray);
        j1 = ai[2];
        j1;
        JVM INSTR tableswitch 103 105: default 40
    //                   103 44
    //                   104 212
    //                   105 219;
           goto _L1 _L2 _L3 _L4
_L1:
        throw FormatException.getFormatInstance();
_L2:
        byte byte0 = 101;
_L39:
        StringBuilder stringbuilder;
        ArrayList arraylist;
        int l1;
        int ai1[];
        boolean flag;
        boolean flag1;
        int i2;
        byte byte1;
        int j2;
        int k2;
        int l2;
        int i3;
        boolean flag2;
        stringbuilder = new StringBuilder(20);
        arraylist = new ArrayList(20);
        int k1 = ai[0];
        l1 = ai[1];
        ai1 = new int[6];
        flag = true;
        flag1 = false;
        i2 = k1;
        byte1 = byte0;
        j2 = 0;
        k2 = j1;
        l2 = 0;
        i3 = 0;
        flag2 = false;
_L14:
        if (flag2) goto _L6; else goto _L5
_L5:
        int j4;
        int i5;
        j4 = a(bitarray, ai1, l1);
        arraylist.add(Byte.valueOf((byte)j4));
        if (j4 != 106)
        {
            flag = true;
        }
        if (j4 != 106)
        {
            j2++;
            k2 += j2 * j4;
        }
        int k4 = ai1.length;
        int l4 = 0;
        i5 = l1;
        for (; l4 < k4; l4++)
        {
            i5 += ai1[l4];
        }

          goto _L7
_L3:
        byte0 = 100;
        continue; /* Loop/switch isn't completed */
_L4:
        byte0 = 99;
        continue; /* Loop/switch isn't completed */
_L7:
        j4;
        JVM INSTR tableswitch 103 105: default 256
    //                   103 358
    //                   104 358
    //                   105 358;
           goto _L8 _L9 _L9 _L9
_L8:
        byte1;
        JVM INSTR tableswitch 99 101: default 284
    //                   99 762
    //                   100 582
    //                   101 362;
           goto _L10 _L11 _L12 _L13
_L10:
        boolean flag4;
        boolean flag5;
        byte byte2;
        boolean flag6;
        boolean flag11 = flag;
        flag4 = flag2;
        flag5 = flag11;
        byte2 = byte1;
        flag6 = false;
_L17:
        boolean flag3;
        boolean flag7;
        boolean flag8;
        boolean flag9;
        boolean flag10;
        boolean flag12;
        boolean flag13;
        boolean flag14;
        boolean flag15;
        boolean flag16;
        boolean flag17;
        boolean flag18;
        boolean flag19;
        boolean flag20;
        boolean flag21;
        if (flag1)
        {
            if (byte2 == 101)
            {
                byte2 = 100;
            } else
            {
                byte2 = 101;
            }
        }
        i2 = l1;
        flag1 = flag6;
        l1 = i5;
        byte1 = byte2;
        l2 = i3;
        i3 = j4;
        flag7 = flag4;
        flag = flag5;
        flag2 = flag7;
          goto _L14
_L9:
        throw FormatException.getFormatInstance();
_L13:
        if (j4 >= 64) goto _L16; else goto _L15
_L15:
        stringbuilder.append((char)(j4 + 32));
        flag21 = flag;
        flag4 = flag2;
        flag5 = flag21;
        byte2 = byte1;
        flag6 = false;
          goto _L17
_L16:
        if (j4 >= 96) goto _L19; else goto _L18
_L18:
        stringbuilder.append((char)(j4 - 64));
        flag20 = flag;
        flag4 = flag2;
        flag5 = flag20;
        byte2 = byte1;
        flag6 = false;
          goto _L17
_L19:
        if (j4 != 106)
        {
            flag = false;
        }
        flag17 = false;
        j4;
        JVM INSTR tableswitch 96 106: default 516
    //                   96 516
    //                   97 516
    //                   98 543
    //                   99 563
    //                   100 553
    //                   101 516
    //                   102 516
    //                   103 516
    //                   104 516
    //                   105 516
    //                   106 573;
           goto _L20 _L20 _L20 _L21 _L22 _L23 _L20 _L20 _L20 _L20 _L20 _L24
_L20:
        flag18 = flag;
        flag4 = flag2;
        flag5 = flag18;
        flag19 = flag17;
        byte2 = byte1;
        flag6 = flag19;
          goto _L17
_L21:
        flag17 = true;
        byte1 = 100;
          goto _L20
_L23:
        byte1 = 100;
        flag17 = false;
          goto _L20
_L22:
        byte1 = 99;
        flag17 = false;
          goto _L20
_L24:
        flag2 = true;
        flag17 = false;
          goto _L20
_L12:
        if (j4 >= 96) goto _L26; else goto _L25
_L25:
        stringbuilder.append((char)(j4 + 32));
        flag16 = flag;
        flag4 = flag2;
        flag5 = flag16;
        byte2 = byte1;
        flag6 = false;
          goto _L17
_L26:
        if (j4 != 106)
        {
            flag = false;
        }
        flag13 = false;
        j4;
        JVM INSTR tableswitch 96 106: default 696
    //                   96 696
    //                   97 696
    //                   98 723
    //                   99 743
    //                   100 696
    //                   101 733
    //                   102 696
    //                   103 696
    //                   104 696
    //                   105 696
    //                   106 753;
           goto _L27 _L27 _L27 _L28 _L29 _L27 _L30 _L27 _L27 _L27 _L27 _L31
_L27:
        flag14 = flag;
        flag4 = flag2;
        flag5 = flag14;
        flag15 = flag13;
        byte2 = byte1;
        flag6 = flag15;
          goto _L17
_L28:
        flag13 = true;
        byte1 = 101;
          goto _L27
_L30:
        byte1 = 101;
        flag13 = false;
          goto _L27
_L29:
        byte1 = 99;
        flag13 = false;
          goto _L27
_L31:
        flag2 = true;
        flag13 = false;
          goto _L27
_L11:
        if (j4 >= 100) goto _L33; else goto _L32
_L32:
        if (j4 < 10)
        {
            stringbuilder.append('0');
        }
        stringbuilder.append(j4);
        flag12 = flag;
        flag4 = flag2;
        flag5 = flag12;
        byte2 = byte1;
        flag6 = false;
          goto _L17
_L33:
        if (j4 != 106)
        {
            flag = false;
        }
        j4;
        JVM INSTR tableswitch 100 106: default 868
    //                   100 871
    //                   101 915
    //                   102 893
    //                   103 868
    //                   104 868
    //                   105 868
    //                   106 937;
           goto _L10 _L34 _L35 _L36 _L10 _L10 _L10 _L37
_L34:
        flag10 = flag;
        flag4 = flag2;
        flag5 = flag10;
        byte2 = 100;
        flag6 = false;
          goto _L17
_L36:
        flag9 = flag;
        flag4 = flag2;
        flag5 = flag9;
        byte2 = byte1;
        flag6 = false;
          goto _L17
_L35:
        flag8 = flag;
        flag4 = flag2;
        flag5 = flag8;
        byte2 = 101;
        flag6 = false;
          goto _L17
_L37:
        flag3 = flag;
        flag4 = true;
        flag5 = flag3;
        byte2 = byte1;
        flag6 = false;
          goto _L17
_L6:
        int j3 = bitarray.getNextUnset(l1);
        if (!bitarray.isRange(j3, Math.min(bitarray.getSize(), j3 + (j3 - i2) / 2), false))
        {
            throw NotFoundException.getNotFoundInstance();
        }
        if ((k2 - j2 * l2) % 103 != l2)
        {
            throw ChecksumException.getChecksumInstance();
        }
        int k3 = stringbuilder.length();
        if (k3 == 0)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        float f1;
        float f2;
        int l3;
        byte abyte0[];
        if (k3 > 0 && flag)
        {
            if (byte1 == 99)
            {
                stringbuilder.delete(k3 - 2, k3);
            } else
            {
                stringbuilder.delete(k3 - 1, k3);
            }
        }
        f1 = (float)(ai[1] + ai[0]) / 2.0F;
        f2 = (float)(j3 + i2) / 2.0F;
        l3 = arraylist.size();
        abyte0 = new byte[l3];
        for (int i4 = 0; i4 < l3; i4++)
        {
            abyte0[i4] = ((Byte)arraylist.get(i4)).byteValue();
        }

        String s = stringbuilder.toString();
        ResultPoint aresultpoint[] = new ResultPoint[2];
        aresultpoint[0] = new ResultPoint(f1, i1);
        aresultpoint[1] = new ResultPoint(f2, i1);
        return new Result(s, abyte0, aresultpoint, BarcodeFormat.CODE_128);
        if (true) goto _L39; else goto _L38
_L38:
    }

}
