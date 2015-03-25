// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location.core;


public class AMapLocException extends Exception
{

    public static final int ERROR_CODE_CONNECTION = 30;
    public static final int ERROR_CODE_FAILURE_AUTH = 32;
    public static final int ERROR_CODE_INVALID_PARAMETER = 24;
    public static final int ERROR_CODE_IO = 21;
    public static final int ERROR_CODE_NULL_PARAMETER = 25;
    public static final int ERROR_CODE_PROTOCOL = 29;
    public static final int ERROR_CODE_SOCKET = 22;
    public static final int ERROR_CODE_SOCKE_TIME_OUT = 23;
    public static final int ERROR_CODE_UNKNOWN = 31;
    public static final int ERROR_CODE_UNKNOW_HOST = 27;
    public static final int ERROR_CODE_UNKNOW_SERVICE = 28;
    public static final int ERROR_CODE_URL = 26;
    public static final String ERROR_CONNECTION = "http\u8FDE\u63A5\u5931\u8D25 - ConnectionException";
    public static final String ERROR_FAILURE_AUTH = "key\u9274\u6743\u5931\u8D25";
    public static final String ERROR_INVALID_PARAMETER = "\u65E0\u6548\u7684\u53C2\u6570 - IllegalArgumentException";
    public static final String ERROR_IO = "IO \u64CD\u4F5C\u5F02\u5E38 - IOException";
    public static final String ERROR_NULL_PARAMETER = "\u7A7A\u6307\u9488\u5F02\u5E38 - NullPointException";
    public static final String ERROR_PROTOCOL = "\u534F\u8BAE\u89E3\u6790\u9519\u8BEF - ProtocolException";
    public static final String ERROR_SOCKET = "socket \u8FDE\u63A5\u5F02\u5E38 - SocketException";
    public static final String ERROR_SOCKE_TIME_OUT = "socket \u8FDE\u63A5\u8D85\u65F6 - SocketTimeoutException";
    public static final String ERROR_UNKNOWN = "\u672A\u77E5\u7684\u9519\u8BEF";
    public static final String ERROR_UNKNOW_HOST = "\u672A\u77E5\u4E3B\u673A - UnKnowHostException";
    public static final String ERROR_UNKNOW_SERVICE = "\u670D\u52A1\u5668\u8FDE\u63A5\u5931\u8D25 - UnknownServiceException";
    public static final String ERROR_URL = "url\u5F02\u5E38 - MalformedURLException";
    private String a;
    private int b;

    public AMapLocException()
    {
        a = "\u6B63\u5E38";
        b = 0;
    }

    public AMapLocException(String s)
    {
        a = "\u6B63\u5E38";
        b = 0;
        a = s;
        a(s);
    }

    private void a(String s)
    {
        if ("IO \u64CD\u4F5C\u5F02\u5E38 - IOException".equals(s))
        {
            b = 21;
        } else
        {
            if ("socket \u8FDE\u63A5\u5F02\u5E38 - SocketException".equals(s))
            {
                b = 22;
                return;
            }
            if ("socket \u8FDE\u63A5\u8D85\u65F6 - SocketTimeoutException".equals(s))
            {
                b = 23;
                return;
            }
            if ("\u65E0\u6548\u7684\u53C2\u6570 - IllegalArgumentException".equals(s))
            {
                b = 24;
                return;
            }
            if ("\u7A7A\u6307\u9488\u5F02\u5E38 - NullPointException".equals(s))
            {
                b = 25;
                return;
            }
            if ("url\u5F02\u5E38 - MalformedURLException".equals(s))
            {
                b = 26;
                return;
            }
            if ("\u672A\u77E5\u4E3B\u673A - UnKnowHostException".equals(s))
            {
                b = 27;
                return;
            }
            if ("\u670D\u52A1\u5668\u8FDE\u63A5\u5931\u8D25 - UnknownServiceException".equals(s))
            {
                b = 28;
                return;
            }
            if ("\u534F\u8BAE\u89E3\u6790\u9519\u8BEF - ProtocolException".equals(s))
            {
                b = 29;
                return;
            }
            if ("http\u8FDE\u63A5\u5931\u8D25 - ConnectionException".equals(s))
            {
                b = 30;
                return;
            }
            if ("\u672A\u77E5\u7684\u9519\u8BEF".equals(s))
            {
                b = 31;
                return;
            }
            if ("key\u9274\u6743\u5931\u8D25".equals(s))
            {
                b = 32;
                return;
            }
        }
    }

    public int getErrorCode()
    {
        return b;
    }

    public String getErrorMessage()
    {
        return a;
    }
}
