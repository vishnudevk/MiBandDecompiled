// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.account.openauth.utils;

import java.util.Map;

public class 
{

    public Map AllHeaders;
    public String ContentType;
    public int ResponseCode;
    public String UserAgent;
    public String realUrl;

    public String toString()
    {
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(ResponseCode);
        aobj[1] = AllHeaders.toString();
        return String.format("resCode = %1$d, headers = %2$s", aobj);
    }

    public ()
    {
    }
}
