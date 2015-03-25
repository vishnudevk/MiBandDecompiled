// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import java.util.concurrent.Callable;

// Referenced classes of package com.aps:
//            g

class N
    implements Callable
{

    final g a;

    N(g g1)
    {
        a = g1;
        super();
    }

    public Void a()
    {
label0:
        {
            synchronized (a)
            {
                if (g.a(a) != null)
                {
                    break label0;
                }
            }
            return null;
        }
        g.b(a);
        if (g.c(a))
        {
            g.d(a);
            g.a(a, 0);
        }
        g1;
        JVM INSTR monitorexit ;
        return null;
        exception;
        g1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object call()
    {
        return a();
    }
}
