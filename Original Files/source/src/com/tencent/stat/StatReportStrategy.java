// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;


public final class StatReportStrategy extends Enum
{

    public static final StatReportStrategy APP_LAUNCH;
    public static final StatReportStrategy BATCH;
    public static final StatReportStrategy DEVELOPER;
    public static final StatReportStrategy INSTANT;
    public static final StatReportStrategy ONLY_WIFI;
    public static final StatReportStrategy ONLY_WIFI_NO_CACHE;
    public static final StatReportStrategy PERIOD;
    private static final StatReportStrategy b[];
    int a;

    private StatReportStrategy(String s, int i, int j)
    {
        super(s, i);
        a = j;
    }

    public static StatReportStrategy getStatReportStrategy(int i)
    {
        StatReportStrategy astatreportstrategy[] = values();
        int j = astatreportstrategy.length;
        for (int k = 0; k < j; k++)
        {
            StatReportStrategy statreportstrategy = astatreportstrategy[k];
            if (i == statreportstrategy.getIntValue())
            {
                return statreportstrategy;
            }
        }

        return null;
    }

    public static StatReportStrategy valueOf(String s)
    {
        return (StatReportStrategy)Enum.valueOf(com/tencent/stat/StatReportStrategy, s);
    }

    public static StatReportStrategy[] values()
    {
        return (StatReportStrategy[])b.clone();
    }

    public int getIntValue()
    {
        return a;
    }

    static 
    {
        INSTANT = new StatReportStrategy("INSTANT", 0, 1);
        ONLY_WIFI = new StatReportStrategy("ONLY_WIFI", 1, 2);
        BATCH = new StatReportStrategy("BATCH", 2, 3);
        APP_LAUNCH = new StatReportStrategy("APP_LAUNCH", 3, 4);
        DEVELOPER = new StatReportStrategy("DEVELOPER", 4, 5);
        PERIOD = new StatReportStrategy("PERIOD", 5, 6);
        ONLY_WIFI_NO_CACHE = new StatReportStrategy("ONLY_WIFI_NO_CACHE", 6, 7);
        StatReportStrategy astatreportstrategy[] = new StatReportStrategy[7];
        astatreportstrategy[0] = INSTANT;
        astatreportstrategy[1] = ONLY_WIFI;
        astatreportstrategy[2] = BATCH;
        astatreportstrategy[3] = APP_LAUNCH;
        astatreportstrategy[4] = DEVELOPER;
        astatreportstrategy[5] = PERIOD;
        astatreportstrategy[6] = ONLY_WIFI_NO_CACHE;
        b = astatreportstrategy;
    }
}
