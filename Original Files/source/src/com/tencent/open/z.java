// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;


final class z extends Enum
{

    public static final z a;
    public static final z b;
    public static final z c;
    public static final z d;
    public static final z e;
    public static final z f;
    private static final z g[];

    private z(String s, int i)
    {
        super(s, i);
    }

    public static z[] a()
    {
        return (z[])g.clone();
    }

    static 
    {
        a = new z("INIT", 0);
        b = new z("WAITTING_BACK_TASKINFO", 1);
        c = new z("WAITTING_BACK_REWARD", 2);
        d = new z("NORAML", 3);
        e = new z("REWARD_SUCCESS", 4);
        f = new z("REWARD_FAIL", 5);
        z az[] = new z[6];
        az[0] = a;
        az[1] = b;
        az[2] = c;
        az[3] = d;
        az[4] = e;
        az[5] = f;
        g = az;
    }
}
