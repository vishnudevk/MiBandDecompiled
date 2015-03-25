// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;


final class o extends Enum
{

    public static final o a;
    public static final o b;
    public static final o c;
    private static final o d[];

    private o(String s, int i)
    {
        super(s, i);
    }

    public static o valueOf(String s)
    {
        return (o)Enum.valueOf(cn/com/smartdevices/bracelet/lua/o, s);
    }

    public static o[] values()
    {
        return (o[])d.clone();
    }

    static 
    {
        a = new o("EXPANDED", 0);
        b = new o("COLLAPSED", 1);
        c = new o("ANCHORED", 2);
        o ao[] = new o[3];
        ao[0] = a;
        ao[1] = b;
        ao[2] = c;
        d = ao;
    }
}
