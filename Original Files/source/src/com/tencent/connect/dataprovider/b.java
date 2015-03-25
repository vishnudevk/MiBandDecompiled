// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.dataprovider;

import android.os.Parcel;

final class b
    implements android.os.Parcelable.Creator
{

    b()
    {
    }

    public DataType.TextAndMediaPath a(Parcel parcel)
    {
        return new DataType.TextAndMediaPath(parcel, null);
    }

    public DataType.TextAndMediaPath[] a(int i)
    {
        return new DataType.TextAndMediaPath[i];
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
