// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMultiMessage;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            BaseResponse, VersionCheckHandler

public class ProvideMultiMessageForWeiboResponse extends BaseResponse
{

    public WeiboMultiMessage multiMessage;

    public ProvideMultiMessageForWeiboResponse()
    {
    }

    public ProvideMultiMessageForWeiboResponse(Bundle bundle)
    {
        fromBundle(bundle);
    }

    final boolean check(Context context, VersionCheckHandler versioncheckhandler)
    {
        if (multiMessage != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (versioncheckhandler == null)
        {
            break; /* Loop/switch isn't completed */
        }
        versioncheckhandler.setPackageName(reqPackageName);
        if (!versioncheckhandler.check(context, multiMessage)) goto _L1; else goto _L3
_L3:
        return multiMessage.checkArgs();
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
        multiMessage = new WeiboMultiMessage(bundle);
    }

    public int getType()
    {
        return 2;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putAll(multiMessage.toBundle(bundle));
    }
}
