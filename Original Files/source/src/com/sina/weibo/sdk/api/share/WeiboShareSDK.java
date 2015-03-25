// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.content.Context;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            WeiboShareAPIImpl, IWeiboShareAPI

public class WeiboShareSDK
{

    public WeiboShareSDK()
    {
    }

    public static IWeiboShareAPI createWeiboAPI(Context context, String s)
    {
        return createWeiboAPI(context, s, true);
    }

    public static IWeiboShareAPI createWeiboAPI(Context context, String s, boolean flag)
    {
        return new WeiboShareAPIImpl(context, s, flag);
    }
}
