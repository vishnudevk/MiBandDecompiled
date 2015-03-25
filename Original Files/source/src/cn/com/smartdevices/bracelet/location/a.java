// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.location;

import android.os.Parcel;

// Referenced classes of package cn.com.smartdevices.bracelet.location:
//            Location

final class a
    implements android.os.Parcelable.Creator
{

    a()
    {
    }

    public Location a(Parcel parcel)
    {
        return new Location(parcel, null);
    }

    public Location[] a(int i)
    {
        return new Location[i];
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
