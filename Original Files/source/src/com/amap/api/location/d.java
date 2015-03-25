// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import com.amap.api.location.core.c;

// Referenced classes of package com.amap.api.location:
//            m, j, a

public class d
{

    public LocationManager a;
    LocationListener b;
    private j c;
    private c d;
    private String e;
    private a f;
    private Context g;

    d(Context context, LocationManager locationmanager, j j, a a1)
    {
        a = null;
        b = new m(this);
        g = context;
        a = locationmanager;
        f = a1;
        c = j;
        d = com.amap.api.location.core.c.a(context);
        e = d.c(context);
    }

    static a a(d d1)
    {
        return d1.f;
    }

    static c b(d d1)
    {
        return d1.d;
    }

    static String c(d d1)
    {
        return d1.e;
    }

    static j d(d d1)
    {
        return d1.c;
    }

    void a()
    {
    }

    void a(long l, float f1)
    {
        try
        {
            Looper looper = g.getMainLooper();
            if (Looper.myLooper() == null)
            {
                Looper.prepare();
            }
            a.requestLocationUpdates("gps", l, f1, b, looper);
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    void b()
    {
        if (b != null)
        {
            a.removeUpdates(b);
        }
    }
}
