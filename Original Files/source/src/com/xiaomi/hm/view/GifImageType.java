// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.view;


public final class GifImageType extends Enum
{

    public static final GifImageType COVER;
    public static final GifImageType SYNC_DECODER;
    public static final GifImageType WAIT_FINISH;
    private static final GifImageType b[];
    final int a;

    private GifImageType(String s, int i, int j)
    {
        super(s, i);
        a = j;
    }

    public static GifImageType valueOf(String s)
    {
        return (GifImageType)Enum.valueOf(com/xiaomi/hm/view/GifImageType, s);
    }

    public static GifImageType[] values()
    {
        GifImageType agifimagetype[] = b;
        int i = agifimagetype.length;
        GifImageType agifimagetype1[] = new GifImageType[i];
        System.arraycopy(agifimagetype, 0, agifimagetype1, 0, i);
        return agifimagetype1;
    }

    static 
    {
        WAIT_FINISH = new GifImageType("WAIT_FINISH", 0, 0);
        SYNC_DECODER = new GifImageType("SYNC_DECODER", 1, 1);
        COVER = new GifImageType("COVER", 2, 2);
        GifImageType agifimagetype[] = new GifImageType[3];
        agifimagetype[0] = WAIT_FINISH;
        agifimagetype[1] = SYNC_DECODER;
        agifimagetype[2] = COVER;
        b = agifimagetype;
    }
}
