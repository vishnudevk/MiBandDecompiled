// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;


public final class  extends Enum
{

    public static final a DECODING_ERROR;
    public static final a IO_ERROR;
    public static final a NETWORK_DENIED;
    public static final a OUT_OF_MEMORY;
    public static final a UNKNOWN;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/nostra13/universalimageloader/core/assist/FailReason$FailType, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        IO_ERROR = new <init>("IO_ERROR", 0);
        DECODING_ERROR = new <init>("DECODING_ERROR", 1);
        NETWORK_DENIED = new <init>("NETWORK_DENIED", 2);
        OUT_OF_MEMORY = new <init>("OUT_OF_MEMORY", 3);
        UNKNOWN = new <init>("UNKNOWN", 4);
        e_3B_.clone aclone[] = new <init>[5];
        aclone[0] = IO_ERROR;
        aclone[1] = DECODING_ERROR;
        aclone[2] = NETWORK_DENIED;
        aclone[3] = OUT_OF_MEMORY;
        aclone[4] = UNKNOWN;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
