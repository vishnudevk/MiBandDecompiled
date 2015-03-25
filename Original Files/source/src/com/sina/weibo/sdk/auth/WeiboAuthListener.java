// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import com.sina.weibo.sdk.exception.WeiboException;

public interface WeiboAuthListener
{

    public abstract void onCancel();

    public abstract void onComplete(Bundle bundle);

    public abstract void onWeiboException(WeiboException weiboexception);
}
