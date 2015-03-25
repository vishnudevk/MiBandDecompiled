// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Request

public class AlterTableRequest extends Request
{

    private List attributeDefinitions;
    private Set grantedApps;
    private String tableName;
    private Set unGrantedApps;

    public AlterTableRequest()
    {
    }

    public List getAttributeDefinitions()
    {
        return attributeDefinitions;
    }

    public Set getGrantedApps()
    {
        return grantedApps;
    }

    public String getTableName()
    {
        return tableName;
    }

    public Set getUnGrantedApps()
    {
        return unGrantedApps;
    }

    protected BasicGalaxyRequest internalGetGalaxyRequest(String s, APILevel apilevel)
    {
        BasicGalaxyRequest basicgalaxyrequest = new BasicGalaxyRequest(this, "Galaxy");
        TargetAction targetaction = new TargetAction();
        targetaction.setApiVersion(GalaxyVersion.getVersion());
        targetaction.setLevel(APILevel.Developer);
        targetaction.setOperation(Operation.AlterTable);
        targetaction.setServiceName("Galaxy");
        basicgalaxyrequest.addHeader("X-XiaoMi-Action", targetaction.format());
        super.setRequestContent(basicgalaxyrequest, s);
        return basicgalaxyrequest;
    }

    public void setAttributeDefinitions(List list)
    {
        attributeDefinitions = list;
    }

    public void setGrantedApps(Set set)
    {
        grantedApps = set;
    }

    public void setTableName(String s)
    {
        tableName = s;
    }

    public void setUnGrantedApps(Set set)
    {
        unGrantedApps = set;
    }

    public void validate()
    {
    }

    public AlterTableRequest withAttributeDefinitions(List list)
    {
        setAttributeDefinitions(list);
        return this;
    }

    public AlterTableRequest withGrantedApps(Set set)
    {
        setGrantedApps(set);
        return this;
    }

    public AlterTableRequest withTableName(String s)
    {
        setTableName(s);
        return this;
    }

    public AlterTableRequest withUnGrantedApps(Set set)
    {
        setUnGrantedApps(set);
        return this;
    }
}
