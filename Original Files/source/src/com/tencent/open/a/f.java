// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// Referenced classes of package com.tencent.open.a:
//            d

class f extends SQLiteOpenHelper
{

    final d a;

    public f(d d, Context context, String s, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, int i)
    {
        a = d;
        super(context, s, cursorfactory, i);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        try
        {
            Log.i("cgi_report_debug", "ReportDataModal onCreate sql1 = create table if not exists newdata(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,deviceinfo text,detail text)");
            sqlitedatabase.execSQL("create table if not exists newdata(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,deviceinfo text,detail text)");
            Log.i("cgi_report_debug", "ReportDataModal onCreate sql2 = create table if not exists olddata(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,deviceinfo text,detail text)");
            sqlitedatabase.execSQL("create table if not exists olddata(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,deviceinfo text,detail text)");
            return;
        }
        catch (Exception exception)
        {
            Log.e("cgi_report_debug", "ReportDataModal onCreate failed");
            exception.printStackTrace();
            return;
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        Log.i("cgi_report_debug", (new StringBuilder()).append("ReportDataModal onUpgrade oldVersion=").append(i).append("  newVersion=").append(j).append("").toString());
        if (i == j)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        sqlitedatabase.execSQL("drop table if exists newdata");
        sqlitedatabase.execSQL("drop table if exists olddata");
        onCreate(sqlitedatabase);
        Log.i("cgi_report_debug", "ReportDataModal onUpgrade success");
        return;
        Exception exception;
        exception;
        Log.e("cgi_report_debug", "ReportDataModal onUpgrade failed");
        return;
    }
}
