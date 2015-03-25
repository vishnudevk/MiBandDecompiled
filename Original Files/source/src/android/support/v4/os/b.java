// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.os;

import android.os.Parcel;

// Referenced classes of package android.support.v4.os:
//            ParcelableCompatCreatorCallbacks

class b
    implements android.os.Parcelable.ClassLoaderCreator
{

    private final ParcelableCompatCreatorCallbacks a;

    public b(ParcelableCompatCreatorCallbacks parcelablecompatcreatorcallbacks)
    {
        a = parcelablecompatcreatorcallbacks;
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a.createFromParcel(parcel, null);
    }

    public Object createFromParcel(Parcel parcel, ClassLoader classloader)
    {
        return a.createFromParcel(parcel, classloader);
    }

    public Object[] newArray(int i)
    {
        return a.newArray(i);
    }
}
