// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.tencent.b.b:
//            w

public final class f
{

    private Context a;
    private WifiManager b;
    private c c;
    private Handler d;
    private Runnable e;
    private int f;
    private a g;
    private b h;
    private boolean i;
    private byte j[];

    public f()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = new w(this);
        f = 1;
        g = null;
        h = null;
        i = false;
        j = new byte[0];
    }

    static b a(f f1, b b1)
    {
        f1.h = b1;
        return b1;
    }

    static void a(f f1)
    {
        if (f1.b != null && f1.b.isWifiEnabled())
        {
            f1.b.startScan();
        }
    }

    static a b(f f1)
    {
        return f1.g;
    }

    static WifiManager c(f f1)
    {
        return f1.b;
    }

    static b d(f f1)
    {
        return f1.h;
    }

    static int e(f f1)
    {
        return f1.f;
    }

    public final void a()
    {
label0:
        {
            synchronized (j)
            {
                if (i)
                {
                    break label0;
                }
            }
            return;
        }
        if (a != null && c != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        abyte0;
        JVM INSTR monitorexit ;
        return;
        try
        {
            a.unregisterReceiver(c);
        }
        catch (Exception exception1) { }
        d.removeCallbacks(e);
        i = false;
        abyte0;
        JVM INSTR monitorexit ;
    }

    public final void a(long l)
    {
        if (d != null && i)
        {
            d.removeCallbacks(e);
            d.postDelayed(e, l);
        }
    }

    public final boolean a(Context context, a a1, int k)
    {
label0:
        {
            synchronized (j)
            {
                if (!i)
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
        d = new Handler(Looper.getMainLooper());
        a = context;
        g = a1;
        f = 1;
        IntentFilter intentfilter;
        c c1;
        b = (WifiManager)a.getSystemService("wifi");
        intentfilter = new IntentFilter();
        c = new c();
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        c1 = c;
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        abyte0;
        JVM INSTR monitorexit ;
        return false;
        intentfilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentfilter.addAction("android.net.wifi.SCAN_RESULTS");
        a.registerReceiver(c, intentfilter);
        a(0L);
        i = true;
        abyte0;
        JVM INSTR monitorexit ;
        return i;
        Exception exception1;
        exception1;
        abyte0;
        JVM INSTR monitorexit ;
        return false;
        exception;
        throw exception;
    }

    public final boolean b()
    {
        return i;
    }

    public final boolean c()
    {
        if (a == null || b == null)
        {
            return false;
        } else
        {
            return b.isWifiEnabled();
        }
    }

    private class c extends BroadcastReceiver
    {

        private int a;
        private List b;
        private boolean c;
        private f d;

        private void a(List list)
        {
            if (list != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
label0:
            {
                if (!c)
                {
                    break label0;
                }
                if (b == null)
                {
                    b = new ArrayList();
                }
                int k = b.size();
                Iterator iterator1 = list.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    ScanResult scanresult1 = (ScanResult)iterator1.next();
                    int l = 0;
                    do
                    {
label1:
                        {
                            if (l < k)
                            {
                                if (!((ScanResult)b.get(l)).BSSID.equals(scanresult1.BSSID))
                                {
                                    break label1;
                                }
                                b.remove(l);
                            }
                            b.add(scanresult1);
                        }
                        if (true)
                        {
                            break;
                        }
                        l++;
                    } while (true);
                } while (true);
            }
            Iterator iterator;
            if (b == null)
            {
                b = new ArrayList();
            } else
            {
                b.clear();
            }
            iterator = list.iterator();
            while (iterator.hasNext()) 
            {
                ScanResult scanresult = (ScanResult)iterator.next();
                b.add(scanresult);
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public final void onReceive(Context context, Intent intent)
        {
            List list;
label0:
            {
                if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED"))
                {
                    a = intent.getIntExtra("wifi_state", 4);
                    if (f.b(d) != null)
                    {
                        f.b(d).b(a);
                    }
                }
                if (intent.getAction().equals("android.net.wifi.SCAN_RESULTS") || intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED"))
                {
                    WifiManager wifimanager = f.c(d);
                    list = null;
                    if (wifimanager != null)
                    {
                        list = f.c(d).getScanResults();
                    }
                    if (!intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED") || list != null && (list == null || list.size() != 0))
                    {
                        break label0;
                    }
                }
                return;
            }
            if (!c && b != null && b.size() >= 4 && list != null && list.size() <= 2)
            {
                a(list);
                c = true;
                d.a(0L);
                return;
            }
            a(list);
            c = false;
            f.a(d, d. new b(b, System.currentTimeMillis(), a));
            if (f.b(d) != null)
            {
                f.b(d).a(f.d(d));
            }
            d.a(20000L * (long)f.e(d));
        }

        public c()
        {
            d = f.this;
            super();
            a = 4;
            b = null;
            c = false;
        }

        private class a
        {

            public abstract void a(b b1);

            public abstract void b(int k);
        }


        private class b
            implements Cloneable
        {

            private List a;

            public final List a()
            {
                return a;
            }

            public final Object clone()
            {
                b b1;
                try
                {
                    b1 = (b)super.clone();
                }
                catch (Exception exception)
                {
                    b1 = null;
                }
                if (a != null)
                {
                    b1.a = new ArrayList();
                    b1.a.addAll(a);
                }
                return b1;
            }

            public b(List list, long l, int k)
            {
                a = null;
                if (list != null)
                {
                    a = new ArrayList();
                    ScanResult scanresult;
                    for (Iterator iterator = list.iterator(); iterator.hasNext(); a.add(scanresult))
                    {
                        scanresult = (ScanResult)iterator.next();
                    }

                }
            }
        }

    }

}
