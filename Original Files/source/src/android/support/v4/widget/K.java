// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.os.Parcel;

final class K
    implements android.os.Parcelable.Creator
{

    K()
    {
    }

    public SlidingPaneLayout.SavedState a(Parcel parcel)
    {
        return new SlidingPaneLayout.SavedState(parcel, null);
    }

    public SlidingPaneLayout.SavedState[] a(int i)
    {
        return new SlidingPaneLayout.SavedState[i];
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
