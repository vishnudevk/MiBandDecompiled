// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.LocationManager;
import android.os.Looper;
import com.amap.api.location.core.d;
import com.aps.j;
import java.util.Vector;

// Referenced classes of package com.amap.api.location:
//            j, d, c, b, 
//            i, g, AMapLocation, AMapLocalWeatherListener, 
//            AMapLocationListener

public class a
{

    com.amap.api.location.d a;
    c b;
    boolean c;
    long d;
    boolean e;
    boolean f;
    b g;
    private Context h;
    private Vector i;
    private com.amap.api.location.j j;
    private Vector k;
    private AMapLocation l;
    private AMapLocation m;
    private Thread n;
    private long o;
    private float p;

    a(Context context, LocationManager locationmanager)
    {
        i = null;
        j = null;
        k = new Vector();
        a = null;
        b = null;
        c = false;
        e = true;
        f = true;
        o = 2000L;
        p = 10F;
        h = context;
        c();
        if (Looper.myLooper() == null)
        {
            j = new com.amap.api.location.j(this, context.getMainLooper());
        } else
        {
            j = new com.amap.api.location.j(this);
        }
        a = new com.amap.api.location.d(context, locationmanager, j, this);
        b = new c(context, j, this);
        b(false);
        e = true;
        f = true;
        g = new b(this, context);
    }

    static AMapLocation a(a a1, AMapLocation amaplocation)
    {
        a1.l = amaplocation;
        return amaplocation;
    }

    static Vector a(a a1)
    {
        return a1.i;
    }

    static AMapLocation b(a a1)
    {
        return a1.l;
    }

    static AMapLocation b(a a1, AMapLocation amaplocation)
    {
        a1.m = amaplocation;
        return amaplocation;
    }

    static Vector c(a a1)
    {
        return a1.k;
    }

    private void c()
    {
        i = new Vector();
    }

    private void c(boolean flag)
    {
        e = flag;
    }

    static Context d(a a1)
    {
        return a1.h;
    }

    private void d(boolean flag)
    {
        f = flag;
    }

    static AMapLocation e(a a1)
    {
        return a1.m;
    }

    AMapLocation a()
    {
        if (l != null)
        {
            return l;
        } else
        {
            return com.amap.api.location.core.d.b(h);
        }
    }

    void a(double d1, double d2, float f1, long l1, 
            PendingIntent pendingintent)
    {
        j j1 = new j();
        j1.b = d1;
        j1.a = d2;
        j1.c = f1;
        j1.a(l1);
        b.a(j1, pendingintent);
    }

    void a(int i1, AMapLocalWeatherListener amaplocalweatherlistener)
    {
        try
        {
            (new i(this, i1, amaplocalweatherlistener)).start();
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    void a(long l1, float f1, AMapLocationListener amaplocationlistener, String s, boolean flag)
    {
        o = l1;
        p = f1;
        if (amaplocationlistener != null)
        {
            g g1 = new g(l1, f1, amaplocationlistener, s, flag);
            i.add(g1);
        }
        if ("gps".equals(s))
        {
            a.a(l1, f1);
        } else
        if ("lbs".equals(s))
        {
            if (f)
            {
                a.a(l1, f1);
            }
            b.a(l1);
            c(true);
            if (n == null)
            {
                n = new Thread(b);
                n.start();
                return;
            }
        }
    }

    void a(PendingIntent pendingintent)
    {
        b.a(pendingintent);
    }

    void a(AMapLocationListener amaplocationlistener)
    {
        int i1 = i.size();
        int j1 = 0;
        while (j1 < i1) 
        {
            g g1 = (g)i.get(j1);
            int k1;
            int l1;
            int i2;
            if (amaplocationlistener.equals(g1.b))
            {
                i.remove(g1);
                int j2 = i1 - 1;
                k1 = j1 - 1;
                l1 = j2;
            } else
            {
                k1 = j1;
                l1 = i1;
            }
            i2 = k1 + 1;
            i1 = l1;
            j1 = i2;
        }
        if (a != null && i.size() == 0)
        {
            a.b();
            b(false);
            c(false);
            if (n != null)
            {
                n.interrupt();
                n = null;
            }
        }
    }

    void a(boolean flag)
    {
label0:
        {
            d(flag);
            if (i != null && i.size() > 0)
            {
                if (!flag)
                {
                    break label0;
                }
                a.b();
                a.a(o, p);
            }
            return;
        }
        a.b();
    }

    void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != null)
        {
            a.b();
            a.a();
            a = null;
        }
        if (b != null)
        {
            b.a();
            b = null;
        }
        if (i != null)
        {
            i.clear();
        }
        b(false);
        n = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void b(double d1, double d2, float f1, long l1, 
            PendingIntent pendingintent)
    {
        j j1 = new j();
        j1.b = d1;
        j1.a = d2;
        j1.c = f1;
        j1.a(l1);
        b.b(j1, pendingintent);
    }

    void b(PendingIntent pendingintent)
    {
        b.b(pendingintent);
    }

    void b(boolean flag)
    {
        c = flag;
    }
}
