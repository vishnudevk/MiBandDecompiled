// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.a.a;


// Referenced classes of package com.tencent.a.a:
//            b

public abstract class g
{

    private volatile int a;
    private volatile boolean b;
    private b c;

    public g()
    {
        this(63, true, b.a);
    }

    public g(int i, boolean flag, b b1)
    {
        a = 63;
        b = true;
        c = b.a;
        a(i);
        a(flag);
        a(b1);
    }

    public void a(int i)
    {
        a = i;
    }

    protected abstract void a(int i, Thread thread, long l, String s, String s1, Throwable throwable);

    public void a(b b1)
    {
        c = b1;
    }

    public void a(boolean flag)
    {
        b = flag;
    }

    public void b(int i, Thread thread, long l, String s, String s1, Throwable throwable)
    {
        if (d() && com.tencent.a.c.c.a.a(a, i))
        {
            a(i, thread, l, s, s1, throwable);
        }
    }

    public boolean d()
    {
        return b;
    }

    public b e()
    {
        return c;
    }
}
