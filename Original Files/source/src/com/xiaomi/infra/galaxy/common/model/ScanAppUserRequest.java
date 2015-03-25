// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Request

public class ScanAppUserRequest extends Request
{

    private int limit;
    private String startUserId;
    private String stopUserId;
    private String tableName;

    public ScanAppUserRequest()
    {
    }

    public int getLimit()
    {
        return limit;
    }

    public String getStartUserId()
    {
        return startUserId;
    }

    public String getStopUserId()
    {
        return stopUserId;
    }

    public String getTableName()
    {
        return tableName;
    }

    protected BasicGalaxyRequest internalGetGalaxyRequest(String s, APILevel apilevel)
    {
        BasicGalaxyRequest basicgalaxyrequest = new BasicGalaxyRequest(this, "Galaxy");
        TargetAction targetaction = new TargetAction();
        targetaction.setApiVersion(GalaxyVersion.getVersion());
        targetaction.setLevel(apilevel);
        targetaction.setOperation(Operation.ScanAppUser);
        targetaction.setServiceName("Galaxy");
        basicgalaxyrequest.addHeader("X-XiaoMi-Action", targetaction.format());
        super.setRequestContent(basicgalaxyrequest, s);
        return basicgalaxyrequest;
    }

    public void setLimit(int i)
    {
        limit = i;
    }

    public void setStartUserId(String s)
    {
        startUserId = s;
    }

    public void setStopUserId(String s)
    {
        stopUserId = s;
    }

    public void setTableName(String s)
    {
        tableName = s;
    }

    public void validate()
    {
    }
}
