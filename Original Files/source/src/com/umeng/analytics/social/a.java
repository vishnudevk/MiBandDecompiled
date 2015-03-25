// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;


public class a extends RuntimeException
{

    private static final long b = 0xbf602c791c90ef11L;
    protected int a;
    private String c;

    public a(int i, String s)
    {
        super(s);
        a = 5000;
        c = "";
        a = i;
        c = s;
    }

    public a(String s)
    {
        super(s);
        a = 5000;
        c = "";
        c = s;
    }

    public a(String s, Throwable throwable)
    {
        super(s, throwable);
        a = 5000;
        c = "";
        c = s;
    }

    public int a()
    {
        return a;
    }

    public String getMessage()
    {
        return c;
    }
}
