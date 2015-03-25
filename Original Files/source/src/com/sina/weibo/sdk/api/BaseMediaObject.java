// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class BaseMediaObject
    implements Parcelable
{

    public static final int MEDIA_TYPE_CMD = 7;
    public static final int MEDIA_TYPE_IMAGE = 2;
    public static final int MEDIA_TYPE_MUSIC = 3;
    public static final int MEDIA_TYPE_TEXT = 1;
    public static final int MEDIA_TYPE_VIDEO = 4;
    public static final int MEDIA_TYPE_VOICE = 6;
    public static final int MEDIA_TYPE_WEBPAGE = 5;
    public String actionUrl;
    public String description;
    public String identify;
    public String schema;
    public byte thumbData[];
    public String title;

    public BaseMediaObject()
    {
    }

    public BaseMediaObject(Parcel parcel)
    {
        actionUrl = parcel.readString();
        schema = parcel.readString();
        identify = parcel.readString();
        title = parcel.readString();
        description = parcel.readString();
        thumbData = parcel.createByteArray();
    }

    protected boolean checkArgs()
    {
        if (actionUrl == null || actionUrl.length() > 512)
        {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, actionUrl is invalid");
            return false;
        }
        if (identify == null || identify.length() > 512)
        {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, identify is invalid");
            return false;
        }
        if (thumbData == null || thumbData.length > 32768)
        {
            LogUtil.e("Weibo.BaseMediaObject", (new StringBuilder("checkArgs fail, thumbData is invalid,size is ")).append(thumbData.length).append("! more then 32768.").toString());
            return false;
        }
        if (title == null || title.length() > 512)
        {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, title is invalid");
            return false;
        }
        if (description == null || description.length() > 1024)
        {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, description is invalid");
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

    public abstract int getObjType();

    public final void setThumbImage(Bitmap bitmap)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        Exception exception;
        Exception exception1;
        try
        {
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 85, bytearrayoutputstream);
            thumbData = bytearrayoutputstream.toByteArray();
            break MISSING_BLOCK_LABEL_27;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception) { }
        finally { }
          goto _L1
        exception;
        bytearrayoutputstream = null;
_L1:
        exception.printStackTrace();
        LogUtil.e("Weibo.BaseMediaObject", "put thumb failed");
        try
        {
            bytearrayoutputstream.close();
            return;
        }
        catch (IOException ioexception1)
        {
            ioexception1.printStackTrace();
        }
        return;
        exception1;
        bytearrayoutputstream = null;
        try
        {
            bytearrayoutputstream.close();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        throw exception1;
        try
        {
            bytearrayoutputstream.close();
            return;
        }
        catch (IOException ioexception2)
        {
            ioexception2.printStackTrace();
        }
        return;
    }

    protected abstract BaseMediaObject toExtraMediaObject(String s);

    protected abstract String toExtraMediaString();

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(actionUrl);
        parcel.writeString(schema);
        parcel.writeString(identify);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeByteArray(thumbData);
    }
}
