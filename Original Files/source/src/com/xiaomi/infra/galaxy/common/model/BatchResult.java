// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import java.util.List;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Result

public class BatchResult extends Result
{

    private List batchCells;

    public BatchResult()
    {
    }

    public List getBatchCells()
    {
        return batchCells;
    }

    public void setBatchCells(List list)
    {
        batchCells = list;
    }
}
