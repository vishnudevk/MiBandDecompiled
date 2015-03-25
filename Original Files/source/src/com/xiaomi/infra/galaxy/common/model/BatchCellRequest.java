// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            SetRequest, DeleteRequest, GetRequest

public class BatchCellRequest
{

    private DeleteRequest delete;
    private GetRequest get;
    private SetRequest set;

    public BatchCellRequest()
    {
    }

    public DeleteRequest getDelete()
    {
        return delete;
    }

    public GetRequest getGet()
    {
        return get;
    }

    public SetRequest getSet()
    {
        return set;
    }

    public void setDelete(DeleteRequest deleterequest)
    {
        delete = deleterequest;
    }

    public void setGet(GetRequest getrequest)
    {
        get = getrequest;
    }

    public void setSet(SetRequest setrequest)
    {
        set = setrequest;
    }

    public void validate()
    {
        SetRequest setrequest = set;
        int i = 0;
        if (setrequest != null)
        {
            set.validate();
            i = 1;
        }
        if (delete != null)
        {
            delete.validate();
            i++;
        }
        if (get != null)
        {
            get.validate();
            i++;
        }
        if (i != 1)
        {
            throw new GalaxyClientException(ReturnCode.BATCH_CELLS_IS_NOT_ONLY, "");
        } else
        {
            return;
        }
    }

    public BatchCellRequest withDelete(DeleteRequest deleterequest)
    {
        setDelete(deleterequest);
        return this;
    }

    public BatchCellRequest withGet(GetRequest getrequest)
    {
        setGet(getrequest);
        return this;
    }

    public BatchCellRequest withSet(SetRequest setrequest)
    {
        setSet(setrequest);
        return this;
    }
}
