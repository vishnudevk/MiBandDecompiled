// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.location.Location;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.b.b:
//            t, k, i, u

public class b
{

    private static com.tencent.b.b.b b;
    public String a;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    private a i;
    private b j;
    private boolean k;

    public b()
    {
        c = 0.0D;
        d = 0.0D;
        e = 0.0D;
        f = 0.0D;
        g = 0.0D;
        h = 0.0D;
        j = null;
        k = false;
        a = "";
    }

    static a a(b b1)
    {
        return b1.i;
    }

    public static b a()
    {
        if (b == null)
        {
            b = new b();
        }
        return b;
    }

    public static u a(String s, String s1, byte abyte0[])
    {
        boolean flag = true;
        if (t.b() == null)
        {
            flag = false;
        }
        if (!flag)
        {
            throw new k();
        }
        u u;
        try
        {
            u = com.tencent.b.b.i.a(false, s, s1, null, abyte0, false, true);
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return u;
    }

    static void a(b b1, byte abyte0[], String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        JSONObject jsonobject;
        double d1;
        double d2;
        try
        {
            stringbuffer.append(new String(abyte0, s));
        }
        catch (Exception exception)
        {
            if (b1.i != null)
            {
                b1.i.a(360D, 360D);
            }
            continue; /* Loop/switch isn't completed */
        }
_L4:
        jsonobject = (new JSONObject(stringbuffer.toString())).getJSONObject("location");
        d1 = jsonobject.getDouble("latitude");
        d2 = jsonobject.getDouble("longitude");
        b1.g = d1 - b1.e;
        b1.h = d2 - b1.f;
        b1.c = b1.e;
        b1.d = b1.f;
        if (b1.i != null)
        {
            b1.i.a(d1, d2);
        }
_L2:
        return;
        JSONException jsonexception;
        jsonexception;
        if (b1.i == null) goto _L2; else goto _L1
_L1:
        b1.i.a(360D, 360D);
        return;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean a(b b1, boolean flag)
    {
        b1.k = flag;
        return flag;
    }

    public static boolean a(String s)
    {
        return s == null || s.trim().length() == 0;
    }

    public final void a(double d1, double d2, a a1)
    {
        i = a1;
        if (g == 0.0D || h == 0.0D) goto _L2; else goto _L1
_L1:
        float af[];
        af = new float[10];
        Location.distanceBetween(d1, d2, c, d, af);
        if (af[0] >= 1500F) goto _L2; else goto _L3
_L3:
        i.a(d1 + g, d2 + h);
_L5:
        return;
_L2:
        if (!k)
        {
            a = (new StringBuilder("{\"source\":101,\"access_token\":\"160e7bd42dec9428721034e0146fc6dd\",\"location\":{\"latitude\":")).append(d1).append(",\"longitude\":").append(d2).append("}\t}").toString();
            e = d1;
            f = d2;
            j = new b();
            j.start();
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    private class a
    {

        public abstract void a(double d1, double d2);
    }


    private class b extends Thread
    {

        private com.tencent.b.b.b a;

        public final void run()
        {
            byte abyte1[] = r.a(a.a.getBytes());
            com.tencent.b.b.b.a(a, true);
            u u2 = com.tencent.b.b.b.a("http://ls.map.soso.com/deflect?c=1", "SOSO MAP LBS SDK", abyte1);
            com.tencent.b.b.b.a(a, false);
            byte abyte2[] = r.b(u2.a);
            com.tencent.b.b.b.a(a, abyte2, u2.b);
_L1:
            return;
            Exception exception;
            exception;
            for (int l = 0; ++l <= 3;)
            {
                try
                {
                    sleep(2000L);
                    u u1 = com.tencent.b.b.b.a("http://ls.map.soso.com/deflect?c=1", "SOSO MAP LBS SDK", r.a(a.a.getBytes()));
                    com.tencent.b.b.b.a(a, false);
                    byte abyte0[] = r.b(u1.a);
                    com.tencent.b.b.b.a(a, abyte0, u1.b);
                    return;
                }
                catch (Exception exception1) { }
            }

            com.tencent.b.b.b.a(a, false);
            if (com.tencent.b.b.b.a(a) != null)
            {
                com.tencent.b.b.b.a(a).a(360D, 360D);
                return;
            }
              goto _L1
        }

        public b()
        {
            a = com.tencent.b.b.b.this;
            super();
        }
    }

}
