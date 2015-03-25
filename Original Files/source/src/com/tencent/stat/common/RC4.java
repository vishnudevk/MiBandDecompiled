// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.common;


public class RC4
{

    static final byte a[] = "03a976511e2cbe3a7f26808fb7af3c05".getBytes();

    static byte[] a(byte abyte0[], byte abyte1[])
    {
        int i = 0;
        int ai[] = new int[256];
        int ai1[] = new int[256];
        int j = abyte1.length;
        if (j < 1 || j > 256)
        {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        for (int k = 0; k < 256; k++)
        {
            ai[k] = k;
            ai1[k] = abyte1[k % j];
        }

        int l = 0;
        int i1 = 0;
        for (; l < 256; l++)
        {
            i1 = 0xff & i1 + ai[l] + ai1[l];
            int i2 = ai[l];
            ai[l] = ai[i1];
            ai[i1] = i2;
        }

        byte abyte2[] = new byte[abyte0.length];
        int j1 = 0;
        int k1 = 0;
        for (; i < abyte0.length; i++)
        {
            k1 = 0xff & k1 + 1;
            j1 = 0xff & j1 + ai[k1];
            int l1 = ai[k1];
            ai[k1] = ai[j1];
            ai[j1] = l1;
            abyte2[i] = (byte)(ai[0xff & ai[k1] + ai[j1]] ^ abyte0[i]);
        }

        return abyte2;
    }

    static byte[] b(byte abyte0[], byte abyte1[])
    {
        return a(abyte0, abyte1);
    }

    public static byte[] decrypt(byte abyte0[])
    {
        return b(abyte0, a);
    }

    public static byte[] encrypt(byte abyte0[])
    {
        return a(abyte0, a);
    }

}
