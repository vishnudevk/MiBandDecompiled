// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.aztec.decoder;


final class b extends Enum
{

    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;
    public static final b f;
    private static final b g[];

    private b(String s, int i)
    {
        super(s, i);
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/google/zxing/aztec/decoder/b, s);
    }

    public static b[] values()
    {
        return (b[])g.clone();
    }

    static 
    {
        a = new b("UPPER", 0);
        b = new b("LOWER", 1);
        c = new b("MIXED", 2);
        d = new b("DIGIT", 3);
        e = new b("PUNCT", 4);
        f = new b("BINARY", 5);
        b ab[] = new b[6];
        ab[0] = a;
        ab[1] = b;
        ab[2] = c;
        ab[3] = d;
        ab[4] = e;
        ab[5] = f;
        g = ab;
    }
}
