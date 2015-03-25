// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// Referenced classes of package com.xiaomi.miui.analyticstracker:
//            j, a

class i
    implements j
{

    public static final String a = "ANALYTICS.SQLITESTORE";
    private static final String b = "analytics";
    private static final String c = "insert into %s values(null, ?, ?, ?, ?, ?)";
    private static final String d = "select * from analytics ";
    private static final String e = "delete from analytics ";
    private static final int f = 2;
    private SQLiteOpenHelper g;

    i()
    {
    }

    public Cursor a(String s)
    {
        SQLiteOpenHelper sqliteopenhelper = g;
        Cursor cursor = null;
        if (sqliteopenhelper == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        String s1 = "select * from analytics ";
        if (s != null)
        {
            s1 = String.format("%s where %s", new Object[] {
                "select * from analytics ", s
            });
        }
        SQLiteDatabase sqlitedatabase;
        Cursor cursor1;
        try
        {
            sqlitedatabase = g.getReadableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            Object aobj[] = new Object[1];
            aobj[0] = g.getDatabaseName();
            Log.e("ANALYTICS.SQLITESTORE", String.format("can't read database:%s", aobj));
            return null;
        }
        cursor = null;
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        cursor1 = sqlitedatabase.rawQuery(s1, null);
        cursor = cursor1;
        return cursor;
    }

    public void a()
    {
        if (g != null)
        {
            g.close();
        }
    }

    public void a(Context context, String s)
    {
        g = new a(context, s, "analytics", 2);
    }

    public void a(Integer integer, String s, String s1, String s2, String s3)
    {
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = g.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            Object aobj[] = new Object[1];
            aobj[0] = g.getDatabaseName();
            Log.e("ANALYTICS.SQLITESTORE", String.format("database:%s is not writable!", aobj));
            return;
        }
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        sqlitedatabase.execSQL(String.format("insert into %s values(null, ?, ?, ?, ?, ?)", new Object[] {
            "analytics"
        }), new Object[] {
            integer, s, s1, s2, s3
        });
    }

    public void b(String s)
    {
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        String s1 = "delete from analytics ";
        if (s != null)
        {
            s1 = String.format("%s where %s", new Object[] {
                "delete from analytics ", s
            });
        }
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = g.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            Object aobj[] = new Object[1];
            aobj[0] = g.getDatabaseName();
            Log.e("ANALYTICS.SQLITESTORE", String.format("can't remove data from database:%s", aobj));
            return;
        }
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        sqlitedatabase.execSQL(s1);
    }
}
