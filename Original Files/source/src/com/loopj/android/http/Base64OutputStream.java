// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.loopj.android.http:
//            i, h, g, Base64DataException

public class Base64OutputStream extends FilterOutputStream
{

    private static byte e[] = new byte[0];
    private final g a;
    private final int b;
    private byte c[];
    private int d;

    public Base64OutputStream(OutputStream outputstream, int j)
    {
        this(outputstream, j, true);
    }

    public Base64OutputStream(OutputStream outputstream, int j, boolean flag)
    {
        super(outputstream);
        c = null;
        d = 0;
        b = j;
        if (flag)
        {
            a = new i(j, null);
            return;
        } else
        {
            a = new h(j, null);
            return;
        }
    }

    private void a()
    {
        if (d > 0)
        {
            a(c, 0, d, false);
            d = 0;
        }
    }

    private void a(byte abyte0[], int j, int k, boolean flag)
    {
        a.a = a(a.a, a.a(k));
        if (!a.a(abyte0, j, k, flag))
        {
            throw new Base64DataException("bad base-64");
        } else
        {
            out.write(a.a, 0, a.b);
            return;
        }
    }

    private byte[] a(byte abyte0[], int j)
    {
        if (abyte0 == null || abyte0.length < j)
        {
            abyte0 = new byte[j];
        }
        return abyte0;
    }

    public void close()
    {
        IOException ioexception;
        IOException ioexception2;
        ioexception = null;
        try
        {
            a();
            a(e, 0, 0, true);
        }
        catch (IOException ioexception1)
        {
            ioexception = ioexception1;
        }
        if ((0x10 & b) != 0) goto _L2; else goto _L1
_L1:
        out.close();
_L3:
        ioexception2 = ioexception;
_L4:
        if (ioexception2 != null)
        {
            throw ioexception2;
        } else
        {
            return;
        }
_L2:
        out.flush();
          goto _L3
        ioexception2;
        if (ioexception == null)
        {
            ioexception2 = ioexception;
        }
          goto _L4
    }

    public void write(int j)
    {
        if (c == null)
        {
            c = new byte[1024];
        }
        if (d >= c.length)
        {
            a(c, 0, d, false);
            d = 0;
        }
        byte abyte0[] = c;
        int k = d;
        d = k + 1;
        abyte0[k] = (byte)j;
    }

    public void write(byte abyte0[], int j, int k)
    {
        if (k <= 0)
        {
            return;
        } else
        {
            a();
            a(abyte0, j, k, false);
            return;
        }
    }

}
