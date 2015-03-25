// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;


public final class LoadedFrom extends Enum
{

    public static final LoadedFrom DISC_CACHE;
    public static final LoadedFrom MEMORY_CACHE;
    public static final LoadedFrom NETWORK;
    private static final LoadedFrom a[];

    private LoadedFrom(String s, int i)
    {
        super(s, i);
    }

    public static LoadedFrom valueOf(String s)
    {
        return (LoadedFrom)Enum.valueOf(com/nostra13/universalimageloader/core/assist/LoadedFrom, s);
    }

    public static LoadedFrom[] values()
    {
        return (LoadedFrom[])a.clone();
    }

    static 
    {
        NETWORK = new LoadedFrom("NETWORK", 0);
        DISC_CACHE = new LoadedFrom("DISC_CACHE", 1);
        MEMORY_CACHE = new LoadedFrom("MEMORY_CACHE", 2);
        LoadedFrom aloadedfrom[] = new LoadedFrom[3];
        aloadedfrom[0] = NETWORK;
        aloadedfrom[1] = DISC_CACHE;
        aloadedfrom[2] = MEMORY_CACHE;
        a = aloadedfrom;
    }
}
