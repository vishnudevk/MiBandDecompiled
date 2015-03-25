// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.identityscope.IdentityScope;
import de.greenrobot.dao.identityscope.IdentityScopeLong;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.FastCursor;
import de.greenrobot.dao.internal.TableStatements;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package de.greenrobot.dao:
//            Property, DaoException, DaoLog, AbstractDaoSession

public abstract class AbstractDao
{

    protected final DaoConfig config;
    protected final SQLiteDatabase db;
    protected IdentityScope identityScope;
    protected IdentityScopeLong identityScopeLong;
    protected final int pkOrdinal;
    protected final AbstractDaoSession session;
    protected TableStatements statements;

    public AbstractDao(DaoConfig daoconfig)
    {
        this(daoconfig, null);
    }

    public AbstractDao(DaoConfig daoconfig, AbstractDaoSession abstractdaosession)
    {
        config = daoconfig;
        session = abstractdaosession;
        db = daoconfig.db;
        identityScope = daoconfig.getIdentityScope();
        if (identityScope instanceof IdentityScopeLong)
        {
            identityScopeLong = (IdentityScopeLong)identityScope;
        }
        statements = daoconfig.statements;
        int i;
        if (daoconfig.pkProperty != null)
        {
            i = daoconfig.pkProperty.ordinal;
        } else
        {
            i = -1;
        }
        pkOrdinal = i;
    }

    private void deleteByKeyInsideSynchronized(Object obj, SQLiteStatement sqlitestatement)
    {
        if (obj instanceof Long)
        {
            sqlitestatement.bindLong(1, ((Long)obj).longValue());
        } else
        {
            if (obj == null)
            {
                throw new DaoException("Cannot delete entity, key is null");
            }
            sqlitestatement.bindString(1, obj.toString());
        }
        sqlitestatement.execute();
    }

    private void deleteInTxInternal(Iterable iterable, Iterable iterable1)
    {
        SQLiteStatement sqlitestatement;
        assertSinglePk();
        sqlitestatement = statements.getDeleteStatement();
        db.beginTransaction();
        sqlitestatement;
        JVM INSTR monitorenter ;
        IdentityScope identityscope = identityScope;
        ArrayList arraylist;
        arraylist = null;
        if (identityscope == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        identityScope.lock();
        arraylist = new ArrayList();
        if (iterable == null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        Iterator iterator1 = iterable.iterator();
_L2:
        Object obj1;
        do
        {
            if (!iterator1.hasNext())
            {
                break MISSING_BLOCK_LABEL_153;
            }
            obj1 = getKeyVerified(iterator1.next());
            deleteByKeyInsideSynchronized(obj1, sqlitestatement);
        } while (arraylist == null);
        arraylist.add(obj1);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception2;
        exception2;
        if (identityScope != null)
        {
            identityScope.unlock();
        }
        throw exception2;
        Exception exception1;
        exception1;
        sqlitestatement;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        db.endTransaction();
        throw exception;
        if (iterable1 == null)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        Iterator iterator = iterable1.iterator();
_L3:
        Object obj;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_209;
            }
            obj = iterator.next();
            deleteByKeyInsideSynchronized(obj, sqlitestatement);
        } while (arraylist == null);
        arraylist.add(obj);
          goto _L3
        if (identityScope != null)
        {
            identityScope.unlock();
        }
        sqlitestatement;
        JVM INSTR monitorexit ;
        db.setTransactionSuccessful();
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        if (identityScope != null)
        {
            identityScope.remove(arraylist);
        }
        db.endTransaction();
        return;
    }

    private long executeInsert(Object obj, SQLiteStatement sqlitestatement)
    {
        if (!db.isDbLockedByCurrentThread()) goto _L2; else goto _L1
_L1:
        sqlitestatement;
        JVM INSTR monitorenter ;
        long l;
        bindValues(sqlitestatement, obj);
        l = sqlitestatement.executeInsert();
        sqlitestatement;
        JVM INSTR monitorexit ;
_L4:
        updateKeyAfterInsertAndAttach(obj, l, true);
        return l;
        Exception exception2;
        exception2;
        sqlitestatement;
        JVM INSTR monitorexit ;
        throw exception2;
_L2:
        db.beginTransaction();
        sqlitestatement;
        JVM INSTR monitorenter ;
        bindValues(sqlitestatement, obj);
        l = sqlitestatement.executeInsert();
        sqlitestatement;
        JVM INSTR monitorexit ;
        db.setTransactionSuccessful();
        db.endTransaction();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception1;
        exception1;
        sqlitestatement;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        db.endTransaction();
        throw exception;
    }

    private void executeInsertInTx(SQLiteStatement sqlitestatement, Iterable iterable, boolean flag)
    {
        db.beginTransaction();
        sqlitestatement;
        JVM INSTR monitorenter ;
        if (identityScope != null)
        {
            identityScope.lock();
        }
        Iterator iterator = iterable.iterator();
_L1:
        Object obj;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_124;
        }
        obj = iterator.next();
        bindValues(sqlitestatement, obj);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        updateKeyAfterInsertAndAttach(obj, sqlitestatement.executeInsert(), false);
          goto _L1
        Exception exception2;
        exception2;
        if (identityScope != null)
        {
            identityScope.unlock();
        }
        throw exception2;
        Exception exception1;
        exception1;
        sqlitestatement;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        db.endTransaction();
        throw exception;
        sqlitestatement.execute();
          goto _L1
        if (identityScope != null)
        {
            identityScope.unlock();
        }
        sqlitestatement;
        JVM INSTR monitorexit ;
        db.setTransactionSuccessful();
        db.endTransaction();
        return;
    }

    protected void assertSinglePk()
    {
        if (config.pkColumns.length != 1)
        {
            throw new DaoException((new StringBuilder()).append(this).append(" (").append(config.tablename).append(") does not have a single-column primary key").toString());
        } else
        {
            return;
        }
    }

    protected void attachEntity(Object obj)
    {
    }

    protected final void attachEntity(Object obj, Object obj1, boolean flag)
    {
label0:
        {
            attachEntity(obj1);
            if (identityScope != null && obj != null)
            {
                if (!flag)
                {
                    break label0;
                }
                identityScope.put(obj, obj1);
            }
            return;
        }
        identityScope.putNoLock(obj, obj1);
    }

    protected abstract void bindValues(SQLiteStatement sqlitestatement, Object obj);

    public long count()
    {
        return DatabaseUtils.queryNumEntries(db, (new StringBuilder()).append('\'').append(config.tablename).append('\'').toString());
    }

    public void delete(Object obj)
    {
        assertSinglePk();
        deleteByKey(getKeyVerified(obj));
    }

    public void deleteAll()
    {
        db.execSQL((new StringBuilder()).append("DELETE FROM '").append(config.tablename).append("'").toString());
        if (identityScope != null)
        {
            identityScope.clear();
        }
    }

    public void deleteByKey(Object obj)
    {
        SQLiteStatement sqlitestatement;
        assertSinglePk();
        sqlitestatement = statements.getDeleteStatement();
        if (!db.isDbLockedByCurrentThread()) goto _L2; else goto _L1
_L1:
        sqlitestatement;
        JVM INSTR monitorenter ;
        deleteByKeyInsideSynchronized(obj, sqlitestatement);
        sqlitestatement;
        JVM INSTR monitorexit ;
_L4:
        if (identityScope != null)
        {
            identityScope.remove(obj);
        }
        return;
        Exception exception2;
        exception2;
        sqlitestatement;
        JVM INSTR monitorexit ;
        throw exception2;
_L2:
        db.beginTransaction();
        sqlitestatement;
        JVM INSTR monitorenter ;
        deleteByKeyInsideSynchronized(obj, sqlitestatement);
        sqlitestatement;
        JVM INSTR monitorexit ;
        db.setTransactionSuccessful();
        db.endTransaction();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception1;
        exception1;
        sqlitestatement;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        db.endTransaction();
        throw exception;
    }

    public void deleteByKeyInTx(Iterable iterable)
    {
        deleteInTxInternal(null, iterable);
    }

    public transient void deleteByKeyInTx(Object aobj[])
    {
        deleteInTxInternal(null, Arrays.asList(aobj));
    }

    public void deleteInTx(Iterable iterable)
    {
        deleteInTxInternal(iterable, null);
    }

    public transient void deleteInTx(Object aobj[])
    {
        deleteInTxInternal(Arrays.asList(aobj), null);
    }

    public boolean detach(Object obj)
    {
        if (identityScope != null)
        {
            Object obj1 = getKeyVerified(obj);
            return identityScope.detach(obj1, obj);
        } else
        {
            return false;
        }
    }

    public String[] getAllColumns()
    {
        return config.allColumns;
    }

    public SQLiteDatabase getDatabase()
    {
        return db;
    }

    protected abstract Object getKey(Object obj);

    protected Object getKeyVerified(Object obj)
    {
        Object obj1 = getKey(obj);
        if (obj1 == null)
        {
            if (obj == null)
            {
                throw new NullPointerException("Entity may not be null");
            } else
            {
                throw new DaoException("Entity has no key");
            }
        } else
        {
            return obj1;
        }
    }

    public String[] getNonPkColumns()
    {
        return config.nonPkColumns;
    }

    public String[] getPkColumns()
    {
        return config.pkColumns;
    }

    public Property getPkProperty()
    {
        return config.pkProperty;
    }

    public Property[] getProperties()
    {
        return config.properties;
    }

    public AbstractDaoSession getSession()
    {
        return session;
    }

    TableStatements getStatements()
    {
        return config.statements;
    }

    public String getTablename()
    {
        return config.tablename;
    }

    public long insert(Object obj)
    {
        return executeInsert(obj, statements.getInsertStatement());
    }

    public void insertInTx(Iterable iterable)
    {
        insertInTx(iterable, isEntityUpdateable());
    }

    public void insertInTx(Iterable iterable, boolean flag)
    {
        executeInsertInTx(statements.getInsertStatement(), iterable, flag);
    }

    public transient void insertInTx(Object aobj[])
    {
        insertInTx(((Iterable) (Arrays.asList(aobj))), isEntityUpdateable());
    }

    public long insertOrReplace(Object obj)
    {
        return executeInsert(obj, statements.getInsertOrReplaceStatement());
    }

    public void insertOrReplaceInTx(Iterable iterable)
    {
        insertOrReplaceInTx(iterable, isEntityUpdateable());
    }

    public void insertOrReplaceInTx(Iterable iterable, boolean flag)
    {
        executeInsertInTx(statements.getInsertOrReplaceStatement(), iterable, flag);
    }

    public transient void insertOrReplaceInTx(Object aobj[])
    {
        insertOrReplaceInTx(((Iterable) (Arrays.asList(aobj))), isEntityUpdateable());
    }

    public long insertWithoutSettingPk(Object obj)
    {
        SQLiteStatement sqlitestatement;
        sqlitestatement = statements.getInsertStatement();
        if (!db.isDbLockedByCurrentThread())
        {
            break MISSING_BLOCK_LABEL_44;
        }
        sqlitestatement;
        JVM INSTR monitorenter ;
        long l1;
        bindValues(sqlitestatement, obj);
        l1 = sqlitestatement.executeInsert();
        sqlitestatement;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception2;
        exception2;
        sqlitestatement;
        JVM INSTR monitorexit ;
        throw exception2;
        db.beginTransaction();
        sqlitestatement;
        JVM INSTR monitorenter ;
        long l;
        bindValues(sqlitestatement, obj);
        l = sqlitestatement.executeInsert();
        sqlitestatement;
        JVM INSTR monitorexit ;
        db.setTransactionSuccessful();
        db.endTransaction();
        return l;
        Exception exception1;
        exception1;
        sqlitestatement;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        db.endTransaction();
        throw exception;
    }

    protected abstract boolean isEntityUpdateable();

    public Object load(Object obj)
    {
        assertSinglePk();
        if (obj != null) goto _L2; else goto _L1
_L1:
        Object obj1 = null;
_L4:
        return obj1;
_L2:
        if (identityScope == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = identityScope.get(obj);
        if (obj1 != null) goto _L4; else goto _L3
_L3:
        String s = statements.getSelectByKey();
        String as[] = new String[1];
        as[0] = obj.toString();
        return loadUniqueAndCloseCursor(db.rawQuery(s, as));
    }

    public List loadAll()
    {
        return loadAllAndCloseCursor(db.rawQuery(statements.getSelectAll(), null));
    }

    protected List loadAllAndCloseCursor(Cursor cursor)
    {
        List list = loadAllFromCursor(cursor);
        cursor.close();
        return list;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    protected List loadAllFromCursor(Cursor cursor)
    {
        int i = cursor.getCount();
        ArrayList arraylist = new ArrayList(i);
        if (cursor instanceof CrossProcessCursor)
        {
            CursorWindow cursorwindow = ((CrossProcessCursor)cursor).getWindow();
            boolean flag;
            if (cursorwindow != null)
            {
                if (cursorwindow.getNumRows() == i)
                {
                    cursor = new FastCursor(cursorwindow);
                } else
                {
                    DaoLog.d((new StringBuilder()).append("Window vs. result size: ").append(cursorwindow.getNumRows()).append("/").append(i).toString());
                }
            }
        }
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_136;
        }
        if (identityScope != null)
        {
            identityScope.lock();
            identityScope.reserveRoom(i);
        }
        do
        {
            arraylist.add(loadCurrent(cursor, 0, false));
            flag = cursor.moveToNext();
        } while (flag);
        if (identityScope != null)
        {
            identityScope.unlock();
        }
        return arraylist;
        Exception exception;
        exception;
        if (identityScope != null)
        {
            identityScope.unlock();
        }
        throw exception;
    }

    public Object loadByRowId(long l)
    {
        String as[] = new String[1];
        as[0] = Long.toString(l);
        return loadUniqueAndCloseCursor(db.rawQuery(statements.getSelectByRowId(), as));
    }

    protected final Object loadCurrent(Cursor cursor, int i, boolean flag)
    {
        if (identityScopeLong == null) goto _L2; else goto _L1
_L1:
        if (i == 0) goto _L4; else goto _L3
_L3:
        Object obj2;
        boolean flag1;
        flag1 = cursor.isNull(i + pkOrdinal);
        obj2 = null;
        if (!flag1) goto _L4; else goto _L5
_L5:
        return obj2;
_L4:
        long l = cursor.getLong(i + pkOrdinal);
        if (flag)
        {
            obj2 = identityScopeLong.get2(l);
        } else
        {
            obj2 = identityScopeLong.get2NoLock(l);
        }
        if (obj2 == null)
        {
            Object obj5 = readEntity(cursor, i);
            attachEntity(obj5);
            if (flag)
            {
                identityScopeLong.put2(l, obj5);
                return obj5;
            } else
            {
                identityScopeLong.put2NoLock(l, obj5);
                return obj5;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        Object obj3;
        if (identityScope == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = readKey(cursor, i);
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = null;
        if (obj3 == null) goto _L5; else goto _L6
_L6:
        if (flag)
        {
            obj2 = identityScope.get(obj3);
        } else
        {
            obj2 = identityScope.getNoLock(obj3);
        }
        if (obj2 == null)
        {
            Object obj4 = readEntity(cursor, i);
            attachEntity(obj3, obj4, flag);
            return obj4;
        }
        if (true) goto _L5; else goto _L7
_L7:
        Object obj1;
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = readKey(cursor, i);
        obj2 = null;
        if (obj1 == null) goto _L5; else goto _L8
_L8:
        Object obj = readEntity(cursor, i);
        attachEntity(obj);
        return obj;
    }

    protected final Object loadCurrentOther(AbstractDao abstractdao, Cursor cursor, int i)
    {
        return abstractdao.loadCurrent(cursor, i, true);
    }

    protected Object loadUnique(Cursor cursor)
    {
        if (!cursor.moveToFirst())
        {
            return null;
        }
        if (!cursor.isLast())
        {
            throw new DaoException((new StringBuilder()).append("Expected unique result, but count was ").append(cursor.getCount()).toString());
        } else
        {
            return loadCurrent(cursor, 0, true);
        }
    }

    protected Object loadUniqueAndCloseCursor(Cursor cursor)
    {
        Object obj = loadUnique(cursor);
        cursor.close();
        return obj;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    public QueryBuilder queryBuilder()
    {
        return QueryBuilder.internalCreate(this);
    }

    public transient List queryRaw(String s, String as[])
    {
        return loadAllAndCloseCursor(db.rawQuery((new StringBuilder()).append(statements.getSelectAll()).append(s).toString(), as));
    }

    public transient Query queryRawCreate(String s, Object aobj[])
    {
        return queryRawCreateListArgs(s, Arrays.asList(aobj));
    }

    public Query queryRawCreateListArgs(String s, Collection collection)
    {
        return Query.internalCreate(this, (new StringBuilder()).append(statements.getSelectAll()).append(s).toString(), collection.toArray());
    }

    protected abstract Object readEntity(Cursor cursor, int i);

    protected abstract void readEntity(Cursor cursor, Object obj, int i);

    protected abstract Object readKey(Cursor cursor, int i);

    public void refresh(Object obj)
    {
        Object obj1;
        Cursor cursor;
        assertSinglePk();
        obj1 = getKeyVerified(obj);
        String s = statements.getSelectByKey();
        String as[] = new String[1];
        as[0] = obj1.toString();
        cursor = db.rawQuery(s, as);
        if (!cursor.moveToFirst())
        {
            throw new DaoException((new StringBuilder()).append("Entity does not exist in the database anymore: ").append(obj.getClass()).append(" with key ").append(obj1).toString());
        }
        break MISSING_BLOCK_LABEL_107;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
        if (!cursor.isLast())
        {
            throw new DaoException((new StringBuilder()).append("Expected unique result, but count was ").append(cursor.getCount()).toString());
        }
        readEntity(cursor, obj, 0);
        attachEntity(obj1, obj, true);
        cursor.close();
        return;
    }

    public void update(Object obj)
    {
        SQLiteStatement sqlitestatement;
        assertSinglePk();
        sqlitestatement = statements.getUpdateStatement();
        if (!db.isDbLockedByCurrentThread())
        {
            break MISSING_BLOCK_LABEL_41;
        }
        sqlitestatement;
        JVM INSTR monitorenter ;
        updateInsideSynchronized(obj, sqlitestatement, true);
        sqlitestatement;
        JVM INSTR monitorexit ;
        return;
        Exception exception2;
        exception2;
        sqlitestatement;
        JVM INSTR monitorexit ;
        throw exception2;
        db.beginTransaction();
        sqlitestatement;
        JVM INSTR monitorenter ;
        updateInsideSynchronized(obj, sqlitestatement, true);
        sqlitestatement;
        JVM INSTR monitorexit ;
        db.setTransactionSuccessful();
        db.endTransaction();
        return;
        Exception exception1;
        exception1;
        sqlitestatement;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        db.endTransaction();
        throw exception;
    }

    public void updateInTx(Iterable iterable)
    {
        SQLiteStatement sqlitestatement;
        sqlitestatement = statements.getUpdateStatement();
        db.beginTransaction();
        sqlitestatement;
        JVM INSTR monitorenter ;
        if (identityScope != null)
        {
            identityScope.lock();
        }
        for (Iterator iterator = iterable.iterator(); iterator.hasNext(); updateInsideSynchronized(iterator.next(), sqlitestatement, false)) { }
        break MISSING_BLOCK_LABEL_105;
        Exception exception2;
        exception2;
        if (identityScope != null)
        {
            identityScope.unlock();
        }
        throw exception2;
        Exception exception1;
        exception1;
        sqlitestatement;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        db.endTransaction();
        throw exception;
        if (identityScope != null)
        {
            identityScope.unlock();
        }
        sqlitestatement;
        JVM INSTR monitorexit ;
        db.setTransactionSuccessful();
        db.endTransaction();
        return;
    }

    public transient void updateInTx(Object aobj[])
    {
        updateInTx(((Iterable) (Arrays.asList(aobj))));
    }

    protected void updateInsideSynchronized(Object obj, SQLiteStatement sqlitestatement, boolean flag)
    {
        bindValues(sqlitestatement, obj);
        int i = 1 + config.allColumns.length;
        Object obj1 = getKey(obj);
        if (obj1 instanceof Long)
        {
            sqlitestatement.bindLong(i, ((Long)obj1).longValue());
        } else
        {
            if (obj1 == null)
            {
                throw new DaoException("Cannot update entity without key - was it inserted before?");
            }
            sqlitestatement.bindString(i, obj1.toString());
        }
        sqlitestatement.execute();
        attachEntity(obj1, obj, flag);
    }

    protected abstract Object updateKeyAfterInsert(Object obj, long l);

    protected void updateKeyAfterInsertAndAttach(Object obj, long l, boolean flag)
    {
        if (l != -1L)
        {
            attachEntity(updateKeyAfterInsert(obj, l), obj, flag);
            return;
        } else
        {
            DaoLog.w("Could not insert row (executeInsert returned -1)");
            return;
        }
    }
}
