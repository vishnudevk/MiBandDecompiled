// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import android.location.Location;
import com.amap.api.location.core.AMapLocException;

public class AMapLocation extends Location
{

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private AMapLocException j;

    public AMapLocation(Location location)
    {
        super(location);
        j = new AMapLocException();
    }

    public AMapLocation(String s)
    {
        super(s);
        j = new AMapLocException();
    }

    void a(String s)
    {
        h = s;
    }

    void b(String s)
    {
        i = s;
    }

    public AMapLocException getAMapException()
    {
        return j;
    }

    public String getAdCode()
    {
        return e;
    }

    public String getAddress()
    {
        return i;
    }

    public String getCity()
    {
        return b;
    }

    public String getCityCode()
    {
        return d;
    }

    public String getDistrict()
    {
        return c;
    }

    public String getFloor()
    {
        return g;
    }

    public String getPoiId()
    {
        return f;
    }

    public String getProvince()
    {
        return a;
    }

    public String getStreet()
    {
        return h;
    }

    public void setAMapException(AMapLocException amaplocexception)
    {
        j = amaplocexception;
    }

    public void setAdCode(String s)
    {
        e = s;
    }

    public void setCity(String s)
    {
        b = s;
    }

    public void setCityCode(String s)
    {
        d = s;
    }

    public void setDistrict(String s)
    {
        c = s;
    }

    public void setFloor(String s)
    {
        g = s;
    }

    public void setPoiId(String s)
    {
        f = s;
    }

    public void setProvince(String s)
    {
        a = s;
    }
}
