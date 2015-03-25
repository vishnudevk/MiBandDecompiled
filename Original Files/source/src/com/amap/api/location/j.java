// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.location.core.d;
import java.util.Iterator;
import java.util.Vector;

// Referenced classes of package com.amap.api.location:
//            a, AMapLocation, g, AMapLocationListener

class j extends Handler
{

    final a a;

    public j(a a1)
    {
        a = a1;
        super();
    }

    public j(a a1, Looper looper)
    {
        a = a1;
        super(looper);
        Looper.prepare();
    }

    public void handleMessage(Message message)
    {
        if (message != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Vector vector;
        if (message.what != 100 || (vector = com.amap.api.location.a.a(a)) == null) goto _L1; else goto _L3
_L3:
        Iterator iterator;
        int i;
        try
        {
            com.amap.api.location.a.a(a, (AMapLocation)message.obj);
            if (com.amap.api.location.a.b(a) != null && com.amap.api.location.a.b(a).getAdCode() != null && com.amap.api.location.a.b(a).getAdCode().length() > 0)
            {
                com.amap.api.location.a.b(a, com.amap.api.location.a.b(a));
            }
        }
        catch (Exception exception)
        {
            try
            {
                exception.printStackTrace();
            }
            catch (Throwable throwable)
            {
                return;
            }
        }
        iterator = com.amap.api.location.a.a(a).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            g g1 = (g)iterator.next();
            if (g1.b != null)
            {
                AMapLocation amaplocation = (AMapLocation)message.obj;
                if (g1.c.booleanValue() || amaplocation.getAMapException().getErrorCode() == 0)
                {
                    g1.b.onLocationChanged(amaplocation);
                    if (g1.c.booleanValue() && g1.a == -1L && com.amap.api.location.a.c(a) != null)
                    {
                        com.amap.api.location.a.c(a).add(g1);
                    }
                }
            }
        } while (true);
        if (com.amap.api.location.a.c(a) == null || com.amap.api.location.a.c(a).size() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = 0;
_L5:
        if (i >= com.amap.api.location.a.c(a).size())
        {
            break; /* Loop/switch isn't completed */
        }
        a.a(((g)com.amap.api.location.a.c(a).get(i)).b);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        com.amap.api.location.a.c(a).clear();
        if (com.amap.api.location.a.b(a) == null) goto _L1; else goto _L6
_L6:
        d.a(com.amap.api.location.a.d(a), com.amap.api.location.a.b(a));
        return;
    }
}
