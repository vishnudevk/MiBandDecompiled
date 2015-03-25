// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import com.xiaomi.infra.galaxy.common.util.StringUtils;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Request, OAuthProvider

public class StorageAccessTokenRequest extends Request
{

    private String accessToken;
    private String appId;
    private String oauthAppId;
    private String oauthProvider;
    private String oauthVersion;

    public StorageAccessTokenRequest()
    {
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = false;
        if (obj == null) goto _L4; else goto _L3
_L3:
        boolean flag1;
        flag1 = obj instanceof StorageAccessTokenRequest;
        flag = false;
        if (!flag1) goto _L4; else goto _L5
_L5:
        StorageAccessTokenRequest storageaccesstokenrequest = (StorageAccessTokenRequest)obj;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag7;
        boolean flag10;
        boolean flag13;
        boolean flag16;
        boolean flag17;
        boolean flag18;
        boolean flag19;
        boolean flag20;
        boolean flag21;
        if (storageaccesstokenrequest.getAppId() == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (getAppId() == null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        flag4 = flag2 ^ flag3;
        flag = false;
        if (flag4) goto _L4; else goto _L6
_L6:
        if (storageaccesstokenrequest.getAppId() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag21 = storageaccesstokenrequest.getAppId().equals(getAppId());
        flag = false;
        if (!flag21) goto _L4; else goto _L7
_L7:
        boolean flag5;
        boolean flag6;
        if (storageaccesstokenrequest.getOauthAppId() == null)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (getOauthAppId() == null)
        {
            flag6 = true;
        } else
        {
            flag6 = false;
        }
        flag7 = flag5 ^ flag6;
        flag = false;
        if (flag7) goto _L4; else goto _L8
_L8:
        if (storageaccesstokenrequest.getOauthAppId() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag20 = storageaccesstokenrequest.getOauthAppId().equals(getOauthAppId());
        flag = false;
        if (!flag20) goto _L4; else goto _L9
_L9:
        boolean flag8;
        boolean flag9;
        if (storageaccesstokenrequest.getAccessToken() == null)
        {
            flag8 = true;
        } else
        {
            flag8 = false;
        }
        if (getAccessToken() == null)
        {
            flag9 = true;
        } else
        {
            flag9 = false;
        }
        flag10 = flag8 ^ flag9;
        flag = false;
        if (flag10) goto _L4; else goto _L10
_L10:
        if (storageaccesstokenrequest.getAccessToken() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag19 = storageaccesstokenrequest.getAccessToken().equals(getAccessToken());
        flag = false;
        if (!flag19) goto _L4; else goto _L11
_L11:
        boolean flag11;
        boolean flag12;
        if (storageaccesstokenrequest.getOauthProvider() == null)
        {
            flag11 = true;
        } else
        {
            flag11 = false;
        }
        if (getOauthProvider() == null)
        {
            flag12 = true;
        } else
        {
            flag12 = false;
        }
        flag13 = flag11 ^ flag12;
        flag = false;
        if (flag13) goto _L4; else goto _L12
_L12:
        if (storageaccesstokenrequest.getOauthProvider() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag18 = storageaccesstokenrequest.getOauthProvider().equals(getOauthProvider());
        flag = false;
        if (!flag18) goto _L4; else goto _L13
_L13:
        boolean flag14;
        boolean flag15;
        if (storageaccesstokenrequest.getOauthVersion() == null)
        {
            flag14 = true;
        } else
        {
            flag14 = false;
        }
        if (getOauthVersion() == null)
        {
            flag15 = true;
        } else
        {
            flag15 = false;
        }
        flag16 = flag14 ^ flag15;
        flag = false;
        if (flag16) goto _L4; else goto _L14
_L14:
        if (storageaccesstokenrequest.getOauthVersion() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag17 = storageaccesstokenrequest.getOauthVersion().equals(getOauthVersion());
        flag = false;
        if (!flag17) goto _L4; else goto _L15
_L15:
        return true;
    }

    public String getAccessToken()
    {
        return accessToken;
    }

    public String getAppId()
    {
        return appId;
    }

    public String getOauthAppId()
    {
        return oauthAppId;
    }

    public String getOauthProvider()
    {
        return oauthProvider;
    }

    public String getOauthVersion()
    {
        return oauthVersion;
    }

    public int hashCode()
    {
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        String s;
        int i2;
        if (getAppId() == null)
        {
            i = 0;
        } else
        {
            i = getAppId().hashCode();
        }
        j = 31 * (i + 31);
        if (getOauthAppId() == null)
        {
            k = 0;
        } else
        {
            k = getOauthAppId().hashCode();
        }
        l = 31 * (k + j);
        if (getAccessToken() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getAccessToken().hashCode();
        }
        j1 = 31 * (i1 + l);
        if (getOauthProvider() == null)
        {
            k1 = 0;
        } else
        {
            k1 = getOauthProvider().hashCode();
        }
        l1 = 31 * (k1 + j1);
        s = getOauthVersion();
        i2 = 0;
        if (s != null)
        {
            i2 = getOauthVersion().hashCode();
        }
        return l1 + i2;
    }

    public BasicGalaxyRequest internalGetGalaxyRequest(String s, APILevel apilevel)
    {
        BasicGalaxyRequest basicgalaxyrequest = new BasicGalaxyRequest(this, "Galaxy");
        TargetAction targetaction = new TargetAction();
        targetaction.setApiVersion(GalaxyVersion.getVersion());
        targetaction.setLevel(APILevel.User);
        targetaction.setOperation(Operation.Auth);
        targetaction.setServiceName("Galaxy");
        basicgalaxyrequest.addHeader("X-XiaoMi-Action", targetaction.format());
        super.setRequestContent(basicgalaxyrequest, s);
        return basicgalaxyrequest;
    }

    public void setAccessToken(String s)
    {
        accessToken = s;
    }

    public void setAppId(String s)
    {
        appId = s;
    }

    public void setOauthAppId(String s)
    {
        oauthAppId = s;
    }

    public void setOauthProvider(String s)
    {
        oauthProvider = s;
    }

    public void setOauthVersion(String s)
    {
        oauthVersion = s;
    }

    public void validate()
    {
        if (!StringUtils.isBlank(appId));
        if (!StringUtils.isBlank(oauthAppId));
        if (!StringUtils.isBlank(accessToken));
        if (!StringUtils.isBlank(oauthProvider));
        if (!StringUtils.isBlank(oauthVersion));
    }

    public StorageAccessTokenRequest withAccessToken(String s)
    {
        setAccessToken(s);
        return this;
    }

    public StorageAccessTokenRequest withAppId(String s)
    {
        setAppId(s);
        return this;
    }

    public StorageAccessTokenRequest withOauthAppId(String s)
    {
        setOauthAppId(s);
        return this;
    }

    public StorageAccessTokenRequest withOauthProvider(OAuthProvider oauthprovider)
    {
        setOauthProvider(oauthprovider.name());
        return this;
    }

    public StorageAccessTokenRequest withOauthVersion(String s)
    {
        setOauthVersion(s);
        return this;
    }
}
