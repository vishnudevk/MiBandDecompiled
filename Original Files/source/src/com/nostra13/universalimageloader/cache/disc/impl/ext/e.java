// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl.ext:
//            g, f

class e
    implements Closeable
{

    private static final byte a = 13;
    private static final byte b = 10;
    private final InputStream c;
    private final Charset d;
    private byte e[];
    private int f;
    private int g;

    public e(InputStream inputstream, int i, Charset charset)
    {
        if (inputstream == null || charset == null)
        {
            throw new NullPointerException();
        }
        if (i < 0)
        {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(g.a))
        {
            throw new IllegalArgumentException("Unsupported encoding");
        } else
        {
            c = inputstream;
            d = charset;
            e = new byte[i];
            return;
        }
    }

    public e(InputStream inputstream, Charset charset)
    {
        this(inputstream, 8192, charset);
    }

    static Charset a(e e1)
    {
        return e1.d;
    }

    private void b()
    {
        int i = c.read(e, 0, e.length);
        if (i == -1)
        {
            throw new EOFException();
        } else
        {
            f = 0;
            g = i;
            return;
        }
    }

    public String a()
    {
        InputStream inputstream = c;
        inputstream;
        JVM INSTR monitorenter ;
        if (e == null)
        {
            throw new IOException("LineReader is closed");
        }
        break MISSING_BLOCK_LABEL_29;
        Exception exception;
        exception;
        inputstream;
        JVM INSTR monitorexit ;
        throw exception;
        int i;
        if (f >= g)
        {
            b();
        }
        i = f;
_L9:
        if (i == g) goto _L2; else goto _L1
_L1:
        if (e[i] != 10)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        f f1;
        int j;
        String s;
        int k;
        String s1;
        if (i != f && e[i - 1] == 13)
        {
            k = i - 1;
        } else
        {
            k = i;
        }
        s1 = new String(e, f, k - f, d.name());
        f = i + 1;
        inputstream;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        f1 = new f(this, 80 + (g - f));
_L8:
        f1.write(e, f, g - f);
        g = -1;
        b();
        j = f;
_L6:
        if (j == g)
        {
            break; /* Loop/switch isn't completed */
        }
        if (e[j] != 10) goto _L4; else goto _L3
_L3:
        if (j != f)
        {
            f1.write(e, f, j - f);
        }
        f = j + 1;
        s = f1.toString();
        inputstream;
        JVM INSTR monitorexit ;
        return s;
_L4:
        j++;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L8; else goto _L7
_L7:
        i++;
          goto _L9
    }

    public void close()
    {
        synchronized (c)
        {
            if (e != null)
            {
                e = null;
                c.close();
            }
        }
        return;
        exception;
        inputstream;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
