// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class a extends SQLiteOpenHelper
{

    private static final String a = "create table %s(_id integer primary key autoincrement, type integer, event_id text, param text, time text, value text)";
    private String b;

    public a(Context context, String s, String s1, int i)
    {
        super(context, s, null, i);
        b = s1;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        Object aobj[] = new Object[1];
        aobj[0] = b;
        sqlitedatabase.execSQL(String.format("create table %s(_id integer primary key autoincrement, type integer, event_id text, param text, time text, value text)", aobj));
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }
}
