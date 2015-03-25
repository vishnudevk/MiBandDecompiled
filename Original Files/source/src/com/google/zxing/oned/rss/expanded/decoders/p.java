// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss.expanded.decoders;


// Referenced classes of package com.google.zxing.oned.rss.expanded.decoders:
//            q

final class p extends q
{

    static final int a = 10;
    private final int b;
    private final int c;

    p(int i, int j, int k)
    {
        super(i);
        b = j;
        c = k;
        if (b < 0 || b > 10)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid firstDigit: ").append(j).toString());
        }
        if (c < 0 || c > 10)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid secondDigit: ").append(k).toString());
        } else
        {
            return;
        }
    }

    int a()
    {
        return b;
    }

    int b()
    {
        return c;
    }

    int c()
    {
        return 10 * b + c;
    }

    boolean d()
    {
        return b == 10;
    }

    boolean e()
    {
        return c == 10;
    }

    boolean f()
    {
        return b == 10 || c == 10;
    }
}
