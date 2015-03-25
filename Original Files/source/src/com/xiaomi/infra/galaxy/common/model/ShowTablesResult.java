// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import java.util.List;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Result

public class ShowTablesResult extends Result
{

    private List tables;
    private List unusedTables;

    public ShowTablesResult()
    {
    }

    public List getTables()
    {
        return tables;
    }

    public List getUnusedTables()
    {
        return unusedTables;
    }

    public void setTables(List list)
    {
        tables = list;
    }

    public void setUnusedTables(List list)
    {
        unusedTables = list;
    }
}
