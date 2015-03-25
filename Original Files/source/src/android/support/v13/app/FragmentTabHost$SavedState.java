// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v13.app;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.support.v13.app:
//            i, g

class <init> extends android.view.SavedState
{

    public static final android.os.t.SavedState.a CREATOR = new i();
    String a;

    public String toString()
    {
        return (new StringBuilder()).append("FragmentTabHost.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" curTab=").append(a).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        super.Parcel(parcel, j);
        parcel.writeString(a);
    }


    private (Parcel parcel)
    {
        super(parcel);
        a = parcel.readString();
    }

    a(Parcel parcel, g g)
    {
        this(parcel);
    }

    <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}
