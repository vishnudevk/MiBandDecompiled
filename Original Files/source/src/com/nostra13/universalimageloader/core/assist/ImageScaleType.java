// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;


public final class ImageScaleType extends Enum
{

    public static final ImageScaleType EXACTLY;
    public static final ImageScaleType EXACTLY_STRETCHED;
    public static final ImageScaleType IN_SAMPLE_INT;
    public static final ImageScaleType IN_SAMPLE_POWER_OF_2;
    public static final ImageScaleType NONE;
    private static final ImageScaleType a[];

    private ImageScaleType(String s, int i)
    {
        super(s, i);
    }

    public static ImageScaleType valueOf(String s)
    {
        return (ImageScaleType)Enum.valueOf(com/nostra13/universalimageloader/core/assist/ImageScaleType, s);
    }

    public static ImageScaleType[] values()
    {
        return (ImageScaleType[])a.clone();
    }

    static 
    {
        NONE = new ImageScaleType("NONE", 0);
        IN_SAMPLE_POWER_OF_2 = new ImageScaleType("IN_SAMPLE_POWER_OF_2", 1);
        IN_SAMPLE_INT = new ImageScaleType("IN_SAMPLE_INT", 2);
        EXACTLY = new ImageScaleType("EXACTLY", 3);
        EXACTLY_STRETCHED = new ImageScaleType("EXACTLY_STRETCHED", 4);
        ImageScaleType aimagescaletype[] = new ImageScaleType[5];
        aimagescaletype[0] = NONE;
        aimagescaletype[1] = IN_SAMPLE_POWER_OF_2;
        aimagescaletype[2] = IN_SAMPLE_INT;
        aimagescaletype[3] = EXACTLY;
        aimagescaletype[4] = EXACTLY_STRETCHED;
        a = aimagescaletype;
    }
}
