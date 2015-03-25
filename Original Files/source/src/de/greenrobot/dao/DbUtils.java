// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package de.greenrobot.dao:
//            DaoLog

public class DbUtils
{

    public DbUtils()
    {
    }

    public static int copyAllBytes(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[4096];
        int i = 0;
        do
        {
            int j = inputstream.read(abyte0);
            if (j == -1)
            {
                return i;
            }
            outputstream.write(abyte0, 0, j);
            i += j;
        } while (true);
    }

    public static int executeSqlScript(Context context, SQLiteDatabase sqlitedatabase, String s)
    {
        return executeSqlScript(context, sqlitedatabase, s, true);
    }

    public static int executeSqlScript(Context context, SQLiteDatabase sqlitedatabase, String s, boolean flag)
    {
        String as[] = (new String(readAsset(context, s), "UTF-8")).split(";(\\s)*[\n\r]");
        int i;
        if (flag)
        {
            i = executeSqlStatementsInTx(sqlitedatabase, as);
        } else
        {
            i = executeSqlStatements(sqlitedatabase, as);
        }
        DaoLog.i((new StringBuilder()).append("Executed ").append(i).append(" statements from SQL script '").append(s).append("'").toString());
        return i;
    }

    public static int executeSqlStatements(SQLiteDatabase sqlitedatabase, String as[])
    {
        int i = 0;
        int j = as.length;
        for (int k = 0; k < j; k++)
        {
            String s = as[k].trim();
            if (s.length() > 0)
            {
                sqlitedatabase.execSQL(s);
                i++;
            }
        }

        return i;
    }

    public static int executeSqlStatementsInTx(SQLiteDatabase sqlitedatabase, String as[])
    {
        sqlitedatabase.beginTransaction();
        int i;
        i = executeSqlStatements(sqlitedatabase, as);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return i;
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
    }

    public static void logTableDump(SQLiteDatabase sqlitedatabase, String s)
    {
        Cursor cursor = sqlitedatabase.query(s, null, null, null, null, null, null);
        DaoLog.d(DatabaseUtils.dumpCursorToString(cursor));
        cursor.close();
        return;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    public static byte[] readAllBytes(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        copyAllBytes(inputstream, bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }

    public static byte[] readAsset(Context context, String s)
    {
        InputStream inputstream = context.getResources().getAssets().open(s);
        byte abyte0[] = readAllBytes(inputstream);
        inputstream.close();
        return abyte0;
        Exception exception;
        exception;
        inputstream.close();
        throw exception;
    }

    public static void vacuum(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("VACUUM");
    }
}
