// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.game;

import java.io.Serializable;

class c
    implements Serializable
{

    private static final long a = 0x1335127L;
    private String b;
    private long c;
    private long d;

    public c(String s)
    {
        b = s;
    }

    public void a()
    {
        d = System.currentTimeMillis();
    }

    public boolean a(String s)
    {
        return b.equals(s);
    }

    public void b()
    {
        c = c + (System.currentTimeMillis() - d);
        d = 0L;
    }

    public void c()
    {
        a();
    }

    public void d()
    {
        b();
    }

    public long e()
    {
        return c;
    }

    public String f()
    {
        return b;
    }
}
