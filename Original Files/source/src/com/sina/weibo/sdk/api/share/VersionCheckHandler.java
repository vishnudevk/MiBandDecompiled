// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.content.Context;
import com.sina.weibo.sdk.api.CmdObject;
import com.sina.weibo.sdk.api.VoiceObject;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.utils.LogUtil;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            IVersionCheckHandler, ApiUtils

public class VersionCheckHandler
    implements IVersionCheckHandler
{

    private static final String TAG = "VersionCheckHandler";
    private String mPackageName;

    public VersionCheckHandler()
    {
    }

    public VersionCheckHandler(String s)
    {
        mPackageName = s;
    }

    public boolean check(Context context, WeiboMessage weibomessage)
    {
        LogUtil.d("VersionCheckHandler", (new StringBuilder("check WeiboMessage package : ")).append(mPackageName).toString());
        ApiUtils.WeiboInfo weiboinfo;
        if (mPackageName != null && mPackageName.length() != 0)
        {
            if ((weiboinfo = ApiUtils.queryWeiboInfoByPackage(context, mPackageName)) != null)
            {
                LogUtil.d("VersionCheckHandler", (new StringBuilder("check WeiboMessage WeiboInfo supportApi : ")).append(weiboinfo.supportApi).toString());
                if (weiboinfo.supportApi < 10351 && weibomessage.mediaObject != null && (weibomessage.mediaObject instanceof VoiceObject))
                {
                    weibomessage.mediaObject = null;
                }
                if (weiboinfo.supportApi < 10352 && weibomessage.mediaObject != null && (weibomessage.mediaObject instanceof CmdObject))
                {
                    weibomessage.mediaObject = null;
                }
                return true;
            }
        }
        return false;
    }

    public boolean check(Context context, WeiboMultiMessage weibomultimessage)
    {
        LogUtil.d("VersionCheckHandler", (new StringBuilder("check WeiboMultiMessage package : ")).append(mPackageName).toString());
        ApiUtils.WeiboInfo weiboinfo;
        if (mPackageName != null && mPackageName.length() != 0)
        {
            if ((weiboinfo = ApiUtils.queryWeiboInfoByPackage(context, mPackageName)) != null)
            {
                LogUtil.d("VersionCheckHandler", (new StringBuilder("check WeiboMultiMessage WeiboInfo supportApi : ")).append(weiboinfo.supportApi).toString());
                if (weiboinfo.supportApi >= 10351)
                {
                    if (weiboinfo.supportApi < 10352 && weibomultimessage.mediaObject != null && (weibomultimessage.mediaObject instanceof CmdObject))
                    {
                        weibomultimessage.mediaObject = null;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void setPackageName(String s)
    {
        mPackageName = s;
    }
}
