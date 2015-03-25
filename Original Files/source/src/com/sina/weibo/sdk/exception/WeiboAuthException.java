// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.exception;


// Referenced classes of package com.sina.weibo.sdk.exception:
//            WeiboException

public class WeiboAuthException extends WeiboException
{

    public static final String DEFAULT_AUTH_ERROR_CODE = "-1";
    public static final String DEFAULT_AUTH_ERROR_DESC = "Unknown Error Description";
    public static final String DEFAULT_AUTH_ERROR_TYPE = "Unknown Error Type";
    private static final long serialVersionUID = 1L;
    private final String mErrorCode;
    private final String mErrorType;

    public WeiboAuthException(String s, String s1, String s2)
    {
        super(s);
        mErrorType = s1;
        mErrorCode = s2;
    }

    public String getErrorCode()
    {
        return mErrorCode;
    }

    public String getErrorType()
    {
        return mErrorType;
    }
}
