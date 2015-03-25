// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            n, o, l

class <init> extends android.view.elLayout.SavedState
{

    public static final android.os. CREATOR = new n();
    o a;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.l(parcel, i);
        parcel.writeString(a.toString());
    }


    private (Parcel parcel)
    {
        super(parcel);
        try
        {
            a = (o)Enum.valueOf(cn/com/smartdevices/bracelet/lua/o, parcel.readString());
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            a = o.b;
        }
    }

    a(Parcel parcel, l l)
    {
        this(parcel);
    }

    <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}
