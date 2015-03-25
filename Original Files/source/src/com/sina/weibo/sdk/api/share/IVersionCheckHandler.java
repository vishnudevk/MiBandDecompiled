// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.content.Context;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;

interface IVersionCheckHandler
{

    public abstract boolean check(Context context, WeiboMessage weibomessage);

    public abstract boolean check(Context context, WeiboMultiMessage weibomultimessage);
}
