// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.location;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.core.AMapLocException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package cn.com.smartdevices.bracelet.location:
//            LocationService, Location, LocationListener, LocationOption

public class AmapLocationService
    implements LocationService, AMapLocationListener
{

    private static final String a = "AmapLocationService";
    private Context b;
    private LocationManagerProxy c;
    private LocationListener d;
    private int e;

    public AmapLocationService(Context context)
    {
        b = context;
        c = LocationManagerProxy.getInstance(context);
    }

    public void onLocationChanged(Location location)
    {
    }

    public void onLocationChanged(AMapLocation amaplocation)
    {
        if (amaplocation != null)
        {
            int i = amaplocation.getAMapException().getErrorCode();
            if (i != 0)
            {
                UmengAnalytics.event(b, "LocationException", (new StringBuilder()).append("Amap_").append(i).toString());
            } else
            {
                Debug.i("AmapLocationService", (new StringBuilder()).append("Location : ").append(amaplocation.getLatitude()).append("  ").append(amaplocation.getLongitude()).toString());
                Debug.i("AmapLocationService", (new StringBuilder()).append("Accuracy : ").append(String.valueOf(amaplocation.getAccuracy())).toString());
                Debug.i("AmapLocationService", (new StringBuilder()).append("Provider : ").append(amaplocation.getProvider()).toString());
                SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(amaplocation.getTime());
                Debug.i("AmapLocationService", (new StringBuilder()).append("Time : ").append(simpledateformat.format(date)).toString());
                Debug.i("AmapLocationService", (new StringBuilder()).append("Address : ").append(amaplocation.getAddress()).toString());
                Debug.i("AmapLocationService", (new StringBuilder()).append("Addr Province : ").append(amaplocation.getProvince()).toString());
                Debug.i("AmapLocationService", (new StringBuilder()).append("Addr City : ").append(amaplocation.getCity()).toString());
                Debug.i("AmapLocationService", (new StringBuilder()).append("Addr CityCode : ").append(amaplocation.getCityCode()).toString());
                Debug.i("AmapLocationService", (new StringBuilder()).append("Addr District : ").append(amaplocation.getDistrict()).toString());
                Debug.i("AmapLocationService", (new StringBuilder()).append("Addr Stress : ").append(amaplocation.getStreet()).toString());
                Debug.i("AmapLocationService", (new StringBuilder()).append("Addr AddrCode : ").append(amaplocation.getAdCode()).toString());
                if (d != null)
                {
                    cn.com.smartdevices.bracelet.location.Location location = new cn.com.smartdevices.bracelet.location.Location();
                    location.setLatitude(amaplocation.getLatitude());
                    location.setLongitude(amaplocation.getLongitude());
                    Location.Address address = new Location.Address();
                    address.setAdmin(amaplocation.getProvince());
                    address.setLocality(amaplocation.getCity());
                    address.setSubLocality(amaplocation.getDistrict());
                    address.setThoroughfare(amaplocation.getStreet());
                    location.setAddress(address);
                    d.onReceiveLocation(location);
                    return;
                }
            }
        }
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

    public void optionLocationService(LocationOption locationoption)
    {
        if (LocationOption.LocationMode.HighAccuracy != locationoption.getMode()) goto _L2; else goto _L1
_L1:
        c.setGpsEnable(true);
_L4:
        e = locationoption.getUpdateInterval();
        return;
_L2:
        if (LocationOption.LocationMode.BatterySave == locationoption.getMode())
        {
            c.setGpsEnable(false);
        } else
        if (LocationOption.LocationMode.GpsOnly == locationoption.getMode())
        {
            c.setGpsEnable(true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void registerLocationListener(LocationListener locationlistener)
    {
        d = locationlistener;
    }

    public void startLocation()
    {
        Debug.i("AmapLocationService", "Start Location!!");
        c.requestLocationData("lbs", e, 15F, this);
    }

    public void stopLocation()
    {
        Debug.i("AmapLocationService", "Stop Location!!");
        c.removeUpdates(this);
        c.destroy();
    }
}
