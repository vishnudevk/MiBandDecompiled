// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location.core;

import android.os.Parcel;

// Referenced classes of package com.amap.api.location.core:
//            GeoPoint

final class f
    implements android.os.Parcelable.Creator
{

    f()
    {
    }

    public GeoPoint a(Parcel parcel)
    {
        return new GeoPoint(parcel, null);
    }

    public GeoPoint[] a(int i)
    {
        return new GeoPoint[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }
}
