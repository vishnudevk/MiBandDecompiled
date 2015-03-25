// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;

import java.util.HashMap;

public class AuthMap
{

    static final boolean a;
    private static int b = 0;
    public static AuthMap sInstance;
    public final String KEY_CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public HashMap authMap;

    public AuthMap()
    {
        authMap = new HashMap();
    }

    private String a(String s, String s1)
    {
        int i = 0;
        if (!a && s.length() % 2 != 0)
        {
            throw new AssertionError();
        }
        StringBuilder stringbuilder = new StringBuilder();
        int j = s1.length();
        int k = s.length() / 2;
        int l = 0;
        for (; i < k; i++)
        {
            stringbuilder.append((char)(Integer.parseInt(s.substring(i * 2, 2 + i * 2), 16) ^ s1.charAt(l)));
            l = (l + 1) % j;
        }

        return stringbuilder.toString();
    }

    public static AuthMap getInstance()
    {
        if (sInstance == null)
        {
            sInstance = new AuthMap();
        }
        return sInstance;
    }

    public static int getSerial()
    {
        int i = 1 + b;
        b = i;
        return i;
    }

    public String decode(String s, String s1)
    {
        return a(s, s1);
    }

    public Auth get(String s)
    {
        return (Auth)authMap.get(s);
    }

    public String makeKey()
    {
        int i = (int)Math.ceil(3D + 20D * Math.random());
        char ac[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int j = ac.length;
        StringBuffer stringbuffer = new StringBuffer();
        for (int k = 0; k < i; k++)
        {
            stringbuffer.append(ac[(int)(Math.random() * (double)j)]);
        }

        return stringbuffer.toString();
    }

    public void remove(String s)
    {
        authMap.remove(s);
    }

    public String set(Auth auth)
    {
        int i = getSerial();
        try
        {
            authMap.put((new StringBuilder()).append("").append(i).toString(), auth);
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
        return (new StringBuilder()).append("").append(i).toString();
    }

    static 
    {
        boolean flag;
        if (!com/tencent/connect/auth/AuthMap.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }

    private class Auth
    {

        public AuthDialog dialog;
        public String key;
        public IUiListener listener;

        public Auth()
        {
        }
    }

}
