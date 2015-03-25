// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.pdf417.encoder;


public final class Compaction extends Enum
{

    public static final Compaction AUTO;
    public static final Compaction BYTE;
    public static final Compaction NUMERIC;
    public static final Compaction TEXT;
    private static final Compaction a[];

    private Compaction(String s, int i)
    {
        super(s, i);
    }

    public static Compaction valueOf(String s)
    {
        return (Compaction)Enum.valueOf(com/google/zxing/pdf417/encoder/Compaction, s);
    }

    public static Compaction[] values()
    {
        return (Compaction[])a.clone();
    }

    static 
    {
        AUTO = new Compaction("AUTO", 0);
        TEXT = new Compaction("TEXT", 1);
        BYTE = new Compaction("BYTE", 2);
        NUMERIC = new Compaction("NUMERIC", 3);
        Compaction acompaction[] = new Compaction[4];
        acompaction[0] = AUTO;
        acompaction[1] = TEXT;
        acompaction[2] = BYTE;
        acompaction[3] = NUMERIC;
        a = acompaction;
    }
}
