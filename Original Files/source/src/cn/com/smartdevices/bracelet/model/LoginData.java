// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


public class LoginData
{

    public String security;
    public long uid;

    public LoginData()
    {
        uid = -1L;
        security = null;
    }

    public boolean isValid()
    {
        return uid != -1L && security != null;
    }

    public String toString()
    {
        return (new StringBuilder()).append("LoginData: uid:").append(uid).append(", security:").append(security).toString();
    }
}
