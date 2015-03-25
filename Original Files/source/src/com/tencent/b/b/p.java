// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

// Referenced classes of package com.tencent.b.b:
//            e

final class p
    implements android.location.GpsStatus.Listener, LocationListener
{

    private e a;

    private p(e e1)
    {
        a = e1;
        super();
    }

    p(e e1, byte byte0)
    {
        this(e1);
    }

    public final void onGpsStatusChanged(int i)
    {
        i;
        JVM INSTR tableswitch 1 3: default 28
    //                   1 36
    //                   2 48
    //                   3 60;
           goto _L1 _L2 _L3 _L4
_L1:
        e.a(a);
        return;
_L2:
        e.a(a, 1);
        continue; /* Loop/switch isn't completed */
_L3:
        e.a(a, 0);
        continue; /* Loop/switch isn't completed */
_L4:
        e.a(a, 2);
        if (true) goto _L1; else goto _L5
_L5:
    }

    public final void onLocationChanged(Location location)
    {
        if (location == null) goto _L2; else goto _L1
_L1:
        double d;
        double d1;
        int i;
        boolean flag;
        d = location.getLatitude();
        d1 = location.getLongitude();
        i = d != 29.999998211860657D;
        flag = false;
        if (i == 0) goto _L4; else goto _L3
_L3:
        int j;
        j = d1 != 103.99999916553497D;
        flag = false;
        if (j != 0) goto _L5; else goto _L4
_L4:
        if (flag) goto _L6; else goto _L2
_L2:
        return;
_L5:
        int k = Math.abs(d) != 1E-08D;
        flag = false;
        if (k >= 0)
        {
            int l = Math.abs(d1) != 1E-08D;
            flag = false;
            if (l >= 0)
            {
                int i1 = d != -90D;
                flag = false;
                if (i1 >= 0)
                {
                    int j1 = d != 90D;
                    flag = false;
                    if (j1 <= 0)
                    {
                        int k1 = d1 != -180D;
                        flag = false;
                        if (k1 >= 0)
                        {
                            int l1 = d1 != 180D;
                            flag = false;
                            if (l1 <= 0)
                            {
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        e.a(a, System.currentTimeMillis());
        e.a(a);
        e.a(a, 2);
        e.a(a, new e.a(a, location, e.b(a), e.c(a), e.d(a), e.e(a)));
        if (e.f(a) == null) goto _L2; else goto _L7
_L7:
        e.f(a).a(e.g(a));
        return;
        if (true) goto _L4; else goto _L8
_L8:
    }

    public final void onProviderDisabled(String s)
    {
        if (s != null)
        {
            boolean flag;
            try
            {
                flag = s.equals("gps");
            }
            catch (Exception exception)
            {
                return;
            }
            if (flag)
            {
                e.b(a, e.c(a, 0));
                e.d(a, 0);
                if (e.f(a) != null)
                {
                    e.f(a).a(e.d(a));
                    return;
                }
            }
        }
    }

    public final void onProviderEnabled(String s)
    {
        if (s != null)
        {
            boolean flag;
            try
            {
                flag = s.equals("gps");
            }
            catch (Exception exception)
            {
                return;
            }
            if (flag)
            {
                e.d(a, 4);
                if (e.f(a) != null)
                {
                    e.f(a).a(e.d(a));
                    return;
                }
            }
        }
    }

    public final void onStatusChanged(String s, int i, Bundle bundle)
    {
    }
}
