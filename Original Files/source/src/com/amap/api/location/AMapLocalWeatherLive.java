// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import com.amap.api.location.core.AMapLocException;

public class AMapLocalWeatherLive
{

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private AMapLocException g;
    private String h;
    private String i;
    private String j;

    public AMapLocalWeatherLive()
    {
    }

    void a(AMapLocException amaplocexception)
    {
        g = amaplocexception;
    }

    void a(String s)
    {
        a = s;
    }

    void b(String s)
    {
        b = s;
    }

    void c(String s)
    {
        c = s;
    }

    void d(String s)
    {
        d = s;
    }

    void e(String s)
    {
        e = s;
    }

    void f(String s)
    {
        f = s;
    }

    public AMapLocException getAMapException()
    {
        return g;
    }

    public String getCity()
    {
        return h;
    }

    public String getCityCode()
    {
        return j;
    }

    public String getHumidity()
    {
        return e;
    }

    public String getProvince()
    {
        return i;
    }

    public String getReportTime()
    {
        return f;
    }

    public String getTemperature()
    {
        return b;
    }

    public String getWeather()
    {
        return a;
    }

    public String getWindDir()
    {
        return c;
    }

    public String getWindPower()
    {
        return d;
    }

    public void setCity(String s)
    {
        h = s;
    }

    public void setCityCode(String s)
    {
        j = s;
    }

    public void setProvince(String s)
    {
        i = s;
    }
}
