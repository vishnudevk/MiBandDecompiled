// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.webapi;


public class WebStatus
{

    public static final int CODE_AUTH_INVALID = 0;
    public static final int CODE_LIKED = 666;
    public static final int CODE_NONE = -1;
    public static final int CODE_OK = 1;
    public static final int CODE_PARSE_FAILED = 2;
    public int code;
    public String message;

    public WebStatus()
    {
        code = -1;
        message = "";
    }

    public boolean equals(Object obj)
    {
        return ((WebStatus)obj).code == code;
    }

    public boolean isAuthInvalid()
    {
        return code == 0;
    }

    public boolean success()
    {
        return code == 1;
    }
}
