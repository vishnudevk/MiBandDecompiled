// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            n, l, m, Fragment, 
//            v

final class BackStackState
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new n();
    final int a[];
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;

    public BackStackState(Parcel parcel)
    {
        a = parcel.createIntArray();
        b = parcel.readInt();
        c = parcel.readInt();
        d = parcel.readString();
        e = parcel.readInt();
        f = parcel.readInt();
        g = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        h = parcel.readInt();
        i = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public BackStackState(v v1, l l1)
    {
        m m1 = l1.k;
        int j = 0;
        for (; m1 != null; m1 = m1.a)
        {
            if (m1.i != null)
            {
                j += m1.i.size();
            }
        }

        a = new int[j + 7 * l1.m];
        if (!l1.t)
        {
            throw new IllegalStateException("Not on back stack");
        }
        m m2 = l1.k;
        int k = 0;
        while (m2 != null) 
        {
            int ai[] = a;
            int i1 = k + 1;
            ai[k] = m2.c;
            int ai1[] = a;
            int j1 = i1 + 1;
            int k1;
            int ai2[];
            int i2;
            int ai3[];
            int j2;
            int ai4[];
            int k2;
            int ai5[];
            int l2;
            if (m2.d != null)
            {
                k1 = m2.d.u;
            } else
            {
                k1 = -1;
            }
            ai1[i1] = k1;
            ai2 = a;
            i2 = j1 + 1;
            ai2[j1] = m2.e;
            ai3 = a;
            j2 = i2 + 1;
            ai3[i2] = m2.f;
            ai4 = a;
            k2 = j2 + 1;
            ai4[j2] = m2.g;
            ai5 = a;
            l2 = k2 + 1;
            ai5[k2] = m2.h;
            if (m2.i != null)
            {
                int i3 = m2.i.size();
                int ai7[] = a;
                int j3 = l2 + 1;
                ai7[l2] = i3;
                for (int k3 = 0; k3 < i3;)
                {
                    int ai8[] = a;
                    int l3 = j3 + 1;
                    ai8[j3] = ((Fragment)m2.i.get(k3)).u;
                    k3++;
                    j3 = l3;
                }

                k = j3;
            } else
            {
                int ai6[] = a;
                k = l2 + 1;
                ai6[l2] = 0;
            }
            m2 = m2.a;
        }
        b = l1.r;
        c = l1.s;
        d = l1.v;
        e = l1.x;
        f = l1.y;
        g = l1.z;
        h = l1.A;
        i = l1.B;
    }

    public l a(v v1)
    {
        l l1 = new l(v1);
        int j = 0;
        int i3;
        for (int k = 0; k < a.length; k = i3)
        {
            m m1 = new m();
            int ai[] = a;
            int i1 = k + 1;
            m1.c = ai[k];
            if (v.a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("Instantiate ").append(l1).append(" op #").append(j).append(" base fragment #").append(a[i1]).toString());
            }
            int ai1[] = a;
            int j1 = i1 + 1;
            int k1 = ai1[i1];
            int ai2[];
            int i2;
            int ai3[];
            int j2;
            int ai4[];
            int k2;
            int ai5[];
            int l2;
            int ai6[];
            int j3;
            if (k1 >= 0)
            {
                m1.d = (Fragment)v1.k.get(k1);
            } else
            {
                m1.d = null;
            }
            ai2 = a;
            i2 = j1 + 1;
            m1.e = ai2[j1];
            ai3 = a;
            j2 = i2 + 1;
            m1.f = ai3[i2];
            ai4 = a;
            k2 = j2 + 1;
            m1.g = ai4[j2];
            ai5 = a;
            l2 = k2 + 1;
            m1.h = ai5[k2];
            ai6 = a;
            i3 = l2 + 1;
            j3 = ai6[l2];
            if (j3 > 0)
            {
                m1.i = new ArrayList(j3);
                for (int k3 = 0; k3 < j3;)
                {
                    if (v.a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("Instantiate ").append(l1).append(" set remove fragment #").append(a[i3]).toString());
                    }
                    ArrayList arraylist = v1.k;
                    int ai7[] = a;
                    int l3 = i3 + 1;
                    Fragment fragment = (Fragment)arraylist.get(ai7[i3]);
                    m1.i.add(fragment);
                    k3++;
                    i3 = l3;
                }

            }
            l1.a(m1);
            j++;
        }

        l1.r = b;
        l1.s = c;
        l1.v = d;
        l1.x = e;
        l1.t = true;
        l1.y = f;
        l1.z = g;
        l1.A = h;
        l1.B = i;
        l1.a(1);
        return l1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        parcel.writeIntArray(a);
        parcel.writeInt(b);
        parcel.writeInt(c);
        parcel.writeString(d);
        parcel.writeInt(e);
        parcel.writeInt(f);
        TextUtils.writeToParcel(g, parcel, 0);
        parcel.writeInt(h);
        TextUtils.writeToParcel(i, parcel, 0);
    }

}
