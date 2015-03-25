// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;


// Referenced classes of package com.tencent.stat:
//            StatReportStrategy

class g
{

    static final int a[];

    static 
    {
        a = new int[StatReportStrategy.values().length];
        try
        {
            a[StatReportStrategy.INSTANT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[StatReportStrategy.ONLY_WIFI.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[StatReportStrategy.APP_LAUNCH.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[StatReportStrategy.DEVELOPER.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[StatReportStrategy.BATCH.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[StatReportStrategy.PERIOD.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[StatReportStrategy.ONLY_WIFI_NO_CACHE.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6)
        {
            return;
        }
    }
}
