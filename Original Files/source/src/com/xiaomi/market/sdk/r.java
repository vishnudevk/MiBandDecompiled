// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class r extends SQLiteOpenHelper
{

    static final String a = "xiaomi_market_sdk_update.db";
    static final int b = 1;
    private static r c;
    private static final String d = "MarketSDKDatabaseHelper";

    private r(Context context)
    {
        super(context, "xiaomi_market_sdk_update.db", null, 1);
    }

    private void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE update_download (_id INTEGER PRIMARY KEY AUTOINCREMENT,package_name TEXT,download_id INTEGER, version_code INTEGER, apk_url TEXT, apk_hash TEXT, diff_url TEXT, diff_hash TEXT, apk_path TEXT, UNIQUE(package_name));");
    }

    public static r j(Context context)
    {
        if (c == null)
        {
            c = new r(context);
        }
        return c;
    }

    public long a(ContentValues contentvalues)
    {
        SQLiteStatement sqlitestatement = getWritableDatabase().compileStatement("INSERT OR REPLACE INTO update_download(package_name,download_id,version_code,apk_url,apk_hash,diff_url,diff_hash,apk_path) VALUES(?,?,?,?,?,?,?,?)");
        sqlitestatement.bindString(1, contentvalues.getAsString("package_name"));
        sqlitestatement.bindLong(2, contentvalues.getAsLong("download_id").longValue());
        sqlitestatement.bindLong(3, contentvalues.getAsInteger("version_code").intValue());
        sqlitestatement.bindString(4, contentvalues.getAsString("apk_url"));
        sqlitestatement.bindString(5, contentvalues.getAsString("apk_hash"));
        sqlitestatement.bindString(6, contentvalues.getAsString("diff_url"));
        sqlitestatement.bindString(7, contentvalues.getAsString("diff_hash"));
        sqlitestatement.bindString(8, contentvalues.getAsString("apk_path"));
        sqlitestatement.execute();
        return 1L;
    }

    public long a(String s, ContentValues contentvalues)
    {
        this;
        JVM INSTR monitorenter ;
        long l = getWritableDatabase().insert(s, null, contentvalues);
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        Log.d("MarketSDKDatabaseHelper", "create database");
        a(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int k)
    {
    }

    public Cursor query(String s, String as[], String s1, String as1[], String s2, String s3, String s4)
    {
        return getReadableDatabase().query(s, as, s1, as1, s2, s3, s4);
    }
}
