// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.location;

import android.content.Context;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;

// Referenced classes of package cn.com.smartdevices.bracelet.location:
//            LocationOption, c, LocationService, SystemLocationService, 
//            AmapLocationService, LocationListener

public class LocationManager
{

    public static final String ACTION_LOCATION_RECEIVED = "com.xiaomi.hm.health.LocationReceived";
    public static final String KEY_LOCATION = "Location";
    public static final String SERVICE_AMAP = "ServiceAmap";
    public static final String SERVICE_BAIDU = "ServiceBaidu";
    public static final String SERVICE_SYSTEM = "ServiceSystem";
    private static final String a = "LocationManager";
    private static final int b = 0x1b7740;
    private static LocationManager c;
    private Context d;
    private LocationService e;
    private LocationOption f;
    private LocationListener g;

    private LocationManager(Context context)
    {
        d = context;
        f = new LocationOption();
        f.setMode(LocationOption.LocationMode.BatterySave);
        f.setNeedAddress(false);
        f.setUpdateInterval(0x1b7740);
        g = new c(this);
    }

    static Context a(LocationManager locationmanager)
    {
        return locationmanager.d;
    }

    public static LocationManager getManager()
    {
        return c;
    }

    public static LocationManager getManager(Context context)
    {
        if (c == null)
        {
            c = new LocationManager(context);
        }
        return c;
    }

    public void cancelLocation()
    {
        if (e != null)
        {
            e.stopLocation();
        }
    }

    public LocationService getService()
    {
        return e;
    }

    public LocationService getService(String s)
    {
        if (e != null)
        {
            e.stopLocation();
        }
        Debug.i("LocationManager", (new StringBuilder()).append("Get Location Service : ").append(s).toString());
        if (!"ServiceSystem".equals(s)) goto _L2; else goto _L1
_L1:
        e = new SystemLocationService(d);
_L4:
        e.optionLocationService(f);
        if (g != null)
        {
            e.registerLocationListener(g);
        }
        return e;
_L2:
        if ("ServiceAmap".equals(s))
        {
            e = new AmapLocationService(d);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void registerLocationListener(LocationListener locationlistener)
    {
        g = locationlistener;
    }

    public void requestLocation()
    {
        if (e != null)
        {
            UmengAnalytics.event(d, "LocationStart");
            e.startLocation();
        }
    }

    public void requestLocation(String s)
    {
        getService(s);
        requestLocation();
    }
}
