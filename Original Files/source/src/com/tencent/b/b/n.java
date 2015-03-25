// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.b.a.a.b;
import com.tencent.b.a.a.c;
import com.tencent.b.a.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tencent.b.b:
//            B, C, e, m, 
//            f, s, b, c, 
//            z, A, y, t, 
//            a

public final class n
    implements b.a, e.b, f.a, m.a
{

    private static boolean t = false;
    private static n u = null;
    private d A;
    private int B;
    private int C;
    private int D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private boolean K;
    private boolean L;
    private long M;
    private Handler N;
    private Runnable O;
    private final BroadcastReceiver P = new C(this);
    private long a;
    private Context b;
    private e c;
    private m d;
    private f e;
    private int f;
    private int g;
    private com.tencent.b.b.c h;
    private com.tencent.b.b.b i;
    private b j;
    private int k;
    private int l;
    private int m;
    private byte n[];
    private byte o[];
    private boolean p;
    private y q;
    private z r;
    private A s;
    private long v;
    private e.a w;
    private m.b x;
    private f.b y;
    private d z;

    private n()
    {
        a = 5000L;
        b = null;
        c = null;
        d = null;
        e = null;
        f = 1024;
        g = 4;
        h = null;
        i = null;
        j = null;
        n = new byte[0];
        o = new byte[0];
        p = false;
        q = null;
        r = null;
        s = null;
        v = -1L;
        w = null;
        x = null;
        y = null;
        z = null;
        A = null;
        B = 0;
        C = 0;
        D = 1;
        E = "";
        F = "";
        G = "";
        H = "";
        I = "";
        J = "";
        K = false;
        L = false;
        M = 0L;
        N = null;
        O = new B(this);
        c = new e();
        d = new m();
        e = new f();
    }

    static long a(n n1)
    {
        return n1.M;
    }

    static long a(n n1, long l1)
    {
        n1.M = l1;
        return l1;
    }

    static A a(n n1, A a1)
    {
        n1.s = null;
        return null;
    }

    public static n a()
    {
        com/tencent/b/b/n;
        JVM INSTR monitorenter ;
        n n1;
        if (u == null)
        {
            u = new n();
        }
        n1 = u;
        com/tencent/b/b/n;
        JVM INSTR monitorexit ;
        return n1;
        Exception exception;
        exception;
        throw exception;
    }

    private static ArrayList a(JSONArray jsonarray)
    {
        int i1 = jsonarray.length();
        ArrayList arraylist = new ArrayList();
        for (int j1 = 0; j1 < i1; j1++)
        {
            JSONObject jsonobject = jsonarray.getJSONObject(j1);
            arraylist.add(new c(jsonobject.getString("name"), jsonobject.getString("addr"), jsonobject.getString("catalog"), jsonobject.getDouble("dist"), Double.parseDouble(jsonobject.getString("latitude")), Double.parseDouble(jsonobject.getString("longitude"))));
        }

        return arraylist;
    }

    static void a(n n1, int i1)
    {
        if (i1 == 0)
        {
            n1.w = null;
        }
        int j1;
        if (i1 == 0)
        {
            j1 = 1;
        } else
        {
            j1 = 2;
        }
        n1.f = j1;
        if (n1.j != null)
        {
            n1.j.onStatusUpdate(n1.f);
        }
    }

    static void a(n n1, Location location)
    {
        if (location == null || location.getLatitude() > 359D || location.getLongitude() > 359D)
        {
            if (n1.w != null && n1.w.a())
            {
                n1.b(true);
            } else
            {
                n1.e();
            }
        }
        n1.z = new d();
        n1.z.z = 0;
        n1.z.y = 0;
        n1.z.b = com.tencent.b.b.s.a(location.getLatitude(), 6);
        n1.z.c = com.tencent.b.b.s.a(location.getLongitude(), 6);
        if (n1.w != null && n1.w.a())
        {
            n1.z.e = com.tencent.b.b.s.a(n1.w.b().getAccuracy(), 1);
            n1.z.d = com.tencent.b.b.s.a(n1.w.b().getAltitude(), 1);
            n1.z.f = com.tencent.b.b.s.a(n1.w.b().getSpeed(), 1);
            n1.z.g = com.tencent.b.b.s.a(n1.w.b().getBearing(), 1);
            n1.z.a = 0;
        }
        n1.z.x = true;
        if (n1.l != 0 && n1.A != null && n1.B == 0)
        {
            if ((n1.l == 3 || n1.l == 4) && n1.l == n1.A.z)
            {
                n1.z.i = n1.A.i;
                n1.z.j = n1.A.j;
                n1.z.k = n1.A.k;
                n1.z.l = n1.A.l;
                n1.z.m = n1.A.m;
                n1.z.n = n1.A.n;
                n1.z.o = n1.A.o;
                n1.z.p = n1.A.p;
                n1.z.z = 3;
            }
            if (n1.l == 4 && n1.l == n1.A.z && n1.A.w != null)
            {
                n1.z.w = new ArrayList();
                c c1;
                for (Iterator iterator = n1.A.w.iterator(); iterator.hasNext(); n1.z.w.add(new c(c1)))
                {
                    c1 = (c)iterator.next();
                }

                n1.z.z = 4;
            }
            if (n1.l == 7 && n1.l == n1.A.z)
            {
                n1.z.z = 7;
                n1.z.h = n1.A.h;
                n1.z.i = n1.A.i;
                if (n1.A.h == 0)
                {
                    n1.z.j = n1.A.j;
                    n1.z.k = n1.A.k;
                    n1.z.l = n1.A.l;
                    n1.z.m = n1.A.m;
                    n1.z.n = n1.A.n;
                    n1.z.o = n1.A.o;
                    n1.z.p = n1.A.p;
                } else
                {
                    n1.z.q = n1.A.q;
                    n1.z.r = n1.A.r;
                    n1.z.s = n1.A.s;
                    n1.z.t = n1.A.t;
                    n1.z.u = n1.A.u;
                    n1.z.v = n1.A.v;
                }
            }
        }
        if (n1.B != 0 || n1.A != null)
        {
            if (n1.B != 0)
            {
                n1.z.y = n1.B;
            }
            if (System.currentTimeMillis() - n1.v >= n1.a && n1.j != null && n1.k == 1)
            {
                n1.j.onLocationUpdate(n1.z);
                n1.v = System.currentTimeMillis();
            }
        }
    }

    static void a(n n1, e.a a1)
    {
        if (a1 != null)
        {
            n1.w = a1;
            if (n1.k == 1 && n1.w != null && n1.w.a())
            {
                if (n1.m == 0)
                {
                    n1.b(false);
                    return;
                }
                if (n1.m == 1 && n1.i != null)
                {
                    com.tencent.b.b.b b1 = n1.i;
                    double d1 = n1.w.b().getLatitude();
                    double d2 = n1.w.b().getLongitude();
                    Context _tmp = n1.b;
                    b1.a(d1, d2, n1);
                    return;
                }
            }
        }
    }

    static void a(n n1, f.b b1)
    {
        if (b1 != null)
        {
            n1.y = b1;
            n1.d();
        }
    }

    static void a(n n1, m.b b1)
    {
        n1.x = b1;
        if (n1.e != null && n1.e.b() && n1.e.c())
        {
            n1.e.a(0L);
            return;
        }
        if (n1.C > 0 && !com.tencent.b.b.s.a(b1.a, b1.b, b1.c, b1.d, b1.e))
        {
            n1.C = -1 + n1.C;
        }
        n1.d();
    }

    static void a(n n1, String s1)
    {
        if (com.tencent.b.b.s.c(s1)) goto _L2; else goto _L1
_L1:
        if (n1.C <= 0) goto _L4; else goto _L3
_L3:
        n1.C = -1 + n1.C;
_L9:
        return;
_L4:
        if (n1.k == 0 && n1.j != null)
        {
            n1.j.onLocationDataUpdate(null, -1);
            return;
        }
        if (n1.k == 1 && n1.j != null)
        {
            n1.z = new d();
            n1.B = 3;
            n1.z.y = 3;
            n1.z.z = -1;
            n1.j.onLocationUpdate(n1.z);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (n1.k != 0 || n1.j == null) goto _L6; else goto _L5
_L5:
        byte abyte1[] = s1.getBytes();
        byte abyte0[] = abyte1;
_L7:
        n1.j.onLocationDataUpdate(abyte0, 0);
        return;
        Exception exception;
        exception;
        abyte0 = null;
        if (true) goto _L7; else goto _L6
_L6:
        String s2;
        if (n1.h == null)
        {
            s2 = null;
        } else
        if (n1.x != null && n1.y != null)
        {
            s2 = n1.h.b(n1.x.b, n1.x.c, n1.x.d, n1.x.e, n1.y.a());
        } else
        {
            s2 = null;
        }
        if (s2 != null)
        {
            n1.a(s2);
            return;
        }
        if (n1.h != null && n1.x != null && n1.y != null)
        {
            n1.h.a(n1.x.b, n1.x.c, n1.x.d, n1.x.e, n1.y.a());
        }
        if (!n1.p)
        {
            if (n1.r != null)
            {
                n1.r.interrupt();
            }
            n1.r = null;
            n1.r = new z(n1, s1);
            n1.r.start();
            return;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void a(String s1)
    {
        JSONObject jsonobject;
        d d1;
        z = new d();
        jsonobject = new JSONObject(s1);
        JSONObject jsonobject1 = jsonobject.getJSONObject("location");
        z.a = 1;
        z.b = com.tencent.b.b.s.a(jsonobject1.getDouble("latitude"), 6);
        z.c = com.tencent.b.b.s.a(jsonobject1.getDouble("longitude"), 6);
        z.d = com.tencent.b.b.s.a(jsonobject1.getDouble("altitude"), 1);
        z.e = com.tencent.b.b.s.a(jsonobject1.getDouble("accuracy"), 1);
        d1 = z;
        boolean flag;
        String s2;
        int i1;
        int j1;
        int k1;
        d d2;
        double d3;
        double d4;
        int i2;
        JSONObject jsonobject3;
        if (m == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d1.x = flag;
        s2 = jsonobject.getString("bearing");
        i1 = -100;
        j1 = 0;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        k1 = s2.split(",").length;
        j1 = 0;
        if (k1 <= 1)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        j1 = Integer.parseInt(s2.split(",")[1]);
        if (x != null)
        {
            i1 = x.f;
        }
        d2 = z;
        d3 = z.e;
        if (j1 >= 6)
        {
            d4 = 40D;
        } else
        if (j1 == 5)
        {
            d4 = 60D;
        } else
        if (j1 == 4)
        {
            d4 = 70D;
        } else
        if (j1 == 3)
        {
            d4 = 90D;
        } else
        if (j1 == 2)
        {
            d4 = 110D;
        } else
        {
            int l1;
            if (i1 >= -72 && j1 == 0)
            {
                l1 = 10 * (int)((0.45000000000000001D * d3) / 10D);
            } else
            if (d3 <= 100D)
            {
                l1 = 10 * (int)(1.0D + (d3 - 1.0D) / 10D);
            } else
            if (d3 > 100D && d3 <= 800D)
            {
                l1 = 10 * (int)((0.84999999999999998D * d3) / 10D);
            } else
            {
                l1 = 10 * (int)((0.80000000000000004D * d3) / 10D);
            }
            d4 = l1;
        }
        d2.e = d4;
        z.z = 0;
        if ((l == 3 || l == 4) && m == 1)
        {
            JSONObject jsonobject4 = jsonobject.getJSONObject("details").getJSONObject("subnation");
            z.a(jsonobject4.getString("name"));
            z.m = jsonobject4.getString("town");
            z.n = jsonobject4.getString("village");
            z.o = jsonobject4.getString("street");
            z.p = jsonobject4.getString("street_no");
            z.z = 3;
            z.h = 0;
        }
        if (l == 4 && m == 1)
        {
            JSONArray jsonarray = jsonobject.getJSONObject("details").getJSONArray("poilist");
            z.w = a(jsonarray);
            z.z = 4;
        }
        if (l != 7 || m != 1) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject2 = jsonobject.getJSONObject("details");
        i2 = jsonobject2.getInt("stat");
        jsonobject3 = jsonobject2.getJSONObject("subnation");
        if (i2 != 0) goto _L4; else goto _L3
_L3:
        z.a(jsonobject3.getString("name"));
        z.m = jsonobject3.getString("town");
        z.n = jsonobject3.getString("village");
        z.o = jsonobject3.getString("street");
        z.p = jsonobject3.getString("street_no");
_L6:
        z.h = i2;
        z.z = 7;
_L2:
        z.y = 0;
        A = new d(z);
        B = 0;
        if (h != null)
        {
            h.a(s1);
        }
_L7:
        if (j != null && k == 1 && (w == null || !w.a()))
        {
            j.onLocationUpdate(z);
            v = System.currentTimeMillis();
        }
        return;
_L4:
        if (i2 != 1) goto _L6; else goto _L5
_L5:
        z.i = jsonobject3.getString("nation");
        z.q = jsonobject3.getString("admin_level_1");
        z.r = jsonobject3.getString("admin_level_2");
        z.s = jsonobject3.getString("admin_level_3");
        z.t = jsonobject3.getString("locality");
        z.u = jsonobject3.getString("sublocality");
        z.v = jsonobject3.getString("route");
          goto _L6
        Exception exception;
        exception;
        z = new d();
        z.z = -1;
        z.y = 2;
        B = 2;
          goto _L7
    }

    static boolean a(n n1, boolean flag)
    {
        n1.p = flag;
        return flag;
    }

    static boolean a(boolean flag)
    {
        t = true;
        return true;
    }

    static f b(n n1)
    {
        return n1.e;
    }

    static void b(n n1, int i1)
    {
        int j1 = 3;
        if (i1 == j1)
        {
            j1 = 4;
        }
        n1.g = j1;
        if (n1.j != null)
        {
            n1.j.onStatusUpdate(n1.g);
        }
    }

    static void b(n n1, String s1)
    {
        n1.a(s1);
    }

    private void b(boolean flag)
    {
        if (w != null && w.a())
        {
            Location location = w.b();
            z = new d();
            z.b = com.tencent.b.b.s.a(location.getLatitude(), 6);
            z.c = com.tencent.b.b.s.a(location.getLongitude(), 6);
            z.d = com.tencent.b.b.s.a(location.getAltitude(), 1);
            z.e = com.tencent.b.b.s.a(location.getAccuracy(), 1);
            z.f = com.tencent.b.b.s.a(location.getSpeed(), 1);
            z.g = com.tencent.b.b.s.a(location.getBearing(), 1);
            z.a = 0;
            z.x = false;
            if (!flag)
            {
                z.y = 0;
            } else
            {
                z.y = 1;
            }
            z.z = 0;
            A = new d(z);
            B = 0;
            if (System.currentTimeMillis() - v >= a && j != null && k == 1)
            {
                j.onLocationUpdate(z);
                v = System.currentTimeMillis();
            }
        }
    }

    static String c(n n1, String s1)
    {
        n1.E = s1;
        return s1;
    }

    static void c(n n1)
    {
        n1.d();
    }

    static boolean c()
    {
        return t;
    }

    static y d(n n1)
    {
        return n1.q;
    }

    static String d(n n1, String s1)
    {
        n1.F = s1;
        return s1;
    }

    private void d()
    {
        if (s != null)
        {
            return;
        } else
        {
            s = new A(this, w, x, y);
            s.start();
            return;
        }
    }

    static int e(n n1)
    {
        return n1.B;
    }

    static String e(n n1, String s1)
    {
        n1.G = s1;
        return s1;
    }

    private void e()
    {
        z = new d();
        B = 1;
        z.y = 1;
        z.z = -1;
        z.a = 1;
        if (j != null && k == 1)
        {
            j.onLocationUpdate(z);
        }
    }

    static e.a f(n n1)
    {
        return n1.w;
    }

    static String f(n n1, String s1)
    {
        n1.I = s1;
        return s1;
    }

    static void g(n n1)
    {
        n1.e();
    }

    static int h(n n1)
    {
        return n1.D;
    }

    static int i(n n1)
    {
        return n1.m;
    }

    static void j(n n1)
    {
    }

    static Context k(n n1)
    {
        return n1.b;
    }

    static String l(n n1)
    {
        return n1.E;
    }

    static String m(n n1)
    {
        return n1.F;
    }

    static String n(n n1)
    {
        return n1.G;
    }

    static int o(n n1)
    {
        return n1.g;
    }

    static m p(n n1)
    {
        return n1.d;
    }

    static String q(n n1)
    {
        return n1.H;
    }

    static boolean r(n n1)
    {
        return n1.K;
    }

    static int s(n n1)
    {
        return n1.l;
    }

    static String t(n n1)
    {
        return n1.I;
    }

    static String u(n n1)
    {
        return n1.J;
    }

    public final void a(double d1, double d2)
    {
        synchronized (o)
        {
            Message message = q.obtainMessage(6);
            Location location = new Location("Deflect");
            location.setLatitude(d1);
            location.setLongitude(d2);
            message.obj = location;
            q.sendMessage(message);
        }
    }

    public final void a(int i1)
    {
        synchronized (o)
        {
            Message message = q.obtainMessage(4, i1, 0);
            q.sendMessage(message);
        }
    }

    public final void a(e.a a1)
    {
        synchronized (o)
        {
            Message message = q.obtainMessage(1, a1);
            q.sendMessage(message);
        }
    }

    public final void a(f.b b1)
    {
        synchronized (o)
        {
            Message message = q.obtainMessage(3, b1);
            q.sendMessage(message);
        }
    }

    public final void a(m.b b1)
    {
        synchronized (o)
        {
            Message message = q.obtainMessage(2, b1);
            q.sendMessage(message);
        }
    }

    public final boolean a(Context context, b b1)
    {
        byte abyte0[] = n;
        abyte0;
        JVM INSTR monitorenter ;
        if (context == null || b1 == null)
        {
            return false;
        }
        if (com.tencent.b.b.s.a(J))
        {
            break MISSING_BLOCK_LABEL_33;
        }
        abyte0;
        JVM INSTR monitorexit ;
        return false;
        q = new y(this);
        N = new Handler(Looper.getMainLooper());
        b = context;
        j = b1;
        com.tencent.b.b.t.a().a(b.getApplicationContext());
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivitymanager == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        if (connectivitymanager.getActiveNetworkInfo() != null)
        {
            K = connectivitymanager.getActiveNetworkInfo().isRoaming();
        }
        b.registerReceiver(P, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
_L2:
        boolean flag;
        boolean flag1;
        boolean flag2;
        k = j.getReqType();
        l = j.getReqLevel();
        m = j.getReqGeoType();
        v = -1L;
        if (l == 7)
        {
            l = 0;
        }
        L = false;
        D = 1;
        flag = c.a(this, b);
        flag1 = d.a(b, this);
        flag2 = e.a(b, this, 1);
        h = com.tencent.b.b.c.a();
        i = com.tencent.b.b.b.a();
        w = null;
        x = null;
        y = null;
        z = null;
        A = null;
        B = 0;
        if (h != null)
        {
            h.b();
        }
        C = 1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_327;
        }
        if (m != 0)
        {
            break MISSING_BLOCK_LABEL_327;
        }
        abyte0;
        JVM INSTR monitorexit ;
        return true;
        if (flag1 || flag2)
        {
            return true;
        }
        return false;
        Exception exception;
        exception;
        throw exception;
        Exception exception1;
        exception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final boolean a(String s1, String s2)
    {
        byte abyte0[] = n;
        abyte0;
        JVM INSTR monitorenter ;
        if (!com.tencent.b.b.a.a().a(s1, s2))
        {
            break MISSING_BLOCK_LABEL_27;
        }
        J = s1;
        return true;
        abyte0;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        throw exception;
    }

    public final void b()
    {
        Exception exception;
        synchronized (n)
        {
            try
            {
                if (j != null)
                {
                    j = null;
                    N.removeCallbacks(O);
                    b.unregisterReceiver(P);
                    c.a();
                    d.a();
                    e.a();
                }
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
    }

    public final void b(int i1)
    {
        synchronized (o)
        {
            Message message = q.obtainMessage(5, i1, 0);
            q.sendMessage(message);
        }
    }

}
