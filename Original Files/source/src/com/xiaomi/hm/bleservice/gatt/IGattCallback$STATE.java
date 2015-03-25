// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.gatt;


public final class  extends Enum
{

    private static final .VALUES $VALUES[];
    public static final .VALUES CONNECTED;
    public static final .VALUES CONNECTING;
    public static final .VALUES DISCONNECTED;
    public static final .VALUES DISCONNECTING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/xiaomi/hm/bleservice/gatt/IGattCallback$STATE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DISCONNECTING = new <init>("DISCONNECTING", 0, 3);
        DISCONNECTED = new <init>("DISCONNECTED", 1, 0);
        CONNECTING = new <init>("CONNECTING", 2, 1);
        CONNECTED = new <init>("CONNECTED", 3, 2);
        E_3B_.clone aclone[] = new <init>[4];
        aclone[0] = DISCONNECTING;
        aclone[1] = DISCONNECTED;
        aclone[2] = CONNECTING;
        aclone[3] = CONNECTED;
        $VALUES = aclone;
    }

    private (String s, int i, int j)
    {
        super(s, i);
    }
}
