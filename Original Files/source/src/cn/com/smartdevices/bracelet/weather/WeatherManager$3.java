// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.weather;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.location.Location;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet.weather:
//            OriginalCityCodes, WeatherManager

class  extends AsyncHttpResponseHandler
{

    final WeatherManager this$0;
    final String val$finalCityNames;
    final Location val$finalLoc;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Debug.w("WeatherManager", "Request CityCodes Failed!!", throwable);
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        String s;
        Debug.i("WeatherManager", "Request CityCodes Successed!!");
        s = new String(abyte0);
        Debug.i("WeatherManager", (new StringBuilder()).append("Respone : ").append(s).toString());
        OriginalCityCodes originalcitycodes1;
        originalcitycodes1 = (OriginalCityCodes)(new Gson()).fromJson(s, cn/com/smartdevices/bracelet/weather/OriginalCityCodes);
        Debug.i("WeatherManager", (new StringBuilder()).append("CityCodes : ").append(originalcitycodes1.toString()).toString());
        OriginalCityCodes originalcitycodes = originalcitycodes1;
_L2:
        String s1;
        if (originalcitycodes != null)
        {
            s1 = originalcitycodes.getCityCode(OriginalCityCodes.TYPE_XIAOMI);
            Debug.i("WeatherManager", (new StringBuilder()).append("Request Weather : ").append(s1).toString());
            if (TextUtils.isEmpty(s1))
            {
                s1 = originalcitycodes.getCityCode(OriginalCityCodes.TYPE_WEATHER_CHINA);
                Debug.i("WeatherManager", (new StringBuilder()).append("Request Weather : ").append(s1).toString());
            }
            if (!TextUtils.isEmpty(s1))
            {
                break; /* Loop/switch isn't completed */
            }
        }
        return;
        Exception exception;
        exception;
        Debug.w("WeatherManager", "Parse CityCodes Error!!", exception);
        UmengAnalytics.event(WeatherManager.access$000(WeatherManager.this), "WeatherException", (new StringBuilder()).append("CityCode_").append(val$finalCityNames).toString());
        UmengAnalytics.exception(WeatherManager.access$000(WeatherManager.this), exception);
        originalcitycodes = null;
        if (true) goto _L2; else goto _L1
_L1:
        if (val$finalLoc.getAddress() != null)
        {
            saveCityCode(val$finalLoc.getAddress().toStringShort(), s1);
        }
        WeatherManager.access$200(WeatherManager.this, s1);
        return;
    }

    ()
    {
        this$0 = final_weathermanager;
        val$finalCityNames = s;
        val$finalLoc = Location.this;
        super();
    }
}
