// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import java.io.Closeable;
import java.io.InputStream;

// Referenced classes of package com.aps:
//            W, g, N

public final class tStream
    implements Closeable
{

    final g a;
    private final String b;
    private final long c;
    private final InputStream d[];
    private final long e[];

    public InputStream a(int i)
    {
        return d[i];
    }

    public void close()
    {
        InputStream ainputstream[] = d;
        int i = ainputstream.length;
        for (int j = 0; j < i; j++)
        {
            W.a(ainputstream[j]);
        }

    }

    private tStream(g g, String s, long l, InputStream ainputstream[], long al[])
    {
        a = g;
        super();
        b = s;
        c = l;
        d = ainputstream;
        e = al;
    }

    tStream(g g, String s, long l, InputStream ainputstream[], long al[], N n)
    {
        this(g, s, l, ainputstream, al);
    }
}
