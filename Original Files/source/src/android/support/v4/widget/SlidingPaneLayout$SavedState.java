// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.support.v4.widget:
//            K, G

class <init> extends android.view.t.SavedState
{

    public static final android.os.out.SavedState.a CREATOR = new K();
    boolean a;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.rcel(parcel, i);
        int j;
        if (a)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
    }


    private (Parcel parcel)
    {
        super(parcel);
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }

    a(Parcel parcel, G g)
    {
        this(parcel);
    }

    <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}
