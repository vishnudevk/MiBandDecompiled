// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api;

import android.os.Bundle;
import com.sina.weibo.sdk.utils.LogUtil;

// Referenced classes of package com.sina.weibo.sdk.api:
//            BaseMediaObject

public final class WeiboMessage
{

    public BaseMediaObject mediaObject;

    public WeiboMessage()
    {
    }

    public WeiboMessage(Bundle bundle)
    {
        toBundle(bundle);
    }

    public boolean checkArgs()
    {
        if (mediaObject == null)
        {
            LogUtil.e("Weibo.WeiboMessage", "checkArgs fail, mediaObject is null");
            return false;
        }
        if (mediaObject != null && !mediaObject.checkArgs())
        {
            LogUtil.e("Weibo.WeiboMessage", "checkArgs fail, mediaObject is invalid");
            return false;
        } else
        {
            return true;
        }
    }

    public Bundle toBundle(Bundle bundle)
    {
        if (mediaObject != null)
        {
            bundle.putParcelable("_weibo_message_media", mediaObject);
            bundle.putString("_weibo_message_media_extra", mediaObject.toExtraMediaString());
        }
        return bundle;
    }

    public WeiboMessage toObject(Bundle bundle)
    {
        mediaObject = (BaseMediaObject)bundle.getParcelable("_weibo_message_media");
        if (mediaObject != null)
        {
            mediaObject.toExtraMediaObject(bundle.getString("_weibo_message_media_extra"));
        }
        return this;
    }
}
