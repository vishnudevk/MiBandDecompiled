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
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Request, BatchCellRequest

public class BatchRequest extends Request
{

    private List batchCells;

    public BatchRequest()
    {
    }

    public List getBatchCells()
    {
        return batchCells;
    }

    protected BasicGalaxyRequest internalGetGalaxyRequest(String s, APILevel apilevel)
    {
        BasicGalaxyRequest basicgalaxyrequest = new BasicGalaxyRequest(this, "Galaxy");
        TargetAction targetaction = new TargetAction();
        targetaction.setApiVersion(GalaxyVersion.getVersion());
        targetaction.setLevel(apilevel);
        targetaction.setOperation(Operation.Batch);
        targetaction.setServiceName("Galaxy");
        basicgalaxyrequest.addHeader("X-XiaoMi-Action", targetaction.format());
        super.setRequestContent(basicgalaxyrequest, s);
        return basicgalaxyrequest;
    }

    public void setBatchCells(List list)
    {
        batchCells = list;
    }

    public void validate()
    {
        if (batchCells == null || batchCells.isEmpty())
        {
            throw new GalaxyClientException(ReturnCode.BATCH_CELLS_IS_EMPTY);
        }
        for (Iterator iterator = batchCells.iterator(); iterator.hasNext(); ((BatchCellRequest)iterator.next()).validate()) { }
    }

    public BatchRequest withBatchCells(List list)
    {
        setBatchCells(list);
        return this;
    }
}
