// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;


// Referenced classes of package com.amap.api.location:
//            a, b, AMapLocalWeatherListener

class i extends Thread
{

    final int a;
    final AMapLocalWeatherListener b;
    final a c;

    i(a a1, int j, AMapLocalWeatherListener amaplocalweatherlistener)
    {
        c = a1;
        a = j;
        b = amaplocalweatherlistener;
        super();
    }

    public void run()
    {
        c.g.a(a, b, com.amap.api.location.a.e(c));
    }
}
