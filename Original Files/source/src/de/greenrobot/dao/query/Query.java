// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.query;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.InternalQueryDaoAccess;
import java.util.List;

// Referenced classes of package de.greenrobot.dao.query:
//            AbstractQuery, LazyList, CloseableListIterator

public class Query extends AbstractQuery
{

    private final int limitPosition;
    private final int offsetPosition;
    private final QueryData queryData;

    private Query(QueryData querydata, AbstractDao abstractdao, String s, String as[], int i, int j)
    {
        super(abstractdao, s, as);
        queryData = querydata;
        limitPosition = i;
        offsetPosition = j;
    }

    Query(QueryData querydata, AbstractDao abstractdao, String s, String as[], int i, int j, _cls1 _pcls1)
    {
        this(querydata, abstractdao, s, as, i, j);
    }

    static Query create(AbstractDao abstractdao, String s, Object aobj[], int i, int j)
    {
        return (Query)(new QueryData(abstractdao, s, toStringArray(aobj), i, j)).forCurrentThread();
    }

    public static Query internalCreate(AbstractDao abstractdao, String s, Object aobj[])
    {
        return create(abstractdao, s, aobj, -1, -1);
    }

    public Query forCurrentThread()
    {
        return (Query)queryData.forCurrentThread(this);
    }

    public List list()
    {
        checkThread();
        android.database.Cursor cursor = dao.getDatabase().rawQuery(sql, parameters);
        return daoAccess.loadAllAndCloseCursor(cursor);
    }

    public CloseableListIterator listIterator()
    {
        return listLazyUncached().listIteratorAutoClose();
    }

    public LazyList listLazy()
    {
        checkThread();
        android.database.Cursor cursor = dao.getDatabase().rawQuery(sql, parameters);
        return new LazyList(daoAccess, cursor, true);
    }

    public LazyList listLazyUncached()
    {
        checkThread();
        android.database.Cursor cursor = dao.getDatabase().rawQuery(sql, parameters);
        return new LazyList(daoAccess, cursor, false);
    }

    public void setLimit(int i)
    {
        checkThread();
        if (limitPosition == -1)
        {
            throw new IllegalStateException("Limit must be set with QueryBuilder before it can be used here");
        } else
        {
            parameters[limitPosition] = Integer.toString(i);
            return;
        }
    }

    public void setOffset(int i)
    {
        checkThread();
        if (offsetPosition == -1)
        {
            throw new IllegalStateException("Offset must be set with QueryBuilder before it can be used here");
        } else
        {
            parameters[offsetPosition] = Integer.toString(i);
            return;
        }
    }

    public void setParameter(int i, Object obj)
    {
        if (i >= 0 && (i == limitPosition || i == offsetPosition))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal parameter index: ").append(i).toString());
        } else
        {
            super.setParameter(i, obj);
            return;
        }
    }

    public Object unique()
    {
        checkThread();
        android.database.Cursor cursor = dao.getDatabase().rawQuery(sql, parameters);
        return daoAccess.loadUniqueAndCloseCursor(cursor);
    }

    public Object uniqueOrThrow()
    {
        Object obj = unique();
        if (obj == null)
        {
            throw new DaoException("No entity found for query");
        } else
        {
            return obj;
        }
    }

    private class QueryData extends AbstractQueryData
    {

        private final int limitPosition;
        private final int offsetPosition;

        protected volatile AbstractQuery createQuery()
        {
            return createQuery();
        }

        protected Query createQuery()
        {
            return new Query(this, dao, sql, (String[])initialValues.clone(), limitPosition, offsetPosition, null);
        }

        QueryData(AbstractDao abstractdao, String s, String as[], int i, int j)
        {
            super(abstractdao, s, as);
            limitPosition = i;
            offsetPosition = j;
        }
    }

}
