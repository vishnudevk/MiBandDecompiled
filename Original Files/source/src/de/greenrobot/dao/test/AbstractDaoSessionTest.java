// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.test;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

// Referenced classes of package de.greenrobot.dao.test:
//            DbTest

public abstract class AbstractDaoSessionTest extends DbTest
{

    protected AbstractDaoMaster daoMaster;
    private final Class daoMasterClass;
    protected AbstractDaoSession daoSession;

    public AbstractDaoSessionTest(Class class1)
    {
        this(class1, true);
    }

    public AbstractDaoSessionTest(Class class1, boolean flag)
    {
        super(flag);
        daoMasterClass = class1;
    }

    protected void setUp()
    {
        super.setUp();
        try
        {
            Constructor constructor = daoMasterClass.getConstructor(new Class[] {
                android/database/sqlite/SQLiteDatabase
            });
            Object aobj[] = new Object[1];
            aobj[0] = db;
            daoMaster = (AbstractDaoMaster)constructor.newInstance(aobj);
            Class class1 = daoMasterClass;
            Class aclass[] = new Class[2];
            aclass[0] = android/database/sqlite/SQLiteDatabase;
            aclass[1] = Boolean.TYPE;
            Method method = class1.getMethod("createAllTables", aclass);
            Object aobj1[] = new Object[2];
            aobj1[0] = db;
            aobj1[1] = Boolean.valueOf(false);
            method.invoke(null, aobj1);
        }
        catch (Exception exception)
        {
            throw new RuntimeException("Could not prepare DAO session test", exception);
        }
        daoSession = daoMaster.newSession();
    }
}
