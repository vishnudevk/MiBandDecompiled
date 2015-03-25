// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.query.WhereCondition;
import java.util.Collection;

public class Property
{

    public final String columnName;
    public final String name;
    public final int ordinal;
    public final boolean primaryKey;
    public final Class type;

    public Property(int i, Class class1, String s, boolean flag, String s1)
    {
        ordinal = i;
        type = class1;
        name = s;
        primaryKey = flag;
        columnName = s1;
    }

    public WhereCondition between(Object obj, Object obj1)
    {
        return new de.greenrobot.dao.query.WhereCondition.PropertyCondition(this, " BETWEEN ? AND ?", new Object[] {
            obj, obj1
        });
    }

    public WhereCondition eq(Object obj)
    {
        return new de.greenrobot.dao.query.WhereCondition.PropertyCondition(this, "=?", obj);
    }

    public WhereCondition ge(Object obj)
    {
        return new de.greenrobot.dao.query.WhereCondition.PropertyCondition(this, ">=?", obj);
    }

    public WhereCondition gt(Object obj)
    {
        return new de.greenrobot.dao.query.WhereCondition.PropertyCondition(this, ">?", obj);
    }

    public WhereCondition in(Collection collection)
    {
        return in(collection.toArray());
    }

    public transient WhereCondition in(Object aobj[])
    {
        StringBuilder stringbuilder = new StringBuilder(" IN (");
        SqlUtils.appendPlaceholders(stringbuilder, aobj.length).append(')');
        return new de.greenrobot.dao.query.WhereCondition.PropertyCondition(this, stringbuilder.toString(), aobj);
    }

    public WhereCondition isNotNull()
    {
        return new de.greenrobot.dao.query.WhereCondition.PropertyCondition(this, " IS NOT NULL");
    }

    public WhereCondition isNull()
    {
        return new de.greenrobot.dao.query.WhereCondition.PropertyCondition(this, " IS NULL");
    }

    public WhereCondition le(Object obj)
    {
        return new de.greenrobot.dao.query.WhereCondition.PropertyCondition(this, "<=?", obj);
    }

    public WhereCondition like(String s)
    {
        return new de.greenrobot.dao.query.WhereCondition.PropertyCondition(this, " LIKE ?", s);
    }

    public WhereCondition lt(Object obj)
    {
        return new de.greenrobot.dao.query.WhereCondition.PropertyCondition(this, "<?", obj);
    }

    public WhereCondition notEq(Object obj)
    {
        return new de.greenrobot.dao.query.WhereCondition.PropertyCondition(this, "<>?", obj);
    }

    public WhereCondition notIn(Collection collection)
    {
        return notIn(collection.toArray());
    }

    public transient WhereCondition notIn(Object aobj[])
    {
        StringBuilder stringbuilder = new StringBuilder(" NOT IN (");
        SqlUtils.appendPlaceholders(stringbuilder, aobj.length).append(')');
        return new de.greenrobot.dao.query.WhereCondition.PropertyCondition(this, stringbuilder.toString(), aobj);
    }
}
