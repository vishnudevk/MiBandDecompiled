// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.tencent.connect.dataprovider:
//            b, a

public class b
    implements Parcelable
{

    public static final android.os.Type.TextAndMediaPath.b CREATOR = new b();
    private String a;
    private String b;

    public int describeContents()
    {
        return 0;
    }

    public String getMediaPath()
    {
        return b;
    }

    public String getText()
    {
        return a;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
        parcel.writeString(b);
    }


    private (Parcel parcel)
    {
        a = parcel.readString();
        b = parcel.readString();
    }

    b(Parcel parcel, a a1)
    {
        this(parcel);
    }

    public <init>(String s, String s1)
    {
        a = s;
        b = s1;
    }
}
