// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.upgrade;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package cn.com.smartdevices.bracelet.upgrade:
//            a

public class OtaVersionInfo
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new a();
    public String firmwareInfo;
    public String firmwareMd5;
    public int firmwareSize;
    public String firmwareUrl;
    public String firmwareVersion;
    public float firmwareVersionCode;

    public OtaVersionInfo()
    {
    }

    private OtaVersionInfo(Parcel parcel)
    {
        firmwareUrl = parcel.readString();
        firmwareVersionCode = parcel.readFloat();
        firmwareVersion = parcel.readString();
        firmwareInfo = parcel.readString();
        firmwareSize = parcel.readInt();
        firmwareMd5 = parcel.readString();
    }

    OtaVersionInfo(Parcel parcel, a a1)
    {
        this(parcel);
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("\n").append(firmwareUrl).append("\n").append(firmwareVersionCode).append("\n").append(firmwareVersion).append("\n").append(firmwareInfo).append("\n").append(firmwareSize).append("\n").append(firmwareMd5).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(firmwareUrl);
        parcel.writeFloat(firmwareVersionCode);
        parcel.writeString(firmwareVersion);
        parcel.writeString(firmwareInfo);
        parcel.writeFloat(firmwareSize);
        parcel.writeString(firmwareMd5);
    }

}
