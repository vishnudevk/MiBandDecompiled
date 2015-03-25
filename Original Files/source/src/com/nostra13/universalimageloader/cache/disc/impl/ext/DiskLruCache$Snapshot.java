// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl.ext:
//            g, DiskLruCache, a

public final class <init>
    implements Closeable
{

    final DiskLruCache a;
    private final String b;
    private final long c;
    private File d[];
    private final InputStream e[];
    private final long f[];

    public void close()
    {
        InputStream ainputstream[] = e;
        int i = ainputstream.length;
        for (int j = 0; j < i; j++)
        {
            g.a(ainputstream[j]);
        }

    }

    public e edit()
    {
        return DiskLruCache.a(a, b, c);
    }

    public File getFile(int i)
    {
        return d[i];
    }

    public InputStream getInputStream(int i)
    {
        return e[i];
    }

    public long getLength(int i)
    {
        return f[i];
    }

    public String getString(int i)
    {
        return DiskLruCache.a(getInputStream(i));
    }

    private Q(DiskLruCache disklrucache, String s, long l, File afile[], InputStream ainputstream[], long al[])
    {
        a = disklrucache;
        super();
        b = s;
        c = l;
        d = afile;
        e = ainputstream;
        f = al;
    }

    f(DiskLruCache disklrucache, String s, long l, File afile[], InputStream ainputstream[], long al[], 
            a a1)
    {
        this(disklrucache, s, l, afile, ainputstream, al);
    }
}
