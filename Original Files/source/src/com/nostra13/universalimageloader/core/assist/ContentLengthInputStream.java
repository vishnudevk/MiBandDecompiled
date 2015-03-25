// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;

import java.io.InputStream;

public class ContentLengthInputStream extends InputStream
{

    private final InputStream a;
    private final int b;

    public ContentLengthInputStream(InputStream inputstream, int i)
    {
        a = inputstream;
        b = i;
    }

    public int available()
    {
        return b;
    }

    public void close()
    {
        a.close();
    }

    public void mark(int i)
    {
        a.mark(i);
    }

    public boolean markSupported()
    {
        return a.markSupported();
    }

    public int read()
    {
        return a.read();
    }

    public int read(byte abyte0[])
    {
        return a.read(abyte0);
    }

    public int read(byte abyte0[], int i, int j)
    {
        return a.read(abyte0, i, j);
    }

    public void reset()
    {
        a.reset();
    }

    public long skip(long l)
    {
        return a.skip(l);
    }
}
