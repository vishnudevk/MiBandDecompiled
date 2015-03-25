// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.content.Intent;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            IWeiboDownloadListener, BaseRequest, BaseResponse

public interface IWeiboShareAPI
{

    public abstract boolean checkEnvironment(boolean flag);

    public abstract int getWeiboAppSupportAPI();

    public abstract boolean handleWeiboRequest(Intent intent, IWeiboHandler.Request request);

    public abstract boolean handleWeiboResponse(Intent intent, IWeiboHandler.Response response);

    public abstract boolean isWeiboAppInstalled();

    public abstract boolean isWeiboAppSupportAPI();

    public abstract boolean launchWeibo();

    public abstract boolean registerApp();

    public abstract void registerWeiboDownloadListener(IWeiboDownloadListener iweibodownloadlistener);

    public abstract boolean sendRequest(BaseRequest baserequest);

    public abstract boolean sendResponse(BaseResponse baseresponse);
}
