// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.weather;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.location.Location;
import cn.com.smartdevices.bracelet.webapi.BraceletHttpClient;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

// Referenced classes of package cn.com.smartdevices.bracelet.weather:
//            WeatherInfo, WeatherListener

public class WeatherManager
{

    private static final String TAG = "WeatherManager";
    public static final String URL_REQUEST_CITY = "http://weatherapi.market.xiaomi.com/wtr-v2/city/positioning?longitude=%s&latitude=%s&source=mihealth";
    public static final String URL_REQUEST_CITY_CODE = "http://weatherapi.market.xiaomi.com/wtr-v2/city/datasource?cityNames=%s&source=mihealth";
    public static final String URL_REQUEST_WEATHER = "http://weatherapi.market.xiaomi.com/wtr-v2/weather?cityId=%s&source=mihealth";
    public static final String URL_WEATHER_BASE = "http://weatherapi.market.xiaomi.com/wtr-v2";
    public static final String URL_WEATHER_BASE_SOURCE = "&source=mihealth";
    private static WeatherManager sManager;
    private Context mContext;
    private SharedPreferences mPrefs;
    private WeatherListener mWeatherListener;

    private WeatherManager(Context context)
    {
        mContext = context;
        mPrefs = mContext.getSharedPreferences("WeatherManager", 0);
    }

    public static WeatherManager getManager(Context context)
    {
        if (sManager == null)
        {
            sManager = new WeatherManager(context);
        }
        return sManager;
    }

    private void readOrRequestCityCode(Location location)
    {
        cn.com.smartdevices.bracelet.location.Location.Address address = location.getAddress();
        String s = null;
        if (address != null)
        {
            s = readLastCityCode(location.getAddress().toStringShort());
        }
        if (!TextUtils.isEmpty(s))
        {
            readOrRequestWeather(s);
            return;
        } else
        {
            requestCityByLocation(location);
            return;
        }
    }

    private void readOrRequestWeather(String s)
    {
        WeatherInfo weatherinfo = readLastWeatherInfo(s);
        if (weatherinfo != null)
        {
            int i = timeOffsetHours(weatherinfo.getTime(), System.currentTimeMillis());
            Debug.i("WeatherManager", (new StringBuilder()).append("Read Weather Time Offset Hours : ").append(i).toString());
            if (i == 0 && mWeatherListener != null)
            {
                mWeatherListener.onReceiveWeather(weatherinfo);
                return;
            } else
            {
                requestWeather(s);
                return;
            }
        } else
        {
            requestWeather(s);
            return;
        }
    }

    public static int timeOffsetHours(long l, long l1)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(l1);
        int i = 24;
        if (calendar.get(1) == calendar1.get(1) && calendar.get(6) == calendar1.get(6))
        {
            i = calendar1.get(11) - calendar.get(11);
        }
        return i;
    }

    public Context getContext()
    {
        return mContext;
    }

    public String readLastCityCode(String s)
    {
        String s1 = mPrefs.getString(s, null);
        Debug.i("WeatherManager", (new StringBuilder()).append("Read Last City Code : ").append(s).append(" , ").append(s1).toString());
        return s1;
    }

    public WeatherInfo readLastWeatherInfo(String s)
    {
        String s1 = mPrefs.getString(s, null);
        Debug.i("WeatherManager", (new StringBuilder()).append("Read Last Weather : ").append(s).append(" , ").append(s1).toString());
        boolean flag = TextUtils.isEmpty(s1);
        WeatherInfo weatherinfo = null;
        if (!flag)
        {
            weatherinfo = (WeatherInfo)(new Gson()).fromJson(s1, cn/com/smartdevices/bracelet/weather/WeatherInfo);
        }
        return weatherinfo;
    }

    public void registerLocationChanged()
    {
        IntentFilter intentfilter = new IntentFilter("com.xiaomi.hm.health.LocationReceived");
        LocalBroadcastManager.getInstance(mContext).registerReceiver(new _cls1(), intentfilter);
    }

    public void registerWeatherListener(WeatherListener weatherlistener)
    {
        mWeatherListener = weatherlistener;
    }

    public void requestCityByLocation(final Location finalLoc)
    {
        Debug.i("WeatherManager", (new StringBuilder()).append("Request City : ").append(finalLoc).toString());
        Object aobj[] = new Object[2];
        aobj[0] = String.valueOf(finalLoc.getLongitude());
        aobj[1] = String.valueOf(finalLoc.getLatitude());
        String s = String.format("http://weatherapi.market.xiaomi.com/wtr-v2/city/positioning?longitude=%s&latitude=%s&source=mihealth", aobj);
        cn.com.smartdevices.bracelet.location.Location.Address address = finalLoc.getAddress();
        if (address != null)
        {
            if (address.getCountryCode() != null)
            {
                s = (new StringBuilder()).append(s).append("&countryCode=").append(address.getCountryCode()).toString();
            } else
            {
                String s1 = (new StringBuilder()).append(s).append("&countryCode=CN").toString();
                s = (new StringBuilder()).append(s1).append("&language=zh_CN").toString();
            }
            if (!TextUtils.isEmpty(address.getAdmin()))
            {
                s = (new StringBuilder()).append(s).append("&adminArea=").append(Uri.encode(address.getAdmin())).toString();
            }
            if (!TextUtils.isEmpty(address.getLocality()))
            {
                s = (new StringBuilder()).append(s).append("&locality=").append(Uri.encode(address.getLocality())).toString();
            }
            if (!TextUtils.isEmpty(address.getSubLocality()))
            {
                s = (new StringBuilder()).append(s).append("&subLocality=").append(Uri.encode(address.getSubLocality())).toString();
            }
            if (!TextUtils.isEmpty(address.getThoroughfare()))
            {
                s = (new StringBuilder()).append(s).append("&thoroughfare=").append(Uri.encode(address.getThoroughfare())).toString();
            }
        }
        UmengAnalytics.event(mContext, "WeatherRequestCity");
        BraceletHttpClient.client.get(s, new _cls2());
    }

    public void requestCityCode(OriginalCityInfos.CityInfo cityinfo, final Location finalLoc)
    {
        StringBuilder stringbuilder = new StringBuilder();
        ArrayList arraylist = cityinfo.getNames();
        if (arraylist != null)
        {
            Iterator iterator = arraylist.iterator();
            int j;
            for (int i = 0; iterator.hasNext(); i = j)
            {
                OriginalCityInfos.Name name = (OriginalCityInfos.Name)iterator.next();
                stringbuilder.append(name.getName()).append(";");
                stringbuilder.append(name.getAffiliation()).append(";");
                stringbuilder.append(name.getLanguage()).append(";");
                stringbuilder.append(name.getShortName());
                j = i + 1;
                if (j < arraylist.size())
                {
                    stringbuilder.append("|");
                }
            }

        }
        Debug.i("WeatherManager", (new StringBuilder()).append("Request City Code : ").append(stringbuilder).toString());
        if (TextUtils.isEmpty(stringbuilder.toString()))
        {
            return;
        } else
        {
            Object aobj[] = new Object[1];
            aobj[0] = Uri.encode(stringbuilder.toString(), ";,");
            String s = String.format("http://weatherapi.market.xiaomi.com/wtr-v2/city/datasource?cityNames=%s&source=mihealth", aobj);
            UmengAnalytics.event(mContext, "WeatherRequestCityCode");
            final String finalCityNames = stringbuilder.toString();
            BraceletHttpClient.client.get(s, new _cls3());
            return;
        }
    }

    public void requestWeather(final String finalCityCode)
    {
        String s = String.format("http://weatherapi.market.xiaomi.com/wtr-v2/weather?cityId=%s&source=mihealth", new Object[] {
            finalCityCode
        });
        UmengAnalytics.event(mContext, "WeatherRequestWeather");
        BraceletHttpClient.client.get(s, new _cls4());
    }

    public void saveCityCode(String s, String s1)
    {
        Debug.i("WeatherManager", (new StringBuilder()).append("Save Last City Code : ").append(s).append(" , ").append(s1).toString());
        android.content.SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(s, s1);
        editor.commit();
    }

    public void saveWeatherInfo(String s, WeatherInfo weatherinfo)
    {
        String s1 = (new Gson()).toJson(weatherinfo);
        Debug.i("WeatherManager", (new StringBuilder()).append("Save Last Weather : ").append(s).append(", ").append(s1).toString());
        android.content.SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(s, s1);
        editor.commit();
    }





    private class _cls1 extends BroadcastReceiver
    {

        final WeatherManager this$0;

        public void onReceive(Context context, Intent intent)
        {
            Location location = (Location)intent.getParcelableExtra("Location");
            Debug.i("WeatherManager", (new StringBuilder()).append("Broadcast Receive Location : ").append(location).toString());
            if (location == null)
            {
                return;
            } else
            {
                UmengAnalytics.event(mContext, "WeatherStart");
                readOrRequestCityCode(location);
                return;
            }
        }

        _cls1()
        {
            this$0 = WeatherManager.this;
            super();
        }
    }


    private class _cls2 extends AsyncHttpResponseHandler
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
            OriginalCityInfos.CityInfo cityinfo = (OriginalCityInfos.CityInfo)originalcityinfos.getCityInfos().get(0);
_L4:
            if (cityinfo != null)
            {
                requestCityCode(cityinfo, finalLoc);
            }
            return;
            Exception exception;
            exception;
            Debug.w("WeatherManager", "Parse CityInfos Error!!", exception);
            UmengAnalytics.event(mContext, "WeatherException", (new StringBuilder()).append("City_").append(finalLoc.toStringShort()).toString());
            UmengAnalytics.exception(mContext, exception);
            cityinfo = null;
            continue; /* Loop/switch isn't completed */
_L2:
            cityinfo = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        _cls2()
        {
            this$0 = WeatherManager.this;
            finalLoc = location;
            super();
        }
    }


    private class _cls3 extends AsyncHttpResponseHandler
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
            UmengAnalytics.event(mContext, "WeatherException", (new StringBuilder()).append("CityCode_").append(finalCityNames).toString());
            UmengAnalytics.exception(mContext, exception);
            originalcitycodes = null;
            if (true) goto _L2; else goto _L1
_L1:
            if (finalLoc.getAddress() != null)
            {
                saveCityCode(finalLoc.getAddress().toStringShort(), s1);
            }
            readOrRequestWeather(s1);
            return;
        }

        _cls3()
        {
            this$0 = WeatherManager.this;
            finalCityNames = s;
            finalLoc = location;
            super();
        }
    }


    private class _cls4 extends AsyncHttpResponseHandler
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
            weatherinfo1.setWeatherDescription(WeatherInfo.toWeatherDescription(mContext, weatherinfo1.getWeather()));
            s1 = originalweatherinfo.getAqi().getAqi();
            if (TextUtils.isEmpty(s1) || "null".equals(s1)) goto _L2; else goto _L1
_L1:
            weatherinfo1.setAqi(Integer.valueOf(s1).intValue());
            weatherinfo1.setAqiLevel(WeatherInfo.toAqiLevel(weatherinfo1.getAqi()));
            weatherinfo1.setAqiDescription(WeatherInfo.toAqiDescription(mContext, weatherinfo1.getAqiLevel()));
_L3:
            WeatherInfo weatherinfo = weatherinfo1;
_L4:
            if (weatherinfo != null)
            {
                Debug.i("WeatherManager", (new StringBuilder()).append("Weather : ").append(weatherinfo).toString());
                saveWeatherInfo(finalCityCode, weatherinfo);
                if (mWeatherListener != null)
                {
                    mWeatherListener.onReceiveWeather(weatherinfo);
                }
            }
            return;
_L2:
            UmengAnalytics.event(mContext, "WeatherException", (new StringBuilder()).append("Weather_NoAqi_").append(finalCityCode).toString());
              goto _L3
            Exception exception;
            exception;
            Debug.w("WeatherManager", "Parse WeatherInfo Error!!", exception);
            UmengAnalytics.event(mContext, "WeatherException", (new StringBuilder()).append("Weather_").append(finalCityCode).toString());
            UmengAnalytics.exception(mContext, exception);
            weatherinfo = null;
              goto _L4
        }

        _cls4()
        {
            this$0 = WeatherManager.this;
            finalCityCode = s;
            super();
        }
    }

}
