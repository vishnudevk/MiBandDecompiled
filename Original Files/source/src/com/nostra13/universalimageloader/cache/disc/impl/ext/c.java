// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl.ext:
//            a

class c extends FilterOutputStream
{

    final DiskLruCache.Editor a;

    private c(DiskLruCache.Editor editor, OutputStream outputstream)
    {
        a = editor;
        super(outputstream);
    }

    c(DiskLruCache.Editor editor, OutputStream outputstream, a a1)
    {
        this(editor, outputstream);
    }

    public void close()
    {
        try
        {
            out.close();
            return;
        }
        catch (IOException ioexception)
        {
            DiskLruCache.Editor.a(a, true);
        }
    }

    public void flush()
    {
        try
        {
            out.flush();
            return;
        }
        catch (IOException ioexception)
        {
            DiskLruCache.Editor.a(a, true);
        }
    }

    public void write(int i)
    {
        try
        {
            out.write(i);
            return;
        }
        catch (IOException ioexception)
        {
            DiskLruCache.Editor.a(a, true);
        }
    }

    public void write(byte abyte0[], int i, int j)
    {
        try
        {
            out.write(abyte0, i, j);
            return;
        }
        catch (IOException ioexception)
        {
            DiskLruCache.Editor.a(a, true);
        }
    }
}
