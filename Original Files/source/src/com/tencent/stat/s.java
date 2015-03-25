// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.tencent.stat:
//            t, StatStore

class s extends SQLiteOpenHelper
{

    private static String a = "tencent_analysis.db";
    private static int b = 3;

    public s(Context context)
    {
        super(context, a, null, b);
    }

    private void a(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor = sqlitedatabase.query("user", null, null, null, null, null, null);
        ContentValues contentvalues = new ContentValues();
        boolean flag = cursor.moveToNext();
        String s1 = null;
        if (flag)
        {
            s1 = cursor.getString(0);
            cursor.getInt(1);
            cursor.getString(2);
            cursor.getLong(3);
            contentvalues.put("uid", StatCommonHelper.encode(s1));
        }
        if (s1 != null)
        {
            sqlitedatabase.update("user", contentvalues, "uid=?", new String[] {
                s1
            });
        }
    }

    private void b(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor = sqlitedatabase.query("events", null, null, null, null, null, null);
        ArrayList arraylist = new ArrayList();
        for (; cursor.moveToNext(); arraylist.add(new t(cursor.getLong(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3)))) { }
        ContentValues contentvalues = new ContentValues();
        String as[];
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); sqlitedatabase.update("events", contentvalues, "event_id=?", as))
        {
            t t1 = (t)iterator.next();
            contentvalues.put("content", StatCommonHelper.encode(t1.b));
            as = new String[1];
            as[0] = Long.toString(t1.a);
        }

    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sqlitedatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sqlitedatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sqlitedatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        StatStore.b().debug((new StringBuilder()).append("upgrade DB from oldVersion ").append(i).append(" to newVersion ").append(j).toString());
        if (i == 1)
        {
            sqlitedatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            a(sqlitedatabase);
            b(sqlitedatabase);
        }
        if (i == 2)
        {
            a(sqlitedatabase);
            b(sqlitedatabase);
        }
    }

}
