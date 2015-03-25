// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.os.Parcel;

final class n
    implements android.os.Parcelable.Creator
{

    n()
    {
    }

    public SlidingUpPanelLayout.SavedState a(Parcel parcel)
    {
        return new SlidingUpPanelLayout.SavedState(parcel, null);
    }

    public SlidingUpPanelLayout.SavedState[] a(int i)
    {
        return new SlidingUpPanelLayout.SavedState[i];
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
