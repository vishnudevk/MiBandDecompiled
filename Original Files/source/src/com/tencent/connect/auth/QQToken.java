// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;


public class QQToken
{

    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;
    private String a;
    private String b;
    private String c;
    private int d;
    private long e;

    public QQToken(String s)
    {
        d = 1;
        e = -1L;
        a = s;
    }

    public String getAccessToken()
    {
        return b;
    }

    public String getAppId()
    {
        return a;
    }

    public int getAuthSource()
    {
        return d;
    }

    public long getExpireTimeInSecond()
    {
        return e;
    }

    public String getOpenId()
    {
        return c;
    }

    public boolean isSessionValid()
    {
        return b != null && System.currentTimeMillis() < e;
    }

    public void setAccessToken(String s, String s1)
    {
        b = s;
        e = 0L;
        if (s1 != null)
        {
            e = System.currentTimeMillis() + 1000L * Long.parseLong(s1);
        }
    }

    public void setAppId(String s)
    {
        a = s;
    }

    public void setAuthSource(int i)
    {
        d = i;
    }

    public void setOpenId(String s)
    {
        c = s;
    }
}
