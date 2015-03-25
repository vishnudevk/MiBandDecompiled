// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.location.core.c;
import com.aps.k;
import com.aps.u;

// Referenced classes of package com.amap.api.location:
//            d, a, AMapLocation, j, 
//            c

class m
    implements LocationListener
{

    final d a;

    m(d d1)
    {
        a = d1;
        super();
    }

    public void onLocationChanged(Location location)
    {
        Object obj;
        Exception exception1;
        AMapLocation amaplocation;
        Message message1;
        Message message2;
        double ad[];
        try
        {
            d.a(a).b(true);
            d.a(a).d = System.currentTimeMillis();
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return;
        }
        obj = null;
        if (d.b(a) == null || !d.b(a).a(com.amap.api.location.d.c(a))) goto _L2; else goto _L1
_L1:
        ad = u.a(location.getLongitude(), location.getLatitude());
        amaplocation = new AMapLocation(location);
        amaplocation.setLatitude(ad[1]);
        amaplocation.setLongitude(ad[0]);
_L3:
        message2 = new Message();
        message2.obj = amaplocation;
        message2.what = 100;
        if (d.d(a) != null)
        {
            d.d(a).sendMessage(message2);
        }
        d.a(a).c = true;
        d.a(a).d = System.currentTimeMillis();
        if (d.a(a).b != null && d.a(a).b.a != null)
        {
            d.a(a).b.a.a(amaplocation);
        }
_L5:
        return;
_L2:
        amaplocation = new AMapLocation(location);
          goto _L3
        exception1;
        amaplocation = null;
_L8:
        exception1.printStackTrace();
        message1 = new Message();
        message1.obj = amaplocation;
        message1.what = 100;
        if (d.d(a) != null)
        {
            d.d(a).sendMessage(message1);
        }
        d.a(a).c = true;
        d.a(a).d = System.currentTimeMillis();
        if (d.a(a).b == null || d.a(a).b.a == null) goto _L5; else goto _L4
_L4:
        d.a(a).b.a.a(amaplocation);
        return;
        Exception exception;
        exception;
_L7:
        Message message = new Message();
        message.obj = obj;
        message.what = 100;
        if (d.d(a) != null)
        {
            d.d(a).sendMessage(message);
        }
        d.a(a).c = true;
        d.a(a).d = System.currentTimeMillis();
        if (d.a(a).b != null && d.a(a).b.a != null)
        {
            d.a(a).b.a.a(((AMapLocation) (obj)));
        }
        throw exception;
        exception;
        obj = amaplocation;
        if (true) goto _L7; else goto _L6
_L6:
        exception1;
          goto _L8
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
