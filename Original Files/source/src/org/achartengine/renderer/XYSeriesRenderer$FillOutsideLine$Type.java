// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.renderer;


public final class  extends Enum
{

    public static final a ABOVE;
    public static final a BELOW;
    public static final a BOUNDS_ABOVE;
    public static final a BOUNDS_ALL;
    public static final a BOUNDS_BELOW;
    public static final a NONE;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/achartengine/renderer/XYSeriesRenderer$FillOutsideLine$Type, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        BOUNDS_ALL = new <init>("BOUNDS_ALL", 1);
        BOUNDS_BELOW = new <init>("BOUNDS_BELOW", 2);
        BOUNDS_ABOVE = new <init>("BOUNDS_ABOVE", 3);
        BELOW = new <init>("BELOW", 4);
        ABOVE = new <init>("ABOVE", 5);
        e_3B_.clone aclone[] = new <init>[6];
        aclone[0] = NONE;
        aclone[1] = BOUNDS_ALL;
        aclone[2] = BOUNDS_BELOW;
        aclone[3] = BOUNDS_ABOVE;
        aclone[4] = BELOW;
        aclone[5] = ABOVE;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
