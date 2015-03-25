// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

// Referenced classes of package com.google.zxing.pdf417.encoder:
//            b

final class a
{

    private final b a[];
    private int b;
    private final int c;
    private final int d;

    a(int i, int j)
    {
        a = new b[i + 2];
        int k = a.length;
        for (int l = 0; l < k; l++)
        {
            a[l] = new b(1 + 17 * (j + 4));
        }

        d = j * 17;
        c = i + 2;
        b = 0;
    }

    void a()
    {
        b = 1 + b;
    }

    void a(int i, int j, byte byte0)
    {
        a[j].a(i, byte0);
    }

    void a(int i, int j, boolean flag)
    {
        int k;
        if (flag)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        a(i, j, (byte)k);
    }

    byte[][] a(int i)
    {
        return a(i, i);
    }

    byte[][] a(int i, int j)
    {
        int ai[] = {
            j * c, i * d
        };
        byte abyte0[][] = (byte[][])Array.newInstance(Byte.TYPE, ai);
        int k = j * c;
        for (int l = 0; l < k; l++)
        {
            abyte0[-1 + (k - l)] = a[l / j].a(i);
        }

        return abyte0;
    }

    b b()
    {
        return a[b];
    }

    byte[][] c()
    {
        return a(1, 1);
    }
}
