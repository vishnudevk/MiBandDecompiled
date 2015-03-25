// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.upgrade;

import android.os.Parcel;

// Referenced classes of package cn.com.smartdevices.bracelet.upgrade:
//            OtaVersionInfo

final class a
    implements android.os.Parcelable.Creator
{

    a()
    {
    }

    public OtaVersionInfo a(Parcel parcel)
    {
        return new OtaVersionInfo(parcel, null);
    }

    public OtaVersionInfo[] a(int i)
    {
        return new OtaVersionInfo[i];
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
