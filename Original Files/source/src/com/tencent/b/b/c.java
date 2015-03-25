// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.tencent.b.b:
//            l, o

public final class c
{

    private static c a;
    private long b;
    private List c;
    private List d;
    private String e;

    public c()
    {
        b = 0L;
        c = new ArrayList();
        d = new ArrayList();
    }

    public static c a()
    {
        if (a == null)
        {
            a = new c();
        }
        return a;
    }

    private static boolean a(StringBuffer stringbuffer)
    {
        double d1;
        int i;
        boolean flag;
        try
        {
            d1 = (new JSONObject(stringbuffer.toString())).getJSONObject("location").getDouble("accuracy");
        }
        catch (Exception exception)
        {
            return false;
        }
        i = d1 != 5000D;
        flag = false;
        if (i < 0)
        {
            flag = true;
        }
        return flag;
    }

    private boolean a(List list)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i;
label0:
        {
label1:
            {
                if (d == null)
                {
                    break label1;
                }
                int k = 0;
                i = 0;
                do
                {
                    if (k >= d.size())
                    {
                        break label0;
                    }
                    String s = ((l)d.get(k)).a;
                    int i1 = 0;
                    do
                    {
label2:
                        {
                            if (s != null && i1 < list.size())
                            {
                                if (!s.equals(((ScanResult)list.get(i1)).BSSID))
                                {
                                    break label2;
                                }
                                i++;
                            }
                            k++;
                        }
                        if (true)
                        {
                            break;
                        }
                        i1++;
                    } while (true);
                } while (true);
            }
            i = 0;
        }
        int j = list.size();
        if (j >= 6 && i >= 1 + j / 2)
        {
            return true;
        }
        if (j < 6 && i >= 2)
        {
            return true;
        }
        if (d.size() <= 2 && list.size() <= 2 && Math.abs(System.currentTimeMillis() - b) <= 30000L)
        {
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void a(int i, int j, int k, int i1, List list)
    {
        b = System.currentTimeMillis();
        e = null;
        c.clear();
        o o1 = new o((byte)0);
        o1.a = i;
        o1.b = j;
        o1.c = k;
        o1.d = i1;
        c.add(o1);
        if (list != null)
        {
            d.clear();
            for (int j1 = 0; j1 < list.size(); j1++)
            {
                l l1 = new l((byte)0);
                l1.a = ((ScanResult)list.get(j1)).BSSID;
                int _tmp = ((ScanResult)list.get(j1)).level;
                d.add(l1);
            }

        }
    }

    public final void a(String s)
    {
        e = s;
    }

    public final String b(int i, int j, int k, int i1, List list)
    {
        if (e != null && e.length() >= 10) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        String s = e;
        o o1;
        if (s == null || list == null)
        {
            s = null;
        } else
        {
            long l1 = Math.abs(System.currentTimeMillis() - b);
            if (l1 > 30000L && list.size() > 2 || l1 > 45000L && list.size() <= 2 || !a(new StringBuffer(s)))
            {
                s = null;
            }
        }
        e = s;
        if (e == null) goto _L1; else goto _L3
_L3:
        if (c == null || c.size() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        o1 = (o)c.get(0);
        if (o1.a != i || o1.b != j || o1.c != k || o1.d != i1) goto _L1; else goto _L4
_L4:
        if ((d == null || d.size() == 0) && (list == null || list.size() == 0))
        {
            return e;
        }
        if (a(list))
        {
            return e;
        }
        if (!a(list)) goto _L1; else goto _L5
_L5:
        return e;
    }

    public final void b()
    {
        e = null;
    }
}
