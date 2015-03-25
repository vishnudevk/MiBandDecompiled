// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.query;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.DaoLog;
import de.greenrobot.dao.InternalQueryDaoAccess;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.TableStatements;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package de.greenrobot.dao.query:
//            WhereCondition, Query, CountQuery, DeleteQuery, 
//            CloseableListIterator, LazyList

public class QueryBuilder
{

    public static boolean LOG_SQL;
    public static boolean LOG_VALUES;
    private final AbstractDao dao;
    private StringBuilder joinBuilder;
    private Integer limit;
    private Integer offset;
    private StringBuilder orderBuilder;
    private final String tablePrefix;
    private final List values;
    private final List whereConditions;

    protected QueryBuilder(AbstractDao abstractdao)
    {
        this(abstractdao, "T");
    }

    protected QueryBuilder(AbstractDao abstractdao, String s)
    {
        dao = abstractdao;
        tablePrefix = s;
        values = new ArrayList();
        whereConditions = new ArrayList();
    }

    private void appendWhereClause(StringBuilder stringbuilder, String s)
    {
        values.clear();
        if (!whereConditions.isEmpty())
        {
            stringbuilder.append(" WHERE ");
            WhereCondition wherecondition;
            for (ListIterator listiterator = whereConditions.listIterator(); listiterator.hasNext(); wherecondition.appendValuesTo(values))
            {
                if (listiterator.hasPrevious())
                {
                    stringbuilder.append(" AND ");
                }
                wherecondition = (WhereCondition)listiterator.next();
                wherecondition.appendTo(stringbuilder, s);
            }

        }
    }

    private void checkOrderBuilder()
    {
        if (orderBuilder == null)
        {
            orderBuilder = new StringBuilder();
        } else
        if (orderBuilder.length() > 0)
        {
            orderBuilder.append(",");
            return;
        }
    }

    public static QueryBuilder internalCreate(AbstractDao abstractdao)
    {
        return new QueryBuilder(abstractdao);
    }

    private transient void orderAscOrDesc(String s, Property aproperty[])
    {
        int i = aproperty.length;
        for (int j = 0; j < i; j++)
        {
            Property property = aproperty[j];
            checkOrderBuilder();
            append(orderBuilder, property);
            if (java/lang/String.equals(property.type))
            {
                orderBuilder.append(" COLLATE LOCALIZED");
            }
            orderBuilder.append(s);
        }

    }

    protected void addCondition(StringBuilder stringbuilder, List list1, WhereCondition wherecondition)
    {
        checkCondition(wherecondition);
        wherecondition.appendTo(stringbuilder, tablePrefix);
        wherecondition.appendValuesTo(list1);
    }

    public transient WhereCondition and(WhereCondition wherecondition, WhereCondition wherecondition1, WhereCondition awherecondition[])
    {
        return combineWhereConditions(" AND ", wherecondition, wherecondition1, awherecondition);
    }

    protected StringBuilder append(StringBuilder stringbuilder, Property property)
    {
        checkProperty(property);
        stringbuilder.append(tablePrefix).append('.').append('\'').append(property.columnName).append('\'');
        return stringbuilder;
    }

    public Query build()
    {
        int i = -1;
        String s;
        StringBuilder stringbuilder;
        int j;
        if (joinBuilder == null || joinBuilder.length() == 0)
        {
            s = InternalQueryDaoAccess.getStatements(dao).getSelectAll();
        } else
        {
            s = SqlUtils.createSqlSelect(dao.getTablename(), tablePrefix, dao.getAllColumns());
        }
        stringbuilder = new StringBuilder(s);
        appendWhereClause(stringbuilder, tablePrefix);
        if (orderBuilder != null && orderBuilder.length() > 0)
        {
            stringbuilder.append(" ORDER BY ").append(orderBuilder);
        }
        String s1;
        if (limit != null)
        {
            stringbuilder.append(" LIMIT ?");
            values.add(limit);
            j = -1 + values.size();
        } else
        {
            j = i;
        }
        if (offset != null)
        {
            if (limit == null)
            {
                throw new IllegalStateException("Offset cannot be set without limit");
            }
            stringbuilder.append(" OFFSET ?");
            values.add(offset);
            i = -1 + values.size();
        }
        s1 = stringbuilder.toString();
        if (LOG_SQL)
        {
            DaoLog.d((new StringBuilder()).append("Built SQL for query: ").append(s1).toString());
        }
        if (LOG_VALUES)
        {
            DaoLog.d((new StringBuilder()).append("Values for query: ").append(values).toString());
        }
        return Query.create(dao, s1, values.toArray(), j, i);
    }

    public CountQuery buildCount()
    {
        StringBuilder stringbuilder = new StringBuilder(SqlUtils.createSqlSelectCountStar(dao.getTablename(), tablePrefix));
        appendWhereClause(stringbuilder, tablePrefix);
        String s = stringbuilder.toString();
        if (LOG_SQL)
        {
            DaoLog.d((new StringBuilder()).append("Built SQL for count query: ").append(s).toString());
        }
        if (LOG_VALUES)
        {
            DaoLog.d((new StringBuilder()).append("Values for count query: ").append(values).toString());
        }
        return CountQuery.create(dao, s, values.toArray());
    }

    public DeleteQuery buildDelete()
    {
        String s = dao.getTablename();
        StringBuilder stringbuilder = new StringBuilder(SqlUtils.createSqlDelete(s, null));
        appendWhereClause(stringbuilder, tablePrefix);
        String s1 = stringbuilder.toString().replace((new StringBuilder()).append(tablePrefix).append(".'").toString(), (new StringBuilder()).append(s).append(".'").toString());
        if (LOG_SQL)
        {
            DaoLog.d((new StringBuilder()).append("Built SQL for delete query: ").append(s1).toString());
        }
        if (LOG_VALUES)
        {
            DaoLog.d((new StringBuilder()).append("Values for delete query: ").append(values).toString());
        }
        return DeleteQuery.create(dao, s1, values.toArray());
    }

    protected void checkCondition(WhereCondition wherecondition)
    {
        if (wherecondition instanceof WhereCondition.PropertyCondition)
        {
            checkProperty(((WhereCondition.PropertyCondition)wherecondition).property);
        }
    }

    protected void checkProperty(Property property)
    {
        if (dao != null)
        {
            Property aproperty[] = dao.getProperties();
            int i = aproperty.length;
            int j = 0;
label0:
            do
            {
label1:
                {
                    boolean flag = false;
                    if (j < i)
                    {
                        if (property != aproperty[j])
                        {
                            break label1;
                        }
                        flag = true;
                    }
                    if (!flag)
                    {
                        throw new DaoException((new StringBuilder()).append("Property '").append(property.name).append("' is not part of ").append(dao).toString());
                    }
                    break label0;
                }
                j++;
            } while (true);
        }
    }

    protected transient WhereCondition combineWhereConditions(String s, WhereCondition wherecondition, WhereCondition wherecondition1, WhereCondition awherecondition[])
    {
        StringBuilder stringbuilder = new StringBuilder("(");
        ArrayList arraylist = new ArrayList();
        addCondition(stringbuilder, arraylist, wherecondition);
        stringbuilder.append(s);
        addCondition(stringbuilder, arraylist, wherecondition1);
        int i = awherecondition.length;
        for (int j = 0; j < i; j++)
        {
            WhereCondition wherecondition2 = awherecondition[j];
            stringbuilder.append(s);
            addCondition(stringbuilder, arraylist, wherecondition2);
        }

        stringbuilder.append(')');
        return new WhereCondition.StringCondition(stringbuilder.toString(), arraylist.toArray());
    }

    public long count()
    {
        return buildCount().count();
    }

    public QueryBuilder join(Class class1, Property property)
    {
        throw new UnsupportedOperationException();
    }

    public QueryBuilder joinToMany(Class class1, Property property)
    {
        throw new UnsupportedOperationException();
    }

    public QueryBuilder limit(int i)
    {
        limit = Integer.valueOf(i);
        return this;
    }

    public List list()
    {
        return build().list();
    }

    public CloseableListIterator listIterator()
    {
        return build().listIterator();
    }

    public LazyList listLazy()
    {
        return build().listLazy();
    }

    public LazyList listLazyUncached()
    {
        return build().listLazyUncached();
    }

    public QueryBuilder offset(int i)
    {
        offset = Integer.valueOf(i);
        return this;
    }

    public transient WhereCondition or(WhereCondition wherecondition, WhereCondition wherecondition1, WhereCondition awherecondition[])
    {
        return combineWhereConditions(" OR ", wherecondition, wherecondition1, awherecondition);
    }

    public transient QueryBuilder orderAsc(Property aproperty[])
    {
        orderAscOrDesc(" ASC", aproperty);
        return this;
    }

    public QueryBuilder orderCustom(Property property, String s)
    {
        checkOrderBuilder();
        append(orderBuilder, property).append(' ');
        orderBuilder.append(s);
        return this;
    }

    public transient QueryBuilder orderDesc(Property aproperty[])
    {
        orderAscOrDesc(" DESC", aproperty);
        return this;
    }

    public QueryBuilder orderRaw(String s)
    {
        checkOrderBuilder();
        orderBuilder.append(s);
        return this;
    }

    public Object unique()
    {
        return build().unique();
    }

    public Object uniqueOrThrow()
    {
        return build().uniqueOrThrow();
    }

    public transient QueryBuilder where(WhereCondition wherecondition, WhereCondition awherecondition[])
    {
        whereConditions.add(wherecondition);
        int i = awherecondition.length;
        for (int j = 0; j < i; j++)
        {
            WhereCondition wherecondition1 = awherecondition[j];
            checkCondition(wherecondition1);
            whereConditions.add(wherecondition1);
        }

        return this;
    }

    public transient QueryBuilder whereOr(WhereCondition wherecondition, WhereCondition wherecondition1, WhereCondition awherecondition[])
    {
        whereConditions.add(or(wherecondition, wherecondition1, awherecondition));
        return this;
    }
}
