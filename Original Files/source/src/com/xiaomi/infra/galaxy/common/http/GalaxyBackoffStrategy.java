// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.http;


public class GalaxyBackoffStrategy
{

    private static final GalaxyBackoffStrategy galaxyBackoffStrategy = new GalaxyBackoffStrategy();

    private GalaxyBackoffStrategy()
    {
    }

    public static GalaxyBackoffStrategy getInstance()
    {
        return galaxyBackoffStrategy;
    }

    public int getBackoffPeriod(int i)
    {
        int j;
        if (i <= 0)
        {
            j = 0;
        } else
        {
            j = 50 * (int)Math.pow(2D, i - 1);
            if (j < 0)
            {
                return 0x7fffffff;
            }
        }
        return j;
    }

}
