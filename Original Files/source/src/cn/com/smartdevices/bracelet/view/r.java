// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.os.Parcel;

final class r
    implements android.os.Parcelable.Creator
{

    r()
    {
    }

    public PagerSlidingTabStrip.SavedState a(Parcel parcel)
    {
        return new PagerSlidingTabStrip.SavedState(parcel, null);
    }

    public PagerSlidingTabStrip.SavedState[] a(int i)
    {
        return new PagerSlidingTabStrip.SavedState[i];
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
