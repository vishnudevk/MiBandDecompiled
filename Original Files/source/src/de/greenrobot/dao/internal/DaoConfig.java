// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.internal;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.identityscope.IdentityScope;
import de.greenrobot.dao.identityscope.IdentityScopeLong;
import de.greenrobot.dao.identityscope.IdentityScopeObject;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package de.greenrobot.dao.internal:
//            TableStatements

public final class DaoConfig
    implements Cloneable
{

    public final String allColumns[];
    public final SQLiteDatabase db;
    private IdentityScope identityScope;
    public final boolean keyIsNumeric;
    public final String nonPkColumns[];
    public final String pkColumns[];
    public final Property pkProperty;
    public final Property properties[];
    public final TableStatements statements;
    public final String tablename;

    public DaoConfig(SQLiteDatabase sqlitedatabase, Class class1)
    {
        int i;
        Property property;
        boolean flag;
        Property property1;
        db = sqlitedatabase;
        Property aproperty[];
        ArrayList arraylist;
        ArrayList arraylist1;
        Class class2;
        String s;
        try
        {
            tablename = (String)class1.getField("TABLENAME").get(null);
            aproperty = reflectProperties(class1);
            properties = aproperty;
            allColumns = new String[aproperty.length];
            arraylist = new ArrayList();
            arraylist1 = new ArrayList();
        }
        catch (Exception exception)
        {
            throw new DaoException("Could not init DAOConfig", exception);
        }
        i = 0;
        property = null;
_L2:
        if (i >= aproperty.length)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        property1 = aproperty[i];
        s = property1.columnName;
        allColumns[i] = s;
        if (property1.primaryKey)
        {
            arraylist.add(s);
            break MISSING_BLOCK_LABEL_356;
        }
        arraylist1.add(s);
        property1 = property;
        break MISSING_BLOCK_LABEL_356;
        nonPkColumns = (String[])arraylist1.toArray(new String[arraylist1.size()]);
        pkColumns = (String[])arraylist.toArray(new String[arraylist.size()]);
        if (pkColumns.length != 1)
        {
            property = null;
        }
        pkProperty = property;
        statements = new TableStatements(sqlitedatabase, tablename, allColumns, pkColumns);
        if (pkProperty == null)
        {
            break MISSING_BLOCK_LABEL_338;
        }
        class2 = pkProperty.type;
        if (class2.equals(Long.TYPE) || class2.equals(java/lang/Long) || class2.equals(Integer.TYPE) || class2.equals(java/lang/Integer) || class2.equals(Short.TYPE) || class2.equals(java/lang/Short) || class2.equals(Byte.TYPE) || class2.equals(java/lang/Byte))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        keyIsNumeric = flag;
        return;
        keyIsNumeric = false;
        return;
        i++;
        property = property1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public DaoConfig(DaoConfig daoconfig)
    {
        db = daoconfig.db;
        tablename = daoconfig.tablename;
        properties = daoconfig.properties;
        allColumns = daoconfig.allColumns;
        pkColumns = daoconfig.pkColumns;
        nonPkColumns = daoconfig.nonPkColumns;
        pkProperty = daoconfig.pkProperty;
        statements = daoconfig.statements;
        keyIsNumeric = daoconfig.keyIsNumeric;
    }

    private static Property[] reflectProperties(Class class1)
    {
        Field afield[] = Class.forName((new StringBuilder()).append(class1.getName()).append("$Properties").toString()).getDeclaredFields();
        ArrayList arraylist = new ArrayList();
        int i = afield.length;
        for (int j = 0; j < i; j++)
        {
            Field field = afield[j];
            if ((9 & field.getModifiers()) != 9)
            {
                continue;
            }
            Object obj = field.get(null);
            if (obj instanceof Property)
            {
                arraylist.add((Property)obj);
            }
        }

        Property aproperty[] = new Property[arraylist.size()];
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext();)
        {
            Property property = (Property)iterator.next();
            if (aproperty[property.ordinal] != null)
            {
                throw new DaoException("Duplicate property ordinals");
            }
            aproperty[property.ordinal] = property;
        }

        return aproperty;
    }

    public DaoConfig clone()
    {
        return new DaoConfig(this);
    }

    public volatile Object clone()
    {
        return clone();
    }

    public IdentityScope getIdentityScope()
    {
        return identityScope;
    }

    public void initIdentityScope(IdentityScopeType identityscopetype)
    {
        if (identityscopetype == IdentityScopeType.None)
        {
            identityScope = null;
            return;
        }
        if (identityscopetype == IdentityScopeType.Session)
        {
            if (keyIsNumeric)
            {
                identityScope = new IdentityScopeLong();
                return;
            } else
            {
                identityScope = new IdentityScopeObject();
                return;
            }
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported type: ").append(identityscopetype).toString());
        }
    }

    public void setIdentityScope(IdentityScope identityscope)
    {
        identityScope = identityscope;
    }
}
