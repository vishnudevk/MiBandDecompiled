// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

final class aG
    implements ParcelableCompatCreatorCallbacks
{

    aG()
    {
    }

    public ViewPager.SavedState a(Parcel parcel, ClassLoader classloader)
    {
        return new ViewPager.SavedState(parcel, classloader);
    }

    public ViewPager.SavedState[] a(int i)
    {
        return new ViewPager.SavedState[i];
    }

    public Object createFromParcel(Parcel parcel, ClassLoader classloader)
    {
        return a(parcel, classloader);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }
}
