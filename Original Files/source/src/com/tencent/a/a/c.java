// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.a.a;


// Referenced classes of package com.tencent.a.a:
//            d, a

public class c extends d
{

    public static c a = null;

    public c()
    {
        d = new a(b);
    }

    public static c a()
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        com/tencent/a/a/c;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new c();
        }
        com/tencent/a/a/c;
        JVM INSTR monitorexit ;
_L2:
        return a;
        Exception exception;
        exception;
        com/tencent/a/a/c;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static final void a(String s, String s1)
    {
        a().a(1, s, s1, null);
    }

    public static final void a(String s, String s1, Throwable throwable)
    {
        a().a(16, s, s1, throwable);
    }

    public static final void b(String s, String s1)
    {
        a().a(2, s, s1, null);
    }

    public static final void c(String s, String s1)
    {
        a().a(4, s, s1, null);
    }

    public static final void d(String s, String s1)
    {
        a().a(16, s, s1, null);
    }

    public void b()
    {
        com/tencent/a/a/c;
        JVM INSTR monitorenter ;
        if (d != null)
        {
            d.a();
            d.b();
            d = null;
            a = null;
        }
        com/tencent/a/a/c;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        com/tencent/a/a/c;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
