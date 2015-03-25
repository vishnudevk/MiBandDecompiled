// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.renderer;


public final class a extends Enum
{

    public static final b HORIZONTAL;
    public static final b VERTICAL;
    private static final b b[];
    private int a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(org/achartengine/renderer/XYMultipleSeriesRenderer$Orientation, s);
    }

    public static a[] values()
    {
        return (a[])b.clone();
    }

    public int getAngle()
    {
        return a;
    }

    static 
    {
        HORIZONTAL = new <init>("HORIZONTAL", 0, 0);
        VERTICAL = new <init>("VERTICAL", 1, 90);
        a aa[] = new <init>[2];
        aa[0] = HORIZONTAL;
        aa[1] = VERTICAL;
        b = aa;
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = 0;
        a = j;
    }
}
