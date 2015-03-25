// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import com.amap.api.location.core.AMapLocException;
import java.util.List;

public class AMapLocalWeatherForecast
{

    private String a;
    private List b;
    private AMapLocException c;

    public AMapLocalWeatherForecast()
    {
    }

    void a(AMapLocException amaplocexception)
    {
        c = amaplocexception;
    }

    void a(String s)
    {
        a = s;
    }

    void a(List list)
    {
        b = list;
    }

    public AMapLocException getAMapException()
    {
        return c;
    }

    public String getReportTime()
    {
        return a;
    }

    public List getWeatherForecast()
    {
        return b;
    }
}
