// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common;


public final class HttpMethodName extends Enum
{

    private static final HttpMethodName $VALUES[];
    public static final HttpMethodName DELETE;
    public static final HttpMethodName GET;
    public static final HttpMethodName HEAD;
    public static final HttpMethodName POST;
    public static final HttpMethodName PUT;

    private HttpMethodName(String s, int i)
    {
        super(s, i);
    }

    public static HttpMethodName valueOf(String s)
    {
        return (HttpMethodName)Enum.valueOf(com/xiaomi/infra/galaxy/common/HttpMethodName, s);
    }

    public static HttpMethodName[] values()
    {
        return (HttpMethodName[])$VALUES.clone();
    }

    static 
    {
        GET = new HttpMethodName("GET", 0);
        POST = new HttpMethodName("POST", 1);
        PUT = new HttpMethodName("PUT", 2);
        DELETE = new HttpMethodName("DELETE", 3);
        HEAD = new HttpMethodName("HEAD", 4);
        HttpMethodName ahttpmethodname[] = new HttpMethodName[5];
        ahttpmethodname[0] = GET;
        ahttpmethodname[1] = POST;
        ahttpmethodname[2] = PUT;
        ahttpmethodname[3] = DELETE;
        ahttpmethodname[4] = HEAD;
        $VALUES = ahttpmethodname;
    }
}
