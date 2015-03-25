// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.profile;


public final class advInt
{

    public final int advInt;
    public final int connInt;
    public final int connIntMax;
    public final int connIntMin;
    public final int latency;
    public final int timeout;

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(160);
        stringbuilder.append((new StringBuilder()).append("[[[ ").append(getClass().getSimpleName()).append(" ]]]").toString());
        stringbuilder.append((new StringBuilder()).append("\n  connIntMin: ").append((int)(1.25D * (double)connIntMin)).append("ms").toString());
        stringbuilder.append((new StringBuilder()).append("\n  connIntMax: ").append((int)(1.25D * (double)connIntMax)).append("ms").toString());
        stringbuilder.append((new StringBuilder()).append("\n     latency: ").append(latency).append("ms").toString());
        stringbuilder.append((new StringBuilder()).append("\n     timeout: ").append(10 * timeout).append("ms").toString());
        stringbuilder.append((new StringBuilder()).append("\n     connInt: ").append((int)(1.25D * (double)connInt)).append("ms").toString());
        stringbuilder.append((new StringBuilder()).append("\n      advInt: ").append((int)(0.625D * (double)advInt)).append("ms").toString());
        return stringbuilder.toString();
    }

    public (int i, int j, int k, int l, int i1, int j1)
    {
        connIntMin = i;
        connIntMax = j;
        latency = k;
        timeout = l;
        connInt = i1;
        advInt = j1;
    }
}
