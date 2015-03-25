// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.telephony.CellLocation;
import java.util.List;

// Referenced classes of package com.aps:
//            ba, ax, ai, ay, 
//            az

public final class aw
{

    private static int c = 10;
    private static int d = 100;
    private static float f = 0.5F;
    protected ba a;
    protected ax b;
    private ai e;

    protected aw(ai ai1)
    {
        a = new ba(this);
        b = new ax(this);
        e = ai1;
    }

    protected static void a()
    {
    }

    protected static void a(int i)
    {
        c = i;
    }

    protected static void b(int i)
    {
        d = i;
    }

    protected final boolean a(Location location)
    {
        ai ai1 = e;
        boolean flag = false;
        if (ai1 != null)
        {
            List list = e.j();
            flag = false;
            if (list != null)
            {
                flag = false;
                if (location != null)
                {
                    (new StringBuilder("cell.list.size: ")).append(list.size()).toString();
                    int i = list.size();
                    ay ay1 = null;
                    flag = false;
                    if (i >= 2)
                    {
                        ay ay2 = new ay((CellLocation)list.get(1));
                        if (b.b == null)
                        {
                            ay1 = ay2;
                            flag = true;
                        } else
                        {
                            boolean flag1;
                            if (location.distanceTo(b.b) > (float)d)
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            if (!flag1)
                            {
                                ay ay3 = b.a;
                                boolean flag2;
                                if (ay2.e == ay3.e && ay2.d == ay3.d && ay2.c == ay3.c && ay2.b == ay3.b && ay2.a == ay3.a)
                                {
                                    flag2 = true;
                                } else
                                {
                                    flag2 = false;
                                }
                                if (!flag2)
                                {
                                    flag1 = true;
                                } else
                                {
                                    flag1 = false;
                                }
                            }
                            (new StringBuilder("collect cell?: ")).append(flag1).toString();
                            flag = flag1;
                            ay1 = ay2;
                        }
                    }
                    if (flag)
                    {
                        b.a = ay1;
                        return flag;
                    }
                }
            }
        }
        return flag;
    }

    protected final boolean b(Location location)
    {
        int i;
        List list2;
        i = 0;
        if (e == null)
        {
            return false;
        }
        List list = e.k();
        if (list.size() < 2)
        {
            break MISSING_BLOCK_LABEL_439;
        }
        list2 = (List)list.get(1);
        if (a.b != null) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L17:
        List list1 = list2;
          goto _L3
_L2:
        if (list2 == null || list2.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_429;
        }
        if (location.distanceTo(a.b) > (float)c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_422;
        }
        list3 = a.a;
        f1 = f;
        if (list2 == null || list3 == null)
        {
            flag1 = false;
        } else
        if (list2 == null || list3 == null)
        {
            flag1 = false;
        } else
        {
            k = list2.size();
            l = list3.size();
            f2 = k + l;
            if (k == 0 && l == 0)
            {
                flag1 = true;
            } else
            {
label0:
                {
                    if (k != 0 && l != 0)
                    {
                        break label0;
                    }
                    flag1 = false;
                }
            }
        }
_L13:
        int j1;
        int k1;
        int i1;
        String s;
        int l1;
        if (!flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        continue; /* Loop/switch isn't completed */
        i1 = 0;
        j1 = 0;
_L11:
        if (i1 >= k) goto _L5; else goto _L4
_L4:
        s = ((ScanResult)list2.get(i1)).BSSID;
        if (s == null) goto _L7; else goto _L6
_L6:
        l1 = 0;
_L12:
        if (l1 >= l) goto _L7; else goto _L8
_L8:
        if (!s.equals(((az)list3.get(l1)).a)) goto _L10; else goto _L9
_L9:
        k1 = j1 + 1;
_L14:
        i1++;
        j1 = k1;
          goto _L11
_L10:
        l1++;
          goto _L12
_L5:
        if ((float)(j1 << 1) >= f2 * f1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
          goto _L13
_L3:
        List list3;
        float f1;
        boolean flag1;
        int k;
        int l;
        float f2;
        if (flag)
        {
            a.a.clear();
            for (int j = list1.size(); i < j; i++)
            {
                a.a.add(new az(((ScanResult)list1.get(i)).BSSID));
            }

        }
        return flag;
_L7:
        k1 = j1;
          goto _L14
        list1 = list2;
        continue; /* Loop/switch isn't completed */
        list1 = list2;
        flag = false;
        continue; /* Loop/switch isn't completed */
        flag = false;
        list1 = null;
        if (true) goto _L3; else goto _L15
_L15:
        if (true) goto _L17; else goto _L16
_L16:
    }

}
