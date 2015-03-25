// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANReader

final class b
{

    private static final int a[] = {
        1, 1, 2
    };
    private static final int b[] = {
        24, 20, 18, 17, 12, 6, 3, 10, 9, 5
    };
    private final int c[] = new int[4];
    private final StringBuilder d = new StringBuilder();

    b()
    {
    }

    private static int a(int i)
    {
        for (int j = 0; j < 10; j++)
        {
            if (i == b[j])
            {
                return j;
            }
        }

        throw NotFoundException.getNotFoundInstance();
    }

    private static int a(CharSequence charsequence)
    {
        int i = charsequence.length();
        int j = 0;
        for (int k = i - 2; k >= 0; k -= 2)
        {
            j += -48 + charsequence.charAt(k);
        }

        int l = j * 3;
        for (int i1 = i - 1; i1 >= 0; i1 -= 2)
        {
            l += -48 + charsequence.charAt(i1);
        }

        return (l * 3) % 10;
    }

    private static Map a(String s)
    {
        s.length();
        JVM INSTR tableswitch 2 5: default 36
    //                   2 38
    //                   3 36
    //                   4 36
    //                   5 72;
           goto _L1 _L2 _L1 _L1 _L3
_L1:
        return null;
_L2:
        ResultMetadataType resultmetadatatype;
        Object obj;
        resultmetadatatype = ResultMetadataType.ISSUE_NUMBER;
        obj = b(s);
_L4:
        if (obj != null)
        {
            EnumMap enummap = new EnumMap(com/google/zxing/ResultMetadataType);
            enummap.put(resultmetadatatype, obj);
            return enummap;
        }
        if (true) goto _L1; else goto _L3
_L3:
        resultmetadatatype = ResultMetadataType.SUGGESTED_PRICE;
        obj = c(s);
          goto _L4
    }

    private static Integer b(String s)
    {
        return Integer.valueOf(s);
    }

    private static String c(String s)
    {
        s.charAt(0);
        JVM INSTR lookupswitch 3: default 40
    //                   48: 124
    //                   53: 130
    //                   57: 136;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_136;
_L1:
        String s1 = "";
_L5:
        int i = Integer.parseInt(s.substring(1));
        String s2 = String.valueOf(i / 100);
        int j = i % 100;
        String s3;
        if (j < 10)
        {
            s3 = (new StringBuilder()).append("0").append(j).toString();
        } else
        {
            s3 = String.valueOf(j);
        }
        return (new StringBuilder()).append(s1).append(s2).append('.').append(s3).toString();
_L2:
        s1 = "\243";
          goto _L5
_L3:
        s1 = "$";
          goto _L5
        if ("90000".equals(s))
        {
            return null;
        }
        if ("99991".equals(s))
        {
            return "0.00";
        }
        if ("99990".equals(s))
        {
            return "Used";
        }
        s1 = "";
          goto _L5
    }

    int a(BitArray bitarray, int ai[], StringBuilder stringbuilder)
    {
        int ai1[] = c;
        ai1[0] = 0;
        ai1[1] = 0;
        ai1[2] = 0;
        ai1[3] = 0;
        int i = bitarray.getSize();
        int j = ai[1];
        int k = 0;
        int l = 0;
        for (; k < 5 && j < i; k++)
        {
            int j1 = UPCEANReader.a(bitarray, ai1, j, UPCEANReader.e);
            stringbuilder.append((char)(48 + j1 % 10));
            int k1 = ai1.length;
            for (int l1 = 0; l1 < k1;)
            {
                int i2 = j + ai1[l1];
                l1++;
                j = i2;
            }

            if (j1 >= 10)
            {
                l |= 1 << 4 - k;
            }
            if (k != 4)
            {
                j = bitarray.getNextUnset(bitarray.getNextSet(j));
            }
        }

        if (stringbuilder.length() != 5)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        int i1 = a(l);
        if (a(((CharSequence) (stringbuilder.toString()))) != i1)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            return j;
        }
    }

    Result a(int i, BitArray bitarray, int j)
    {
        int ai[] = UPCEANReader.a(bitarray, j, false, a);
        StringBuilder stringbuilder = d;
        stringbuilder.setLength(0);
        int k = a(bitarray, ai, stringbuilder);
        String s = stringbuilder.toString();
        Map map = a(s);
        ResultPoint aresultpoint[] = new ResultPoint[2];
        aresultpoint[0] = new ResultPoint((float)(ai[0] + ai[1]) / 2.0F, i);
        aresultpoint[1] = new ResultPoint(k, i);
        Result result = new Result(s, null, aresultpoint, BarcodeFormat.UPC_EAN_EXTENSION);
        if (map != null)
        {
            result.putAllMetadata(map);
        }
        return result;
    }

}
