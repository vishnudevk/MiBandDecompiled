// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.auth;

import com.xiaomi.infra.galaxy.common.SessionExpiredException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.model.StorageAccessTokenResult;

// Referenced classes of package com.xiaomi.infra.galaxy.common.auth:
//            GalaxyCredentials

public class SessionCredentials
    implements GalaxyCredentials
{

    private final String appId;
    private StorageAccessTokenResult storageAccessTokenResult;

    public SessionCredentials(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("appId cannot be null.");
        } else
        {
            appId = s;
            return;
        }
    }

    public String getGalaxyAppId()
    {
        return appId;
    }

    public String getGalaxySecretKey()
    {
        if (storageAccessTokenResult == null)
        {
            return "";
        }
        if (System.currentTimeMillis() >= storageAccessTokenResult.getExpiresIn())
        {
            throw new SessionExpiredException(ReturnCode.STORAGEACCESS_TOKEN_IS_EXPIRED, "storage access token is expired, you should get a new one from galaxy server");
        } else
        {
            return storageAccessTokenResult.getStorageAccessToken();
        }
    }

    public StorageAccessTokenResult getStorageAccessTokenResult()
    {
        return storageAccessTokenResult;
    }

    public void setStorageAccessTokenResult(StorageAccessTokenResult storageaccesstokenresult)
    {
        storageAccessTokenResult = storageaccesstokenresult;
    }
}
