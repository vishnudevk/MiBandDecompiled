// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.location.core.c;
import com.amap.api.location.core.d;
import com.aps.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.amap.api.location:
//            AMapLocationListener, k, AMapLocalWeatherForecast, AMapLocalDayWeatherForecast, 
//            AMapLocation, AMapLocalWeatherLive, a, AMapLocalWeatherListener

public class b
    implements AMapLocationListener
{

    k a;
    AMapLocalWeatherListener b;
    a c;
    private Context d;
    private int e;
    private AMapLocalWeatherListener f;

    public b(a a1, Context context)
    {
        a = null;
        d = context;
        c = a1;
        a = new k(this);
    }

    static int a(b b1)
    {
        return b1.e;
    }

    private AMapLocalWeatherForecast a(String s, AMapLocation amaplocation)
    {
        AMapLocalWeatherForecast amaplocalweatherforecast = new AMapLocalWeatherForecast();
        JSONArray jsonarray;
        try
        {
            com.amap.api.location.core.d.a(s);
        }
        catch (AMapLocException amaplocexception)
        {
            amaplocalweatherforecast.a(amaplocexception);
            amaplocexception.printStackTrace();
        }
        jsonarray = (new JSONObject(s)).getJSONArray("forecasts");
        if (jsonarray != null && jsonarray.length() > 0)
        {
            JSONObject jsonobject = (JSONObject)jsonarray.get(0);
            amaplocalweatherforecast.a(a(jsonobject, "reporttime"));
            JSONArray jsonarray1 = jsonobject.getJSONArray("casts");
            if (jsonarray1 != null && jsonarray1.length() > 0)
            {
                ArrayList arraylist = new ArrayList();
                for (int i = 0; i < jsonarray1.length(); i++)
                {
                    AMapLocalDayWeatherForecast amaplocaldayweatherforecast = new AMapLocalDayWeatherForecast();
                    JSONObject jsonobject1 = (JSONObject)jsonarray1.get(i);
                    String s1 = a(jsonobject1, "date");
                    String s2 = a(jsonobject1, "week");
                    String s3 = a(jsonobject1, "dayweather");
                    String s4 = a(jsonobject1, "nightweather");
                    String s5 = a(jsonobject1, "daytemp");
                    String s6 = a(jsonobject1, "nighttemp");
                    String s7 = a(jsonobject1, "daywind");
                    String s8 = a(jsonobject1, "nightwind");
                    String s9 = a(jsonobject1, "daypower");
                    String s10 = a(jsonobject1, "nightpower");
                    amaplocaldayweatherforecast.a(s1);
                    amaplocaldayweatherforecast.b(s2);
                    amaplocaldayweatherforecast.c(s3);
                    amaplocaldayweatherforecast.d(s4);
                    amaplocaldayweatherforecast.e(s5);
                    amaplocaldayweatherforecast.f(s6);
                    amaplocaldayweatherforecast.g(s7);
                    amaplocaldayweatherforecast.h(s8);
                    amaplocaldayweatherforecast.i(s9);
                    amaplocaldayweatherforecast.j(s10);
                    amaplocaldayweatherforecast.setCity(amaplocation.getCity());
                    amaplocaldayweatherforecast.setCityCode(amaplocation.getCityCode());
                    amaplocaldayweatherforecast.setProvince(amaplocation.getProvince());
                    arraylist.add(amaplocaldayweatherforecast);
                }

                amaplocalweatherforecast.a(arraylist);
            }
        }
        return amaplocalweatherforecast;
    }

    private AMapLocalWeatherLive a(String s)
    {
        AMapLocalWeatherLive amaplocalweatherlive = new AMapLocalWeatherLive();
        JSONArray jsonarray;
        JSONObject jsonobject;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        try
        {
            com.amap.api.location.core.d.a(s);
        }
        catch (AMapLocException amaplocexception)
        {
            amaplocalweatherlive.a(amaplocexception);
        }
        try
        {
            jsonarray = (new JSONObject(s)).getJSONArray("lives");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return amaplocalweatherlive;
        }
        if (jsonarray == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        if (jsonarray.length() > 0)
        {
            jsonobject = (JSONObject)jsonarray.get(0);
            s1 = a(jsonobject, "weather");
            s2 = a(jsonobject, "temperature");
            s3 = a(jsonobject, "winddirection");
            s4 = a(jsonobject, "windpower");
            s5 = a(jsonobject, "humidity");
            s6 = a(jsonobject, "reporttime");
            amaplocalweatherlive.a(s1);
            amaplocalweatherlive.f(s6);
            amaplocalweatherlive.e(s5);
            amaplocalweatherlive.b(s2);
            amaplocalweatherlive.c(s3);
            amaplocalweatherlive.d(s4);
        }
        return amaplocalweatherlive;
    }

    private String a()
    {
        return "http://restapi.amap.com/v3/weather/weatherInfo?";
    }

    private byte[] a(AMapLocation amaplocation, String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("output=json&ec=1").append((new StringBuilder()).append("&extensions=").append(s).toString()).append("&city=").append(amaplocation.getAdCode());
        stringbuffer.append((new StringBuilder()).append("&key=").append(com.amap.api.location.core.c.a()).toString());
        return stringbuffer.toString().getBytes("utf-8");
    }

    static AMapLocalWeatherListener b(b b1)
    {
        return b1.f;
    }

    protected String a(JSONObject jsonobject, String s)
    {
        String s1;
        if (jsonobject == null)
        {
            s1 = "";
        } else
        {
            s1 = "";
            if (jsonobject.has(s) && !jsonobject.getString(s).equals("[]"))
            {
                return jsonobject.optString(s);
            }
        }
        return s1;
    }

    void a(int i, AMapLocalWeatherListener amaplocalweatherlistener, AMapLocation amaplocation)
    {
        e = i;
        f = amaplocalweatherlistener;
        if (amaplocation == null)
        {
            try
            {
                c.a(-1L, 10F, this, "lbs", true);
                return;
            }
            catch (Throwable throwable)
            {
                throwable.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_69;
        }
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        a(amaplocation, "base", amaplocalweatherlistener);
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        a(amaplocation, "all", amaplocalweatherlistener);
        return;
    }

    void a(AMapLocation amaplocation, String s, AMapLocalWeatherListener amaplocalweatherlistener)
    {
        b = amaplocalweatherlistener;
        if (amaplocation != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        byte abyte0[];
        String s1;
        AMapLocException amaplocexception;
        abyte0 = a(amaplocation, s);
        s1 = a();
        amaplocexception = new AMapLocException();
        String s3 = l.a().a(d, s1, abyte0, "sea");
        String s2 = s3;
_L4:
        AMapLocException amaplocexception1;
        if ("base".equals(s))
        {
            Message message;
            AMapLocalWeatherLive amaplocalweatherlive;
            Message message1;
            if (s2 != null)
            {
                AMapLocalWeatherLive amaplocalweatherlive1 = a(s2);
                amaplocexception1 = amaplocexception;
                amaplocalweatherlive = amaplocalweatherlive1;
            } else
            {
                amaplocalweatherlive = new AMapLocalWeatherLive();
                amaplocexception1 = new AMapLocException("http\u8FDE\u63A5\u5931\u8D25 - ConnectionException");
            }
            amaplocalweatherlive.a(amaplocexception1);
            amaplocalweatherlive.setCity(amaplocation.getCity());
            amaplocalweatherlive.setCityCode(amaplocation.getCityCode());
            amaplocalweatherlive.setProvince(amaplocation.getProvince());
            message1 = Message.obtain();
            message1.what = 1;
            message1.obj = amaplocalweatherlive;
            a.sendMessage(message1);
        } else
        {
            amaplocexception1 = amaplocexception;
        }
        if ("all".equals(s))
        {
            AMapLocalWeatherForecast amaplocalweatherforecast;
            if (s2 != null)
            {
                amaplocalweatherforecast = a(s2, amaplocation);
            } else
            {
                amaplocalweatherforecast = new AMapLocalWeatherForecast();
                amaplocexception1 = new AMapLocException("http\u8FDE\u63A5\u5931\u8D25 - ConnectionException");
            }
            amaplocalweatherforecast.a(amaplocexception1);
            message = Message.obtain();
            message.what = 2;
            message.obj = amaplocalweatherforecast;
            a.sendMessage(message);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        amaplocexception;
        s2 = null;
          goto _L4
    }

    public void onLocationChanged(Location location)
    {
    }

    public void onLocationChanged(AMapLocation amaplocation)
    {
        if (amaplocation == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        if (amaplocation.getAMapException() != null && amaplocation.getAMapException().getErrorCode() == 0)
        {
            c.a(this);
            Message message = Message.obtain();
            message.what = 3;
            message.obj = amaplocation;
            a.sendMessage(message);
        }
        return;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return;
    }

    public void onProviderDisabled(String s)
    {
    }

    public void onProviderEnabled(String s)
    {
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
    }
}
