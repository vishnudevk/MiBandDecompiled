// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location.core;

import com.aps.u;

// Referenced classes of package com.amap.api.location.core:
//            GeoPoint

public class CoordinateConvert
{

    public CoordinateConvert()
    {
    }

    public static GeoPoint fromGpsToAMap(double d, double d1)
    {
        GeoPoint geopoint;
        try
        {
            double ad[] = u.a(d1, d);
            geopoint = new GeoPoint((int)(1000000D * ad[1]), (int)(1000000D * ad[0]));
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return null;
        }
        return geopoint;
    }

    public static double[] fromSeveralGpsToAMap(String s)
    {
        int i = 0;
        double ad[];
        String as[];
        int j;
        as = s.split(",");
        j = as.length;
        ad = new double[j];
_L1:
        if (i >= j / 2)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        double ad1[] = u.a(Double.parseDouble(as[i * 2]), Double.parseDouble(as[1 + i * 2]));
        ad[i * 2] = ad1[0];
        ad[1 + i * 2] = ad1[1];
        i++;
          goto _L1
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        ad = null;
        return ad;
    }

    public static double[] fromSeveralGpsToAMap(double ad[])
    {
        int i = 0;
        double ad1[];
        int j;
        j = ad.length;
        ad1 = new double[j];
_L1:
        if (i >= j / 2)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        double ad2[] = u.a(ad[i * 2], ad[1 + i * 2]);
        ad1[i * 2] = ad2[0];
        ad1[1 + i * 2] = ad2[1];
        i++;
          goto _L1
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        ad1 = null;
        return ad1;
    }
}
