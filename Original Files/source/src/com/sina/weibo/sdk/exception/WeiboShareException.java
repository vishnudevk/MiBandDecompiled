// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.exception;


// Referenced classes of package com.sina.weibo.sdk.exception:
//            WeiboException

public class WeiboShareException extends WeiboException
{

    private static final long serialVersionUID = 1L;

    public WeiboShareException()
    {
    }

    public WeiboShareException(String s)
    {
        super(s);
    }

    public WeiboShareException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public WeiboShareException(Throwable throwable)
    {
        super(throwable);
    }
}
