// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TreeMap;

// Referenced classes of package com.aps:
//            bb, B, E, C, 
//            D

public final class ai
{

    private static int C = 10000;
    private static ai t = null;
    private Thread A;
    private Looper B;
    private Context a;
    private TelephonyManager b;
    private LocationManager c;
    private WifiManager d;
    private String e;
    private String f;
    private String g;
    private boolean h;
    private int i;
    private boolean j;
    private long k;
    private String l;
    private String m;
    private int n;
    private int o;
    private int p;
    private String q;
    private long r;
    private long s;
    private C u;
    private D v;
    private CellLocation w;
    private E x;
    private List y;
    private Timer z;

    private ai(Context context)
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = "";
        f = "";
        g = "";
        h = false;
        i = 0;
        j = false;
        k = -1L;
        l = "";
        m = "";
        n = 0;
        o = 0;
        p = 0;
        q = "";
        r = 0L;
        s = 0L;
        u = null;
        v = null;
        w = null;
        x = null;
        y = new ArrayList();
        z = null;
        A = null;
        B = null;
        if (context != null)
        {
            a = context;
            e = Build.MODEL;
            b = (TelephonyManager)context.getSystemService("phone");
            c = (LocationManager)context.getSystemService("location");
            d = (WifiManager)context.getSystemService("wifi");
            context.getSystemService("sensor");
            if (b != null && d != null)
            {
                String as[];
                boolean flag;
                try
                {
                    f = b.getDeviceId();
                }
                catch (Exception exception) { }
                g = b.getSubscriberId();
                if (d.getConnectionInfo() != null)
                {
                    m = d.getConnectionInfo().getMacAddress();
                    if (m != null && m.length() > 0)
                    {
                        m = m.replace(":", "");
                    }
                }
                as = b(b);
                n = Integer.parseInt(as[0]);
                o = Integer.parseInt(as[1]);
                p = b.getNetworkType();
                q = context.getPackageName();
                if (b.getPhoneType() == 2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                h = flag;
                return;
            }
        }
    }

    static int a(ai ai1, int i1)
    {
        ai1.n = i1;
        return i1;
    }

    static long a(ai ai1, long l1)
    {
        ai1.r = l1;
        return l1;
    }

    static Looper a(ai ai1, Looper looper)
    {
        ai1.B = looper;
        return looper;
    }

    static CellLocation a(ai ai1, CellLocation celllocation)
    {
        ai1.w = celllocation;
        return celllocation;
    }

    static C a(ai ai1)
    {
        return ai1.u;
    }

    static C a(ai ai1, C c1)
    {
        ai1.u = c1;
        return c1;
    }

    static D a(ai ai1, D d1)
    {
        ai1.v = d1;
        return d1;
    }

    protected static ai a(Context context)
    {
        if (t != null || !c(context)) goto _L2; else goto _L1
_L1:
        LocationManager locationmanager = (LocationManager)context.getSystemService("location");
        if (locationmanager == null) goto _L4; else goto _L3
_L3:
        Iterator iterator = locationmanager.getAllProviders().iterator();
_L7:
        if (!iterator.hasNext()) goto _L4; else goto _L5
_L5:
        String s1 = (String)iterator.next();
        if (!s1.equals("passive") && !s1.equals("gps")) goto _L7; else goto _L6
_L6:
        boolean flag = true;
_L9:
        if (flag)
        {
            t = new ai(context);
        }
_L2:
        return t;
_L4:
        flag = false;
        if (true) goto _L9; else goto _L8
_L8:
    }

    static String a(ai ai1, String s1)
    {
        ai1.l = s1;
        return s1;
    }

    static Timer a(ai ai1, Timer timer)
    {
        ai1.z = timer;
        return timer;
    }

    private void a(BroadcastReceiver broadcastreceiver)
    {
        if (broadcastreceiver == null || a == null)
        {
            return;
        } else
        {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.net.wifi.SCAN_RESULTS");
            a.registerReceiver(broadcastreceiver, intentfilter);
            return;
        }
    }

    static void a(ai ai1, android.location.GpsStatus.NmeaListener nmealistener)
    {
        if (ai1.c == null || nmealistener == null)
        {
            return;
        } else
        {
            ai1.c.addNmeaListener(nmealistener);
            return;
        }
    }

    static void a(ai ai1, PhoneStateListener phonestatelistener)
    {
        if (ai1.b != null)
        {
            ai1.b.listen(phonestatelistener, 273);
        }
    }

    private static void a(List list)
    {
        if (list == null || list.size() <= 0)
        {
            return;
        }
        HashMap hashmap = new HashMap();
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            ScanResult scanresult = (ScanResult)list.get(i1);
            if (scanresult.SSID == null)
            {
                scanresult.SSID = "null";
            }
            hashmap.put(Integer.valueOf(scanresult.level), scanresult);
        }

        TreeMap treemap = new TreeMap(Collections.reverseOrder());
        treemap.putAll(hashmap);
        list.clear();
        for (Iterator iterator = treemap.keySet().iterator(); iterator.hasNext(); list.add(treemap.get((Integer)iterator.next()))) { }
        hashmap.clear();
        treemap.clear();
    }

    static boolean a(ai ai1, boolean flag)
    {
        ai1.j = flag;
        return flag;
    }

    static String[] a(TelephonyManager telephonymanager)
    {
        return b(telephonymanager);
    }

    static int b(ai ai1, int i1)
    {
        ai1.o = i1;
        return i1;
    }

    static long b(ai ai1, long l1)
    {
        ai1.s = l1;
        return l1;
    }

    static D b(ai ai1)
    {
        return ai1.v;
    }

    private void b(BroadcastReceiver broadcastreceiver)
    {
        if (broadcastreceiver == null || a == null)
        {
            return;
        }
        try
        {
            a.unregisterReceiver(broadcastreceiver);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    protected static boolean b(Context context)
    {
        if (context == null)
        {
            return false;
        }
        if (android.provider.Settings.Secure.getString(context.getContentResolver(), "mock_location").equals("0")) goto _L2; else goto _L1
_L1:
        boolean flag;
        PackageManager packagemanager;
        String s1;
        Iterator iterator;
        packagemanager = context.getPackageManager();
        List list = packagemanager.getInstalledApplications(128);
        s1 = context.getPackageName();
        iterator = list.iterator();
        flag = false;
_L11:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        ApplicationInfo applicationinfo = (ApplicationInfo)iterator.next();
        if (flag) goto _L4; else goto _L5
_L5:
        String as[] = packagemanager.getPackageInfo(applicationinfo.packageName, 4096).requestedPermissions;
        if (as == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        int i1 = as.length;
        int j1 = 0;
_L8:
        if (j1 >= i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!as[j1].equals("android.permission.ACCESS_MOCK_LOCATION")) goto _L7; else goto _L6
_L6:
        boolean flag2 = applicationinfo.packageName.equals(s1);
        boolean flag1;
        if (flag2)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag1 = true;
_L9:
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L7:
        j1++;
          goto _L8
        Exception exception;
        exception;
        flag1 = flag;
          goto _L9
_L2:
        flag = false;
_L4:
        return flag;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private static String[] b(TelephonyManager telephonymanager)
    {
        int i1 = 0;
        String s1 = null;
        if (telephonymanager != null)
        {
            s1 = telephonymanager.getNetworkOperator();
        }
        String as[] = {
            "0", "0"
        };
        if (TextUtils.isDigitsOnly(s1) && s1.length() > 4)
        {
            as[0] = s1.substring(0, 3);
            for (char ac[] = s1.substring(3).toCharArray(); i1 < ac.length && Character.isDigit(ac[i1]); i1++) { }
            as[1] = s1.substring(3, i1 + 3);
        }
        return as;
    }

    static int c(ai ai1, int i1)
    {
        ai1.i = i1;
        return i1;
    }

    static long c(ai ai1, long l1)
    {
        ai1.k = l1;
        return l1;
    }

    static WifiManager c(ai ai1)
    {
        return ai1.d;
    }

    private static boolean c(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        PackageInfo packageinfo;
        String as[];
        try
        {
            packageinfo = packagemanager.getPackageInfo(context.getPackageName(), 4096);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return false;
        }
        as = packageinfo.requestedPermissions;
        for (int i1 = 0; i1 < bb.a.length; i1++)
        {
            if (!bb.a(as, bb.a[i1]))
            {
                return false;
            }
        }

        return true;
    }

    static Timer d(ai ai1)
    {
        return ai1.z;
    }

    static List e(ai ai1)
    {
        return ai1.y;
    }

    static TelephonyManager f(ai ai1)
    {
        return ai1.b;
    }

    static boolean g(ai ai1)
    {
        return ai1.h;
    }

    static int h(ai ai1)
    {
        return ai1.i;
    }

    static int y()
    {
        return C;
    }

    private void z()
    {
        if (d == null)
        {
            return;
        } else
        {
            d.startScan();
            return;
        }
    }

    protected final List a(float f1)
    {
        ArrayList arraylist;
label0:
        {
            arraylist = new ArrayList();
            long l1 = System.currentTimeMillis();
            if (Math.abs(f1) <= 1.0F)
            {
                f1 = 1.0F;
            }
            if (c())
            {
                CellLocation celllocation = (CellLocation)j().get(1);
                if (celllocation != null && (celllocation instanceof GsmCellLocation))
                {
                    arraylist.add(Integer.valueOf(((GsmCellLocation)celllocation).getLac()));
                    arraylist.add(Integer.valueOf(((GsmCellLocation)celllocation).getCid()));
                    if ((double)(l1 - ((Long)j().get(0)).longValue()) > 50000D / (double)f1)
                    {
                        break label0;
                    }
                    arraylist.add(Integer.valueOf(1));
                }
            }
            return arraylist;
        }
        arraylist.add(Integer.valueOf(0));
        return arraylist;
    }

    protected final void a()
    {
        b();
        if (B != null)
        {
            B.quit();
            B = null;
        }
        if (A != null)
        {
            A.interrupt();
            A = null;
        }
        A = new B(this, "");
        A.start();
    }

    protected final List b(float f1)
    {
        ArrayList arraylist;
label0:
        {
            arraylist = new ArrayList();
            long l1 = System.currentTimeMillis();
            if (Math.abs(f1) <= 1.0F)
            {
                f1 = 1.0F;
            }
            if (c())
            {
                CellLocation celllocation = (CellLocation)j().get(1);
                if (celllocation != null && (celllocation instanceof CdmaCellLocation))
                {
                    CdmaCellLocation cdmacelllocation = (CdmaCellLocation)celllocation;
                    arraylist.add(Integer.valueOf(cdmacelllocation.getSystemId()));
                    arraylist.add(Integer.valueOf(cdmacelllocation.getNetworkId()));
                    arraylist.add(Integer.valueOf(cdmacelllocation.getBaseStationId()));
                    arraylist.add(Integer.valueOf(cdmacelllocation.getBaseStationLongitude()));
                    arraylist.add(Integer.valueOf(cdmacelllocation.getBaseStationLatitude()));
                    if ((double)(l1 - ((Long)j().get(0)).longValue()) > 50000D / (double)f1)
                    {
                        break label0;
                    }
                    arraylist.add(Integer.valueOf(1));
                }
            }
            return arraylist;
        }
        arraylist.add(Integer.valueOf(0));
        return arraylist;
    }

    protected final void b()
    {
        if (u != null)
        {
            C c1 = u;
            if (b != null)
            {
                b.listen(c1, 0);
            }
            u = null;
        }
        if (v != null)
        {
            D d1 = v;
            if (c != null && d1 != null)
            {
                c.removeNmeaListener(d1);
            }
            v = null;
        }
        if (z != null)
        {
            z.cancel();
            z = null;
        }
        if (B != null)
        {
            B.quit();
            B = null;
        }
        if (A != null)
        {
            A.interrupt();
            A = null;
        }
    }

    protected final boolean c()
    {
        if (b != null && b.getSimState() == 5 && j)
        {
            return true;
        }
        if (b == null) goto _L2; else goto _L1
_L1:
        CellLocation celllocation1 = b.getCellLocation();
        CellLocation celllocation = celllocation1;
_L4:
        if (celllocation != null)
        {
            s = System.currentTimeMillis();
            w = celllocation;
            return true;
        }
_L2:
        return false;
        Exception exception;
        exception;
        celllocation = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final boolean d()
    {
        return d != null && d.isWifiEnabled();
    }

    protected final boolean e()
    {
        boolean flag;
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        flag = c.isProviderEnabled("gps");
        if (flag)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        return false;
    }

    protected final String f()
    {
        if (e == null)
        {
            e = Build.MODEL;
        }
        if (e != null)
        {
            return e;
        } else
        {
            return "";
        }
    }

    protected final String g()
    {
        if (f == null && a != null)
        {
            b = (TelephonyManager)a.getSystemService("phone");
            if (b != null)
            {
                f = b.getDeviceId();
            }
        }
        if (f != null)
        {
            return f;
        } else
        {
            return "";
        }
    }

    protected final String h()
    {
        if (g == null && a != null)
        {
            b = (TelephonyManager)a.getSystemService("phone");
            if (b != null)
            {
                g = b.getSubscriberId();
            }
        }
        if (g != null)
        {
            return g;
        } else
        {
            return "";
        }
    }

    protected final boolean i()
    {
        return h;
    }

    protected final List j()
    {
        if (android.provider.Settings.System.getInt(a.getContentResolver(), "airplane_mode_on", 0) == 1)
        {
            return new ArrayList();
        }
        if (c())
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(Long.valueOf(s));
            arraylist.add(w);
            return arraylist;
        } else
        {
            return new ArrayList();
        }
    }

    protected final List k()
    {
        int i1;
        ArrayList arraylist;
        i1 = 0;
        arraylist = new ArrayList();
        if (!d())
        {
            break MISSING_BLOCK_LABEL_119;
        }
        ArrayList arraylist1 = new ArrayList();
        this;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (System.currentTimeMillis() - r < 3500L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        arraylist1.add(Long.valueOf(r));
_L1:
        if (i1 >= y.size())
        {
            break MISSING_BLOCK_LABEL_100;
        }
        arraylist.add(y.get(i1));
        i1++;
          goto _L1
        arraylist1.add(arraylist);
        this;
        JVM INSTR monitorexit ;
        return arraylist1;
        exception;
        throw exception;
        return new ArrayList();
    }

    protected final byte l()
    {
        if (c())
        {
            return (byte)i;
        } else
        {
            return -128;
        }
    }

    protected final List m()
    {
        ArrayList arraylist = new ArrayList();
        if (b == null)
        {
            return arraylist;
        }
        if (!c())
        {
            return arraylist;
        }
        Iterator iterator = b.getNeighboringCellInfo().iterator();
        int i1 = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            NeighboringCellInfo neighboringcellinfo = (NeighboringCellInfo)iterator.next();
            if (i1 > 15)
            {
                break;
            }
            if (neighboringcellinfo.getLac() != 0 && neighboringcellinfo.getLac() != 65535 && neighboringcellinfo.getCid() != 65535 && neighboringcellinfo.getCid() != 0xfffffff)
            {
                arraylist.add(neighboringcellinfo);
                i1++;
            }
        } while (true);
        return arraylist;
    }

    protected final List n()
    {
        ArrayList arraylist = new ArrayList();
        long l1;
        String s1;
        if (e())
        {
            long l2 = k;
            String s2 = l;
            l1 = l2;
            s1 = s2;
        } else
        {
            l1 = -1L;
            s1 = "";
        }
        if (l1 <= 0L)
        {
            l1 = System.currentTimeMillis() / 1000L;
        }
        if (l1 > 0x7fffffffL)
        {
            l1 /= 1000L;
        }
        arraylist.add(Long.valueOf(l1));
        arraylist.add(s1);
        return arraylist;
    }

    protected final long o()
    {
        long l1 = 0L;
        long l2 = k;
        if (l2 > l1)
        {
            int i1 = String.valueOf(l2).length();
            l1 = l2;
            int j1 = i1;
            while (j1 != 13) 
            {
                if (j1 > 13)
                {
                    l1 /= 10L;
                } else
                {
                    l1 *= 10L;
                }
                j1 = String.valueOf(l1).length();
            }
        }
        return l1;
    }

    protected final String p()
    {
        if (m == null && a != null)
        {
            d = (WifiManager)a.getSystemService("wifi");
            if (d != null && d.getConnectionInfo() != null)
            {
                m = d.getConnectionInfo().getMacAddress();
                if (m != null && m.length() > 0)
                {
                    m = m.replace(":", "");
                }
            }
        }
        if (m != null)
        {
            return m;
        } else
        {
            return "";
        }
    }

    protected final int q()
    {
        return n;
    }

    protected final int r()
    {
        return o;
    }

    protected final int s()
    {
        return p;
    }

    protected final String t()
    {
        if (q == null && a != null)
        {
            q = a.getPackageName();
        }
        if (q != null)
        {
            return q;
        } else
        {
            return "";
        }
    }

    protected final List u()
    {
        ArrayList arraylist = new ArrayList();
        if (d())
        {
            List list = k();
            List list1 = (List)list.get(1);
            long l1 = ((Long)list.get(0)).longValue();
            a(list1);
            arraylist.add(Long.valueOf(l1));
            if (list1 != null)
            {
                int i1 = list1.size();
                int j1 = 0;
                if (i1 > 0)
                {
                    for (; j1 < list1.size(); j1++)
                    {
                        ScanResult scanresult = (ScanResult)list1.get(j1);
                        if (-1 + arraylist.size() >= 40)
                        {
                            break;
                        }
                        if (scanresult != null)
                        {
                            ArrayList arraylist1 = new ArrayList();
                            arraylist1.add(scanresult.BSSID.replace(":", ""));
                            arraylist1.add(Integer.valueOf(scanresult.level));
                            arraylist1.add(scanresult.SSID);
                            arraylist.add(arraylist1);
                        }
                    }

                }
            }
        }
        return arraylist;
    }

    protected final void v()
    {
        this;
        JVM INSTR monitorenter ;
        y.clear();
        this;
        JVM INSTR monitorexit ;
        if (x != null)
        {
            b(x);
            x = null;
        }
        if (z != null)
        {
            z.cancel();
            z = null;
        }
        z = new Timer();
        x = new E(this, (byte)0);
        a(x);
        z();
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected final void w()
    {
        this;
        JVM INSTR monitorenter ;
        y.clear();
        this;
        JVM INSTR monitorexit ;
        if (x != null)
        {
            b(x);
            x = null;
        }
        if (z != null)
        {
            z.cancel();
            z = null;
        }
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected final Context x()
    {
        return a;
    }

}
