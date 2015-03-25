// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader, b, a

public abstract class UPCEANReader extends OneDReader
{

    private static final int a = 122;
    static final int b[] = {
        1, 1, 1
    };
    static final int c[] = {
        1, 1, 1, 1, 1
    };
    static final int d[][] = {
        {
            3, 2, 1, 1
        }, {
            2, 2, 2, 1
        }, {
            2, 1, 2, 2
        }, {
            1, 4, 1, 1
        }, {
            1, 1, 3, 2
        }, {
            1, 2, 3, 1
        }, {
            1, 1, 1, 4
        }, {
            1, 3, 1, 2
        }, {
            1, 2, 1, 3
        }, {
            3, 1, 1, 2
        }
    };
    static final int e[][];
    private static final int f = 179;
    private final StringBuilder g = new StringBuilder(20);
    private final b h = new b();
    private final a i = new a();

    protected UPCEANReader()
    {
    }

    static int a(BitArray bitarray, int ai[], int j, int ai1[][])
    {
        recordPattern(bitarray, j, ai);
        int k = 122;
        int l = -1;
        int i1 = ai1.length;
        int j1 = 0;
        while (j1 < i1) 
        {
            int k1 = patternMatchVariance(ai, ai1[j1], 179);
            if (k1 < k)
            {
                l = j1;
            } else
            {
                k1 = k;
            }
            j1++;
            k = k1;
        }
        if (l >= 0)
        {
            return l;
        } else
        {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private static boolean a(CharSequence charsequence)
    {
        int j = charsequence.length();
        if (j != 0)
        {
            int k = j - 2;
            int l = 0;
            for (; k >= 0; k -= 2)
            {
                int l1 = -48 + charsequence.charAt(k);
                if (l1 < 0 || l1 > 9)
                {
                    throw FormatException.getFormatInstance();
                }
                l += l1;
            }

            int i1 = l * 3;
            for (int j1 = j - 1; j1 >= 0; j1 -= 2)
            {
                int k1 = -48 + charsequence.charAt(j1);
                if (k1 < 0 || k1 > 9)
                {
                    throw FormatException.getFormatInstance();
                }
                i1 += k1;
            }

            if (i1 % 10 == 0)
            {
                return true;
            }
        }
        return false;
    }

    static int[] a(BitArray bitarray)
    {
        int ai[] = new int[b.length];
        int j = 0;
        int ai1[] = null;
        boolean flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            Arrays.fill(ai, 0, b.length, 0);
            ai1 = a(bitarray, j, false, b, ai);
            int k = ai1[0];
            j = ai1[1];
            int l = k - (j - k);
            if (l >= 0)
            {
                flag = bitarray.isRange(l, k, false);
            }
        } while (true);
        return ai1;
    }

    static int[] a(BitArray bitarray, int j, boolean flag, int ai[])
    {
        return a(bitarray, j, flag, ai, new int[ai.length]);
    }

    static int[] a(BitArray bitarray, int j, boolean flag, int ai[], int ai1[])
    {
        int k = ai.length;
        int l = bitarray.getSize();
        int i1;
        int j1;
        int k1;
        boolean flag1;
        if (flag)
        {
            i1 = bitarray.getNextUnset(j);
        } else
        {
            i1 = bitarray.getNextSet(j);
        }
        j1 = i1;
        k1 = 0;
        flag1 = flag;
        while (j1 < l) 
        {
            if (flag1 ^ bitarray.get(j1))
            {
                ai1[k1] = 1 + ai1[k1];
            } else
            {
                if (k1 == k - 1)
                {
                    if (patternMatchVariance(ai1, ai, 179) < 122)
                    {
                        return (new int[] {
                            i1, j1
                        });
                    }
                    i1 += ai1[0] + ai1[1];
                    System.arraycopy(ai1, 2, ai1, 0, k - 2);
                    ai1[k - 2] = 0;
                    ai1[k - 1] = 0;
                    k1--;
                } else
                {
                    k1++;
                }
                ai1[k1] = 1;
                if (!flag1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            j1++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    abstract BarcodeFormat a();

    boolean checkChecksum(String s)
    {
        return a(s);
    }

    int[] decodeEnd(BitArray bitarray, int j)
    {
        return a(bitarray, j, false, b);
    }

    protected abstract int decodeMiddle(BitArray bitarray, int ai[], StringBuilder stringbuilder);

    public Result decodeRow(int j, BitArray bitarray, Map map)
    {
        return decodeRow(j, bitarray, a(bitarray), map);
    }

    public Result decodeRow(int j, BitArray bitarray, int ai[], Map map)
    {
        ResultPointCallback resultpointcallback;
        StringBuilder stringbuilder;
        int k;
        int ai1[];
        int l;
        int i1;
        if (map == null)
        {
            resultpointcallback = null;
        } else
        {
            resultpointcallback = (ResultPointCallback)map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        if (resultpointcallback != null)
        {
            resultpointcallback.foundPossibleResultPoint(new ResultPoint((float)(ai[0] + ai[1]) / 2.0F, j));
        }
        stringbuilder = g;
        stringbuilder.setLength(0);
        k = decodeMiddle(bitarray, ai, stringbuilder);
        if (resultpointcallback != null)
        {
            resultpointcallback.foundPossibleResultPoint(new ResultPoint(k, j));
        }
        ai1 = decodeEnd(bitarray, k);
        if (resultpointcallback != null)
        {
            resultpointcallback.foundPossibleResultPoint(new ResultPoint((float)(ai1[0] + ai1[1]) / 2.0F, j));
        }
        l = ai1[1];
        i1 = l + (l - ai1[0]);
        if (i1 >= bitarray.getSize() || !bitarray.isRange(l, i1, false))
        {
            throw NotFoundException.getNotFoundInstance();
        }
        String s = stringbuilder.toString();
        if (!checkChecksum(s))
        {
            throw ChecksumException.getChecksumInstance();
        }
        float f1 = (float)(ai[1] + ai[0]) / 2.0F;
        float f2 = (float)(ai1[1] + ai1[0]) / 2.0F;
        BarcodeFormat barcodeformat = a();
        ResultPoint aresultpoint[] = new ResultPoint[2];
        aresultpoint[0] = new ResultPoint(f1, j);
        aresultpoint[1] = new ResultPoint(f2, j);
        Result result = new Result(s, null, aresultpoint, barcodeformat);
        try
        {
            Result result1 = h.a(j, bitarray, ai1[1]);
            result.putAllMetadata(result1.getResultMetadata());
            result.addResultPoints(result1.getResultPoints());
        }
        catch (ReaderException readerexception) { }
        if (barcodeformat == BarcodeFormat.EAN_13 || barcodeformat == BarcodeFormat.UPC_A)
        {
            String s1 = i.a(s);
            if (s1 != null)
            {
                result.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, s1);
            }
        }
        return result;
    }

    static 
    {
        e = new int[20][];
        System.arraycopy(d, 0, e, 0, 10);
        for (int j = 10; j < 20; j++)
        {
            int ai[] = d[j - 10];
            int ai1[] = new int[ai.length];
            for (int k = 0; k < ai.length; k++)
            {
                ai1[k] = ai[-1 + (ai.length - k)];
            }

            e[j] = ai1;
        }

    }
}
