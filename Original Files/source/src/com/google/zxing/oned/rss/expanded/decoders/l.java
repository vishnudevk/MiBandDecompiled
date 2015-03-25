// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss.expanded.decoders;


// Referenced classes of package com.google.zxing.oned.rss.expanded.decoders:
//            m

final class l
{

    private int a;
    private m b;

    l()
    {
        a = 0;
        b = m.a;
    }

    int a()
    {
        return a;
    }

    void a(int i)
    {
        a = i;
    }

    void b(int i)
    {
        a = i + a;
    }

    boolean b()
    {
        return b == m.b;
    }

    boolean c()
    {
        return b == m.a;
    }

    boolean d()
    {
        return b == m.c;
    }

    void e()
    {
        b = m.a;
    }

    void f()
    {
        b = m.b;
    }

    void g()
    {
        b = m.c;
    }
}
