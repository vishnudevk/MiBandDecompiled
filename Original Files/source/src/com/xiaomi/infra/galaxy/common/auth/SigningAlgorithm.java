// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.auth;


public final class SigningAlgorithm extends Enum
{

    private static final SigningAlgorithm $VALUES[];
    public static final SigningAlgorithm HmacSHA1;
    public static final SigningAlgorithm HmacSHA256;

    private SigningAlgorithm(String s, int i)
    {
        super(s, i);
    }

    public static SigningAlgorithm valueOf(String s)
    {
        return (SigningAlgorithm)Enum.valueOf(com/xiaomi/infra/galaxy/common/auth/SigningAlgorithm, s);
    }

    public static SigningAlgorithm[] values()
    {
        return (SigningAlgorithm[])$VALUES.clone();
    }

    static 
    {
        HmacSHA1 = new SigningAlgorithm("HmacSHA1", 0);
        HmacSHA256 = new SigningAlgorithm("HmacSHA256", 1);
        SigningAlgorithm asigningalgorithm[] = new SigningAlgorithm[2];
        asigningalgorithm[0] = HmacSHA1;
        asigningalgorithm[1] = HmacSHA256;
        $VALUES = asigningalgorithm;
    }
}
