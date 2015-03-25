// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common;


public class GalaxyVersion
{

    private static String platform = "java";
    private static String userAgent = getUserAgent();
    private static String version = "0.0.1";

    public GalaxyVersion()
    {
    }

    public static String getPlatform()
    {
        return platform;
    }

    public static String getUserAgent()
    {
        if (userAgent == null)
        {
            initializeUserAgent();
        }
        return userAgent;
    }

    public static String getVersion()
    {
        return version;
    }

    private static void initializeUserAgent()
    {
        StringBuilder stringbuilder;
        String s;
        stringbuilder = new StringBuilder(1024);
        stringbuilder.append((new StringBuilder()).append("galaxy-sdk-").append(getPlatform().toLowerCase()).append("/").toString());
        stringbuilder.append(getVersion());
        stringbuilder.append(" ");
        stringbuilder.append((new StringBuilder()).append(System.getProperty("os.name").replace(' ', '_')).append("/").append(System.getProperty("os.version").replace(' ', '_')).toString());
        stringbuilder.append(" ");
        stringbuilder.append((new StringBuilder()).append(System.getProperty("java.vm.name").replace(' ', '_')).append("/").append(System.getProperty("java.vm.version").replace(' ', '_')).toString());
        s = "";
        String s1 = (new StringBuilder()).append(" ").append(System.getProperty("user.language").replace(' ', '_')).append("_").append(System.getProperty("user.region").replace(' ', '_')).toString();
        s = s1;
_L2:
        stringbuilder.append(s);
        userAgent = stringbuilder.toString();
        return;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
