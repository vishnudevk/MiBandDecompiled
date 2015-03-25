// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.query;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

// Referenced classes of package de.greenrobot.dao.query:
//            AbstractQuery

public class CountQuery extends AbstractQuery
{

    private final QueryData queryData;

    private CountQuery(QueryData querydata, AbstractDao abstractdao, String s, String as[])
    {
        super(abstractdao, s, as);
        queryData = querydata;
    }

    CountQuery(QueryData querydata, AbstractDao abstractdao, String s, String as[], _cls1 _pcls1)
    {
        this(querydata, abstractdao, s, as);
    }

    static CountQuery create(AbstractDao abstractdao, String s, Object aobj[])
    {
        return (CountQuery)(new QueryData(abstractdao, s, toStringArray(aobj), null)).forCurrentThread();
    }

    public long count()
    {
        Cursor cursor;
        checkThread();
        cursor = dao.getDatabase().rawQuery(sql, parameters);
        if (!cursor.moveToNext())
        {
            throw new DaoException("No result for count");
        }
        break MISSING_BLOCK_LABEL_51;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
        long l;
        if (!cursor.isLast())
        {
            throw new DaoException((new StringBuilder()).append("Unexpected row count: ").append(cursor.getCount()).toString());
        }
        if (cursor.getColumnCount() != 1)
        {
            throw new DaoException((new StringBuilder()).append("Unexpected column count: ").append(cursor.getColumnCount()).toString());
        }
        l = cursor.getLong(0);
        cursor.close();
        return l;
    }

    public CountQuery forCurrentThread()
    {
        return (CountQuery)queryData.forCurrentThread(this);
    }

    public volatile void setParameter(int i, Object obj)
    {
        super.setParameter(i, obj);
    }

    private class QueryData extends AbstractQueryData
    {

        protected volatile AbstractQuery createQuery()
        {
            return createQuery();
        }

        protected CountQuery createQuery()
        {
            return new CountQuery(this, dao, sql, (String[])initialValues.clone(), null);
        }

        private QueryData(AbstractDao abstractdao, String s, String as[])
        {
            super(abstractdao, s, as);
        }

        QueryData(AbstractDao abstractdao, String s, String as[], _cls1 _pcls1)
        {
            this(abstractdao, s, as);
        }
    }

}
