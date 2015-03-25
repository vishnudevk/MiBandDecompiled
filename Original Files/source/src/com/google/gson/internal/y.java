// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.io.Writer;

// Referenced classes of package com.google.gson.internal:
//            z, x

final class y extends Writer
{

    private final Appendable a;
    private final z b;

    private y(Appendable appendable)
    {
        b = new z();
        a = appendable;
    }

    y(Appendable appendable, x x)
    {
        this(appendable);
    }

    public void close()
    {
    }

    public void flush()
    {
    }

    public void write(int i)
    {
        a.append((char)i);
    }

    public void write(char ac[], int i, int j)
    {
        b.a = ac;
        a.append(b, i, i + j);
    }
}
