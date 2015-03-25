// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import android.location.Criteria;
import android.location.LocationManager;
import android.location.LocationProvider;

public class LocationProviderProxy
{

    public static final String AMapNetwork = "lbs";
    public static final int AVAILABLE = 2;
    public static final int OUT_OF_SERVICE = 0;
    public static final int TEMPORARILY_UNAVAILABLE = 1;
    private LocationManager a;
    private String b;

    protected LocationProviderProxy(LocationManager locationmanager, String s)
    {
        a = locationmanager;
        b = s;
    }

    private LocationProvider a()
    {
        LocationProvider locationprovider;
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        locationprovider = a.getProvider(b);
        return locationprovider;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return null;
    }

    static LocationProviderProxy a(LocationManager locationmanager, String s)
    {
        return new LocationProviderProxy(locationmanager, s);
    }

    public int getAccuracy()
    {
        if ("lbs" == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        if ("lbs".equals(b))
        {
            return 2;
        }
        int i;
        if (a() == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        i = a().getAccuracy();
        return i;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return -1;
    }

    public String getName()
    {
        if ("lbs" == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        if ("lbs".equals(b))
        {
            return "lbs";
        }
        String s;
        if (a() == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        s = a().getName();
        return s;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return "null";
    }

    public int getPowerRequirement()
    {
        if ("lbs" == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        if ("lbs".equals(b))
        {
            return 2;
        }
        int i;
        if (a() == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        i = a().getPowerRequirement();
        return i;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return -1;
    }

    public boolean hasMonetaryCost()
    {
        if ("lbs" == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        if ("lbs".equals(b))
        {
            return false;
        }
        boolean flag;
        if (a() == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        flag = a().hasMonetaryCost();
        return flag;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return false;
    }

    public boolean meetsCriteria(Criteria criteria)
    {
        boolean flag;
        flag = true;
        if ("lbs" == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        if ("lbs".equals(b))
        {
            if (criteria == null)
            {
                return flag;
            }
            boolean flag1;
            try
            {
                if (criteria.isAltitudeRequired() || criteria.isBearingRequired() || criteria.isSpeedRequired() || criteria.getAccuracy() == flag)
                {
                    break MISSING_BLOCK_LABEL_86;
                }
                break MISSING_BLOCK_LABEL_84;
            }
            catch (Throwable throwable)
            {
                throwable.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_82;
        }
        if (a() == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        flag1 = a().meetsCriteria(criteria);
        return flag1;
        flag = false;
        return flag;
        return false;
    }

    public boolean requiresCell()
    {
        if ("lbs" == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        if ("lbs".equals(b))
        {
            return true;
        }
        boolean flag;
        if (a() == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        flag = a().requiresCell();
        return flag;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return true;
    }

    public boolean requiresNetwork()
    {
        if ("lbs" == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        if ("lbs".equals(b))
        {
            return true;
        }
        boolean flag;
        if (a() == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        flag = a().requiresNetwork();
        return flag;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return true;
    }

    public boolean requiresSatellite()
    {
        if ("lbs" == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        if ("lbs".equals(b))
        {
            return false;
        }
        boolean flag;
        if (a() == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        flag = a().requiresNetwork();
        return flag;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return true;
    }

    public boolean supportsAltitude()
    {
        if ("lbs" == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        if ("lbs".equals(b))
        {
            return false;
        }
        boolean flag;
        if (a() == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        flag = a().supportsAltitude();
        return flag;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return false;
    }

    public boolean supportsBearing()
    {
        if ("lbs" == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        if ("lbs".equals(b))
        {
            return false;
        }
        boolean flag;
        if (a() == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        flag = a().supportsBearing();
        return flag;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return false;
    }

    public boolean supportsSpeed()
    {
        if ("lbs" == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        if ("lbs".equals(b))
        {
            return false;
        }
        boolean flag;
        if (a() == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        flag = a().supportsSpeed();
        return flag;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return false;
    }
}
