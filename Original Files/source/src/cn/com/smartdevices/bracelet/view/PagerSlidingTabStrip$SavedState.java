// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            r, o

class <init> extends android.view.gTabStrip.SavedState
{

    public static final android.os.ingTabStrip.SavedState.a CREATOR = new r();
    int a;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.l(parcel, i);
        parcel.writeInt(a);
    }


    private (Parcel parcel)
    {
        super(parcel);
        a = parcel.readInt();
    }

    a(Parcel parcel, o o)
    {
        this(parcel);
    }

    public <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}
