// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api;

import android.os.Parcel;

// Referenced classes of package com.sina.weibo.sdk.api:
//            BaseMediaObject

public class CmdObject extends BaseMediaObject
{

    public static final String CMD_HOME = "home";
    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public String cmd;

    public CmdObject()
    {
    }

    public CmdObject(Parcel parcel)
    {
        cmd = parcel.readString();
    }

    public boolean checkArgs()
    {
        return cmd != null && cmd.length() != 0 && cmd.length() <= 1024;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getObjType()
    {
        return 7;
    }

    protected BaseMediaObject toExtraMediaObject(String s)
    {
        return this;
    }

    protected String toExtraMediaString()
    {
        return "";
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(cmd);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public CmdObject createFromParcel(Parcel parcel)
        {
            return new CmdObject(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CmdObject[] newArray(int i)
        {
            return new CmdObject[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
