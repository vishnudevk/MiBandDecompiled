// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
import java.util.Iterator;

// Referenced classes of package com.tencent.b.b:
//            p

public final class e
{

    private static LocationManager b = null;
    private static float d = 0.0F;
    private Context a;
    private p c;
    private b e;
    private a f;
    private boolean g;
    private byte h[];
    private int i;
    private long j;
    private boolean k;
    private int l;
    private int m;

    public e()
    {
        a = null;
        c = null;
        e = null;
        f = null;
        g = false;
        h = new byte[0];
        i = 1024;
        j = 0L;
        k = false;
        l = 0;
        m = 0;
    }

    static int a(e e1, int i1)
    {
        int j1 = i1 | e1.i;
        e1.i = j1;
        return j1;
    }

    static long a(e e1, long l1)
    {
        e1.j = l1;
        return l1;
    }

    static a a(e e1, a a1)
    {
        e1.f = a1;
        return a1;
    }

    static void a(e e1)
    {
        e1.b();
    }

    static int b(e e1)
    {
        return e1.l;
    }

    static int b(e e1, int i1)
    {
        e1.l = i1;
        return i1;
    }

    private void b()
    {
        m = 0;
        l = 0;
        GpsStatus gpsstatus = b.getGpsStatus(null);
        if (gpsstatus != null)
        {
            int i1 = gpsstatus.getMaxSatellites();
            Iterator iterator = gpsstatus.getSatellites().iterator();
            if (iterator != null)
            {
                while (iterator.hasNext() && l <= i1) 
                {
                    l = 1 + l;
                    if (((GpsSatellite)iterator.next()).usedInFix())
                    {
                        m = 1 + m;
                    }
                }
            }
        }
    }

    static int c(e e1)
    {
        return e1.m;
    }

    static int c(e e1, int i1)
    {
        e1.m = 0;
        return 0;
    }

    static int d(e e1)
    {
        return e1.i;
    }

    static int d(e e1, int i1)
    {
        e1.i = i1;
        return i1;
    }

    static long e(e e1)
    {
        return e1.j;
    }

    static b f(e e1)
    {
        return e1.e;
    }

    static a g(e e1)
    {
        return e1.f;
    }

    public final void a()
    {
label0:
        {
            synchronized (h)
            {
                if (g)
                {
                    break label0;
                }
            }
            return;
        }
        if (b != null && c != null)
        {
            b.removeGpsStatusListener(c);
            b.removeUpdates(c);
        }
        g = false;
        abyte0;
        JVM INSTR monitorexit ;
    }

    public final boolean a(b b1, Context context)
    {
label0:
        {
            synchronized (h)
            {
                if (!g)
                {
                    break label0;
                }
            }
            return true;
        }
        if (context == null || b1 == null)
        {
            return false;
        }
        a = context;
        e = b1;
        p p1;
        try
        {
            b = (LocationManager)a.getSystemService("location");
            c = new p(this, (byte)0);
            if (b == null)
            {
                break MISSING_BLOCK_LABEL_85;
            }
            p1 = c;
        }
        catch (Exception exception1)
        {
            return false;
        }
        if (p1 != null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        abyte0;
        JVM INSTR monitorexit ;
        return false;
        b.requestLocationUpdates("gps", 1000L, 0.0F, c);
        b.addGpsStatusListener(c);
        if (!b.isProviderEnabled("gps"))
        {
            break MISSING_BLOCK_LABEL_150;
        }
        i = 4;
_L1:
        g = true;
        abyte0;
        JVM INSTR monitorexit ;
        return g;
        i = 0;
          goto _L1
        Exception exception2;
        exception2;
        abyte0;
        JVM INSTR monitorexit ;
        return false;
        exception;
        throw exception;
    }

}
