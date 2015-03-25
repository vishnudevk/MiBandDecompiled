// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.sina.weibo.sdk.api:
//            BaseMediaObject

public class VoiceObject extends BaseMediaObject
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public static final String EXTRA_KEY_DEFAULTTEXT = "extra_key_defaulttext";
    public String dataHdUrl;
    public String dataUrl;
    public String defaultText;
    public int duration;
    public String h5Url;

    public VoiceObject()
    {
    }

    public VoiceObject(Parcel parcel)
    {
        super(parcel);
        h5Url = parcel.readString();
        dataUrl = parcel.readString();
        dataHdUrl = parcel.readString();
        duration = parcel.readInt();
    }

    public boolean checkArgs()
    {
        if (!super.checkArgs())
        {
            return false;
        }
        if (dataUrl != null && dataUrl.length() > 512)
        {
            LogUtil.e("Weibo.VoiceObject", "checkArgs fail, dataUrl is invalid");
            return false;
        }
        if (dataHdUrl != null && dataHdUrl.length() > 512)
        {
            LogUtil.e("Weibo.VoiceObject", "checkArgs fail, dataHdUrl is invalid");
            return false;
        }
        if (duration <= 0)
        {
            LogUtil.e("Weibo.VoiceObject", "checkArgs fail, duration is invalid");
            return false;
        } else
        {
            return true;
        }
    }

    public int getObjType()
    {
        return 6;
    }

    protected BaseMediaObject toExtraMediaObject(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            try
            {
                defaultText = (new JSONObject(s)).optString("extra_key_defaulttext");
            }
            catch (JSONException jsonexception)
            {
                return this;
            }
        }
        return this;
    }

    protected String toExtraMediaString()
    {
        String s;
        try
        {
            JSONObject jsonobject = new JSONObject();
            if (!TextUtils.isEmpty(defaultText))
            {
                jsonobject.put("extra_key_defaulttext", defaultText);
            }
            s = jsonobject.toString();
        }
        catch (JSONException jsonexception)
        {
            return "";
        }
        return s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeString(h5Url);
        parcel.writeString(dataUrl);
        parcel.writeString(dataHdUrl);
        parcel.writeInt(duration);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public VoiceObject createFromParcel(Parcel parcel)
        {
            return new VoiceObject(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VoiceObject[] newArray(int i)
        {
            return new VoiceObject[i];
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
