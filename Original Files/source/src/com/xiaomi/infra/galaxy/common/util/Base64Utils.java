// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.util;

import java.io.ByteArrayOutputStream;

public class Base64Utils
{

    private static byte base64DecodeChars[] = {
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
    private static char base64EncodeChars[] = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
        'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
        'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
        '8', '9', '+', '/'
    };

    private Base64Utils()
    {
    }

    public static byte[] decode(byte abyte0[])
    {
        int i;
        ByteArrayOutputStream bytearrayoutputstream;
        int j;
        i = abyte0.length;
        bytearrayoutputstream = new ByteArrayOutputStream(i);
        j = 0;
_L9:
        if (j >= i) goto _L2; else goto _L1
_L1:
        int k;
        byte byte0;
        byte abyte1[] = base64DecodeChars;
        k = j + 1;
        byte0 = abyte1[abyte0[j]];
        if (k < i && byte0 == -1)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        if (byte0 != -1) goto _L3; else goto _L2
_L2:
        return bytearrayoutputstream.toByteArray();
_L5:
        int l;
        k = l;
_L3:
        byte byte1;
        byte abyte2[] = base64DecodeChars;
        l = k + 1;
        byte1 = abyte2[abyte0[k]];
        if (l < i && byte1 == -1) goto _L5; else goto _L4
_L4:
        if (byte1 == -1) goto _L2; else goto _L6
_L6:
        bytearrayoutputstream.write(byte0 << 2 | (byte1 & 0x30) >>> 4);
_L11:
        int i1;
        byte byte3;
        i1 = l + 1;
        byte byte2 = abyte0[l];
        if (byte2 == 61)
        {
            return bytearrayoutputstream.toByteArray();
        }
        byte3 = base64DecodeChars[byte2];
        if (i1 < i && byte3 == -1)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        if (byte3 == -1) goto _L2; else goto _L7
_L7:
        bytearrayoutputstream.write((byte1 & 0xf) << 4 | (byte3 & 0x3c) >>> 2);
_L10:
        byte byte5;
        j = i1 + 1;
        byte byte4 = abyte0[i1];
        if (byte4 == 61)
        {
            return bytearrayoutputstream.toByteArray();
        }
        byte5 = base64DecodeChars[byte4];
        if (j < i && byte5 == -1)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        if (byte5 == -1) goto _L2; else goto _L8
_L8:
        bytearrayoutputstream.write(byte5 | (byte3 & 3) << 6);
          goto _L9
        i1 = j;
          goto _L10
        l = i1;
          goto _L11
        j = k;
          goto _L1
    }

    public static String encode(byte abyte0[])
    {
        StringBuffer stringbuffer;
        int i;
        int j;
        stringbuffer = new StringBuffer();
        i = abyte0.length;
        j = 0;
_L7:
        if (j >= i) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        k = j + 1;
        l = 0xff & abyte0[j];
        if (k != i) goto _L4; else goto _L3
_L3:
        stringbuffer.append(base64EncodeChars[l >>> 2]);
        stringbuffer.append(base64EncodeChars[(l & 3) << 4]);
        stringbuffer.append("==");
_L2:
        return stringbuffer.toString();
_L4:
        int i1;
        int j1;
        i1 = k + 1;
        j1 = 0xff & abyte0[k];
        if (i1 != i)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuffer.append(base64EncodeChars[l >>> 2]);
        stringbuffer.append(base64EncodeChars[(l & 3) << 4 | (j1 & 0xf0) >>> 4]);
        stringbuffer.append(base64EncodeChars[(j1 & 0xf) << 2]);
        stringbuffer.append("=");
        if (true) goto _L2; else goto _L5
_L5:
        j = i1 + 1;
        int k1 = 0xff & abyte0[i1];
        stringbuffer.append(base64EncodeChars[l >>> 2]);
        stringbuffer.append(base64EncodeChars[(l & 3) << 4 | (j1 & 0xf0) >>> 4]);
        stringbuffer.append(base64EncodeChars[(j1 & 0xf) << 2 | (k1 & 0xc0) >>> 6]);
        stringbuffer.append(base64EncodeChars[k1 & 0x3f]);
        if (true) goto _L7; else goto _L6
_L6:
    }

}
