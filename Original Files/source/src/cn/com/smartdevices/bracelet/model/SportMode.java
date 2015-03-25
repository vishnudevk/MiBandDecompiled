// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


public final class SportMode extends Enum
{

    private static final SportMode $VALUES[];
    public static final SportMode NONWEAR;
    public static final SportMode NOREM;
    public static final SportMode REM;
    public static final SportMode RUNNING;
    public static final SportMode SILENT;
    public static final SportMode WALKING;

    private SportMode(String s, int i)
    {
        super(s, i);
    }

    public static SportMode valueOf(String s)
    {
        return (SportMode)Enum.valueOf(cn/com/smartdevices/bracelet/model/SportMode, s);
    }

    public static SportMode[] values()
    {
        return (SportMode[])$VALUES.clone();
    }

    static 
    {
        SILENT = new SportMode("SILENT", 0);
        WALKING = new SportMode("WALKING", 1);
        RUNNING = new SportMode("RUNNING", 2);
        NONWEAR = new SportMode("NONWEAR", 3);
        REM = new SportMode("REM", 4);
        NOREM = new SportMode("NOREM", 5);
        SportMode asportmode[] = new SportMode[6];
        asportmode[0] = SILENT;
        asportmode[1] = WALKING;
        asportmode[2] = RUNNING;
        asportmode[3] = NONWEAR;
        asportmode[4] = REM;
        asportmode[5] = NOREM;
        $VALUES = asportmode;
    }
}
