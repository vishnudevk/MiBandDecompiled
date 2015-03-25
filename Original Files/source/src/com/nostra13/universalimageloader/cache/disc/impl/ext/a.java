// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.util.concurrent.Callable;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl.ext:
//            DiskLruCache

class a
    implements Callable
{

    final DiskLruCache a;

    a(DiskLruCache disklrucache)
    {
        a = disklrucache;
        super();
    }

    public Void a()
    {
label0:
        {
            synchronized (a)
            {
                if (DiskLruCache.a(a) != null)
                {
                    break label0;
                }
            }
            return null;
        }
        DiskLruCache.b(a);
        DiskLruCache.c(a);
        if (DiskLruCache.d(a))
        {
            DiskLruCache.e(a);
            DiskLruCache.a(a, 0);
        }
        disklrucache;
        JVM INSTR monitorexit ;
        return null;
        exception;
        disklrucache;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object call()
    {
        return a();
    }
}
