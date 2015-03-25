// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.location;

import android.os.Parcel;

final class b
    implements android.os.Parcelable.Creator
{

    b()
    {
    }

    public Location.Address a(Parcel parcel)
    {
        return new Location.Address(parcel, null);
    }

    public Location.Address[] a(int i)
    {
        return new Location.Address[i];
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
