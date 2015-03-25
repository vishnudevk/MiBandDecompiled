// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.text.SimpleDateFormat;

// Referenced classes of package com.aps:
//            y, aw, av

final class G
    implements LocationListener
{

    private y a;

    G(y y1)
    {
        a = y1;
        super();
    }

    private static boolean a(Location location)
    {
        return location != null && "gps".equalsIgnoreCase(location.getProvider()) && location.getLatitude() > -90D && location.getLatitude() < 90D && location.getLongitude() > -180D && location.getLongitude() < 180D;
    }

    public final void onLocationChanged(Location location)
    {
        long l;
        long l1;
        try
        {
            l = location.getTime();
            l1 = System.currentTimeMillis();
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpledateformat.format(Long.valueOf(l));
            simpledateformat.format(Long.valueOf(l1));
        }
        catch (Exception exception)
        {
            return;
        }
        if (l > 0L)
        {
            l1 = l;
        }
        if (location == null)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        if (!a(location))
        {
            return;
        }
        if (location.getSpeed() <= (float)y.g()) goto _L2; else goto _L1
_L1:
        aw.a(y.h());
        aw.b(10 * y.h());
_L3:
        y.b(a).a();
        a(location);
        if (!y.b(a).a() || !a(location))
        {
            break MISSING_BLOCK_LABEL_237;
        }
        location.setTime(System.currentTimeMillis());
        y.a(a, System.currentTimeMillis());
        y.a(a, location);
        if (!y.c(a))
        {
            y.a(a, location, 0, l1);
            return;
        }
        break MISSING_BLOCK_LABEL_221;
_L2:
label0:
        {
            if (location.getSpeed() <= (float)y.i())
            {
                break label0;
            }
            aw.a(y.j());
            aw.b(10 * y.j());
        }
          goto _L3
        aw.a(y.k());
        aw.b(10 * y.k());
          goto _L3
        y.a(a, "new location in indoor collect");
        return;
    }

    public final void onProviderDisabled(String s)
    {
    }

    public final void onProviderEnabled(String s)
    {
    }

    public final void onStatusChanged(String s, int i, Bundle bundle)
    {
    }
}
