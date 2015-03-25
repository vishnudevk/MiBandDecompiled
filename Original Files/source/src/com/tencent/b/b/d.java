// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.tencent.b.b:
//            t

public final class d
{

    private static int a = 10000;
    private static int b = 15000;
    private static int c = 5000;
    private static int d = 20000;
    private static int e = 25000;
    private static int f = 15000;
    private static ArrayList g;
    private static long h;
    private static long i;
    private static long j;
    private static long k;
    private static long l;
    private static long m;
    private static long n;
    private static long o;
    private static long p;
    private static long q;
    private static int r;
    private static int s;
    private static int t;
    private static int u;

    public static int a()
    {
        int i1 = a;
        int j1;
        ConnectivityManager connectivitymanager;
        int k1;
        a a1;
        NetworkInfo networkinfo;
        if (j > 0L && k > 0L)
        {
            j1 = (int)((Math.max(m, j) + k) - l);
        } else
        {
            j1 = i1;
        }
        connectivitymanager = (ConnectivityManager)com.tencent.b.b.t.b().getSystemService("connectivity");
        if (connectivitymanager == null) goto _L2; else goto _L1
_L1:
        networkinfo = connectivitymanager.getActiveNetworkInfo();
        if (networkinfo == null) goto _L2; else goto _L3
_L3:
        if (networkinfo.isConnected() || !networkinfo.isAvailable()) goto _L5; else goto _L4
_L4:
        j1 = b;
_L2:
        k1 = j1 + u * c;
        if (k1 <= c)
        {
            k1 = c;
        }
        if ((long)k1 <= k)
        {
            k1 = (int)(k + (long)c);
        }
        if (k1 >= b)
        {
            k1 = b;
        }
        a1 = b(Thread.currentThread().getId());
        if (a1 == null)
        {
            a1 = a(Thread.currentThread().getId());
        }
        if (k1 < a1.g + c)
        {
            k1 = a1.g + c;
        }
        a1.g = k1;
        return k1;
_L5:
        if (k > 0L && k < (long)c)
        {
            j1 = c;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    private static a a(long l1)
    {
        if (g == null)
        {
            g = new ArrayList();
        }
        ArrayList arraylist = g;
        arraylist;
        JVM INSTR monitorenter ;
        if (g.size() <= 20) goto _L2; else goto _L1
_L1:
        int i1 = g.size();
        int j1;
        boolean flag;
        int k1;
        j1 = 0;
        flag = false;
        k1 = 0;
_L10:
        if (j1 < i1 / 2) goto _L4; else goto _L3
_L3:
        if (!flag) goto _L2; else goto _L5
_L5:
        Iterator iterator;
        g.get(0);
        h = 0L;
        g.get(0);
        i = 0L;
        k = ((a)g.get(0)).c;
        l = ((a)g.get(0)).c;
        o = ((a)g.get(0)).d;
        p = ((a)g.get(0)).d;
        if (((a)g.get(0)).f > 0L)
        {
            r = (int)((long)(1000 * ((a)g.get(0)).e) / ((a)g.get(0)).f);
        }
        s = r;
        iterator = g.iterator();
_L8:
        if (iterator.hasNext()) goto _L6; else goto _L2
_L2:
        a a1;
        a1 = new a();
        a1.a = l1;
        g.add(a1);
        arraylist;
        JVM INSTR monitorexit ;
        return a1;
_L4:
        if (((a)g.get(k1)).f <= 0L && System.currentTimeMillis() - ((a)g.get(k1)).b <= 0x927c0L)
        {
            break; /* Loop/switch isn't completed */
        }
        g.remove(k1);
        boolean flag1;
        int j2;
        flag1 = true;
        j2 = k1;
          goto _L7
_L6:
        a a2 = (a)iterator.next();
        if (0L > h)
        {
            h = 0L;
        }
        if (0L < i)
        {
            i = 0L;
        }
        if (a2.c > k)
        {
            k = a2.c;
        }
        if (a2.c < l)
        {
            l = a2.c;
        }
        if (a2.d > o)
        {
            o = a2.d;
        }
        if (a2.d < p)
        {
            p = a2.d;
        }
        if (a2.f > 0L)
        {
            int i2 = (int)((long)(1000 * a2.e) / a2.f);
            if (i2 > r)
            {
                r = i2;
            }
            if (i2 < s)
            {
                s = i2;
            }
        }
          goto _L8
        Exception exception;
        exception;
        throw exception;
_L7:
        j1++;
        k1 = j2;
        flag = flag1;
        if (true) goto _L10; else goto _L9
_L9:
        int k2 = k1 + 1;
        boolean flag2 = flag;
        j2 = k2;
        flag1 = flag2;
        if (true) goto _L7; else goto _L11
_L11:
        if (true) goto _L10; else goto _L12
_L12:
    }

    public static void a(int i1)
    {
        ArrayList arraylist;
        Iterator iterator;
        a a1 = b(Thread.currentThread().getId());
        if (a1 == null)
        {
            return;
        }
        a1.f = System.currentTimeMillis() - a1.b;
        a1.b = System.currentTimeMillis();
        a1.e = i1;
        long l1;
        int j1;
        int k1;
        int i2;
        if (a1.f == 0L)
        {
            l1 = 1L;
        } else
        {
            l1 = a1.f;
        }
        j1 = (int)((long)(i1 * 1000) / l1);
        t = j1;
        if (j1 > r)
        {
            k1 = t;
        } else
        {
            k1 = r;
        }
        r = k1;
        if (t < s)
        {
            i2 = t;
        } else
        if (s == 0)
        {
            i2 = t;
        } else
        {
            i2 = s;
        }
        s = i2;
        if (g == null) goto _L2; else goto _L1
_L1:
        arraylist = g;
        arraylist;
        JVM INSTR monitorenter ;
        iterator = g.iterator();
_L3:
        if (iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_224;
        }
_L2:
        if (u > 0 && a1.c < (long)c && a1.d < (long)f)
        {
            u = -1 + u;
        }
        a1.g = (int)a1.c;
        return;
        a a2 = (a)iterator.next();
        a2.e;
        a2.f;
          goto _L3
        Exception exception;
        exception;
        throw exception;
    }

    public static void a(HttpURLConnection httpurlconnection)
    {
        a a1 = b(Thread.currentThread().getId());
        if (a1 == null)
        {
            a1 = a(Thread.currentThread().getId());
        }
        if (a1 == null)
        {
            return;
        } else
        {
            a1.b = System.currentTimeMillis();
            return;
        }
    }

    public static void a(boolean flag)
    {
        if (!flag)
        {
            u = 1 + u;
        }
        a a1 = c(Thread.currentThread().getId());
        if (a1 != null)
        {
            long _tmp = a1.b;
        }
    }

    public static int b()
    {
        int i1 = d;
        int j1;
        ConnectivityManager connectivitymanager;
        int k1;
        a a1;
        NetworkInfo networkinfo;
        if (n > 0L && o > 0L)
        {
            j1 = (int)((Math.max(q, n) + o) - p);
        } else
        {
            j1 = i1;
        }
        connectivitymanager = (ConnectivityManager)com.tencent.b.b.t.b().getSystemService("connectivity");
        if (connectivitymanager == null) goto _L2; else goto _L1
_L1:
        networkinfo = connectivitymanager.getActiveNetworkInfo();
        if (networkinfo == null) goto _L2; else goto _L3
_L3:
        if (networkinfo.isConnected() || !networkinfo.isAvailable()) goto _L5; else goto _L4
_L4:
        j1 = e;
_L2:
        k1 = j1 + u * c;
        if (k1 <= f)
        {
            k1 = f;
        }
        if ((long)k1 <= o)
        {
            k1 = (int)(o + (long)f);
        }
        if (k1 >= e)
        {
            k1 = e;
        }
        a1 = b(Thread.currentThread().getId());
        if (a1 != null)
        {
            if (k1 < a1.h + f)
            {
                k1 = a1.h + f;
            }
            if (k1 < a1.g + f)
            {
                k1 = a1.g + f;
            }
            a1.h = k1;
        }
        return k1;
_L5:
        if (o > 0L && o < (long)f)
        {
            j1 = f;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    private static a b(long l1)
    {
        if (g == null)
        {
            return null;
        }
        ArrayList arraylist = g;
        arraylist;
        JVM INSTR monitorenter ;
        Iterator iterator = g.iterator();
_L2:
        if (!iterator.hasNext())
        {
            return null;
        }
        a a1 = (a)iterator.next();
        if (a1.a != l1) goto _L2; else goto _L1
_L1:
        arraylist;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
    }

    private static a c(long l1)
    {
        if (g == null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = g;
        arraylist;
        JVM INSTR monitorenter ;
        int i1 = g.size();
        int j1 = i1 - 1;
_L5:
        if (j1 >= 0) goto _L3; else goto _L2
_L2:
        return null;
_L3:
        a a1;
        if (((a)g.get(j1)).a != l1)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        a1 = (a)g.remove(j1);
        arraylist;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
        j1--;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static void c()
    {
        a a1 = b(Thread.currentThread().getId());
        if (a1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Iterator iterator;
        int i1;
        a1.c = System.currentTimeMillis() - a1.b;
        a1.b = System.currentTimeMillis();
        m = a1.c;
        long l1;
        long l2;
        ArrayList arraylist;
        Exception exception;
        if (a1.c > k)
        {
            l1 = a1.c;
        } else
        {
            l1 = k;
        }
        k = l1;
        if (a1.c < l)
        {
            l2 = a1.c;
        } else
        if (l == 0L)
        {
            l2 = a1.c;
        } else
        {
            l2 = l;
        }
        l = l2;
        if (g == null) goto _L1; else goto _L3
_L3:
        arraylist = g;
        arraylist;
        JVM INSTR monitorenter ;
        iterator = g.iterator();
        i1 = 0;
_L5:
        if (iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_173;
        }
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        j /= i1;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
        a a2 = (a)iterator.next();
        if (a2.c <= 0L)
        {
            continue; /* Loop/switch isn't completed */
        }
        j += a2.c;
        i1++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static void d()
    {
        a a1 = b(Thread.currentThread().getId());
        if (a1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Iterator iterator;
        int i1;
        a1.d = System.currentTimeMillis() - a1.b;
        a1.b = System.currentTimeMillis();
        q = a1.d;
        long l1;
        long l2;
        ArrayList arraylist;
        Exception exception;
        if (a1.d > o)
        {
            l1 = a1.d;
        } else
        {
            l1 = o;
        }
        o = l1;
        if (a1.d < p)
        {
            l2 = a1.d;
        } else
        if (p == 0L)
        {
            l2 = a1.d;
        } else
        {
            l2 = p;
        }
        p = l2;
        if (g == null) goto _L1; else goto _L3
_L3:
        arraylist = g;
        arraylist;
        JVM INSTR monitorenter ;
        iterator = g.iterator();
        i1 = 0;
_L5:
        if (iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_173;
        }
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        n /= i1;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
        a a2 = (a)iterator.next();
        if (a2.d <= 0L)
        {
            continue; /* Loop/switch isn't completed */
        }
        n += a2.d;
        i1++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    static 
    {
        a = 12000;
        b = 20000;
        c = 8000;
        d = 20000;
        e = 25000;
        f = 15000;
        ConnectivityManager connectivitymanager = (ConnectivityManager)com.tencent.b.b.t.b().getSystemService("connectivity");
        if (connectivitymanager != null)
        {
            NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
            if (networkinfo != null)
            {
                int i1 = networkinfo.getType();
                if (networkinfo.isConnected() && i1 == 0)
                {
                    String s1 = ((TelephonyManager)com.tencent.b.b.t.b().getSystemService("phone")).getSubscriberId();
                    if (s1 != null && s1.length() > 3 && !s1.startsWith("46000") && !s1.startsWith("46002"))
                    {
                        a = 15000;
                        b = 25000;
                        c = 10000;
                        d = 25000;
                        e = 35000;
                        f = 15000;
                    }
                }
            }
        }
    }

    private class a
    {

        public long a;
        public long b;
        public long c;
        public long d;
        public int e;
        public long f;
        public int g;
        public int h;

        public a()
        {
        }
    }

}
