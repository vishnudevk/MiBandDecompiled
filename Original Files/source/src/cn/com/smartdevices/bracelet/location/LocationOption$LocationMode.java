// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.location;


public final class  extends Enum
{

    public static final a BatterySave;
    public static final a GpsOnly;
    public static final a HighAccuracy;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(cn/com/smartdevices/bracelet/location/LocationOption$LocationMode, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        HighAccuracy = new <init>("HighAccuracy", 0);
        BatterySave = new <init>("BatterySave", 1);
        GpsOnly = new <init>("GpsOnly", 2);
        e_3B_.clone aclone[] = new <init>[3];
        aclone[0] = HighAccuracy;
        aclone[1] = BatterySave;
        aclone[2] = GpsOnly;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
