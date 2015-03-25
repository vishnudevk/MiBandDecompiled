// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;


public final class OAuthProvider extends Enum
{

    private static final OAuthProvider $VALUES[];
    public static final OAuthProvider QQ;
    public static final OAuthProvider Renren;
    public static final OAuthProvider ServerAuth;
    public static final OAuthProvider Sina;
    public static final OAuthProvider XiaoMi;
    private String value;

    private OAuthProvider(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static OAuthProvider fromValue(String s)
    {
        if (s == null || "".equals(s))
        {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if ("XiaoMi".equals(s))
        {
            return XiaoMi;
        }
        if ("Sina".equals(s))
        {
            return Sina;
        }
        if ("QQ".equals(s))
        {
            return QQ;
        }
        if ("Renren".equals(s))
        {
            return Renren;
        }
        if ("ServerAuth".equals(s))
        {
            return ServerAuth;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot create enum from ").append(s).append(" value!").toString());
        }
    }

    public static OAuthProvider valueOf(String s)
    {
        return (OAuthProvider)Enum.valueOf(com/xiaomi/infra/galaxy/common/model/OAuthProvider, s);
    }

    public static OAuthProvider[] values()
    {
        return (OAuthProvider[])$VALUES.clone();
    }

    public String toString()
    {
        return value;
    }

    static 
    {
        XiaoMi = new OAuthProvider("XiaoMi", 0, "XiaoMi");
        Sina = new OAuthProvider("Sina", 1, "Sina");
        QQ = new OAuthProvider("QQ", 2, "QQ");
        Renren = new OAuthProvider("Renren", 3, "Renren");
        ServerAuth = new OAuthProvider("ServerAuth", 4, "ServerAuth");
        OAuthProvider aoauthprovider[] = new OAuthProvider[5];
        aoauthprovider[0] = XiaoMi;
        aoauthprovider[1] = Sina;
        aoauthprovider[2] = QQ;
        aoauthprovider[3] = Renren;
        aoauthprovider[4] = ServerAuth;
        $VALUES = aoauthprovider;
    }
}
