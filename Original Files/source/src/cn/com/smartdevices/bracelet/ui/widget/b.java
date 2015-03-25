// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui.widget;

import android.os.Parcel;

final class b
    implements android.os.Parcelable.Creator
{

    b()
    {
    }

    public CirclePageIndicator.SavedState a(Parcel parcel)
    {
        return new CirclePageIndicator.SavedState(parcel, null);
    }

    public CirclePageIndicator.SavedState[] a(int i)
    {
        return new CirclePageIndicator.SavedState[i];
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
