// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.exception;


// Referenced classes of package com.sina.weibo.sdk.exception:
//            WeiboException

public class WeiboDialogException extends WeiboException
{

    private static final long serialVersionUID = 1L;
    private int mErrorCode;
    private String mFailingUrl;

    public WeiboDialogException(String s, int i, String s1)
    {
        super(s);
        mErrorCode = i;
        mFailingUrl = s1;
    }

    public int getErrorCode()
    {
        return mErrorCode;
    }

    public String getFailingUrl()
    {
        return mFailingUrl;
    }
}
