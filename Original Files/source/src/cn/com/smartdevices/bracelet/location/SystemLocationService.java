// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.Debug;
import java.io.IOException;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.location:
//            LocationService, Location, LocationListener, LocationOption

public class SystemLocationService
    implements LocationListener, LocationService
{

    private static final String a = "SystemLocationService";
    private Context b;
    private LocationManager c;
    private cn.com.smartdevices.bracelet.location.LocationListener d;
    private String e;
    private int f;

    public SystemLocationService(Context context)
    {
        b = context;
        c = (LocationManager)context.getSystemService("location");
        Debug.i("SystemLocationService", (new StringBuilder()).append("Provider : ").append(c.getAllProviders()).toString());
    }

    public void onLocationChanged(Location location)
    {
        Geocoder geocoder;
        Debug.i("SystemLocationService", (new StringBuilder()).append("Time : ").append(location.getTime()).toString());
        Debug.i("SystemLocationService", (new StringBuilder()).append("Latitude : ").append(location.getLatitude()).toString());
        Debug.i("SystemLocationService", (new StringBuilder()).append("Longitude : ").append(location.getLongitude()).toString());
        geocoder = new Geocoder(b);
        List list;
        list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        Debug.i("SystemLocationService", (new StringBuilder()).append("Address : ").append(list).toString());
        if (list == null) goto _L2; else goto _L1
_L1:
        if (list.size() <= 0) goto _L2; else goto _L3
_L3:
        Address address1;
        Location.Address address2;
        address1 = (Address)list.get(0);
        address2 = new Location.Address();
        address2.setCountry(address1.getCountryName());
        address2.setCountryCode(address1.getCountryCode());
        address2.setAdmin(address1.getAdminArea());
        address2.setSubAdmin(address1.getSubAdminArea());
        address2.setLocality(address1.getLocality());
        address2.setSubLocality(address1.getSubLocality());
        address2.setThoroughfare(address1.getThoroughfare());
        Location.Address address = address2;
_L6:
        if (d != null)
        {
            cn.com.smartdevices.bracelet.location.Location location1 = new cn.com.smartdevices.bracelet.location.Location();
            location1.setLatitude(location.getLatitude());
            location1.setLongitude(location.getLongitude());
            if (address != null)
            {
                location1.setAddress(address);
            }
            d.onReceiveLocation(location1);
        }
        return;
        IOException ioexception;
        ioexception;
        IOException ioexception1;
        ioexception1 = ioexception;
        address = null;
_L4:
        ioexception1.printStackTrace();
        continue; /* Loop/switch isn't completed */
        IOException ioexception2;
        ioexception2;
        address = address2;
        ioexception1 = ioexception2;
        if (true) goto _L4; else goto _L2
_L2:
        address = null;
        if (true) goto _L6; else goto _L5
_L5:
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
        if (LocationOption.LocationMode.HighAccuracy == locationoption.getMode())
        {
            e = "gps";
        } else
        {
            if (LocationOption.LocationMode.BatterySave == locationoption.getMode())
            {
                e = "network";
                return;
            }
            if (LocationOption.LocationMode.GpsOnly == locationoption.getMode())
            {
                e = "gps";
                return;
            }
        }
    }

    public void registerLocationListener(cn.com.smartdevices.bracelet.location.LocationListener locationlistener)
    {
        d = locationlistener;
    }

    public void startLocation()
    {
        Debug.i("SystemLocationService", "Start Location!!");
        c.requestLocationUpdates(e, f, 15F, this);
        Debug.i("SystemLocationService", (new StringBuilder()).append("Last Loc : ").append(c.getLastKnownLocation("network")).toString());
    }

    public void stopLocation()
    {
        Debug.i("SystemLocationService", "Stop Location!!");
        c.removeUpdates(this);
    }
}
