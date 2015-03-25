// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.Vector;

// Referenced classes of package com.amap.api.location:
//            AMapLocationListener, AMapLocation, LocationManagerProxy, g

class e
    implements AMapLocationListener
{

    final LocationManagerProxy a;

    e(LocationManagerProxy locationmanagerproxy)
    {
        a = locationmanagerproxy;
        super();
    }

    public void onLocationChanged(Location location)
    {
        int k;
        if (location == null)
        {
            break MISSING_BLOCK_LABEL_509;
        }
        int j;
        g g1;
        AMapLocation amaplocation;
        Vector vector;
        int l;
        g g2;
        try
        {
            amaplocation = new AMapLocation(location);
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return;
        }
        k = 0;
_L12:
        if (LocationManagerProxy.c(a) == null || k >= LocationManagerProxy.c(a).size()) goto _L2; else goto _L1
_L1:
        g2 = (g)LocationManagerProxy.c(a).get(k);
        if (g2 == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        if (g2.b != null)
        {
            g2.b.onLocationChanged(amaplocation);
        }
        if (g2 == null) goto _L4; else goto _L3
_L3:
        if (g2.a == -1L && LocationManagerProxy.d(a) != null)
        {
            LocationManagerProxy.d(a).add(g2);
        }
          goto _L4
_L2:
        if (LocationManagerProxy.d(a) == null || LocationManagerProxy.d(a).size() <= 0) goto _L6; else goto _L5
_L5:
        vector = LocationManagerProxy.c(a);
        l = 0;
        if (vector == null) goto _L6; else goto _L7
_L7:
        if (l >= LocationManagerProxy.d(a).size())
        {
            break; /* Loop/switch isn't completed */
        }
        LocationManagerProxy.c(a).remove(LocationManagerProxy.d(a).get(l));
        l++;
        if (true) goto _L7; else goto _L8
_L8:
        LocationManagerProxy.d(a).clear();
        if (LocationManagerProxy.c(a).size() == 0 && LocationManagerProxy.e(a) != null && LocationManagerProxy.f(a) != null)
        {
            LocationManagerProxy.e(a).removeUpdates(LocationManagerProxy.f(a));
            return;
        }
          goto _L6
_L13:
        int i;
        for (; LocationManagerProxy.c(a) == null || i >= LocationManagerProxy.c(a).size(); i++)
        {
            break MISSING_BLOCK_LABEL_355;
        }

        g1 = (g)LocationManagerProxy.c(a).get(i);
        if (g1 == null)
        {
            break MISSING_BLOCK_LABEL_514;
        }
        if (g1.a == -1L && LocationManagerProxy.d(a) != null)
        {
            LocationManagerProxy.d(a).add(g1);
        }
        break MISSING_BLOCK_LABEL_514;
        if (LocationManagerProxy.d(a) == null || LocationManagerProxy.d(a).size() <= 0 || LocationManagerProxy.c(a) == null) goto _L6; else goto _L9
_L9:
        j = 0;
_L11:
        if (j >= LocationManagerProxy.d(a).size())
        {
            break; /* Loop/switch isn't completed */
        }
        LocationManagerProxy.c(a).remove(LocationManagerProxy.d(a).get(j));
        j++;
        if (true) goto _L11; else goto _L10
_L10:
        LocationManagerProxy.d(a).clear();
        if (LocationManagerProxy.c(a).size() == 0 && LocationManagerProxy.e(a) != null && LocationManagerProxy.f(a) != null)
        {
            LocationManagerProxy.e(a).removeUpdates(LocationManagerProxy.f(a));
            return;
        }
          goto _L6
_L4:
        k++;
          goto _L12
_L6:
        return;
        i = 0;
          goto _L13
    }

    public void onLocationChanged(AMapLocation amaplocation)
    {
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
