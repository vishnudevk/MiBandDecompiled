// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;


// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            StorageAccessTokenRequest, OAuthProvider

public class MiSatRequest extends StorageAccessTokenRequest
{

    private String macAlgorithm;
    private String macKey;

    public MiSatRequest()
    {
        setOauthProvider(null);
    }

    public String getMacAlgorithm()
    {
        return macAlgorithm;
    }

    public String getMacKey()
    {
        return macKey;
    }

    public void setMacAlgorithm(String s)
    {
        macAlgorithm = s;
    }

    public void setMacKey(String s)
    {
        macKey = s;
    }

    public void setOauthProvider(String s)
    {
        super.setOauthProvider(OAuthProvider.XiaoMi.name());
    }

    public MiSatRequest withMacAlgorithm(String s)
    {
        setMacAlgorithm(s);
        return this;
    }

    public MiSatRequest withMacKey(String s)
    {
        setMacKey(s);
        return this;
    }

    public StorageAccessTokenRequest withOauthProvider(OAuthProvider oauthprovider)
    {
        setOauthProvider(OAuthProvider.XiaoMi.name());
        return this;
    }
}
