// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amap.api.location.AMapLocation;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amap.api.location.core:
//            AMapLocException

public class d
{

    static int a = 2048;

    public d()
    {
    }

    public static void a(Context context, AMapLocation amaplocation)
    {
        try
        {
            android.content.SharedPreferences.Editor editor = context.getSharedPreferences("last_know_location", 0).edit();
            editor.putString("last_know_lat", String.valueOf(amaplocation.getLatitude()));
            editor.putString("last_know_lng", String.valueOf(amaplocation.getLongitude()));
            editor.putString("province", amaplocation.getProvince());
            editor.putString("city", amaplocation.getCity());
            editor.putString("district", amaplocation.getDistrict());
            editor.putString("cityCode", amaplocation.getCityCode());
            editor.putString("adCode", amaplocation.getAdCode());
            editor.putFloat("accuracy", amaplocation.getAccuracy());
            editor.putLong("time", amaplocation.getTime());
            editor.commit();
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public static void a(String s)
    {
        JSONObject jsonobject;
        String s1;
        String s2;
        try
        {
            jsonobject = new JSONObject(s);
            if (!jsonobject.has("status"))
            {
                break MISSING_BLOCK_LABEL_171;
            }
            if (!jsonobject.has("info"))
            {
                return;
            }
        }
        catch (JSONException jsonexception)
        {
            return;
        }
        s1 = jsonobject.getString("status");
        s2 = jsonobject.getString("info");
        if (!s1.equals("1") && s1.equals("0"))
        {
            if (s2.equals("INVALID_USER_KEY") || s2.equals("INSUFFICIENT_PRIVILEGES") || s2.equals("USERKEY_PLAT_NOMATCH"))
            {
                throw new AMapLocException("key\u9274\u6743\u5931\u8D25");
            }
            if (s2.equals("SERVICE_NOT_EXIST") || s2.equals("SERVICE_RESPONSE_ERROR") || s2.equals("OVER_QUOTA") || s2.equals("UNKNOWN_ERROR"))
            {
                throw new AMapLocException("\u672A\u77E5\u7684\u9519\u8BEF");
            }
            if (s2.equals("INVALID_PARAMS"))
            {
                throw new AMapLocException("\u65E0\u6548\u7684\u53C2\u6570 - IllegalArgumentException");
            }
        }
    }

    public static boolean a(Context context)
    {
        if (context == null)
        {
            return false;
        }
        ConnectivityManager connectivitymanager;
        NetworkInfo networkinfo;
        android.net.NetworkInfo.State state;
        android.net.NetworkInfo.State state1;
        try
        {
            connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return false;
        }
        if (connectivitymanager == null)
        {
            return false;
        }
        networkinfo = connectivitymanager.getActiveNetworkInfo();
        if (networkinfo == null)
        {
            return false;
        }
        state = networkinfo.getState();
        if (state == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (state == android.net.NetworkInfo.State.DISCONNECTED)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        state1 = android.net.NetworkInfo.State.DISCONNECTING;
        if (state != state1)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        return false;
        return true;
    }

    public static AMapLocation b(Context context)
    {
        AMapLocation amaplocation;
        try
        {
            SharedPreferences sharedpreferences = context.getSharedPreferences("last_know_location", 0);
            amaplocation = new AMapLocation("");
            amaplocation.setProvider("lbs");
            double d1 = Double.parseDouble(sharedpreferences.getString("last_know_lat", "0.0"));
            double d2 = Double.parseDouble(sharedpreferences.getString("last_know_lng", "0.0"));
            amaplocation.setLatitude(d1);
            amaplocation.setLongitude(d2);
            amaplocation.setProvince(sharedpreferences.getString("province", ""));
            amaplocation.setCity(sharedpreferences.getString("city", ""));
            amaplocation.setDistrict(sharedpreferences.getString("district", ""));
            amaplocation.setCityCode(sharedpreferences.getString("cityCode", ""));
            amaplocation.setAdCode(sharedpreferences.getString("adCode", ""));
            amaplocation.setAccuracy(sharedpreferences.getFloat("accuracy", 0.0F));
            amaplocation.setTime(sharedpreferences.getLong("time", 0L));
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return null;
        }
        return amaplocation;
    }

}
