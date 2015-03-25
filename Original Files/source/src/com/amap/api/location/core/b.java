// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location.core;


public class b
{

    private static final char a[] = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
        'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
        'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
        '8', '9', '+', '/'
    };
    private static byte b[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -1, -1, -1, -1, -1
    };

    private b()
    {
    }

    public static String a(byte abyte0[])
    {
        StringBuffer stringbuffer;
        int j;
        int l;
        int i1;
        int j1;
        int i;
        int k;
        try
        {
            stringbuffer = new StringBuffer();
            i = abyte0.length;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return "";
        }
        j = 0;
_L5:
        if (j >= i) goto _L2; else goto _L1
_L1:
        k = j + 1;
        l = 0xff & abyte0[j];
        if (k != i) goto _L4; else goto _L3
_L3:
        stringbuffer.append(a[l >>> 2]);
        stringbuffer.append(a[(l & 3) << 4]);
        stringbuffer.append("==");
_L2:
        return stringbuffer.toString();
_L4:
        i1 = k + 1;
        j1 = 0xff & abyte0[k];
        if (i1 != i)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        stringbuffer.append(a[l >>> 2]);
        stringbuffer.append(a[(l & 3) << 4 | (j1 & 0xf0) >>> 4]);
        stringbuffer.append(a[(j1 & 0xf) << 2]);
        stringbuffer.append("=");
          goto _L2
        j = i1 + 1;
        int k1 = 0xff & abyte0[i1];
        stringbuffer.append(a[l >>> 2]);
        stringbuffer.append(a[(l & 3) << 4 | (j1 & 0xf0) >>> 4]);
        stringbuffer.append(a[(j1 & 0xf) << 2 | (k1 & 0xc0) >>> 6]);
        stringbuffer.append(a[k1 & 0x3f]);
          goto _L5
    }

}
