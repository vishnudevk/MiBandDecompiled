// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.tencent.b.b:
//            f

public final class c extends BroadcastReceiver
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
            int i = b.size();
            Iterator iterator1 = list.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                ScanResult scanresult1 = (ScanResult)iterator1.next();
                int j = 0;
                do
                {
label1:
                    {
                        if (j < i)
                        {
                            if (!((ScanResult)b.get(j)).BSSID.equals(scanresult1.BSSID))
                            {
                                break label1;
                            }
                            b.remove(j);
                        }
                        b.add(scanresult1);
                    }
                    if (true)
                    {
                        break;
                    }
                    j++;
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
        f.a(d, new <init>(d, b, System.currentTimeMillis(), a));
        if (f.b(d) != null)
        {
            f.b(d).a(f.d(d));
        }
        d.a(20000L * (long)f.e(d));
    }

    public nt(f f1)
    {
        d = f1;
        super();
        a = 4;
        b = null;
        c = false;
    }
}
