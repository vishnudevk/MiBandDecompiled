// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMessage;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            BaseRequest, VersionCheckHandler

public class SendMessageToWeiboRequest extends BaseRequest
{

    public WeiboMessage message;

    public SendMessageToWeiboRequest()
    {
    }

    public SendMessageToWeiboRequest(Bundle bundle)
    {
        fromBundle(bundle);
    }

    final boolean check(Context context, VersionCheckHandler versioncheckhandler)
    {
        while (message == null || versioncheckhandler != null && !versioncheckhandler.check(context, message)) 
        {
            return false;
        }
        return message.checkArgs();
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
        message = new WeiboMessage(bundle);
    }

    public int getType()
    {
        return 1;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putAll(message.toBundle(bundle));
    }
}
