// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;

// Referenced classes of package com.amap.api.location:
//            AMapLocationListener, LocationManagerProxy, AMapLocation

public class f
    implements AMapLocationListener
{

    private LocationManagerProxy a;
    private AMapLocationListener b;

    public f(LocationManagerProxy locationmanagerproxy)
    {
        b = null;
        a = locationmanagerproxy;
    }

    public void a()
    {
        if (a != null)
        {
            a.removeUpdates(this);
        }
        b = null;
    }

    public boolean a(AMapLocationListener amaplocationlistener, long l, float f1, String s)
    {
        b = amaplocationlistener;
        boolean flag = "lbs".equals(s);
        boolean flag1 = false;
        if (flag)
        {
            a.requestLocationUpdates(s, l, f1, this);
            flag1 = true;
        }
        return flag1;
    }

    public void onLocationChanged(Location location)
    {
        if (b != null)
        {
            b.onLocationChanged(location);
        }
    }

    public void onLocationChanged(AMapLocation amaplocation)
    {
        if (b != null)
        {
            b.onLocationChanged(amaplocation);
        }
    }

    public void onProviderDisabled(String s)
    {
        if (b != null)
        {
            b.onProviderDisabled(s);
        }
    }

    public void onProviderEnabled(String s)
    {
        if (b != null)
        {
            b.onProviderEnabled(s);
        }
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
        if (b != null)
        {
            b.onStatusChanged(s, i, bundle);
        }
    }
}
