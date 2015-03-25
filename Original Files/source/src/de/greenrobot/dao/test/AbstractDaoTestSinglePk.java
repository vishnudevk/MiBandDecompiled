// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.test;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.InternalUnitTestDaoAccess;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package de.greenrobot.dao.test:
//            AbstractDaoTest

public abstract class AbstractDaoTestSinglePk extends AbstractDaoTest
{

    private Property pkColumn;
    protected Set usedPks;

    public AbstractDaoTestSinglePk(Class class1)
    {
        super(class1);
        usedPks = new HashSet();
    }

    protected abstract Object createEntity(Object obj);

    protected Object createEntityWithRandomPk()
    {
        return createEntity(nextPk());
    }

    protected abstract Object createRandomPk();

    protected Object nextPk()
    {
        for (int i = 0; i < 0x186a0; i++)
        {
            Object obj = createRandomPk();
            if (usedPks.add(obj))
            {
                return obj;
            }
        }

        throw new IllegalStateException("Could not find a new PK");
    }

    protected Cursor queryWithDummyColumnsInFront(int i, String s, Object obj)
    {
        int j = 0;
        StringBuilder stringbuilder = new StringBuilder("SELECT ");
        for (int k = 0; k < i; k++)
        {
            stringbuilder.append(s).append(",");
        }

        SqlUtils.appendColumns(stringbuilder, "T", dao.getAllColumns()).append(" FROM ");
        stringbuilder.append(dao.getTablename()).append(" T");
        if (obj != null)
        {
            stringbuilder.append(" WHERE ");
            assertEquals(1, dao.getPkColumns().length);
            stringbuilder.append(dao.getPkColumns()[0]).append("=");
            DatabaseUtils.appendValueToSql(stringbuilder, obj);
        }
        String s1 = stringbuilder.toString();
        Cursor cursor = db.rawQuery(s1, null);
        assertTrue(cursor.moveToFirst());
        do
        {
            if (j >= i)
            {
                break;
            }
            try
            {
                assertEquals(s, cursor.getString(j));
            }
            catch (RuntimeException runtimeexception)
            {
                cursor.close();
                throw runtimeexception;
            }
            j++;
        } while (true);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        assertEquals(1, cursor.getCount());
        return cursor;
    }

    protected void runLoadPkTest(int i)
    {
        Object obj;
        Cursor cursor;
        obj = nextPk();
        Object obj1 = createEntity(obj);
        dao.insert(obj1);
        cursor = queryWithDummyColumnsInFront(i, "42", obj);
        assertEquals(obj, daoAccess.readKey(cursor, i));
        cursor.close();
        return;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    protected void setUp()
    {
        super.setUp();
        Property aproperty[] = daoAccess.getProperties();
        int i = aproperty.length;
        for (int j = 0; j < i; j++)
        {
            Property property = aproperty[j];
            if (!property.primaryKey)
            {
                continue;
            }
            if (pkColumn != null)
            {
                throw new RuntimeException("Test does not work with multiple PK columns");
            }
            pkColumn = property;
        }

        if (pkColumn == null)
        {
            throw new RuntimeException("Test does not work without a PK column");
        } else
        {
            return;
        }
    }

    public void testCount()
    {
        dao.deleteAll();
        assertEquals(0L, dao.count());
        dao.insert(createEntityWithRandomPk());
        assertEquals(1L, dao.count());
        dao.insert(createEntityWithRandomPk());
        assertEquals(2L, dao.count());
    }

    public void testDelete()
    {
        Object obj = nextPk();
        dao.deleteByKey(obj);
        Object obj1 = createEntity(obj);
        dao.insert(obj1);
        assertNotNull(dao.load(obj));
        dao.deleteByKey(obj);
        assertNull(dao.load(obj));
    }

    public void testDeleteAll()
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < 10; i++)
        {
            arraylist.add(createEntityWithRandomPk());
        }

        dao.insertInTx(arraylist);
        dao.deleteAll();
        assertEquals(0L, dao.count());
        Object obj1;
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); assertNull(dao.load(obj1)))
        {
            Object obj = iterator.next();
            obj1 = daoAccess.getKey(obj);
            assertNotNull(obj1);
        }

    }

    public void testDeleteByKeyInTx()
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < 10; i++)
        {
            arraylist.add(createEntityWithRandomPk());
        }

        dao.insertInTx(arraylist);
        ArrayList arraylist1 = new ArrayList();
        arraylist1.add(daoAccess.getKey(arraylist.get(0)));
        arraylist1.add(daoAccess.getKey(arraylist.get(3)));
        arraylist1.add(daoAccess.getKey(arraylist.get(4)));
        arraylist1.add(daoAccess.getKey(arraylist.get(8)));
        dao.deleteByKeyInTx(arraylist1);
        assertEquals(arraylist.size() - arraylist1.size(), dao.count());
        Object obj;
        for (Iterator iterator = arraylist1.iterator(); iterator.hasNext(); assertNull(dao.load(obj)))
        {
            obj = iterator.next();
            assertNotNull(obj);
        }

    }

    public void testDeleteInTx()
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < 10; i++)
        {
            arraylist.add(createEntityWithRandomPk());
        }

        dao.insertInTx(arraylist);
        ArrayList arraylist1 = new ArrayList();
        arraylist1.add(arraylist.get(0));
        arraylist1.add(arraylist.get(3));
        arraylist1.add(arraylist.get(4));
        arraylist1.add(arraylist.get(8));
        dao.deleteInTx(arraylist1);
        assertEquals(arraylist.size() - arraylist1.size(), dao.count());
        Object obj1;
        for (Iterator iterator = arraylist1.iterator(); iterator.hasNext(); assertNull(dao.load(obj1)))
        {
            Object obj = iterator.next();
            obj1 = daoAccess.getKey(obj);
            assertNotNull(obj1);
        }

    }

    public void testInsertAndLoad()
    {
        Object obj = nextPk();
        Object obj1 = createEntity(obj);
        dao.insert(obj1);
        assertEquals(obj, daoAccess.getKey(obj1));
        Object obj2 = dao.load(obj);
        assertNotNull(obj2);
        assertEquals(daoAccess.getKey(obj1), daoAccess.getKey(obj2));
    }

    public void testInsertInTx()
    {
        dao.deleteAll();
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < 20; i++)
        {
            arraylist.add(createEntityWithRandomPk());
        }

        dao.insertInTx(arraylist);
        assertEquals(arraylist.size(), dao.count());
    }

    public void testInsertOrReplaceInTx()
    {
        dao.deleteAll();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        for (int i = 0; i < 20; i++)
        {
            Object obj = createEntityWithRandomPk();
            if (i % 2 == 0)
            {
                arraylist.add(obj);
            }
            arraylist1.add(obj);
        }

        dao.insertOrReplaceInTx(arraylist);
        dao.insertOrReplaceInTx(arraylist1);
        assertEquals(arraylist1.size(), dao.count());
    }

    public void testInsertOrReplaceTwice()
    {
        Object obj = createEntityWithRandomPk();
        long l = dao.insert(obj);
        long l1 = dao.insertOrReplace(obj);
        if (dao.getPkProperty().type == java/lang/Long)
        {
            assertEquals(l, l1);
        }
    }

    public void testInsertTwice()
    {
        Object obj = createEntity(nextPk());
        dao.insert(obj);
        try
        {
            dao.insert(obj);
            fail("Inserting twice should not work");
            return;
        }
        catch (SQLException sqlexception)
        {
            return;
        }
    }

    public void testLoadAll()
    {
        dao.deleteAll();
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < 15; i++)
        {
            arraylist.add(createEntity(nextPk()));
        }

        dao.insertInTx(arraylist);
        List list = dao.loadAll();
        assertEquals(arraylist.size(), list.size());
    }

    public void testLoadPk()
    {
        runLoadPkTest(0);
    }

    public void testLoadPkWithOffset()
    {
        runLoadPkTest(10);
    }

    public void testQuery()
    {
        dao.insert(createEntityWithRandomPk());
        Object obj = nextPk();
        dao.insert(createEntity(obj));
        dao.insert(createEntityWithRandomPk());
        String s = (new StringBuilder()).append("WHERE ").append(dao.getPkColumns()[0]).append("=?").toString();
        AbstractDao abstractdao = dao;
        String as[] = new String[1];
        as[0] = obj.toString();
        List list = abstractdao.queryRaw(s, as);
        assertEquals(1, list.size());
        assertEquals(obj, daoAccess.getKey(list.get(0)));
    }

    public void testReadWithOffset()
    {
        Object obj;
        Cursor cursor;
        obj = nextPk();
        Object obj1 = createEntity(obj);
        dao.insert(obj1);
        cursor = queryWithDummyColumnsInFront(5, "42", obj);
        Object obj2 = daoAccess.readEntity(cursor, 5);
        assertEquals(obj, daoAccess.getKey(obj2));
        cursor.close();
        return;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    public void testRowId()
    {
        Object obj = createEntityWithRandomPk();
        Object obj1 = createEntityWithRandomPk();
        boolean flag;
        if (dao.insert(obj) != dao.insert(obj1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        assertTrue(flag);
    }

    public void testUpdate()
    {
        dao.deleteAll();
        Object obj = createEntityWithRandomPk();
        dao.insert(obj);
        dao.update(obj);
        assertEquals(1L, dao.count());
    }
}
