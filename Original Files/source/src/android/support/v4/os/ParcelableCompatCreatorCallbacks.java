// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.os;

import android.os.Parcel;

public interface ParcelableCompatCreatorCallbacks
{

    public abstract Object createFromParcel(Parcel parcel, ClassLoader classloader);

    public abstract Object[] newArray(int i);
}
