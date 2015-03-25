// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common;

import java.util.List;

public final class DecoderResult
{

    private final byte a[];
    private final String b;
    private final List c;
    private final String d;

    public DecoderResult(byte abyte0[], String s, List list, String s1)
    {
        a = abyte0;
        b = s;
        c = list;
        d = s1;
    }

    public List getByteSegments()
    {
        return c;
    }

    public String getECLevel()
    {
        return d;
    }

    public byte[] getRawBytes()
    {
        return a;
    }

    public String getText()
    {
        return b;
    }
}
