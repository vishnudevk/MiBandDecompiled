// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import java.util.Map;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Request

public class AlterAppInfoRequest extends Request
{

    private String appId;
    private Map authMethods;

    public AlterAppInfoRequest()
    {
    }

    public String getAppId()
    {
        return appId;
    }

    public Map getAuthMethods()
    {
        return authMethods;
    }

    protected BasicGalaxyRequest internalGetGalaxyRequest(String s, APILevel apilevel)
    {
        BasicGalaxyRequest basicgalaxyrequest = new BasicGalaxyRequest(this, "Galaxy");
        TargetAction targetaction = new TargetAction();
        targetaction.setApiVersion(GalaxyVersion.getVersion());
        targetaction.setLevel(APILevel.Developer);
        targetaction.setOperation(Operation.AlterAppInfo);
        targetaction.setServiceName("Galaxy");
        basicgalaxyrequest.addHeader("X-XiaoMi-Action", targetaction.format());
        super.setRequestContent(basicgalaxyrequest, s);
        return basicgalaxyrequest;
    }

    public void setAppId(String s)
    {
        appId = s;
    }

    public void setAuthMethods(Map map)
    {
        authMethods = map;
    }

    public void validate()
    {
        if (appId == null || "".equals(appId.trim()))
        {
            throw new GalaxyClientException(ReturnCode.APP_ID_IS_BLANK);
        } else
        {
            return;
        }
    }

    public AlterAppInfoRequest withAppId(String s)
    {
        setAppId(s);
        return this;
    }

    public AlterAppInfoRequest withAuthMethods(Map map)
    {
        setAuthMethods(map);
        return this;
    }
}
