// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.aps:
//            w, y, ai

public final class as
    implements android.location.GpsStatus.Listener, android.location.GpsStatus.NmeaListener
{

    private long a;
    private long b;
    private boolean c;
    private List d;
    private String e;
    private String f;
    private String g;
    private y h;

    protected as(y y1)
    {
        h = y1;
        super();
        a = 0L;
        b = 0L;
        c = false;
        d = new ArrayList();
        e = null;
        f = null;
        g = null;
    }

    public final void a(String s)
    {
        if (System.currentTimeMillis() - b <= 400L || !c || d.size() <= 0) goto _L2; else goto _L1
_L1:
        w w1 = new w(d, e, null, g);
        if (!w1.a()) goto _L4; else goto _L3
_L3:
        y.e(h, y.a(h, w1, y.o(h)));
        if (y.p(h) > 0)
        {
            y y1 = h;
            Locale locale = Locale.CHINA;
            Object aobj[] = new Object[3];
            aobj[0] = Double.valueOf(w1.c());
            aobj[1] = Double.valueOf(w1.b());
            aobj[2] = Integer.valueOf(y.p(h));
            y.b(y1, String.format(locale, "&nmea=%.1f|%.1f&g_tp=%d", aobj));
        }
_L6:
        d.clear();
        g = null;
        f = null;
        e = null;
        c = false;
_L2:
        Exception exception;
        if (s.startsWith("$GPGGA"))
        {
            c = true;
            e = s.trim();
        } else
        if (s.startsWith("$GPGSV"))
        {
            d.add(s.trim());
        } else
        if (s.startsWith("$GPGSA"))
        {
            g = s.trim();
        }
        b = System.currentTimeMillis();
        return;
_L4:
        try
        {
            y.e(h, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            y.e(h, 0);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void onGpsStatusChanged(int i)
    {
        int j = 0;
        Iterator iterator;
        int k;
        int l;
        GpsSatellite gpssatellite;
        try
        {
            if (y.e(h) == null)
            {
                return;
            }
        }
        catch (Exception exception)
        {
            return;
        }
          goto _L1
_L15:
        y.d(h, 0);
        return;
_L16:
        if (!y.a && System.currentTimeMillis() - a < 10000L)
        {
            break MISSING_BLOCK_LABEL_393;
        }
        if (y.i(h) != null)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        y.a(h, y.e(h).getGpsStatus(null));
_L4:
        iterator = y.i(h).getSatellites().iterator();
        y.a(h, 0);
        y.b(h, 0);
        y.a(h, new HashMap());
        k = 0;
        l = 0;
_L3:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_223;
        }
        gpssatellite = (GpsSatellite)iterator.next();
        k++;
        if (gpssatellite.usedInFix())
        {
            l++;
        }
        if (gpssatellite.getSnr() > 0.0F)
        {
            j++;
        }
        if (gpssatellite.getSnr() < (float)y.m()) goto _L3; else goto _L2
_L2:
        y.j(h);
          goto _L3
        y.e(h).getGpsStatus(y.i(h));
          goto _L4
        if (y.k(h) == -1) goto _L6; else goto _L5
_L5:
        if (l < 4) goto _L8; else goto _L7
_L7:
        if (y.k(h) < 4) goto _L6; else goto _L8
_L8:
        if (l >= 4) goto _L10; else goto _L9
_L9:
        if (y.k(h) < 4) goto _L10; else goto _L6
_L6:
        y.c(h, l);
        if (l >= 4) goto _L12; else goto _L11
_L11:
        if (y.l(h) != null)
        {
            y.l(h).w();
        }
_L10:
        y.d(h, j);
        y.b(h, y.m(h));
        if (y.a || l <= 3 && k <= 15)
        {
            break MISSING_BLOCK_LABEL_393;
        }
        if (y.e(h).getLastKnownLocation("gps") != null)
        {
            a = System.currentTimeMillis();
            return;
        }
        break MISSING_BLOCK_LABEL_393;
_L12:
        if (y.l(h) == null) goto _L10; else goto _L13
_L13:
        y.l(h).v();
          goto _L10
        return;
_L1:
        i;
        JVM INSTR tableswitch 2 4: default 420
    //                   2 13
    //                   3 420
    //                   4 23;
           goto _L14 _L15 _L14 _L16
_L14:
    }

    public final void onNmeaReceived(long l, String s)
    {
        if (!y.a)
        {
            return;
        }
        if (s != null)
        {
            try
            {
                if (!s.equals("") && s.length() >= 9 && s.length() <= 150)
                {
                    y.n(h).sendMessage(y.n(h).obtainMessage(1, s));
                    return;
                }
            }
            catch (Exception exception) { }
        }
        return;
    }
}
