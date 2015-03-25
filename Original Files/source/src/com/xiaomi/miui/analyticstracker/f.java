// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;


final class f extends Enum
{

    public static final f a;
    public static final f b;
    private static final f c[];

    private f(String s, int i)
    {
        super(s, i);
    }

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/xiaomi/miui/analyticstracker/f, s);
    }

    public static f[] values()
    {
        return (f[])c.clone();
    }

    static 
    {
        a = new f("READ_WRITE", 0);
        b = new f("READ_ONLY", 1);
        f af[] = new f[2];
        af[0] = a;
        af[1] = b;
        c = af;
    }
}
