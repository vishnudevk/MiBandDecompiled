// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Result

public class GetAppInfoResult extends Result
{

    private String appId;
    private Map authMethods;
    private List unusedTables;
    private List usedTables;

    public GetAppInfoResult()
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

    public List getUnusedTables()
    {
        return unusedTables;
    }

    public List getUsedTables()
    {
        return usedTables;
    }

    public void setAppId(String s)
    {
        appId = s;
    }

    public void setAuthMethods(Map map)
    {
        authMethods = map;
    }

    public void setUnusedTables(List list)
    {
        unusedTables = list;
    }

    public void setUsedTables(List list)
    {
        usedTables = list;
    }
}
