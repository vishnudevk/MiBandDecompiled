// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.test;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoLog;
import de.greenrobot.dao.InternalUnitTestDaoAccess;
import java.util.Random;

// Referenced classes of package de.greenrobot.dao.test:
//            AbstractDaoTestSinglePk

public abstract class AbstractDaoTestLongPk extends AbstractDaoTestSinglePk
{

    public AbstractDaoTestLongPk(Class class1)
    {
        super(class1);
    }

    protected Long createRandomPk()
    {
        return Long.valueOf(random.nextLong());
    }

    protected volatile Object createRandomPk()
    {
        return createRandomPk();
    }

    public void testAssignPk()
    {
        if (daoAccess.isEntityUpdateable())
        {
            Object obj = createEntity(null);
            if (obj != null)
            {
                Object obj1 = createEntity(null);
                dao.insert(obj);
                dao.insert(obj1);
                Long long1 = (Long)daoAccess.getKey(obj);
                assertNotNull(long1);
                Long long2 = (Long)daoAccess.getKey(obj1);
                assertNotNull(long2);
                assertFalse(long1.equals(long2));
                assertNotNull(dao.load(long1));
                assertNotNull(dao.load(long2));
                return;
            } else
            {
                DaoLog.d((new StringBuilder()).append("Skipping testAssignPk for ").append(daoClass).append(" (createEntity returned null for null key)").toString());
                return;
            }
        } else
        {
            DaoLog.d((new StringBuilder()).append("Skipping testAssignPk for not updateable ").append(daoClass).toString());
            return;
        }
    }
}
