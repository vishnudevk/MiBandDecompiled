// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.common;


public class User
{

    private String a;
    private String b;
    private int c;

    public User(String s, String s1, int i)
    {
        a = null;
        b = null;
        a = s;
        b = s1;
        c = i;
    }

    public String getMac()
    {
        return b;
    }

    public int getType()
    {
        return c;
    }

    public String getUid()
    {
        return a;
    }

    public void setType(int i)
    {
        c = i;
    }
}
