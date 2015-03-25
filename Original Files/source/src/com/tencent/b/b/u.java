// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;


public final class u
{

    public byte a[];
    public String b;

    public u()
    {
        b = "GBK";
    }

    public final String toString()
    {
        String s;
        try
        {
            s = new String(a, b);
        }
        catch (Exception exception)
        {
            return "";
        }
        return s;
    }
}
