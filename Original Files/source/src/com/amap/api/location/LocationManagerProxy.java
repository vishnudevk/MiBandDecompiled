// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Criteria;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import com.amap.api.location.core.c;
import com.amap.api.location.core.d;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.amap.api.location:
//            e, a, g, LocationProviderProxy, 
//            AMapLocation, f, h, AMapLocationListener, 
//            AMapLocalWeatherListener

public class LocationManagerProxy
{

    public static final String GPS_PROVIDER = "gps";
    public static final String KEY_LOCATION_CHANGED = "location";
    public static final String KEY_PROVIDER_ENABLED = "providerEnabled";
    public static final String KEY_PROXIMITY_ENTERING = "entering";
    public static final String KEY_STATUS_CHANGED = "status";
    public static final String NETWORK_PROVIDER = "network";
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;
    private static LocationManagerProxy b = null;
    private LocationManager a;
    private a c;
    private Context d;
    private f e;
    private h f;
    private ArrayList g;
    private Hashtable h;
    private Vector i;
    private Vector j;
    private e k;
    private c l;
    private String m;

    private LocationManagerProxy(Activity activity)
    {
        a = null;
        c = null;
        g = new ArrayList();
        h = new Hashtable();
        i = new Vector();
        j = new Vector();
        k = new e(this);
        a(activity.getApplicationContext());
    }

    private LocationManagerProxy(Context context)
    {
        a = null;
        c = null;
        g = new ArrayList();
        h = new Hashtable();
        i = new Vector();
        j = new Vector();
        k = new e(this);
        a(context);
    }

    static ArrayList a(LocationManagerProxy locationmanagerproxy)
    {
        return locationmanagerproxy.g;
    }

    private static void a()
    {
        b = null;
    }

    private void a(Context context)
    {
        try
        {
            d = context;
            l = com.amap.api.location.core.c.a(context);
            a = (LocationManager)context.getSystemService("location");
            c = new a(context.getApplicationContext(), a);
            m = l.c(context);
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    private void a(String s, long l1, float f1, AMapLocationListener amaplocationlistener, boolean flag)
    {
_L2:
        if (!l.a(m) && "lbs".equals(s1))
        {
            s1 = "network";
        }
        if ("lbs".equals(s1) && l.a(m))
        {
            c.a(l1, f1, amaplocationlistener, "lbs", flag);
            return;
        }
        if ("gps".equals(s1))
        {
            c.a(l1, f1, amaplocationlistener, "gps", flag);
            return;
        }
        g g1 = new g(l1, f1, amaplocationlistener, s1, false);
        i.add(g1);
        a.requestLocationUpdates(s1, l1, f1, k);
        return;
        String s1;
        try
        {
            if (c == null)
            {
                c = new a(d.getApplicationContext(), a);
            }
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return;
        }
        while (s != null) 
        {
            s1 = s;
            continue; /* Loop/switch isn't completed */
        }
        s1 = "lbs";
        if (true) goto _L2; else goto _L1
_L1:
    }

    static Context b(LocationManagerProxy locationmanagerproxy)
    {
        return locationmanagerproxy.d;
    }

    static Vector c(LocationManagerProxy locationmanagerproxy)
    {
        return locationmanagerproxy.i;
    }

    static Vector d(LocationManagerProxy locationmanagerproxy)
    {
        return locationmanagerproxy.j;
    }

    static LocationManager e(LocationManagerProxy locationmanagerproxy)
    {
        return locationmanagerproxy.a;
    }

    static e f(LocationManagerProxy locationmanagerproxy)
    {
        return locationmanagerproxy.k;
    }

    public static LocationManagerProxy getInstance(Activity activity)
    {
        com/amap/api/location/LocationManagerProxy;
        JVM INSTR monitorenter ;
        LocationManagerProxy locationmanagerproxy;
        if (b == null)
        {
            b = new LocationManagerProxy(activity);
        }
        locationmanagerproxy = b;
_L2:
        com/amap/api/location/LocationManagerProxy;
        JVM INSTR monitorexit ;
        return locationmanagerproxy;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        locationmanagerproxy = null;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public static LocationManagerProxy getInstance(Context context)
    {
        com/amap/api/location/LocationManagerProxy;
        JVM INSTR monitorenter ;
        LocationManagerProxy locationmanagerproxy;
        if (b == null)
        {
            b = new LocationManagerProxy(context);
        }
        locationmanagerproxy = b;
_L2:
        com/amap/api/location/LocationManagerProxy;
        JVM INSTR monitorexit ;
        return locationmanagerproxy;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        locationmanagerproxy = null;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public void addGeoFenceAlert(double d1, double d2, float f1, long l1, 
            PendingIntent pendingintent)
    {
        try
        {
            if (c != null)
            {
                c.b(d1, d2, f1, l1, pendingintent);
            }
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public boolean addGpsStatusListener(android.location.GpsStatus.Listener listener)
    {
        boolean flag;
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        flag = a.addGpsStatusListener(listener);
        return flag;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return false;
    }

    public void addProximityAlert(double d1, double d2, float f1, long l1, 
            PendingIntent pendingintent)
    {
        try
        {
            if (c.f)
            {
                a.addProximityAlert(d1, d2, f1, l1, pendingintent);
            }
            c.a(d1, d2, f1, l1, pendingintent);
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void addTestProvider(String s, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, 
            boolean flag6, int i1, int j1)
    {
        try
        {
            if (a != null)
            {
                a.addTestProvider(s, flag, flag1, flag2, flag3, flag4, flag5, flag6, i1, j1);
            }
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void clearTestProviderEnabled(String s)
    {
        try
        {
            if (a != null)
            {
                a.clearTestProviderEnabled(s);
            }
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void clearTestProviderLocation(String s)
    {
        try
        {
            if (a != null)
            {
                a.clearTestProviderLocation(s);
            }
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void clearTestProviderStatus(String s)
    {
        try
        {
            if (a != null)
            {
                a.clearTestProviderStatus(s);
            }
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void destory()
    {
        try
        {
            destroy();
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void destroy()
    {
        if (c != null)
        {
            c.b();
        }
        if (h != null)
        {
            h.clear();
        }
        if (i != null)
        {
            i.clear();
        }
        if (a == null) goto _L2; else goto _L1
_L1:
        if (k != null)
        {
            a.removeUpdates(k);
        }
        if (g == null) goto _L2; else goto _L3
_L3:
        int i1 = 0;
_L8:
        if (i1 >= g.size()) goto _L2; else goto _L4
_L4:
        PendingIntent pendingintent = (PendingIntent)g.get(i1);
        if (pendingintent == null) goto _L6; else goto _L5
_L5:
        a.removeUpdates(pendingintent);
          goto _L6
_L2:
        try
        {
            if (g != null)
            {
                g.clear();
            }
            c = null;
            a();
            k = null;
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
        return;
_L6:
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public List getAllProviders()
    {
        List list = a.getAllProviders();
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        if (list.contains("lbs"))
        {
            break MISSING_BLOCK_LABEL_78;
        }
        list.add("lbs");
        return list;
        ArrayList arraylist;
        arraylist = new ArrayList();
        arraylist.add("lbs");
        arraylist.addAll(a.getAllProviders());
        return arraylist;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        list = null;
        return list;
    }

    public String getBestProvider(Criteria criteria, boolean flag)
    {
        String s;
        s = "lbs";
        if (criteria == null)
        {
            return s;
        }
        if (!getProvider("lbs").meetsCriteria(criteria))
        {
            s = a.getBestProvider(criteria, flag);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        String s1;
        if (com.amap.api.location.core.d.a(d))
        {
            break MISSING_BLOCK_LABEL_70;
        }
        s1 = a.getBestProvider(criteria, flag);
        return s1;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        s = "gps";
        return s;
    }

    public GpsStatus getGpsStatus(GpsStatus gpsstatus)
    {
        LocationManager locationmanager;
        GpsStatus gpsstatus1;
        GpsStatus gpsstatus2;
        try
        {
            locationmanager = a;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return null;
        }
        gpsstatus1 = null;
        if (locationmanager == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        gpsstatus2 = a.getGpsStatus(gpsstatus);
        gpsstatus1 = gpsstatus2;
        return gpsstatus1;
    }

    public AMapLocation getLastKnownLocation(String s)
    {
        if (c == null)
        {
            return null;
        }
        Location location;
        if ("lbs".equals(s) && l.a(m))
        {
            return c.a();
        }
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        location = a.getLastKnownLocation(s);
        if (location == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        AMapLocation amaplocation = new AMapLocation(location);
        return amaplocation;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return null;
    }

    public LocationProviderProxy getProvider(String s)
    {
        if (s == null)
        {
            try
            {
                throw new IllegalArgumentException("name\u4E0D\u80FD\u4E3A\u7A7A\uFF01");
            }
            catch (Throwable throwable)
            {
                throwable.printStackTrace();
            }
            return null;
        }
        LocationProviderProxy locationproviderproxy;
        if (h.containsKey(s))
        {
            return (LocationProviderProxy)h.get(s);
        }
        locationproviderproxy = LocationProviderProxy.a(a, s);
        h.put(s, locationproviderproxy);
        return locationproviderproxy;
    }

    public List getProviders(Criteria criteria, boolean flag)
    {
        Object obj;
        try
        {
            obj = a.getProviders(criteria, flag);
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        if (((List) (obj)).size() != 0)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        obj = new ArrayList();
        if ("lbs".equals(getBestProvider(criteria, flag)))
        {
            ((List) (obj)).add("lbs");
        }
        return ((List) (obj));
    }

    public List getProviders(boolean flag)
    {
        Object obj;
        try
        {
            obj = a.getProviders(flag);
            if (!isProviderEnabled("lbs"))
            {
                break MISSING_BLOCK_LABEL_48;
            }
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (((List) (obj)).size() != 0)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        obj = new ArrayList();
        ((List) (obj)).add("lbs");
        return ((List) (obj));
    }

    public String getVersion()
    {
        return "V1.2.0";
    }

    public boolean isProviderEnabled(String s)
    {
        boolean flag;
        try
        {
            if ("lbs".equals(s))
            {
                return com.amap.api.location.core.d.a(d);
            }
            flag = a.isProviderEnabled(s);
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return false;
        }
        return flag;
    }

    public void removeGeoFenceAlert(PendingIntent pendingintent)
    {
        try
        {
            if (c != null)
            {
                c.b(pendingintent);
            }
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void removeGpsStatusListener(android.location.GpsStatus.Listener listener)
    {
        try
        {
            if (a != null)
            {
                a.removeGpsStatusListener(listener);
            }
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void removeProximityAlert(PendingIntent pendingintent)
    {
        try
        {
            if (c != null && c.f && a != null)
            {
                a.removeProximityAlert(pendingintent);
            }
            if (c != null)
            {
                c.a(pendingintent);
            }
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void removeUpdates(PendingIntent pendingintent)
    {
        try
        {
            if (e != null)
            {
                g.remove(pendingintent);
                if (g.size() == 0)
                {
                    e.a();
                }
            }
            e = null;
            a.removeUpdates(pendingintent);
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void removeUpdates(AMapLocationListener amaplocationlistener)
    {
        if (amaplocationlistener == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        if (c != null)
        {
            c.a(amaplocationlistener);
        }
        a.removeUpdates(amaplocationlistener);
        if (i == null || i.size() <= 0) goto _L2; else goto _L1
_L1:
        int i1 = i.size();
        int j1 = 0;
_L9:
        if (j1 >= i1) goto _L4; else goto _L3
_L3:
        g g1 = (g)i.get(j1);
        if (!amaplocationlistener.equals(g1.b)) goto _L6; else goto _L5
_L5:
        i.remove(g1);
        int k1;
        int l1;
        int j2 = i1 - 1;
        k1 = j1 - 1;
        l1 = j2;
          goto _L7
_L4:
        if (i.size() == 0 && k != null)
        {
            a.removeUpdates(k);
        }
_L2:
        return;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return;
_L6:
        k1 = j1;
        l1 = i1;
_L7:
        int i2 = k1 + 1;
        i1 = l1;
        j1 = i2;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void requestLocationData(String s, long l1, float f1, AMapLocationListener amaplocationlistener)
    {
        a(s, l1, f1, amaplocationlistener, true);
    }

    public void requestLocationUpdates(String s, long l1, float f1, PendingIntent pendingintent)
    {
        if ("lbs".equals(s) && l.a(m))
        {
            if (e == null)
            {
                e = new f(this);
            }
            if (f == null)
            {
                f = new h(this);
            }
            e.a(f, l1, f1, s);
            g.add(pendingintent);
            return;
        }
        try
        {
            g.add(pendingintent);
            a.requestLocationUpdates(s, l1, f1, pendingintent);
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
        return;
    }

    public void requestLocationUpdates(String s, long l1, float f1, AMapLocationListener amaplocationlistener)
    {
        a(s, l1, f1, amaplocationlistener, false);
    }

    public void requestWeatherUpdates(int i1, AMapLocalWeatherListener amaplocalweatherlistener)
    {
        try
        {
            c.a(i1, amaplocalweatherlistener);
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void setGpsEnable(boolean flag)
    {
        try
        {
            if (c != null)
            {
                c.a(flag);
            }
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void setTestProviderEnabled(String s, boolean flag)
    {
        try
        {
            if (a != null)
            {
                a.setTestProviderEnabled(s, flag);
            }
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void setTestProviderLocation(String s, Location location)
    {
        try
        {
            if (a != null)
            {
                a.setTestProviderLocation(s, location);
            }
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void setTestProviderStatus(String s, int i1, Bundle bundle, long l1)
    {
        try
        {
            if (a != null)
            {
                a.setTestProviderStatus(s, i1, bundle, l1);
            }
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

}
