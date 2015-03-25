// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;


// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            DeleteResult, GetResult, SetResult

public class BatchCellResult
{

    private DeleteResult delete;
    private GetResult get;
    private SetResult set;

    public BatchCellResult()
    {
    }

    public DeleteResult getDelete()
    {
        return delete;
    }

    public GetResult getGet()
    {
        return get;
    }

    public SetResult getSet()
    {
        return set;
    }

    public void setDelete(DeleteResult deleteresult)
    {
        delete = deleteresult;
    }

    public void setGet(GetResult getresult)
    {
        get = getresult;
    }

    public void setSet(SetResult setresult)
    {
        set = setresult;
    }
}
