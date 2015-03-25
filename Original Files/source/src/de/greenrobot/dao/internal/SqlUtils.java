// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.internal;

import de.greenrobot.dao.DaoException;

public class SqlUtils
{

    public SqlUtils()
    {
    }

    public static StringBuilder appendColumn(StringBuilder stringbuilder, String s)
    {
        stringbuilder.append('\'').append(s).append('\'');
        return stringbuilder;
    }

    public static StringBuilder appendColumn(StringBuilder stringbuilder, String s, String s1)
    {
        stringbuilder.append(s).append(".'").append(s1).append('\'');
        return stringbuilder;
    }

    public static StringBuilder appendColumns(StringBuilder stringbuilder, String s, String as[])
    {
        int i = as.length;
        for (int j = 0; j < i; j++)
        {
            appendColumn(stringbuilder, s, as[j]);
            if (j < i - 1)
            {
                stringbuilder.append(',');
            }
        }

        return stringbuilder;
    }

    public static StringBuilder appendColumns(StringBuilder stringbuilder, String as[])
    {
        int i = as.length;
        for (int j = 0; j < i; j++)
        {
            stringbuilder.append('\'').append(as[j]).append('\'');
            if (j < i - 1)
            {
                stringbuilder.append(',');
            }
        }

        return stringbuilder;
    }

    public static StringBuilder appendColumnsEqValue(StringBuilder stringbuilder, String s, String as[])
    {
        for (int i = 0; i < as.length; i++)
        {
            appendColumn(stringbuilder, s, as[i]).append("=?");
            if (i < -1 + as.length)
            {
                stringbuilder.append(',');
            }
        }

        return stringbuilder;
    }

    public static StringBuilder appendColumnsEqualPlaceholders(StringBuilder stringbuilder, String as[])
    {
        for (int i = 0; i < as.length; i++)
        {
            appendColumn(stringbuilder, as[i]).append("=?");
            if (i < -1 + as.length)
            {
                stringbuilder.append(',');
            }
        }

        return stringbuilder;
    }

    public static StringBuilder appendPlaceholders(StringBuilder stringbuilder, int i)
    {
        int j = 0;
        while (j < i) 
        {
            if (j < i - 1)
            {
                stringbuilder.append("?,");
            } else
            {
                stringbuilder.append('?');
            }
            j++;
        }
        return stringbuilder;
    }

    public static String createSqlDelete(String s, String as[])
    {
        StringBuilder stringbuilder = new StringBuilder("DELETE FROM ");
        stringbuilder.append(s);
        if (as != null && as.length > 0)
        {
            stringbuilder.append(" WHERE ");
            appendColumnsEqValue(stringbuilder, s, as);
        }
        return stringbuilder.toString();
    }

    public static String createSqlInsert(String s, String s1, String as[])
    {
        StringBuilder stringbuilder = new StringBuilder(s);
        stringbuilder.append(s1).append(" (");
        appendColumns(stringbuilder, as);
        stringbuilder.append(") VALUES (");
        appendPlaceholders(stringbuilder, as.length);
        stringbuilder.append(')');
        return stringbuilder.toString();
    }

    public static String createSqlSelect(String s, String s1, String as[])
    {
        StringBuilder stringbuilder = new StringBuilder("SELECT ");
        if (s1 == null || s1.length() < 0)
        {
            throw new DaoException("Table alias required");
        } else
        {
            appendColumns(stringbuilder, s1, as).append(" FROM ");
            stringbuilder.append(s).append(' ').append(s1).append(' ');
            return stringbuilder.toString();
        }
    }

    public static String createSqlSelectCountStar(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder("SELECT COUNT(*) FROM ");
        stringbuilder.append(s).append(' ');
        if (s1 != null)
        {
            stringbuilder.append(s1).append(' ');
        }
        return stringbuilder.toString();
    }

    public static String createSqlUpdate(String s, String as[], String as1[])
    {
        StringBuilder stringbuilder = new StringBuilder("UPDATE ");
        stringbuilder.append(s).append(" SET ");
        appendColumnsEqualPlaceholders(stringbuilder, as);
        stringbuilder.append(" WHERE ");
        appendColumnsEqValue(stringbuilder, s, as1);
        return stringbuilder.toString();
    }
}
