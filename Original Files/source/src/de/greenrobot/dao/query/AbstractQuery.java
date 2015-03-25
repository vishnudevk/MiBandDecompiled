// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.query;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.InternalQueryDaoAccess;

abstract class AbstractQuery
{

    protected final AbstractDao dao;
    protected final InternalQueryDaoAccess daoAccess;
    protected final Thread ownerThread = Thread.currentThread();
    protected final String parameters[];
    protected final String sql;

    protected AbstractQuery(AbstractDao abstractdao, String s, String as[])
    {
        dao = abstractdao;
        daoAccess = new InternalQueryDaoAccess(abstractdao);
        sql = s;
        parameters = as;
    }

    protected static String[] toStringArray(Object aobj[])
    {
        int i = aobj.length;
        String as[] = new String[i];
        int j = 0;
        while (j < i) 
        {
            Object obj = aobj[j];
            if (obj != null)
            {
                as[j] = obj.toString();
            } else
            {
                as[j] = null;
            }
            j++;
        }
        return as;
    }

    protected void checkThread()
    {
        if (Thread.currentThread() != ownerThread)
        {
            throw new DaoException("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
        } else
        {
            return;
        }
    }

    public void setParameter(int i, Object obj)
    {
        checkThread();
        if (obj != null)
        {
            parameters[i] = obj.toString();
            return;
        } else
        {
            parameters[i] = null;
            return;
        }
    }
}
