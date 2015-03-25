// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;


public final class g extends Enum
{

    public static final g I;
    public static final g J;
    public static final g K;
    public static final g L;
    public static final g M;
    public static final g N;
    public static final g O;
    public static final g P;
    private static final g a[];

    private g(String s, int i)
    {
        super(s, i);
    }

    public static g valueOf(String s)
    {
        return (g)Enum.valueOf(com/xiaomi/market/sdk/g, s);
    }

    public static g[] values()
    {
        g ag[] = a;
        int i = ag.length;
        g ag1[] = new g[i];
        System.arraycopy(ag, 0, ag1, 0, i);
        return ag1;
    }

    static 
    {
        I = new g("OK", 0);
        J = new g("URL_ERROR", 1);
        K = new g("NETWORK_ERROR", 2);
        L = new g("AUTH_ERROR", 3);
        M = new g("CLIENT_ERROR", 4);
        N = new g("SERVER_ERROR", 5);
        O = new g("RESULT_ERROR", 6);
        P = new g("UNKNOWN_ERROR", 7);
        g ag[] = new g[8];
        ag[0] = I;
        ag[1] = J;
        ag[2] = K;
        ag[3] = L;
        ag[4] = M;
        ag[5] = N;
        ag[6] = O;
        ag[7] = P;
        a = ag;
    }
}
