// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.Utils;
import org.json.JSONException;
import org.json.JSONObject;

public class UserLocationData
{

    private static final String TAG = "UserLocationData";
    public String city;
    public String latitude;
    public String longitude;

    public UserLocationData()
    {
        city = "";
        longitude = "";
        latitude = "";
    }

    public static UserLocationData fromJsonStr(String s)
    {
        UserLocationData userlocationdata = new UserLocationData();
        try
        {
            JSONObject jsonobject = new JSONObject(Utils.URLDecodeStr(s));
            userlocationdata.city = jsonobject.optString("city");
            userlocationdata.longitude = jsonobject.optString("longitude");
            userlocationdata.latitude = jsonobject.optString("latitude");
        }
        catch (JSONException jsonexception)
        {
            jsonexception.toString();
            return userlocationdata;
        }
        return userlocationdata;
    }

    public boolean isValid()
    {
        return city != null && longitude.length() > 0 && latitude.length() > 0;
    }

    public void setCity(String s)
    {
        city = s;
    }

    public void setLocation(String s, String s1, String s2)
    {
        city = s;
        longitude = s1;
        latitude = s2;
    }

    public String toString()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("city", city);
            jsonobject.put("longitude", longitude);
            jsonobject.put("latitude", latitude);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        return jsonobject.toString();
    }
}
