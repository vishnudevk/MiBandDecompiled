// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.pdf417.decoder;


final class d extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    public static final d f;
    private static final d g[];

    private d(String s, int i)
    {
        super(s, i);
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/google/zxing/pdf417/decoder/d, s);
    }

    public static d[] values()
    {
        return (d[])g.clone();
    }

    static 
    {
        a = new d("ALPHA", 0);
        b = new d("LOWER", 1);
        c = new d("MIXED", 2);
        d = new d("PUNCT", 3);
        e = new d("ALPHA_SHIFT", 4);
        f = new d("PUNCT_SHIFT", 5);
        d ad[] = new d[6];
        ad[0] = a;
        ad[1] = b;
        ad[2] = c;
        ad[3] = d;
        ad[4] = e;
        ad[5] = f;
        g = ad;
    }
}
