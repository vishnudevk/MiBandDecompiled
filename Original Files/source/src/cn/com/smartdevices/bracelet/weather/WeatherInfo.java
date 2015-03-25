// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.weather;

import android.content.Context;
import android.content.res.Resources;
import java.text.DateFormat;
import java.util.Date;

public class WeatherInfo
{

    public static final int AQI_LEVEL_1[] = {
        0, 50
    };
    public static final int AQI_LEVEL_2[] = {
        51, 100
    };
    public static final int AQI_LEVEL_3[] = {
        100, 150
    };
    public static final int AQI_LEVEL_4[] = {
        151, 200
    };
    public static final int AQI_LEVEL_5[] = {
        201, 300
    };
    public static final int AQI_LEVEL_6[] = {
        300, 500
    };
    private static String sWeatherCloudy[];
    private static String sWeatherFine[];
    private static String sWeatherFog[];
    private static String sWeatherHaze[];
    private static String sWeatherOvercast[];
    private static String sWeatherRainSnows[];
    private static String sWeatherRains[];
    private static String sWeatherSands[];
    private static String sWeatherSnows[];
    private int aqi;
    private String aqiDescription;
    private int aqiLevel;
    private long time;
    private String weather;
    private String weatherDescription;

    public WeatherInfo()
    {
        aqi = -1;
        aqiLevel = 0;
    }

    private static boolean has(String as[], String s)
    {
        int i = as.length;
        int j = 0;
        do
        {
label0:
            {
                boolean flag = false;
                if (j < i)
                {
                    if (!as[j].equals(s))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            j++;
        } while (true);
    }

    public static String toAqiDescription(Context context, int i)
    {
        String as[] = context.getResources().getStringArray(0x7f070003);
        String s = null;
        if (i > 0)
        {
            s = as[i - 1];
        }
        return s;
    }

    public static int toAqiLevel(int i)
    {
        if (i >= AQI_LEVEL_1[0] && i <= AQI_LEVEL_1[1])
        {
            return 1;
        }
        if (i >= AQI_LEVEL_2[0] && i <= AQI_LEVEL_2[1])
        {
            return 2;
        }
        if (i >= AQI_LEVEL_3[0] && i <= AQI_LEVEL_3[1])
        {
            return 3;
        }
        if (i >= AQI_LEVEL_4[0] && i <= AQI_LEVEL_4[1])
        {
            return 4;
        }
        if (i >= AQI_LEVEL_5[0] && i <= AQI_LEVEL_5[1])
        {
            return 5;
        }
        return i < AQI_LEVEL_6[0] || i > AQI_LEVEL_6[1] ? 0 : 6;
    }

    public static String toWeatherDescription(Context context, String s)
    {
        if (sWeatherRains == null)
        {
            sWeatherRains = context.getResources().getStringArray(0x7f07000a);
        }
        String s1;
        if (has(sWeatherRains, s))
        {
            s1 = context.getString(0x7f0d01e9);
        } else
        {
            if (sWeatherRainSnows == null)
            {
                sWeatherRainSnows = context.getResources().getStringArray(0x7f070009);
            }
            if (has(sWeatherRainSnows, s))
            {
                return context.getString(0x7f0d01ea);
            }
            if (sWeatherSnows == null)
            {
                sWeatherSnows = context.getResources().getStringArray(0x7f07000c);
            }
            if (has(sWeatherSnows, s))
            {
                return context.getString(0x7f0d01ec);
            }
            if (sWeatherSands == null)
            {
                sWeatherSands = context.getResources().getStringArray(0x7f07000b);
            }
            if (has(sWeatherSands, s))
            {
                return context.getString(0x7f0d01eb);
            }
            if (sWeatherFine == null)
            {
                sWeatherFine = context.getResources().getStringArray(0x7f070005);
            }
            if (has(sWeatherFine, s))
            {
                return context.getString(0x7f0d01e5);
            }
            if (sWeatherCloudy == null)
            {
                sWeatherCloudy = context.getResources().getStringArray(0x7f070004);
            }
            if (has(sWeatherCloudy, s))
            {
                return context.getString(0x7f0d01e4);
            }
            if (sWeatherOvercast == null)
            {
                sWeatherOvercast = context.getResources().getStringArray(0x7f070008);
            }
            if (has(sWeatherOvercast, s))
            {
                return context.getString(0x7f0d01e8);
            }
            if (sWeatherFog == null)
            {
                sWeatherFog = context.getResources().getStringArray(0x7f070006);
            }
            if (has(sWeatherFog, s))
            {
                return context.getString(0x7f0d01e6);
            }
            if (sWeatherHaze == null)
            {
                sWeatherHaze = context.getResources().getStringArray(0x7f070007);
            }
            boolean flag = has(sWeatherHaze, s);
            s1 = null;
            if (flag)
            {
                return context.getString(0x7f0d01e7);
            }
        }
        return s1;
    }

    public int getAqi()
    {
        return aqi;
    }

    public String getAqiDescription()
    {
        return aqiDescription;
    }

    public int getAqiLevel()
    {
        return aqiLevel;
    }

    public long getTime()
    {
        return time;
    }

    public String getWeather()
    {
        return weather;
    }

    public String getWeatherDescription()
    {
        return weatherDescription;
    }

    public void setAqi(int i)
    {
        aqi = i;
    }

    public void setAqiDescription(String s)
    {
        aqiDescription = s;
    }

    public void setAqiLevel(int i)
    {
        aqiLevel = i;
    }

    public void setTime(long l)
    {
        time = l;
    }

    public void setWeather(String s)
    {
        weather = s;
    }

    public void setWeatherDescription(String s)
    {
        weatherDescription = s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Date date = new Date(time);
        String s = DateFormat.getTimeInstance().format(date);
        stringbuilder.append("\n").append("Time : ").append(s);
        stringbuilder.append("\n").append("Weather : ").append(weather);
        stringbuilder.append("\n").append("AQI : ").append(aqi);
        stringbuilder.append("\n").append("AQI Level : ").append(aqiLevel);
        stringbuilder.append("\n").append("AQI Description : ").append(aqiDescription);
        return stringbuilder.toString();
    }

}
