// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss.expanded.decoders;


// Referenced classes of package com.google.zxing.oned.rss.expanded.decoders:
//            q

final class o extends q
{

    private final String a;
    private final int b;
    private final boolean c;

    o(int i, String s)
    {
        super(i);
        a = s;
        c = false;
        b = 0;
    }

    o(int i, String s, int j)
    {
        super(i);
        c = true;
        b = j;
        a = s;
    }

    String a()
    {
        return a;
    }

    boolean b()
    {
        return c;
    }

    int c()
    {
        return b;
    }
}
