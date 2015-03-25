// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.os.Bundle;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            Base

public abstract class BaseResponse extends Base
{

    public int errCode;
    public String errMsg;
    public String reqPackageName;

    public BaseResponse()
    {
    }

    public void fromBundle(Bundle bundle)
    {
        errCode = bundle.getInt("_weibo_resp_errcode");
        errMsg = bundle.getString("_weibo_resp_errstr");
        transaction = bundle.getString("_weibo_transaction");
        reqPackageName = bundle.getString("_weibo_appPackage");
    }

    public void toBundle(Bundle bundle)
    {
        bundle.putInt("_weibo_command_type", getType());
        bundle.putInt("_weibo_resp_errcode", errCode);
        bundle.putString("_weibo_resp_errstr", errMsg);
        bundle.putString("_weibo_transaction", transaction);
    }
}
