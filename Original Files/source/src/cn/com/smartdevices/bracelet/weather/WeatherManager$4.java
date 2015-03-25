// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.weather;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet.weather:
//            OriginalWeatherInfo, WeatherInfo, WeatherManager, WeatherListener

class  extends AsyncHttpResponseHandler
{

    final WeatherManager this$0;
    final String val$finalCityCode;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Debug.w("WeatherManager", "Request Weather Failed!!", throwable);
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        String s;
        Debug.i("WeatherManager", "Request Weather Successed!!");
        s = new String(abyte0);
        Debug.i("WeatherManager", (new StringBuilder()).append("Respone : ").append(s).toString());
        WeatherInfo weatherinfo1;
        String s1;
        OriginalWeatherInfo originalweatherinfo = (OriginalWeatherInfo)(new Gson()).fromJson(s, cn/com/smartdevices/bracelet/weather/OriginalWeatherInfo);
        Debug.i("WeatherManager", (new StringBuilder()).append("WeatherInfo : ").append(originalweatherinfo).toString());
        weatherinfo1 = new WeatherInfo();
        weatherinfo1.setTime(System.currentTimeMillis());
        weatherinfo1.setWeather(originalweatherinfo.getRealtime().getWeather());
        weatherinfo1.setWeatherDescription(WeatherInfo.toWeatherDescription(WeatherManager.access$000(WeatherManager.this), weatherinfo1.getWeather()));
        s1 = originalweatherinfo.getAqi().getAqi();
        if (TextUtils.isEmpty(s1) || "null".equals(s1)) goto _L2; else goto _L1
_L1:
        weatherinfo1.setAqi(Integer.valueOf(s1).intValue());
        weatherinfo1.setAqiLevel(WeatherInfo.toAqiLevel(weatherinfo1.getAqi()));
        weatherinfo1.setAqiDescription(WeatherInfo.toAqiDescription(WeatherManager.access$000(WeatherManager.this), weatherinfo1.getAqiLevel()));
_L3:
        WeatherInfo weatherinfo = weatherinfo1;
_L4:
        if (weatherinfo != null)
        {
            Debug.i("WeatherManager", (new StringBuilder()).append("Weather : ").append(weatherinfo).toString());
            saveWeatherInfo(val$finalCityCode, weatherinfo);
            if (WeatherManager.access$300(WeatherManager.this) != null)
            {
                WeatherManager.access$300(WeatherManager.this).onReceiveWeather(weatherinfo);
            }
        }
        return;
_L2:
        UmengAnalytics.event(WeatherManager.access$000(WeatherManager.this), "WeatherException", (new StringBuilder()).append("Weather_NoAqi_").append(val$finalCityCode).toString());
          goto _L3
        Exception exception;
        exception;
        Debug.w("WeatherManager", "Parse WeatherInfo Error!!", exception);
        UmengAnalytics.event(WeatherManager.access$000(WeatherManager.this), "WeatherException", (new StringBuilder()).append("Weather_").append(val$finalCityCode).toString());
        UmengAnalytics.exception(WeatherManager.access$000(WeatherManager.this), exception);
        weatherinfo = null;
          goto _L4
    }

    fo.AQI()
    {
        this$0 = final_weathermanager;
        val$finalCityCode = String.this;
        super();
    }
}
