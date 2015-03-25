// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;


// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            StorageAccessTokenRequest, OAuthProvider

public class QQSatRequest extends StorageAccessTokenRequest
{

    public static final String OAUTHTYPE_OPEN = "open";
    public static final String OAUTHTYPE_WEIBO = "weibo";
    private String oauthType;
    private String openid;

    public QQSatRequest()
    {
        setOauthProvider(null);
    }

    public String getOauthType()
    {
        return oauthType;
    }

    public String getOpenid()
    {
        return openid;
    }

    public void setOauthProvider(String s)
    {
        super.setOauthProvider(OAuthProvider.QQ.name());
    }

    public void setOauthType(String s)
    {
        oauthType = s;
    }

    public void setOpenid(String s)
    {
        openid = s;
    }

    public StorageAccessTokenRequest withOauthProvider(OAuthProvider oauthprovider)
    {
        setOauthProvider(OAuthProvider.QQ.name());
        return this;
    }

    public QQSatRequest withOauthType(String s)
    {
        setOauthType(s);
        return this;
    }

    public QQSatRequest withOpenid(String s)
    {
        setOpenid(s);
        return this;
    }
}
