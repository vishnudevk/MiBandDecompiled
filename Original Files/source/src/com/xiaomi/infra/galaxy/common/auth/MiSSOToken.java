// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.auth;


public class MiSSOToken
{

    private String security;
    private String serviceToken;
    private String userId;

    public MiSSOToken(String s, String s1, String s2)
    {
        userId = s;
        serviceToken = s1;
        security = s2;
    }

    public String getSecurity()
    {
        return security;
    }

    public String getServiceToken()
    {
        return serviceToken;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setSecurity(String s)
    {
        security = s;
    }

    public void setServiceToken(String s)
    {
        serviceToken = s;
    }

    public void setUserId(String s)
    {
        userId = s;
    }
}
