// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.async;

import de.greenrobot.dao.DaoException;

// Referenced classes of package de.greenrobot.dao.async:
//            AsyncOperation

public class AsyncDaoException extends DaoException
{

    private static final long serialVersionUID = 0x517e182e78643b2eL;
    private final AsyncOperation failedOperation;

    public AsyncDaoException(AsyncOperation asyncoperation, Throwable throwable)
    {
        super(throwable);
        failedOperation = asyncoperation;
    }

    public AsyncOperation getFailedOperation()
    {
        return failedOperation;
    }
}
