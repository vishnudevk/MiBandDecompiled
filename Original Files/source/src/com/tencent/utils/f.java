// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

class f extends BufferedOutputStream
{

    private int a;

    public f(OutputStream outputstream)
    {
        super(outputstream);
        a = 0;
    }

    public int a()
    {
        return a;
    }

    public void write(byte abyte0[])
    {
        super.write(abyte0);
        a = a + abyte0.length;
    }
}
