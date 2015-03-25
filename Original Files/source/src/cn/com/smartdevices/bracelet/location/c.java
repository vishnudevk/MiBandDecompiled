// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.location;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.location:
//            LocationListener, LocationManager, Location

class c
    implements LocationListener
{

    final LocationManager a;

    c(LocationManager locationmanager)
    {
        a = locationmanager;
        super();
    }

    public void onReceiveLocation(Location location)
    {
        Debug.i("LocationManager", (new StringBuilder()).append("Location Received : ").append(location).toString());
        Intent intent = new Intent("com.xiaomi.hm.health.LocationReceived");
        intent.putExtra("Location", location);
        LocalBroadcastManager.getInstance(LocationManager.a(a)).sendBroadcast(intent);
    }
}
