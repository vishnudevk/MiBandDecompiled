// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;


public class d
{

    private int a;
    private String b;
    private String c;
    private Exception d;

    public d(int i)
    {
        a = -1;
        b = "";
        c = "";
        d = null;
        a = i;
    }

    public d(int i, Exception exception)
    {
        a = -1;
        b = "";
        c = "";
        d = null;
        a = i;
        d = exception;
    }

    public Exception a()
    {
        return d;
    }

    public void a(int i)
    {
        a = i;
    }

    public void a(String s)
    {
        b = s;
    }

    public int b()
    {
        return a;
    }

    public void b(String s)
    {
        c = s;
    }

    public String c()
    {
        return b;
    }

    public String d()
    {
        return c;
    }

    public String toString()
    {
        return (new StringBuilder("status=")).append(a).append("\r\n").append("msg:  ").append(b).append("\r\n").append("data:  ").append(c).toString();
    }
}
