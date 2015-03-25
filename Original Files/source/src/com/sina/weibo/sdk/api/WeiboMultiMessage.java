// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api;

import android.os.Bundle;
import com.sina.weibo.sdk.utils.LogUtil;

// Referenced classes of package com.sina.weibo.sdk.api:
//            TextObject, ImageObject, BaseMediaObject

public final class WeiboMultiMessage
{

    private static final String TAG = "WeiboMultiMessage";
    public ImageObject imageObject;
    public BaseMediaObject mediaObject;
    public TextObject textObject;

    public WeiboMultiMessage()
    {
    }

    public WeiboMultiMessage(Bundle bundle)
    {
        toBundle(bundle);
    }

    public boolean checkArgs()
    {
        if (textObject != null && !textObject.checkArgs())
        {
            LogUtil.e("WeiboMultiMessage", "checkArgs fail, textObject is invalid");
            return false;
        }
        if (imageObject != null && !imageObject.checkArgs())
        {
            LogUtil.e("WeiboMultiMessage", "checkArgs fail, imageObject is invalid");
            return false;
        }
        if (mediaObject != null && !mediaObject.checkArgs())
        {
            LogUtil.e("WeiboMultiMessage", "checkArgs fail, mediaObject is invalid");
            return false;
        }
        if (textObject == null && imageObject == null && mediaObject == null)
        {
            LogUtil.e("WeiboMultiMessage", "checkArgs fail, textObject and imageObject and mediaObject is null");
            return false;
        } else
        {
            return true;
        }
    }

    public Bundle toBundle(Bundle bundle)
    {
        if (textObject != null)
        {
            bundle.putParcelable("_weibo_message_text", textObject);
            bundle.putString("_weibo_message_text_extra", textObject.toExtraMediaString());
        }
        if (imageObject != null)
        {
            bundle.putParcelable("_weibo_message_image", imageObject);
            bundle.putString("_weibo_message_image_extra", imageObject.toExtraMediaString());
        }
        if (mediaObject != null)
        {
            bundle.putParcelable("_weibo_message_media", mediaObject);
            bundle.putString("_weibo_message_media_extra", mediaObject.toExtraMediaString());
        }
        return bundle;
    }

    public WeiboMultiMessage toObject(Bundle bundle)
    {
        textObject = (TextObject)bundle.getParcelable("_weibo_message_text");
        if (textObject != null)
        {
            textObject.toExtraMediaObject(bundle.getString("_weibo_message_text_extra"));
        }
        imageObject = (ImageObject)bundle.getParcelable("_weibo_message_image");
        if (imageObject != null)
        {
            imageObject.toExtraMediaObject(bundle.getString("_weibo_message_image_extra"));
        }
        mediaObject = (BaseMediaObject)bundle.getParcelable("_weibo_message_media");
        if (mediaObject != null)
        {
            mediaObject.toExtraMediaObject(bundle.getString("_weibo_message_media_extra"));
        }
        return this;
    }
}
