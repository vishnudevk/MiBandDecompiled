// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common;


public final class Protocol extends Enum
{

    private static final Protocol $VALUES[];
    public static final Protocol HTTP;
    public static final Protocol HTTPS;
    private final String protocol;

    private Protocol(String s, int i, String s1)
    {
        super(s, i);
        protocol = s1;
    }

    public static Protocol valueOf(String s)
    {
        return (Protocol)Enum.valueOf(com/xiaomi/infra/galaxy/common/Protocol, s);
    }

    public static Protocol[] values()
    {
        return (Protocol[])$VALUES.clone();
    }

    public String toString()
    {
        return protocol;
    }

    static 
    {
        HTTP = new Protocol("HTTP", 0, "http");
        HTTPS = new Protocol("HTTPS", 1, "https");
        Protocol aprotocol[] = new Protocol[2];
        aprotocol[0] = HTTP;
        aprotocol[1] = HTTPS;
        $VALUES = aprotocol;
    }
}
