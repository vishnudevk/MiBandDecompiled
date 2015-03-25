// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.tencent.b.b:
//            x

public final class m
{

    private Context a;
    private TelephonyManager b;
    private c c;
    private a d;
    private b e;
    private boolean f;
    private List g;
    private byte h[];
    private byte i[];
    private boolean j;

    public m()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = false;
        g = new LinkedList();
        h = new byte[0];
        i = new byte[0];
        j = false;
    }

    private int a(int k)
    {
        String s;
        s = b.getNetworkOperator();
        if (s == null || s.length() < 3)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        int i1 = Integer.valueOf(s.substring(0, 3)).intValue();
        int l = i1;
_L1:
        Exception exception;
        if (k == 2 && l == -1)
        {
            return 0;
        } else
        {
            return l;
        }
        exception;
        l = -1;
          goto _L1
    }

    static a a(m m1)
    {
        return m1.d;
    }

    static b a(m m1, b b1)
    {
        m1.e = b1;
        return b1;
    }

    static boolean a(m m1, boolean flag)
    {
        m1.j = false;
        return false;
    }

    static b b(m m1)
    {
        return m1.e;
    }

    static void c(m m1)
    {
        if (!m1.j)
        {
            m1.j = true;
            (new x(m1)).start();
        }
    }

    static TelephonyManager d(m m1)
    {
        return m1.b;
    }

    static byte[] e(m m1)
    {
        return m1.i;
    }

    static List f(m m1)
    {
        return m1.g;
    }

    public final void a()
    {
label0:
        {
            c c1;
            synchronized (h)
            {
                if (f)
                {
                    break label0;
                }
            }
            return;
        }
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        c1 = c;
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        b.listen(c, 0);
_L1:
        f = false;
        abyte0;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        f = false;
          goto _L1
    }

    public final boolean a(Context context, a a1)
    {
label0:
        {
            synchronized (h)
            {
                if (!f)
                {
                    break label0;
                }
            }
            return true;
        }
        if (context == null || a1 == null)
        {
            return false;
        }
        a = context;
        d = a1;
        TelephonyManager telephonymanager;
        b = (TelephonyManager)a.getSystemService("phone");
        telephonymanager = b;
        if (telephonymanager != null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        abyte0;
        JVM INSTR monitorexit ;
        return false;
        c c1;
        int k = b.getPhoneType();
        c = new c(a(k), k);
        c1 = c;
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        abyte0;
        JVM INSTR monitorexit ;
        return false;
        b.listen(c, 18);
        f = true;
        abyte0;
        JVM INSTR monitorexit ;
        return f;
        Exception exception1;
        exception1;
        abyte0;
        JVM INSTR monitorexit ;
        return false;
        exception;
        throw exception;
    }

    public final List b()
    {
        byte abyte0[] = i;
        abyte0;
        JVM INSTR monitorenter ;
        List list = g;
        LinkedList linkedlist;
        linkedlist = null;
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        linkedlist = new LinkedList();
        linkedlist.addAll(g);
        abyte0;
        JVM INSTR monitorexit ;
        return linkedlist;
        Exception exception;
        exception;
        throw exception;
    }

    private class c extends PhoneStateListener
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
        //                       1 133
        //                       2 288;
               goto _L2 _L3 _L4
_L2:
            m.a(n, n. new b(a, b, c, d, e, f, g, h));
            if (m.a(n) != null)
            {
                m.a(n).a(m.b(n));
            }
            return;
_L3:
            GsmCellLocation gsmcelllocation = (GsmCellLocation)celllocation;
            GsmCellLocation gsmcelllocation1;
            if (gsmcelllocation.getLac() > 0 || gsmcelllocation.getCid() > 0)
            {
                break MISSING_BLOCK_LABEL_174;
            }
            gsmcelllocation1 = (GsmCellLocation)m.d(n).getCellLocation();
            gsmcelllocation = gsmcelllocation1;
            boolean flag = true;
_L6:
            if (!flag || gsmcelllocation == null) goto _L2; else goto _L5
_L5:
            String s;
            s = m.d(n).getNetworkOperator();
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
            m.c(n);
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
                m.c(n);
            }
            if (Math.abs(i1 - (113 + f) / 2) > 3)
            {
                if (f == -1)
                {
                    f = -113 + (i1 << 1);
                } else
                {
                    f = -113 + (i1 << 1);
                    m.a(n, n. new b(a, b, c, d, e, f, g, h));
                    if (m.a(n) != null)
                    {
                        m.a(n).a(m.b(n));
                        return;
                    }
                }
            }
        }

        public c(int i1, int j1)
        {
            n = m.this;
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

        private class b
            implements Cloneable
        {

            public int a;
            public int b;
            public int c;
            public int d;
            public int e;
            public int f;
            public int g;
            public int h;

            public final Object clone()
            {
                b b1;
                try
                {
                    b1 = (b)super.clone();
                }
                catch (Exception exception)
                {
                    return null;
                }
                return b1;
            }

            public b(int i1, int j1, int k1, int l1, int i2, int j2, 
                    int k2, int l2)
            {
                a = 0;
                b = 0;
                c = 0;
                d = 0;
                e = 0;
                f = 0;
                g = 0x7fffffff;
                h = 0x7fffffff;
                a = i1;
                b = j1;
                c = k1;
                d = l1;
                e = i2;
                f = j2;
                g = k2;
                h = l2;
            }
        }


        private class a
        {

            public abstract void a(b b1);
        }

    }

}
