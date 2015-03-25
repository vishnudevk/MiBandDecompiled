// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api;

import android.os.Parcel;
import com.sina.weibo.sdk.utils.LogUtil;

// Referenced classes of package com.sina.weibo.sdk.api:
//            BaseMediaObject

public class TextObject extends BaseMediaObject
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public String text;

    public TextObject()
    {
    }

    public TextObject(Parcel parcel)
    {
        text = parcel.readString();
    }

    public boolean checkArgs()
    {
        if (text == null || text.length() == 0 || text.length() > 1024)
        {
            LogUtil.e("Weibo.TextObject", "checkArgs fail, text is invalid");
            return false;
        } else
        {
            return true;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public int getObjType()
    {
        return 1;
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
        parcel.writeString(text);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public TextObject createFromParcel(Parcel parcel)
        {
            return new TextObject(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public TextObject[] newArray(int i)
        {
            return new TextObject[i];
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
