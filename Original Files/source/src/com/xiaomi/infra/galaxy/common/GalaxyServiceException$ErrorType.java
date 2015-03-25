// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common;


public final class  extends Enum
{

    private static final .VALUES $VALUES[];
    public static final .VALUES Client;
    public static final .VALUES Service;
    public static final .VALUES Unknown;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/xiaomi/infra/galaxy/common/GalaxyServiceException$ErrorType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Client = new <init>("Client", 0);
        Service = new <init>("Service", 1);
        Unknown = new <init>("Unknown", 2);
        e_3B_.clone aclone[] = new <init>[3];
        aclone[0] = Client;
        aclone[1] = Service;
        aclone[2] = Unknown;
        $VALUES = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
