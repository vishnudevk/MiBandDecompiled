// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl.ext:
//            d, DiskLruCache, c, g, 
//            a

public final class <init>
{

    final DiskLruCache a;
    private final d b;
    private final boolean c[];
    private boolean d;
    private boolean e;

    static d a(<init> <init>1)
    {
        return <init>1.b;
    }

    static boolean a(b b1, boolean flag)
    {
        b1.d = flag;
        return flag;
    }

    static boolean[] b(d d1)
    {
        return d1.c;
    }

    public void abort()
    {
        DiskLruCache.a(a, this, false);
    }

    public void abortUnlessCommitted()
    {
        if (e)
        {
            break MISSING_BLOCK_LABEL_11;
        }
        abort();
        return;
        IOException ioexception;
        ioexception;
    }

    public void commit()
    {
        if (d)
        {
            DiskLruCache.a(a, this, false);
            a.c(com.nostra13.universalimageloader.cache.disc.impl.ext.d.c(b));
        } else
        {
            DiskLruCache.a(a, this, true);
        }
        e = true;
    }

    public String getString(int i)
    {
        InputStream inputstream = newInputStream(i);
        if (inputstream != null)
        {
            return DiskLruCache.a(inputstream);
        } else
        {
            return null;
        }
    }

    public InputStream newInputStream(int i)
    {
        DiskLruCache disklrucache = a;
        disklrucache;
        JVM INSTR monitorenter ;
        if (com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(b) != this)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        disklrucache;
        JVM INSTR monitorexit ;
        throw exception;
        if (com.nostra13.universalimageloader.cache.disc.impl.ext.d.d(b))
        {
            break MISSING_BLOCK_LABEL_45;
        }
        disklrucache;
        JVM INSTR monitorexit ;
        return null;
        FileInputStream fileinputstream = new FileInputStream(b.a(i));
        disklrucache;
        JVM INSTR monitorexit ;
        return fileinputstream;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        disklrucache;
        JVM INSTR monitorexit ;
        return null;
    }

    public OutputStream newOutputStream(int i)
    {
        DiskLruCache disklrucache = a;
        disklrucache;
        JVM INSTR monitorenter ;
        if (com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(b) != this)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        disklrucache;
        JVM INSTR monitorexit ;
        throw exception;
        File file;
        if (!com.nostra13.universalimageloader.cache.disc.impl.ext.d.d(b))
        {
            c[i] = true;
        }
        file = b.b(i);
        FileOutputStream fileoutputstream = new FileOutputStream(file);
        FileOutputStream fileoutputstream1 = fileoutputstream;
_L1:
        c c1 = new c(this, fileoutputstream1, null);
        disklrucache;
        JVM INSTR monitorexit ;
        return c1;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        DiskLruCache.g(a).mkdirs();
        FileOutputStream fileoutputstream2 = new FileOutputStream(file);
        fileoutputstream1 = fileoutputstream2;
          goto _L1
        FileNotFoundException filenotfoundexception1;
        filenotfoundexception1;
        OutputStream outputstream = DiskLruCache.i();
        disklrucache;
        JVM INSTR monitorexit ;
        return outputstream;
    }

    public void set(int i, String s)
    {
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(newOutputStream(i), g.b);
        outputstreamwriter.write(s);
        g.a(outputstreamwriter);
        return;
        Exception exception;
        exception;
        outputstreamwriter = null;
_L2:
        g.a(outputstreamwriter);
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private (DiskLruCache disklrucache, d d1)
    {
        a = disklrucache;
        super();
        b = d1;
        boolean aflag[];
        if (com.nostra13.universalimageloader.cache.disc.impl.ext.d.d(d1))
        {
            aflag = null;
        } else
        {
            aflag = new boolean[DiskLruCache.f(disklrucache)];
        }
        c = aflag;
    }

    c(DiskLruCache disklrucache, d d1, a a1)
    {
        this(disklrucache, d1);
    }
}
