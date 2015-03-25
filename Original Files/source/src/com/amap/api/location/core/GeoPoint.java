// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location.core;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.amap.api.location.core:
//            f

public class GeoPoint
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new f();
    private long a;
    private long b;
    private double c;
    private double d;

    public GeoPoint()
    {
        a = 0x8000000000000000L;
        b = 0x8000000000000000L;
        c = 4.9406564584124654E-324D;
        d = 4.9406564584124654E-324D;
        a = 0L;
        b = 0L;
    }

    public GeoPoint(int i, int j)
    {
        a = 0x8000000000000000L;
        b = 0x8000000000000000L;
        c = 4.9406564584124654E-324D;
        d = 4.9406564584124654E-324D;
        a = i;
        b = j;
    }

    public GeoPoint(long l, long l1)
    {
        a = 0x8000000000000000L;
        b = 0x8000000000000000L;
        c = 4.9406564584124654E-324D;
        d = 4.9406564584124654E-324D;
        a = l;
        b = l1;
    }

    private GeoPoint(Parcel parcel)
    {
        a = 0x8000000000000000L;
        b = 0x8000000000000000L;
        c = 4.9406564584124654E-324D;
        d = 4.9406564584124654E-324D;
        a = parcel.readLong();
        b = parcel.readLong();
    }

    GeoPoint(Parcel parcel, f f1)
    {
        this(parcel);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && obj.getClass() == getClass())
        {
            GeoPoint geopoint = (GeoPoint)obj;
            if (c == geopoint.c && d == geopoint.d && a == geopoint.a && b == geopoint.b)
            {
                return true;
            }
        }
        return false;
    }

    public int getLatitudeE6()
    {
        return (int)a;
    }

    public int getLongitudeE6()
    {
        return (int)b;
    }

    public int hashCode()
    {
        return (int)(7D * d + 11D * c);
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(a).append(",").append(b).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(a);
        parcel.writeLong(b);
    }

}
