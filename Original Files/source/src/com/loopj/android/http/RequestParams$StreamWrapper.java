// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.io.InputStream;

public class autoClose
{

    public final boolean autoClose;
    public final String contentType;
    public final InputStream inputStream;
    public final String name;

    static autoClose a(InputStream inputstream, String s, String s1, boolean flag)
    {
        if (s1 == null)
        {
            s1 = "application/octet-stream";
        }
        return new <init>(inputstream, s, s1, flag);
    }

    public (InputStream inputstream, String s, String s1, boolean flag)
    {
        inputStream = inputstream;
        name = s;
        contentType = s1;
        autoClose = flag;
    }
}
