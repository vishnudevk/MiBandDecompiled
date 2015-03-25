// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package u.aly:
//            dm, dn

public class dk extends dm
{

    protected InputStream a;
    protected OutputStream b;

    protected dk()
    {
        a = null;
        b = null;
    }

    public dk(InputStream inputstream)
    {
        a = null;
        b = null;
        a = inputstream;
    }

    public dk(InputStream inputstream, OutputStream outputstream)
    {
        a = null;
        b = null;
        a = inputstream;
        b = outputstream;
    }

    public dk(OutputStream outputstream)
    {
        a = null;
        b = null;
        b = outputstream;
    }

    public int a(byte abyte0[], int i, int j)
    {
        if (a == null)
        {
            throw new dn(1, "Cannot read from null inputStream");
        }
        int k;
        try
        {
            k = a.read(abyte0, i, j);
        }
        catch (IOException ioexception)
        {
            throw new dn(0, ioexception);
        }
        if (k < 0)
        {
            throw new dn(4);
        } else
        {
            return k;
        }
    }

    public boolean a()
    {
        return true;
    }

    public void b()
    {
    }

    public void b(byte abyte0[], int i, int j)
    {
        if (b == null)
        {
            throw new dn(1, "Cannot write to null outputStream");
        }
        try
        {
            b.write(abyte0, i, j);
            return;
        }
        catch (IOException ioexception)
        {
            throw new dn(0, ioexception);
        }
    }

    public void c()
    {
        if (a != null)
        {
            try
            {
                a.close();
            }
            catch (IOException ioexception1)
            {
                ioexception1.printStackTrace();
            }
            a = null;
        }
        if (b != null)
        {
            try
            {
                b.close();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
            b = null;
        }
    }

    public void d()
    {
        if (b == null)
        {
            throw new dn(1, "Cannot flush null outputStream");
        }
        try
        {
            b.flush();
            return;
        }
        catch (IOException ioexception)
        {
            throw new dn(0, ioexception);
        }
    }
}
