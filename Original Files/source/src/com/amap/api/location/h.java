// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import android.app.PendingIntent;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.amap.api.location:
//            AMapLocationListener, LocationManagerProxy, AMapLocation

class h
    implements AMapLocationListener
{

    final LocationManagerProxy a;

    h(LocationManagerProxy locationmanagerproxy)
    {
        a = locationmanagerproxy;
        super();
    }

    public void onLocationChanged(Location location)
    {
        Iterator iterator;
        if (LocationManagerProxy.a(a) == null || LocationManagerProxy.a(a).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        iterator = LocationManagerProxy.a(a).iterator();
_L1:
        PendingIntent pendingintent;
        Intent intent;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_121;
        }
        pendingintent = (PendingIntent)iterator.next();
        intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("location", location);
        intent.putExtras(bundle);
        pendingintent.send(LocationManagerProxy.b(a), 0, intent);
          goto _L1
        android.app.PendingIntent.CanceledException canceledexception;
        canceledexception;
        canceledexception.printStackTrace();
          goto _L1
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
    }

    public void onLocationChanged(AMapLocation amaplocation)
    {
        Iterator iterator;
        if (LocationManagerProxy.a(a) == null || LocationManagerProxy.a(a).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        iterator = LocationManagerProxy.a(a).iterator();
_L1:
        PendingIntent pendingintent;
        Intent intent;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_121;
        }
        pendingintent = (PendingIntent)iterator.next();
        intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("location", amaplocation);
        intent.putExtras(bundle);
        pendingintent.send(LocationManagerProxy.b(a), 0, intent);
          goto _L1
        android.app.PendingIntent.CanceledException canceledexception;
        canceledexception;
        canceledexception.printStackTrace();
          goto _L1
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
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
