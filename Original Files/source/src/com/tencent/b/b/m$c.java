// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.lang.reflect.Method;

// Referenced classes of package com.tencent.b.b:
//            m

public final class a extends PhoneStateListener
{

    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Method i;
    private Method j;
    private Method k;
    private Method l;
    private Method m;
    private m n;

    public final void onCellLocationChanged(CellLocation celllocation)
    {
        f = -1;
        e = -1;
        d = -1;
        c = -1;
        if (celllocation == null) goto _L2; else goto _L1
_L1:
        a;
        JVM INSTR tableswitch 1 2: default 52
    //                   1 133
    //                   2 288;
           goto _L2 _L3 _L4
_L2:
        com.tencent.b.b.m.a(n, new <init>(n, a, b, c, d, e, f, g, h));
        if (com.tencent.b.b.m.a(n) != null)
        {
            com.tencent.b.b.m.a(n).a(com.tencent.b.b.m.b(n));
        }
        return;
_L3:
        GsmCellLocation gsmcelllocation = (GsmCellLocation)celllocation;
        GsmCellLocation gsmcelllocation1;
        if (gsmcelllocation.getLac() > 0 || gsmcelllocation.getCid() > 0)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        gsmcelllocation1 = (GsmCellLocation)com.tencent.b.b.m.d(n).getCellLocation();
        gsmcelllocation = gsmcelllocation1;
        boolean flag = true;
_L6:
        if (!flag || gsmcelllocation == null) goto _L2; else goto _L5
_L5:
        String s;
        s = com.tencent.b.b.m.d(n).getNetworkOperator();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        if (s.length() > 3)
        {
            c = Integer.valueOf(s.substring(3)).intValue();
        }
        d = gsmcelllocation.getLac();
        e = gsmcelllocation.getCid();
_L7:
        com.tencent.b.b.m.c(n);
          goto _L2
        Exception exception1;
        exception1;
        gsmcelllocation = null;
_L8:
        flag = false;
          goto _L6
        Exception exception2;
        exception2;
        e = -1;
        d = -1;
        c = -1;
          goto _L7
_L4:
        if (celllocation != null)
        {
            try
            {
                if (i == null)
                {
                    i = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getBaseStationId", new Class[0]);
                    j = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getSystemId", new Class[0]);
                    k = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getNetworkId", new Class[0]);
                    l = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getBaseStationLatitude", new Class[0]);
                    m = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getBaseStationLongitude", new Class[0]);
                }
                c = ((Integer)j.invoke(celllocation, new Object[0])).intValue();
                d = ((Integer)k.invoke(celllocation, new Object[0])).intValue();
                e = ((Integer)i.invoke(celllocation, new Object[0])).intValue();
                g = ((Integer)l.invoke(celllocation, new Object[0])).intValue();
                h = ((Integer)m.invoke(celllocation, new Object[0])).intValue();
            }
            catch (Exception exception)
            {
                e = -1;
                d = -1;
                c = -1;
                g = 0x7fffffff;
                h = 0x7fffffff;
            }
        }
          goto _L2
        Exception exception3;
        exception3;
          goto _L8
    }

    public final void onSignalStrengthChanged(int i1)
    {
        if (a == 1)
        {
            com.tencent.b.b.m.c(n);
        }
        if (Math.abs(i1 - (113 + f) / 2) > 3)
        {
            if (f == -1)
            {
                f = -113 + (i1 << 1);
            } else
            {
                f = -113 + (i1 << 1);
                com.tencent.b.b.m.a(n, new <init>(n, a, b, c, d, e, f, g, h));
                if (com.tencent.b.b.m.a(n) != null)
                {
                    com.tencent.b.b.m.a(n).a(com.tencent.b.b.m.b(n));
                    return;
                }
            }
        }
    }

    public llLocation(m m1, int i1, int j1)
    {
        n = m1;
        super();
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        f = -1;
        g = 0x7fffffff;
        h = 0x7fffffff;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        b = i1;
        a = j1;
    }
}
