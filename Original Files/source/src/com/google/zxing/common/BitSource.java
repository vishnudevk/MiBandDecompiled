// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common;


public final class BitSource
{

    private final byte a[];
    private int b;
    private int c;

    public BitSource(byte abyte0[])
    {
        a = abyte0;
    }

    public int available()
    {
        return 8 * (a.length - b) - c;
    }

    public int getByteOffset()
    {
        return b;
    }

    public int readBits(int i)
    {
        if (i < 1 || i > 32)
        {
            throw new IllegalArgumentException();
        }
        int j;
        int k;
        if (c > 0)
        {
            int j1 = 8 - c;
            int k1;
            int l1;
            int i2;
            int j2;
            if (i < j1)
            {
                k1 = i;
            } else
            {
                k1 = j1;
            }
            l1 = j1 - k1;
            i2 = ((255 >> 8 - k1) << l1 & a[b]) >> l1;
            j2 = i - k1;
            c = k1 + c;
            if (c == 8)
            {
                c = 0;
                b = 1 + b;
            }
            k = i2;
            j = j2;
        } else
        {
            j = i;
            k = 0;
        }
        if (j > 0)
        {
            for (; j >= 8; j -= 8)
            {
                k = k << 8 | 0xff & a[b];
                b = 1 + b;
            }

            if (j > 0)
            {
                int l = 8 - j;
                int i1 = (255 >> l) << l;
                k = k << j | (i1 & a[b]) >> l;
                c = j + c;
            }
        }
        return k;
    }
}
