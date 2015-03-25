// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v13.app;

import android.os.Parcel;

final class i
    implements android.os.Parcelable.Creator
{

    i()
    {
    }

    public FragmentTabHost.SavedState a(Parcel parcel)
    {
        return new FragmentTabHost.SavedState(parcel, null);
    }

    public FragmentTabHost.SavedState[] a(int j)
    {
        return new FragmentTabHost.SavedState[j];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int j)
    {
        return a(j);
    }
}
