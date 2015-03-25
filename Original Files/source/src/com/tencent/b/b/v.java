// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;


public final class v
{

    private static v b;
    private int a;

    private v()
    {
        a = 0;
    }

    public static v a()
    {
        if (b == null)
        {
            b = new v();
        }
        return b;
    }
}
