// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.pdf417.encoder;


final class b
{

    private final byte a[];
    private int b;

    b(int i)
    {
        a = new byte[i];
        b = 0;
    }

    void a(int i, byte byte0)
    {
        a[i] = byte0;
    }

    void a(int i, boolean flag)
    {
        byte abyte0[] = a;
        int j;
        if (flag)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        abyte0[i] = (byte)j;
    }

    void a(boolean flag, int i)
    {
        for (int j = 0; j < i; j++)
        {
            int k = b;
            b = k + 1;
            a(k, flag);
        }

    }

    byte[] a()
    {
        return a;
    }

    byte[] a(int i)
    {
        byte abyte0[] = new byte[i * a.length];
        for (int j = 0; j < abyte0.length; j++)
        {
            abyte0[j] = a[j / i];
        }

        return abyte0;
    }
}
