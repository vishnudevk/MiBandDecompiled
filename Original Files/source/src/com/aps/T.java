// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.aps:
//            p, S

class T extends FilterOutputStream
{

    final p a;
    private final g.a b;
    private boolean c;

    private T(p p, OutputStream outputstream, g.a a1)
    {
        a = p;
        super(outputstream);
        c = false;
        b = a1;
    }

    T(p p, OutputStream outputstream, g.a a1, S s)
    {
        this(p, outputstream, a1);
    }

    public void close()
    {
        IOException ioexception = null;
        try
        {
            super.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception) { }
        if (c)
        {
            b.b();
        } else
        {
            b.a();
        }
        if (ioexception != null)
        {
            throw ioexception;
        } else
        {
            return;
        }
    }

    public void flush()
    {
        try
        {
            super.flush();
            return;
        }
        catch (IOException ioexception)
        {
            c = true;
            throw ioexception;
        }
    }

    public void write(int i)
    {
        try
        {
            super.write(i);
            return;
        }
        catch (IOException ioexception)
        {
            c = true;
            throw ioexception;
        }
    }

    public void write(byte abyte0[])
    {
        try
        {
            super.write(abyte0);
            return;
        }
        catch (IOException ioexception)
        {
            c = true;
            throw ioexception;
        }
    }

    public void write(byte abyte0[], int i, int j)
    {
        try
        {
            super.write(abyte0, i, j);
            return;
        }
        catch (IOException ioexception)
        {
            c = true;
            throw ioexception;
        }
    }
}
