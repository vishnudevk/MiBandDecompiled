// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.daobracelet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// Referenced classes of package de.greenrobot.daobracelet:
//            DaoMaster

public abstract class ctory extends SQLiteOpenHelper
{

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        Log.i("greenDAO", "Creating tables for schema version 6");
        DaoMaster.createAllTables(sqlitedatabase, false);
    }

    public ctory(Context context, String s, android.database.sqlite.Factory factory)
    {
        super(context, s, factory, 6);
    }
}
