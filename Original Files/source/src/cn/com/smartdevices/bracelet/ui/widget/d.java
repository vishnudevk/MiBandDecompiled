// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui.widget;

import android.os.Parcel;

final class d
    implements android.os.Parcelable.Creator
{

    d()
    {
    }

    public TitlePageIndicator.SavedState a(Parcel parcel)
    {
        return new TitlePageIndicator.SavedState(parcel, null);
    }

    public TitlePageIndicator.SavedState[] a(int i)
    {
        return new TitlePageIndicator.SavedState[i];
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
