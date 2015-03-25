// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.os;


// Referenced classes of package android.support.v4.os:
//            c, a, ParcelableCompatCreatorCallbacks

public class ParcelableCompat
{

    public ParcelableCompat()
    {
    }

    public static android.os.Parcelable.Creator newCreator(ParcelableCompatCreatorCallbacks parcelablecompatcreatorcallbacks)
    {
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            c.a(parcelablecompatcreatorcallbacks);
        }
        return new a(parcelablecompatcreatorcallbacks);
    }
}
