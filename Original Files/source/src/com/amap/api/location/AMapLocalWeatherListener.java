// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;


// Referenced classes of package com.amap.api.location:
//            AMapLocalWeatherForecast, AMapLocalWeatherLive

public interface AMapLocalWeatherListener
{

    public abstract void onWeatherForecaseSearched(AMapLocalWeatherForecast amaplocalweatherforecast);

    public abstract void onWeatherLiveSearched(AMapLocalWeatherLive amaplocalweatherlive);
}
