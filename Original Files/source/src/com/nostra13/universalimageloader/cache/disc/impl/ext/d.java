// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl.ext:
//            DiskLruCache, a

final class d
{

    final DiskLruCache a;
    private final String b;
    private final long c[];
    private boolean d;
    private DiskLruCache.Editor e;
    private long f;

    private d(DiskLruCache disklrucache, String s)
    {
        a = disklrucache;
        super();
        b = s;
        c = new long[DiskLruCache.f(disklrucache)];
    }

    d(DiskLruCache disklrucache, String s, a a1)
    {
        this(disklrucache, s);
    }

    static long a(d d1, long l)
    {
        d1.f = l;
        return l;
    }

    static DiskLruCache.Editor a(d d1)
    {
        return d1.e;
    }

    static DiskLruCache.Editor a(d d1, DiskLruCache.Editor editor)
    {
        d1.e = editor;
        return editor;
    }

    static void a(d d1, String as[])
    {
        d1.a(as);
    }

    private void a(String as[])
    {
        if (as.length != DiskLruCache.f(a))
        {
            throw b(as);
        }
        int i = 0;
        do
        {
            try
            {
                if (i >= as.length)
                {
                    break;
                }
                c[i] = Long.parseLong(as[i]);
            }
            catch (NumberFormatException numberformatexception)
            {
                throw b(as);
            }
            i++;
        } while (true);
    }

    static boolean a(d d1, boolean flag)
    {
        d1.d = flag;
        return flag;
    }

    private IOException b(String as[])
    {
        throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(Arrays.toString(as)).toString());
    }

    static long[] b(d d1)
    {
        return d1.c;
    }

    static String c(d d1)
    {
        return d1.b;
    }

    static boolean d(d d1)
    {
        return d1.d;
    }

    static long e(d d1)
    {
        return d1.f;
    }

    public File a(int i)
    {
        return new File(DiskLruCache.g(a), (new StringBuilder()).append(b).append(".").append(i).toString());
    }

    public String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        long al[] = c;
        int i = al.length;
        for (int j = 0; j < i; j++)
        {
            long l = al[j];
            stringbuilder.append(' ').append(l);
        }

        return stringbuilder.toString();
    }

    public File b(int i)
    {
        return new File(DiskLruCache.g(a), (new StringBuilder()).append(b).append(".").append(i).append(".tmp").toString());
    }
}
