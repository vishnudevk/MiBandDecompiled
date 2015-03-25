// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.weather;


public class OriginalWeatherInfo
{

    private AQI aqi;
    private Realtime realtime;

    public OriginalWeatherInfo()
    {
    }

    public AQI getAqi()
    {
        return aqi;
    }

    public Realtime getRealtime()
    {
        return realtime;
    }

    public void setAqi(AQI aqi1)
    {
        aqi = aqi1;
    }

    public void setRealtime(Realtime realtime1)
    {
        realtime = realtime1;
    }
}
