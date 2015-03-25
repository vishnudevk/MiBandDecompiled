// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.location;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package cn.com.smartdevices.bracelet.location:
//            b, a

public class <init>
    implements Parcelable
{

    public static final android.os.r CREATOR = new b();
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public int describeContents()
    {
        return 0;
    }

    public String getAdmin()
    {
        return c;
    }

    public String getCountry()
    {
        return a;
    }

    public String getCountryCode()
    {
        return b;
    }

    public String getLocality()
    {
        return e;
    }

    public String getSubAdmin()
    {
        return d;
    }

    public String getSubLocality()
    {
        return f;
    }

    public String getThoroughfare()
    {
        return g;
    }

    public void setAdmin(String s)
    {
        c = s;
    }

    public void setCountry(String s)
    {
        a = s;
    }

    public void setCountryCode(String s)
    {
        b = s;
    }

    public void setLocality(String s)
    {
        e = s;
    }

    public void setSubAdmin(String s)
    {
        d = s;
    }

    public void setSubLocality(String s)
    {
        f = s;
    }

    public void setThoroughfare(String s)
    {
        g = s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("\n\t\t").append((new StringBuilder()).append("Country : ").append(a).toString()).append((new StringBuilder()).append(", CountryCode : ").append(b).toString()).append((new StringBuilder()).append(", Admin : ").append(c).toString()).append((new StringBuilder()).append(", SubAdmin : ").append(d).toString()).append((new StringBuilder()).append(", Locality : ").append(e).toString()).append((new StringBuilder()).append(", SubLocality : ").append(f).toString()).append((new StringBuilder()).append(", Thoroughfare : ").append(g).toString());
        return stringbuilder.toString();
    }

    public String toStringShort()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Ctr:").append(a).append(",CtrCode:").append(b).append(",Admin:").append(c).append(",SubAdm:").append(d).append(",Loc:").append(e).append(",SubLoc:").append(f).append(",Thoro:").append(g);
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
        parcel.writeString(b);
        parcel.writeString(c);
        parcel.writeString(d);
        parcel.writeString(e);
        parcel.writeString(f);
        parcel.writeString(g);
    }


    public ()
    {
    }

    private (Parcel parcel)
    {
        a = parcel.readString();
        b = parcel.readString();
        c = parcel.readString();
        d = parcel.readString();
        e = parcel.readString();
        f = parcel.readString();
        g = parcel.readString();
    }

    g(Parcel parcel, a a1)
    {
        this(parcel);
    }
}
