// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;


public final class  extends Enum
{

    public static final a DEFAULT;
    public static final a STACKED;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/achartengine/chart/BarChart$Type, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        DEFAULT = new <init>("DEFAULT", 0);
        STACKED = new <init>("STACKED", 1);
        e_3B_.clone aclone[] = new <init>[2];
        aclone[0] = DEFAULT;
        aclone[1] = STACKED;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
