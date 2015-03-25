// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;


public final class EncodeHintType extends Enum
{

    public static final EncodeHintType CHARACTER_SET;
    public static final EncodeHintType ERROR_CORRECTION;
    private static final EncodeHintType a[];

    private EncodeHintType(String s, int i)
    {
        super(s, i);
    }

    public static EncodeHintType valueOf(String s)
    {
        return (EncodeHintType)Enum.valueOf(com/google/zxing/EncodeHintType, s);
    }

    public static EncodeHintType[] values()
    {
        return (EncodeHintType[])a.clone();
    }

    static 
    {
        ERROR_CORRECTION = new EncodeHintType("ERROR_CORRECTION", 0);
        CHARACTER_SET = new EncodeHintType("CHARACTER_SET", 1);
        EncodeHintType aencodehinttype[] = new EncodeHintType[2];
        aencodehinttype[0] = ERROR_CORRECTION;
        aencodehinttype[1] = CHARACTER_SET;
        a = aencodehinttype;
    }
}
