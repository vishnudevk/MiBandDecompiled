// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package android.support.v4.content:
//            l, m, n

public class LocalBroadcastManager
{

    static final int a = 1;
    private static final String b = "LocalBroadcastManager";
    private static final boolean c;
    private static final Object i = new Object();
    private static LocalBroadcastManager j;
    private final Context d;
    private final HashMap e = new HashMap();
    private final HashMap f = new HashMap();
    private final ArrayList g = new ArrayList();
    private final Handler h;

    private LocalBroadcastManager(Context context)
    {
        d = context;
        h = new l(this, context.getMainLooper());
    }

    private void a()
    {
_L4:
        HashMap hashmap = e;
        hashmap;
        JVM INSTR monitorenter ;
        int k = g.size();
        if (k > 0)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        hashmap;
        JVM INSTR monitorexit ;
        return;
        m am[];
        am = new m[k];
        g.toArray(am);
        g.clear();
        hashmap;
        JVM INSTR monitorexit ;
        int i1 = 0;
_L2:
        if (i1 < am.length)
        {
            m m1 = am[i1];
            for (int j1 = 0; j1 < m1.b.size(); j1++)
            {
                ((n)m1.b.get(j1)).b.onReceive(d, m1.a);
            }

            break MISSING_BLOCK_LABEL_120;
        }
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void a(LocalBroadcastManager localbroadcastmanager)
    {
        localbroadcastmanager.a();
    }

    public static LocalBroadcastManager getInstance(Context context)
    {
        LocalBroadcastManager localbroadcastmanager;
        synchronized (i)
        {
            if (j == null)
            {
                j = new LocalBroadcastManager(context.getApplicationContext());
            }
            localbroadcastmanager = j;
        }
        return localbroadcastmanager;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter)
    {
        HashMap hashmap = e;
        hashmap;
        JVM INSTR monitorenter ;
        n n1;
        ArrayList arraylist;
        n1 = new n(intentfilter, broadcastreceiver);
        arraylist = (ArrayList)e.get(broadcastreceiver);
        if (arraylist != null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        arraylist = new ArrayList(1);
        e.put(broadcastreceiver, arraylist);
        arraylist.add(intentfilter);
        int k = 0;
_L2:
        String s;
        ArrayList arraylist1;
        if (k >= intentfilter.countActions())
        {
            break; /* Loop/switch isn't completed */
        }
        s = intentfilter.getAction(k);
        arraylist1 = (ArrayList)f.get(s);
        if (arraylist1 != null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        arraylist1 = new ArrayList(1);
        f.put(s, arraylist1);
        arraylist1.add(n1);
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        hashmap;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean sendBroadcast(Intent intent)
    {
        HashMap hashmap = e;
        hashmap;
        JVM INSTR monitorenter ;
        String s;
        String s1;
        android.net.Uri uri;
        String s2;
        java.util.Set set;
        s = intent.getAction();
        s1 = intent.resolveTypeIfNeeded(d.getContentResolver());
        uri = intent.getData();
        s2 = intent.getScheme();
        set = intent.getCategories();
        ArrayList arraylist1;
        int i1;
        ArrayList arraylist2;
        String s3;
        Exception exception;
        boolean flag;
        ArrayList arraylist;
        int k;
        n n1;
        int j1;
        if ((8 & intent.getFlags()) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        Log.v("LocalBroadcastManager", (new StringBuilder()).append("Resolving type ").append(s1).append(" scheme ").append(s2).append(" of intent ").append(intent).toString());
        arraylist = (ArrayList)f.get(intent.getAction());
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        Log.v("LocalBroadcastManager", (new StringBuilder()).append("Action list: ").append(arraylist).toString());
          goto _L4
_L24:
        if (k >= arraylist.size()) goto _L6; else goto _L5
_L5:
        n1 = (n)arraylist.get(k);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        Log.v("LocalBroadcastManager", (new StringBuilder()).append("Matching against filter ").append(n1.a).toString());
        if (!n1.c) goto _L8; else goto _L7
_L7:
        if (!flag) goto _L10; else goto _L9
_L9:
        Log.v("LocalBroadcastManager", "  Filter's target already added");
        arraylist2 = arraylist1;
          goto _L11
_L8:
        j1 = n1.a.match(s, s1, s2, uri, set, "LocalBroadcastManager");
        if (j1 < 0) goto _L13; else goto _L12
_L12:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_307;
        }
        Log.v("LocalBroadcastManager", (new StringBuilder()).append("  Filter matched!  match=0x").append(Integer.toHexString(j1)).toString());
        if (arraylist1 != null) goto _L15; else goto _L14
_L14:
        arraylist2 = new ArrayList();
_L23:
        arraylist2.add(n1);
        n1.c = true;
          goto _L11
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
_L13:
        if (!flag) goto _L10; else goto _L16
_L16:
        j1;
        JVM INSTR tableswitch -4 -1: default 380
    //                   -4 535
    //                   -3 528
    //                   -2 542
    //                   -1 549;
           goto _L17 _L18 _L19 _L20 _L21
_L17:
        s3 = "unknown reason";
_L25:
        Log.v("LocalBroadcastManager", (new StringBuilder()).append("  Filter did not match: ").append(s3).toString());
          goto _L10
_L22:
        if (i1 >= arraylist1.size())
        {
            break MISSING_BLOCK_LABEL_443;
        }
        ((n)arraylist1.get(i1)).c = false;
        i1++;
          goto _L22
        g.add(new m(intent, arraylist1));
        if (!h.hasMessages(1))
        {
            h.sendEmptyMessage(1);
        }
        hashmap;
        JVM INSTR monitorexit ;
        return true;
_L2:
        hashmap;
        JVM INSTR monitorexit ;
        return false;
_L15:
        arraylist2 = arraylist1;
          goto _L23
_L4:
        arraylist1 = null;
        k = 0;
          goto _L24
_L11:
        k++;
        arraylist1 = arraylist2;
          goto _L24
_L10:
        arraylist2 = arraylist1;
          goto _L11
_L19:
        s3 = "action";
          goto _L25
_L18:
        s3 = "category";
          goto _L25
_L20:
        s3 = "data";
          goto _L25
_L21:
        s3 = "type";
          goto _L25
_L6:
        if (arraylist1 == null) goto _L2; else goto _L26
_L26:
        i1 = 0;
          goto _L22
    }

    public void sendBroadcastSync(Intent intent)
    {
        if (sendBroadcast(intent))
        {
            a();
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastreceiver)
    {
        HashMap hashmap = e;
        hashmap;
        JVM INSTR monitorenter ;
        ArrayList arraylist = (ArrayList)e.remove(broadcastreceiver);
        if (arraylist != null) goto _L2; else goto _L1
_L1:
        hashmap;
        JVM INSTR monitorexit ;
        return;
_L16:
        int k;
        if (k >= arraylist.size()) goto _L4; else goto _L3
_L3:
        IntentFilter intentfilter = (IntentFilter)arraylist.get(k);
        int i1 = 0;
_L14:
        String s;
        ArrayList arraylist1;
        if (i1 >= intentfilter.countActions())
        {
            break; /* Loop/switch isn't completed */
        }
        s = intentfilter.getAction(i1);
        arraylist1 = (ArrayList)f.get(s);
        if (arraylist1 == null) goto _L6; else goto _L5
_L5:
        int j1 = 0;
_L12:
        if (j1 >= arraylist1.size()) goto _L8; else goto _L7
_L7:
        if (((n)arraylist1.get(j1)).b != broadcastreceiver) goto _L10; else goto _L9
_L9:
        arraylist1.remove(j1);
        int k1 = j1 - 1;
          goto _L11
_L8:
        if (arraylist1.size() <= 0)
        {
            f.remove(s);
        }
        break; /* Loop/switch isn't completed */
_L4:
        hashmap;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
_L10:
        k1 = j1;
          goto _L11
_L2:
        k = 0;
        continue; /* Loop/switch isn't completed */
_L11:
        j1 = k1 + 1;
        if (true) goto _L12; else goto _L6
_L6:
        i1++;
        if (true) goto _L14; else goto _L13
_L13:
        k++;
        if (true) goto _L16; else goto _L15
_L15:
    }

}
