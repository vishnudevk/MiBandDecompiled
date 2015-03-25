// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.exception;


public class WeiboException extends RuntimeException
{

    private static final long serialVersionUID = 0x6979ee5a4b2fff8L;

    public WeiboException()
    {
    }

    public WeiboException(String s)
    {
        super(s);
    }

    public WeiboException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public WeiboException(Throwable throwable)
    {
        super(throwable);
    }
}
