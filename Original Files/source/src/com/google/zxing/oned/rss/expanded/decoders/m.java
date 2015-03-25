// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss.expanded.decoders;


final class m extends Enum
{

    public static final m a;
    public static final m b;
    public static final m c;
    private static final m d[];

    private m(String s, int i)
    {
        super(s, i);
    }

    public static m valueOf(String s)
    {
        return (m)Enum.valueOf(com/google/zxing/oned/rss/expanded/decoders/m, s);
    }

    public static m[] values()
    {
        return (m[])d.clone();
    }

    static 
    {
        a = new m("NUMERIC", 0);
        b = new m("ALPHA", 1);
        c = new m("ISO_IEC_646", 2);
        m am[] = new m[3];
        am[0] = a;
        am[1] = b;
        am[2] = c;
        d = am;
    }
}
