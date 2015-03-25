// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.test;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoLog;
import de.greenrobot.dao.InternalUnitTestDaoAccess;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.identityscope.IdentityScope;
import java.lang.reflect.Method;

// Referenced classes of package de.greenrobot.dao.test:
//            DbTest

public abstract class AbstractDaoTest extends DbTest
{

    protected AbstractDao dao;
    protected InternalUnitTestDaoAccess daoAccess;
    protected final Class daoClass;
    protected IdentityScope identityScopeForDao;
    protected Property pkColumn;

    public AbstractDaoTest(Class class1)
    {
        this(class1, true);
    }

    public AbstractDaoTest(Class class1, boolean flag)
    {
        super(flag);
        daoClass = class1;
    }

    protected void clearIdentityScopeIfAny()
    {
        if (identityScopeForDao != null)
        {
            identityScopeForDao.clear();
            DaoLog.d("Identity scope cleared");
            return;
        } else
        {
            DaoLog.d("No identity scope to clear");
            return;
        }
    }

    protected void logTableDump()
    {
        logTableDump(dao.getTablename());
    }

    public void setIdentityScopeBeforeSetUp(IdentityScope identityscope)
    {
        identityScopeForDao = identityscope;
    }

    protected void setUp()
    {
        super.setUp();
        try
        {
            setUpTableForDao();
            daoAccess = new InternalUnitTestDaoAccess(db, daoClass, identityScopeForDao);
            dao = daoAccess.getDao();
            return;
        }
        catch (Exception exception)
        {
            throw new RuntimeException("Could not prepare DAO Test", exception);
        }
    }

    protected void setUpTableForDao()
    {
        try
        {
            Class class1 = daoClass;
            Class aclass[] = new Class[2];
            aclass[0] = android/database/sqlite/SQLiteDatabase;
            aclass[1] = Boolean.TYPE;
            Method method = class1.getMethod("createTable", aclass);
            Object aobj[] = new Object[2];
            aobj[0] = db;
            aobj[1] = Boolean.valueOf(false);
            method.invoke(null, aobj);
            return;
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            DaoLog.i("No createTable method");
        }
    }
}
