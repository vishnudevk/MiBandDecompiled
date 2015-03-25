// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.cache.disc.DiskCache;
import java.io.File;
import java.util.concurrent.Executor;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            i, ImageLoaderConfiguration, l

class j
    implements Runnable
{

    final l a;
    final i b;

    j(i k, l l1)
    {
        b = k;
        a = l1;
        super();
    }

    public void run()
    {
        File file = b.a.o.get(a.a());
        boolean flag;
        if (file != null && file.exists())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i.a(b);
        if (flag)
        {
            i.b(b).execute(a);
            return;
        } else
        {
            i.c(b).execute(a);
            return;
        }
    }
}
