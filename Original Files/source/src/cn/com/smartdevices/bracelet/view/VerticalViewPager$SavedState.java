// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ParcelableCompat;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            I

public class c extends android.view.ViewPager.SavedState
{

    public static final android.os.eatorCallbacks CREATOR = ParcelableCompat.newCreator(new I());
    int a;
    Parcelable b;
    ClassLoader c;

    public String toString()
    {
        return (new StringBuilder()).append("FragmentPager.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" position=").append(a).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.rcel(parcel, i);
        parcel.writeInt(a);
        parcel.writeParcelable(b, i);
    }


    (Parcel parcel, ClassLoader classloader)
    {
        super(parcel);
        if (classloader == null)
        {
            classloader = getClass().getClassLoader();
        }
        a = parcel.readInt();
        b = parcel.readParcelable(classloader);
        c = classloader;
    }

    public c(Parcelable parcelable)
    {
        super(parcelable);
    }
}
