// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.weather;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.location.Location;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet.weather:
//            OriginalCityInfos, WeatherManager

class  extends AsyncHttpResponseHandler
{

    final WeatherManager this$0;
    final Location val$finalLoc;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Debug.w("WeatherManager", "Request CityInfos Failed!!", throwable);
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        String s;
        Debug.i("WeatherManager", "Request CityInfos Successed!!");
        s = new String(abyte0);
        Debug.i("WeatherManager", (new StringBuilder()).append("Respone : ").append(s).toString());
        OriginalCityInfos originalcityinfos;
        originalcityinfos = (OriginalCityInfos)(new Gson()).fromJson(s, cn/com/smartdevices/bracelet/weather/OriginalCityInfos);
        Debug.i("WeatherManager", (new StringBuilder()).append("CityInfos : ").append(originalcityinfos.toString()).toString());
        if (originalcityinfos.getCityInfos().size() <= 0) goto _L2; else goto _L1
_L1:
        .CityInfo cityinfo = (.CityInfo)originalcityinfos.getCityInfos().get(0);
_L4:
        if (cityinfo != null)
        {
            requestCityCode(cityinfo, val$finalLoc);
        }
        return;
        Exception exception;
        exception;
        Debug.w("WeatherManager", "Parse CityInfos Error!!", exception);
        UmengAnalytics.event(WeatherManager.access$000(WeatherManager.this), "WeatherException", (new StringBuilder()).append("City_").append(val$finalLoc.toStringShort()).toString());
        UmengAnalytics.exception(WeatherManager.access$000(WeatherManager.this), exception);
        cityinfo = null;
        continue; /* Loop/switch isn't completed */
_L2:
        cityinfo = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    .CityInfo()
    {
        this$0 = final_weathermanager;
        val$finalLoc = Location.this;
        super();
    }
}
