// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;


// Referenced classes of package com.amap.api.location:
//            b, AMapLocation, k

class l extends Thread
{

    final b a;
    final AMapLocation b;
    final k c;

    l(k k, b b1, AMapLocation amaplocation)
    {
        c = k;
        a = b1;
        b = amaplocation;
        super();
    }

    public void run()
    {
        try
        {
            if (com.amap.api.location.b.a(a) == 1)
            {
                a.a(b, "base", com.amap.api.location.b.b(a));
            }
            if (com.amap.api.location.b.a(a) == 2)
            {
                a.a(b, "all", com.amap.api.location.b.b(a));
            }
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }
}
