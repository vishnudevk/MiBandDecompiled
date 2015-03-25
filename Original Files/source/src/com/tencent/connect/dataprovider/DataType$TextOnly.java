// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.tencent.connect.dataprovider:
//            c, a

public class a
    implements Parcelable
{

    public static final android.os. CREATOR = new c();
    private String a;

    public int describeContents()
    {
        return 0;
    }

    public String getText()
    {
        return a;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
    }


    private (Parcel parcel)
    {
        a = parcel.readString();
    }

    a(Parcel parcel, a a1)
    {
        this(parcel);
    }

    public <init>(String s)
    {
        a = s;
    }
}
