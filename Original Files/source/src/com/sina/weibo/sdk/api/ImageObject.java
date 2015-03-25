// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.sina.weibo.sdk.api:
//            BaseMediaObject

public class ImageObject extends BaseMediaObject
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private static final int DATA_SIZE = 0x200000;
    public byte imageData[];
    public String imagePath;

    public ImageObject()
    {
    }

    public ImageObject(Parcel parcel)
    {
        imageData = parcel.createByteArray();
        imagePath = parcel.readString();
    }

    public boolean checkArgs()
    {
label0:
        {
            if (imageData == null && imagePath == null)
            {
                LogUtil.e("Weibo.ImageObject", "imageData and imagePath are null");
                return false;
            }
            if (imageData != null && imageData.length > 0x200000)
            {
                LogUtil.e("Weibo.ImageObject", "imageData is too large");
                return false;
            }
            if (imagePath != null && imagePath.length() > 512)
            {
                LogUtil.e("Weibo.ImageObject", "imagePath is too length");
                return false;
            }
            if (imagePath == null)
            {
                break label0;
            }
            File file = new File(imagePath);
            try
            {
                if (file.exists() && file.length() != 0L && file.length() <= 0xa00000L)
                {
                    break label0;
                }
                LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
            }
            catch (SecurityException securityexception)
            {
                LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
                return false;
            }
            return false;
        }
        return true;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getObjType()
    {
        return 2;
    }

    public final void setImageObject(Bitmap bitmap)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        Exception exception;
        Exception exception1;
        try
        {
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 85, bytearrayoutputstream);
            imageData = bytearrayoutputstream.toByteArray();
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
        LogUtil.e("Weibo.ImageObject", "put thumb failed");
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
        parcel.writeByteArray(imageData);
        parcel.writeString(imagePath);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public ImageObject createFromParcel(Parcel parcel)
        {
            return new ImageObject(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ImageObject[] newArray(int i)
        {
            return new ImageObject[i];
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
