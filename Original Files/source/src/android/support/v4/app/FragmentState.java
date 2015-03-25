// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

// Referenced classes of package android.support.v4.app:
//            C, Fragment, FragmentActivity, v

final class FragmentState
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new C();
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    Bundle j;
    Fragment k;

    public FragmentState(Parcel parcel)
    {
        boolean flag = true;
        super();
        a = parcel.readString();
        b = parcel.readInt();
        boolean flag1;
        boolean flag2;
        if (parcel.readInt() != 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        c = flag1;
        d = parcel.readInt();
        e = parcel.readInt();
        f = parcel.readString();
        if (parcel.readInt() != 0)
        {
            flag2 = flag;
        } else
        {
            flag2 = false;
        }
        g = flag2;
        if (parcel.readInt() == 0)
        {
            flag = false;
        }
        h = flag;
        i = parcel.readBundle();
        j = parcel.readBundle();
    }

    public FragmentState(Fragment fragment)
    {
        a = fragment.getClass().getName();
        b = fragment.u;
        c = fragment.D;
        d = fragment.L;
        e = fragment.M;
        f = fragment.N;
        g = fragment.Q;
        h = fragment.P;
        i = fragment.w;
    }

    public Fragment a(FragmentActivity fragmentactivity, Fragment fragment)
    {
        if (k != null)
        {
            return k;
        }
        if (i != null)
        {
            i.setClassLoader(fragmentactivity.getClassLoader());
        }
        k = Fragment.instantiate(fragmentactivity, a, i);
        if (j != null)
        {
            j.setClassLoader(fragmentactivity.getClassLoader());
            k.s = j;
        }
        k.a(b, fragment);
        k.D = c;
        k.F = true;
        k.L = d;
        k.M = e;
        k.N = f;
        k.Q = g;
        k.P = h;
        k.H = fragmentactivity.e;
        if (v.a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Instantiated fragment ").append(k).toString());
        }
        return k;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int l)
    {
        int i1 = 1;
        parcel.writeString(a);
        parcel.writeInt(b);
        int j1;
        int k1;
        if (c)
        {
            j1 = i1;
        } else
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        parcel.writeInt(d);
        parcel.writeInt(e);
        parcel.writeString(f);
        if (g)
        {
            k1 = i1;
        } else
        {
            k1 = 0;
        }
        parcel.writeInt(k1);
        if (!h)
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        parcel.writeBundle(i);
        parcel.writeBundle(j);
    }

}
