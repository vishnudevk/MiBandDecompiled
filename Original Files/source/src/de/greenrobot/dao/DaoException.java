// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import android.database.SQLException;

// Referenced classes of package de.greenrobot.dao:
//            DaoLog

public class DaoException extends SQLException
{

    private static final long serialVersionUID = 0xae6d5f249611350dL;

    public DaoException()
    {
    }

    public DaoException(String s)
    {
        super(s);
    }

    public DaoException(String s, Throwable throwable)
    {
        super(s);
        safeInitCause(throwable);
    }

    public DaoException(Throwable throwable)
    {
        safeInitCause(throwable);
    }

    protected void safeInitCause(Throwable throwable)
    {
        try
        {
            initCause(throwable);
            return;
        }
        catch (Throwable throwable1)
        {
            DaoLog.e("Could not set initial cause", throwable1);
        }
        DaoLog.e("Initial cause is:", throwable);
    }
}
