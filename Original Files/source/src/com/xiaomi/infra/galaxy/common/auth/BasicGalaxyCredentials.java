// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.auth;


// Referenced classes of package com.xiaomi.infra.galaxy.common.auth:
//            GalaxyCredentials

public class BasicGalaxyCredentials
    implements GalaxyCredentials
{

    private final String appId;
    private final String secretKey;

    public BasicGalaxyCredentials(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("appId cannot be null.");
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("Secret key cannot be null.");
        } else
        {
            appId = s;
            secretKey = s1;
            return;
        }
    }

    public String getGalaxyAppId()
    {
        return appId;
    }

    public String getGalaxySecretKey()
    {
        return secretKey;
    }
}
