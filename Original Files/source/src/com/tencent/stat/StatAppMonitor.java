// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;


public class StatAppMonitor
{

    public static final int FAILURE_RESULT_TYPE = 1;
    public static final int LOGIC_FAILURE_RESULT_TYPE = 2;
    public static final int SUCCESS_RESULT_TYPE;
    private String a;
    private long b;
    private long c;
    private int d;
    private long e;
    private int f;
    private int g;

    public StatAppMonitor(String s)
    {
        a = null;
        b = 0L;
        c = 0L;
        d = 0;
        e = 0L;
        f = 0;
        g = 1;
        a = s;
    }

    public StatAppMonitor(String s, int i, int j, long l, long l1, 
            long l2, int k)
    {
        a = null;
        b = 0L;
        c = 0L;
        d = 0;
        e = 0L;
        f = 0;
        g = 1;
        a = s;
        b = l;
        c = l1;
        d = i;
        e = l2;
        f = j;
        g = k;
    }

    public String getInterfaceName()
    {
        return a;
    }

    public long getMillisecondsConsume()
    {
        return e;
    }

    public long getReqSize()
    {
        return b;
    }

    public long getRespSize()
    {
        return c;
    }

    public int getResultType()
    {
        return d;
    }

    public int getReturnCode()
    {
        return f;
    }

    public int getSampling()
    {
        return g;
    }

    public void setInterfaceName(String s)
    {
        a = s;
    }

    public void setMillisecondsConsume(long l)
    {
        e = l;
    }

    public void setReqSize(long l)
    {
        b = l;
    }

    public void setRespSize(long l)
    {
        c = l;
    }

    public void setResultType(int i)
    {
        d = i;
    }

    public void setReturnCode(int i)
    {
        f = i;
    }

    public void setSampling(int i)
    {
        if (i <= 0)
        {
            i = 1;
        }
        g = i;
    }
}
