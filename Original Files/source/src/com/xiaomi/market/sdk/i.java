// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import java.io.OutputStream;

// Referenced classes of package com.xiaomi.market.sdk:
//            c

public abstract class i extends OutputStream
{

    protected OutputStream S;
    final c b;

    public i(c c, OutputStream outputstream)
    {
        b = c;
        super();
        if (outputstream == null)
        {
            throw new IllegalArgumentException("outputstream is null");
        } else
        {
            S = outputstream;
            return;
        }
    }

    public void close()
    {
        S.close();
    }

    public void flush()
    {
        S.flush();
    }

    public abstract void reset();

    public void write(int j)
    {
        S.write(j);
    }

    public void write(byte abyte0[])
    {
        S.write(abyte0);
    }

    public void write(byte abyte0[], int j, int k)
    {
        S.write(abyte0, j, k);
    }
}
